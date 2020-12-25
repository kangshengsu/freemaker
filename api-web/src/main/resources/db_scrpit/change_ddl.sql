-- 创建广告位信息表
CREATE TABLE `advert_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `name` varchar(128) NOT NULL COMMENT '名称',
  `channel` varchar(128) DEFAULT NULL COMMENT '渠道',
  `scene` varchar(128) DEFAULT NULL COMMENT '应用场景',
  `role` varchar(128) DEFAULT NULL COMMENT '可见角色',
  `status` tinyint(4) NOT NULL COMMENT '状态（10-启用，20-停用）',
  `up_time` datetime DEFAULT NULL COMMENT '上线时间',
  `down_time` datetime DEFAULT NULL COMMENT '下线时间',
	`path` varchar(255) NOT NULL COMMENT '图片地址',
	`other_path` varchar(255) NOT NULL COMMENT '图片地址',
	`url` varchar(255) NOT NULL COMMENT '链接地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='广告位信息表';

-- 新增是否推荐列
ALTER TABLE `select_info`
ADD COLUMN is_recommend TINYINT(4) DEFAULT 20 COMMENT '是否上推荐' AFTER keyword
-- 主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('advert_info',2000,10);