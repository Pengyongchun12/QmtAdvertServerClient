package com.qmt.qmtadvertserverclient.base.config;

import java.io.Serializable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class OSSConfig implements Serializable {

    private static final long serialVersionUID = -119396871324982279L;

    /**
     * 阿里云 oss 站点
     */
    @Value("${oss.endpoint}")
    private String endpoint;

    /**
     * 阿里云 oss 资源访问 url
     */
    @Value("${oss.url}")
    private String url;

    /**
     * 阿里云 oss 公钥
     */
    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    /**
     * 阿里云 oss 私钥
     */
    @Value(value = "${oss.accessKeySecret}")
    private String accessKeySecret;

    /**
     * 阿里云 oss 文件根目录
     */
    @Value("${oss.bucketName}")
    private String bucketName;
}
