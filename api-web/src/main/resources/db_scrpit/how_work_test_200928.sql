/*
Navicat MySQL Data Transfer

Source Server         : 172.21.16.11
Source Server Version : 50718
Source Host           : 172.21.16.11:3306
Source Database       : how_work_test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-09-28 01:11:55
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
) ENGINE=InnoDB AUTO_INCREMENT=30010 DEFAULT CHARSET=utf8 COMMENT='附件表';

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
INSERT INTO `attachment_info` VALUES ('26004', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:55', '2020-09-26 16:52:33', '2', '2', '1', '2020-09-26 16:52:33.251');
INSERT INTO `attachment_info` VALUES ('26005', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-24 00:32:55', '2020-09-26 16:52:33', '2', '2', '1', '2020-09-26 16:52:33.251');
INSERT INTO `attachment_info` VALUES ('28000', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-26 16:52:33', '2020-09-26 16:52:33', '2', '2', '0', '2020-09-26 16:52:33.484');
INSERT INTO `attachment_info` VALUES ('28001', '20', 'CH7HQPQDJ', '1', '', 'test/00001.jpg', 'test/00001.jpg', '2020-09-26 16:52:33', '2020-09-26 16:52:33', '2', '2', '0', '2020-09-26 16:52:33.484');
INSERT INTO `attachment_info` VALUES ('30000', '20', 'BCU3BRQLK', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.264');
INSERT INTO `attachment_info` VALUES ('30001', '20', 'BCU3BRQLK', '1', 'test2', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.264');
INSERT INTO `attachment_info` VALUES ('30002', '20', 'DG2KJSY3S', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 22:07:57', '2020-09-27 22:07:57', '2', '2', '0', '2020-09-27 22:07:56.710');
INSERT INTO `attachment_info` VALUES ('30003', '20', 'DG2KJSY3S', '1', 'test2', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 22:07:57', '2020-09-27 22:07:57', '2', '2', '0', '2020-09-27 22:07:56.710');
INSERT INTO `attachment_info` VALUES ('30004', '20', 'DVAYK55N4', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 22:11:06', '2020-09-27 23:18:13', '2', '2', '1', '2020-09-27 23:18:13.907');
INSERT INTO `attachment_info` VALUES ('30005', '20', 'DVAYK55N4', '1', 'test2', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 22:11:06', '2020-09-27 23:18:13', '2', '2', '1', '2020-09-27 23:18:13.907');
INSERT INTO `attachment_info` VALUES ('30006', '20', 'DVAYK55N4', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 23:18:14', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:14.498');
INSERT INTO `attachment_info` VALUES ('30007', '20', 'DVAYK55N4', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 23:18:14', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:14.498');
INSERT INTO `attachment_info` VALUES ('30008', '20', 'JJY55L4DX', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 23:18:52', '2020-09-27 23:18:52', '2', '2', '0', '2020-09-27 23:18:51.541');
INSERT INTO `attachment_info` VALUES ('30009', '20', 'JJY55L4DX', '1', 'test1', 'test/00001.jpg', 'test/00001.jpg', '2020-09-27 23:18:52', '2020-09-27 23:18:52', '2', '2', '0', '2020-09-27 23:18:51.541');

-- ----------------------------
-- Table structure for bd_job_cate
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_cate`;
CREATE TABLE `bd_job_cate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `cate_name` varchar(50) NOT NULL,
  `english_name` varchar(100) NOT NULL,
  `icon` varchar(30) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=10024 DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Records of bd_job_cate
-- ----------------------------
INSERT INTO `bd_job_cate` VALUES ('10000', '视频', 'video', '123', 'sp', '10', 'ZGEPBSIF', null, 'ZGEP', '2020-09-26 23:07:23', '2020-09-27 00:16:39', '2', '2', '0', '2020-09-27 00:16:41.142');
INSERT INTO `bd_job_cate` VALUES ('10001', '设计', 'design', '22', 'sj', '10', 'GLSQ', null, '', '2020-09-26 23:08:29', '2020-09-27 00:07:26', '2', '2', '0', '2020-09-27 00:07:26.737');
INSERT INTO `bd_job_cate` VALUES ('10002', '运营', 'operation', '33', 'yy', '10', 'WGNNFAWT', null, 'WGNN', '2020-09-26 23:09:25', '2020-09-27 00:07:27', '2', '2', '0', '2020-09-27 00:07:27.532');
INSERT INTO `bd_job_cate` VALUES ('10003', '研发', 'coding', '44', 'yf', '10', 'VFOC', null, '', '2020-09-26 23:10:05', '2020-09-27 00:07:28', '2', '2', '0', '2020-09-27 00:07:28.236');
INSERT INTO `bd_job_cate` VALUES ('10004', '教师', 'teacher', '5', 'js', '10', 'PIDM', null, '', '2020-09-26 23:10:21', '2020-09-27 00:07:28', '2', '2', '0', '2020-09-27 00:07:28.938');
INSERT INTO `bd_job_cate` VALUES ('10005', '短视频编导', '', '', 'dspbd', '20', 'ZGEPXCHO', '10000', 'ZGEP', '2020-09-26 23:11:05', '2020-09-26 23:11:05', '2', '2', '0', '2020-09-26 23:11:05.371');
INSERT INTO `bd_job_cate` VALUES ('10006', '视频拍摄', '', '', 'spps', '20', 'ZGEPEBTH', '10000', 'ZGEP', '2020-09-26 23:11:23', '2020-09-26 23:11:23', '2', '2', '0', '2020-09-26 23:11:23.225');
INSERT INTO `bd_job_cate` VALUES ('10007', '短视频编辑', '', '', 'dspbj', '20', 'ZGEPNJRX', '10000', 'ZGEP', '2020-09-26 23:11:42', '2020-09-26 23:11:42', '2', '2', '0', '2020-09-26 23:11:41.529');
INSERT INTO `bd_job_cate` VALUES ('10008', '海报设计', '', '', 'hbsj', '20', 'GLSQMHNY', '10001', 'GLSQ', '2020-09-26 23:15:38', '2020-09-26 23:15:38', '2', '2', '0', '2020-09-26 23:15:38.336');
INSERT INTO `bd_job_cate` VALUES ('10009', 'Banner广告设计', '', '', 'bggsj', '20', 'GLSQMNWW', '10001', 'GLSQ', '2020-09-26 23:15:59', '2020-09-26 23:15:59', '2', '2', '0', '2020-09-26 23:15:58.964');
INSERT INTO `bd_job_cate` VALUES ('10010', '包装设计', '', '', 'bzsj', '20', 'GLSQZYFN', '10001', 'GLSQ', '2020-09-26 23:16:14', '2020-09-26 23:16:14', '2', '2', '0', '2020-09-26 23:16:14.036');
INSERT INTO `bd_job_cate` VALUES ('10011', '展品设计', '', '', 'zpsj', '20', 'GLSQVBWU', '10001', 'GLSQ', '2020-09-26 23:16:28', '2020-09-26 23:16:28', '2', '2', '0', '2020-09-26 23:16:27.920');
INSERT INTO `bd_job_cate` VALUES ('10012', '文案攥写', '', '', 'wazx', '20', 'WGNNFAWTVAAT', '10002', 'WGNNFAWT', '2020-09-26 23:16:48', '2020-09-26 23:16:48', '2', '2', '0', '2020-09-26 23:16:47.735');
INSERT INTO `bd_job_cate` VALUES ('10013', '活动策划', '', '', 'hdch', '20', 'WGNNFAWTHIMY', '10002', 'WGNNFAWT', '2020-09-26 23:17:03', '2020-09-26 23:17:03', '2', '2', '0', '2020-09-26 23:17:03.262');
INSERT INTO `bd_job_cate` VALUES ('10014', '短视频运营', '', '', 'dspyy', '20', 'WGNNFAWTRMTK', '10002', 'WGNNFAWT', '2020-09-26 23:17:20', '2020-09-26 23:17:20', '2', '2', '0', '2020-09-26 23:17:19.918');
INSERT INTO `bd_job_cate` VALUES ('10015', '社群运营', '', '', 'sqyy', '20', 'WGNNFAWTHQTC', '10002', 'WGNNFAWT', '2020-09-26 23:17:48', '2020-09-26 23:17:48', '2', '2', '0', '2020-09-26 23:17:47.533');
INSERT INTO `bd_job_cate` VALUES ('10017', '小程序开发', '', '', 'xcxkf', '20', 'VFOCPFOV', '10003', 'VFOC', '2020-09-26 23:23:03', '2020-09-26 23:23:03', '2', '2', '0', '2020-09-26 23:23:02.827');
INSERT INTO `bd_job_cate` VALUES ('10018', 'Java开发', '', '', 'jkf', '20', 'VFOCEVQV', '10003', 'VFOC', '2020-09-26 23:23:19', '2020-09-26 23:23:19', '2', '2', '0', '2020-09-26 23:23:19.129');
INSERT INTO `bd_job_cate` VALUES ('10019', 'IOS开发', '', '', 'ikf', '20', 'VFOCBEEL', '10003', 'VFOC', '2020-09-26 23:23:34', '2020-09-26 23:23:34', '2', '2', '0', '2020-09-26 23:23:33.801');
INSERT INTO `bd_job_cate` VALUES ('10020', '安卓开发', '', '', 'akf', '20', 'VFOCUGON', '10003', 'VFOC', '2020-09-26 23:23:48', '2020-09-26 23:23:48', '2', '2', '0', '2020-09-26 23:23:48.425');
INSERT INTO `bd_job_cate` VALUES ('10021', '讲师', '', '', 'js', '20', 'PIDMBFUA', '10004', 'PIDM', '2020-09-26 23:24:01', '2020-09-26 23:24:01', '2', '2', '0', '2020-09-26 23:24:01.443');
INSERT INTO `bd_job_cate` VALUES ('10022', '助教', '', '', 'zj', '20', 'PIDMQKCQ', '10004', 'PIDM', '2020-09-26 23:24:17', '2020-09-26 23:24:17', '2', '2', '0', '2020-09-26 23:24:17.489');
INSERT INTO `bd_job_cate` VALUES ('10023', '外教', '', '', 'wj', '20', 'PIDMBIXR', '10004', 'PIDM', '2020-09-26 23:24:32', '2020-09-26 23:24:32', '2', '2', '0', '2020-09-26 23:24:32.377');

-- ----------------------------
-- Table structure for bd_job_skill
-- ----------------------------
DROP TABLE IF EXISTS `bd_job_skill`;
CREATE TABLE `bd_job_skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `skill_name` varchar(50) NOT NULL,
  `english_name` varchar(100) NOT NULL,
  `icon` varchar(30) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=24001 DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

-- ----------------------------
-- Records of bd_job_skill
-- ----------------------------
INSERT INTO `bd_job_skill` VALUES ('22000', '脚本攥写', '', '', 'jbzx', '10005', 'ZGEPXCHOVXQB', '2020-09-26 23:12:01', '2020-09-26 23:12:01', '2', '2', '0', '2020-09-26 23:12:01.214');
INSERT INTO `bd_job_skill` VALUES ('22001', '热点追踪', '', '', 'rdzz', '10005', 'ZGEPXCHOVKYP', '2020-09-26 23:12:23', '2020-09-26 23:12:23', '2', '2', '0', '2020-09-26 23:12:23.076');
INSERT INTO `bd_job_skill` VALUES ('22002', '内容策划', '', '', 'nrch', '10005', 'ZGEPXCHOSZIM', '2020-09-26 23:12:38', '2020-09-26 23:12:38', '2', '2', '0', '2020-09-26 23:12:38.498');
INSERT INTO `bd_job_skill` VALUES ('22003', '组织拍摄', '', '', 'zzps', '10005', 'ZGEPXCHODRAO', '2020-09-26 23:12:54', '2020-09-26 23:12:54', '2', '2', '0', '2020-09-26 23:12:54.339');
INSERT INTO `bd_job_skill` VALUES ('22004', '布光布景', '', '', 'bgbj', '10006', 'ZGEPEBTHCBDA', '2020-09-26 23:13:27', '2020-09-26 23:13:27', '2', '2', '0', '2020-09-26 23:13:26.769');
INSERT INTO `bd_job_skill` VALUES ('22005', '拍摄风格多元', '', '', 'psfgdy', '10006', 'ZGEPEBTHOCJQ', '2020-09-26 23:13:46', '2020-09-26 23:13:46', '2', '2', '0', '2020-09-26 23:13:46.230');
INSERT INTO `bd_job_skill` VALUES ('22006', '平面拍摄', '', '', 'pmps', '10006', 'ZGEPEBTHKFCC', '2020-09-26 23:14:02', '2020-09-26 23:14:02', '2', '2', '0', '2020-09-26 23:14:02.225');
INSERT INTO `bd_job_skill` VALUES ('22007', '字幕', '', '', 'zm', '10007', 'ZGEPNJRXFKSG', '2020-09-26 23:14:18', '2020-09-26 23:14:18', '2', '2', '0', '2020-09-26 23:14:17.698');
INSERT INTO `bd_job_skill` VALUES ('22008', '配乐', '', '', 'py', '10007', 'ZGEPNJRXODFL', '2020-09-26 23:14:30', '2020-09-26 23:14:30', '2', '2', '0', '2020-09-26 23:14:29.995');
INSERT INTO `bd_job_skill` VALUES ('22009', '视频剪辑', '', '', 'spjj', '10007', 'ZGEPNJRXTEVI', '2020-09-26 23:14:45', '2020-09-26 23:14:45', '2', '2', '0', '2020-09-26 23:14:45.298');
INSERT INTO `bd_job_skill` VALUES ('22010', '视频合成', '', '', 'sphc', '10007', 'ZGEPNJRXOCJG', '2020-09-26 23:15:00', '2020-09-26 23:15:00', '2', '2', '0', '2020-09-26 23:15:00.475');
INSERT INTO `bd_job_skill` VALUES ('22011', '卡点制作', '', '', 'kdzz', '10007', 'ZGEPNJRXHAZX', '2020-09-26 23:15:16', '2020-09-26 23:15:16', '2', '2', '0', '2020-09-26 23:15:16.318');
INSERT INTO `bd_job_skill` VALUES ('24000', '123', '123', '123', '123', '10000', 'ZGEPBSIFBLJH', '2020-09-27 00:17:06', '2020-09-27 00:17:16', '2', '2', '1', '2020-09-27 00:17:16.833');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='展位配置表';

-- ----------------------------
-- Records of display_config
-- ----------------------------
INSERT INTO `display_config` VALUES ('3', '48000', '7', '2025-09-20 16:35:32', '2020-09-20 16:35:37', '2020-09-27 23:29:07', '2', '2', '0', '2020-09-27 23:29:07.511');
INSERT INTO `display_config` VALUES ('4', '48001', '7', '2024-09-20 16:37:10', '2020-09-20 16:37:13', '2020-09-27 23:29:13', '2', null, '0', '2020-09-27 23:29:13.230');
INSERT INTO `display_config` VALUES ('5', '10000', '1', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('6', '10001', '1', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('7', '10002', '1', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('8', '10003', '1', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('9', '10004', '1', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('10', '10005', '2', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('11', '10006', '2', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('12', '10007', '2', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');
INSERT INTO `display_config` VALUES ('13', '10008', '2', '2024-09-27 20:58:45', '2020-09-27 20:58:53', null, '2', null, '0', '2020-09-27 20:58:57.944');

-- ----------------------------
-- Table structure for employer_info
-- ----------------------------
DROP TABLE IF EXISTS `employer_info`;
CREATE TABLE `employer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
  `code` varchar(32) NOT NULL COMMENT '雇佣者编码',
  `name` varchar(32) NOT NULL COMMENT '雇佣者姓名',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
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
) ENGINE=InnoDB AUTO_INCREMENT=6001 DEFAULT CHARSET=utf8 COMMENT='雇佣者信息表';

-- ----------------------------
-- Records of employer_info
-- ----------------------------
INSERT INTO `employer_info` VALUES ('1', '0', '1', '老总', null, '1', '1', '2', '3', '4', '123456789', '2020-09-19 16:59:07', '2020-09-23 23:41:22', '1', '1', '0', '2020-09-23 23:41:22.113');
INSERT INTO `employer_info` VALUES ('33', '11', 'why not', 'why not', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDFo6AERNIMLOl9YC9Wft4icGXlazDWNfSCkLbJicPbEhXDVxnkCgE1QTQrUmNnA6zicH8H1fxeIyFg/132', '', 'Beijing', 'Haidian', '', '', null, '2020-09-26 14:00:41', '2020-09-27 23:54:08', '-1', '-1', '0', '2020-09-27 23:54:06.822');
INSERT INTO `employer_info` VALUES ('6000', '6000', '波英冰', '波英冰', null, '', '', '', '', '', null, '2020-09-26 18:51:12', '2020-09-27 23:22:32', '-1', '-1', '0', '2020-09-27 23:22:32.299');

-- ----------------------------
-- Table structure for freelancer_info
-- ----------------------------
DROP TABLE IF EXISTS `freelancer_info`;
CREATE TABLE `freelancer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联SYS_USER用户表数据',
  `code` varchar(32) NOT NULL COMMENT '自由职业者编码',
  `name` varchar(32) NOT NULL COMMENT '自由职业者姓名',
  `head_img` varchar(255) DEFAULT NULL,
  `skill_summarize` varchar(2000) NOT NULL COMMENT '技能描述',
  `language` tinyint(4) NOT NULL COMMENT '语言',
  `job_cate_id` bigint(20) DEFAULT NULL COMMENT '所属领域',
  `cate_tree_code` varchar(256) DEFAULT '' COMMENT '技能全路径',
  `province_code` varchar(32) NOT NULL DEFAULT '' COMMENT '省份编码',
  `city_code` varchar(32) NOT NULL DEFAULT '' COMMENT '城市编码',
  `district_code` varchar(32) NOT NULL DEFAULT '' COMMENT '区编码',
  `county_code` varchar(32) NOT NULL DEFAULT '' COMMENT '县编码',
  `account_code` varchar(32) NOT NULL DEFAULT '' COMMENT '关联账户(微信登录认证)',
  `phone` varchar(32) DEFAULT '' COMMENT '手机号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12002 DEFAULT CHARSET=utf8 COMMENT='自由职业者信息表';

-- ----------------------------
-- Records of freelancer_info
-- ----------------------------
INSERT INTO `freelancer_info` VALUES ('2', '0', 'wyb', '王一博', null, '测试数据', '1', '1', '1', '1', '1', '1', '1', '1', '18888888888', '2020-09-19 16:11:26', '2020-09-19 16:11:29', '1', '1', '0', '2020-09-19 16:12:12.501');
INSERT INTO `freelancer_info` VALUES ('3', '0', 'xz', '肖战', null, '测试数据', '1', '1', '1', '1', '1', '1', '1', '1', '18888888889', '2020-09-19 16:11:26', '2020-09-19 23:12:27', '1', '1', '0', '2020-09-19 23:12:27.137');
INSERT INTO `freelancer_info` VALUES ('22', '11', 'why not', 'why not', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDFo6AERNIMLOl9YC9Wft4icGXlazDWNfSCkLbJicPbEhXDVxnkCgE1QTQrUmNnA6zicH8H1fxeIyFg/132', '', '0', '0', '', 'Beijing', 'Haidian', '', '', '', null, '2020-09-26 14:00:41', '2020-09-27 23:54:08', '-1', '-1', '0', '2020-09-27 23:54:06.736');
INSERT INTO `freelancer_info` VALUES ('6000', '6000', '波英冰', '波英冰', null, '', '0', '0', '', '', '', '', '', '', null, '2020-09-26 18:51:12', '2020-09-27 23:22:32', '-1', '-1', '0', '2020-09-27 23:22:32.296');
INSERT INTO `freelancer_info` VALUES ('8001', '0', 'test1', '测试名称', null, '为是的', '10', null, '', '', '', '', '', '', '12312321321', '2020-09-27 23:49:10', '2020-09-28 00:00:17', '2', '2', '1', '2020-09-28 00:00:17.092');
INSERT INTO `freelancer_info` VALUES ('10000', '0', 'ld', '刘铎', null, '测试数据', '10', null, '', '', '', '', '', '', '18500229693', '2020-09-28 00:18:18', '2020-09-28 00:19:39', '2', '2', '0', '2020-09-28 00:19:38.229');
INSERT INTO `freelancer_info` VALUES ('12000', '0', 'ys', '亚索', null, '死亡如风常伴吾身', '10', null, '', '', '', '', '', '', '18500229999', '2020-09-28 00:49:12', '2020-09-28 00:49:12', '2', '2', '0', '2020-09-28 00:49:12.062');
INSERT INTO `freelancer_info` VALUES ('12001', '0', 'sly', '赛利亚', null, '我不是使徒！', '10', null, '', '', '', '', '', '', '13888889653', '2020-09-28 00:51:00', '2020-09-28 00:51:13', '2', '2', '0', '2020-09-28 00:51:12.042');

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
INSERT INTO `leaf_alloc` VALUES ('attachment_info', '32000', '2000', null, '2020-09-27 21:55:54');
INSERT INTO `leaf_alloc` VALUES ('bd_job_cate', '12000', '2000', null, '2020-09-26 23:07:24');
INSERT INTO `leaf_alloc` VALUES ('bd_job_skill', '26000', '2000', null, '2020-09-27 00:17:07');
INSERT INTO `leaf_alloc` VALUES ('demand_info', '6000', '2000', null, '2020-09-28 00:35:38');
INSERT INTO `leaf_alloc` VALUES ('demand_production_relation', '18000', '2000', null, '2020-09-21 23:38:24');
INSERT INTO `leaf_alloc` VALUES ('display_config', '2000', '2000', null, '2020-09-19 13:14:41');
INSERT INTO `leaf_alloc` VALUES ('employer_info', '8000', '2000', null, '2020-09-26 18:51:11');
INSERT INTO `leaf_alloc` VALUES ('freelancer_info', '14000', '2000', null, '2020-09-28 00:49:11');
INSERT INTO `leaf_alloc` VALUES ('leaf-segment-test', '1', '2000', 'Test leaf Segment Mode Get Id', '2020-09-10 16:19:14');
INSERT INTO `leaf_alloc` VALUES ('order_follow', '6000', '2000', null, '2020-09-27 23:57:30');
INSERT INTO `leaf_alloc` VALUES ('order_info', '2000', '2000', null, '2020-09-19 13:14:47');
INSERT INTO `leaf_alloc` VALUES ('order_info_detail', '2000', '2000', null, '2020-09-19 13:14:47');
INSERT INTO `leaf_alloc` VALUES ('production_info', '50000', '2000', null, '2020-09-27 21:55:54');
INSERT INTO `leaf_alloc` VALUES ('production_review_info', '18000', '2000', null, '2020-09-27 21:56:07');
INSERT INTO `leaf_alloc` VALUES ('production_skill_relation', '28000', '2000', null, '2020-09-27 21:55:54');
INSERT INTO `leaf_alloc` VALUES ('sys_base_dict', '2000', '2000', null, '2020-09-19 13:14:51');
INSERT INTO `leaf_alloc` VALUES ('sys_user', '8000', '2000', null, '2020-09-26 18:51:11');

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
) ENGINE=InnoDB AUTO_INCREMENT=4001 DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of order_follow
-- ----------------------------
INSERT INTO `order_follow` VALUES ('2000', '1', '20', '1212121', '2020-09-20 16:23:24', '2020-09-20 16:23:24', '2', '2', '0', '2020-09-20 16:23:24.314');
INSERT INTO `order_follow` VALUES ('4000', '10000', '40', null, '2020-09-27 23:57:32', '2020-09-27 23:57:32', '-1', '-1', '0', '2020-09-27 23:57:31.965');

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
  `status` tinyint(4) NOT NULL COMMENT '订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）',
  `order_mny` decimal(20,8) NOT NULL DEFAULT '0.00000000' COMMENT '订单金额',
  `order_price` decimal(20,8) DEFAULT NULL,
  `order_times` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('10000', '002', null, null, '10000', 'ZGEP', '40', '1000.00000000', null, null, '2020-09-20 16:22:21', '2020-09-20 16:22:25', '15', '2', '3', '2020-09-20 16:22:41', '2020-09-27 23:57:32', '11', '-1', '0', '2020-09-27 23:57:30.822');

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
) ENGINE=InnoDB AUTO_INCREMENT=48005 DEFAULT CHARSET=utf8 COMMENT='作品表';

-- ----------------------------
-- Records of production_info
-- ----------------------------
INSERT INTO `production_info` VALUES ('48000', 'BCU3BRQLK', '3', '精通各种编程语言', '没有不会的', '998.00', '40', '10007', '', '2020-09-27 21:55:55', '2020-09-27 21:56:07', '2', '2', '0', '2020-09-27 21:56:07.835');
INSERT INTO `production_info` VALUES ('48001', 'DG2KJSY3S', '2', '视频剪辑', '什么都会剪', '889.00', '40', '10006', '', '2020-09-27 22:07:57', '2020-09-27 22:11:21', '2', '2', '0', '2020-09-27 22:11:21.052');
INSERT INTO `production_info` VALUES ('48002', 'DVAYK55N4', '2', '灯光布景', '梦幻灯光秀', '7796.00', '40', '10005', '', '2020-09-27 22:11:04', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:13.740');
INSERT INTO `production_info` VALUES ('48003', 'LVHKUJAHC', '2', '测试作品', '测试描述', '666.00', '20', '10006', '', '2020-09-27 22:54:12', '2020-09-27 23:18:21', '2', '2', '1', '2020-09-27 23:18:21.726');
INSERT INTO `production_info` VALUES ('48004', 'JJY55L4DX', '3', '测试标题', '测试描述', '9989.00', '40', '10005', '', '2020-09-27 23:18:51', '2020-09-27 23:18:51', '2', '2', '0', '2020-09-27 23:18:51.442');

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
) ENGINE=InnoDB AUTO_INCREMENT=16003 DEFAULT CHARSET=utf8 COMMENT='作品审核表';

-- ----------------------------
-- Records of production_review_info
-- ----------------------------
INSERT INTO `production_review_info` VALUES ('14000', '30000', '2', '必须的', '30', '2020-09-26 16:50:23', '2020-09-26 16:50:23', '2', '2', '0', '2020-09-26 16:50:22.623');
INSERT INTO `production_review_info` VALUES ('14001', '32001', '2', '不行', '20', '2020-09-26 16:52:08', '2020-09-26 16:52:08', '2', '2', '0', '2020-09-26 16:52:07.847');
INSERT INTO `production_review_info` VALUES ('16000', '48000', '2', '通过', '30', '2020-09-27 21:56:08', '2020-09-27 21:56:08', '2', '2', '0', '2020-09-27 21:56:08.264');
INSERT INTO `production_review_info` VALUES ('16001', '48001', '2', '通过', '30', '2020-09-27 22:11:22', '2020-09-27 22:11:22', '2', '2', '0', '2020-09-27 22:11:21.517');
INSERT INTO `production_review_info` VALUES ('16002', '48002', '2', '通过', '30', '2020-09-27 22:11:29', '2020-09-27 22:11:29', '2', '2', '0', '2020-09-27 22:11:28.942');

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
) ENGINE=InnoDB AUTO_INCREMENT=26016 DEFAULT CHARSET=utf8 COMMENT='作品与技能关联表';

-- ----------------------------
-- Records of production_skill_relation
-- ----------------------------
INSERT INTO `production_skill_relation` VALUES ('26000', '48000', '22007', '[10000,10007,22007]', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.159');
INSERT INTO `production_skill_relation` VALUES ('26001', '48000', '22009', '[10000,10007,22009]', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.159');
INSERT INTO `production_skill_relation` VALUES ('26002', '48000', '22010', '[10000,10007,22010]', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.159');
INSERT INTO `production_skill_relation` VALUES ('26003', '48000', '22011', '[10000,10007,22011]', '2020-09-27 21:55:55', '2020-09-27 21:55:55', '2', '2', '0', '2020-09-27 21:55:55.159');
INSERT INTO `production_skill_relation` VALUES ('26004', '48001', '22004', '[10000,10006,22004]', '2020-09-27 22:07:57', '2020-09-27 22:07:57', '2', '2', '0', '2020-09-27 22:07:56.683');
INSERT INTO `production_skill_relation` VALUES ('26005', '48001', '22005', '[10000,10006,22005]', '2020-09-27 22:07:57', '2020-09-27 22:07:57', '2', '2', '0', '2020-09-27 22:07:56.683');
INSERT INTO `production_skill_relation` VALUES ('26006', '48002', '22000', '[10000,10005,22000]', '2020-09-27 22:11:06', '2020-09-27 23:18:13', '2', '2', '1', '2020-09-27 23:18:13.846');
INSERT INTO `production_skill_relation` VALUES ('26007', '48002', '22001', '[10000,10005,22001]', '2020-09-27 22:11:06', '2020-09-27 23:18:13', '2', '2', '1', '2020-09-27 23:18:13.846');
INSERT INTO `production_skill_relation` VALUES ('26008', '48003', '22004', '[10000,10006,22004]', '2020-09-27 22:54:12', '2020-09-27 22:54:12', '2', '2', '0', '2020-09-27 22:54:11.628');
INSERT INTO `production_skill_relation` VALUES ('26009', '48003', '22005', '[10000,10006,22005]', '2020-09-27 22:54:12', '2020-09-27 22:54:12', '2', '2', '0', '2020-09-27 22:54:11.628');
INSERT INTO `production_skill_relation` VALUES ('26010', '48003', '22006', '[10000,10006,22006]', '2020-09-27 22:54:12', '2020-09-27 22:54:12', '2', '2', '0', '2020-09-27 22:54:11.628');
INSERT INTO `production_skill_relation` VALUES ('26011', '48002', '22000', '[10000,10005,22000]', '2020-09-27 23:18:14', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:14.436');
INSERT INTO `production_skill_relation` VALUES ('26012', '48002', '22001', '[10000,10005,22001]', '2020-09-27 23:18:14', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:14.436');
INSERT INTO `production_skill_relation` VALUES ('26013', '48002', '22002', '[10000,10005,22002]', '2020-09-27 23:18:14', '2020-09-27 23:18:14', '2', '2', '0', '2020-09-27 23:18:14.436');
INSERT INTO `production_skill_relation` VALUES ('26014', '48004', '22001', '[10000,10005,22001]', '2020-09-27 23:18:52', '2020-09-27 23:18:52', '2', '2', '0', '2020-09-27 23:18:51.515');
INSERT INTO `production_skill_relation` VALUES ('26015', '48004', '22002', '[10000,10005,22002]', '2020-09-27 23:18:52', '2020-09-27 23:18:52', '2', '2', '0', '2020-09-27 23:18:51.515');

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
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `INDEX_CODE` (`code`) COMMENT '编码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'wyb', '王一博', 'wyb', null, null, '2020-09-12 18:00:02', '0', '2020-09-13 10:35:19.000', null, null, null, null);
INSERT INTO `sys_user` VALUES ('2', 'admin', '管理员', '21232f297a57a5a743894a0e4a801fc3', '18888888888', null, '2020-09-13 13:56:20', '0', '2020-09-13 16:07:04.000', null, null, null, null);
INSERT INTO `sys_user` VALUES ('11', 'o9kHZ5RVsiYjCOnQ_I2BVsYwsq6Y', 'why not', '', 'why not', null, null, '0', '2020-09-27 00:44:30.701', null, null, null, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDFo6AERNIMLOl9YC9Wft4icGXlazDWNfSCkLbJicPbEhXDVxnkCgE1QTQrUmNnA6zicH8H1fxeIyFg/132');
INSERT INTO `sys_user` VALUES ('6000', 'o9kHZ5T2xTZ7jzC-JAZ_gvTWq-Ks', '波英冰', '', '波英冰', null, null, '0', '2020-09-26 18:51:11.721', null, null, null, null);
