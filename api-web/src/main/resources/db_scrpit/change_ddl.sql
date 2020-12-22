
-- 首页配置表加入推荐位权重字段
ALTER TABLE `display_config`
ADD COLUMN recommend_weight BIGINT NOT NULL DEFAULT 0 COMMENT '推荐位权重' AFTER display_type

-- 添加作品权重字段
ALTER TABLE `production_info`
ADD COLUMN production_weight BIGINT NOT NULL DEFAULT 0 COMMENT '作品权重' AFTER delivery_type

-- 新建收藏表
CREATE TABLE `collect_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `collect` BIGINT(20) NOT NULL COMMENT '收藏信息id(作品 需求)',
  `collect_type` TINYINT(4) DEFAULT NULL COMMENT '收藏类型(10-作品,20-需求)',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` BIGINT(20) NOT NULL COMMENT '创建人',
  `update_user` BIGINT(20) NOT NULL COMMENT '修改人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `IDX_FREELANCER_id` (`user_id`)
) ENGINE=INNODB AUTO_INCREMENT=112047 DEFAULT CHARSET=utf8 COMMENT='作品需求收藏表';


-- 主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('collect_info',2000,2000);

-- 添加收藏状态列
ALTER TABLE `collect_info`
ADD COLUMN `status` TINYINT(4) DEFAULT 10 COMMENT '收藏状态(10-收藏  20-取消)' AFTER collect_type;
