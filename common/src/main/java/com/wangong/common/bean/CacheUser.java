package com.wangong.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangong.common.domain.position.Position;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 缓存用户信息
 */
@Data
@Builder
public class CacheUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;

    private String realName;

    private Integer state;

    private String username;

    private String positionId;

    private Position position;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ctime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date utime;

    private String telphone;

    private String token;
}

