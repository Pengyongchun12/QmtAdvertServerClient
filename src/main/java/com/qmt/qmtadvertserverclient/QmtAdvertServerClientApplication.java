package com.qmt.qmtadvertserverclient;

import cn.dev33.satoken.SaManager;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.qmt.qmtadvertserverclient.mapper")
public class QmtAdvertServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(QmtAdvertServerClientApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

    /**
     * 配置fastjson方式二：启动测试类中注入Bean: HttpMessageConverters
     * 具体做法:不需要继承WebMvcConfigurerAdapter
     * map集合、list集合、单个对象，三者有null，均不格式为——""，直接省略
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //创建会话消息实例容器
        FastJsonHttpMessageConverter httpMessageConverter = new FastJsonHttpMessageConverter();
        //创建fastJson配置实例
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                //全局修改日期格式,如果时间是data、时间戳类型，按照这种格式初始化时间 "yyyy-MM-dd HH:mm:ss"
                SerializerFeature.WriteDateUseDateFormat,
                // 保留 Map 空的字段
                SerializerFeature.WriteMapNullValue,
                // 将 String 类型的 null 转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将 Number 类型的 null 转成 0
                SerializerFeature.WriteNullNumberAsZero,
                // 将 List 类型的 null 转成 []
                SerializerFeature.WriteNullListAsEmpty,
                // 将 Boolean 类型的 null 转成 false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect,
                //返回Json数据排版格式
                SerializerFeature.PrettyFormat);
        //按字段名称排序后输出-SerializerFeature.SortField
        //设置配置实例
        httpMessageConverter.setFastJsonConfig(config);
        //设置默认编码方式
        httpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        //集合填入媒介类型
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在 Controller 上的 @RequestMapping 中加了个属性 produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
        //设置支持媒介——装载了解决中文乱码参数
        httpMessageConverter.setSupportedMediaTypes(mediaTypeList);
        return new HttpMessageConverters(httpMessageConverter);
    }

}
