package com.qmt.qmtadvertserverclient.service.impl;

import com.qmt.qmtadvertserverclient.entity.UserBean;
import com.qmt.qmtadvertserverclient.mapper.UserMapper;
import com.qmt.qmtadvertserverclient.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserBean> implements UserService {

}
