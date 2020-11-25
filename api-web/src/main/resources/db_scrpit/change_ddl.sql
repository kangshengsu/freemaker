CREATE TABLE `education_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `freelancer_id` bigint(20) NOT NULL COMMENT '自由职业者编码',
  `start_time` datetime NOT NULL COMMENT '入学时间',
  `stop_time` datetime NOT NULL COMMENT '毕业时间',
  `school_name` varchar(128) NOT NULL COMMENT '学校名称',
  `degree` varchar(32) DEFAULT NULL COMMENT '学位',
  `speciality` varchar(32) NOT NULL COMMENT '专业',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE 
  KEY `idx_education_freelancer_id` (`freelancer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='学历信息表';

CREATE TABLE `work_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `freelancer_id` bigint(20) NOT NULL COMMENT '自由职业者编码',
  `start_time` datetime NOT NULL COMMENT '入职时间',
  `stop_time` datetime NOT NULL COMMENT '离职时间',
  `company_name` varchar(128) NOT NULL COMMENT '公司名称',
  `department` varchar(32) DEFAULT NULL COMMENT '部门',
  `position` varchar(32) DEFAULT NULL COMMENT '职位',
	`job_content` varchar(1024) DEFAULT NULL COMMENT '工作内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE
  KEY `idx_education_freelancer_id` (`freelancer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='工作信息表';

CREATE TABLE `partner_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `freelancer_id` bigint(20) NOT NULL COMMENT '自由职业者编码',
	`referrer_id` bigint(20) DEFAULT NULL COMMENT '推荐人编码',
	`belong_id` bigint(20) DEFAULT NULL COMMENT '所属合伙人编码',
  `distribution_id` bigint(20) DEFAULT NULL COMMENT '分配人编码',
  `settlement_id` bigint(20) DEFAULT NULL COMMENT '结算人编码',
  `settlement_status` tinyint(4) DEFAULT '0' COMMENT '是否结算（0-否，1-是）',
  `distribution_status` tinyint(4) DEFAULT '0' COMMENT '是否分配合伙人（0-否，1-是）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE
  KEY `idx_education_freelancer_id` (`freelancer_id`),
	KEY `idx_education_referrer_id` (`referrer_id`),
	KEY `idx_education_belong_id` (`belong_id`),
	KEY `idx_education_distribution_id` (`distribution_id`),
	KEY `idx_education_settlement_id` (`settlement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='合伙人信息表';

ALTER TABLE production_review_info MODIFY production_id BIGINT(20) DEFAULT NULL COMMENT '作品编码';
ALTER TABLE production_review_info ADD COLUMN modify_content varchar(2000) DEFAULT NULL COMMENT '修改内容' AFTER production_id;
ALTER TABLE production_review_info ADD COLUMN freelancer_id BIGINT(20) DEFAULT NULL COMMENT '自由职业者编码' AFTER production_id;

INSERT INTO leaf_alloc set biz_tag='education_info',max_id=2000,step=2000;
INSERT INTO leaf_alloc set biz_tag='work_info',max_id=2000,step=2000;
INSERT INTO leaf_alloc set biz_tag='partner_info',max_id=2000,step=2000;

