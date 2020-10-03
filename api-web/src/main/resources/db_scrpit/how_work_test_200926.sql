/*
Navicat MySQL Data Transfer

Source Server         : 172.21.16.11.test
Source Server Version : 50718
Source Host           : 172.21.16.11:3306
Source Database       : how_work_test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-09-26 16:48:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment_info
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=26006 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attachment_info
-- ----------------------------
INSERT INTO `attachment_info` VALUES ('1', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('2', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('3', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('4', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('5', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('6', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('7', '20', 'PROD_1', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('8', '20', 'PROD_2', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-21 23:28:29', '1', '1', '1', '2020-09-21 23:28:29.884');
INSERT INTO `attachment_info` VALUES ('9', '20', 'PROD_3', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('10', '20', 'PROD_3', '1', '需求', 'test/00001.jpg', 'test/00001.jpg', '2020-09-19 21:11:55', '2020-09-19 21:46:17', '1', '1', '0', '2020-09-19 21:46:17.148');
INSERT INTO `attachment_info` VALUES ('6000', '20', 'DEG92MYYU', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 20:38:25', '2020-09-21 20:38:25', '2', '2', '0', '2020-09-21 20:38:24.788');
INSERT INTO `attachment_info` VALUES ('6001', '20', 'DEG92MYYU', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 20:38:25', '2020-09-21 20:38:25', '2', '2', '0', '2020-09-21 20:38:24.788');
INSERT INTO `attachment_info` VALUES ('8000', '20', '2FKYDT3S9', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 21:55:51', '2020-09-21 21:55:51', '2', '2', '0', '2020-09-21 21:55:51.328');
INSERT INTO `attachment_info` VALUES ('8001', '20', '2FKYDT3S9', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 21:55:51', '2020-09-21 21:55:51', '2', '2', '0', '2020-09-21 21:55:51.328');
INSERT INTO `attachment_info` VALUES ('10000', '20', '2U87SZ9JC', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:01:11', '2020-09-21 22:01:11', '2', '2', '0', '2020-09-21 22:01:11.347');
INSERT INTO `attachment_info` VALUES ('10001', '20', '2U87SZ9JC', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:01:11', '2020-09-21 22:01:11', '2', '2', '0', '2020-09-21 22:01:11.347');
INSERT INTO `attachment_info` VALUES ('12000', '20', '4MH8MP2R9', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:03:09', '2020-09-21 22:03:09', '2', '2', '0', '2020-09-21 22:03:09.496');
INSERT INTO `attachment_info` VALUES ('12001', '20', '4MH8MP2R9', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:03:09', '2020-09-21 22:03:09', '2', '2', '0', '2020-09-21 22:03:09.496');
INSERT INTO `attachment_info` VALUES ('14000', '20', 'JL6AJQH7G', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:10:36', '2020-09-21 22:10:36', '2', '2', '0', '2020-09-21 22:10:35.541');
INSERT INTO `attachment_info` VALUES ('14001', '20', 'JL6AJQH7G', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 22:10:36', '2020-09-21 22:10:36', '2', '2', '0', '2020-09-21 22:10:35.541');
INSERT INTO `attachment_info` VALUES ('16000', '20', '', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 23:04:06', '2020-09-21 23:04:06', '2', '2', '0', '2020-09-21 23:04:05.737');
INSERT INTO `attachment_info` VALUES ('16001', '20', '', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 23:04:06', '2020-09-21 23:04:06', '2', '2', '0', '2020-09-21 23:04:05.737');
INSERT INTO `attachment_info` VALUES ('18000', '20', 'PROD_2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 23:28:29', '2020-09-21 23:28:29', '2', '2', '0', '2020-09-21 23:28:29.160');
INSERT INTO `attachment_info` VALUES ('18001', '20', 'PROD_2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-21 23:28:29', '2020-09-21 23:28:29', '2', '2', '0', '2020-09-21 23:28:29.160');
INSERT INTO `attachment_info` VALUES ('20000', '20', 'BRUBJ8H34', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-22 00:22:27', '2020-09-22 00:22:27', '2', '2', '0', '2020-09-22 00:22:26.892');
INSERT INTO `attachment_info` VALUES ('20001', '20', 'BRUBJ8H34', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-22 00:22:27', '2020-09-22 00:22:27', '2', '2', '0', '2020-09-22 00:22:26.892');
INSERT INTO `attachment_info` VALUES ('22000', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-23 23:57:58', '2020-09-24 00:08:30', '2', '2', '1', '2020-09-24 00:08:30.460');
INSERT INTO `attachment_info` VALUES ('22001', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-23 23:57:58', '2020-09-24 00:08:30', '2', '2', '1', '2020-09-24 00:08:30.460');
INSERT INTO `attachment_info` VALUES ('24000', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:08:30', '2020-09-24 00:10:11', '2', '2', '1', '2020-09-24 00:10:11.453');
INSERT INTO `attachment_info` VALUES ('24001', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:08:30', '2020-09-24 00:10:11', '2', '2', '1', '2020-09-24 00:10:11.453');
INSERT INTO `attachment_info` VALUES ('24002', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:10:11', '2020-09-24 00:10:11', '2', '2', '0', '2020-09-24 00:10:11.267');
INSERT INTO `attachment_info` VALUES ('24003', '20', 'DB9EX7FJR', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:10:11', '2020-09-24 00:10:11', '2', '2', '0', '2020-09-24 00:10:11.267');
INSERT INTO `attachment_info` VALUES ('24004', '20', 'MTQ6GPTJ2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:11:32', '2020-09-24 00:32:37', '2', '2', '1', '2020-09-24 00:32:37.114');
INSERT INTO `attachment_info` VALUES ('24005', '20', 'MTQ6GPTJ2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:11:32', '2020-09-24 00:32:37', '2', '2', '1', '2020-09-24 00:32:37.114');
INSERT INTO `attachment_info` VALUES ('26000', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:20:05', '2020-09-24 00:32:55', '2', '2', '1', '2020-09-24 00:32:55.225');
INSERT INTO `attachment_info` VALUES ('26001', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:20:05', '2020-09-24 00:32:55', '2', '2', '1', '2020-09-24 00:32:55.225');
INSERT INTO `attachment_info` VALUES ('26002', '20', 'MTQ6GPTJ2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:37', '2020-09-24 00:32:37', '2', '2', '0', '2020-09-24 00:32:36.918');
INSERT INTO `attachment_info` VALUES ('26003', '20', 'MTQ6GPTJ2', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:37', '2020-09-24 00:32:37', '2', '2', '0', '2020-09-24 00:32:36.918');
INSERT INTO `attachment_info` VALUES ('26004', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:55', '2020-09-24 00:32:55', '2', '2', '0', '2020-09-24 00:32:55.031');
INSERT INTO `attachment_info` VALUES ('26005', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:55', '2020-09-24 00:32:55', '2', '2', '0', '2020-09-24 00:32:55.031');

-- ----------------------------
-- Table structure for bd_job_cate
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_cate`;
CREATE TABLE `bd_job_cate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `cate_name` varchar(50) NOT NULL,
  `cate_code` varchar(30) NOT NULL,
  `cate_type` smallint(6) NOT NULL,
  `tree_code` varchar(64) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_code` varchar(10) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8004 DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Records of bd_job_cate
-- ----------------------------
INSERT INTO `bd_job_cate` VALUES ('1', '餐饮领域', '1111', '10', 'NHRZ', null, '', '2020-09-19 17:29:48', '2020-09-20 11:12:47', '2', '2', '0', '2020-09-20 11:12:47.087');
INSERT INTO `bd_job_cate` VALUES ('2', '厨师', '22', '20', 'PHAF', '1', '', '2020-09-19 21:52:50', '2020-09-20 11:12:51', '2', '2', '0', '2020-09-20 11:12:51.573');
INSERT INTO `bd_job_cate` VALUES ('3', '切墩', '228', '20', 'ZDKH', '1', '', '2020-09-19 22:58:46', '2020-09-20 11:12:53', '2', '2', '0', '2020-09-20 11:12:53.566');
INSERT INTO `bd_job_cate` VALUES ('8000', '互联网领域', 'HLW', '10', 'KZEI', null, '', '2020-09-20 21:51:25', '2020-09-20 21:51:35', '2', '2', '0', '2020-09-20 21:51:34.898');
INSERT INTO `bd_job_cate` VALUES ('8001', '开发', 'KF', '20', 'KZEIVSUI', '8000', 'KZEI', '2020-09-20 21:51:54', '2020-09-20 21:59:29', '2', '2', '0', '2020-09-20 21:59:29.989');
INSERT INTO `bd_job_cate` VALUES ('8002', '测试', 'CS', '20', 'KZEINBSP', '8000', 'KZEI', '2020-09-20 21:52:19', '2020-09-20 21:59:30', '2', '2', '0', '2020-09-20 21:59:30.932');
INSERT INTO `bd_job_cate` VALUES ('8003', '产品', 'CP', '20', 'KZEIEQZL', '8000', 'KZEI', '2020-09-20 21:52:43', '2020-09-20 21:59:31', '2', '2', '0', '2020-09-20 21:59:31.904');

-- ----------------------------
-- Table structure for bd_job_skill
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_skill`;
CREATE TABLE `bd_job_skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `skill_name` varchar(50) NOT NULL,
  `skill_code` varchar(30) NOT NULL,
  `job_cate_id` bigint(20) NOT NULL,
  `cate_tree_code` varchar(200) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20008 DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

-- ----------------------------
-- Records of bd_job_skill
-- ----------------------------
INSERT INTO `bd_job_skill` VALUES ('16000', 'JAVA', 'JAVA', '8001', 'KZEIVSUIMYVW', '2020-09-20 21:52:54', '2020-09-20 22:00:03', '2', '2', '1', '2020-09-20 22:00:03.091');
INSERT INTO `bd_job_skill` VALUES ('16001', 'JAVA', 'JAVA', '8001', 'KFIXYS', '2020-09-20 21:53:07', '2020-09-20 21:53:09', '2', '2', '1', '2020-09-20 21:53:09.295');
INSERT INTO `bd_job_skill` VALUES ('16002', 'JAVA', 'JAVA', '8001', 'KZEIVSUIFXQE', '2020-09-20 21:53:20', '2020-09-20 22:00:07', '2', '2', '0', '2020-09-20 22:00:07.989');
INSERT INTO `bd_job_skill` VALUES ('18000', 'VUE', 'VUE', '8001', 'KZEIVSUIYHJQ', '2020-09-20 22:10:16', '2020-09-20 22:10:16', '2', '2', '0', '2020-09-20 22:10:16.464');
INSERT INTO `bd_job_skill` VALUES ('20000', '锅包肉', 'GBR', '2', '22APBQ', '2020-09-21 00:30:11', '2020-09-21 00:30:11', '2', '2', '0', '2020-09-21 00:30:10.637');
INSERT INTO `bd_job_skill` VALUES ('20001', '溜肉段', 'LRD', '2', '22PVTI', '2020-09-21 00:30:27', '2020-09-21 00:30:27', '2', '2', '0', '2020-09-21 00:30:26.996');
INSERT INTO `bd_job_skill` VALUES ('20002', '卤煮', 'LZ', '2', '22UNGC', '2020-09-21 00:30:51', '2020-09-21 00:30:51', '2', '2', '0', '2020-09-21 00:30:51.433');
INSERT INTO `bd_job_skill` VALUES ('20003', '花刀', 'HD', '3', '228PKQL', '2020-09-21 00:31:14', '2020-09-21 00:31:14', '2', '2', '0', '2020-09-21 00:31:13.582');
INSERT INTO `bd_job_skill` VALUES ('20004', '功能测试', 'GNCS', '8002', 'CSVUZA', '2020-09-21 00:31:30', '2020-09-21 00:31:30', '2', '2', '0', '2020-09-21 00:31:29.557');
INSERT INTO `bd_job_skill` VALUES ('20005', '压力测试', 'YLCS', '8002', 'CSZQIW', '2020-09-21 00:31:51', '2020-09-21 00:31:51', '2', '2', '0', '2020-09-21 00:31:50.535');
INSERT INTO `bd_job_skill` VALUES ('20006', '往死吹', 'WSC', '8003', 'CPWJNU', '2020-09-21 00:32:13', '2020-09-21 00:32:13', '2', '2', '0', '2020-09-21 00:32:13.263');
INSERT INTO `bd_job_skill` VALUES ('20007', 'Python', 'PYTHON', '8001', 'KFOROB', '2020-09-21 00:32:38', '2020-09-21 00:32:38', '2', '2', '0', '2020-09-21 00:32:38.347');

-- ----------------------------
-- Table structure for demand_info
-- ----------------------------
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
  `county_code` varchar(32) NOT NULL COMMENT '需求县编码',
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '需求概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '需求详细描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='需求表';

-- ----------------------------
-- Records of demand_info
-- ----------------------------
INSERT INTO `demand_info` VALUES ('1', 'demand_1', '1', '20', '2000', '#1', '2020-09-19 16:10:39', '1', '1', '1', '2', '3', '4', '一个小需求', '需求简单,钱多,时间充裕,想咋干就咋干,就是任性', '2020-09-19 16:11:52', '2020-09-21 23:40:10', '1', '2', '0', '2020-09-21 23:40:10.407');
INSERT INTO `demand_info` VALUES ('2', 'demand_2', '1', '20', '2000', '#1', '2020-09-19 16:10:39', '1', '2', '1', '2', '3', '4', '两个个小需求', '需求简单,钱多,时间充裕,想咋干就咋干,就是任性', '2020-09-19 16:11:52', '2020-09-21 21:21:19', '1', '2', '0', '2020-09-21 21:21:19.526');

-- ----------------------------
-- Table structure for demand_production_relation
-- ----------------------------
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16008 DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of demand_production_relation
-- ----------------------------
INSERT INTO `demand_production_relation` VALUES ('16007', '1', null, '10', '1', '2020-09-21 23:40:10', '2020-09-21 23:40:10', '2', '2', '0', '2020-09-21 23:40:10.189');

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
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='展位配置表';

-- ----------------------------
-- Records of display_config
-- ----------------------------
INSERT INTO `display_config` VALUES ('1', '1111', '1', '2025-09-20 16:23:12', '2020-09-20 16:23:27', '2020-09-20 16:37:37', '2', '2', '0', '2020-09-20 16:37:40.607');
INSERT INTO `display_config` VALUES ('2', '22', '2', '2024-09-20 16:33:04', '2020-09-20 16:33:12', null, '2', null, '0', '2020-09-20 16:33:17.169');
INSERT INTO `display_config` VALUES ('3', 'PROD_1', '7', '2025-09-20 16:35:32', '2020-09-20 16:35:37', '2020-09-20 16:37:41', '2', '2', '0', '2020-09-20 16:37:41.869');
INSERT INTO `display_config` VALUES ('4', 'PROD_2', '7', '2024-09-20 16:37:10', '2020-09-20 16:37:13', null, '2', null, '0', '2020-09-20 16:37:17.292');

-- ----------------------------
-- Table structure for employer_info
-- ----------------------------
DROP TABLE IF EXISTS `employer_info`;
CREATE TABLE `employer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
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
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4001 DEFAULT CHARSET=utf8 COMMENT='雇佣者信息表';

-- ----------------------------
-- Records of employer_info
-- ----------------------------
INSERT INTO `employer_info` VALUES ('1', '0', '1', '老总', '1', '1', '2', '3', '4', '123456789', '2020-09-19 16:59:07', '2020-09-23 23:41:22', '1', '1', '0', '2020-09-23 23:41:22.113');
INSERT INTO `employer_info` VALUES ('33', '11', 'why not', 'why not', '', 'Beijing', 'Haidian', '', '', null, '2020-09-26 14:00:41', '2020-09-26 16:45:44', '-1', '-1', '0', '2020-09-26 16:45:43.661');

-- ----------------------------
-- Table structure for freelancer_info
-- ----------------------------
DROP TABLE IF EXISTS `freelancer_info`;
CREATE TABLE `freelancer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
  `code` varchar(32) NOT NULL COMMENT '自由职业者编码',
  `name` varchar(32) NOT NULL COMMENT '自由职业者姓名',
  `skill_summarize` varchar(2000) NOT NULL COMMENT '技能描述',
  `language` tinyint(4) NOT NULL COMMENT '语言',
  `job_cate_id` bigint(20) NOT NULL COMMENT '所属领域',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '技能全路径',
  `province_code` varchar(32) NOT NULL COMMENT '省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '区编码',
  `county_code` varchar(32) NOT NULL COMMENT '县编码',
  `account_code` varchar(32) NOT NULL COMMENT '关联账户(微信登录认证)',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4001 DEFAULT CHARSET=utf8 COMMENT='自由职业者信息表';

-- ----------------------------
-- Records of freelancer_info
-- ----------------------------
INSERT INTO `freelancer_info` VALUES ('2', '0', 'wyb', '王一博', '测试数据', '1', '1', '1', '1', '1', '1', '1', '1', '18888888888', '2020-09-19 16:11:26', '2020-09-19 16:11:29', '1', '1', '0', '2020-09-19 16:12:12.501');
INSERT INTO `freelancer_info` VALUES ('3', '0', 'xz', '肖战', '测试数据', '1', '1', '1', '1', '1', '1', '1', '1', '18888888889', '2020-09-19 16:11:26', '2020-09-19 23:12:27', '1', '1', '0', '2020-09-19 23:12:27.137');
INSERT INTO `freelancer_info` VALUES ('22', '11', 'why not', 'why not', '', '0', '0', '', 'Beijing', 'Haidian', '', '', '', null, '2020-09-26 14:00:41', '2020-09-26 16:45:43', '-1', '-1', '0', '2020-09-26 16:45:43.578');

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
INSERT INTO `leaf_alloc` VALUES ('attachment_info', '28000', '2000', null, '2020-09-24 00:20:04');
INSERT INTO `leaf_alloc` VALUES ('bd_job_cate', '10000', '2000', null, '2020-09-20 21:51:24');
INSERT INTO `leaf_alloc` VALUES ('bd_job_skill', '22000', '2000', null, '2020-09-21 00:30:09');
INSERT INTO `leaf_alloc` VALUES ('demand_info', '2000', '2000', null, '2020-09-19 13:14:39');
INSERT INTO `leaf_alloc` VALUES ('demand_production_relation', '18000', '2000', null, '2020-09-21 23:38:24');
INSERT INTO `leaf_alloc` VALUES ('display_config', '2000', '2000', null, '2020-09-19 13:14:41');
INSERT INTO `leaf_alloc` VALUES ('employer_info', '6000', '2000', null, '2020-09-26 14:00:40');
INSERT INTO `leaf_alloc` VALUES ('freelancer_info', '6000', '2000', null, '2020-09-26 14:00:40');
INSERT INTO `leaf_alloc` VALUES ('leaf-segment-test', '1', '2000', 'Test leaf Segment Mode Get Id', '2020-09-10 16:19:14');
INSERT INTO `leaf_alloc` VALUES ('order_follow', '4000', '2000', null, '2020-09-20 16:23:22');
INSERT INTO `leaf_alloc` VALUES ('order_info', '2000', '2000', null, '2020-09-19 13:14:47');
INSERT INTO `leaf_alloc` VALUES ('order_info_detail', '2000', '2000', null, '2020-09-19 13:14:47');
INSERT INTO `leaf_alloc` VALUES ('production_info', '48000', '2000', null, '2020-09-25 23:53:15');
INSERT INTO `leaf_alloc` VALUES ('production_review_info', '14000', '2000', null, '2020-09-22 00:17:17');
INSERT INTO `leaf_alloc` VALUES ('production_skill_relation', '24000', '2000', null, '2020-09-24 00:20:04');
INSERT INTO `leaf_alloc` VALUES ('sys_base_dict', '2000', '2000', null, '2020-09-19 13:14:51');
INSERT INTO `leaf_alloc` VALUES ('sys_user', '6000', '2000', null, '2020-09-26 14:00:40');

-- ----------------------------
-- Table structure for order_follow
-- ----------------------------
DROP TABLE IF EXISTS `order_follow`;
CREATE TABLE `order_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单号',
  `operate_type` tinyint(4) DEFAULT NULL COMMENT '操作类型',
  `memo` varchar(50) DEFAULT NULL COMMENT '流水描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2001 DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of order_follow
-- ----------------------------
INSERT INTO `order_follow` VALUES ('2000', '1', '20', '1212121', '2020-09-20 16:23:24', '2020-09-20 16:23:24', '2', '2', '0', '2020-09-20 16:23:24.314');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '订单编码',
  `summarize` varchar(128) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `job_cate_id` bigint(20) NOT NULL COMMENT '需求类型',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '需求类型',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）',
  `order_mny` double(20,8) NOT NULL DEFAULT '0.00000000' COMMENT '订单金额',
  `expect_delivery_time` datetime NOT NULL COMMENT '期望交付时间',
  `act_deliver_time` datetime NOT NULL COMMENT '实际交付时间',
  `demand_id` bigint(20) NOT NULL COMMENT '需求编码',
  `freelancer_id` bigint(20) NOT NULL COMMENT '需求执行人',
  `employer_id` bigint(20) NOT NULL COMMENT '需求提出人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '002', null, null, '1', 'NHRZ', '20', '1000.00000000', '2020-09-20 16:22:21', '2020-09-20 16:22:25', '15', '2', '3', '2020-09-20 16:22:41', '2020-09-26 13:26:20', '11', '1', '0', '2020-09-26 13:26:21.566');

-- ----------------------------
-- Table structure for order_info_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_info_detail`;
CREATE TABLE `order_info_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单码',
  `province_code` varchar(32) NOT NULL COMMENT '需求省份编码',
  `city_code` varchar(32) NOT NULL COMMENT '需求城市编码',
  `district_code` varchar(32) NOT NULL COMMENT '需求区编码',
  `county_code` varchar(32) NOT NULL COMMENT '需求县编码',
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '订单概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '订单详细描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
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
  `freelancer_id` bigint(20) NOT NULL COMMENT '发布用户编码',
  `title` varchar(256) NOT NULL DEFAULT '' COMMENT '作品标题',
  `summarize` varchar(2000) NOT NULL DEFAULT '' COMMENT '技能描述',
  `hourly_wage` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '时薪',
  `status` tinyint(4) NOT NULL COMMENT '状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）',
  `job_cate_id` bigint(20) NOT NULL COMMENT '所属领域',
  `cate_tree_code` varchar(256) DEFAULT '' COMMENT '技能全路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32002 DEFAULT CHARSET=utf8 COMMENT='作品表';

-- ----------------------------
-- Records of production_info
-- ----------------------------
INSERT INTO `production_info` VALUES ('30000', 'MTQ6GPTJ2', '2', '重构之路', '越走越远', '9987.00', '20', '8001', '[[8000,8001,16002],[8000,8001,20007]]', '2020-09-24 00:11:32', '2020-09-24 00:32:37', '2', '2', '0', '2020-09-24 00:32:37.002');
INSERT INTO `production_info` VALUES ('32001', 'CH7HQPQDJ', '3', '样例标题2', '样例描述1', '9989.00', '20', '8001', '', '2020-09-24 00:20:04', '2020-09-24 00:32:55', '2', '2', '0', '2020-09-24 00:32:55.162');

-- ----------------------------
-- Table structure for production_review_info
-- ----------------------------
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12001 DEFAULT CHARSET=utf8 COMMENT='作品审核表';

-- ----------------------------
-- Records of production_review_info
-- ----------------------------

-- ----------------------------
-- Table structure for production_skill_relation
-- ----------------------------
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22007 DEFAULT CHARSET=utf8 COMMENT='作品与技能关联表';

-- ----------------------------
-- Records of production_skill_relation
-- ----------------------------
INSERT INTO `production_skill_relation` VALUES ('20000', '30000', '16002', '[8000,8001,16002]', '2020-09-24 00:11:32', '2020-09-24 00:32:37', '2', '2', '1', '2020-09-24 00:32:37.022');
INSERT INTO `production_skill_relation` VALUES ('20001', '30000', '20007', '[8000,8001,20007]', '2020-09-24 00:11:32', '2020-09-24 00:32:37', '2', '2', '1', '2020-09-24 00:32:37.022');
INSERT INTO `production_skill_relation` VALUES ('22000', '32001', '16002', '[8000,8001,16002]', '2020-09-24 00:20:05', '2020-09-24 00:32:55', '2', '2', '1', '2020-09-24 00:32:55.180');
INSERT INTO `production_skill_relation` VALUES ('22001', '32001', '18000', '[8000,8001,18000]', '2020-09-24 00:20:05', '2020-09-24 00:32:55', '2', '2', '1', '2020-09-24 00:32:55.180');
INSERT INTO `production_skill_relation` VALUES ('22002', '32001', '20007', '[8000,8001,20007]', '2020-09-24 00:20:05', '2020-09-24 00:32:55', '2', '2', '1', '2020-09-24 00:32:55.180');
INSERT INTO `production_skill_relation` VALUES ('22003', '30000', '16002', '[8000,8001,16002]', '2020-09-24 00:32:37', '2020-09-24 00:32:37', '2', '2', '0', '2020-09-24 00:32:36.828');
INSERT INTO `production_skill_relation` VALUES ('22004', '30000', '20007', '[8000,8001,20007]', '2020-09-24 00:32:37', '2020-09-24 00:32:37', '2', '2', '0', '2020-09-24 00:32:36.828');
INSERT INTO `production_skill_relation` VALUES ('22005', '32001', '16002', '[8000,8001,16002]', '2020-09-24 00:32:55', '2020-09-24 00:32:55', '2', '2', '0', '2020-09-24 00:32:54.986');
INSERT INTO `production_skill_relation` VALUES ('22006', '32001', '20007', '[8000,8001,20007]', '2020-09-24 00:32:55', '2020-09-24 00:32:55', '2', '2', '0', '2020-09-24 00:32:54.986');

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
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `update_user` bigint(20) DEFAULT '0' COMMENT '修改人ID',
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
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_CODE` (`code`) COMMENT '编码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'wyb', '王一博', 'wyb', null, null, '2020-09-12 18:00:02', '0', '2020-09-13 10:35:19.000', null, null, null);
INSERT INTO `sys_user` VALUES ('2', 'admin', '管理员', '21232f297a57a5a743894a0e4a801fc3', '18888888888', null, '2020-09-13 13:56:20', '0', '2020-09-13 16:07:04.000', null, null, null);
INSERT INTO `sys_user` VALUES ('11', 'o9kHZ5RVsiYjCOnQ_I2BVsYwsq6Y', 'why not', '', 'why not', null, null, '0', '2020-09-26 14:02:27.319', null, null, null);
