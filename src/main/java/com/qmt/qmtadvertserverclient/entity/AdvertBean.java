package com.qmt.qmtadvertserverclient.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 广告墙表
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Data
@Accessors(chain = true)
@TableName("t_advert")
public class AdvertBean extends Model<AdvertBean> {

    /**
     * 广告id
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    /**
     * 用户id
     */
    @TableField("a_uid")
    private Integer aUid;

    /**
     * 发布内容
     */
    @TableField("a_content")
    private String aContent;

    /**
     * 发布地址
     */
    @TableField("a_address")
    private String aAddress;

    /**
     * 有效天数
     */
    @TableField("a_day")
    private Integer aDay;

    /**
     * 图片URL
     */
    @TableField("a_pic")
    private String aPic;

    /**
     * 发布时间
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
        return this.aId;
    }


    public AdvertBean(Integer aUid, String aContent, String aAddress, Integer aDay, String aPic) {
        this.aUid = aUid;
        this.aContent = aContent;
        this.aAddress = aAddress;
        this.aDay = aDay;
        this.aPic = aPic;
    }
}
