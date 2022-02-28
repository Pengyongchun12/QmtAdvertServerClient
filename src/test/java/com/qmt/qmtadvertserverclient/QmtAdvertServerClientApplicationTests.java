package com.qmt.qmtadvertserverclient;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qmt.qmtadvertserverclient.entity.AdvertBean;
import com.qmt.qmtadvertserverclient.service.AdvertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class QmtAdvertServerClientApplicationTests {


    @Autowired
    AdvertService advertService;
    @Test
    void contextLoads() {

    }
    @Test
    void queryAdvertByPassword(){
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        Map<String,String> map =new HashMap<>();
//        map.put("aContent","%被子%");
//        map.put("aAdress","%乌当区%");
//        AdvertMapper mapper = sqlSession.getMapper(AdvertMapper.class);
//
//        //List<AdvertBean> advertBeans = mapper.queryAdvertByPassword(map);
//        for (AdvertBean advertBean : advertBeans) {
//            System.out.println(advertBean);
//        }
//
//        sqlSession.close();

        String Address = "乌当区";
        String Password = "被子";

        QueryWrapper<AdvertBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(Address), "a_address", Address);
        queryWrapper.like(StringUtils.isNotBlank(Password), "a_content", Password);

        Map<String, Object> map = advertService.getMap(queryWrapper);
        System.out.println(map);

    }

}
