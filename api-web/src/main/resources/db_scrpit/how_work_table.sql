/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.18-txsql-log : Database - how_work
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`how_work` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `how_work`;

/*Table structure for table `attachment_info` */

DROP TABLE IF EXISTS `attachment_info`;

CREATE TABLE `attachment_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `business_type` tinyint(4) NOT NULL COMMENT '附件所属业务类型（10-需求,20-作品,30-订单）',
  `business_code` varchar(32) NOT NULL DEFAULT '' COMMENT '附件所属业务编码',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '附件类型（1-图片,2-视频）',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '附件名称',
  `path` varchar(255) NOT NULL DEFAULT '存放路径',
  `other_path` varchar(255) NOT NULL DEFAULT '其他路径（图片时存放压缩图片）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48011 DEFAULT CHARSET=utf8 COMMENT='附件表';

/*Table structure for table `bd_job_cate` */

DROP TABLE IF EXISTS `bd_job_cate`;

CREATE TABLE `bd_job_cate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `cate_name` varchar(50) NOT NULL,
  `english_name` varchar(100) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `cate_code` varchar(30) NOT NULL,
  `cate_type` smallint(6) NOT NULL,
  `tree_code` varchar(64) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_code` varchar(30) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42001 DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

/*Table structure for table `bd_job_skill` */

DROP TABLE IF EXISTS `bd_job_skill`;

CREATE TABLE `bd_job_skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `skill_name` varchar(50) NOT NULL,
  `english_name` varchar(100) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `skill_code` varchar(30) NOT NULL,
  `job_cate_id` bigint(20) NOT NULL,
  `tree_code` varchar(64) NOT NULL,
  `cate_tree_code` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46057 DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

/*Table structure for table `bd_job_tag` */

DROP TABLE IF EXISTS `bd_job_tag`;

CREATE TABLE `bd_job_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `tag_name` varchar(50) NOT NULL COMMENT '标签名',
  `job_cate_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `skill_id` bigint(20) DEFAULT NULL COMMENT '技能id',
  `employer_id` bigint(20) DEFAULT '-1' COMMENT '雇佣者id（如果是非自定义标签，该字段为空）',
  `status` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `ts` timestamp(3) NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6002 DEFAULT CHARSET=utf8mb4 COMMENT='评价标签';

/*Table structure for table `demand_info` */

DROP TABLE IF EXISTS `demand_info`;

CREATE TABLE `demand_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '需求编码',
  `employer_id` bigint(20) NOT NULL COMMENT '发布用户编码',
  `status` tinyint(4) DEFAULT NULL COMMENT '需求状态（10-未发布，20-已发布，30-已取消，40-已下单）',
  `job_cate_id` bigint(20) NOT NULL COMMENT '需求类型',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '需求类型',
  `expect_delivery_time` datetime NOT NULL COMMENT '期望交付时间',
  `budget` double NOT NULL DEFAULT '0' COMMENT '预算',
  `recommend_count` int(11) NOT NULL DEFAULT '0' COMMENT '推荐人数',
  `province_code` varchar(32) NOT NULL COMMENT '需求省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '需求城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '需求区编码',
  `county_code` varchar(32) DEFAULT NULL,
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '需求概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '需求详细描述',
  `job_title` varchar(50) DEFAULT NULL COMMENT '职务名称',
  `company_name` varchar(500) DEFAULT '' COMMENT '企业名称',
  `budget_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '预算计算方式:0:时薪,1:一口价,2:面谈',
  `delivery_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '交付方式:0:远程,1:现场',
  `attestation` bigint(50) DEFAULT '0' COMMENT '平台认证:0-未认证,1-认证',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UN_CODE` (`code`) COMMENT '唯一索引',
  KEY `idx_demand_employer_id` (`employer_id`),
  KEY `idx_demand_status` (`status`),
  KEY `idx_demand_job_cate_id` (`job_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14001 DEFAULT CHARSET=utf8 COMMENT='需求表';

/*Table structure for table `demand_production_relation` */

DROP TABLE IF EXISTS `demand_production_relation`;

CREATE TABLE `demand_production_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `demand_id` bigint(20) DEFAULT NULL COMMENT '需求编号',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单Id',
  `status` tinyint(4) DEFAULT NULL COMMENT '关系状态',
  `production_id` bigint(20) NOT NULL COMMENT '作品编码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_demand_production_demand_id` (`demand_id`),
  KEY `idx_demand_production_production_id` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16014 DEFAULT CHARSET=utf8 COMMENT='订单流水';

/*Table structure for table `display_config` */

DROP TABLE IF EXISTS `display_config`;

CREATE TABLE `display_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `display_id` bigint(20) NOT NULL COMMENT '绑定资源编码',
  `display_type` tinyint(4) NOT NULL COMMENT '绑定资源类型',
  `expired_time` datetime NOT NULL COMMENT '过期时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18002 DEFAULT CHARSET=utf8 COMMENT='展位配置表';

/*Table structure for table `employer_info` */

DROP TABLE IF EXISTS `employer_info`;

CREATE TABLE `employer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
  `code` varchar(32) NOT NULL COMMENT '雇佣者编码',
  `name` varchar(32) NOT NULL COMMENT '雇佣者姓名',
  `head_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  `account_code` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '关联账户(微信登录认证)',
  `province_code` varchar(32) DEFAULT NULL,
  `city_code` varchar(32) DEFAULT NULL,
  `district_code` varchar(32) DEFAULT NULL,
  `county_code` varchar(32) DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号',
  `job_title` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '职务名称',
  `company` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_user` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38003 DEFAULT CHARSET=utf8mb4 COMMENT='雇佣者信息表';

/*Table structure for table `evaluation_info` */

DROP TABLE IF EXISTS `evaluation_info`;

CREATE TABLE `evaluation_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单主键\n',
  `total_score` double NOT NULL COMMENT '总体评价（5分满分）\n',
  `job_cate_id` bigint(20) NOT NULL COMMENT '需求类型',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '需求类型',
  `employer_id` bigint(20) NOT NULL COMMENT '评价者主键',
  `freelancer_id` bigint(20) NOT NULL COMMENT '被评价者主键',
  `result_score` double NOT NULL COMMENT '结果打分（5分制）',
  `process_score` double NOT NULL COMMENT '过程打分（5分制）',
  `recommend_score` double NOT NULL COMMENT '推荐意向（5分制）',
  `description` varchar(300) NOT NULL DEFAULT '' COMMENT '评价',
  `create_time` datetime NOT NULL,
  `create_user` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(20) NOT NULL,
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_delete` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4002 DEFAULT CHARSET=utf8 COMMENT='评价信息表';

/*Table structure for table `evaluation_info_tag` */

DROP TABLE IF EXISTS `evaluation_info_tag`;

CREATE TABLE `evaluation_info_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `evaluation_info_id` bigint(20) NOT NULL COMMENT '评价信息主键',
  `tag_id` bigint(20) NOT NULL COMMENT '标签主键',
  `create_time` datetime NOT NULL,
  `create_user` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` bigint(20) NOT NULL,
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_delete` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评价信息标签表';

/*Table structure for table `freelancer_info` */

DROP TABLE IF EXISTS `freelancer_info`;

CREATE TABLE `freelancer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
  `code` varchar(32) NOT NULL COMMENT '自由职业者编码',
  `name` varchar(32) NOT NULL COMMENT '自由职业者姓名',
  `head_img` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `skill_summarize` varchar(2000) CHARACTER SET utf8 NOT NULL COMMENT '技能描述',
  `language` tinyint(4) NOT NULL COMMENT '语言',
  `job_cate_id` bigint(20) DEFAULT NULL COMMENT '所属领域',
  `cate_tree_code` varchar(256) CHARACTER SET utf8 DEFAULT '' COMMENT '技能全路径',
  `province_code` varchar(32) DEFAULT NULL,
  `city_code` varchar(32) DEFAULT NULL,
  `district_code` varchar(32) DEFAULT NULL,
  `county_code` varchar(32) DEFAULT NULL,
  `account_code` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '关联账户(微信登录认证)',
  `phone` varchar(32) CHARACTER SET utf8 DEFAULT '' COMMENT '手机号',
  `referral_code` varchar(255) DEFAULT NULL,
  `referrer` bigint(50) DEFAULT NULL COMMENT '推荐人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54003 DEFAULT CHARSET=utf8mb4 COMMENT='自由职业者信息表';

/*Table structure for table `leaf_alloc` */

DROP TABLE IF EXISTS `leaf_alloc`;

CREATE TABLE `leaf_alloc` (
  `biz_tag` varchar(128) NOT NULL DEFAULT '',
  `max_id` bigint(20) NOT NULL DEFAULT '1',
  `step` int(11) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`biz_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `order_follow` */

DROP TABLE IF EXISTS `order_follow`;

CREATE TABLE `order_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单号',
  `operate_type` tinyint(4) DEFAULT NULL COMMENT '操作类型',
  `memo` varchar(50) DEFAULT NULL COMMENT '流水描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operate_user` bigint(20) NOT NULL,
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12017 DEFAULT CHARSET=utf8 COMMENT='订单流水';

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '订单编码',
  `job_cate_id` bigint(20) NOT NULL COMMENT '需求类型',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '需求类型',
  `status` tinyint(4) NOT NULL COMMENT '订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）',
  `budget_type` tinyint(4) DEFAULT '0' COMMENT '预算计算方式:0:时薪,1:一口价,2:面谈',
  `order_mny` decimal(20,8) NOT NULL DEFAULT '0.00000000' COMMENT '订单金额',
  `act_order_mny` decimal(20,8) NOT NULL DEFAULT '0.00000000',
  `order_price` decimal(20,8) DEFAULT NULL,
  `order_times` int(11) DEFAULT NULL,
  `expect_delivery_time` datetime NOT NULL COMMENT '期望交付时间',
  `act_deliver_time` datetime DEFAULT NULL,
  `demand_id` bigint(20) DEFAULT NULL,
  `is_upload_voucher` tinyint(4) DEFAULT NULL COMMENT '是否上传凭证',
  `freelancer_id` bigint(20) NOT NULL COMMENT '需求执行人',
  `employer_id` bigint(20) NOT NULL COMMENT '需求提出人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UN_CODE` (`code`) COMMENT '唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=12005 DEFAULT CHARSET=utf8 COMMENT='订单信息';

/*Table structure for table `order_info_detail` */

DROP TABLE IF EXISTS `order_info_detail`;

CREATE TABLE `order_info_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单码',
  `province_code` varchar(32) DEFAULT NULL COMMENT '需求省份编码',
  `city_code` varchar(32) DEFAULT NULL COMMENT '需求城市编码',
  `district_code` varchar(32) DEFAULT NULL COMMENT '需求区编码',
  `county_code` varchar(32) DEFAULT NULL,
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '订单概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '订单详细描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38001 DEFAULT CHARSET=utf8 COMMENT='订单详情';

/*Table structure for table `order_operate_info` */

DROP TABLE IF EXISTS `order_operate_info`;

CREATE TABLE `order_operate_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` bigint(20) NOT NULL,
  `operate_type` smallint(6) NOT NULL COMMENT '操作类型（10：提交验收；20：验收通过；30：验收不通过）',
  `operate_user` bigint(20) NOT NULL,
  `receive_user` bigint(20) NOT NULL,
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

/*Table structure for table `production_info` */

DROP TABLE IF EXISTS `production_info`;

CREATE TABLE `production_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '作品编码',
  `freelancer_id` bigint(20) NOT NULL COMMENT '发布用户编码',
  `title` varchar(256) NOT NULL DEFAULT '' COMMENT '作品标题',
  `summarize` varchar(2000) NOT NULL DEFAULT '' COMMENT '技能描述',
  `hourly_wage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '时薪',
  `status` tinyint(4) NOT NULL COMMENT '状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）',
  `job_cate_id` bigint(20) NOT NULL COMMENT '所属领域',
  `cate_tree_code` varchar(256) DEFAULT '' COMMENT '技能全路径',
  `budget_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '预算计算方式:0:时薪,1:一口价,2:面谈',
  `delivery_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '交付方式:0:远程,1:现场',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UN_CODE` (`code`) COMMENT 'code唯一索引',
  KEY `IDX_CREATE_TIME` (`create_time`),
  KEY `IDX_JOB_CATE_ID` (`job_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36002 DEFAULT CHARSET=utf8 COMMENT='作品表';

/*Table structure for table `production_review_info` */

DROP TABLE IF EXISTS `production_review_info`;

CREATE TABLE `production_review_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `production_id` bigint(20) NOT NULL COMMENT '作品编码',
  `reviewer_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `reviewer_opinion` varchar(2000) DEFAULT NULL COMMENT '审核意见',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（10-未审核，20-审核未通过，30-审核通过）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(50) NOT NULL COMMENT '创建人',
  `update_user` bigint(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `IDX_PRO_ID` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26011 DEFAULT CHARSET=utf8 COMMENT='作品审核表';

/*Table structure for table `production_skill_relation` */

DROP TABLE IF EXISTS `production_skill_relation`;

CREATE TABLE `production_skill_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `production_id` bigint(20) NOT NULL COMMENT '作品编码',
  `job_skill_id` bigint(20) NOT NULL COMMENT '技能编码',
  `skill_tree_path` varchar(500) DEFAULT '' COMMENT '技能树完整路径ID数组格式',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `IDX_PRO_ID` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38016 DEFAULT CHARSET=utf8 COMMENT='作品与技能关联表';

/*Table structure for table `sys_base_dict` */

DROP TABLE IF EXISTS `sys_base_dict`;

CREATE TABLE `sys_base_dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '分类名称',
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '分类编号',
  `memo` varchar(128) NOT NULL DEFAULT '' COMMENT '备注',
  `parent_id` int(11) DEFAULT NULL COMMENT '与id进行关联',
  `node_level` int(11) DEFAULT NULL COMMENT '节点级别',
  `belong_group` int(11) DEFAULT NULL COMMENT '类型分类',
  `order_num` int(11) DEFAULT '0' COMMENT '排序值',
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `update_user` bigint(20) DEFAULT '0' COMMENT '修改人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '删除标识，默认为0',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `IDX_UN_CODE` (`code`) COMMENT '唯一索引',
  KEY `idx_group` (`belong_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '编码',
  `name` varchar(32) DEFAULT '' COMMENT '名字',
  `password` varchar(64) DEFAULT '',
  `phone` varchar(20) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `INDEX_CODE` (`code`) COMMENT '编码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础用户表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
