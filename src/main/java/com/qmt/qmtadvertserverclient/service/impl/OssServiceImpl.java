package com.qmt.qmtadvertserverclient.service.impl;

import com.qmt.qmtadvertserverclient.base.config.OSSConfig;
import com.qmt.qmtadvertserverclient.service.OssService;
import com.qmt.qmtadvertserverclient.utils.file.OSSBootUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OssServiceImpl implements OssService {


    @Autowired
    private OSSConfig ossConfig;
    @Override
    public String uploadToOss(MultipartFile[] files) {

        String ossFileUrlBoot = "";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        int length = 0;
        for (MultipartFile file:files) {
            length++;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            ossFileUrlBoot = ossFileUrlBoot+ OSSBootUtil.upload(ossConfig, file, "jpc/" + format); //字符串拼接
            if(length < files.length){
                ossFileUrlBoot +=";";
            }
        }
        return ossFileUrlBoot;
    }
}
