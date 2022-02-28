package com.qmt.qmtadvertserverclient.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 广告墙表 前端控制器
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/api/advert/")
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

    //访问 http://localhost:8085/api/advert/uploadOSS/8/内容/地址/10 (Body选择file图片)
    @RequestMapping(value = "uploadOSS/{userId}/{content}/{address}/{day}", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public JsonResult uploadOSS(@RequestParam(value = "file") MultipartFile[] files, @PathVariable("userId") int userId,
                                @PathVariable("content") String content, @PathVariable("address") String address, @PathVariable("day") int day) {
        String aPic = ossService.uploadToOss(files); // 获取商家发布广告的图片的相关url
        System.out.println("图片Url======" + aPic);
        //int aId = (int)((Math.random()*9+1)*1000);// 广告IDa
        boolean isSave = advertService.save(new AdvertBean(userId, content, address, day, aPic));
        return isSave ? ResultUtil.successSate(ResultCode.SUCCESS, "发布成功") : ResultUtil.successSate(ResultCode.SUCCESS_AND_FAIL, "发布失败");

    }


    //根据地址或者关键词得到广告数据
    @RequestMapping(value = "queryAdverts",method = RequestMethod.GET)
    public JsonResult queryAdverts(@RequestParam("aAddress") String aAddress, @RequestParam("password") String password){

        QueryWrapper<AdvertBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(aAddress), "a_address", aAddress);
        queryWrapper.like(StringUtils.isNotBlank(password), "a_content", password);
        List<Map<String, Object>> maps = advertService.listMaps(queryWrapper);

        return ResultUtil.successSate(ResultCode.SUCCESS,maps);

    }
}
