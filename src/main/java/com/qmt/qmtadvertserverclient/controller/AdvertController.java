package com.qmt.qmtadvertserverclient.controller;


import com.qmt.qmtadvertserverclient.entity.AdvertBean;

import com.qmt.qmtadvertserverclient.service.AdvertService;


import com.qmt.qmtadvertserverclient.service.OssService;

import com.qmt.qmtadvertserverclient.utils.json.JsonResult;
import com.qmt.qmtadvertserverclient.utils.json.ResultCode;
import com.qmt.qmtadvertserverclient.utils.json.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * 广告墙表 前端控制器
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/advert-bean")
public class AdvertController {

    @Autowired
    AdvertService advertService;
    @Autowired
    OssService ossService;

//
//    @RequestMapping("/publishAdvert")
//    @SaCheckLogin
//    @SaCheckRole("")//商家角色
//    public JsonResult selectAdvert(@RequestBody AdvertBean advertBean){
//        int userId = (int) StpUtil.getLoginId();
//
//    }
//

    @RequestMapping(value = "/publishAdvert/{userId}/{content}/{address}/{day}", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public JsonResult uploadOSS(@PathVariable("userId") int userId, @PathVariable("content") String content,
                                @PathVariable("address") String address, @PathVariable("day") int day,
                                @RequestParam(value = "file") MultipartFile[] files) {
        String aPic = ossService.uploadToOss(files); // 获取商家发布广告的图片的相关url
        System.out.println("图片Url======"+aPic);
        //int aId = (int)((Math.random()*9+1)*1000);// 广告IDa
        boolean isSave = advertService.save(new AdvertBean(userId, content,address,day,aPic));
        return isSave ? ResultUtil.successSate(ResultCode.SUCCESS, "发布成功") : ResultUtil.successSate(ResultCode.SUCCESS_AND_FAIL, "发布失败");

    }
}
