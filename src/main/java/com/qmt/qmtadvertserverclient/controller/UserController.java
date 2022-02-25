package com.qmt.qmtadvertserverclient.controller;


import com.qmt.qmtadvertserverclient.service.UserService;
import com.qmt.qmtadvertserverclient.utils.json.JsonResult;
import com.qmt.qmtadvertserverclient.utils.json.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
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


    //访问: http:localhost:8085/api/user/select
    @RequestMapping("selectAll")
    public JsonResult selectAll(){
        return ResultUtil.successSate(userService.list());
    }





}
