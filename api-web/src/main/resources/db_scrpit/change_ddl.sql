-- 创建类目信息表
CREATE TABLE `bd_job_cate_detail` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `job_cate_id` BIGINT(20) NOT NULL COMMENT '类目主键',
  `cate_name_abb` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '类目简称',
  `description` VARCHAR(50) DEFAULT '' COMMENT '类目描述',
  `cate_type` TINYINT(4) NOT NULL COMMENT '类目类型（10-一级 20-二级）',
  `is_home_show` TINYINT(4) NOT NULL DEFAULT 20 COMMENT '首页展示（一级使用 10-展示 20不展示）',
  `home_show_order` TINYINT(4)  DEFAULT 0 COMMENT '首页展示顺序',
  `category_show` TINYINT(4) NOT NULL DEFAULT 20 COMMENT '类目页展示（都使用 10-展示 20-不展示）',
  `category_show_order` TINYINT(4)NOT NULL DEFAULT 0 COMMENT '类目页展示顺序',
  `serve_price` DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '服务均价（二级使用）',
  `serve_company` BIGINT(20) COMMENT '服务企业数',
  `serve_freelancer` BIGINT(20) COMMENT '服务人才数',
  `is_new` TINYINT(4) NOT NULL DEFAULT 20 COMMENT '是否上新(二级使用 10-上新 20-不上新)',
  `is_hot` TINYINT(4) NOT NULL DEFAULT 20 COMMENT '是否火热(二级使用 10-火热 20-不火热)',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` BIGINT(20) NOT NULL COMMENT '创建人',
  `update_user` BIGINT(20) NOT NULL COMMENT '修改人',
  `is_delete` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=68002 DEFAULT CHARSET=utf8 COMMENT='类目信息表';

-- id分布式自增表添加
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES('bd_job_cate_detail',1000,50)

-- 修改bd_job_cate表treeCode与parentCode列为不为非空