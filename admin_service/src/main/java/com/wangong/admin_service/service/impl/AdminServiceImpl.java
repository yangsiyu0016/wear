package com.wangong.admin_service.service.impl;


import com.wangong.admin_service.mapper.AdminMapper;
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
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 后台用户逻辑层
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public CacheUser login(String username, String password) {
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
            Admin admin = (Admin) currentUser.getPrincipals().getPrimaryPrincipal();
            cacheUser = CacheUser.builder()
                    .token(currentUser.getSession().getId().toString())
                    .build();
            BeanUtils.copyProperties(admin, cacheUser);
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
        return cacheUser;
    }

    @Override
    public void logout() {

    }

    /**
     * 分页获取所有数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Admin> getAll(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Admin> admins = adminMapper.getAll(start, size);
        return admins;
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount() {
        return adminMapper.getCount();
    }

    /**
     * 根据id获取后台用户
     * @param id
     * @return
     */
    @Override
    public Admin getAdminById(String id) {
        return adminMapper.getAdminById(id);
    }

    /**
     * 根据后台用户查询参数获取后台用户
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.getAdminByUsername(username);
    }

    /**
     * 添加用户
     * @param admin
     */
    @Override
    public void addAdmin(Admin admin) {
        admin.setCtime(new Date());
        admin.setIsenable(false);
        admin.setId(UUID.randomUUID().toString());
        adminMapper.addAdmin(admin);
    }

    /**
     * 更新用户信息
     * @param admin
     */
    @Override
    public void editAdmin(Admin admin) {
        adminMapper.editAdmin(admin);
    }

    /**
     * 修改密码
     * @param password
     * @param username
     */
    @Override
    public void editPassword(String password, String username) {

    }

    /**
     * 用户是否启用
     * @param isenable
     * @param id
     */
    @Override
    public void editEnable(Boolean isenable, String id) {
        adminMapper.editEnable(isenable, id);
    }

    /**
     * 根据id删除后台用户
     * @param id
     */
    @Override
    public void deleteAdminById(String id) {
        adminMapper.deleteAdminById(id);
    }
}
