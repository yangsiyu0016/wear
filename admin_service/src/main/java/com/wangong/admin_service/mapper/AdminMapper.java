package com.wangong.admin_service.mapper;

import com.wangong.common.domain.admin.Admin;
import com.wangong.common.domain.admin.AdminQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户持久层
 */
@Mapper
public interface AdminMapper {

    /**
     * 分页获取所有数据
     * @param start
     * @param size
     * @return
     */
    List<Admin> getAll(@Param("start") Integer start, @Param("size") Integer size);

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
    Admin getAdminById(@Param("id") String id);

    /**
     * 根据后台用户查询参数获取后台用户
     * @param username
     * @return
     */
    Admin getAdminByUsername(@Param("username") String username);

    /**
     * 添加用户
     * @param admin
     */
    void addAdmin(@Param("admin") Admin admin);

    /**
     * 更新用户信息
     * @param admin
     */
    void editAdmin(@Param("admin") Admin admin);

    /**
     * 修改密码
     * @param password
     * @param username
     */
    void editPassword(@Param("password") String password, @Param("username") String username);

    /**
     * 用户是否启用
     * @param isenable
     * @param id
     */
    void editEnable(@Param("isenable") Boolean isenable, @Param("id") String id);

    /**
     * 根据id删除后台用户
     * @param id
     */
    void deleteAdminById(@Param("id") String id);
}
