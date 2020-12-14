package com.wangong.common.domain.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangong.common.domain.position.Position;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户实体类
 */
@Data
public class Admin implements Serializable {

    String id;
    String username;//用户名
    String phone;//登录手机号
    String email;//邮箱
    String password;//登录密码
    String salt;//盐
    String realName;//真实姓名
    String positionId;//职位id
    Position position;//职位
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date ctime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date utime;//更新时间
    String telphone;//联系电话
    Boolean isenable;//是否启用
}
