package com.qmt.qmtadvertserverclient.service;

import com.qmt.qmtadvertserverclient.entity.AdvertBean;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 广告墙表 服务类
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
public interface AdvertService extends IService<AdvertBean> {


    //List<AdvertBean> queryAdvertByPassword(Map<String,String> map);
}
