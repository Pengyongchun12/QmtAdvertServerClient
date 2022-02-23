package com.qmt.qmtadvertserverclient.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_user")
public class UserBean extends Model<UserBean> {

    /**
     * 用户id
     */
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    /**
     * openid
     */
    @TableField("u_openid")
    private String uOpenid;

    /**
     * access_token
     */
    @TableField("u_access_token")
    private String uAccessToken;

    /**
     * 昵称
     */
    @TableField("u_nickname")
    private String uNickname;

    /**
     * 性别
     */
    @TableField("u_sex")
    private String uSex;

    /**
     * 国家
     */
    @TableField("u_country")
    private String uCountry;

    /**
     * 省份
     */
    @TableField("u_province")
    private String uProvince;

    /**
     * 城市
     */
    @TableField("u_city")
    private String uCity;

    /**
     * 头像URL
     */
    @TableField("u_headimgurl")
    private String uHeadimgurl;

    /**
     * unionid
     */
    @TableField("u_unionid")
    private String uUnionid;

    /**
     * 手机号
     */
    @TableField("u_tel")
    private String uTel;

    /**
     * token
     */
    @TableField("u_token")
    private String uToken;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @Override
    public Serializable pkVal() {
        return this.uId;
    }

    /**
     * Mybatis 必须提供无参构造方法，用于Mybatis容器内部查询参数(反射机制)
     */
    public UserBean() {

    }

    /**
     * 注册账户
     */
    public UserBean(String uOpenid, String uAccessToken, String uNickname, String uSex, String uCountry, String uProvince, String uCity, String uHeadimgurl, String uUnionid, String uTel) {
        this.uOpenid = uOpenid;
        this.uAccessToken = uAccessToken;
        this.uNickname = uNickname;
        this.uSex = uSex;
        this.uCountry = uCountry;
        this.uProvince = uProvince;
        this.uCity = uCity;
        this.uHeadimgurl = uHeadimgurl;
        this.uUnionid = uUnionid;
        this.uTel = uTel;
    }
}
