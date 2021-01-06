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

-- 创建轮播信息表
CREATE TABLE `rotation_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `name` varchar(128) NOT NULL COMMENT '模版名称',
  `role` varchar(128) NOT NULL COMMENT '角色',
  `content` varchar(128) NOT NULL COMMENT '内容',
	`money` varchar(128) NOT NULL COMMENT '金额',
  `type` tinyint(4) NOT NULL COMMENT '类型（10-需求/服务，20-支付，30-评价）',
  `status` tinyint(4) NOT NULL COMMENT '状态（10-启用，20-停用）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='轮播信息表';

-- 新增是否推荐列
ALTER TABLE `select_info`
ADD COLUMN is_recommend TINYINT(4) DEFAULT 20 COMMENT '是否上推荐' AFTER keyword;

-- 主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('advert_info',2000,10);
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('rotation_info',2000,10);

-- 新增订单表流水号列
ALTER TABLE `order_info`
ADD COLUMN serial_number VARCHAR(255) DEFAULT '' COMMENT '流水号' AFTER CODE

-- 新增服务费配置表
CREATE TABLE `service_charge` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `freelancer_service_charge` TINYINT(4) DEFAULT 10 NOT NULL COMMENT '人才服务费（按百分比）',
  `company_service_charge` TINYINT(4) DEFAULT 10 NOT NULL COMMENT '企业服务费（按百分比）',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` BIGINT(20) NOT NULL COMMENT '创建人',
  `update_user` BIGINT(20) NOT NULL COMMENT '修改人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='服务费配置表';

-- 服务费配置表主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('service_charge',2000,10);

-- 记录订单实际交易金额以及收费标准
CREATE TABLE `order_amount` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` BIGINT(20)NOT NULL COMMENT '订单主键',
  `freelancer_service_charge` TINYINT(4) DEFAULT 10 NOT NULL COMMENT '人才服务费标准（按百分比）',
  `employer_service_charge` TINYINT(4) DEFAULT 10 NOT NULL COMMENT '企业服务费标准（按百分比）',
  `freelancer_act_service_charge` DECIMAL(20,8) DEFAULT 0.00000000 NOT NULL COMMENT '实际收取人才手续费',
  `employer_act_service_charge` DECIMAL(20,8) DEFAULT 0.0000000 NOT NULL COMMENT '实际收取雇主手续费',
  `freelancer_act_get_mny` DECIMAL(20,8) DEFAULT 0.00000000 NOT NULL COMMENT '人才实际到手金额',
  `employer_act_pay_mny` DECIMAL(20,8) DEFAULT 0.00000000 NOT NULL COMMENT '雇主实际支付金额',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` BIGINT(20) NOT NULL COMMENT '创建人',
  `update_user` BIGINT(20) NOT NULL COMMENT '修改人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='记录订单实际交易金额以及收费标准表';

-- 服务费配置表主键分布式自增
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('order_amount',1,1000);