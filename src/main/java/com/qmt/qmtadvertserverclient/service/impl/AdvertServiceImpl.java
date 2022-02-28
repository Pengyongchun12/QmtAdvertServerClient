package com.qmt.qmtadvertserverclient.service.impl;

import com.qmt.qmtadvertserverclient.entity.AdvertBean;
import com.qmt.qmtadvertserverclient.mapper.AdvertMapper;
import com.qmt.qmtadvertserverclient.service.AdvertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告墙表 服务实现类
 * </p>
 *
 * @author 黔民通
 * @since 2022-02-23
 */
@Service
public class AdvertServiceImpl extends ServiceImpl<AdvertMapper, AdvertBean> implements AdvertService {


//    @Override
//    public List<AdvertBean> queryAdvertByPassword(Map<String,String> map) {
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//
//        AdvertMapper mapper = sqlSession.getMapper(AdvertMapper.class);
//        List<AdvertBean> advertBeans = mapper.queryAdvertByPassword(map);
//        sqlSession.close();
//        return advertBeans;
//    }
}
