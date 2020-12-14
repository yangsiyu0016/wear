package com.wangong.admin_web.config;

import com.wangong.common.domain.admin.Admin;
import com.wangong.common.domain.menu.Menu;
import com.wangong.common.domain.position.Position;
import com.wangong.common.service.AdminService;
import com.wangong.common.service.MenuService;
import com.wangong.common.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;

    @Resource
    private MenuService menuService;

    @Resource
    private PositionService positionService;

    /**
     * description: 授权
     *
     * @return 权限信息，包括角色以及权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.warn("开始执行授权操作.......");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        Admin admin = (Admin) principals.getPrimaryPrincipal();
        Position position = positionService.getPositionById(admin.getPositionId());
        authorizationInfo.addRole(position.getName());

        List<Menu> menus = menuService.getTreeMenu(position.getId());
        for (Menu menu: menus) {
            authorizationInfo.addStringPermission(menu.getTitle());
        }
        return authorizationInfo;
    }

    /**
     * description: 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     *
     * @return 身份验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.warn("开始进行身份认证......");
        //获取用户的输入的账号.
        String userName = (String) token.getPrincipal();

        //通过username从数据库中查找 User对象.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        Admin admin = adminService.getAdminByUsername(userName);
        if (Objects.isNull(admin)) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                userName,
                admin.getPassword(),
                ByteSource.Util.bytes(admin.getSalt()),
                getName()
        );

    }

}
