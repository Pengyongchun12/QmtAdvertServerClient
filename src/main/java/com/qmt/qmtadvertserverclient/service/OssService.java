package com.qmt.qmtadvertserverclient.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface OssService {
   String uploadToOss(MultipartFile[] files);
}
