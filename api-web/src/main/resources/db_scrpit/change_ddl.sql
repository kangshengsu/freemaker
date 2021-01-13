
-- 需求表添加是否已下单列
ALTER TABLE `demand_info` ADD COLUMN is_order TINYINT DEFAULT 20 COMMENT '是否已下单(10-已下单 20-未下单)' AFTER  attestation

-- 新增需求备注表
CREATE TABLE `demand_remark_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `demand_id` BIGINT(20) DEFAULT NULL COMMENT '需求主键',
  `remark_info` VARCHAR(255) DEFAULT '' NOT NULL COMMENT '备注信息',
  `next_time` DATETIME  COMMENT '下次联系时间',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` BIGINT(20) NOT NULL COMMENT '创建人',
  `update_user` BIGINT(20) NOT NULL COMMENT '修改人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_demand_production_demand_id` (`demand_id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='需求备注表';

-- 需求备注表主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('demand_remark_info',1,50);