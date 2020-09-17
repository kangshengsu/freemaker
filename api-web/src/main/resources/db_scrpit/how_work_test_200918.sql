/*
Navicat MySQL Data Transfer

Source Server         : 172.21.16.11
Source Server Version : 50718
Source Host           : 172.21.16.11:3306
Source Database       : how_work_test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-09-18 00:24:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment_info
-- ----------------------------
DROP TABLE IF EXISTS `attachment_info`;
CREATE TABLE `attachment_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `business_type` tinyint(4) DEFAULT NULL COMMENT '附件所属业务类型（10-需求,20-作品,30-订单）',
  `business_code` varchar(32) DEFAULT '' COMMENT '附件所属业务编码',
  `type` tinyint(4) DEFAULT NULL COMMENT '附件类型（1-图片,2-视频）',
  `name` varchar(128) DEFAULT NULL COMMENT '附件名称',
  `path` varchar(255) DEFAULT NULL COMMENT '存放路径',
  `other_path` varchar(255) DEFAULT NULL COMMENT '其他路径（图片时存放压缩图片）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attachment_info
-- ----------------------------
INSERT INTO `attachment_info` VALUES ('12', '2', '23', '3', '1', '2', '1', '2020-09-11 23:12:21', '2020-09-11 23:18:47', '11', '1', '1', '2020-09-11 23:18:47');
INSERT INTO `attachment_info` VALUES ('101', null, '22', null, null, null, null, '2020-09-12 15:14:09', '2020-09-12 15:14:09', 'test', '123', '0', '2020-09-12 15:14:09');

-- ----------------------------
-- Table structure for bd_job_cate
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_cate`;
CREATE TABLE `bd_job_cate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `cate_name` varchar(50) NOT NULL,
  `cate_code` varchar(10) NOT NULL,
  `cate_type` smallint(6) NOT NULL,
  `tree_code` varchar(64) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Records of bd_job_cate
-- ----------------------------

-- ----------------------------
-- Table structure for bd_job_skill
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_skill`;
CREATE TABLE `bd_job_skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `skill_name` varchar(50) NOT NULL,
  `skill_code` varchar(10) NOT NULL,
  `job_code` bigint(20) NOT NULL,
  `tree_code` varchar(200) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

-- ----------------------------
-- Records of bd_job_skill
-- ----------------------------

-- ----------------------------
-- Table structure for demand_info
-- ----------------------------
DROP TABLE IF EXISTS `demand_info`;
CREATE TABLE `demand_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '需求编码',
  `employer_code` varchar(128) NOT NULL COMMENT '发布用户编码',
  `status` tinyint(4) DEFAULT NULL COMMENT '需求状态（10-未发布，20-已发布，30-已取消，40-已下单）',
  `job_code` bigint(20) NOT NULL COMMENT '需求类型',
  `tree_code` bigint(20) NOT NULL COMMENT '需求类型',
  `expect_delivery_time` datetime NOT NULL COMMENT '期望交付时间',
  `budget` double NOT NULL DEFAULT '0' COMMENT '预算',
  `recommend_count` int(11) NOT NULL DEFAULT '0' COMMENT '推荐人数',
  `province_code` varchar(32) NOT NULL COMMENT '需求省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '需求城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '需求区编码',
  `county_code` varchar(32) NOT NULL COMMENT '需求县编码',
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '需求概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '需求详细描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='需求表';

-- ----------------------------
-- Records of demand_info
-- ----------------------------
INSERT INTO `demand_info` VALUES ('1', 'demand_001', 'user01', '2', '12', '12', '2020-09-11 21:49:00', '0', '0', '1', '1', '1', '12', '', '', '2020-09-11 21:49:16', '2020-09-13 20:13:08', '122', '12', '0', '2020-09-13 20:13:08');

-- ----------------------------
-- Table structure for demand_production_relation
-- ----------------------------
DROP TABLE IF EXISTS `demand_production_relation`;
CREATE TABLE `demand_production_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单号',
  `status` tinyint(4) DEFAULT NULL COMMENT '关系状态',
  `production_code` varchar(32) NOT NULL COMMENT '作品编码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of demand_production_relation
-- ----------------------------

-- ----------------------------
-- Table structure for display_config
-- ----------------------------
DROP TABLE IF EXISTS `display_config`;
CREATE TABLE `display_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `display_code` varchar(32) NOT NULL COMMENT '绑定资源编码',
  `display_type` tinyint(4) NOT NULL COMMENT '绑定资源类型（1-领域，2-技能，3-作品）',
  `expired_time` datetime NOT NULL COMMENT '过期时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='展位配置表';

-- ----------------------------
-- Records of display_config
-- ----------------------------

-- ----------------------------
-- Table structure for employer_info
-- ----------------------------
DROP TABLE IF EXISTS `employer_info`;
CREATE TABLE `employer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '雇佣者编码',
  `name` varchar(32) NOT NULL COMMENT '雇佣者姓名',
  `account_code` varchar(32) NOT NULL COMMENT '关联账户(微信登录认证)',
  `province_code` varchar(32) NOT NULL COMMENT '省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '区编码',
  `county_code` varchar(32) NOT NULL COMMENT '县编码',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='雇佣者信息表';

-- ----------------------------
-- Records of employer_info
-- ----------------------------

-- ----------------------------
-- Table structure for freelancer_info
-- ----------------------------
DROP TABLE IF EXISTS `freelancer_info`;
CREATE TABLE `freelancer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '自由职业者编码',
  `name` varchar(32) NOT NULL COMMENT '自由职业者姓名',
  `skill_summarize` varchar(2000) NOT NULL COMMENT '技能描述',
  `language` tinyint(4) NOT NULL COMMENT '语言',
  `job_code` varchar(32) NOT NULL COMMENT '所属领域',
  `tree_code` varchar(256) NOT NULL COMMENT '技能全路径',
  `province_code` varchar(32) NOT NULL COMMENT '省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '区编码',
  `county_code` varchar(32) NOT NULL COMMENT '县编码',
  `account_code` varchar(32) NOT NULL COMMENT '关联账户(微信登录认证)',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='自由职业者信息表';

-- ----------------------------
-- Records of freelancer_info
-- ----------------------------
INSERT INTO `freelancer_info` VALUES ('1', 'zhangsan', '张三', '1231231', '1', '12', '12', '001', '002', '112', '112', '11', '1', '2020-09-13 22:47:30', '2020-09-13 22:47:35', '1', '1', '0', null);

-- ----------------------------
-- Table structure for leaf_alloc
-- ----------------------------
DROP TABLE IF EXISTS `leaf_alloc`;
CREATE TABLE `leaf_alloc` (
  `biz_tag` varchar(128) NOT NULL DEFAULT '',
  `max_id` bigint(20) NOT NULL DEFAULT '1',
  `step` int(11) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`biz_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of leaf_alloc
-- ----------------------------
INSERT INTO `leaf_alloc` VALUES ('attachment_info', '201', '100', null, '2020-09-12 15:14:09');
INSERT INTO `leaf_alloc` VALUES ('leaf-segment-test', '1', '2000', 'Test leaf Segment Mode Get Id', '2020-09-10 16:19:14');

-- ----------------------------
-- Table structure for order_follow
-- ----------------------------
DROP TABLE IF EXISTS `order_follow`;
CREATE TABLE `order_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_code` varchar(32) DEFAULT NULL COMMENT '订单号',
  `operate_type` tinyint(4) DEFAULT NULL COMMENT '操作类型',
  `memo` varchar(50) DEFAULT NULL COMMENT '流水描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of order_follow
-- ----------------------------

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '订单编码',
  `job_code` bigint(20) NOT NULL COMMENT '需求类型',
  `tree_code` bigint(20) NOT NULL COMMENT '需求类型',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）',
  `order_mny` double NOT NULL DEFAULT '0' COMMENT '订单金额',
  `expect_delivery_time` datetime NOT NULL COMMENT '期望交付时间',
  `act_deliver_time` datetime NOT NULL COMMENT '实际交付时间',
  `demand_code` varchar(32) NOT NULL COMMENT '需求编码',
  `freelancer` varchar(50) NOT NULL COMMENT '需求执行人',
  `employer` varchar(50) NOT NULL COMMENT '需求提出人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '12', '12', '2', '10', '0', '2020-09-13 18:06:30', '2020-09-13 18:06:36', '123', '阿斯达', '1说的', '2020-09-13 18:06:55', '2020-09-13 18:06:57', '123', '567', '0', '2020-09-13 18:07:05');
INSERT INTO `order_info` VALUES ('2', '123', '12', '2', '10', '0', '2020-09-13 18:06:30', '2020-09-13 18:06:36', '123', '阿斯达', '1说的', '2020-09-13 18:06:55', '2020-09-13 18:06:57', '123', '567', '0', '2020-09-13 18:07:05');
INSERT INTO `order_info` VALUES ('3', '1234', '12', '2', '10', '0', '2020-09-13 18:06:30', '2020-09-13 18:06:36', '123', '阿斯达', '1说的', '2020-09-13 18:06:55', '2020-09-13 18:06:57', '123', '567', '0', '2020-09-13 18:07:05');

-- ----------------------------
-- Table structure for order_info_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_info_detail`;
CREATE TABLE `order_info_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_code` varchar(32) NOT NULL COMMENT '订单码',
  `province_code` varchar(32) NOT NULL COMMENT '需求省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '需求城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '需求区编码',
  `county_code` varchar(32) NOT NULL COMMENT '需求县编码',
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '订单概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '订单详细描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情';

-- ----------------------------
-- Records of order_info_detail
-- ----------------------------

-- ----------------------------
-- Table structure for production_info
-- ----------------------------
DROP TABLE IF EXISTS `production_info`;
CREATE TABLE `production_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '作品编码',
  `freelancer_code` varchar(128) NOT NULL COMMENT '发布用户编码',
  `title` varchar(256) DEFAULT '' COMMENT '作品标题',
  `summarize` varchar(2000) DEFAULT NULL COMMENT '技能描述',
  `hourly_wage` decimal(10,2) DEFAULT '0.00' COMMENT '时薪',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）',
  `job_code` varchar(32) NOT NULL COMMENT '所属领域',
  `tree_code` varchar(256) NOT NULL COMMENT '技能全路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='作品表';

-- ----------------------------
-- Records of production_info
-- ----------------------------
INSERT INTO `production_info` VALUES ('1', '1', '123', '胸口碎大石', '各种石头各种碎', '3000.01', '10', 'job_code', 'tree_code', '2020-09-13 22:06:23', '2020-09-13 22:06:25', 'liuduo', 'liuduo', '0', '2020-09-13 22:06:41');
INSERT INTO `production_info` VALUES ('2', '2', '123', '倒拔垂杨柳', '啥都能干', '6000.01', '20', 'job_code', 'tree_code', '2020-09-13 22:06:23', '2020-09-13 22:06:25', 'liuduo', 'liuduo', '0', '2020-09-13 22:06:41');

-- ----------------------------
-- Table structure for production_review_info
-- ----------------------------
DROP TABLE IF EXISTS `production_review_info`;
CREATE TABLE `production_review_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `production_code` varchar(32) NOT NULL COMMENT '作品编码',
  `reviewer_code` varchar(32) DEFAULT NULL COMMENT '审核人',
  `reviewer_opinion` varchar(2000) DEFAULT NULL COMMENT '审核意见',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（10-未审核，20-审核未通过，30-审核通过）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作品审核表';

-- ----------------------------
-- Records of production_review_info
-- ----------------------------

-- ----------------------------
-- Table structure for production_skill_relation
-- ----------------------------
DROP TABLE IF EXISTS `production_skill_relation`;
CREATE TABLE `production_skill_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `production_code` varchar(32) NOT NULL COMMENT '作品编码',
  `skill_code` varchar(32) NOT NULL COMMENT '技能编码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作品与技能关联表';

-- ----------------------------
-- Records of production_skill_relation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_base_dict
-- ----------------------------
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
  `create_user_code` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `update_user_code` bigint(20) DEFAULT '0' COMMENT '修改人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '删除标识，默认为0',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_group` (`belong_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

-- ----------------------------
-- Records of sys_base_dict
-- ----------------------------
INSERT INTO `sys_base_dict` VALUES ('1', '测试字典', 'TEST1', '测1', '1', '1', '1', '1', '0', '0', '2020-09-17 22:05:54', '2020-09-17 22:05:57', '0', '2020-09-17 22:06:44.466');
INSERT INTO `sys_base_dict` VALUES ('2', '测试字典2', 'TEST2', '测2', '1', '2', '1', '2', '0', '0', '2020-09-17 22:05:54', '2020-09-17 22:05:57', '0', '2020-09-17 22:06:53.090');
INSERT INTO `sys_base_dict` VALUES ('3', '测试字典3', 'TEST3', '测3', '1', '2', '1', '1', '0', '0', '2020-09-17 22:05:54', '2020-09-17 22:05:57', '0', '2020-09-17 22:06:54.933');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '编码',
  `name` varchar(32) NOT NULL COMMENT '名字',
  `password` varchar(64) DEFAULT '',
  `phone` varchar(20) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `INDEX_CODE` (`code`) COMMENT '编码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'wyb', '王一博', 'wyb', null, null, '2020-09-12 18:00:02', '0', '2020-09-13 10:35:19');
INSERT INTO `sys_user` VALUES ('2', 'admin', '管理员', '21232f297a57a5a743894a0e4a801fc3', '18888888888', null, '2020-09-13 13:56:20', '0', '2020-09-13 16:07:04');
