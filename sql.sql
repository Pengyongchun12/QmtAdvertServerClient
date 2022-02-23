CREATE TABLE `t_user`  (
  `u_id` int NOT NULL AUTO_INCREMENT COMMENT '登录id',
	 u_openid varchar(255) COMMENT 'openid',
	 u_access_token varchar(255) COMMENT 'access_token',
	 u_nickname varchar(255) COMMENT '昵称',
	 u_sex char(1) COMMENT '性别',
	 u_country varchar(255) COMMENT '国家',
	 u_province varchar(255) COMMENT '省份',
	 u_city varchar(255) COMMENT '城市',
	 u_headimgurl varchar(255) COMMENT '头像URL',
	 u_unionid varchar(255) COMMENT 'unionid',
  `u_tel` char(11) NOT NULL COMMENT '手机号',
  `u_token` char(64) NOT NULL COMMENT 'token',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

CREATE TABLE `t_advert`  (
  `a_id` int NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `a_uid` int NOT NULL COMMENT '用户id',
  `a_content` varchar(255) NOT NULL COMMENT '发布内容',
  `a_address` varchar(255) NOT NULL COMMENT '发布地址',
	`a_day` int NOT NULL COMMENT '有效天数',
	`a_pic` varchar(10000) NOT NULL COMMENT '图片URL',
  `create_time` datetime NOT NULL COMMENT '发布时间',
  `update_time` datetime COMMENT '更新时间',
	PRIMARY KEY (`a_id`) USING BTREE,
	CONSTRAINT `FK_user_advert` FOREIGN KEY (`a_uid`) REFERENCES `t_user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告墙表' ROW_FORMAT = DYNAMIC;