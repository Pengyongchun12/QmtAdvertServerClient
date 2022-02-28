package com.qmt.qmtadvertserverclient.mapper;

import com.qmt.qmtadvertserverclient.entity.AdvertBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 广告墙表 Mapper 接口
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Mapper
public interface AdvertMapper extends BaseMapper<AdvertBean> {

    //List<AdvertBean> queryAdvertByPassword(Map<String,String> map);

}
