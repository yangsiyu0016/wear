package com.wangong.admin_web.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.wangong.admin_web.bean.Response;
import com.wangong.common.bean.CacheUser;
import com.wangong.common.domain.admin.Admin;
import com.wangong.common.exception.LoginException;
import com.wangong.common.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {

    @Resource
    private AdminService adminService;

    @Resource
    private Response response;

    /**
     * 登录
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Response login(@RequestBody Admin admin){
        log.warn("进入登录.....");
        String username = admin.getUsername();
        String password = admin.getPassword();

        if (StringUtils.isBlank(username)) {
            return response.failure("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return response.failure("密码为空！");
        }

        //CacheUser cacheUser = adminService.login(username, password);

        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        CacheUser cacheUser;

        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(usernamePasswordToken);
            // 构建缓存用户信息返回给前端
            //Admin admin1 = (Admin) currentUser.getPrincipals().getPrimaryPrincipal();
            username = (String)currentUser.getPrincipals().getPrimaryPrincipal();
            Admin admin1 = adminService.getAdminByUsername(username);

            cacheUser = CacheUser.builder()
                    .token(currentUser.getSession().getId().toString())
                    .build();
            //BeanUtils.copyProperties(primaryPrincipal, cacheUser);
            cacheUser.setUsername(username);
            cacheUser.setCtime(admin1.getCtime());
            cacheUser.setEmail(admin1.getEmail());
            cacheUser.setPosition(admin1.getPosition());
            cacheUser.setPositionId(admin1.getPositionId());
            cacheUser.setRealName(admin1.getRealName());
            cacheUser.setTelphone(admin1.getTelphone());
            cacheUser.setUtime(admin1.getUtime());
            log.warn("CacheUser is {}", cacheUser.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new LoginException("账号不存在!", e);
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new LoginException("密码不正确!", e);
        } catch (AuthenticationException e) {
            log.error("身份验证异常:", e);
            throw new LoginException("用户验证失败!", e);
        }

        return response.success("登录成功", cacheUser);
    }

    /**
     * 注册
     * @param admin
     * @return
     */
    @PostMapping("/register")
    public Response register(@RequestBody Admin admin) {
        System.out.println("-----进入注册");
        String username = admin.getUsername();
        String password = admin.getPassword();

        Admin adminByUsername = adminService.getAdminByUsername(username);
        if (!Objects.isNull(adminByUsername)){
            return response.failure("用户名已存在！");
        }
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();

        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        admin.setSalt(salt);
        admin.setPassword(encodedPassword);
        admin.setCtime(new Date());
        adminService.addAdmin(admin);
        return response.success("注册成功");
    }

    /**
     * description: 登出
     */
    @RequestMapping("/logout")
    public Response logOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return response.success("登出成功！");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping("/un_auth")
    public Response unAuth() {
        return response.failure(HttpStatus.UNAUTHORIZED, "用户未登录！", null);
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping("/unauthorized")
    public Response unauthorized() {
        return response.failure(HttpStatus.FORBIDDEN, "用户无权限！", null);
    }

}
