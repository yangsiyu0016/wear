package com.wangong.common.service;

import com.wangong.common.bean.CacheUser;
import com.wangong.common.domain.admin.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    CacheUser login(String username, String password);

    /**
     * 登出
     */
    void logout();

    /**
     * 分页获取所有数据
     * @param page
     * @param size
     * @return
     */
    List<Admin> getAll(Integer page, Integer size);

    /**
     * 获取总条数
     * @return
     */
    Long getCount();

    /**
     * 根据id获取后台用户
     * @param id
     * @return
     */
    Admin getAdminById(String id);

    /**
     * 根据后台用户查询参数获取后台用户
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);

    /**
     * 添加用户
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 更新用户信息
     * @param admin
     */
    void editAdmin(Admin admin);

    /**
     * 修改密码
     * @param password
     * @param username
     */
    void editPassword(String password, String username);

    /**
     * 用户是否启用
     * @param isenable
     * @param id
     */
    void editEnable(Boolean isenable, String id);

    /**
     * 根据id删除后台用户
     * @param id
     */
    void deleteAdminById(String id);

}
