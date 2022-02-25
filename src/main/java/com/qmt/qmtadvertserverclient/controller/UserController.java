package com.qmt.qmtadvertserverclient.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmt.qmtadvertserverclient.entity.UserBean;
import com.qmt.qmtadvertserverclient.service.UserService;
import com.qmt.qmtadvertserverclient.utils.json.JsonResult;
import com.qmt.qmtadvertserverclient.utils.json.ResultCode;
import com.qmt.qmtadvertserverclient.utils.json.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;


    //访问: http:localhost:8085/api/user/selectAll
    @RequestMapping("selectAll")
    public JsonResult selectAll(){
        return ResultUtil.successSate(userService.list());
    }

    /**
     * 注册账户
     * 访问: http:localhost:8085/api/user/register/2/2/2/2/2/2/2/2/2/2
     */
    @RequestMapping("register/{uOpenid}/{uAccessToken}/{uNickname}/{uSex}/{uCountry}/{uProvince}/{uCity}/{uHeadimgurl}/{uUnionid}/{uTel}")
    public JsonResult register(@PathVariable(value = "uOpenid") String uOpenid, @PathVariable(value = "uAccessToken") String uAccessToken,
                               @PathVariable(value = "uNickname") String uNickname, @PathVariable(value = "uSex") String uSex,
                               @PathVariable(value = "uCountry") String uCountry, @PathVariable(value = "uProvince") String uProvince,
                               @PathVariable(value = "uCity") String uCity, @PathVariable(value = "uHeadimgurl") String uHeadimgurl,
                               @PathVariable(value = "uUnionid") String uUnionid, @PathVariable(value = "uTel") String uTel){
        //1.构造SQL条件
        QueryWrapper<UserBean> queryWrapper = new QueryWrapper<UserBean>().select("*").eq("u_tel",uTel);
        //2.判断此手机号是否注册
        UserBean userInfo =  userService.getOne(queryWrapper);
        //3.手机号已注册
        if (userInfo !=null && userInfo.getUTel().equals(uTel)){
            return ResultUtil.successSate(ResultCode.SUCCESS_AND_FAIL,"此手机号已被注册");
        }
        //4.构造注册信息
        UserBean userBean = new UserBean(uOpenid,uAccessToken,uNickname,uSex,uCountry,uProvince,uCity,uHeadimgurl,uUnionid,uTel);
        //5.开始注册同时添加数据库
        boolean registerState = userService.save(userBean);
        //6.判断注册结果
        return registerState ? ResultUtil.successSate(ResultCode.SUCCESS,"注册成功") : ResultUtil.successSate(ResultCode.SUCCESS_AND_FAIL,"注册失败");
    }
}
