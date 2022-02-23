package com.qmt.qmtadvertserverclient.mapper;

import com.qmt.qmtadvertserverclient.entity.UserBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Mapper
public interface UserMapper extends BaseMapper<UserBean> {

}
