/*
 Navicat Premium Data Transfer

 Source Server         : 172.21.16.11
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 172.21.16.11:3306
 Source Schema         : how_work

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/10/2020 15:16:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE=InnoDB AUTO_INCREMENT=22002 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attachment_info
-- ----------------------------
BEGIN;
INSERT INTO `attachment_info` VALUES (2000, 20, '20101417KQ2U5GEEJ', 1, '', 'production/2020-10-14/tmp_1ea8dc4b5eb83218a0050bd9e5235e2c.jpg', 'production/2020-10-14/tmp_1ea8dc4b5eb83218a0050bd9e5235e2c.jpg', '2020-10-14 17:13:34', '2020-10-14 17:13:34', 4000, 4000, 0, '2020-10-14 17:13:34.373');
INSERT INTO `attachment_info` VALUES (2001, 31, '2000', 1, '', 'order/2020-10-14/tmp_d64d20ebf5d1ae30de49debe526b1e90.jpg', 'order/2020-10-14/tmp_d64d20ebf5d1ae30de49debe526b1e90.jpg', '2020-10-14 17:21:01', '2020-10-14 17:21:01', 4000, 4000, 0, '2020-10-14 17:21:00.984');
INSERT INTO `attachment_info` VALUES (2002, 20, '20101417DGDPHJHRD', 1, '', 'production/2020-10-14/tmp_cd29eb6bee5d0b029df34f3c0ce69514.jpg', 'production/2020-10-14/tmp_cd29eb6bee5d0b029df34f3c0ce69514.jpg', '2020-10-14 17:23:27', '2020-10-14 17:23:27', 4001, 4001, 0, '2020-10-14 17:23:27.035');
INSERT INTO `attachment_info` VALUES (2003, 31, '2002', 1, '', 'order/2020-10-14/tmp_cfc7d3ef5c6717612021bf1dab3c732e.jpg', 'order/2020-10-14/tmp_cfc7d3ef5c6717612021bf1dab3c732e.jpg', '2020-10-14 17:25:09', '2020-10-14 17:25:09', 4001, 4001, 0, '2020-10-14 17:25:09.413');
INSERT INTO `attachment_info` VALUES (2004, 31, '2003', 1, '', 'order/2020-10-14/tmp_c0ec447cc7f10dcb279e1c7f29245d95.jpg', 'order/2020-10-14/tmp_c0ec447cc7f10dcb279e1c7f29245d95.jpg', '2020-10-14 17:25:42', '2020-10-14 17:25:42', 4001, 4001, 0, '2020-10-14 17:25:42.086');
INSERT INTO `attachment_info` VALUES (2005, 20, '20101420KKM9DKLVE', 1, '', 'production/2020-10-14/tmp_88a6a4382425f89d147876e2e6bae26da6b028283b434540.jpg', 'production/2020-10-14/tmp_88a6a4382425f89d147876e2e6bae26da6b028283b434540.jpg', '2020-10-14 20:11:20', '2020-10-14 20:11:20', 4013, 4013, 0, '2020-10-14 20:11:20.209');
INSERT INTO `attachment_info` VALUES (2006, 20, '20101421L43FM49JC', 1, '', 'production/2020-10-14/tmp_10470e256db5443b50cd40fbd9179e00.jpg', 'production/2020-10-14/tmp_10470e256db5443b50cd40fbd9179e00.jpg', '2020-10-14 21:14:52', '2020-10-14 21:14:52', 2018, 2018, 0, '2020-10-14 21:14:52.227');
INSERT INTO `attachment_info` VALUES (2007, 20, '20101500DX9FB5NV6', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.BJM111bHSarl09668ff1f5a52ba5a1a17e492ccbca2f.jpg', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.BJM111bHSarl09668ff1f5a52ba5a1a17e492ccbca2f.jpg', '2020-10-15 00:13:30', '2020-10-15 00:13:45', 2022, 2022, 0, '2020-10-15 00:13:30.236');
INSERT INTO `attachment_info` VALUES (2008, 20, '20101500LEHR2R6Z3', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.x6j1jBfyDdjV09668ff1f5a52ba5a1a17e492ccbca2f.jpg', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.x6j1jBfyDdjV09668ff1f5a52ba5a1a17e492ccbca2f.jpg', '2020-10-15 00:27:27', '2020-10-15 00:27:59', 2022, 2022, 1, '2020-10-15 00:27:59.678');
INSERT INTO `attachment_info` VALUES (2009, 20, '20101500L2UNVTMGJ', 1, '', 'production/2020-10-15/tmp_ceb1bfeca761722083b58345af6b9a61.jpg', 'production/2020-10-15/tmp_ceb1bfeca761722083b58345af6b9a61.jpg', '2020-10-15 00:37:11', '2020-10-15 00:37:42', 2015, 2015, 0, '2020-10-15 00:37:10.768');
INSERT INTO `attachment_info` VALUES (2010, 20, '20101500L2UNVTMGJ', 1, '', 'production/2020-10-15/tmp_5aea417b7f0a8df4aa05d135e4036ebd.jpg', 'production/2020-10-15/tmp_5aea417b7f0a8df4aa05d135e4036ebd.jpg', '2020-10-15 00:37:11', '2020-10-15 00:37:26', 2015, 2015, 1, '2020-10-15 00:37:26.059');
INSERT INTO `attachment_info` VALUES (2011, 20, '20101500L2UNVTMGJ', 1, '', 'production/2020-10-15/tmp_9f2c53f71676002170253bdef86cc583.jpg', 'production/2020-10-15/tmp_9f2c53f71676002170253bdef86cc583.jpg', '2020-10-15 00:37:42', '2020-10-15 00:37:42', 2015, 2015, 0, '2020-10-15 00:37:41.726');
INSERT INTO `attachment_info` VALUES (2012, 20, '20101500L2UNVTMGJ', 1, '', 'production/2020-10-15/tmp_4e89711d49a3cb896ac8fe93d67201fc.jpg', 'production/2020-10-15/tmp_4e89711d49a3cb896ac8fe93d67201fc.jpg', '2020-10-15 00:37:42', '2020-10-15 00:37:42', 2015, 2015, 0, '2020-10-15 00:37:41.726');
INSERT INTO `attachment_info` VALUES (4000, 20, '20101416E258ULR9T', 1, '头像.jpg', 'production/2020-10-14/1602668769529.jpg', 'production/2020-10-14/1602668769529_thumbnail.jpg', '2020-10-14 17:21:14', '2020-10-14 17:27:46', 1, 1, 1, '2020-10-14 17:27:46.554');
INSERT INTO `attachment_info` VALUES (4001, 20, '20101416BSTZNNTMK', 1, 'detail_btc7@3x.png', 'production/2020-10-14/1602678134292.png', 'production/2020-10-14/1602678134292_thumbnail.png', '2020-10-14 17:43:34', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4002, 20, '20101416BSTZNNTMK', 1, 'detail_btc5@3x.png', 'production/2020-10-14/1602671876308.png', 'production/2020-10-14/1602671876308_thumbnail.png', '2020-10-14 17:43:34', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4003, 20, '20101416GSNGT96GJ', 1, '韩群 (2).jpg', 'production/2020-10-14/1602671321016.jpg', 'production/2020-10-14/1602671321016_thumbnail.jpg', '2020-10-14 17:45:24', '2020-10-14 19:34:23', 1, 1, 0, '2020-10-14 17:45:24.158');
INSERT INTO `attachment_info` VALUES (4004, 20, '201014164ZTQVRFEQ', 1, '张蕾.jpg', 'production/2020-10-14/1602675145784.jpg', 'production/2020-10-14/1602675145784_thumbnail.jpg', '2020-10-14 17:46:40', '2020-10-15 11:05:30', 1, 1, 1, '2020-10-15 11:05:30.704');
INSERT INTO `attachment_info` VALUES (4005, 20, '20101416BWML373S9', 1, '孙培霖.jpg', 'production/2020-10-14/1602671021897.jpg', 'production/2020-10-14/1602671021897_thumbnail.jpg', '2020-10-14 17:47:35', '2020-10-14 20:15:56', 1, 1, 0, '2020-10-14 17:47:35.125');
INSERT INTO `attachment_info` VALUES (4006, 20, '20101416JMTPRDAAA', 1, '邓雷.jpg', 'production/2020-10-14/1602678983201.jpg', 'production/2020-10-14/1602678983201_thumbnail.jpg', '2020-10-14 17:51:44', '2020-10-19 14:55:06', 1, 1, 1, '2020-10-19 14:55:06.328');
INSERT INTO `attachment_info` VALUES (4007, 20, '20101416BSTZNNTMK', 1, 'detail_btc6@3x.png', 'production/2020-10-14/1602672118683.png', 'production/2020-10-14/1602672118683_thumbnail.png', '2020-10-14 17:59:37', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4008, 20, '20101416BSTZNNTMK', 1, 'detail_btc1.1@3x.png', 'production/2020-10-14/1602678150011.png', 'production/2020-10-14/1602678150011_thumbnail.png', '2020-10-14 17:59:37', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4009, 20, '20101416BSTZNNTMK', 1, 'detail_btc1@3x.png', 'production/2020-10-14/1602674778919.png', 'production/2020-10-14/1602674778919_thumbnail.png', '2020-10-14 17:59:37', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4010, 20, '20101416BSTZNNTMK', 1, 'detail_btc2@3x.png', 'production/2020-10-14/1602673692284.png', 'production/2020-10-14/1602673692284_thumbnail.png', '2020-10-14 17:59:37', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4011, 20, '20101416BSTZNNTMK', 1, 'detail_btc2@3x.png', 'production/2020-10-14/1602678917341.png', 'production/2020-10-14/1602678917341_thumbnail.png', '2020-10-14 17:59:37', '2020-10-14 18:00:12', 1, 1, 1, '2020-10-14 18:00:12.923');
INSERT INTO `attachment_info` VALUES (4012, 20, '20101416BSTZNNTMK', 1, 'detail_btc4@3x.png', 'production/2020-10-14/1602673027912.png', 'production/2020-10-14/1602673027912_thumbnail.png', '2020-10-14 18:00:13', '2020-10-19 14:53:03', 1, 1, 1, '2020-10-19 14:53:03.267');
INSERT INTO `attachment_info` VALUES (4013, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app2@3x.png', 'production/2020-10-14/1602678005776.png', 'production/2020-10-14/1602678005776_thumbnail.png', '2020-10-14 18:08:55', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (4014, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app4@3x.png', 'production/2020-10-14/1602673158388.png', 'production/2020-10-14/1602673158388_thumbnail.png', '2020-10-14 18:08:55', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (4015, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app5@2x.png', 'production/2020-10-14/1602673687094.png', 'production/2020-10-14/1602673687094_thumbnail.png', '2020-10-14 18:08:55', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (4016, 20, '20101416HKU9N9XRL', 1, '海报设计测试图片.png', 'production/2020-10-14/1602673011363.png', 'production/2020-10-14/1602673011363_thumbnail.png', '2020-10-14 18:19:44', '2020-10-18 09:07:59', 1, 1, 1, '2020-10-18 09:07:59.187');
INSERT INTO `attachment_info` VALUES (4017, 20, '20101419E36RUYKU6', 1, '吴雨菲作品集-形象1@3x.png', 'production/2020-10-14/1602682791515.png', 'production/2020-10-14/1602682791515_thumbnail.png', '2020-10-14 19:18:32', '2020-10-14 19:46:57', 1, 1, 0, '2020-10-14 19:18:32.288');
INSERT INTO `attachment_info` VALUES (4018, 20, '20101419E36RUYKU6', 1, '吴雨菲作品集-形象3@3x.png', 'production/2020-10-14/1602676328307.png', 'production/2020-10-14/1602676328307_thumbnail.png', '2020-10-14 19:18:32', '2020-10-14 19:46:57', 1, 1, 0, '2020-10-14 19:18:32.288');
INSERT INTO `attachment_info` VALUES (4019, 20, '20101419E36RUYKU6', 1, '吴雨菲作品集-形象2@3x.png', 'production/2020-10-14/1602674607502.png', 'production/2020-10-14/1602674607502_thumbnail.png', '2020-10-14 19:18:32', '2020-10-14 19:46:57', 1, 1, 0, '2020-10-14 19:18:32.288');
INSERT INTO `attachment_info` VALUES (4020, 20, '20101419E36RUYKU6', 1, '吴雨菲作品集-形象4@3x.png', 'production/2020-10-14/1602680595198.png', 'production/2020-10-14/1602680595198_thumbnail.png', '2020-10-14 19:18:32', '2020-10-14 19:46:57', 1, 1, 0, '2020-10-14 19:18:32.288');
INSERT INTO `attachment_info` VALUES (4021, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app6@3x.png', 'production/2020-10-14/1602684342524.png', 'production/2020-10-14/1602684342524_thumbnail.png', '2020-10-14 19:42:39', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (4022, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app3@3x.png', 'production/2020-10-14/1602678613693.png', 'production/2020-10-14/1602678613693_thumbnail.png', '2020-10-14 19:42:39', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (4023, 20, '201014224PL2GYGQ5', 1, '汤继荣.jpg', 'production/2020-10-14/1602691868294.jpg', 'production/2020-10-14/1602691868294_thumbnail.jpg', '2020-10-14 22:39:10', '2020-10-15 10:00:06', 1, 1, 1, '2020-10-15 10:00:06.616');
INSERT INTO `attachment_info` VALUES (6000, 32, '2000', 1, '', 'appraise/2020-10-14/tmp_871b705ed4efe205fe7918c118fa292a.jpg', 'appraise/2020-10-14/tmp_871b705ed4efe205fe7918c118fa292a.jpg', '2020-10-14 17:21:26', '2020-10-14 17:21:26', 4001, 4001, 0, '2020-10-14 17:21:26.384');
INSERT INTO `attachment_info` VALUES (6001, 31, '4000', 1, '', 'order/2020-10-14/tmp_06b01b8add0a352aab28bf20879e81e5.jpg', 'order/2020-10-14/tmp_06b01b8add0a352aab28bf20879e81e5.jpg', '2020-10-14 17:25:25', '2020-10-14 17:25:25', 4000, 4000, 0, '2020-10-14 17:25:25.055');
INSERT INTO `attachment_info` VALUES (6002, 32, '2001', 1, '', 'appraise/2020-10-14/tmp_918a908dc68a898210b97ef1a4f04308.jpg', 'appraise/2020-10-14/tmp_918a908dc68a898210b97ef1a4f04308.jpg', '2020-10-14 17:26:20', '2020-10-14 17:26:20', 4000, 4000, 0, '2020-10-14 17:26:19.790');
INSERT INTO `attachment_info` VALUES (6003, 20, '201014193VL2QURAP', 1, '', 'production/2020-10-14/tmp_08a7262a9df6d37391c57a9def851367bee1148cf914f024.jpg', 'production/2020-10-14/tmp_08a7262a9df6d37391c57a9def851367bee1148cf914f024.jpg', '2020-10-14 19:55:50', '2020-10-20 17:56:27', 2009, 2009, 1, '2020-10-20 17:56:27.771');
INSERT INTO `attachment_info` VALUES (6004, 20, '20101500LEHR2R6Z3', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.S0Y6ttMgATeu2aa680fd2bc6fc2974b82f7d595cb5a4.jpg', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs_VpI0HSOpGghrPpnju6DGQ.S0Y6ttMgATeu2aa680fd2bc6fc2974b82f7d595cb5a4.jpg', '2020-10-15 00:27:46', '2020-10-15 00:28:00', 2022, 2022, 0, '2020-10-15 00:27:46.107');
INSERT INTO `attachment_info` VALUES (8000, 20, '20101416E258ULR9T', 1, '耕云.jpg', 'production/2020-10-14/1602673686388.jpg', 'production/2020-10-14/1602673686388_thumbnail.jpg', '2020-10-14 17:27:47', '2020-10-15 11:09:58', 1, 1, 1, '2020-10-15 11:09:58.915');
INSERT INTO `attachment_info` VALUES (8001, 20, '20101416A7V5W5DJC', 1, '高艳.jpg', 'production/2020-10-14/1602673769866.jpg', 'production/2020-10-14/1602673769866_thumbnail.jpg', '2020-10-14 17:32:30', '2020-10-14 17:49:31', 1, 1, 1, '2020-10-14 17:49:31.946');
INSERT INTO `attachment_info` VALUES (8002, 20, '20101416H8LCQZR9T', 1, '石磊作品集-形象1@3x.png', 'production/2020-10-14/1602670100550.png', 'production/2020-10-14/1602670100550_thumbnail.png', '2020-10-14 17:34:17', '2020-10-19 14:56:15', 1, 1, 1, '2020-10-19 14:56:15.044');
INSERT INTO `attachment_info` VALUES (8003, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app7@3x.png', 'production/2020-10-14/1602671050979.png', 'production/2020-10-14/1602671050979_thumbnail.png', '2020-10-14 17:37:02', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (8004, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app1@3x.png', 'production/2020-10-14/1602671290303.png', 'production/2020-10-14/1602671290303_thumbnail.png', '2020-10-14 17:37:02', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (8005, 20, '20101416KNQD6GTBH', 1, '帅炜玥 (2).jpg', 'production/2020-10-14/1602674052358.jpg', 'production/2020-10-14/1602674052358_thumbnail.jpg', '2020-10-14 17:39:46', '2020-10-19 14:57:34', 1, 1, 1, '2020-10-19 14:57:34.093');
INSERT INTO `attachment_info` VALUES (8006, 20, '20101416NXHDY6FXU', 1, '张蕾.jpg', 'production/2020-10-14/1602676456892.jpg', 'production/2020-10-14/1602676456892_thumbnail.jpg', '2020-10-14 17:40:45', '2020-10-14 20:02:50', 1, 1, 0, '2020-10-14 17:40:44.785');
INSERT INTO `attachment_info` VALUES (8007, 20, '20101416GSM4J38S5', 1, '王敏佳.jpg', 'production/2020-10-14/1602673005015.jpg', 'production/2020-10-14/1602673005015_thumbnail.jpg', '2020-10-14 17:41:34', '2020-10-14 19:24:14', 1, 1, 0, '2020-10-14 17:41:34.470');
INSERT INTO `attachment_info` VALUES (8008, 20, '20101416A7V5W5DJC', 1, '高艳.jpg', 'production/2020-10-14/1602670775080.jpg', 'production/2020-10-14/1602670775080_thumbnail.jpg', '2020-10-14 17:49:32', '2020-10-19 14:48:15', 1, 1, 1, '2020-10-19 14:48:15.515');
INSERT INTO `attachment_info` VALUES (8009, 20, '20101416KXV3N3G68', 1, '赵宇翀 (2).jpg', 'production/2020-10-14/1602675689929.jpg', 'production/2020-10-14/1602675689929_thumbnail.jpg', '2020-10-14 17:52:34', '2020-10-15 17:26:18', 1, 1, 1, '2020-10-15 17:26:18.831');
INSERT INTO `attachment_info` VALUES (8010, 20, '20101416MQTRENNV6', 1, '张苏 (2).jpg', 'production/2020-10-14/1602677256270.jpg', 'production/2020-10-14/1602677256270_thumbnail.jpg', '2020-10-14 17:55:38', '2020-10-14 19:56:13', 1, 1, 0, '2020-10-14 17:55:37.695');
INSERT INTO `attachment_info` VALUES (8011, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app8@2x.png', 'production/2020-10-14/1602674299120.png', 'production/2020-10-14/1602674299120_thumbnail.png', '2020-10-14 18:14:05', '2020-10-19 14:56:23', 1, 1, 1, '2020-10-19 14:56:23.959');
INSERT INTO `attachment_info` VALUES (8012, 20, '20101419KM52ZW2R9', 1, '吴雨菲作品集-web1@3x.png', 'production/2020-10-14/1602675282573.png', 'production/2020-10-14/1602675282573_thumbnail.png', '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:16:13.584');
INSERT INTO `attachment_info` VALUES (8013, 20, '20101419KM52ZW2R9', 1, '吴雨菲作品集-web4@3x.png', 'production/2020-10-14/1602682146754.png', 'production/2020-10-14/1602682146754_thumbnail.png', '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:16:13.584');
INSERT INTO `attachment_info` VALUES (8014, 20, '20101419KM52ZW2R9', 1, '吴雨菲作品集-web3@3x.png', 'production/2020-10-14/1602677524870.png', 'production/2020-10-14/1602677524870_thumbnail.png', '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:16:13.584');
INSERT INTO `attachment_info` VALUES (8015, 20, '20101419KM52ZW2R9', 1, '吴雨菲作品集-web2@3x.png', 'production/2020-10-14/1602681206735.png', 'production/2020-10-14/1602681206735_thumbnail.png', '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:16:13.584');
INSERT INTO `attachment_info` VALUES (8016, 20, '20101419KM52ZW2R9', 1, '吴雨菲作品集-web5@3x.png', 'production/2020-10-14/1602683601245.png', 'production/2020-10-14/1602683601245_thumbnail.png', '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:16:13.584');
INSERT INTO `attachment_info` VALUES (8017, 20, '20101423GDVH7JWYF', 1, '刘建作品集-4.png', 'production/2020-10-14/1602695605181.png', 'production/2020-10-14/1602695605181_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8018, 20, '20101423GDVH7JWYF', 1, '刘建作品集-2.png', 'production/2020-10-14/1602691037954.png', 'production/2020-10-14/1602691037954_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8019, 20, '20101423GDVH7JWYF', 1, '刘建作品集-1.png', 'production/2020-10-14/1602691565778.png', 'production/2020-10-14/1602691565778_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8020, 20, '20101423GDVH7JWYF', 1, '刘建作品集-5.png', 'production/2020-10-14/1602692305825.png', 'production/2020-10-14/1602692305825_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8021, 20, '20101423GDVH7JWYF', 1, '刘建作品集-3.png', 'production/2020-10-14/1602692527812.png', 'production/2020-10-14/1602692527812_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8022, 20, '20101423GDVH7JWYF', 1, '刘建作品集-6.png', 'production/2020-10-14/1602698045431.png', 'production/2020-10-14/1602698045431_thumbnail.png', '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.550');
INSERT INTO `attachment_info` VALUES (8023, 20, '20101423F6S2FJZ78', 1, '刘威作品集-2.png', 'production/2020-10-14/1602692864342.png', 'production/2020-10-14/1602692864342_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (8024, 20, '20101423F6S2FJZ78', 1, '刘威作品集-3.png', 'production/2020-10-14/1602695673783.png', 'production/2020-10-14/1602695673783_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (8025, 20, '20101423F6S2FJZ78', 1, '刘威作品集-5.png', 'production/2020-10-14/1602694804826.png', 'production/2020-10-14/1602694804826_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (8026, 20, '20101423F6S2FJZ78', 1, '刘威作品集-1.png', 'production/2020-10-14/1602690872425.png', 'production/2020-10-14/1602690872425_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (8027, 20, '20101423F6S2FJZ78', 1, '刘威作品集-4.png', 'production/2020-10-14/1602695931191.png', 'production/2020-10-14/1602695931191_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (8028, 20, '20101423F6S2FJZ78', 1, '刘威作品集-6.png', 'production/2020-10-14/1602688777689.png', 'production/2020-10-14/1602688777689_thumbnail.png', '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.623');
INSERT INTO `attachment_info` VALUES (10000, 20, '20101500DQBYHE4AW', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.INyU89T9fZog3a2fe0130220bba291e7d580d8a5e917.png', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.INyU89T9fZog3a2fe0130220bba291e7d580d8a5e917.png', '2020-10-15 00:58:11', '2020-10-15 01:01:12', 2000, 2000, 1, '2020-10-15 01:01:12.300');
INSERT INTO `attachment_info` VALUES (10001, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', '2020-10-15 00:59:48', '2020-10-15 00:59:57', 2015, 2015, 1, '2020-10-15 00:59:57.867');
INSERT INTO `attachment_info` VALUES (10002, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', '2020-10-15 00:59:48', '2020-10-15 00:59:57', 2015, 2015, 1, '2020-10-15 00:59:57.867');
INSERT INTO `attachment_info` VALUES (10003, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 00:59:48', '2020-10-15 00:59:57', 2015, 2015, 1, '2020-10-15 00:59:57.867');
INSERT INTO `attachment_info` VALUES (10004, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', '2020-10-15 00:59:58', '2020-10-15 01:00:14', 2015, 2015, 1, '2020-10-15 01:00:14.703');
INSERT INTO `attachment_info` VALUES (10005, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', '2020-10-15 00:59:58', '2020-10-15 01:00:14', 2015, 2015, 1, '2020-10-15 01:00:14.703');
INSERT INTO `attachment_info` VALUES (10006, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 00:59:58', '2020-10-15 01:00:14', 2015, 2015, 1, '2020-10-15 01:00:14.703');
INSERT INTO `attachment_info` VALUES (10007, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:00:15', '2020-10-15 01:00:22', 2015, 2015, 1, '2020-10-15 01:00:22.133');
INSERT INTO `attachment_info` VALUES (10008, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:00:22', '2020-10-15 01:00:36', 2015, 2015, 1, '2020-10-15 01:00:36.302');
INSERT INTO `attachment_info` VALUES (10009, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:00:36', '2020-10-15 01:00:44', 2015, 2015, 1, '2020-10-15 01:00:44.499');
INSERT INTO `attachment_info` VALUES (10010, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:00:36', '2020-10-15 01:00:44', 2015, 2015, 1, '2020-10-15 01:00:44.499');
INSERT INTO `attachment_info` VALUES (10011, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:00:45', '2020-10-15 01:03:52', 2015, 2015, 1, '2020-10-15 01:03:52.430');
INSERT INTO `attachment_info` VALUES (10012, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:00:45', '2020-10-15 01:03:52', 2015, 2015, 1, '2020-10-15 01:03:52.430');
INSERT INTO `attachment_info` VALUES (10013, 20, '20101501ATR29CKU6', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.i7FsBgUDmsWl3a2fe0130220bba291e7d580d8a5e917.png', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.i7FsBgUDmsWl3a2fe0130220bba291e7d580d8a5e917.png', '2020-10-15 01:14:58', '2020-10-15 01:14:58', 2000, 2000, 0, '2020-10-15 01:14:58.330');
INSERT INTO `attachment_info` VALUES (10014, 20, '20101513NKCEWZR5V', 1, '', 'production/2020-10-15/tmp_49fb155b48199871262d2c891a4178a718a7ab0e96258d1e.jpg', 'production/2020-10-15/tmp_49fb155b48199871262d2c891a4178a718a7ab0e96258d1e.jpg', '2020-10-15 13:29:40', '2020-10-15 13:29:40', 8027, 8027, 0, '2020-10-15 13:29:39.769');
INSERT INTO `attachment_info` VALUES (10015, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 15:24:26', '2020-10-15 15:26:29', 6001, 6001, 1, '2020-10-15 15:26:29.525');
INSERT INTO `attachment_info` VALUES (10016, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 15:26:30', '2020-10-15 15:37:11', 6001, 6001, 1, '2020-10-15 15:37:11.809');
INSERT INTO `attachment_info` VALUES (10017, 20, '20101809DXUTEBDXF', 1, '', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', '2020-10-18 09:22:12', '2020-10-18 09:26:23', 2007, 2007, 1, '2020-10-18 09:26:23.092');
INSERT INTO `attachment_info` VALUES (10018, 20, '20101809DXUTEBDXF', 1, '', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', '2020-10-18 09:26:23', '2020-10-18 18:04:23', 2007, 2007, 1, '2020-10-18 18:04:23.697');
INSERT INTO `attachment_info` VALUES (10019, 20, '20102010C5Q3KHNS5', 1, '', 'production/2020-10-20/tmp_84ffc72701b8249ae8f0559bfff64b7f.jpg', 'production/2020-10-20/tmp_84ffc72701b8249ae8f0559bfff64b7f.jpg', '2020-10-20 10:25:36', '2020-10-20 10:27:07', 6075, 6075, 1, '2020-10-20 10:27:07.275');
INSERT INTO `attachment_info` VALUES (10020, 20, '20102113HBXDVKSHY', 1, '', 'production/2020-10-21/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201021135416.jpg', 'production/2020-10-21/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201021135416.jpg', '2020-10-21 13:54:38', '2020-10-21 13:54:38', 6079, 6079, 0, '2020-10-21 13:54:38.429');
INSERT INTO `attachment_info` VALUES (10021, 31, '6000', 1, '', 'order/2020-10-22/tmp_524a48da389fce5f7597d15b2d929575.jpg', 'order/2020-10-22/tmp_524a48da389fce5f7597d15b2d929575.jpg', '2020-10-22 22:36:44', '2020-10-22 22:36:44', 2007, 2007, 0, '2020-10-22 22:36:44.451');
INSERT INTO `attachment_info` VALUES (10022, 20, '20102611KSDUHKJ3K', 1, '', 'production/2020-10-26/tmp_7dcc57a5196cc57fb90d9b0f98401d8a.jpg', 'production/2020-10-26/tmp_7dcc57a5196cc57fb90d9b0f98401d8a.jpg', '2020-10-26 11:09:55', '2020-10-26 11:09:55', 6095, 6095, 0, '2020-10-26 11:09:54.533');
INSERT INTO `attachment_info` VALUES (12000, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', 'production/2020-10-15/tmp_bd31bc095a07619858f1530faa74953e.jpg', '2020-10-15 00:59:32', '2020-10-15 00:59:48', 2015, 2015, 1, '2020-10-15 00:59:48.158');
INSERT INTO `attachment_info` VALUES (12001, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', 'production/2020-10-15/tmp_8525ee4951e0570dcc435aa816834821.jpg', '2020-10-15 00:59:32', '2020-10-15 00:59:48', 2015, 2015, 1, '2020-10-15 00:59:48.158');
INSERT INTO `attachment_info` VALUES (12002, 20, '20101501EARMMVXRL', 1, '', 'production/2020-10-15/tmp_1467e9adfa4d0961b4948af7f83c804c.jpg', 'production/2020-10-15/tmp_1467e9adfa4d0961b4948af7f83c804c.jpg', '2020-10-15 01:00:13', '2020-10-15 01:00:55', 2000, 2000, 1, '2020-10-15 01:00:55.752');
INSERT INTO `attachment_info` VALUES (12003, 20, '20101501EARMMVXRL', 1, '', 'production/2020-10-15/tmp_1467e9adfa4d0961b4948af7f83c804c.jpg', 'production/2020-10-15/tmp_1467e9adfa4d0961b4948af7f83c804c.jpg', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.760');
INSERT INTO `attachment_info` VALUES (12004, 20, '20101501EARMMVXRL', 1, '', 'production/2020-10-15/tmp_10a663cde88a1f586ab01cf6d0d0f23e.jpg', 'production/2020-10-15/tmp_10a663cde88a1f586ab01cf6d0d0f23e.jpg', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.760');
INSERT INTO `attachment_info` VALUES (12005, 20, '20101500DQBYHE4AW', 1, '', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.INyU89T9fZog3a2fe0130220bba291e7d580d8a5e917.png', 'production/2020-10-15/wxebd3588df98ae1a7.o6zAJs6MrGfeTqciNsKbK7FuwdHM.INyU89T9fZog3a2fe0130220bba291e7d580d8a5e917.png', '2020-10-15 01:01:12', '2020-10-15 01:01:12', 2000, 2000, 0, '2020-10-15 01:01:12.308');
INSERT INTO `attachment_info` VALUES (12006, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.241');
INSERT INTO `attachment_info` VALUES (12007, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.241');
INSERT INTO `attachment_info` VALUES (12008, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.241');
INSERT INTO `attachment_info` VALUES (12009, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_ccc550d4644be477cddcb2b543a593eb.jpg', 'production/2020-10-15/tmp_ccc550d4644be477cddcb2b543a593eb.jpg', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.241');
INSERT INTO `attachment_info` VALUES (12010, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:07:03', '2020-10-15 01:07:20', 2015, 2015, 1, '2020-10-15 01:07:20.118');
INSERT INTO `attachment_info` VALUES (12011, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:07:03', '2020-10-15 01:07:20', 2015, 2015, 1, '2020-10-15 01:07:20.118');
INSERT INTO `attachment_info` VALUES (12012, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:07:03', '2020-10-15 01:07:20', 2015, 2015, 1, '2020-10-15 01:07:20.118');
INSERT INTO `attachment_info` VALUES (12013, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_ccc550d4644be477cddcb2b543a593eb.jpg', 'production/2020-10-15/tmp_ccc550d4644be477cddcb2b543a593eb.jpg', '2020-10-15 01:07:03', '2020-10-15 01:07:20', 2015, 2015, 1, '2020-10-15 01:07:20.118');
INSERT INTO `attachment_info` VALUES (12014, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:07:20', '2020-10-15 01:07:36', 2015, 2015, 1, '2020-10-15 01:07:36.099');
INSERT INTO `attachment_info` VALUES (12015, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:07:36', '2020-10-15 01:07:36', 2015, 2015, 0, '2020-10-15 01:07:36.110');
INSERT INTO `attachment_info` VALUES (12016, 20, '20101501LM66LELKC', 1, '', 'production/2020-10-15/tmp_9beec243ea516b73257ac5adda21b820.jpg', 'production/2020-10-15/tmp_9beec243ea516b73257ac5adda21b820.jpg', '2020-10-15 01:16:50', '2020-10-15 01:16:50', 2000, 2000, 0, '2020-10-15 01:16:49.916');
INSERT INTO `attachment_info` VALUES (12017, 20, '20101501CNRA6K8V6', 1, '', 'production/2020-10-15/tmp_8eeca62840b0fec81fbeb1199f4b341c.jpg', 'production/2020-10-15/tmp_8eeca62840b0fec81fbeb1199f4b341c.jpg', '2020-10-15 01:26:13', '2020-10-15 01:26:13', 2000, 2000, 0, '2020-10-15 01:26:12.503');
INSERT INTO `attachment_info` VALUES (12018, 20, '20101512CK7LLQ2FQ', 1, '', 'production/2020-10-15/tmp_b205ed156268e4cf00d36a778429cfb48a8191a30227db34.jpg', 'production/2020-10-15/tmp_b205ed156268e4cf00d36a778429cfb48a8191a30227db34.jpg', '2020-10-15 12:37:16', '2020-10-15 12:37:16', 6016, 6016, 0, '2020-10-15 12:37:15.917');
INSERT INTO `attachment_info` VALUES (12019, 20, '20101513F39V493GQ', 1, '', 'production/2020-10-15/tmp_02fb612c2f93f989307a690bff22ab6f87c0b7af9cb22ca9.jpg', 'production/2020-10-15/tmp_02fb612c2f93f989307a690bff22ab6f87c0b7af9cb22ca9.jpg', '2020-10-15 13:22:05', '2020-10-15 13:22:05', 6022, 6022, 0, '2020-10-15 13:22:04.691');
INSERT INTO `attachment_info` VALUES (12020, 20, '20101515DWE94MNGX', 1, '', 'production/2020-10-15/tmp_2afb580a0fd268125af60041e71d64c3.jpg', 'production/2020-10-15/tmp_2afb580a0fd268125af60041e71d64c3.jpg', '2020-10-15 15:06:40', '2020-10-15 15:06:40', 8040, 8040, 0, '2020-10-15 15:06:39.949');
INSERT INTO `attachment_info` VALUES (12021, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 15:37:12', '2020-10-15 15:37:12', 6001, 6001, 0, '2020-10-15 15:37:11.802');
INSERT INTO `attachment_info` VALUES (12022, 20, '201015152T85GNEJ2', 1, '', 'production/2020-10-15/tmp_1d238564f1538a943a0961422da00236.jpg', 'production/2020-10-15/tmp_1d238564f1538a943a0961422da00236.jpg', '2020-10-15 15:56:47', '2020-10-15 15:56:47', 8045, 8045, 0, '2020-10-15 15:56:47.335');
INSERT INTO `attachment_info` VALUES (12023, 20, '20101416KXV3N3G68', 1, '赵宇翀 (2).jpg', 'production/2020-10-14/1602675689929.jpg', 'production/2020-10-14/1602675689929_thumbnail.jpg', '2020-10-15 17:26:19', '2020-10-15 17:26:19', 4006, 4006, 0, '2020-10-15 17:26:18.852');
INSERT INTO `attachment_info` VALUES (12024, 20, '20101606GDVHNTTTM', 1, '', 'production/2020-10-16/tmp_0a31de2d99e5bb3de9a4343eef9c42e4.jpg', 'production/2020-10-16/tmp_0a31de2d99e5bb3de9a4343eef9c42e4.jpg', '2020-10-16 06:25:53', '2020-10-18 14:28:31', 6051, 6051, 1, '2020-10-18 14:28:31.213');
INSERT INTO `attachment_info` VALUES (12025, 20, '20101610L4RPYNPAA', 1, '', 'production/2020-10-16/tmp_f048848c02fd0c963fb51b5987ffdca6.jpg', 'production/2020-10-16/tmp_f048848c02fd0c963fb51b5987ffdca6.jpg', '2020-10-16 10:35:19', '2020-10-16 10:35:19', 4002, 4002, 0, '2020-10-16 10:35:18.545');
INSERT INTO `attachment_info` VALUES (12026, 20, '20101610FMFJNGUQ9', 1, '', 'production/2020-10-16/tmp_ea67b5d5a550cf5f92fcc05bee89bfca0dc0b31b41ac91db.jpg', 'production/2020-10-16/tmp_ea67b5d5a550cf5f92fcc05bee89bfca0dc0b31b41ac91db.jpg', '2020-10-16 10:55:05', '2020-10-23 17:04:57', 6054, 6054, 1, '2020-10-23 17:04:57.483');
INSERT INTO `attachment_info` VALUES (12027, 20, '20101612J9ZEBTETM', 1, '', 'production/2020-10-16/tmp_157e3d8104619f8fd87e3778191353bfe6abdb7045e42149.jpg', 'production/2020-10-16/tmp_157e3d8104619f8fd87e3778191353bfe6abdb7045e42149.jpg', '2020-10-16 12:23:50', '2020-10-16 12:23:50', 6057, 6057, 0, '2020-10-16 12:23:50.439');
INSERT INTO `attachment_info` VALUES (12028, 20, '20101416HKU9N9XRL', 1, '海报设计测试图片.png', 'production/2020-10-14/1602673011363.png', 'production/2020-10-14/1602673011363_thumbnail.png', '2020-10-18 09:07:59', '2020-10-18 09:07:59', 4000, 4000, 0, '2020-10-18 09:07:59.198');
INSERT INTO `attachment_info` VALUES (12029, 20, '20101809DXUTEBDXF', 1, '', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', 'production/2020-10-18/tmp_d5f8b09aca7554103ec72180506393e8.jpg', '2020-10-18 09:21:08', '2020-10-18 09:22:11', 2007, 2007, 1, '2020-10-18 09:22:11.745');
INSERT INTO `attachment_info` VALUES (12030, 20, '20101809DXUTEBDXF', 1, 'WechatIMG67.jpg', 'production/2020-10-18/1603021284678.jpg', 'production/2020-10-18/1603021284678_thumbnail.jpg', '2020-10-18 18:39:44', '2020-10-18 18:39:44', 2007, 2007, 0, '2020-10-18 18:39:44.328');
INSERT INTO `attachment_info` VALUES (12031, 20, '20101909FS6XU2CWU', 1, '', 'production/2020-10-19/tmp_c1b44a5ddaeaefa652fafa462d7bdf310a3605d79ed9f3bf.jpg', 'production/2020-10-19/tmp_c1b44a5ddaeaefa652fafa462d7bdf310a3605d79ed9f3bf.jpg', '2020-10-19 09:53:33', '2020-10-19 09:53:33', 8077, 8077, 0, '2020-10-19 09:53:32.841');
INSERT INTO `attachment_info` VALUES (12032, 20, '20101909FS6XU2CWU', 1, '', 'production/2020-10-19/tmp_5da12fbaa27293d5207b827db1b062150c514c23678f3271.jpg', 'production/2020-10-19/tmp_5da12fbaa27293d5207b827db1b062150c514c23678f3271.jpg', '2020-10-19 09:53:33', '2020-10-19 09:53:33', 8077, 8077, 0, '2020-10-19 09:53:32.841');
INSERT INTO `attachment_info` VALUES (12033, 20, '20101909FS6XU2CWU', 1, '', 'production/2020-10-19/tmp_5e5058682a65143e3883117296b4164e40bf240ed16e56f9.jpg', 'production/2020-10-19/tmp_5e5058682a65143e3883117296b4164e40bf240ed16e56f9.jpg', '2020-10-19 09:53:33', '2020-10-19 09:53:33', 8077, 8077, 0, '2020-10-19 09:53:32.841');
INSERT INTO `attachment_info` VALUES (12034, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140259.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140259.png', '2020-10-19 14:06:38', '2020-10-19 14:09:05', 8078, 8078, 1, '2020-10-19 14:09:05.009');
INSERT INTO `attachment_info` VALUES (12035, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140058.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140058.png', '2020-10-19 14:06:38', '2020-10-19 14:09:05', 8078, 8078, 1, '2020-10-19 14:09:05.009');
INSERT INTO `attachment_info` VALUES (12036, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140126.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140126.png', '2020-10-19 14:06:38', '2020-10-19 14:09:05', 8078, 8078, 1, '2020-10-19 14:09:05.009');
INSERT INTO `attachment_info` VALUES (12037, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140410.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140410.png', '2020-10-19 14:06:38', '2020-10-19 14:09:05', 8078, 8078, 1, '2020-10-19 14:09:05.009');
INSERT INTO `attachment_info` VALUES (12038, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140259.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140259.png', '2020-10-19 14:09:05', '2020-10-19 14:09:05', 8078, 8078, 0, '2020-10-19 14:09:05.019');
INSERT INTO `attachment_info` VALUES (12039, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140058.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140058.png', '2020-10-19 14:09:05', '2020-10-19 14:09:05', 8078, 8078, 0, '2020-10-19 14:09:05.019');
INSERT INTO `attachment_info` VALUES (12040, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140126.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140126.png', '2020-10-19 14:09:05', '2020-10-19 14:09:05', 8078, 8078, 0, '2020-10-19 14:09:05.019');
INSERT INTO `attachment_info` VALUES (12041, 20, '20101914L5KSAF6K2', 1, '', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140410.png', 'production/2020-10-19/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20201019140410.png', '2020-10-19 14:09:05', '2020-10-19 14:09:05', 8078, 8078, 0, '2020-10-19 14:09:05.020');
INSERT INTO `attachment_info` VALUES (12042, 20, '20102010C5Q3KHNS5', 1, '', 'production/2020-10-20/tmp_84ffc72701b8249ae8f0559bfff64b7f.jpg', 'production/2020-10-20/tmp_84ffc72701b8249ae8f0559bfff64b7f.jpg', '2020-10-20 10:27:07', '2020-10-20 17:57:33', 6075, 6075, 1, '2020-10-20 17:57:33.962');
INSERT INTO `attachment_info` VALUES (12043, 20, '20102219JHGWUU4LZ', 1, '', 'production/2020-10-22/tmp_31cb6945bd89a2771c8a8d951d6c483205989da2cb9a25d1.jpg', 'production/2020-10-22/tmp_31cb6945bd89a2771c8a8d951d6c483205989da2cb9a25d1.jpg', '2020-10-22 19:42:49', '2020-10-22 19:42:49', 8099, 8099, 0, '2020-10-22 19:42:49.118');
INSERT INTO `attachment_info` VALUES (12044, 20, '20102307F3MWGZWFB', 1, '', 'production/2020-10-23/tmp_ade328d4146da5509eecbd25183d687921074cc5b05d4d11.jpg', 'production/2020-10-23/tmp_ade328d4146da5509eecbd25183d687921074cc5b05d4d11.jpg', '2020-10-23 07:41:08', '2020-10-23 07:41:08', 6010, 6010, 0, '2020-10-23 07:41:08.129');
INSERT INTO `attachment_info` VALUES (12045, 20, '20102313AKEEZZXUM', 1, '', 'production/2020-10-23/tmp_6f75a74c78aa05b9378eb4aeff9cef10.jpg', 'production/2020-10-23/tmp_6f75a74c78aa05b9378eb4aeff9cef10.jpg', '2020-10-23 13:29:58', '2020-10-23 13:29:58', 4000, 4000, 0, '2020-10-23 13:29:58.417');
INSERT INTO `attachment_info` VALUES (12046, 20, '20102611EXHJ8AMVM', 1, '', 'production/2020-10-26/tmp_dcf2b74d6f52ff625689243626b28d27.jpg', 'production/2020-10-26/tmp_dcf2b74d6f52ff625689243626b28d27.jpg', '2020-10-26 11:06:59', '2020-10-26 11:06:59', 6095, 6095, 0, '2020-10-26 11:06:59.248');
INSERT INTO `attachment_info` VALUES (14000, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:03:52', '2020-10-15 01:03:57', 1, 1, 1, '2020-10-15 01:03:57.719');
INSERT INTO `attachment_info` VALUES (14001, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:03:52', '2020-10-15 01:03:57', 1, 1, 1, '2020-10-15 01:03:57.719');
INSERT INTO `attachment_info` VALUES (14002, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:03:52', '2020-10-15 01:03:57', 1, 1, 1, '2020-10-15 01:03:57.719');
INSERT INTO `attachment_info` VALUES (14003, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', 'production/2020-10-15/tmp_fef70c103e47e7762b6ee51cceadd271.jpg', '2020-10-15 01:03:58', '2020-10-15 01:06:44', 1, 1, 1, '2020-10-15 01:06:44.396');
INSERT INTO `attachment_info` VALUES (14004, 20, '201015004B7WAJLN4', 1, '', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', 'production/2020-10-15/tmp_df3b4ca559b997d4eec529ad5a610cd5.jpg', '2020-10-15 01:03:58', '2020-10-15 01:06:44', 1, 1, 1, '2020-10-15 01:06:44.396');
INSERT INTO `attachment_info` VALUES (14005, 20, '201015004B7WAJLN4', 1, 'QQ图片20200821165141.png', 'production/2020-10-15/1602700254627.png', 'production/2020-10-15/1602700254627_thumbnail.png', '2020-10-15 01:03:58', '2020-10-15 01:06:44', 1, 1, 1, '2020-10-15 01:06:44.396');
INSERT INTO `attachment_info` VALUES (16000, 20, '201014224PL2GYGQ5', 1, '汤继荣.jpg', 'production/2020-10-14/1602691868294.jpg', 'production/2020-10-14/1602691868294_thumbnail.jpg', '2020-10-15 10:00:07', '2020-10-15 11:22:54', 1, 1, 1, '2020-10-15 11:22:54.949');
INSERT INTO `attachment_info` VALUES (16001, 20, '20101510BTLEYWDTE', 1, '2-白海芳.jpg', 'production/2020-10-15/1602730590758.jpg', 'production/2020-10-15/1602730590758_thumbnail.jpg', '2020-10-15 10:04:48', '2020-10-15 10:04:48', 1, 1, 0, '2020-10-15 10:04:48.234');
INSERT INTO `attachment_info` VALUES (16002, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 10:11:05', '2020-10-15 11:06:23', 1, 1, 1, '2020-10-15 11:06:23.789');
INSERT INTO `attachment_info` VALUES (16003, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 11:06:24', '2020-10-15 11:07:17', 1, 1, 1, '2020-10-15 11:07:17.842');
INSERT INTO `attachment_info` VALUES (16004, 20, '20101416E258ULR9T', 1, '耕云.jpg', 'production/2020-10-14/1602673686388.jpg', 'production/2020-10-14/1602673686388_thumbnail.jpg', '2020-10-15 11:09:59', '2020-10-15 11:09:59', 1, 1, 0, '2020-10-15 11:09:58.925');
INSERT INTO `attachment_info` VALUES (16005, 20, '20101606GDVHNTTTM', 1, '人力资源作品2.png', 'production/2020-10-18/1603003515525.png', 'production/2020-10-18/1603003515525_thumbnail.png', '2020-10-18 14:28:31', '2020-10-18 14:28:31', 1, 1, 0, '2020-10-18 14:28:31.236');
INSERT INTO `attachment_info` VALUES (16006, 20, '20101809DXUTEBDXF', 1, 'WechatIMG67.jpg', 'production/2020-10-18/1603021284678.jpg', 'production/2020-10-18/1603021284678_thumbnail.jpg', '2020-10-18 18:04:24', '2020-10-18 18:39:44', 1, 1, 1, '2020-10-18 18:39:44.334');
INSERT INTO `attachment_info` VALUES (16007, 20, '20101416BSTZNNTMK', 1, 'detail_btc7@3x.png', 'production/2020-10-14/1602678134292.png', 'production/2020-10-14/1602678134292_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16008, 20, '20101416BSTZNNTMK', 1, 'detail_btc5@3x.png', 'production/2020-10-14/1602671876308.png', 'production/2020-10-14/1602671876308_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16009, 20, '20101416BSTZNNTMK', 1, 'detail_btc6@3x.png', 'production/2020-10-14/1602672118683.png', 'production/2020-10-14/1602672118683_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16010, 20, '20101416BSTZNNTMK', 1, 'detail_btc1.1@3x.png', 'production/2020-10-14/1602678150011.png', 'production/2020-10-14/1602678150011_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16011, 20, '20101416BSTZNNTMK', 1, 'detail_btc1@3x.png', 'production/2020-10-14/1602674778919.png', 'production/2020-10-14/1602674778919_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16012, 20, '20101416BSTZNNTMK', 1, 'detail_btc2@3x.png', 'production/2020-10-14/1602673692284.png', 'production/2020-10-14/1602673692284_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16013, 20, '20101416BSTZNNTMK', 1, 'detail_btc4@3x.png', 'production/2020-10-14/1602673027912.png', 'production/2020-10-14/1602673027912_thumbnail.png', '2020-10-19 14:53:03', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.270');
INSERT INTO `attachment_info` VALUES (16014, 20, '20101416H8LCQZR9T', 1, '石磊作品集-形象1@3x.png', 'production/2020-10-14/1602670100550.png', 'production/2020-10-14/1602670100550_thumbnail.png', '2020-10-19 14:56:15', '2020-10-19 14:56:15', 1, 1, 0, '2020-10-19 14:56:15.048');
INSERT INTO `attachment_info` VALUES (16015, 20, '20101416KNQD6GTBH', 1, '帅炜玥 (2).jpg', 'production/2020-10-14/1602674052358.jpg', 'production/2020-10-14/1602674052358_thumbnail.jpg', '2020-10-19 14:57:34', '2020-10-19 14:57:34', 1, 1, 0, '2020-10-19 14:57:34.097');
INSERT INTO `attachment_info` VALUES (16016, 20, '20102010C5Q3KHNS5', 1, '3-七月WYJ.jpg', 'production/2020-10-20/1603192752872.jpg', 'production/2020-10-20/1603192752872_thumbnail.jpg', '2020-10-20 17:57:34', '2020-10-20 17:57:34', 1, 1, 0, '2020-10-20 17:57:33.967');
INSERT INTO `attachment_info` VALUES (18000, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 10:07:31', '2020-10-15 10:11:05', 1, 1, 1, '2020-10-15 10:11:05.105');
INSERT INTO `attachment_info` VALUES (18001, 20, '20101510AVLE5A58G', 1, '2-黄婷.jpg', 'production/2020-10-15/1602732564354.jpg', 'production/2020-10-15/1602732564354_thumbnail.jpg', '2020-10-15 10:08:34', '2020-10-15 14:07:56', 1, 1, 1, '2020-10-15 14:07:56.602');
INSERT INTO `attachment_info` VALUES (18002, 20, '201014164ZTQVRFEQ', 1, '张蕾-new.jpg', 'production/2020-10-15/1602732915081.jpg', 'production/2020-10-15/1602732915081_thumbnail.jpg', '2020-10-15 11:05:31', '2020-10-15 11:05:31', 1, 1, 0, '2020-10-15 11:05:30.712');
INSERT INTO `attachment_info` VALUES (18003, 20, '20101510C92QKZJUM', 1, '2-冯宁.jpg', 'production/2020-10-15/1602735541022.jpg', 'production/2020-10-15/1602735541022_thumbnail.jpg', '2020-10-15 11:07:18', '2020-10-15 15:24:25', 1, 1, 1, '2020-10-15 15:24:25.874');
INSERT INTO `attachment_info` VALUES (18004, 20, '201014224PL2GYGQ5', 1, '汤继荣.jpg', 'production/2020-10-14/1602691868294.jpg', 'production/2020-10-14/1602691868294_thumbnail.jpg', '2020-10-15 11:22:55', '2020-10-17 00:35:44', 1, 1, 1, '2020-10-17 00:35:44.987');
INSERT INTO `attachment_info` VALUES (18005, 20, '20101510AVLE5A58G', 1, '2-黄婷.jpg', 'production/2020-10-15/1602732564354.jpg', 'production/2020-10-15/1602732564354_thumbnail.jpg', '2020-10-15 14:07:57', '2020-10-15 14:07:57', 1, 1, 0, '2020-10-15 14:07:56.613');
INSERT INTO `attachment_info` VALUES (18006, 20, '201014224PL2GYGQ5', 1, '汤继荣.jpg', 'production/2020-10-14/1602691868294.jpg', 'production/2020-10-14/1602691868294_thumbnail.jpg', '2020-10-17 00:35:45', '2020-10-19 15:00:00', 1, 1, 1, '2020-10-19 15:00:00.486');
INSERT INTO `attachment_info` VALUES (18007, 20, '20101416A7V5W5DJC', 1, '高艳.jpg', 'production/2020-10-14/1602670775080.jpg', 'production/2020-10-14/1602670775080_thumbnail.jpg', '2020-10-19 14:48:16', '2020-10-23 10:01:12', 1, 1, 1, '2020-10-23 10:01:12.460');
INSERT INTO `attachment_info` VALUES (18008, 20, '20101416JMTPRDAAA', 1, '邓雷.jpg', 'production/2020-10-14/1602678983201.jpg', 'production/2020-10-14/1602678983201_thumbnail.jpg', '2020-10-19 14:55:06', '2020-10-19 14:55:06', 1, 1, 0, '2020-10-19 14:55:06.331');
INSERT INTO `attachment_info` VALUES (18009, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app2@3x.png', 'production/2020-10-14/1602678005776.png', 'production/2020-10-14/1602678005776_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18010, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app4@3x.png', 'production/2020-10-14/1602673158388.png', 'production/2020-10-14/1602673158388_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18011, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app5@2x.png', 'production/2020-10-14/1602673687094.png', 'production/2020-10-14/1602673687094_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18012, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app6@3x.png', 'production/2020-10-14/1602684342524.png', 'production/2020-10-14/1602684342524_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18013, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app3@3x.png', 'production/2020-10-14/1602678613693.png', 'production/2020-10-14/1602678613693_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18014, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app7@3x.png', 'production/2020-10-14/1602671050979.png', 'production/2020-10-14/1602671050979_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18015, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app1@3x.png', 'production/2020-10-14/1602671290303.png', 'production/2020-10-14/1602671290303_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18016, 20, '20101417D2GY4Z6Z3', 1, '石磊作品集-app8@2x.png', 'production/2020-10-14/1602674299120.png', 'production/2020-10-14/1602674299120_thumbnail.png', '2020-10-19 14:56:24', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.962');
INSERT INTO `attachment_info` VALUES (18017, 20, '201014224PL2GYGQ5', 1, '汤继荣.jpg', 'production/2020-10-14/1602691868294.jpg', 'production/2020-10-14/1602691868294_thumbnail.jpg', '2020-10-19 15:00:00', '2020-10-19 15:00:00', 1, 1, 0, '2020-10-19 15:00:00.491');
INSERT INTO `attachment_info` VALUES (18018, 20, '201014193VL2QURAP', 1, '1-王亚东.jpg', 'production/2020-10-20/1603195973140.jpg', 'production/2020-10-20/1603195973140_thumbnail.jpg', '2020-10-20 17:56:28', '2020-10-20 17:56:28', 1, 1, 0, '2020-10-20 17:56:27.775');
INSERT INTO `attachment_info` VALUES (20000, 20, '20101416A7V5W5DJC', 1, '高艳.jpg', 'production/2020-10-14/1602670775080.jpg', 'production/2020-10-14/1602670775080_thumbnail.jpg', '2020-10-23 10:01:12', '2020-10-23 10:01:12', 1, 1, 0, '2020-10-23 10:01:12.471');
INSERT INTO `attachment_info` VALUES (22000, 20, '20101610FMFJNGUQ9', 1, '3-雪迈.jpg', 'production/2020-10-23/1603445228398.jpg', 'production/2020-10-23/1603445228398_thumbnail.jpg', '2020-10-23 17:04:58', '2020-10-23 17:04:58', 1, 1, 0, '2020-10-23 17:04:57.504');
INSERT INTO `attachment_info` VALUES (22001, 20, '20102317B4BP3TUJR', 1, '3-郭美美.jpg', 'production/2020-10-23/1603454217514.jpg', 'production/2020-10-23/1603454217514_thumbnail.jpg', '2020-10-23 17:16:13', '2020-10-23 17:16:13', 1, 1, 0, '2020-10-23 17:16:13.152');
COMMIT;

-- ----------------------------
-- Table structure for bd_job_cate
-- ----------------------------
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

-- ----------------------------
-- Records of bd_job_cate
-- ----------------------------
BEGIN;
INSERT INTO `bd_job_cate` VALUES (6000, '专家类', '专家类', '', '20101416NNM9QYTEJ', 10, 'CRIM', NULL, '', '2020-10-14 16:12:36', '2020-10-14 16:15:43', 1, 1, 0, '2020-10-14 16:15:42.507');
INSERT INTO `bd_job_cate` VALUES (6001, '设计类', '设计类', '', '201014163WMH4DPPD', 10, 'NCDI', NULL, '', '2020-10-14 16:13:13', '2020-10-14 16:13:13', 1, 1, 0, '2020-10-14 16:13:12.548');
INSERT INTO `bd_job_cate` VALUES (6002, '运营类', '运营类', '', '20101416JLJNTHMSL', 10, 'ROBD', NULL, '', '2020-10-14 16:13:57', '2020-10-14 16:13:57', 1, 1, 0, '2020-10-14 16:13:57.434');
INSERT INTO `bd_job_cate` VALUES (6003, '团队教练', 'Team Coach', '', '20101416DF7RAJ5GB', 20, 'CRIMAIVO', 6000, 'CRIM', '2020-10-14 16:16:59', '2020-10-14 16:16:59', 1, 1, 0, '2020-10-14 16:16:58.974');
INSERT INTO `bd_job_cate` VALUES (6004, '云测评1', '云测评', '', '201014163XJGM3QDJ', 20, 'CRIMXMXV', 6000, 'CRIM', '2020-10-14 16:17:43', '2020-10-21 18:38:37', 1, 1, 1, '2020-10-21 18:38:37.737');
INSERT INTO `bd_job_cate` VALUES (6005, '云发展', '云发展', '', '20101416JWE9QR23S', 20, 'CRIMYUYP', 6000, 'CRIM', '2020-10-14 16:18:09', '2020-10-21 18:39:03', 1, 1, 1, '2020-10-21 18:39:03.755');
INSERT INTO `bd_job_cate` VALUES (6006, '品牌设计师', 'Brand Designer', '', '20101416LK8256SP5', 20, 'NCDIYQHC', 6001, 'NCDI', '2020-10-14 16:18:57', '2020-10-14 16:18:57', 1, 1, 0, '2020-10-14 16:18:57.321');
INSERT INTO `bd_job_cate` VALUES (6007, '电商运营', '电商运营', '', '201014162XCM8A34P', 20, 'ROBDIXAL', 6002, 'ROBD', '2020-10-14 16:20:28', '2020-10-14 16:20:28', 1, 1, 0, '2020-10-14 16:20:28.097');
INSERT INTO `bd_job_cate` VALUES (6008, '内容运营', '内容运营', '', '20101416ABGPCU5KC', 20, 'ROBDPPJR', 6002, 'ROBD', '2020-10-14 16:21:14', '2020-10-14 16:21:14', 1, 1, 0, '2020-10-14 16:21:14.486');
INSERT INTO `bd_job_cate` VALUES (6009, '服务端研发', 'Server R&D', '', '20101416NT3MRCGQ5', 20, 'YNEHZKYE', 8001, 'YNEH', '2020-10-14 16:23:43', '2020-10-14 16:23:43', 1, 1, 0, '2020-10-14 16:23:42.803');
INSERT INTO `bd_job_cate` VALUES (6010, '小程序研发', 'Mini Program R&D', '', '20101416GWMMYGHFB', 20, 'YNEHIQHD', 8001, 'YNEH', '2020-10-14 16:24:37', '2020-10-14 16:24:37', 1, 1, 0, '2020-10-14 16:24:37.364');
INSERT INTO `bd_job_cate` VALUES (6011, '视频拍摄', 'Video Photographer', '', '20101417FTC6GTHYF', 20, 'FWKJZHBE', 8000, 'FWKJ', '2020-10-14 17:00:53', '2020-10-14 17:00:53', 1, 1, 0, '2020-10-14 17:00:52.841');
INSERT INTO `bd_job_cate` VALUES (8000, '视频类', '视频类', '', '201014164W93RYDM4', 10, 'FWKJ', NULL, '', '2020-10-14 16:12:54', '2020-10-14 16:12:54', 1, 1, 0, '2020-10-14 16:12:53.556');
INSERT INTO `bd_job_cate` VALUES (8001, '研发类', '研发类', '', '20101416LHT2TRSW7', 10, 'YNEH', NULL, '', '2020-10-14 16:13:41', '2020-10-14 16:13:41', 1, 1, 0, '2020-10-14 16:13:41.295');
INSERT INTO `bd_job_cate` VALUES (8002, '市场营销专家', 'Executive Coach', '', '20101416FXF34XL4A', 20, 'CRIMKYLF', 6000, 'CRIM', '2020-10-14 16:17:33', '2020-10-14 16:17:33', 1, 1, 0, '2020-10-14 16:17:32.870');
INSERT INTO `bd_job_cate` VALUES (8003, '云HR', '云HR', '', '201014162GH479BPL', 20, 'CRIMFRQL', 6000, 'CRIM', '2020-10-14 16:17:55', '2020-10-14 16:17:55', 1, 1, 0, '2020-10-14 16:17:54.710');
INSERT INTO `bd_job_cate` VALUES (8004, '管理咨询顾问', '管理咨询顾问', '', '20101416DJJYCYHFB', 20, 'CRIMMMHX', 6000, 'CRIM', '2020-10-14 16:18:25', '2020-10-14 16:18:25', 1, 1, 0, '2020-10-14 16:18:25.189');
INSERT INTO `bd_job_cate` VALUES (8005, 'UI设计师', 'UI Designer', '', '20101416BFWRLETTM', 20, 'NCDIQCYF', 6001, 'NCDI', '2020-10-14 16:20:04', '2020-10-14 16:20:04', 1, 1, 0, '2020-10-14 16:20:04.203');
INSERT INTO `bd_job_cate` VALUES (8006, '商务服务', '商务服务', '', '20101416ADVRYRPAA', 20, 'ROBDUATH', 6002, 'ROBD', '2020-10-14 16:20:41', '2020-10-14 16:20:41', 1, 1, 0, '2020-10-14 16:20:41.454');
INSERT INTO `bd_job_cate` VALUES (8007, '视频编辑', 'Video Editor', '', '201014163Y7MN5KY7', 20, 'FWKJZCYN', 8000, 'FWKJ', '2020-10-14 16:21:45', '2020-10-14 16:21:45', 1, 1, 0, '2020-10-14 16:21:45.290');
INSERT INTO `bd_job_cate` VALUES (8008, 'Web端研发', 'Web R&D', '', '2010141646QDXYAL4', 20, 'YNEHMBRO', 8001, 'YNEH', '2020-10-14 16:24:20', '2020-10-14 16:24:20', 1, 1, 0, '2020-10-14 16:24:20.342');
INSERT INTO `bd_job_cate` VALUES (8009, '移动端研发', 'Mobile R&D', '', '20101416H2UJDVRAP', 20, 'YNEHCLPC', 8001, 'YNEH', '2020-10-14 16:24:55', '2020-10-14 16:24:55', 1, 1, 0, '2020-10-14 16:24:55.042');
INSERT INTO `bd_job_cate` VALUES (10000, '网页设计师', '网页设计师', '', '20101419H2GM7CSW7', 20, 'NCDIMXMS', 6001, 'NCDI', '2020-10-14 19:13:04', '2020-10-14 19:13:04', 1, 1, 0, '2020-10-14 19:13:04.409');
INSERT INTO `bd_job_cate` VALUES (10001, '法务专家', '法务专家', '', '20101422JTJR3EB5N', 20, 'CRIMMHFD', 6000, 'CRIM', '2020-10-14 22:39:36', '2020-10-14 22:39:36', 1, 1, 0, '2020-10-14 22:39:35.540');
INSERT INTO `bd_job_cate` VALUES (10002, '建筑设计师', '建筑设计师', '', '20101423E4FSS5KY7', 20, 'NCDIPNKA', 6001, 'NCDI', '2020-10-14 23:10:37', '2020-10-14 23:11:57', 1, 1, 0, '2020-10-14 23:11:57.367');
INSERT INTO `bd_job_cate` VALUES (12000, '企业教练', '企业教练', '', '20101420JPN22AG68', 20, 'CRIMDWZZ', 6000, 'CRIM', '2020-10-14 20:02:09', '2020-10-14 20:02:09', 1, 1, 0, '2020-10-14 20:02:09.435');
INSERT INTO `bd_job_cate` VALUES (14000, '11111111', '', '', '201018224CQVC57S9', 10, 'YWKM', NULL, '', '2020-10-18 22:05:08', '2020-10-18 22:06:01', 1, 1, 1, '2020-10-18 22:06:01.129');
INSERT INTO `bd_job_cate` VALUES (16000, '222222222222', '', '', '20101822HAM9DJJCH', 20, 'YWKMROFQ', 14000, 'YWKM', '2020-10-18 22:05:24', '2020-10-18 22:05:57', 1, 1, 1, '2020-10-18 22:05:57.864');
INSERT INTO `bd_job_cate` VALUES (18000, '其他', '其他', '', '20102309FTPF3LNGX', 20, 'CRIMGBNV', 6000, 'CRIM', '2020-10-23 09:47:34', '2020-10-23 09:47:34', 1, 1, 0, '2020-10-23 09:47:33.774');
INSERT INTO `bd_job_cate` VALUES (18001, '其他', '其他', '', '20102309GEAA8VADB', 20, 'ROBDRAWH', 6002, 'ROBD', '2020-10-23 09:47:56', '2020-10-23 09:47:56', 1, 1, 0, '2020-10-23 09:47:56.358');
INSERT INTO `bd_job_cate` VALUES (18002, '其他', '其他', '', '20102309AG28XH4W7', 20, 'YNEHOYXQ', 8001, 'YNEH', '2020-10-23 09:48:31', '2020-10-23 09:49:26', 1, 1, 1, '2020-10-23 09:49:26.870');
INSERT INTO `bd_job_cate` VALUES (18003, '其他', '其他', '', '20102309GGBK5554A', 20, 'YNEHPXRY', 8001, 'YNEH', '2020-10-23 09:49:35', '2020-10-23 09:49:59', 1, 1, 1, '2020-10-23 09:49:59.224');
INSERT INTO `bd_job_cate` VALUES (20000, '其他', '其他', '', '20102309DTFCAC5VE', 20, 'NCDIETUH', 6001, 'NCDI', '2020-10-23 09:47:46', '2020-10-23 09:47:46', 1, 1, 0, '2020-10-23 09:47:46.212');
INSERT INTO `bd_job_cate` VALUES (20001, '其他', '其他', '', '201023092LFNF7RLS', 20, 'FWKJIPSO', 8000, 'FWKJ', '2020-10-23 09:48:08', '2020-10-23 09:48:08', 1, 1, 0, '2020-10-23 09:48:07.825');
COMMIT;

-- ----------------------------
-- Table structure for bd_job_skill
-- ----------------------------
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

-- ----------------------------
-- Records of bd_job_skill
-- ----------------------------
BEGIN;
INSERT INTO `bd_job_skill` VALUES (6000, '能力测评', '能力测评', '', '20101416NUUMML6Z3', 6004, 'CRIMXMXVURRO', 'CRIMXMXV', '2020-10-14 16:25:40', '2020-10-21 16:44:50', 1, 1, 1, '2020-10-21 16:44:50.890');
INSERT INTO `bd_job_skill` VALUES (6001, '领导力测评', '领导力测评', '', '20101416LZG9DNUQ9', 6004, 'CRIMXMXVEMYP', 'CRIMXMXV', '2020-10-14 16:26:07', '2020-10-21 18:38:33', 1, 1, 1, '2020-10-21 18:38:33.994');
INSERT INTO `bd_job_skill` VALUES (6002, '互联网通用人才', '互联网通用人才', '', '201014162VX246AHC', 8003, 'CRIMFRQLHLBK', 'CRIMFRQL', '2020-10-14 16:26:40', '2020-10-14 16:26:40', 1, 1, 0, '2020-10-14 16:26:39.805');
INSERT INTO `bd_job_skill` VALUES (6003, '职级体系', '职级体系', '', '20101416NQTWWHCP9', 6005, 'CRIMYUYPKCSZ', 'CRIMYUYP', '2020-10-14 16:27:54', '2020-10-14 17:17:10', 1, 1, 1, '2020-10-14 17:17:10.405');
INSERT INTO `bd_job_skill` VALUES (6004, '人才盘点', '人才盘点', '', '20101416BV4K8BLSD', 6005, 'CRIMYUYPQFMW', 'CRIMYUYP', '2020-10-14 16:28:20', '2020-10-21 18:38:49', 1, 1, 1, '2020-10-21 18:38:49.485');
INSERT INTO `bd_job_skill` VALUES (6005, '商标设计', '商标设计', '', '20101416DWQWKNL4A', 6006, 'NCDIYQHCWWRX', 'NCDIYQHC', '2020-10-14 16:30:24', '2020-10-14 16:30:24', 1, 1, 0, '2020-10-14 16:30:24.496');
INSERT INTO `bd_job_skill` VALUES (6006, '形象设计', '形象设计', '', '201014164TDQEHDBA', 6006, 'NCDIYQHCVPSJ', 'NCDIYQHC', '2020-10-14 16:30:47', '2020-10-14 16:30:47', 1, 1, 0, '2020-10-14 16:30:47.467');
INSERT INTO `bd_job_skill` VALUES (6007, 'APP设计', 'APP设计', '', '20101416F4DC5MUMS', 8005, 'NCDIQCYFEOOI', 'NCDIQCYF', '2020-10-14 16:31:27', '2020-10-14 16:31:27', 1, 1, 0, '2020-10-14 16:31:26.816');
INSERT INTO `bd_job_skill` VALUES (6008, '文案撰写', '文案撰写', '', '20101416EXXJS7FEQ', 6008, 'ROBDPPJREUTD', 'ROBDPPJR', '2020-10-14 16:31:59', '2020-10-14 16:31:59', 1, 1, 0, '2020-10-14 16:31:59.036');
INSERT INTO `bd_job_skill` VALUES (6009, '内容排版', '内容排版', '', '20101416J84AZKHRD', 6008, 'ROBDPPJRTMJB', 'ROBDPPJR', '2020-10-14 16:32:21', '2020-10-14 16:32:21', 1, 1, 0, '2020-10-14 16:32:20.917');
INSERT INTO `bd_job_skill` VALUES (6010, '数据分析', '数据分析', '', '20101416LB9XYY2YU', 6008, 'ROBDPPJRCOYA', 'ROBDPPJR', '2020-10-14 16:32:43', '2020-10-14 16:32:43', 1, 1, 0, '2020-10-14 16:32:42.813');
INSERT INTO `bd_job_skill` VALUES (6011, '配乐', '配乐', '', '201014163PKJT5KR5', 8007, 'FWKJZCYNLDQM', 'FWKJZCYN', '2020-10-14 16:33:14', '2020-10-14 16:33:14', 1, 1, 0, '2020-10-14 16:33:14.049');
INSERT INTO `bd_job_skill` VALUES (6012, '视频合成', '视频合成', '', '20101416GUPMSVPAA', 8007, 'FWKJZCYNKEGT', 'FWKJZCYN', '2020-10-14 16:33:35', '2020-10-14 16:33:35', 1, 1, 0, '2020-10-14 16:33:34.862');
INSERT INTO `bd_job_skill` VALUES (6013, 'Java', 'Java', '', '20101416DCHFT66GJ', 6009, 'YNEHZKYEKMAA', 'YNEHZKYE', '2020-10-14 16:34:09', '2020-10-14 16:34:09', 1, 1, 0, '2020-10-14 16:34:08.807');
INSERT INTO `bd_job_skill` VALUES (6014, 'Go', 'Go', '', '20101416FYVW4Y78V', 6009, 'YNEHZKYEZHOD', 'YNEHZKYE', '2020-10-14 16:34:31', '2020-10-14 16:34:31', 1, 1, 0, '2020-10-14 16:34:31.008');
INSERT INTO `bd_job_skill` VALUES (6015, '.NET', '.NET', '', '20101416L7Q5XQN88', 6009, 'YNEHZKYEVUWD', 'YNEHZKYE', '2020-10-14 16:34:54', '2020-10-14 20:17:43', 1, 1, 0, '2020-10-14 20:17:42.924');
INSERT INTO `bd_job_skill` VALUES (6016, 'Spring Boot', 'Spring Boot', '', '20101416DSLKPG7ZU', 6009, 'YNEHZKYEFCOA', 'YNEHZKYE', '2020-10-14 16:35:17', '2020-10-14 20:17:05', 1, 1, 0, '2020-10-14 20:17:05.470');
INSERT INTO `bd_job_skill` VALUES (6017, 'MQ', 'MQ', '', '201014162H7D2DWRD', 6009, 'YNEHZKYECJIC', 'YNEHZKYE', '2020-10-14 16:35:42', '2020-10-14 16:35:42', 1, 1, 0, '2020-10-14 16:35:41.916');
INSERT INTO `bd_job_skill` VALUES (6018, 'React', 'React', '', '20101416N5ZNTHZ3Z', 8008, 'YNEHMBROSVRR', 'YNEHMBRO', '2020-10-14 16:36:12', '2020-10-14 16:36:12', 1, 1, 0, '2020-10-14 16:36:12.360');
INSERT INTO `bd_job_skill` VALUES (6019, 'ES6', 'ES6', '', '20101416G823VR6GJ', 8008, 'YNEHMBROIRGL', 'YNEHMBRO', '2020-10-14 16:36:46', '2020-10-14 16:36:46', 1, 1, 0, '2020-10-14 16:36:46.163');
INSERT INTO `bd_job_skill` VALUES (6020, 'TypeScript', 'TypeScript', '', '20101416352A5PWCA', 8008, 'YNEHMBROYCDX', 'YNEHMBRO', '2020-10-14 16:37:13', '2020-10-14 16:37:13', 1, 1, 0, '2020-10-14 16:37:12.628');
INSERT INTO `bd_job_skill` VALUES (6021, 'CSS', 'CSS', '', '20101416FX9GS7X3K', 8008, 'YNEHMBROXFNK', 'YNEHMBRO', '2020-10-14 16:37:53', '2020-10-14 16:37:53', 1, 1, 0, '2020-10-14 16:37:53.171');
INSERT INTO `bd_job_skill` VALUES (6022, 'Taro', 'Taro', '', '20101416NHKRA3TEJ', 6010, 'YNEHIQHDHDPQ', 'YNEHIQHD', '2020-10-14 16:38:22', '2020-10-14 16:38:22', 1, 1, 0, '2020-10-14 16:38:21.511');
INSERT INTO `bd_job_skill` VALUES (6023, 'CSS', 'CSS', '', '20101416GBMDEBPDB', 6010, 'YNEHIQHDINKZ', 'YNEHIQHD', '2020-10-14 16:38:43', '2020-10-14 16:38:43', 1, 1, 0, '2020-10-14 16:38:43.170');
INSERT INTO `bd_job_skill` VALUES (6024, 'Android', 'Android', '', '20101416EL52VMPWF', 8009, 'YNEHCLPCWGGF', 'YNEHCLPC', '2020-10-14 16:39:08', '2020-10-14 16:39:08', 1, 1, 0, '2020-10-14 16:39:07.551');
INSERT INTO `bd_job_skill` VALUES (6025, 'react native', 'react native', '', '20101416GXXJBFA9E', 8009, 'YNEHCLPCJBEY', 'YNEHCLPC', '2020-10-14 16:39:32', '2020-10-14 16:39:32', 1, 1, 0, '2020-10-14 16:39:31.859');
INSERT INTO `bd_job_skill` VALUES (6026, 'flutter', 'flutter', '', '20101416GKRE4T4W7', 8009, 'YNEHCLPCORST', 'YNEHCLPC', '2020-10-14 16:39:57', '2020-10-14 16:39:57', 1, 1, 0, '2020-10-14 16:39:57.349');
INSERT INTO `bd_job_skill` VALUES (8000, '性格测评', '性格测评', '', '201014162YHUL45KC', 6004, 'CRIMXMXVNRNY', 'CRIMXMXV', '2020-10-14 16:25:51', '2020-10-21 18:38:30', 1, 1, 1, '2020-10-21 18:38:30.226');
INSERT INTO `bd_job_skill` VALUES (8001, '高端人才', '高端人才', '', '20101416LUA5CZXRL', 8003, 'CRIMFRQLOXUQ', 'CRIMFRQL', '2020-10-14 16:26:25', '2020-10-14 16:26:25', 1, 1, 0, '2020-10-14 16:26:24.608');
INSERT INTO `bd_job_skill` VALUES (8002, '灵活用工人才', '灵活用工人才', '', '20101416K7NU5C5ZF', 8003, 'CRIMFRQLPYKB', 'CRIMFRQL', '2020-10-14 16:26:53', '2020-10-14 16:26:53', 1, 1, 0, '2020-10-14 16:26:53.488');
INSERT INTO `bd_job_skill` VALUES (8003, '培训发展', '培训发展', '', '20101416223MF2GEX', 6005, 'CRIMYUYPBULG', 'CRIMYUYP', '2020-10-14 16:28:08', '2020-10-21 18:38:53', 1, 1, 1, '2020-10-21 18:38:53.811');
INSERT INTO `bd_job_skill` VALUES (8004, '晋升发展', '晋升发展', '', '20101416EL9TUXPPD', 6005, 'CRIMYUYPMCKF', 'CRIMYUYP', '2020-10-14 16:28:35', '2020-10-21 18:38:58', 1, 1, 1, '2020-10-21 18:38:58.141');
INSERT INTO `bd_job_skill` VALUES (8005, 'VI设计', 'VI设计', '', '20101416K9474DSDX', 6006, 'NCDIYQHCRVAI', 'NCDIYQHC', '2020-10-14 16:30:35', '2020-10-14 16:30:35', 1, 1, 0, '2020-10-14 16:30:35.356');
INSERT INTO `bd_job_skill` VALUES (8006, '衍生品设计', '衍生品设计', '', '20101416GL7W5JQDJ', 6006, 'NCDIYQHCFWXJ', 'NCDIYQHC', '2020-10-14 16:31:11', '2020-10-14 16:31:11', 1, 1, 0, '2020-10-14 16:31:11.325');
INSERT INTO `bd_job_skill` VALUES (8007, '小程序设计', '小程序设计', '', '201014162XGLDMTJ2', 8005, 'NCDIQCYFZIBO', 'NCDIQCYF', '2020-10-14 16:31:40', '2020-10-14 16:31:40', 1, 1, 0, '2020-10-14 16:31:40.137');
INSERT INTO `bd_job_skill` VALUES (8008, '课题研究', '课题研究', '', '20101416LN4Z48VBW', 6008, 'ROBDPPJRQOHK', 'ROBDPPJR', '2020-10-14 16:32:10', '2020-10-14 16:32:10', 1, 1, 0, '2020-10-14 16:32:10.461');
INSERT INTO `bd_job_skill` VALUES (8009, '素材制作', '素材制作', '', '20101416G48EZKLSD', 6008, 'ROBDPPJRWHMC', 'ROBDPPJR', '2020-10-14 16:32:33', '2020-10-14 16:32:33', 1, 1, 0, '2020-10-14 16:32:32.802');
INSERT INTO `bd_job_skill` VALUES (8010, '字幕', '字幕', '', '20101416DFQXQB7S9', 8007, 'FWKJZCYNXZUC', 'FWKJZCYN', '2020-10-14 16:33:01', '2020-10-14 16:33:01', 1, 1, 0, '2020-10-14 16:33:01.000');
INSERT INTO `bd_job_skill` VALUES (8011, '视频剪辑', '视频剪辑', '', '20101416LFWPJ5EJ2', 8007, 'FWKJZCYNYLWF', 'FWKJZCYN', '2020-10-14 16:33:25', '2020-10-14 16:33:25', 1, 1, 0, '2020-10-14 16:33:24.711');
INSERT INTO `bd_job_skill` VALUES (8012, '卡点制作', '卡点制作', '', '2010141626JZZVVEX', 8007, 'FWKJZCYNNPNK', 'FWKJZCYN', '2020-10-14 16:33:46', '2020-10-14 16:33:46', 1, 1, 0, '2020-10-14 16:33:45.929');
INSERT INTO `bd_job_skill` VALUES (8013, 'Python', 'Python', '', '20101416G2H6P87ZU', 6009, 'YNEHZKYEBLKE', 'YNEHZKYE', '2020-10-14 16:34:21', '2020-10-14 16:34:21', 1, 1, 0, '2020-10-14 16:34:20.889');
INSERT INTO `bd_job_skill` VALUES (8014, 'C/C++', 'C/C++', '', '20101416AGCQMMM8N', 6009, 'YNEHZKYEBNQQ', 'YNEHZKYE', '2020-10-14 16:34:43', '2020-10-14 16:34:43', 1, 1, 0, '2020-10-14 16:34:43.419');
INSERT INTO `bd_job_skill` VALUES (8015, 'PHP', 'PHP', '', '20101416KL73UUHCA', 6009, 'YNEHZKYEDWPV', 'YNEHZKYE', '2020-10-14 16:35:06', '2020-10-14 16:35:06', 1, 1, 0, '2020-10-14 16:35:05.740');
INSERT INTO `bd_job_skill` VALUES (8016, 'Spring Cloud', 'Spring Cloud', '', '201014162SV5MYAPD', 6009, 'YNEHZKYEDUYP', 'YNEHZKYE', '2020-10-14 16:35:32', '2020-10-14 20:17:16', 1, 1, 0, '2020-10-14 20:17:15.802');
INSERT INTO `bd_job_skill` VALUES (8017, 'VUE', 'VUE', '', '20101416N6NKRDU6V', 8008, 'YNEHMBROMEVZ', 'YNEHMBRO', '2020-10-14 16:36:02', '2020-10-14 16:36:02', 1, 1, 0, '2020-10-14 16:36:01.877');
INSERT INTO `bd_job_skill` VALUES (8018, 'AngularJS', 'AngularJS', '', '20101416ELXYARQLK', 8008, 'YNEHMBROOLWD', 'YNEHMBRO', '2020-10-14 16:36:29', '2020-10-14 16:36:29', 1, 1, 0, '2020-10-14 16:36:29.000');
INSERT INTO `bd_job_skill` VALUES (8019, 'H5', 'H5', '', '20101416CHK7FLLVE', 8008, 'YNEHMBROQMAV', 'YNEHMBRO', '2020-10-14 16:36:57', '2020-10-14 16:36:57', 1, 1, 0, '2020-10-14 16:36:57.335');
INSERT INTO `bd_job_skill` VALUES (8020, 'Less', 'Less', '', '20101416NTDUQ8Y3S', 8008, 'YNEHMBROJNSW', 'YNEHMBRO', '2020-10-14 16:37:24', '2020-10-14 16:37:24', 1, 1, 0, '2020-10-14 16:37:24.173');
INSERT INTO `bd_job_skill` VALUES (8021, 'WXML', 'WXML', '', '20101416L8WV25RP9', 6010, 'YNEHIQHDOHDI', 'YNEHIQHD', '2020-10-14 16:38:11', '2020-10-14 16:38:11', 1, 1, 0, '2020-10-14 16:38:10.633');
INSERT INTO `bd_job_skill` VALUES (8022, 'JS', 'JS', '', '20101416K5PDYYPWF', 6010, 'YNEHIQHDIUOF', 'YNEHIQHD', '2020-10-14 16:38:34', '2020-10-14 16:38:34', 1, 1, 0, '2020-10-14 16:38:34.186');
INSERT INTO `bd_job_skill` VALUES (8023, 'uniapp', 'uniapp', 'job_profile_photo/2020-10-14/16026661370006296073.png', '20101416MR34JQFXU', 6010, 'YNEHIQHDWOKF', 'YNEHIQHD', '2020-10-14 16:38:55', '2020-10-14 17:02:19', 1, 1, 0, '2020-10-14 17:02:18.948');
INSERT INTO `bd_job_skill` VALUES (8024, 'IOS', 'IOS', '', '20101416K6NM3EKU6', 8009, 'YNEHCLPCPMDJ', 'YNEHCLPC', '2020-10-14 16:39:18', '2020-10-14 16:39:18', 1, 1, 0, '2020-10-14 16:39:18.208');
INSERT INTO `bd_job_skill` VALUES (8025, 'uniapp', 'uniapp', '', '20101416KR2T3M5GB', 8009, 'YNEHCLPCQQNA', 'YNEHCLPC', '2020-10-14 16:39:46', '2020-10-14 16:39:46', 1, 1, 0, '2020-10-14 16:39:46.496');
INSERT INTO `bd_job_skill` VALUES (10000, '333333333333', '', '', '201018222NFTU53VT', 16000, 'YWKMROFQHDEG', 'YWKMROFQ', '2020-10-18 22:05:36', '2020-10-18 22:05:54', 1, 1, 1, '2020-10-18 22:05:54.609');
COMMIT;

-- ----------------------------
-- Table structure for bd_job_tag
-- ----------------------------
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

-- ----------------------------
-- Records of bd_job_tag
-- ----------------------------
BEGIN;
COMMIT;

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
  `county_code` varchar(32) DEFAULT NULL,
  `summarize` varchar(128) NOT NULL DEFAULT '' COMMENT '需求概括',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '需求详细描述',
  `company_name` varchar(500) DEFAULT '' COMMENT '企业名称',
  `budget_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '预算计算方式:0:时薪,1:一口价,2:面谈',
  `delivery_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '交付方式:0:远程,1:现场',
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
) ENGINE=InnoDB AUTO_INCREMENT=8004 DEFAULT CHARSET=utf8 COMMENT='需求表';

-- ----------------------------
-- Records of demand_info
-- ----------------------------
BEGIN;
INSERT INTO `demand_info` VALUES (2000, '20101417CAH5N3Y2R', 4000, 40, 8003, 'CRIMFRQL', '2020-10-16 00:00:00', 500, 1, '1', '1', '0', NULL, '测试发布需求', '接吧', '', 1, 0, '2020-10-14 17:22:54', '2020-10-25 15:20:26', 4000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (2001, '20101420HNHB2H4HY', 4013, 20, 6009, 'YNEHZKYE', '2020-11-14 00:00:00', 12000, 0, '310000', '310100', '310107', NULL, '系统架构师', '能帮助我们架构系统的人', '', 1, 0, '2020-10-14 20:09:16', '2020-10-25 15:20:26', 4013, 4013, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (2002, '20101420DVQ53V74P', 2013, 40, 6009, 'YNEHZKYE', '2020-10-15 00:00:00', 5000, 0, '110000', '110100', '110101', NULL, '1', '2', '', 1, 0, '2020-10-14 20:17:33', '2020-10-25 15:20:26', 2013, 2013, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (2003, '20101500F246WUSW7', 2021, 20, 6003, 'CRIMAIVO', '2020-10-14 00:00:00', 1000, 0, '140000', '140200', '140212', NULL, '11111111111112', 'qqqqqw', '', 1, 0, '2020-10-15 00:11:35', '2020-10-25 15:20:26', 2021, 2021, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (4000, '20101500H8P8SQU6V', 2000, 40, 6003, '20101416DF7RAJ5GB', '2020-10-15 00:00:00', 361, 0, '2', '1', '0', NULL, '你你们', '即使翅膀折了，心也要飞翔 —— 泰戈尔', '', 1, 0, '2020-10-15 00:49:35', '2020-10-25 15:20:26', 2000, 2000, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6000, '201015012AY72Z3S9', 2000, 40, 8008, 'YNEHMBRO', '2024-12-15 00:00:00', 36661, 0, '130000', '130100', '130102', NULL, '呃呃', '自爱，沉稳，而后爱人 —— 亦舒', '', 1, 0, '2020-10-15 01:01:47', '2020-10-25 15:20:26', 2000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6001, '20101501EGG85TCWU', 2000, 40, 6003, 'CRIMAIVO', '2020-10-15 00:00:00', 333, 0, '140000', '140500', '140524', NULL, '324', '4324324', '', 1, 0, '2020-10-15 01:14:02', '2020-10-25 15:20:26', 2000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6002, '20101501H44Q5R9JC', 2000, 40, 6010, 'YNEHIQHD', '2020-12-15 00:00:00', 336, 0, '140000', '140400', '140423', NULL, '还有没有什么时候回来', '@qq.com必须敢于正视，这才可望敢想、敢说、敢做、敢当 —— 鲁迅一路涉足、一路留恋、一路回望。依旧前行一个人的行走范围，就是他的世界 —— 北岛自爱，沉稳，而后爱人 —— 亦舒', '', 1, 0, '2020-10-15 01:17:22', '2020-10-25 15:20:26', 2000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6003, '20101515HYYA4P496', 8038, 20, 6006, 'NCDIYQHC', '2020-10-31 00:00:00', 20000, 0, '110000', '110100', '110108', NULL, '转转公司-视觉设计师兼职', '工作职责：负责线上运营活动页面设计、日常活动资源位设计；任职要求：1、熟练使用Photoshop、AI、sketch等设计类软件、具备手绘基础；2、熟练掌握基础平面构成、色彩知识，对设计形式有基础感知；3、具有责任心、能按照需求在规定时间内完成设计任务；4、有一定的抗压能力；5、需要提供过往设计作品，有运营设计工作经验2年以上。', '', 1, 0, '2020-10-15 15:34:02', '2020-10-25 15:20:26', 8038, 8038, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6004, '20101519BNAY3GWRD', 4002, 20, 6006, 'NCDIYQHC', '2020-11-15 00:00:00', 5000, 1, '110000', '110100', '110101', NULL, '我需要一个品牌设计师', '我需要一个品牌设计师帮我设计公司品牌形象……', '', 1, 0, '2020-10-15 19:20:11', '2020-10-25 15:20:26', 4002, 4002, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6005, '20101606E2Z7PZDEB', 6051, 20, 10001, '20101422JTJR3EB5N', '2020-10-31 00:00:00', 3000, 0, '1', '1', '0', NULL, '我要找一个兼职会计', '1、帮公司做账及出纳工作2、计算及发放员工工作3、跑财税法手续', '', 1, 0, '2020-10-16 06:24:01', '2020-10-25 15:20:26', 6051, 6051, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6006, '20101711NUAJMADJC', 6007, 20, 10000, 'NCDIMXMS', '2020-10-28 00:00:00', 300, 0, '110000', '110100', '110108', NULL, 'EDM邮件海报&内容设计', '邮件营销中，放在邮件中的内容。海报形式，内容呈现简单明了。用不大的篇幅阐述清楚产品的价值、特点、功能等。海报风格要求简洁，色调明快，轻商务类型。内置链接、二维码。', '', 1, 0, '2020-10-17 11:42:08', '2020-10-25 15:20:26', 6007, 6007, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6007, '201018162E96BVVBW', 2000, 40, 8008, 'YNEHMBRO', '2020-12-18 00:00:00', 36, 0, '220000', '220700', '220701', NULL, '啊啊啊', '一个人的行走范围，就是他的世界 —— 北岛你应该是一场梦，我应该是一阵风 —— 顾城必须敢于正视，这才可望敢想、敢说、敢做、敢当 —— 鲁迅一路涉足、一路留恋、一路回望。依旧前行风后面是风，天空上面是天空，道路前面还是道路 —— 海子', '', 1, 0, '2020-10-18 16:18:18', '2020-10-25 15:20:26', 2000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6008, '20101913B5UR2DWUE', 6067, 20, 8002, 'CRIMKYLF', '2020-10-25 00:00:00', 10000, 0, '110000', '110100', '110105', NULL, '文案策划', '有品牌策划、文字创意经验和成熟案例；熟悉线上传播类创意玩法；负责品牌策略相关的文字创作，包括命名、品牌slogen，产品卖点、营销话术等创意工作。', '', 1, 0, '2020-10-19 13:40:19', '2020-10-25 15:20:26', 6067, 6067, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6009, '20101923JWJ8AWSDX', 6051, 20, 8003, '201014162GH479BPL', '2020-10-31 00:00:00', 1000, 0, '0', '1', '0', NULL, '欢迎应聘或者推荐招聘HR，有奖励哦！', '一、岗位名称：招聘顾问（外包）二、岗位职责：负责设计、研发、运营等岗位招聘，主要以交付为主三、岗位要求：1、统招本科以上学历，优秀者可面谈评估；2、2-3年的recruiter，有过互联网招聘经验；3、甲乙方均可，如果是乙方最好有过大厂招聘经验；4、其他要求：男女不限，年龄30左右即可，需驻场在企业四、外包周期：6个月-1年左右，根据企业需求可能会延长五、薪资范围：12-18K之间，具体薪酬根据能力和工作经验来定六、保险福利：1、五险一金，以月薪作为基数缴纳保险和公积金2、双休，法定节假日正常休息，免费三餐七、办公职场：海淀区上地（根据业务安排）', '', 1, 0, '2020-10-19 23:42:18', '2020-10-25 15:20:26', 6051, 6051, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6010, '20102218G83A534LZ', 6051, 20, 6008, 'ROBDPPJR', '2020-10-31 00:00:00', 1000, 1, '110000', '110100', '110105', NULL, '招募一个大学生支持新媒体运营工作', '小程序上线，需要一个新媒体运营实习生，在线支持10天', '', 1, 0, '2020-10-22 18:59:27', '2020-10-25 15:20:26', 6051, 6051, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6011, '20102313L2NBQPU6V', 4000, 20, 6003, 'CRIMAIVO', '2020-10-23 00:00:00', 50, 1, '110000', '110100', '110101', NULL, '测试接单', '测试', '', 1, 0, '2020-10-23 13:08:38', '2020-10-25 15:20:26', 4000, 4000, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (6012, '20102610GY7JE3JCH', 6042, 20, 18001, 'ROBDRAWH', '2020-11-26 00:00:00', 6000, 0, '110000', '110100', '110108', NULL, '鉴定师', '岗位职责: 1、负责市面主流奢侈品腕表/品牌球鞋潮服/口红/香水/护肤/彩妆鉴定和估价工作，包括直播连线和图文鉴定，对鉴定结果负责；2、协助建立完善的鉴别程序，不断优化流程。任职要求： 1、大专及以上学历；2、至少3年及以上的某一种品类的鉴定经验，以及相应考级证书和职业认证；3、性格稳重、细心、耐心，有强烈的责任意识； 4、具备较好的沟通、工作主动积极，具有高度的责任心，团队协作能力强 5、有良好的个人素质和职业操守。', '', 1, 0, '2020-10-26 10:47:29', '2020-10-26 10:47:29', 6042, 6042, 0, '2020-10-26 10:47:28.508');
INSERT INTO `demand_info` VALUES (8000, '201015012NFCTAYCP', 2000, 40, 6010, 'YNEHIQHD', '2020-12-15 00:00:00', 36, 0, '140000', '140100', '140121', NULL, '不知道', '祝你今天愉快，你明天的愉快留着我明天再祝 —— 王小波一个人的行走范围，就是他的世界 —— 北岛一路涉足、一路留恋、一路回望。依旧前行凡是过往皆为序章，所有将来皆为可盼要像小星星一样，努力发光', '', 1, 0, '2020-10-15 01:26:48', '2020-10-25 15:20:26', 2000, 1, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (8001, '20101513BC86YMPHC', 8023, 20, 8009, 'YNEHCLPC', '2020-12-01 00:00:00', 50000, 0, '370000', '370100', '370114', NULL, '机械制造工程助理', '协助生产~“智能化高压消毒除臭喷淋系统”。', '', 1, 0, '2020-10-15 13:23:18', '2020-10-25 15:20:26', 8023, 8023, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (8002, '20101515C9HB573S9', 6040, 20, 6006, 'NCDIYQHC', '2020-10-15 00:00:00', 1000, 0, '110000', '110100', '110101', NULL, 'logo制作', '企业logo', '', 1, 0, '2020-10-15 15:28:24', '2020-10-25 15:20:26', 6040, 6040, 0, '2020-10-25 15:20:26.571');
INSERT INTO `demand_info` VALUES (8003, '20101913NGCU9XFEQ', 6067, 20, 6006, 'NCDIYQHC', '2020-10-25 00:00:00', 18000, 0, '110000', '110100', '110105', NULL, '设计总监', '任职要求1.指导和负责品牌设计、产品包装设计工作，包括品牌视觉识别系统设计和平面应用设计；2.完成设计提案文件，并主持向客户的提案；3.配合必要的市场研究和品牌审计工作。4.以品牌logo、vi，产品包装，产品视觉为主要设计范畴 。任职要求：1. 深刻理解品牌与产品的关系，以及创意和商业之间的衔接关系；2. 出色的设计团队领导能力，包括工作安排、质量把控、人员培养；3. 能适应多任务处理的工作压力；4. 出色的审美情趣和创新能力；5.精通设计软件，出色的PPT使用技巧。', '', 1, 0, '2020-10-19 13:58:13', '2020-10-25 15:20:26', 6067, 6067, 0, '2020-10-25 15:20:26.571');
COMMIT;

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
  PRIMARY KEY (`id`),
  KEY `idx_demand_production_demand_id` (`demand_id`),
  KEY `idx_demand_production_production_id` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8001 DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of demand_production_relation
-- ----------------------------
BEGIN;
INSERT INTO `demand_production_relation` VALUES (2000, 2000, NULL, 10, 6001, '2020-10-14 17:24:08', '2020-10-14 17:24:08', 1, 1, 0, '2020-10-14 17:24:08.154');
INSERT INTO `demand_production_relation` VALUES (4000, 6004, NULL, 10, 14000, '2020-10-15 19:26:41', '2020-10-15 19:26:41', 1, 1, 0, '2020-10-15 19:26:41.228');
INSERT INTO `demand_production_relation` VALUES (6000, 6010, NULL, 10, 16015, '2020-10-22 19:50:51', '2020-10-22 19:50:51', 1, 1, 0, '2020-10-22 19:50:50.729');
INSERT INTO `demand_production_relation` VALUES (8000, 6011, NULL, 10, 4002, '2020-10-23 13:12:22', '2020-10-23 13:12:22', 1, 1, 0, '2020-10-23 13:12:21.699');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=14003 DEFAULT CHARSET=utf8 COMMENT='展位配置表';

-- ----------------------------
-- Records of display_config
-- ----------------------------
BEGIN;
INSERT INTO `display_config` VALUES (2005, 6002, 1, '2021-10-31 08:00:00', '2020-10-14 16:15:16', '2020-10-14 16:15:16', 1, 1, 0, '2020-10-14 16:15:15.533');
INSERT INTO `display_config` VALUES (4000, 6000, 1, '2021-10-31 08:00:00', '2020-10-14 16:14:13', '2020-10-14 16:14:13', 1, 1, 0, '2020-10-14 16:14:12.862');
INSERT INTO `display_config` VALUES (4001, 8000, 1, '2021-10-31 08:00:00', '2020-10-14 16:14:24', '2020-10-14 16:14:24', 1, 1, 0, '2020-10-14 16:14:23.858');
INSERT INTO `display_config` VALUES (4002, 6001, 1, '2021-10-31 08:00:00', '2020-10-14 16:14:34', '2020-10-14 16:14:34', 1, 1, 0, '2020-10-14 16:14:33.650');
INSERT INTO `display_config` VALUES (4003, 8001, 1, '2021-10-31 08:00:00', '2020-10-14 16:14:56', '2020-10-14 16:14:56', 1, 1, 0, '2020-10-14 16:14:56.468');
INSERT INTO `display_config` VALUES (6000, 6006, 2, '2021-10-31 08:00:00', '2020-10-14 17:02:14', '2020-10-14 17:02:14', 1, 1, 0, '2020-10-14 17:02:14.071');
INSERT INTO `display_config` VALUES (6001, 8007, 2, '2021-10-31 08:00:00', '2020-10-14 17:02:35', '2020-10-14 17:02:35', 1, 1, 0, '2020-10-14 17:02:34.526');
INSERT INTO `display_config` VALUES (6002, 6009, 2, '2021-10-31 08:00:00', '2020-10-14 17:02:58', '2020-10-14 17:02:58', 1, 1, 0, '2020-10-14 17:02:58.228');
INSERT INTO `display_config` VALUES (6003, 2005, 7, '2020-10-31 08:00:00', '2020-10-14 19:27:45', '2020-10-14 19:27:45', 1, 1, 0, '2020-10-14 19:27:44.707');
INSERT INTO `display_config` VALUES (6004, 2004, 7, '2020-10-31 08:00:00', '2020-10-14 19:37:54', '2020-10-14 19:37:54', 1, 1, 0, '2020-10-14 19:37:54.287');
INSERT INTO `display_config` VALUES (6005, 8000, 7, '2020-10-31 08:00:00', '2020-10-14 19:42:54', '2020-10-14 19:42:54', 1, 1, 0, '2020-10-14 19:42:54.089');
INSERT INTO `display_config` VALUES (6006, 10000, 7, '2020-10-31 08:00:00', '2020-10-14 19:47:23', '2020-10-14 19:47:23', 1, 1, 0, '2020-10-14 19:47:23.261');
INSERT INTO `display_config` VALUES (6007, 4004, 7, '2020-10-31 08:00:00', '2020-10-14 19:50:08', '2020-10-14 19:50:08', 1, 1, 0, '2020-10-14 19:50:08.370');
INSERT INTO `display_config` VALUES (6008, 2001, 7, '2020-10-31 08:00:00', '2020-10-14 22:46:49', '2020-10-14 22:46:49', 1, 1, 0, '2020-10-14 22:46:49.152');
INSERT INTO `display_config` VALUES (8000, 8007, 2, '2021-10-31 08:00:00', '2020-10-14 17:02:35', '2020-10-14 17:02:38', 1, 1, 1, '2020-10-14 17:02:38.474');
INSERT INTO `display_config` VALUES (8001, 8003, 2, '2020-10-15 01:17:59', '2020-10-14 17:18:01', '2020-10-14 17:18:01', 1, 1, 0, '2020-10-14 17:18:00.785');
INSERT INTO `display_config` VALUES (8002, 2006, 7, '2020-10-31 08:00:00', '2020-10-14 18:09:42', '2020-10-14 18:09:42', 1, 1, 0, '2020-10-14 18:09:42.290');
INSERT INTO `display_config` VALUES (8003, 2007, 7, '2020-10-31 08:00:00', '2020-10-14 19:27:02', '2020-10-14 19:27:02', 1, 1, 0, '2020-10-14 19:27:01.770');
INSERT INTO `display_config` VALUES (8004, 4003, 7, '2020-10-31 08:00:00', '2020-10-14 19:47:33', '2020-10-14 19:47:33', 1, 1, 0, '2020-10-14 19:47:32.829');
INSERT INTO `display_config` VALUES (8005, 2003, 7, '2020-10-31 08:00:00', '2020-10-14 22:46:22', '2020-10-14 22:46:22', 1, 1, 0, '2020-10-14 22:46:22.382');
INSERT INTO `display_config` VALUES (10000, 16011, 7, '2020-10-31 08:00:00', '2020-10-19 10:51:22', '2020-10-23 17:08:34', 1, 1, 1, '2020-10-23 17:08:34.512');
INSERT INTO `display_config` VALUES (10001, 16005, 7, '2020-10-31 08:00:00', '2020-10-19 10:51:48', '2020-10-19 10:51:48', 1, 1, 0, '2020-10-19 10:51:48.380');
INSERT INTO `display_config` VALUES (12000, 20000, 7, '2020-10-31 08:00:00', '2020-10-19 10:52:15', '2020-10-19 10:52:15', 1, 1, 0, '2020-10-19 10:52:15.413');
INSERT INTO `display_config` VALUES (14000, 14003, 7, '2020-10-31 08:00:00', '2020-10-21 20:22:36', '2020-10-23 17:08:19', 1, 1, 1, '2020-10-23 17:08:19.084');
INSERT INTO `display_config` VALUES (14001, 12000, 7, '2020-10-31 08:00:00', '2020-10-21 20:23:17', '2020-10-23 17:08:16', 1, 1, 1, '2020-10-23 17:08:16.923');
INSERT INTO `display_config` VALUES (14002, 16010, 7, '2020-10-31 08:00:00', '2020-10-23 17:06:01', '2020-10-23 17:06:01', 1, 1, 0, '2020-10-23 17:06:01.383');
COMMIT;

-- ----------------------------
-- Table structure for employer_info
-- ----------------------------
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
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `update_user` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38003 DEFAULT CHARSET=utf8mb4 COMMENT='雇佣者信息表';

-- ----------------------------
-- Records of employer_info
-- ----------------------------
BEGIN;
INSERT INTO `employer_info` VALUES (2000, 2000, '波英冰', '波英冰', '', '', NULL, NULL, '', '', '18680506315', '2020-10-14 15:59:46', '2020-10-18 22:12:37', '-1', '2000', 0, '2020-10-18 22:12:37.089');
INSERT INTO `employer_info` VALUES (2001, 2001, '康胜苏', '康胜苏', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJsjcw1SDskBDFyjYwcABNaRd9ZfWlmquoyseVmqtia7iaFlyDMVZbjrPGZZh3HBz72GI3icFuy6Fj2g/132', '', NULL, NULL, '', '', '15801227230', '2020-10-14 15:59:58', '2020-10-14 16:00:01', '-1', '2001', 0, '2020-10-14 16:00:00.972');
INSERT INTO `employer_info` VALUES (2002, 2002, '孔令飞', '孔令飞', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erbP3G6OIm5zElMYyEWufBMTgO6kDiausGg9NLfEY3Pe0GQ6kJNlPNbrYKYhmHdYALJIuDdoTCATLg/132', '', NULL, NULL, '', '', '15010924982', '2020-10-14 18:06:21', '2020-10-14 18:06:24', '4001', '2002', 0, '2020-10-14 18:06:23.860');
INSERT INTO `employer_info` VALUES (2003, 2003, '秋天离别-邓雷', '秋天离别-邓雷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLCnEPpM4WwSNRWZa1T3zOwA2x0icia0OSDMU8nfVunRWAdYOqmkZSia5FxAOcSRK7CfSTiaDFicaubibEw/132', '', NULL, NULL, '', '', '18657675257', '2020-10-14 18:47:11', '2020-10-14 18:47:17', '4002', '2003', 0, '2020-10-14 18:47:16.663');
INSERT INTO `employer_info` VALUES (2004, 2004, 'i舒克', 'i舒克', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIIPk9sbg3Nu6ZNBGsSsKAPIk1355iaTY7z32ybYbl93L9sLZGKEGys8yXyBxNnPly8Np7bJjA05vw/132', '', NULL, NULL, '', '', '18271676417', '2020-10-14 18:47:23', '2020-10-14 18:47:25', '4000', '2004', 0, '2020-10-14 18:47:25.472');
INSERT INTO `employer_info` VALUES (2005, 2005, 'Carly 张蕾', 'Carly 张蕾', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIrVkpD3ck8XcQhpcAlNPZXmINHJUWSbC9SVriaKfnpLRxGt5x4tibwo5qTfteWrjvpT6Eo4piaPfPZQ/132', '', NULL, NULL, '', '', '13801251875', '2020-10-14 18:47:34', '2020-10-14 18:47:41', '2004', '2005', 0, '2020-10-14 18:47:41.170');
INSERT INTO `employer_info` VALUES (2006, 2006, 'W-', 'W-', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLJ2F2ibIlPic8fQHDpOIbgIcpfXSQJNavSdOIMEpkthGwToicnibvBn45zRzUm0BY6ZTtfDAYMSSLmew/132', '', NULL, NULL, '', '', '13261523952', '2020-10-14 19:18:04', '2020-10-14 19:18:06', '4004', '2006', 0, '2020-10-14 19:18:06.449');
INSERT INTO `employer_info` VALUES (2007, 2007, '孙欣Amanda', '孙欣Amanda', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epzxl1othrI7L1KibF9uAHMW8pTKUiaicLKZyWKgyFkQmCWM01Kib5xRLwbsbQibufjFy4pSic4jOdkLibicQ/132', '', NULL, NULL, '', '', '13120485009', '2020-10-14 19:22:30', '2020-10-14 19:22:32', '4002', '2007', 0, '2020-10-14 19:22:32.439');
INSERT INTO `employer_info` VALUES (2008, 2008, '张苏k', '张苏k', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIKOs8aPC4ArJbsiaic0rSV4lEhkHabltxKia5P6mA5cKOvAibr0t2cCnD2EK2NVwJdoAHibn3E0suEdww/132', '', NULL, NULL, '', '', NULL, '2020-10-14 19:29:29', '2020-10-14 19:29:29', '4005', '4005', 0, '2020-10-14 19:29:29.031');
INSERT INTO `employer_info` VALUES (2009, 2009, '官方提醒', '官方提醒', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJcVC1nVcVVlJKNWcqkzomQtKWiciaBxrlWtlvL45KbqaV9zrwA9jbDQlvCuBt5mKls9MHgfSjeKnrw/132', '', NULL, NULL, '', '', '18752867304', '2020-10-14 19:49:28', '2020-10-14 19:49:47', '4008', '2009', 0, '2020-10-14 19:49:46.576');
INSERT INTO `employer_info` VALUES (2010, 2010, 'Yu-Hsiu', 'Yu-Hsiu', 'https://thirdwx.qlogo.cn/mmopen/vi_32/0Jm9FRypCPkXQXExeeOUpTbv6UyrPxSrRzMLtGJWgeLmV1WYdRwpKxl80jLzYwzM6ibrvVC2qmaYsfyyibPnPVIA/132', '', NULL, NULL, '', '', '18611323185', '2020-10-14 19:51:23', '2020-10-14 19:51:26', '4009', '2010', 0, '2020-10-14 19:51:25.804');
INSERT INTO `employer_info` VALUES (2011, 2011, '帅炜玥（帅权晍）', '帅炜玥（帅权晍）', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLjO1ywuFNHOCjJuNbbj7UHAld6ib6qUAFtfxsdLYqict8PAfOmjia6DeAT97qAJcfMREtxVx3FrLOfg/132', '', NULL, NULL, '', '', '13693376633', '2020-10-14 19:57:37', '2020-10-14 19:57:41', '2009', '2011', 0, '2020-10-14 19:57:41.304');
INSERT INTO `employer_info` VALUES (2012, 2012, 'Judy', 'Judy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ8m41TE7yeRo6KmtyRDI1k30ia6ElbK9IkCp8IC1O3Gia56B86ic8VPbmVKeOj3sib8ibTO0zTPg2oURA/132', '', NULL, NULL, '', '', '13501391246', '2020-10-14 20:12:06', '2020-10-14 20:12:12', '4013', '2012', 0, '2020-10-14 20:12:11.864');
INSERT INTO `employer_info` VALUES (2013, 2013, 'OK_Boy', 'OK_Boy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIetZBcibMqTLbrV3VZI7jsHy6gzHAQibMxibzAgWd33FuXEjD2DvoN9Ohd10mIuBmcia8jtRArbn799g/132', '', NULL, NULL, '', '', '13810998520', '2020-10-14 20:12:55', '2020-10-14 20:12:59', '4013', '2013', 0, '2020-10-14 20:12:59.080');
INSERT INTO `employer_info` VALUES (2014, 2014, 'winxie', 'winxie', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJhhjyWnerFSS9xTfgd8bolpy2UDb2xE5ibgQWhGPj20pVGY5LBUeDUpDoNcHQgYicdJV9iacgZnhx5g/132', '', NULL, NULL, '', '', '18500192168', '2020-10-14 20:13:48', '2020-10-14 20:13:52', '4016', '2014', 0, '2020-10-14 20:13:52.216');
INSERT INTO `employer_info` VALUES (2015, 2015, ' 嗯哼～', ' 嗯哼～', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoXpyeIdLk2YJABQufPes2gQUFTjEXY6eq9bfQjBGCk9EBJYy1Lg1eX6U78O8BaXJiaxKPtG2yibDLA/132', '', NULL, NULL, '', '', '18500229693', '2020-10-14 20:14:42', '2020-10-14 20:14:45', '2013', '2015', 0, '2020-10-14 20:14:44.803');
INSERT INTO `employer_info` VALUES (2016, 2016, '菲菲', '菲菲', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ergDOQm9kh9xn8R4ICTUYRyLD5EwHBkpV2eebJxRmCt2hzu7VNBOjCVaJfS964djYegN2pCZD5CGw/132', '', NULL, NULL, '', '', '13910501580', '2020-10-14 20:37:30', '2020-10-14 20:37:33', '2013', '2016', 0, '2020-10-14 20:37:33.350');
INSERT INTO `employer_info` VALUES (2017, 2017, '杰子', '杰子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erTUVjd6pv0ft16qThVWGYZ31icEkia7lkMg2rJZHOzbwpfaAgpH6VJKTcmDpNyzAKR3pIu2bD4LwWA/132', '', NULL, NULL, '', '', '13810469408', '2020-10-14 20:54:42', '2020-10-14 20:54:48', '4018', '2017', 0, '2020-10-14 20:54:47.650');
INSERT INTO `employer_info` VALUES (2018, 2018, '鹰子', '鹰子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erY4ZLFhWonZfM07q0KwV7ZQ0ftSoXCMVy6aHPFqm6ic5Gqnfwdglg4ThKkHcuLJyXEu37IORYXUYA/132', '', NULL, NULL, '', '', '18600852299', '2020-10-14 21:12:20', '2020-10-14 21:12:24', '2016', '2018', 0, '2020-10-14 21:12:23.797');
INSERT INTO `employer_info` VALUES (2019, 2019, '桑雨', '桑雨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI8mJ99Xpo281MpgdibdxC0tBgbNtY3MSPTI8PkWABnU02Vt5eUuw1XoIC562gibxibs7Via5Ql9ajRWw/132', '', NULL, NULL, '', '', '18811040547', '2020-10-14 21:12:21', '2020-10-14 21:12:26', '4002', '2019', 0, '2020-10-14 21:12:25.772');
INSERT INTO `employer_info` VALUES (2020, 2020, '圣灵居士（强哥）', '圣灵居士（强哥）', 'https://thirdwx.qlogo.cn/mmopen/vi_32/eNw07BdCEd4LOUEib5QQsIDhaRmuMeGSQIfwJMSricqb1SepmbQiaJnCybJHJQQUM4unzric38gC81P3x4gpiclSNbA/132', '', NULL, NULL, '', '', '13810684286', '2020-10-14 21:23:16', '2020-10-14 21:23:40', '2018', '2020', 0, '2020-10-14 21:23:40.035');
INSERT INTO `employer_info` VALUES (2021, 2021, '刘海鸣', '刘海鸣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvGAUEPO8BsCFvO9qNWbzdjibC2gMKymXV6CxjWG0fiaElqrCqotll33giaMlJwEbHQmIDnwyyCVibFQ/132', '', NULL, NULL, '', '', '18611098024', '2020-10-14 23:21:35', '2020-10-14 23:21:38', '2005', '2021', 0, '2020-10-14 23:21:37.905');
INSERT INTO `employer_info` VALUES (2022, 2022, 'why not', 'why not', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDFo6AERNIMLOl9YC9Wft4icGXlazDWNfSCkLbJicPbEhXDVxnkCgE1QTQrUmNnA6zicH8H1fxeIyFg/132', '', NULL, NULL, '', '', '18810226137', '2020-10-14 23:21:53', '2020-10-14 23:21:57', '2021', '2022', 0, '2020-10-14 23:21:56.489');
INSERT INTO `employer_info` VALUES (2023, 2023, '祺', '祺', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epLPbr4Kbh71UaKIghS1U3DysKexannxz2BcibMZIpjLeJLTZ5TEc6cQiaMCDlD98z3ialWRRyWY5kOQ/132', '', NULL, NULL, '', '', '18510180570', '2020-10-15 00:08:02', '2020-10-15 00:08:13', '2022', '2023', 0, '2020-10-15 00:08:12.916');
INSERT INTO `employer_info` VALUES (2024, 2024, 'Lynnnnnnn🦄', 'Lynnnnnnn🦄', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCyRqwKL3sUwVJ5AwVpB7naZeTuvYwPmurTMpbZZ62Qzch9nSwrqaJc7VDzSRWTE5WFIicWmMPvDA/132', '', NULL, NULL, '', '', '15620304128', '2020-10-15 00:52:06', '2020-10-15 00:52:19', '2000', '2024', 0, '2020-10-15 00:52:19.282');
INSERT INTO `employer_info` VALUES (4000, 4000, '麒少爷', '麒少爷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUSWrYgGK0rIlJDtMFRJpVxD5EAic299PnKPfVxu4rMTLKnd4JOQPK1j3LRZxbetKsCjZXDdlY4QQ/132', '', NULL, NULL, '', '', '15110245740', '2020-10-14 16:01:18', '2020-10-14 16:01:21', '-1', '4000', 0, '2020-10-14 16:01:20.735');
INSERT INTO `employer_info` VALUES (4001, 4001, 'HowWork客服', 'HowWork客服', 'https://thirdwx.qlogo.cn/mmopen/vi_32/nuLEiaxX0hzQHDQZqWuBuEBQUT4yr2icI7jaqk0g4FXS8jQ2iajGmqnWMa4VAn3lfORlMHEN0JtjD6BicNfkJOnMhA/132', '', NULL, NULL, '', '', '13261773089', '2020-10-14 16:40:53', '2020-10-14 16:40:56', '-1', '4001', 0, '2020-10-14 16:40:56.364');
INSERT INTO `employer_info` VALUES (4002, 4002, '大力🍋', '大力🍋', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erxgsdezJSjynLhOjZRhDdc1FMUichmv69jnCCZwAcztmeAxQZIp9wiaJXxTjV2kDJQKC8QBqxQs6aQ/132', '', NULL, NULL, '', '', '13331138761', '2020-10-14 16:51:41', '2020-10-14 16:51:44', '-1', '4002', 0, '2020-10-14 16:51:43.836');
INSERT INTO `employer_info` VALUES (4003, 4003, '董亦', '董亦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK04GtFYBs2wEuDSheebJppicibXSrUlzeeYm6emKcqBicg5Y0Fp4gibnEcvo9djvroW9iarKHEtIUkuFQ/132', '', NULL, NULL, '', '', '13067817724', '2020-10-14 18:16:18', '2020-10-14 18:16:23', '2002', '4003', 0, '2020-10-14 18:16:22.765');
INSERT INTO `employer_info` VALUES (4004, 4004, 'Mr.MJ', 'Mr.MJ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZjcJtcEHQaO1gk8YayfJerm2m24m6rIicGngqLr24YpZXBaxqsfq7EESJf79F67jIetYCb6RPKNw/132', '', NULL, NULL, '', '', '15221907328', '2020-10-14 18:51:49', '2020-10-14 18:51:52', '2003', '4004', 0, '2020-10-14 18:51:52.245');
INSERT INTO `employer_info` VALUES (4005, 4005, '君扬', '君扬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJaD0xeiaicfgia0E9ia3s2blhjNia5ZO5phMzm7LVgj7jkglVeibdmqXW11icIEDWOrtn9UR8tOMciaqA1ng/132', '', NULL, NULL, '', '', '13302048330', '2020-10-14 19:23:04', '2020-10-14 19:23:07', '2006', '4005', 0, '2020-10-14 19:23:06.597');
INSERT INTO `employer_info` VALUES (4006, 4006, '二东丶', '二东丶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLbrBKic45K6MSNYXbeCEBxGVsY9kIQxL4PmUKuJghFwvvubDxWACoHGwMOOlUIVph0PW5UKGAshdw/132', '', NULL, NULL, '', '', '13264181224', '2020-10-14 19:33:54', '2020-10-14 19:34:10', '2008', '4006', 0, '2020-10-14 19:34:09.572');
INSERT INTO `employer_info` VALUES (4007, 4007, 'Abby', 'Abby', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKKuXa6MoPRiczkFQTXkDxr4IibTGC5vNylWB7m3PocWhV106tTaChRMukQXeFvOM6M9EZc7icrNkfIA/132', '', NULL, NULL, '', '', '15011103665', '2020-10-14 19:45:48', '2020-10-14 19:45:51', '2005', '4007', 0, '2020-10-14 19:45:51.224');
INSERT INTO `employer_info` VALUES (4008, 4008, '江声', '江声', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIJcnqT8h9u8DTO69AxseV7rRtakuCGILGicYz1TISBuKAcdmx6T2ceVYva76sod72s2wwUgGu3Bvw/132', '', NULL, NULL, '', '', '13716988056', '2020-10-14 19:49:16', '2020-10-14 19:49:18', '2005', '4008', 0, '2020-10-14 19:49:18.291');
INSERT INTO `employer_info` VALUES (4009, 4009, 'FE', 'FE', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLOhHuWCdKrZTHyNcbg30VPTQZKg2wicyicSRKibJWeyibFhaU0sEucEDGZEPicIQw6I7rh9MkZBcdcXIA/132', '', NULL, NULL, '', '', '15566899876', '2020-10-14 19:49:54', '2020-10-14 19:50:00', '2005', '4009', 0, '2020-10-14 19:50:00.294');
INSERT INTO `employer_info` VALUES (4010, 4010, 'Beyondsky', 'Beyondsky', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epOA01ibEIYceFvqyjtGD4eR9LvAOQzrEHAq5DoWzrC5Y4MnyuZA6oq2639qkXlWW9VFl2szbrr2xg/132', '', NULL, NULL, '', '', '13522285321', '2020-10-14 19:50:09', '2020-10-14 19:50:24', '2009', '4010', 0, '2020-10-14 19:50:23.736');
INSERT INTO `employer_info` VALUES (4011, 4011, '阿白', '阿白', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM4C2qIotaBho6E2tu5wfmtTYAw6nViamQZibsMoFaGkUjgXKE9y1UEUMW5cgKIxy0yuDucQAWib7mMIg/132', '', NULL, NULL, '', '', '13701246092', '2020-10-14 19:52:00', '2020-10-14 20:03:54', '2010', '4011', 0, '2020-10-14 20:03:53.494');
INSERT INTO `employer_info` VALUES (4012, 4012, 'Tigger', 'Tigger', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eru8vCvpIedl4uIc8edb5zicDRsQcgR7pv79ib3GJyUfVXpffLe1av94Ly5oBOVDzvwDmTjQwdoGeog/132', '', NULL, NULL, '', '', '13240119298', '2020-10-14 19:53:19', '2020-10-14 19:53:23', '4011', '4012', 0, '2020-10-14 19:53:22.715');
INSERT INTO `employer_info` VALUES (4013, 4013, 'Dennis', 'Dennis', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBCG76XZZVPuDENj2aSrnWtticsibckb4fKZtJhPZo7oroxhVXkRY7V4MdCpTeXCyibSwb5zfp4V8NvA/132', '', NULL, NULL, '', '', '18516224166', '2020-10-14 19:56:30', '2020-10-14 19:56:33', '2009', '4013', 0, '2020-10-14 19:56:32.634');
INSERT INTO `employer_info` VALUES (4014, 4014, 'Leanne', 'Leanne', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI08UYkOdJziaicgmxGKiaooRpB8ic47JyicaTGYn3AJFHppEMSC2iaR7SFwx9qeNNU3gbhO8VYDF1MtePQ/132', '', NULL, NULL, '', '', '13683687235', '2020-10-14 20:04:56', '2020-10-14 20:05:00', '4013', '4014', 0, '2020-10-14 20:05:00.124');
INSERT INTO `employer_info` VALUES (4015, 4015, 'Victoria🦄', 'Victoria🦄', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqDto46VMrZf01mbs1AfyKLrGQ4O6XQibqLU6wZKRRL518u8GFZGddyGKwQymL3YUURSOC37UnicaeQ/132', '', NULL, NULL, '', '', '17600498222', '2020-10-14 20:09:40', '2020-10-14 20:09:43', '4013', '4015', 0, '2020-10-14 20:09:42.938');
INSERT INTO `employer_info` VALUES (4016, 4016, '郭峰', '郭峰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eriagictpucFF6ibeL1mRL7rfQPju5KV1H3zias0CnJ4sBc4ysFlEV4CoG0Nb5ccGrVOP2m4gZs3uGKUQ/132', '', NULL, NULL, '', '', '18611687063', '2020-10-14 20:12:53', '2020-10-14 20:12:57', '4013', '4016', 0, '2020-10-14 20:12:57.105');
INSERT INTO `employer_info` VALUES (4017, 4017, '惠鹏|盛世三人行', '惠鹏|盛世三人行', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK14wx7cL8PEc8TnpaBpLI7n2tIbRQRhIyF1mcPUIlzQ6tnteD3uyFunyHpcTIL2k8t8d9qeHKH4g/132', '', NULL, NULL, '', '', NULL, '2020-10-14 20:43:55', '2020-10-14 20:43:55', '2015', '2015', 0, '2020-10-14 20:43:55.229');
INSERT INTO `employer_info` VALUES (4018, 4018, '毛毛钱儿', '毛毛钱儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIlJicNmiaibib3Jzl9QX3mE8DVuicv4ukicSddkkYWT23BPeecQgHZc2GN5Kjw8roOicX3ziahKrr2DxjAhQ/132', '', NULL, NULL, '', '', '13811602180', '2020-10-14 20:51:07', '2020-10-14 20:51:16', '2016', '4018', 0, '2020-10-14 20:51:16.237');
INSERT INTO `employer_info` VALUES (4019, 4019, '郭项玉', '郭项玉', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKgA8bMuSpADlj8y8FTX8D6ciarcN1aXx5nfhp5F9ThaNv1O3vnByib9Lp4jGvBGJiaaKwqWRd7ltuKg/132', '', NULL, NULL, '', '', '13121813382', '2020-10-14 20:55:19', '2020-10-14 20:55:25', '2017', '4019', 0, '2020-10-14 20:55:25.243');
INSERT INTO `employer_info` VALUES (4020, 4020, 'sun', 'sun', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoUmVMortCC1GEEnjic1ibNIM6jUHsabMDKb0ZQKnMVsCRomibqwqnhqwIY3jUP6cnpZ4T3r7MtrvPSA/132', '', NULL, NULL, '', '', '13718911001', '2020-10-14 20:55:46', '2020-10-14 20:55:50', '2015', '4020', 0, '2020-10-14 20:55:49.613');
INSERT INTO `employer_info` VALUES (4021, 4021, '巴拉巴拉不啦', '巴拉巴拉不啦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/RNic9ILGf7zA15L0oqoHJnG7wh3yBPxPsDgpP98bBFshBRgibIjjY32wlomgz4CqzBExNZLch7WTria3phEhHKIyw/132', '', NULL, NULL, '', '', '18519580645', '2020-10-14 21:21:22', '2020-10-14 21:21:26', '2018', '4021', 0, '2020-10-14 21:21:25.545');
INSERT INTO `employer_info` VALUES (4022, 4022, 'stan.j', 'stan.j', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK2IGjBHxn5N8mNznQBw8P7M7JtzRuKLJV7BgyCBjpnw2XKG9m5Dsczf00AoM4wQtorMicKSsQkakA/132', '', NULL, NULL, '', '', '18810178690', '2020-10-14 21:25:31', '2020-10-14 21:25:37', '2020', '4022', 0, '2020-10-14 21:25:36.875');
INSERT INTO `employer_info` VALUES (4023, 4023, 'MAOXT', 'MAOXT', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqgJaiaS4uxy06cq9N2UEHial5gDiceV038s6p5phktV05cj6wrUHDGpUj0QQBsGic10Xe7duLM2gtcWA/132', '', NULL, NULL, '', '', '18618284020', '2020-10-14 21:27:40', '2020-10-14 21:27:47', '2020', '4023', 0, '2020-10-14 21:27:47.238');
INSERT INTO `employer_info` VALUES (4024, 4024, '你没', '你没', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIZ7wT7fOlAz3ad9ZwdxImvcjxicoy7ByIXqnyNPkQv64mwDrOxGXhayUguGMy6s6ytx9VdQdNoKvA/132', '', NULL, NULL, '', '', NULL, '2020-10-14 21:41:40', '2020-10-14 21:41:40', '4023', '4023', 0, '2020-10-14 21:41:39.869');
INSERT INTO `employer_info` VALUES (4025, 4025, '马俊', '马俊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqSn7SKIwE2NF7ALa48LbickYAtcibuJ1jQJDDFCJ3y9qPjdictiasj9E5ibCKzDvwN2tiaINtibZX4ribjTA/132', '', NULL, NULL, '', '', NULL, '2020-10-14 21:44:55', '2020-10-14 21:44:55', '4023', '4023', 0, '2020-10-14 21:44:55.399');
INSERT INTO `employer_info` VALUES (4026, 4026, '高高', '高高', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqsxdVNykRAznxrCdWXbR4B47eRKLpsib4TbJN4Ayw3DNTzAOTbeOUq64onTR8kwicdK9PlX43Biajog/132', '', NULL, NULL, '', '', '15011353173', '2020-10-14 22:13:50', '2020-10-14 22:13:53', '2013', '4026', 0, '2020-10-14 22:13:53.203');
INSERT INTO `employer_info` VALUES (6000, 6000, '汤继荣律师 15618301701', '汤继荣律师 15618301701', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICBrkJyDjjHey5WzykZa6kqswJiatG81srqg2XA5HWLuPZ5YIawEUA95SNIYLqyO46ZDyLFVUntzw/132', '', NULL, NULL, '', '', '13818872885', '2020-10-15 03:39:26', '2020-10-15 03:39:36', '2000', '6000', 0, '2020-10-15 03:39:35.552');
INSERT INTO `employer_info` VALUES (6001, 6001, '冯 宁', '冯 宁', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL2GBvNwxu4PVCIDWnOdrqszjGBD9Layr3ibN4XcHCdk3CQicNL9nekrAT95qERqKsmuO8LGYkNq5Qw/132', '', NULL, NULL, '', '', '13910429707', '2020-10-15 08:59:17', '2020-10-15 08:59:21', '4005', '6001', 0, '2020-10-15 08:59:21.151');
INSERT INTO `employer_info` VALUES (6002, 6002, 'Leo', 'Leo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/umBbHGdic4jV4libLU9o8UXkfyvLZo1J7nlszqgwiaHjwJGqaIqZUcYTYuTk1FDMhfAORlqKqcYqFF0csQJEScOiaA/132', '', NULL, NULL, '', '', NULL, '2020-10-15 10:12:12', '2020-10-15 10:12:12', '4005', '4005', 0, '2020-10-15 10:12:12.406');
INSERT INTO `employer_info` VALUES (6003, 6003, '小锅锅', '小锅锅', 'https://thirdwx.qlogo.cn/mmopen/vi_32/mAGK7Wtn392B6bdZDyd4p8ia5GdcR2huGlN2KqPfEJ6RGbERCgnhyuFrr0ZgdvmHwwvgjJkibGb9IvfflV57M28A/132', '', NULL, NULL, '', '', '18511697147', '2020-10-15 10:14:46', '2020-10-15 10:14:51', '4005', '6003', 0, '2020-10-15 10:14:50.854');
INSERT INTO `employer_info` VALUES (6004, 6004, '木子', '木子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJsjcw1SDskBJxlK6JX7XicPOEU3OTk2aFDqEGtLZUoYl74mKnLYXqEZkujszfYOVibeAqxSMicWeBBA/132', '', NULL, NULL, '', '', '15011322815', '2020-10-15 10:33:56', '2020-10-15 10:33:59', '4000', '6004', 0, '2020-10-15 10:33:58.676');
INSERT INTO `employer_info` VALUES (6005, 6005, 'WhenUBelieve', 'WhenUBelieve', 'https://thirdwx.qlogo.cn/mmopen/vi_32/wVJLKmibyYdrCGCeiaaBt5ibQwiaPxrNLgx8AmAEYPibOicL8VIuCaicFrtrZldgJSW8HxbKiaXJP0qDibhiaPWSrwXmFwCg/132', '', NULL, NULL, '', '', NULL, '2020-10-15 10:37:49', '2020-10-15 10:37:49', '2007', '2007', 0, '2020-10-15 10:37:48.772');
INSERT INTO `employer_info` VALUES (6006, 6006, '轩辕客', '轩辕客', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqnx3Y4WEwsD80awtVcCPeK2Pm8KUerVUEWoOxD4Jm9vXUTnSaa7De4OKbgQg64D4h4iaVbPDU1opA/132', '', NULL, NULL, '', '', '15901476757', '2020-10-15 11:22:03', '2020-10-15 11:22:09', '2007', '6006', 0, '2020-10-15 11:22:09.224');
INSERT INTO `employer_info` VALUES (6007, 6007, 'Samson孙峰', 'Samson孙峰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKP02vhVpuXoKS3qhbyAnZmqtq9SvLxBDciaUYBs3cKPs4cT2Gn6cxD4vUhaLf0nQ8TrBwXz5vicsTA/132', '', NULL, NULL, '', '', '13901328854', '2020-10-15 11:25:50', '2020-10-15 11:25:53', '6006', '6007', 0, '2020-10-15 11:25:52.837');
INSERT INTO `employer_info` VALUES (6008, 6008, '敬淞  ྃ༄༅།འགུ་རུ་།', '敬淞  ྃ༄༅།འགུ་རུ་།', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM5mqiaRDoAhajND8ia91E7lyoqGqcEDcR4pLDChI7LMfJKljAsuxtQvt1kTsXolM6v8JQekEb8qkicnw/132', '', NULL, NULL, '', '', '13522137269', '2020-10-15 11:26:48', '2020-10-15 11:26:51', '6001', '6008', 0, '2020-10-15 11:26:50.944');
INSERT INTO `employer_info` VALUES (6009, 6009, '那谁', '那谁', 'https://thirdwx.qlogo.cn/mmopen/vi_32/GQp8bndH8SwDC7uWQLVDDB3IVCaib7kiaB32WKElG6wZyiaeib6nsZ99KBOmOBlbak9pptFAbIr4RqC8wFwcxTSLFw/132', '', NULL, NULL, '', '', NULL, '2020-10-15 11:43:48', '2020-10-15 11:43:48', '4023', '4023', 0, '2020-10-15 11:43:47.810');
INSERT INTO `employer_info` VALUES (6010, 6010, '九言', '九言', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ephqYEb1kicCR1BJdHoib4WEtkHZk8l7QM7yzMUzaicNKTah6GYlLZW3SrPfC4skunCAYWqw1OftuTEg/132', '', NULL, NULL, '', '', '13653958513', '2020-10-15 11:59:47', '2020-10-15 11:59:50', '8004', '6010', 0, '2020-10-15 11:59:49.606');
INSERT INTO `employer_info` VALUES (6011, 6011, '🦡小明🦊', '🦡小明🦊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKaSdSDpHf9jwE1hzVu1W2TP4ajVANMSprjXCHB5DC1rKMdGjTibMxseMWvSTRd2R46YibXkJLFPjtQ/132', '', NULL, NULL, '', '', NULL, '2020-10-15 12:00:26', '2020-10-15 12:00:26', '6010', '6010', 0, '2020-10-15 12:00:26.349');
INSERT INTO `employer_info` VALUES (6012, 6012, '胡博', '胡博', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLFg5tqQZ0MAYVibj1GcPtLdpG1uwSoG8sF197ZVfEM0MdWzNhyzqjCOhZxK0blzhqq4xHFJ4njvfw/132', '', NULL, NULL, '', '', '13466336122', '2020-10-15 12:01:22', '2020-10-15 12:01:26', '2000', '6012', 0, '2020-10-15 12:01:26.346');
INSERT INTO `employer_info` VALUES (6013, 6013, '张泡面', '张泡面', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLGhUVNkpWcgLttLcTtIwNlyqpd1dP0jd6VblyDCaoPvN4291ic4Ht5JpFa1VXECVMQricJApibuxuzA/132', '', NULL, NULL, '', '', '16619715506', '2020-10-15 12:05:43', '2020-10-15 12:05:46', '8009', '6013', 0, '2020-10-15 12:05:45.494');
INSERT INTO `employer_info` VALUES (6014, 6014, 'Sarah Cui 崔艳荣', 'Sarah Cui 崔艳荣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKBjb9zHPLciasrZOExKyjHwdRBeuhZsJ2DBnDxicIM6fwzphjBJXnIqtpR64wMkUuF9tOTpCW3ic9Mg/132', '', NULL, NULL, '', '', '18516265080', '2020-10-15 12:25:43', '2020-10-15 12:25:47', '8011', '6014', 0, '2020-10-15 12:25:47.309');
INSERT INTO `employer_info` VALUES (6015, 6015, '黄婷', '黄婷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJe1PH2ctrLXo7GLKNDUPQUZk4bS3BCM3ic6AA9YVroVSlz1Y8LkWWQMbBnRRNOrP8UGcLVjdxIubQ/132', '', NULL, NULL, '', '', '18618296273', '2020-10-15 12:25:56', '2020-10-15 12:25:59', '8011', '6015', 0, '2020-10-15 12:25:59.207');
INSERT INTO `employer_info` VALUES (6016, 6016, '李雪', '李雪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlRicM4EutouH8pTZsYltHWseCT9qEXLZ66BtZ32JawC2ibmpbgKiaDk3drlmbScLAwwicPNsfjyVMFw/132', '', NULL, NULL, '', '', '15268631865', '2020-10-15 12:34:33', '2020-10-15 12:34:36', '6015', '6016', 0, '2020-10-15 12:34:36.202');
INSERT INTO `employer_info` VALUES (6017, 6017, 'mistletoe🍀', 'mistletoe🍀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/3Nb8UuhjwiaVzSYqQHCTlzpCErC5u1qwCTvcCwd91UUghza0VFrI0PT0TOv9cnajqQQ5FCicD7Ew8AJfFwc93L9w/132', '', NULL, NULL, '', '', '15768716486', '2020-10-15 12:43:12', '2020-10-15 12:43:16', '6016', '6017', 0, '2020-10-15 12:43:16.148');
INSERT INTO `employer_info` VALUES (6018, 6018, '乐成', '乐成', 'https://thirdwx.qlogo.cn/mmopen/vi_32/na6MRMnZwRl4gHbibXOHmLsSutodUN5EpzpicyKGTHjwDpsKVicVia4nLicC87fia87BkxkaZIbMr83wyicZzUwfFFvibw/132', '', NULL, NULL, '', '', '18800176762', '2020-10-15 12:48:57', '2020-10-15 12:49:01', '8013', '6018', 0, '2020-10-15 12:49:01.326');
INSERT INTO `employer_info` VALUES (6019, 6019, '蓝果', '蓝果', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI3HKb6YtXbibUnjvPqDMibmOJM35MvrLict2vTrbvnqbVSpUmo4jwY5MErsjNmXx6XofttfGgEZ7x4g/132', '', NULL, NULL, '', '', '13301312051', '2020-10-15 12:52:12', '2020-10-15 12:52:15', '8012', '6019', 0, '2020-10-15 12:52:15.440');
INSERT INTO `employer_info` VALUES (6020, 6020, '威能&贝雷塔壁挂炉13391653950', '威能&贝雷塔壁挂炉13391653950', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDExlPBTcsr2MoWBv941ia3fjosIibOoXicPpxFvVcafVGib4buSHe6nxicG3yZcAmnxmqUZyPBynLbOw/132', '', NULL, NULL, '', '', '13391653950', '2020-10-15 12:54:07', '2020-10-15 12:54:13', '8012', '6020', 0, '2020-10-15 12:54:13.088');
INSERT INTO `employer_info` VALUES (6021, 6021, 'guoxlong', 'guoxlong', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMFcwG2UicNSPH8kFyg0pBDcViaLKbnPwFDKia5kXnr7WaqMAGfEtIFkAw8LsghNFLXvT4FNwwH1OuQ/132', '', NULL, NULL, '', '', '18311238336', '2020-10-15 13:03:49', '2020-10-15 13:04:35', '8017', '6021', 0, '2020-10-15 13:04:34.742');
INSERT INTO `employer_info` VALUES (6022, 6022, '阿白', '阿白', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLsLkkF6cCgdGLPY8hAibg03PfLHFvFQG5FaG8GFDG5atiaWIXLQAtxHC70XdPA4ibzfawlKd6qKslUw/132', '', NULL, NULL, '', '', '18601350717', '2020-10-15 13:14:37', '2020-10-15 13:14:43', '6021', '6022', 0, '2020-10-15 13:14:42.553');
INSERT INTO `employer_info` VALUES (6023, 6023, 'Jason-AICO', 'Jason-AICO', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ephmeHBXjZU0cia3BAsI0F3tqOxzeKd4jS1g1QHbybE8plN74w4DucWyqWuZ41SKaXdrLClMNAQRog/132', '', NULL, NULL, '', '', '13910210808', '2020-10-15 13:21:16', '2020-10-15 13:21:30', '8023', '6023', 0, '2020-10-15 13:21:29.627');
INSERT INTO `employer_info` VALUES (6024, 6024, '张卷🕴', '张卷🕴', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkQYWxoGC8hEibld9KQ3hvcdeeMCicqCrKwtPzoMHTyAKjsbc0euotB4uYrfhpSguHnPbrA4JeibbAQ/132', '', NULL, NULL, '', '', NULL, '2020-10-15 13:26:19', '2020-10-15 13:26:19', '8027', '8027', 0, '2020-10-15 13:26:18.666');
INSERT INTO `employer_info` VALUES (6025, 6025, 'David.Li', 'David.Li', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoo6uFTgKySGHRP5t0KB0GX6fXflkXddBFpJFia59bkeNSTjo0fJ38j0sxTlZUPXXM5TR2LlYauk6Q/132', '', NULL, NULL, '', '', '18355380522', '2020-10-15 13:29:55', '2020-10-15 13:29:59', '8027', '6025', 0, '2020-10-15 13:29:59.069');
INSERT INTO `employer_info` VALUES (6026, 6026, 'atreyu', 'atreyu', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ermWNtiajr22z8rcFvFY0T65q9icaD2j0fehWsMHmYiaRKK6pBA5aib4CK3RMXyngQ4PTrpDF5Dk8ib8cQ/132', '', NULL, NULL, '', '', '13862026360', '2020-10-15 13:30:00', '2020-10-15 13:30:03', '8027', '6026', 0, '2020-10-15 13:30:03.370');
INSERT INTO `employer_info` VALUES (6027, 6027, '東叔(^㉨^)', '東叔(^㉨^)', 'https://thirdwx.qlogo.cn/mmopen/vi_32/KKV7U228SaJx1A1MYG0Q7aibibdDGMSFQDWZfsywibKrMgXHoTTesPJSj1oKGRjEric4PqJgVZ84u8zMf1xGmd8X9A/132', '', NULL, NULL, '', '', '13436820396', '2020-10-15 13:30:14', '2020-10-15 13:30:20', '8027', '6027', 0, '2020-10-15 13:30:20.448');
INSERT INTO `employer_info` VALUES (6028, 6028, '知遇', '知遇', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLsRhFESf3TwibyJ4xZUtJHTwqICfUz0YmlXNlgPBwYdr0ectNKhS6m6HgxI21sfXlmKPJibPGKfWCA/132', '', NULL, NULL, '', '', '17093032020', '2020-10-15 13:31:14', '2020-10-15 13:31:17', '6026', '6028', 0, '2020-10-15 13:31:16.533');
INSERT INTO `employer_info` VALUES (6029, 6029, 'Econear HR_Grace', 'Econear HR_Grace', 'https://thirdwx.qlogo.cn/mmopen/vi_32/reMf8x6NaE7yWfOvEIVUic7ico3HU4y4MH7Gxo0ia2RbmHObicjjVNEeGiaLWD6gnzRWTib9gHDmlsYy7LxFCYJyq6Sg/132', '', NULL, NULL, '', '', NULL, '2020-10-15 13:32:04', '2020-10-15 13:32:04', '8023', '8023', 0, '2020-10-15 13:32:04.221');
INSERT INTO `employer_info` VALUES (6030, 6030, '志轩', '志轩', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0ojpGnRMCXxmwyOsDBCOML7bWnaFUGSW0EaQl3Sruibw2qibEUldUB1B2AYGVCObEl6DfDm8h86oA/132', '', NULL, NULL, '', '', '15010827586', '2020-10-15 13:33:55', '2020-10-15 13:33:58', '8012', '6030', 0, '2020-10-15 13:33:58.082');
INSERT INTO `employer_info` VALUES (6031, 6031, '🎀germaine🎀', '🎀germaine🎀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/0iaiauALtEFdUVrb5lGsbhJl37aZficEnZGNCaBsyWK7mibjeLlcfelw4xcp2icCCcdTl6kYicHia5kuI8Vhbr3jnibkrw/132', '', NULL, NULL, '', '', '18516614855', '2020-10-15 13:42:51', '2020-10-15 13:42:55', '8017', '6031', 0, '2020-10-15 13:42:55.143');
INSERT INTO `employer_info` VALUES (6032, 6032, '马成功', '马成功', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJO3xWwgMlqWxdZUHE0KFUjfoXQvh15Jj9NZueZuicIKibJUYl3MKeNLn8HicIFzgykg7GaVS7APrptw/132', '', NULL, NULL, '', '', '13910906162', '2020-10-15 13:43:14', '2020-10-15 13:43:18', '8030', '6032', 0, '2020-10-15 13:43:17.558');
INSERT INTO `employer_info` VALUES (6033, 6033, 'zoe', 'zoe', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoZq04zg7Ym4IAkJlA8aNwKozu9ebD9JTxT1LbHZ64Jic7AgzLHgtUFDiaAUQ1sBNIqUUhv0v3mkD1w/132', '', NULL, NULL, '', '', '18768177858', '2020-10-15 13:49:38', '2020-10-15 13:49:41', '6028', '6033', 0, '2020-10-15 13:49:40.619');
INSERT INTO `employer_info` VALUES (6034, 6034, '宁溘死以流亡兮', '宁溘死以流亡兮', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Uq8ibgONzWvwENdYhcHFUfblh2PbC5YUXE4qp35YbHKRJgCye9caM8jIp3cnIXpSDNbWMiashGQyA3nZSw9exxGg/132', '', NULL, NULL, '', '', '18510786711', '2020-10-15 14:01:09', '2020-10-15 14:01:13', '8025', '6034', 0, '2020-10-15 14:01:12.536');
INSERT INTO `employer_info` VALUES (6035, 6035, '林。', '林。', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELaFwfVsJtNNZARlWJZOM8jE4e7dgyianEH7bWEkszCt4yN8jQu0d5lpuMvWvJybfldepkWZFeMXcQ/132', '', NULL, NULL, '', '', '18705040300', '2020-10-15 14:02:59', '2020-10-15 14:03:02', '8031', '6035', 0, '2020-10-15 14:03:02.410');
INSERT INTO `employer_info` VALUES (6036, 6036, 'Anan', 'Anan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6pjAcqAwjE9vREzDicEicyygHrKdhiaBS5J3DDW9VsW8TJfCtOt2iaibRvZ5NciajAc6pOehnub54U0ribQ/132', '', NULL, NULL, '', '', '15848798130', '2020-10-15 14:03:47', '2020-10-15 14:03:52', '6032', '6036', 0, '2020-10-15 14:03:52.354');
INSERT INTO `employer_info` VALUES (6037, 6037, 'Claire.J阿章🦑', 'Claire.J阿章🦑', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er73rJ1CtTVSQibWfqluEiagG3IbY0PNp7EE4y807IeYIvxv4yEu9OBDxb5ROD9D10onMD2Pjb1DBaA/132', '', NULL, NULL, '', '', '15651716250', '2020-10-15 14:07:14', '2020-10-15 14:07:17', '6032', '6037', 0, '2020-10-15 14:07:17.071');
INSERT INTO `employer_info` VALUES (6038, 6038, 'Tony,刘跃生', 'Tony,刘跃生', 'https://thirdwx.qlogo.cn/mmopen/vi_32/LLyKWMqboIiaDgar1ElITjQRj8yDZhWD0IZF2iaCwjgQPtUCG0mIfGuou5xC37sX9Vic8SQKPX8WSMUibfBvicKGKPQ/132', '', NULL, NULL, '', '', NULL, '2020-10-15 14:15:24', '2020-10-15 14:15:24', '8000', '8000', 0, '2020-10-15 14:15:24.257');
INSERT INTO `employer_info` VALUES (6039, 6039, '王小君', '王小君', 'https://thirdwx.qlogo.cn/mmopen/vi_32/FQib9TdrgQwLHJkhxIul1TapmEEQLav5DwMISKXsAvjtzSycPVmRDyofy2PZ92GbmVXHLV4kPLicibpkcAgZgaJRw/132', '', NULL, NULL, '', '', '18910526134', '2020-10-15 14:54:35', '2020-10-15 14:54:42', '8038', '6039', 0, '2020-10-15 14:54:41.615');
INSERT INTO `employer_info` VALUES (6040, 6040, '璠', '璠', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep1TuFVvfjkHSBoEibVgAGge9FNTib2mujPhXv5uWWtcZJrhUGuaKWnaibvYoWtAQ8N5oFumKRtlOwSA/132', '', NULL, NULL, '', '', '15210361561', '2020-10-15 15:13:50', '2020-10-15 15:14:05', '6001', '6040', 0, '2020-10-15 15:14:04.659');
INSERT INTO `employer_info` VALUES (6041, 6041, '邢越', '邢越', 'https://thirdwx.qlogo.cn/mmopen/vi_32/zV5GshvC0GZr0qWu56xLyHOE0GhEEjl3gugE6wFsG1NtnspPpPxTjOG3RYsYBeLA3icEBfWeW5l5Wia9hl1G3gmQ/132', '', NULL, NULL, '', '', '13366203998', '2020-10-15 15:15:27', '2020-10-15 15:15:31', '6040', '6041', 0, '2020-10-15 15:15:31.126');
INSERT INTO `employer_info` VALUES (6042, 6042, '黄明月', '黄明月', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFAeZ8ibXJ9DCb9aCGWcYicINryWA0vYJWlSkPGB1HYFRkrrxOTf683PZ1PYph9XiccGsRI3ZQj7Ohg/132', '', NULL, NULL, '', '', '18801352878', '2020-10-15 15:42:50', '2020-10-15 15:42:53', '8043', '6042', 0, '2020-10-15 15:42:53.395');
INSERT INTO `employer_info` VALUES (6043, 6043, '不愧是我', '不愧是我', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKrVnISvhlRt4LRKXmxwKfhJdpy1w3JdbtILr0td2NN1xKyvZlQMMmbd30q3tIdrBJqQsicmjliczVw/132', '', NULL, NULL, '', '', '18510694664', '2020-10-15 18:09:29', '2020-10-15 18:09:38', '4006', '6043', 0, '2020-10-15 18:09:38.082');
INSERT INTO `employer_info` VALUES (6044, 6044, 'laughing.', 'laughing.', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKlHV0UAj0X8LfGQzooiat3Q9oh93e9Olh8AfTL0ksxyU7D0FmyVcicLnxyVYldo4Txh3h2m8wobIyg/132', '', NULL, NULL, '', '', '13777419035', '2020-10-15 18:14:46', '2020-10-15 18:14:49', '4006', '6044', 0, '2020-10-15 18:14:49.040');
INSERT INTO `employer_info` VALUES (6045, 6045, 'STR', 'STR', 'https://thirdwx.qlogo.cn/mmopen/vi_32/fwYrSMM8GyJIlbFZTlQDXPeOz6MNLlynhZQcZSicHBEPZ7KqjN5A2DYajPu1WLYaXuLAx89ZyCWBLFyGarlbHqw/132', '', NULL, NULL, '', '', '15142314727', '2020-10-15 20:18:05', '2020-10-15 20:18:15', '4000', '6045', 0, '2020-10-15 20:18:15.432');
INSERT INTO `employer_info` VALUES (6046, 6046, '东篱南山品牌设计', '东篱南山品牌设计', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEIXnfgQDv2l5p7kOhzSbKq3rMb10z12yUjG84jbSQAjqQFbZHe1vCsWks2L0Y4jKNnWj1qAhoOBibA/132', '', NULL, NULL, '', '', '18201500208', '2020-10-15 21:27:38', '2020-10-15 21:27:58', '2000', '6046', 0, '2020-10-15 21:27:57.733');
INSERT INTO `employer_info` VALUES (6047, 6047, 'zyn', 'zyn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqCKbuKJNxS8xpXe4PjcibXkUzlhoQvjxRGgOnJNMibqQ8fHtjC5uWibmGL6DPOY8XfYlRLVAOp18ibqw/132', '', NULL, NULL, '', '', '18601279221', '2020-10-15 22:18:14', '2020-10-15 22:18:18', '6012', '6047', 0, '2020-10-15 22:18:17.586');
INSERT INTO `employer_info` VALUES (6048, 6048, 'May🎨', 'May🎨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epkKbmIVtwWUtibicyC6muBMibicrxLBIoB132R0UYa3FvMvqueBSAibAzfULhbbiauE5L9rbzA7TypQqvw/132', '', NULL, NULL, '', '', '18817576509', '2020-10-15 22:32:18', '2020-10-15 22:32:21', '4006', '6048', 0, '2020-10-15 22:32:21.456');
INSERT INTO `employer_info` VALUES (6049, 6049, '姚颖', '姚颖', 'https://thirdwx.qlogo.cn/mmopen/vi_32/MVSskmbLBI8JwguAaHVHCsCbhxfdIeFZTLo1hTbV0sAppba6p5Bm7dOr7NtJbwvUCialXZ0dgfZn6ZmqntQaMxw/132', '', NULL, NULL, '', '', '13671146571', '2020-10-15 23:14:09', '2020-10-15 23:14:14', '2000', '6049', 0, '2020-10-15 23:14:14.204');
INSERT INTO `employer_info` VALUES (6050, 6050, 'argo', 'argo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM7T7x4juP79mADfm66IehFNwp68jSGLunkwiczvQkicGOmx3vyTAmtufpUDbXlHicONBRew8pDtQDEibw/132', '', NULL, NULL, '', '', NULL, '2020-10-16 02:55:13', '2020-10-16 02:55:13', '2000', '2000', 0, '2020-10-16 02:55:13.189');
INSERT INTO `employer_info` VALUES (6051, 6051, '杨建宏@HowWork', '杨建宏@HowWork', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8NMONgicic7pSbkpNOMEx0u2MMV1gM5XORttrBHKmHnO5zZl9ZgVeSwuALaJkibHz5kXAHK84iaIuIw/132', '', NULL, NULL, '', '', '18611928615', '2020-10-16 06:17:35', '2020-10-16 06:17:39', '2000', '6051', 0, '2020-10-16 06:17:38.820');
INSERT INTO `employer_info` VALUES (6052, 6052, 'Hoody', 'Hoody', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIleB7ribGFFGjgwdTMBPicibPDpy8CWFxSAYFicr1B2WVx5ia57FefZc88rBqG0hzJo58cFluUvEtMIYg/132', '', NULL, NULL, '', '', '17611669300', '2020-10-16 08:05:38', '2020-10-16 08:05:43', '4002', '6052', 0, '2020-10-16 08:05:42.802');
INSERT INTO `employer_info` VALUES (6053, 6053, 'Wangyuan', 'Wangyuan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIyGC6TqAOyeBLTQWbFgyN2mPvQmXhibZ7jib6axagibNR5EKNKNWyHiaUKfflHXuytXIgyVvoveD9OCw/132', '', NULL, NULL, '', '', '18616193720', '2020-10-16 10:15:09', '2020-10-16 10:15:17', '6001', '6053', 0, '2020-10-16 10:15:17.177');
INSERT INTO `employer_info` VALUES (6054, 6054, '雪迈', '雪迈', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI6nRIhgjVOM9FyJYAfkBBYldBV76DIfCicQtqTTvvR76yyYh2gK3yAbN5vdd1HlANScYxp1EFcDCw/132', '', NULL, NULL, '', '', '13456966710', '2020-10-16 10:39:01', '2020-10-16 10:39:06', '8058', '6054', 0, '2020-10-16 10:39:06.257');
INSERT INTO `employer_info` VALUES (6055, 6055, '王小央ོ', '王小央ོ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJdursINmHvQCNfBzvzk9udTAhLWrmjAz7lUxDDQ0pWdWfRj4I8pReaJTPIdvCpphRIeSSy6DicujA/132', '', NULL, NULL, '', '', '13605813737', '2020-10-16 10:40:28', '2020-10-16 10:40:30', '6054', '6055', 0, '2020-10-16 10:40:30.386');
INSERT INTO `employer_info` VALUES (6056, 6056, '🎀Le Papillon🎀', '🎀Le Papillon🎀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2Ynhnd93otFJicAVibaBNebiakVuBdA67icTcOx4cFicNib7SKictGNaibbL5hCWrNvia1MadkXT0kT1ekuw/132', '', NULL, NULL, '', '', '13735494363', '2020-10-16 10:59:24', '2020-10-16 10:59:27', '6054', '6056', 0, '2020-10-16 10:59:27.157');
INSERT INTO `employer_info` VALUES (6057, 6057, 'Annie 毛豆', 'Annie 毛豆', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epibZ9NtMMRyjYyViaCK5G3JGUibfh9RUkAvmPguWjFlYrK1BPG1nuklsQHeIk2rE8icSZbtV8vvjZleQ/132', '', NULL, NULL, '', '', '18668075325', '2020-10-16 12:11:27', '2020-10-16 12:11:32', '8064', '6057', 0, '2020-10-16 12:11:32.048');
INSERT INTO `employer_info` VALUES (6058, 6058, '光阴的故事', '光阴的故事', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eox2aVWNRiaXLK7XxMjuicYAEZghFNicVPn1zgzKE5BOSEMkQu5yZUNTVgJ2Xsxa3piajvjgibhvNxRZhQ/132', '', NULL, NULL, '', '', NULL, '2020-10-16 19:15:19', '2020-10-16 19:15:19', '6051', '6051', 0, '2020-10-16 19:15:19.450');
INSERT INTO `employer_info` VALUES (6059, 6059, '王超', '王超', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLC1qvkb7LHMb2Z8ClTbqJqntyXdVmOuPjBL0nFiaKqibzgrN3pVtEMDIiaqfNg0ssamf2TQeZuVt0dQ/132', '', NULL, NULL, '', '', '15810804929', '2020-10-16 19:39:23', '2020-10-16 19:39:32', '6051', '6059', 0, '2020-10-16 19:39:32.489');
INSERT INTO `employer_info` VALUES (6060, 6060, '神经蛙', '神经蛙', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM4yp2lVBsPmTDGp7RzWIEUjDjmic29cJPciaU6pK0pFcrH4n8GBq9N6U13WFqeRHZUkrVhYjv6YHT5A/132', '', NULL, NULL, '', '', NULL, '2020-10-16 19:47:13', '2020-10-16 19:47:13', '8067', '8067', 0, '2020-10-16 19:47:13.116');
INSERT INTO `employer_info` VALUES (6061, 6061, 'Timo', 'Timo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELNoKQeKo5UJIXxF9iaEefYRIjibcAIpwTGibaiaTR6Ue8LjTjDibrNOrJ7jvtq2kCTCUyI44wQyCIOzGA/132', '', NULL, NULL, '', '', '18311080582', '2020-10-16 20:08:02', '2020-10-16 20:08:05', '8045', '6061', 0, '2020-10-16 20:08:04.961');
INSERT INTO `employer_info` VALUES (6062, 6062, '李文波', '李文波', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLHDy8U1uurf45bf0f2DlGRal9hVzkYm0600UW06CLbLHu5wsm7X5UtNKAvPKCljWnsRGdZ07yyTQ/132', '', NULL, NULL, '', '', '18223455359', '2020-10-17 10:02:18', '2020-10-17 10:02:28', '2000', '6062', 0, '2020-10-17 10:02:28.121');
INSERT INTO `employer_info` VALUES (6063, 6063, '谷堆那儿', '谷堆那儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqwoahL8O0Wndx9IjR0sZyxu1eaPpPzFOdmY6yjCNWjHPkPnqQ2TROF54hkpXQLwcPhkicwZrU580w/132', '', NULL, NULL, '', '', '13525516792', '2020-10-17 12:14:49', '2020-10-17 12:14:59', '6007', '6063', 0, '2020-10-17 12:14:59.087');
INSERT INTO `employer_info` VALUES (6064, 6064, 'nora', 'nora', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJAqVXYe3LJ7IBlUvSx5GwuDLaKqoD2I7bkb3LrxPCS1K2Cd2hn7W6O2dLEYonruBTLKKIX5mt0lQ/132', '', NULL, NULL, '', '', '13693065582', '2020-10-18 18:26:46', '2020-10-18 18:26:51', '2000', '6064', 0, '2020-10-18 18:26:51.394');
INSERT INTO `employer_info` VALUES (6065, 6065, '怡然', '怡然', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIUrbLAzgYEiaAO3tC99hKnmayErfHEt02iacoKw1pcvO72GEdWYnEFS535iaeGkhqiaQZ7Ko1gRbjWCw/132', '', NULL, NULL, '', '', NULL, '2020-10-18 19:11:53', '2020-10-18 19:11:53', '2000', '2000', 0, '2020-10-18 19:11:53.479');
INSERT INTO `employer_info` VALUES (6066, 6066, '陈碧天', '陈碧天', 'https://thirdwx.qlogo.cn/mmhead/Yr1LMYX6KTaOlic5qThibhniaX1T6hiciaLYsFhy1tIC8UQw/132', '', NULL, NULL, '', '', NULL, '2020-10-18 20:55:40', '2020-10-18 20:55:40', '2000', '2000', 0, '2020-10-18 20:55:40.350');
INSERT INTO `employer_info` VALUES (6067, 6067, '品牌创新@李前承', '品牌创新@李前承', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er3dqNm0UyWrSLMnQumsBGVeK7uzI1lk3JiaLBqFPRXq7hIvSlK5IlBBlNCtTUAsU8QBeNatoaZwKA/132', '', NULL, NULL, '', '', '18610441168', '2020-10-19 13:31:50', '2020-10-19 13:31:58', '2000', '6067', 0, '2020-10-19 13:31:57.855');
INSERT INTO `employer_info` VALUES (6068, 6068, '乔儿天堂', '乔儿天堂', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlnvVBN1uUEbgSSTz3Vztk7k4Yj2lpicTFCSscVVxmTT1T3KZ4icUicfaX6qOJaqJ9SgHRp84Ohicnhg/132', '', NULL, NULL, '', '', '18610846949', '2020-10-19 16:22:07', '2020-10-19 16:22:11', '2007', '6068', 0, '2020-10-19 16:22:11.373');
INSERT INTO `employer_info` VALUES (6069, 6069, '🍓🍓Candice🍫🍫', '🍓🍓Candice🍫🍫', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqjso4Rb5ckR7GnUmdhYiblicbjpguoEUGSmx3fliadvHtYnMC4IeTQlkIZ4m00ibtMzUOiaFKNmmxCQug/132', '', NULL, NULL, '', '', '15158001797', '2020-10-19 16:48:35', '2020-10-19 16:48:39', '2007', '6069', 0, '2020-10-19 16:48:38.533');
INSERT INTO `employer_info` VALUES (6070, 6070, 'CAIAMOON.', 'CAIAMOON.', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELAI2gF3cf0vEic33ewOkLxDJFZ3E4aE8scRvXOic0ibJWNiacg8GopJhYh2s3DAzAUALUdy4ccE3Biaew/132', '', NULL, NULL, '', '', '13312179561', '2020-10-19 17:22:05', '2020-10-19 17:22:07', '4000', '6070', 0, '2020-10-19 17:22:07.061');
INSERT INTO `employer_info` VALUES (6071, 6071, '何同学', '何同学', 'https://thirdwx.qlogo.cn/mmopen/vi_32/1hWoDcsZhfPHyZ4xt9XeFqPSwqX89oMwnVwNTF4nxJ9Qof1Nwt7OktfljwTiaUqDuzrd2BB6zYnugn8uef9sibWg/132', '', NULL, NULL, '', '', '18848427790', '2020-10-19 21:31:02', '2020-10-19 21:31:06', '4000', '6071', 0, '2020-10-19 21:31:05.652');
INSERT INTO `employer_info` VALUES (6072, 6072, '刘育轩', '刘育轩', 'https://thirdwx.qlogo.cn/mmhead/T9CEia0v4OAyhxhrHxUzOkzBozsK8O4vGzcNciagUJF7w/132', '', NULL, NULL, '', '', NULL, '2020-10-20 06:58:02', '2020-10-20 06:58:02', '6051', '6051', 0, '2020-10-20 06:58:01.703');
INSERT INTO `employer_info` VALUES (6073, 6073, 'Forward', 'Forward', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJN4dfKu52ZJjkK7MQO1KZaUJfLOpr928Osvic2ibvPOplxaBZB6urZuwDPgNGLrsnflFtCBSxrJ4Mg/132', '', NULL, NULL, '', '', NULL, '2020-10-20 09:30:38', '2020-10-20 09:30:38', '8082', '8082', 0, '2020-10-20 09:30:37.875');
INSERT INTO `employer_info` VALUES (6074, 6074, '梁东东', '梁东东', 'https://thirdwx.qlogo.cn/mmopen/vi_32/arTfyC2qkmC5icc1ld04oVkxjmbFzoTjTQSC5ncqxurD4u7zGvQgFCRk9jOSasXMweySNtWLdY6Zu3ImfDMkpLg/132', '', NULL, NULL, '', '', '18758063850', '2020-10-20 09:33:58', '2020-10-20 09:34:02', '8082', '6074', 0, '2020-10-20 09:34:01.542');
INSERT INTO `employer_info` VALUES (6075, 6075, '七月WYJ', '七月WYJ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI2Pn31hdYEmaWck2GcMUVLLs4PfZTLZvD6BOKDs6Eia1NC7G4MF82OshChukDzICutpe7XeRiajCIw/132', '', NULL, NULL, '', '', '15801255241', '2020-10-20 10:21:48', '2020-10-20 10:21:52', '4000', '6075', 0, '2020-10-20 10:21:52.285');
INSERT INTO `employer_info` VALUES (6076, 6076, '窦恒山', '窦恒山', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PFjOr4mUMXNTPe94Jnd461neS96tUXD044EgzxwNk4cIX9WIgORuLYTFYYZlRIykw0qp6asGL7X0yZGyvpibEicg/132', '', NULL, NULL, '', '', '13412133311', '2020-10-20 14:57:08', '2020-10-20 14:57:12', '8038', '6076', 0, '2020-10-20 14:57:12.292');
INSERT INTO `employer_info` VALUES (6077, 6077, '邓一些', '邓一些', 'https://thirdwx.qlogo.cn/mmopen/vi_32/V5Q9iapkWRXatRhcl0Sj2YjgBHhgV9vkpTOxxMKNamTIzUJ59xLyqtHCS7n83qfYyI2pOCfSO3dI8efQibDVI4oQ/132', '', NULL, NULL, '', '', '18200261273', '2020-10-20 19:43:53', '2020-10-20 19:43:56', '8057', '6077', 0, '2020-10-20 19:43:55.865');
INSERT INTO `employer_info` VALUES (6078, 6078, 'Li', 'Li', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eosBbjRJshvOAfWWqF1xIRUsJa8icbicD5wnXWMVEuI46uWL8dBWfUjsmnO367fKOOfmwu1HHQNE06Q/132', '', NULL, NULL, '', '', '13152682260', '2020-10-21 12:54:12', '2020-10-21 12:54:16', '8088', '6078', 0, '2020-10-21 12:54:15.954');
INSERT INTO `employer_info` VALUES (6079, 6079, '静下来', '静下来', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvGAUEPO8BsJGvR1gd1kclib3IJOAusLzyvneIUSOtzUY6UqMiaXJ6CNJBOYHsm8MHpiaV7yvRY7eKA/132', '', NULL, NULL, '', '', '13588198469', '2020-10-21 13:42:37', '2020-10-21 13:42:40', '6078', '6079', 0, '2020-10-21 13:42:40.397');
INSERT INTO `employer_info` VALUES (6080, 6080, 'ivy Han', 'ivy Han', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNbIV6xOa8ZFfuN9lyO54aMxEO0MIYib8TSndleJPOoqyS8HqFF0aC8bHo15rICCd8XQvhvflmiaibw/132', '', NULL, NULL, '', '', '13911797317', '2020-10-21 16:54:09', '2020-10-21 16:54:13', '8071', '6080', 0, '2020-10-21 16:54:12.714');
INSERT INTO `employer_info` VALUES (6081, 6081, '方静', '方静', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKu71e4qLenziaoIqXov5U4ykVicpbWswH7UG4gicoLbuIGDqs3hXXt31L6o3kG8ib7KemzsXrXHGquEw/132', '', NULL, NULL, '', '', '18511879025', '2020-10-21 17:36:48', '2020-10-21 17:36:53', '8071', '6081', 0, '2020-10-21 17:36:53.077');
INSERT INTO `employer_info` VALUES (6082, 6082, '王慧龙', '王慧龙', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLzozxBUdRvxq2tSic1Ea2UG9kmY9tadp2AtRw6SbFCNWhX6twLxUmbRKmiciah5R3CMS6UtojicOaBWw/132', '', NULL, NULL, '', '', '18518889381', '2020-10-21 18:09:38', '2020-10-21 18:09:42', '2007', '6082', 0, '2020-10-21 18:09:42.483');
INSERT INTO `employer_info` VALUES (6083, 6083, '黄旭', '黄旭', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJHxkkgSjibsAZoaicYuuGibbPq6Ce8tVia1YMfMhtHVENFib03vfSLRWFOGYib0UF8YuL3c6mJrV3vgMHg/132', '', NULL, NULL, '', '', '15801054575', '2020-10-21 18:15:25', '2020-10-21 18:15:27', '6082', '6083', 0, '2020-10-21 18:15:27.469');
INSERT INTO `employer_info` VALUES (6084, 6084, '九日', '九日', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKn4kHQ8TTzaegUzHtEXvG2kcJTZu0rjVlqkWqo8bAaHb3bib4bVDnnJP9juibLS5G1zGOKneiaiaqz2A/132', '', NULL, NULL, '', '', '15545140725', '2020-10-21 18:17:51', '2020-10-21 18:17:54', '8092', '6084', 0, '2020-10-21 18:17:53.514');
INSERT INTO `employer_info` VALUES (6085, 6085, '莹冰瑾儿', '莹冰瑾儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epjqiaHW4b2vXBT9KZ0DWMOURleRo26R5ibj3icn9EsCaibe6akK2B9FkaITF4zh7fXNhiaIDqT8Z6qlpg/132', '', NULL, NULL, '', '', '18611488140', '2020-10-21 18:38:53', '2020-10-21 18:38:57', '6084', '6085', 0, '2020-10-21 18:38:56.866');
INSERT INTO `employer_info` VALUES (6086, 6086, '王振', '王振', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gIiarlMOiaFbboIjJ4hiahjoCcibKzpGPW5YK00Y8ibhxKicezm0RH97JXJoC69AYib9QrbqNxIOiaTVCHv0HtnSYaGnag/132', '', NULL, NULL, '', '', '17607092191', '2020-10-21 22:00:14', '2020-10-21 22:00:17', '4002', '6086', 0, '2020-10-21 22:00:17.156');
INSERT INTO `employer_info` VALUES (6087, 6087, 'Marlboro', 'Marlboro', 'https://thirdwx.qlogo.cn/mmopen/vi_32/M0TTYA7lvC2crMFYYscn0ovo3TuNAbVMLfiarDibKC0LicuebwqRia98n7H9g4YAJR2ktiaia8CAJZIsscbXsNy4aZ0w/132', '', NULL, NULL, '', '', '17710859219', '2020-10-21 22:44:08', '2020-10-21 22:44:13', '4000', '6087', 0, '2020-10-21 22:44:12.800');
INSERT INTO `employer_info` VALUES (6088, 6088, '晨', '晨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJAFFqEfyLFBfpgmibEVGtnMqCttGHXe4e35AsSvN1z9427OORibIFRx9y5jmYYLOgia16MApEpmFWYA/132', '', NULL, NULL, '', '', '15110035921', '2020-10-22 12:33:34', '2020-10-22 12:33:40', '8096', '6088', 0, '2020-10-22 12:33:39.878');
INSERT INTO `employer_info` VALUES (6089, 6089, '宋彬', '宋彬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqOy2ibz4SMIniaic7teEj5S3L2f6lmTJmWSI8sbUJn80HZC2iaXzUAJEWWdFggMVBHmibI87DicJz4icibTA/132', '', NULL, NULL, '', '', '18611408328', '2020-10-22 15:09:41', '2020-10-22 15:09:45', '8097', '6089', 0, '2020-10-22 15:09:45.179');
INSERT INTO `employer_info` VALUES (6090, 6090, '张天翼', '张天翼', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK4iawQfJ55JXAVnx1xRJVxMYrsjYlFG5ticpDdzrqyfiaIABODdGBHua5XqjMA43rtHbQibJibsVXZGoA/132', '', NULL, NULL, '', '', '18618359599', '2020-10-22 17:13:03', '2020-10-22 17:13:06', '6089', '6090', 0, '2020-10-22 17:13:05.848');
INSERT INTO `employer_info` VALUES (6091, 6091, 'Samuel', 'Samuel', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJHhWv7puygLAeOC79G4GxjTQWdoibgZgc2NcdTKvUcMGXHFHzDEv60biaDAorIKI3ELWVWjaDnazg/132', '', NULL, NULL, '', '', '17610398193', '2020-10-22 17:17:51', '2020-10-22 17:17:53', '6090', '6091', 0, '2020-10-22 17:17:53.260');
INSERT INTO `employer_info` VALUES (6092, 6092, '曲玉杰', '曲玉杰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epM5Ka8Nmm1wOnr2MHU8hQ9icpykJGhjxGWslNS18qibc2oMxO3zRIwOU3kE00511FHq388HlglTvjw/132', '', NULL, NULL, '', '', '17790005266', '2020-10-22 19:14:40', '2020-10-22 19:14:42', '6051', '6092', 0, '2020-10-22 19:14:42.203');
INSERT INTO `employer_info` VALUES (6093, 6093, '王晶', '王晶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/sSj0tx5KicEUeWiar1hmtemxEoSl3ibW98MfOrwrGL1LrlhE43bW3M0ZIwuHbyapa0rKiciaiaQLPur6zbVribaZ9JWzA/132', '', NULL, NULL, '', '', '15801573218', '2020-10-23 15:49:18', '2020-10-23 15:49:22', '4000', '6093', 0, '2020-10-23 15:49:21.888');
INSERT INTO `employer_info` VALUES (6094, 6094, 'Jan_keor', 'Jan_keor', 'https://thirdwx.qlogo.cn/mmopen/vi_32/3fRpE6VAWTPsH8yUh4YjbymfZHOHfgHqQI2Zyvec5U9yLZcHIW1ucd53JnaHzBjB7wicSa0jOxyY0wNrLU3Qu3A/132', '', NULL, NULL, '', '', '17339803665', '2020-10-25 21:45:18', '2020-10-25 21:45:21', '4000', '6094', 0, '2020-10-25 21:45:21.257');
INSERT INTO `employer_info` VALUES (6095, 6095, 'Aser Uni.  刘浩', 'Aser Uni.  刘浩', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epF5HjX9nJJg43UPKn9blG3fp9viaopDRfmzxic8Z7Mialiacx6u9Cj3D8YOiaQ5YKO0TgJYFvmZjJ9uZg/132', '', NULL, NULL, '', '', '15901210350', '2020-10-26 10:50:05', '2020-10-26 10:50:09', '6042', '6095', 0, '2020-10-26 10:50:08.832');
INSERT INTO `employer_info` VALUES (6096, 6096, '欢乐马', '欢乐马', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6k7ic5JOARZrh4wWV5lxC7xNALwudqib8h4CgLibHadhoO1yRh5UhONGsMBjTJIxxevQhwWSIlxhsZg/132', '', NULL, NULL, '', '', NULL, '2020-10-26 11:28:07', '2020-10-26 11:28:07', '6095', '6095', 0, '2020-10-26 11:28:06.738');
INSERT INTO `employer_info` VALUES (6097, 6097, '小南🌀', '小南🌀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8uiaErzMEKjGGaukYuOJQ1iauLkL3HhebdVzkjb3TY5Idgvfd0j9kfmzxmlCKLCn1cKt23XD37noQ/132', '', NULL, NULL, '', '', '17891938143', '2020-10-26 12:53:35', '2020-10-26 12:53:38', '8106', '6097', 0, '2020-10-26 12:53:37.557');
INSERT INTO `employer_info` VALUES (6098, 6098, 'echo-做灵魂有香气的女人', 'echo-做灵魂有香气的女人', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK1AEBmld3BjASpC3A9lBKAC7KVTSdM77cxKXhJ6ddPX5uvtzIXicnYuVMzhQGgJ48NH4S65vcqP8w/132', '', NULL, NULL, '', '', '13911526263', '2020-10-27 13:17:20', '2020-10-27 13:17:23', '8105', '6098', 0, '2020-10-27 13:17:22.889');
INSERT INTO `employer_info` VALUES (8000, 8000, '海欧', '海欧', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELichXBRHPFJJjEBqtqeEcTsk0yOh1KkIibO3MY3ttZSdfpQfqlEPCICSLhJ9N2KsApe2y8pGJSQCLw/132', '', NULL, NULL, '', '', '15910991142', '2020-10-15 08:47:35', '2020-10-15 08:47:38', '4005', '8000', 0, '2020-10-15 08:47:38.043');
INSERT INTO `employer_info` VALUES (8001, 8001, '海康', '海康', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6pvv3THEQbUY98UojFWzk0AVYpRmr5Mia8o9vJNC9719RAicNpCMxGMIGt4brztlEaZiboQmVr3iaYng/132', '', NULL, NULL, '', '', '13957101219', '2020-10-15 10:52:32', '2020-10-15 10:52:42', '6004', '8001', 0, '2020-10-15 10:52:41.775');
INSERT INTO `employer_info` VALUES (8002, 8002, '春雪', '春雪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzAlRUIpHn19hxzdibP91hV2GGfY79dGItfNlXqBibDV3pox2EZFZCtic8cA1XDhukAUfatSmkyM6icA/132', '', NULL, NULL, '', '', '13810990272', '2020-10-15 11:00:04', '2020-10-15 11:00:08', '8001', '8002', 0, '2020-10-15 11:00:08.229');
INSERT INTO `employer_info` VALUES (8003, 8003, '职小氧', '职小氧', 'https://thirdwx.qlogo.cn/mmopen/vi_32/iblPs6icGX5tHiasTce2V19Hfg20FRU6iazghGSX5CDLlyqabdE8Qvlichdb46L3iafTXq7KAWCTuoURzU8eU4qQq4Sw/132', '', NULL, NULL, '', '', '13241937740', '2020-10-15 11:46:31', '2020-10-15 11:46:44', '4023', '8003', 0, '2020-10-15 11:46:44.474');
INSERT INTO `employer_info` VALUES (8004, 8004, 'QwwwtQ.Garlic', 'QwwwtQ.Garlic', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIr5qh5IzgYOwicLP8O24g94vK3Yr79LUnZ98c88UVDIvU2BBUDdsUvUBXHaGpaKEkvZib7q6H8Q0Fw/132', '', NULL, NULL, '', '', '15684235313', '2020-10-15 11:52:34', '2020-10-15 11:52:38', '2001', '8004', 0, '2020-10-15 11:52:37.738');
INSERT INTO `employer_info` VALUES (8005, 8005, 'Ashley', 'Ashley', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoqjHhMt0NJMMFibPuKafiaAcwA1IatbzOpGV7S8IPx2yWBIaKxyt7YFyKWv8JFcd4uLX3CBemVCLbA/132', '', NULL, NULL, '', '', '18622048296', '2020-10-15 11:58:22', '2020-10-15 11:58:24', '4023', '8005', 0, '2020-10-15 11:58:23.760');
INSERT INTO `employer_info` VALUES (8006, 8006, 'Wei魏Xin欣', 'Wei魏Xin欣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epPYGNLqbQqkXPHznghqmfKeicvR5xILxCfq2ZIbkSZwgWSWHNjaBEDrrac5r8uSqJoKiaSBkE6PvLg/132', '', NULL, NULL, '', '', '13911096678', '2020-10-15 12:00:20', '2020-10-15 12:00:23', '6010', '8006', 0, '2020-10-15 12:00:23.291');
INSERT INTO `employer_info` VALUES (8007, 8007, 'XIBEI', 'XIBEI', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUBK2NThItVVXyUwBsAzMkldwRMkeJUzGF1BM6Lm1MxMTNdwTywzkCtbcEzqeNrTD1NDjD0222Vg/132', '', NULL, NULL, '', '', NULL, '2020-10-15 12:02:37', '2020-10-15 12:02:37', '6012', '6012', 0, '2020-10-15 12:02:36.766');
INSERT INTO `employer_info` VALUES (8008, 8008, 'Sabrina 随心而动🌻🌻', 'Sabrina 随心而动🌻🌻', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFJTkiavo03epmkh6ye8S2lepl2WXmVjmmpwDUbq3TwiaLauyMUx56fYrjS3oVK313LiaudsLQIn7LQ/132', '', NULL, NULL, '', '', '18911867225', '2020-10-15 12:03:44', '2020-10-15 12:03:48', '8006', '8008', 0, '2020-10-15 12:03:47.620');
INSERT INTO `employer_info` VALUES (8009, 8009, 'max', 'max', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhox8vabohu5ia2TibQEMr6sd6XzN1Iia0k7uNYXOP9BZnzLPYE4g45SmdlN8ibDjLtzI2gJbKtdzS0A/132', '', NULL, NULL, '', '', '18660787032', '2020-10-15 12:04:46', '2020-10-15 12:05:09', '8008', '8009', 0, '2020-10-15 12:05:08.771');
INSERT INTO `employer_info` VALUES (8010, 8010, 'mikeliang', 'mikeliang', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep7hHnEjgzNXibWnN4OJhw1ZwncGjl7PVLDHAHmURbgxHRlLaXOH4UjBriawIVM0fbkAhgtqP23CDXw/132', '', NULL, NULL, '', '', NULL, '2020-10-15 12:09:59', '2020-10-15 12:09:59', '6013', '6013', 0, '2020-10-15 12:09:58.772');
INSERT INTO `employer_info` VALUES (8011, 8011, '梅子·王', '梅子·王', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLxVbGPArsC7fibdRsgLWnn72tdGfkwMh4PgVuYrxLjJbIIhJHNcqtvuCxv9rEXVTT76KYhbjib4myA/132', '', NULL, NULL, '', '', '13601171808', '2020-10-15 12:17:04', '2020-10-15 12:17:07', '2023', '8011', 0, '2020-10-15 12:17:07.380');
INSERT INTO `employer_info` VALUES (8012, 8012, 'Soymilk_伟伟', 'Soymilk_伟伟', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo0792qtdS7OdQkR4ETO7hd21yp2USVhq4ln20jUChS1F2XfhIUClBNhA3Q8rWe9Rzl4UZnsZ4p0Q/132', '', NULL, NULL, '', '', '15011403503', '2020-10-15 12:46:36', '2020-10-15 12:46:39', '2016', '8012', 0, '2020-10-15 12:46:39.036');
INSERT INTO `employer_info` VALUES (8013, 8013, '四点木', '四点木', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epYxxeNAaAbJ6ibEDoI40BiaLM7Oq7nXh8AKvoV4N1besvfmzkHjow1zNiachMUbrp0Vibg9VDfSHOR3g/132', '', NULL, NULL, '', '', '17338132894', '2020-10-15 12:48:35', '2020-10-15 12:48:37', '8012', '8013', 0, '2020-10-15 12:48:37.490');
INSERT INTO `employer_info` VALUES (8014, 8014, '羊羊', '羊羊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqnstgIcP9rjEoqcJNRibqI39PIiaGz0MGkicN6jXBR2iaelmmTTeSXLTT1DJXBfV77EpIK4E3fZJZTXA/132', '', NULL, NULL, '', '', '15810487960', '2020-10-15 12:51:27', '2020-10-15 12:51:29', '8013', '8014', 0, '2020-10-15 12:51:29.376');
INSERT INTO `employer_info` VALUES (8015, 8015, 'Xiaoluxin', 'Xiaoluxin', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoe2f5xCkDU6xsdu3bXtcDRiczy6NWwW9lDfxicIacSlNFMuUUtGEedVIOpdTdTibxfTE6zE1ibE3HXKg/132', '', NULL, NULL, '', '', '17600117292', '2020-10-15 12:53:01', '2020-10-15 12:53:06', '6019', '8015', 0, '2020-10-15 12:53:05.671');
INSERT INTO `employer_info` VALUES (8016, 8016, 'yuan', 'yuan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erxFSbdeu9BzrcNX4ialX0nLwpu92yJ4EnObwVWEL7MriccKNlThqNktB6f2j3BGYic8Cts3wbsA0mcA/132', '', NULL, NULL, '', '', '15110084810', '2020-10-15 13:02:03', '2020-10-15 13:02:06', '8015', '8016', 0, '2020-10-15 13:02:05.828');
INSERT INTO `employer_info` VALUES (8017, 8017, '陈雪芳-招募优秀合伙人', '陈雪芳-招募优秀合伙人', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKnshNur7anWHic367tLyhRWMklFxAF5nkjkfX9SGqA5rmxHYic7zwC92eqgGVcD66taka35QPsWkaQ/132', '', NULL, NULL, '', '', '18001276699', '2020-10-15 13:03:22', '2020-10-15 13:03:26', '8016', '8017', 0, '2020-10-15 13:03:25.971');
INSERT INTO `employer_info` VALUES (8018, 8018, '何艳Emma', '何艳Emma', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eokaqGurEhbEatAoaW90qDkDbSyY3GN7vvrBIicOa1yibu8DOhnsaBtHRoT1kmvjiaYtjkW1dbQzcdFg/132', '', NULL, NULL, '', '', '13814898564', '2020-10-15 13:04:05', '2020-10-15 13:04:08', '8016', '8018', 0, '2020-10-15 13:04:07.671');
INSERT INTO `employer_info` VALUES (8019, 8019, '见清丶', '见清丶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Uh0jwI3gFfYPiaMyZlkMYfqxicZF6qDq7yWheZXd4TM5PSbCbNdOMBxLCkE2dcaVVxdMG1Od2rJ6vudsXxcVaFSw/132', '', NULL, NULL, '', '', '13263113883', '2020-10-15 13:05:50', '2020-10-15 13:05:53', '6021', '8019', 0, '2020-10-15 13:05:53.189');
INSERT INTO `employer_info` VALUES (8020, 8020, 'lzm', 'lzm', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJUXwG4RBCSRnFRtUic9tBv6Z7pAKc8PRicKQbS52Ou23veGEqF5dhDwvoUugCGbAVW3rJsluQpkJlQ/132', '', NULL, NULL, '', '', '18600185840', '2020-10-15 13:13:10', '2020-10-15 13:13:14', '6021', '8020', 0, '2020-10-15 13:13:13.496');
INSERT INTO `employer_info` VALUES (8021, 8021, 'Molly', 'Molly', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq5tGdX9BaiaOqic8BScoUsvXIB1JxgJdIZn6kicMjuLhDObTz1USvZnvzPgciaEqCAko0IFJt3ibME3qA/132', '', NULL, NULL, '', '', '17717373289', '2020-10-15 13:14:00', '2020-10-15 13:14:07', '8017', '8021', 0, '2020-10-15 13:14:06.704');
INSERT INTO `employer_info` VALUES (8022, 8022, '小盆胡同26号', '小盆胡同26号', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzZ4X8pyxDBI5KSTZLoh1YuE9Lvqrel3b4WuiasUCjia9aq0lTx6wTodxiamWLDkzdrZprkicibic6RBNA/132', '', NULL, NULL, '', '', NULL, '2020-10-15 13:14:36', '2020-10-15 13:14:36', '2000', '2000', 0, '2020-10-15 13:14:35.509');
INSERT INTO `employer_info` VALUES (8023, 8023, '尹東亮', '尹東亮', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er1PWO9LvHrCJ88iaQLiaiauSMGjBpXtgUSjIVJmnf0hmSUqVFDzxOFueNPGZ1PfJe6baKhnkBeXRr4Q/132', '', NULL, NULL, '', '', '13953167399', '2020-10-15 13:18:53', '2020-10-15 13:18:59', '6014', '8023', 0, '2020-10-15 13:18:59.011');
INSERT INTO `employer_info` VALUES (8024, 8024, '逸少', '逸少', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKHS6mbJv3Cq81AnEh9UUNibeB1rAq0jwhRiaNIMQot3mhYvSK9sWNBqg6ib2BIJOS49cQ9c6t2pvusA/132', '', NULL, NULL, '', '', '18911599015', '2020-10-15 13:21:58', '2020-10-15 13:22:02', '6022', '8024', 0, '2020-10-15 13:22:01.839');
INSERT INTO `employer_info` VALUES (8025, 8025, 'Rita 💅🏼', 'Rita 💅🏼', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqbfcFTFtXUTbb9wBOK2NHqjOLrgZE15GnKqU2M3audIOBQWia3vSvVlOJIZLj91REOH4CeF09Ds9w/132', '', NULL, NULL, '', '', '15101132569', '2020-10-15 13:23:20', '2020-10-15 13:23:25', '6022', '8025', 0, '2020-10-15 13:23:24.724');
INSERT INTO `employer_info` VALUES (8026, 8026, 'Jimmy', 'Jimmy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqOJicoW6pibhIibacZzasRb92YrVRhkxRxfSiaibMS3fpkD3ZllM8mXLNd98Uvib41WXoA3mjYsOxB1SIw/132', '', NULL, NULL, '', '', NULL, '2020-10-15 13:24:37', '2020-10-15 13:24:37', '6022', '6022', 0, '2020-10-15 13:24:37.342');
INSERT INTO `employer_info` VALUES (8027, 8027, '桑雷德', '桑雷德', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKvEAPIBicZTWRFhXsQM4DJ99CDRm9Ria1qOy5OS7AXY1VAPF7cRqJJibq00x5OLVrMrV5ul7yCJIc9g/132', '', NULL, NULL, '', '', '18614085713', '2020-10-15 13:25:55', '2020-10-15 13:25:57', '8025', '8027', 0, '2020-10-15 13:25:57.083');
INSERT INTO `employer_info` VALUES (8028, 8028, 'Klein', 'Klein', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erFX1iaOwOQNbVP1x4NBq4x9toic96MMk5tHh7iaRHChIuISyPKBfnrepUsiaGEWKNBljzj1HSHBDkkBA/132', '', NULL, NULL, '', '', '18500202468', '2020-10-15 13:26:34', '2020-10-15 13:26:38', '8027', '8028', 0, '2020-10-15 13:26:38.277');
INSERT INTO `employer_info` VALUES (8029, 8029, '孙宇铃', '孙宇铃', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLCeW8CkSDSvM8fzUI4MLSh8ibR1vXxWf4hBmulI0shc7l77hEUYibqvHNdXaq9ibBuOIBIjmicFZicKiaibg/132', '', NULL, NULL, '', '', NULL, '2020-10-15 13:38:01', '2020-10-15 13:38:01', '8017', '8017', 0, '2020-10-15 13:38:00.984');
INSERT INTO `employer_info` VALUES (8030, 8030, 'Peter Wang', 'Peter Wang', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq7Xn99rwicjibkaz05ibdYfvD9RvUgQLBl5FIZN53cd6RSUy3o0I8JNn3mQZFkLZmmTUR3tBQkZibSkA/132', '', NULL, NULL, '', '', '13820979077', '2020-10-15 13:38:54', '2020-10-15 13:38:59', '8017', '8030', 0, '2020-10-15 13:38:58.528');
INSERT INTO `employer_info` VALUES (8031, 8031, 'cteen”', 'cteen”', 'https://thirdwx.qlogo.cn/mmopen/vi_32/9GfxzBVyich4eBXLcARcWc9fj9vib8h9TlwMbCP0tS1JeaoAsw1Jg3CV3Wl1GnibpKib4LgQ0XialO1rDcqia0oYLjQA/132', '', NULL, NULL, '', '', '15889967907', '2020-10-15 13:46:37', '2020-10-15 13:46:40', '6032', '8031', 0, '2020-10-15 13:46:40.206');
INSERT INTO `employer_info` VALUES (8032, 8032, 'July', 'July', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq80Ns72njENQlGlXGicPibB25ZGOic8hSJ6DhvicNyh9N5zhJG4uOzDX61L7Ll2xWRNe2KvV5fJcHPrg/132', '', NULL, NULL, '', '', '18210566605', '2020-10-15 13:53:56', '2020-10-15 13:53:58', '6033', '8032', 0, '2020-10-15 13:53:58.220');
INSERT INTO `employer_info` VALUES (8033, 8033, '岸芷汀兰', '岸芷汀兰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJXZOE1LAocibr1CetxMnyBP8vJlib1HCMBP4IKrpGSJou4luDteiaYqJNNSF3BJZQVTrkLKuj9yFD3w/132', '', NULL, NULL, '', '', NULL, '2020-10-15 14:04:58', '2020-10-15 14:04:58', '8017', '8017', 0, '2020-10-15 14:04:58.067');
INSERT INTO `employer_info` VALUES (8034, 8034, '刘德深', '刘德深', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKQxjfRMbm4Y2v6Cy2no7Tnria9TID9TTHTqlYvv5ryVjzkXSTuQpG3Qcrn7I3NEReH03rIAqT9Xng/132', '', NULL, NULL, '', '', '15618938725', '2020-10-15 14:10:31', '2020-10-15 14:10:45', '8030', '8034', 0, '2020-10-15 14:10:45.274');
INSERT INTO `employer_info` VALUES (8035, 8035, '胥博', '胥博', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIBYicns3ugAyibCsmHviaEicB9wvwiaIJc0fORuj4QT4xEXlvfOzOYlsfxTIkI6DjfzTV8OfLv17kN1pQ/132', '', NULL, NULL, '', '', '17512588868', '2020-10-15 14:25:16', '2020-10-15 14:25:21', '8000', '8035', 0, '2020-10-15 14:25:20.496');
INSERT INTO `employer_info` VALUES (8036, 8036, 'skcl', 'skcl', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqA3Gz9ibbWwMRke1o8ObncFRkyr9hiaX5Gq1fQia5dNtH07Rdx9I5vLAll6IibicpdKpTge0ic3P7wrAIw/132', '', NULL, NULL, '', '', '17625193410', '2020-10-15 14:31:55', '2020-10-15 14:31:57', '8017', '8036', 0, '2020-10-15 14:31:57.351');
INSERT INTO `employer_info` VALUES (8037, 8037, '蓝黎冲   ', '蓝黎冲   ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJpdoetgNjXACibmgIWb9FXHTUgBpsOWwIPDz6IAh8uTjm0zMbhZT0PrgNQXxicubE8wbeAYkwIqr3A/132', '', NULL, NULL, '', '', '15122025218', '2020-10-15 14:33:56', '2020-10-15 14:34:01', '8003', '8037', 0, '2020-10-15 14:34:01.018');
INSERT INTO `employer_info` VALUES (8038, 8038, '-', '-', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzmBzIeVHkjkIIBYbxtzelTjdDpDobSDFcPmic0ibMs5OO37e1edPmyv7mnjDwCsBr8YTX87Go0WQw/132', '', NULL, NULL, '', '', '13051150079', '2020-10-15 14:42:28', '2020-10-15 14:42:30', '8003', '8038', 0, '2020-10-15 14:42:30.422');
INSERT INTO `employer_info` VALUES (8039, 8039, '卡卡卓', '卡卡卓', 'https://thirdwx.qlogo.cn/mmopen/vi_32/fxrdfHVd8zbTmMdFibdqnoickXEUtXSkK1x1hx0C3bJHO2y3ArvVBg0CcTc9ErAJjygskn6Sk7exAEZEIMAIAScw/132', '', NULL, NULL, '', '', '18049362492', '2020-10-15 14:58:53', '2020-10-15 14:58:56', '6039', '8039', 0, '2020-10-15 14:58:56.235');
INSERT INTO `employer_info` VALUES (8040, 8040, '三木', '三木', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL1nUufFmnUITbNzrfbyv0sSrN63Zes3c4NUDlZWmocEfs6UDKYhxwRicgSeVEO7WicfkkUW3Ep8DAA/132', '', NULL, NULL, '', '', '13282829515', '2020-10-15 15:00:43', '2020-10-15 15:00:49', '8003', '8040', 0, '2020-10-15 15:00:48.626');
INSERT INTO `employer_info` VALUES (8041, 8041, 'NancyShi', 'NancyShi', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIXpbAttHr0F2oPEQKlKLY75aVxtkRZj8XBNrU7zYQrYalXhCqZSr1sLcIktibfagViaT5uicyZnQCsA/132', '', NULL, NULL, '', '', NULL, '2020-10-15 15:05:11', '2020-10-15 15:05:11', '8040', '8040', 0, '2020-10-15 15:05:11.163');
INSERT INTO `employer_info` VALUES (8042, 8042, 'momo', 'momo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLuu9YlJp7AuDuZsI9vsianu018GWehDHu7icaiboqPGziaTD4rKg0GEdfa2dmcEu6ficQiahphSxlmnjrA/132', '', NULL, NULL, '', '', NULL, '2020-10-15 15:05:47', '2020-10-15 15:05:47', '8003', '8003', 0, '2020-10-15 15:05:47.299');
INSERT INTO `employer_info` VALUES (8043, 8043, '家犬', '家犬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJMrl3FOMUCXPicSPdqSlyViajLp9mmWydviaExnicXOE1ibIuoy6o8iaDhQnWJriaK5YZHDZgk68CHOTssQ/132', '', NULL, NULL, '', '', '15021012515', '2020-10-15 15:40:35', '2020-10-15 15:40:38', '8038', '8043', 0, '2020-10-15 15:40:37.797');
INSERT INTO `employer_info` VALUES (8044, 8044, '安尼💗', '安尼💗', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epUJ5UkanJGyFgt30jUyoVgqFk3iag8mQwwX5mpakpcReKEpA8k0Y1b6jpXsT2KmGA0hCAoJgX8S7g/132', '', NULL, NULL, '', '', '13071188020', '2020-10-15 15:45:02', '2020-10-15 15:45:06', '6042', '8044', 0, '2020-10-15 15:45:06.375');
INSERT INTO `employer_info` VALUES (8045, 8045, 'Elly刘', 'Elly刘', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKoOicBeZibr7nM9lG1icKpTXgjaXOyiagj8A2BaIfQib9gF6QpZqT6vkkNqXWpBdENfK4fSiaylzRQdSlA/132', '', NULL, NULL, '', '', '13701095136', '2020-10-15 15:47:18', '2020-10-15 15:47:25', '8044', '8045', 0, '2020-10-15 15:47:25.268');
INSERT INTO `employer_info` VALUES (8046, 8046, '薛小婷', '薛小婷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoxXuMyicEptPFia9W05uNI5YCJgS3ibYddMsINw6tjqSEdjJUkpc0ke5pxDF5iccjoDMfPOEziaWVCDWw/132', '', NULL, NULL, '', '', '18610373336', '2020-10-15 16:55:43', '2020-10-15 16:55:46', '8003', '8046', 0, '2020-10-15 16:55:46.323');
INSERT INTO `employer_info` VALUES (8047, 8047, 'rufei.cn', 'rufei.cn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erf1o3QrluWmYBhxYsIbBZ8lTcJwNs3n2IbU3kKF5diaSHt8QUvuPJUnPpEz9Y5bjp5Lv2k9a7VKeg/132', '', NULL, NULL, '', '', NULL, '2020-10-15 17:14:22', '2020-10-15 17:14:22', '8046', '8046', 0, '2020-10-15 17:14:22.184');
INSERT INTO `employer_info` VALUES (8048, 8048, '晖晖', '晖晖', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOP4klM32tWqbMAJunR9fVguwDiaDejric7CSwarmKM45vibzk5ceTgeicpiaaJVV2fgwMwiabdWjcGU6w/132', '', NULL, NULL, '', '', '15810251145', '2020-10-15 17:43:56', '2020-10-15 17:44:00', '4006', '8048', 0, '2020-10-15 17:44:00.065');
INSERT INTO `employer_info` VALUES (8049, 8049, 'Cindy', 'Cindy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/qqfZcibDJY3nia4l2CfpqzB10U1MxSScCFnZWVV4NH2TSptA5wI5pso8XwK3xQAUdnAiaJ3uOWP26cibPpL5hHkrEw/132', '', NULL, NULL, '', '', NULL, '2020-10-15 18:06:58', '2020-10-15 18:06:58', '8048', '8048', 0, '2020-10-15 18:06:58.050');
INSERT INTO `employer_info` VALUES (8050, 8050, '耀君_百当@Yashi', '耀君_百当@Yashi', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqXtEWzCAic6AZW0BzaqNdQajeYwics6fl3DgYvevKhddXZS3xAQr01NPw8XT8r1YTmicgw9Rcib6z2TA/132', '', NULL, NULL, '', '', '18668119280', '2020-10-15 18:20:15', '2020-10-15 18:20:19', '4006', '8050', 0, '2020-10-15 18:20:18.590');
INSERT INTO `employer_info` VALUES (8051, 8051, '李兆彬', '李兆彬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKKVUz9m9NCz5WXgZPAPGEJYt3UmHqTstPwbbBDUjKJUCszvx4aCmibJsAz3GnBHQwDtQiaPdTR43zg/132', '', NULL, NULL, '', '', '13910974080', '2020-10-15 19:13:41', '2020-10-15 19:13:44', '2015', '8051', 0, '2020-10-15 19:13:44.293');
INSERT INTO `employer_info` VALUES (8052, 8052, '兴风踏浪', '兴风踏浪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL9f2IRkfAb3wL4Np47JeAmS9jnZHMUJfKX28s1iaEibVia5alx6JWcIN71hOPNuLTThTMlVQhzC3ibwQ/132', '', NULL, NULL, '', '', NULL, '2020-10-15 19:47:45', '2020-10-15 19:47:45', '4000', '4000', 0, '2020-10-15 19:47:45.007');
INSERT INTO `employer_info` VALUES (8053, 8053, '林晓薇', '林晓薇', 'https://thirdwx.qlogo.cn/mmhead/fDUgH9bFtIT8LG5zXXiczfQf2Po4a2CqaDsCzM38jPAs/132', '', NULL, NULL, '', '', NULL, '2020-10-15 20:24:05', '2020-10-15 20:24:05', '4000', '4000', 0, '2020-10-15 20:24:04.635');
INSERT INTO `employer_info` VALUES (8054, 8054, 'Betty', 'Betty', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLbKp0Id2libic3tFXdjTTz3icpwP0EWq31o1Svnic5FeC4rtq4ybcGeDpEb4r6ibaPzTtEDuqMaHaNibLg/132', '', NULL, NULL, '', '', '13522370887', '2020-10-15 21:51:51', '2020-10-15 21:53:07', '2023', '8054', 0, '2020-10-15 21:53:06.758');
INSERT INTO `employer_info` VALUES (8055, 8055, '马腾', '马腾', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIsCeMiaA1tbuxiaQ2fHibyxy4jwWxxl6LicuSxqqvYec05iaGsBt2Rx7gDXO5iaRZvURUFSxEkoIDFbzrg/132', '', NULL, NULL, '', '', '15501085058', '2020-10-15 22:24:40', '2020-10-15 22:24:44', '6047', '8055', 0, '2020-10-15 22:24:43.582');
INSERT INTO `employer_info` VALUES (8056, 8056, '叶宝珍', '叶宝珍', 'https://thirdwx.qlogo.cn/mmhead/dbmbvl7UYS8hcRelNJTkocl0MhM0LLmDlApB27KHLlw/132', '', NULL, NULL, '', '', NULL, '2020-10-15 23:34:46', '2020-10-15 23:34:46', '2000', '2000', 0, '2020-10-15 23:34:45.711');
INSERT INTO `employer_info` VALUES (8057, 8057, 'xiaofan|Fruitage', 'xiaofan|Fruitage', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er3gf9mtgW90tjvacdgmq4efdKFheowhtBUKALyXIAw7pQ6gT0z0e61vfK09DwvyFxMkcSj2ZMP9w/132', '', NULL, NULL, '', '', '18510665571', '2020-10-16 09:23:27', '2020-10-16 09:23:30', '6051', '8057', 0, '2020-10-16 09:23:30.420');
INSERT INTO `employer_info` VALUES (8058, 8058, '暖暖🍃 诗里', '暖暖🍃 诗里', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep57xKEpeyFJPQJubNicEz4GSYmuBLwHjVeRdiak6k2oEVddMyU5rwf9BHP8JReLn58icovOmdzWdHng/132', '', NULL, NULL, '', '', '18658157611', '2020-10-16 10:30:19', '2020-10-16 10:30:22', '6053', '8058', 0, '2020-10-16 10:30:21.827');
INSERT INTO `employer_info` VALUES (8059, 8059, 'loverose', 'loverose', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM5fHibMuHpkOgUqTZBdbnccxaNsPJHIZlrJU1icvp7Gy5b0gB5z1WLRKZXRrnQpnaTknYfXFhicuzVJQ/132', '', NULL, NULL, '', '', '13516813035', '2020-10-16 10:38:54', '2020-10-16 10:39:05', '4002', '8059', 0, '2020-10-16 10:39:04.996');
INSERT INTO `employer_info` VALUES (8060, 8060, '高丽丽', '高丽丽', 'https://thirdwx.qlogo.cn/mmopen/vi_32/eH67YutzOic6cvq5Ql9gqGBO8ugmV3MK9KukLxCTx93wKiar8IPhP3Ia14RP51c5JEwKWpsbl08icJenoAPdKokXA/132', '', NULL, NULL, '', '', '15658117627', '2020-10-16 10:59:24', '2020-10-16 10:59:28', '8057', '8060', 0, '2020-10-16 10:59:27.568');
INSERT INTO `employer_info` VALUES (8061, 8061, '文强', '文强', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er49qI4ricscCcWN3w2BS2WusQdibqFh5CQkxRvOfA5AsQdOib2RCnZP40eYrM7RUUFXcEntbaGpppsQ/132', '', NULL, NULL, '', '', '15067158859', '2020-10-16 11:03:22', '2020-10-16 11:03:25', '6054', '8061', 0, '2020-10-16 11:03:25.127');
INSERT INTO `employer_info` VALUES (8062, 8062, 'Anna', 'Anna', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTy7GKvduQo8MaRcqklJTTicIWgGdkQ3AJ0HbccbkQ95RdUnTYXwRia2q6mJp1E4wCmMQ0l7OhyQhw/132', '', NULL, NULL, '', '', '18667132261', '2020-10-16 11:03:41', '2020-10-16 11:03:43', '8060', '8062', 0, '2020-10-16 11:03:43.190');
INSERT INTO `employer_info` VALUES (8063, 8063, '仲秋.晴', '仲秋.晴', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ0K4Ea95u4mTlKqicxCzG1opvx3saaC5yk8IicMIdC5QqAYmTMNbNQKgvtGTmMSxXO5bxpdePB3uIw/132', '', NULL, NULL, '', '', '13666698249', '2020-10-16 11:13:50', '2020-10-16 11:13:52', '8062', '8063', 0, '2020-10-16 11:13:52.258');
INSERT INTO `employer_info` VALUES (8064, 8064, 'Katy', 'Katy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eovY5YhcicuuhblibQQjrWjm89NkHH1ibDz5nl0SFIckVW9Uk0hBibPvoYDrHtqUd30kK6S9bvfJY5FAw/132', '', NULL, NULL, '', '', '15906665740', '2020-10-16 12:00:50', '2020-10-16 12:00:53', '4002', '8064', 0, '2020-10-16 12:00:52.939');
INSERT INTO `employer_info` VALUES (8065, 8065, '咖啡师爷', '咖啡师爷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKAAjrpSzJE6ToORaAVgIBUXXwEOViaZNzWtSwW8kMmVt6RZokSjTFbdlCSr19EzsDlicUVfy40RqlQ/132', '', NULL, NULL, '', '', '13758137221', '2020-10-16 13:02:56', '2020-10-16 13:02:59', '6057', '8065', 0, '2020-10-16 13:02:59.482');
INSERT INTO `employer_info` VALUES (8066, 8066, '忘', '忘', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJNf0qg9pM2cbyY6D9hk4CKrbicicsNIlKbia54Fd3ib8QIh9l8DRo0eylP5Dc5QO9P36yiamkBMvHCBog/132', '', NULL, NULL, '', '', NULL, '2020-10-16 13:54:03', '2020-10-16 13:54:03', '6057', '6057', 0, '2020-10-16 13:54:02.845');
INSERT INTO `employer_info` VALUES (8067, 8067, '不失本色', '不失本色', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8ZEzZjlpMk20G132dA99xlJ9KQN7dl6skyueSYYzpooxt7xDKKUpDWnuiaP2jsZBLW6QsjCGZ0Rg/132', '', NULL, NULL, '', '', '15625018926', '2020-10-16 19:17:36', '2020-10-16 19:46:17', '4000', '8067', 0, '2020-10-16 19:46:16.813');
INSERT INTO `employer_info` VALUES (8068, 8068, 'sky', 'sky', 'https://thirdwx.qlogo.cn/mmopen/vi_32/oVTZZspdwoHiavcodWkz5uQfPITSlmmLQiariapCcare8rNgAYkp67TNn6YLUUO4XaSLwHPIkS3Ymmicz4iaFr0Q3jA/132', '', NULL, NULL, '', '', '13602546400', '2020-10-16 21:38:17', '2020-10-16 21:38:23', '6007', '8068', 0, '2020-10-16 21:38:23.351');
INSERT INTO `employer_info` VALUES (8069, 8069, '秋天来了', '秋天来了', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJbSPetaEBiaofEElKNZjJskayUfNA5rqUTUnglKJAowclUonw0c7wvgvY4GLsFicQIPB7OXWIgcbxw/132', '', NULL, NULL, '', '', '18101928491', '2020-10-16 21:40:36', '2020-10-16 21:40:47', '6007', '8069', 0, '2020-10-16 21:40:46.915');
INSERT INTO `employer_info` VALUES (8070, 8070, '就不告诉你', '就不告诉你', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8uiaErzMEKjMQQnuetiazbVUmR94o9m1I1AI88qib2kemHPA5RTr2bOicp6pECDBKqPnnxcRhNUhXpA/132', '', NULL, NULL, '', '', '18210526775', '2020-10-16 22:00:51', '2020-10-16 22:00:54', '8069', '8070', 0, '2020-10-16 22:00:54.416');
INSERT INTO `employer_info` VALUES (8071, 8071, '卓', '卓', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqpKdSsjASicx09dfeEa6pZQUNsiaI7L97nlXaL8aHPMgPe4iaaWXkweibt1zMBWH0kFPU4YKxTwOBGGQ/132', '', NULL, NULL, '', '', '13911233734', '2020-10-16 22:48:00', '2020-10-16 22:48:05', '8070', '8071', 0, '2020-10-16 22:48:05.432');
INSERT INTO `employer_info` VALUES (8072, 8072, '林慧齐', '林慧齐', 'https://thirdwx.qlogo.cn/mmhead/8crE0icJmlhkyC1WJWqJ6ibuTxOpqUAABp3lRumxCq43U/132', '', NULL, NULL, '', '', NULL, '2020-10-17 10:26:37', '2020-10-17 10:26:37', '2000', '2000', 0, '2020-10-17 10:26:36.942');
INSERT INTO `employer_info` VALUES (8073, 8073, '张可依', '张可依', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epHNkyMkOeLa9s3W2wGBjlMvuBqbJb3hZl7YGSgkRjdqMxq2qSafbDLlGGj2NIsvBJRibCFEIDJWRA/132', '', NULL, NULL, '', '', '18482050775', '2020-10-17 17:24:05', '2020-10-17 17:24:07', '6062', '8073', 0, '2020-10-17 17:24:07.277');
INSERT INTO `employer_info` VALUES (8074, 8074, '许志霖', '许志霖', 'https://thirdwx.qlogo.cn/mmhead/DX1nQyXf4GTjCHopwWkMMuAfUwnW0fIPj15IxcHxPA8/132', '', NULL, NULL, '', '', NULL, '2020-10-18 02:21:42', '2020-10-18 02:21:42', '2000', '2000', 0, '2020-10-18 02:21:42.346');
INSERT INTO `employer_info` VALUES (8075, 8075, '刘垚功', '刘垚功', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJqUkoCXOxRrZ2CyE7BEad4ye3hIV7Yic6JBoFqQOsSQlAXeibribgoLI6Zabib3d6gdNje8ibb08Juq7Q/132', '', NULL, NULL, '', '', '18611945229', '2020-10-18 06:36:19', '2020-10-18 06:36:28', '2000', '8075', 0, '2020-10-18 06:36:27.585');
INSERT INTO `employer_info` VALUES (8076, 8076, '曦瑶', '曦瑶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIfI4IVbPPia8x3azUNCF5PDC4VGp8xSvxzKj96SgdlIyLhYL0RWuAibFS6bAlCf8oLjJ75fU2Ja7IQ/132', '', NULL, NULL, '', '', '13910714819', '2020-10-18 14:15:46', '2020-10-18 14:15:52', '2007', '8076', 0, '2020-10-18 14:15:51.828');
INSERT INTO `employer_info` VALUES (8077, 8077, '兰  丫头', '兰  丫头', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIBYricK9KtTZgO2BC5zQpzfttlnERy2we2ibszxuE5DGsQPibZDRNiaooJIWPlllIO6xgdcL6Myrq41w/132', '', NULL, NULL, '', '', '13718868375', '2020-10-19 09:38:48', '2020-10-19 09:38:51', '4002', '8077', 0, '2020-10-19 09:38:51.434');
INSERT INTO `employer_info` VALUES (8078, 8078, '劉Jian', '劉Jian', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gebz9R2KoicIzP4766zib19bMgajWDHeWibu1jf9AxrukdWsucbibwj2MKia2s1yVlhPKoibR2BQrSa5pIic6XS9NjO6w/132', '', NULL, NULL, '', '', '18801209353', '2020-10-19 13:38:45', '2020-10-19 13:38:48', '2000', '8078', 0, '2020-10-19 13:38:47.793');
INSERT INTO `employer_info` VALUES (8079, 8079, '郭雨桦', '郭雨桦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJKzUzFEcDaicRib9o1Wt1a4NCPAM0pmWEycPoK0RMrzsUslAibsZzCpbgibOUCQp5ClO6MH1rUIO0xAw/132', '', NULL, NULL, '', '', '13126717896', '2020-10-19 15:43:38', '2020-10-19 15:43:42', '2007', '8079', 0, '2020-10-19 15:43:41.935');
INSERT INTO `employer_info` VALUES (8080, 8080, 'Ivy', 'Ivy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/J6QAFH0QPCfX28nicQ2SD8yAPWbugGic0lbBicZN9NBWxR8OIW6mbHGthXypibJmB1UzDqlD8TahJeibme4icAHibIqjA/132', '', NULL, NULL, '', '', '17002200088', '2020-10-19 18:54:20', '2020-10-19 18:54:25', '4000', '8080', 0, '2020-10-19 18:54:25.004');
INSERT INTO `employer_info` VALUES (8081, 8081, '张帆', '张帆', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eokmgMic76YFnAf37tMrC0fFwM8Yd8194sjvXiadxf7hAibOibjT4QsNtOPDxr33A7bHMcZdyN1sIs2uQ/132', '', NULL, NULL, '', '', '13466765575', '2020-10-19 22:41:35', '2020-10-19 22:41:40', '6071', '8081', 0, '2020-10-19 22:41:40.406');
INSERT INTO `employer_info` VALUES (8082, 8082, '敏娟', '敏娟', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLGhUVNkpWcgDwFliaSczKLHxSBGbSV4KpTSUTbNrD6oHoP8x6Vu3zIJwKMX2l9MWDG0mI4yPYVxicw/132', '', NULL, NULL, '', '', '15201277758', '2020-10-20 07:30:46', '2020-10-20 07:30:49', '2020', '8082', 0, '2020-10-20 07:30:49.327');
INSERT INTO `employer_info` VALUES (8083, 8083, 'Samson', 'Samson', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erZ8svwT73clDzuBYzS58HFcIJ0N9gPFA1llraSO5avVm90JaSuqonM8AsBKib5Le2CNGTF0AumS9Q/132', '', NULL, NULL, '', '', NULL, '2020-10-20 09:45:41', '2020-10-20 09:45:41', '6074', '6074', 0, '2020-10-20 09:45:40.850');
INSERT INTO `employer_info` VALUES (8084, 8084, '周全', '周全', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8QkD9V6I7OoHWpp8Y4b0ckfPafEdmer68CqwJRzeib8Kh3hsE58hJbJ7LZNAGZsP3P0lrN2lx52w/132', '', NULL, NULL, '', '', '18910357327', '2020-10-20 13:20:45', '2020-10-20 13:20:56', '8040', '8084', 0, '2020-10-20 13:20:56.074');
INSERT INTO `employer_info` VALUES (8085, 8085, '安东旭', '安东旭', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKaNtEXTK3uj7BicC3u55vJSGgQRUWT1lpRKAKfnth5G1qL8frDhibUda8K7WhW3LCgJWWUkIdkBjaA/132', '', NULL, NULL, '', '', '17326097257', '2020-10-20 21:22:18', '2020-10-20 21:22:21', '8045', '8085', 0, '2020-10-20 21:22:21.032');
INSERT INTO `employer_info` VALUES (8086, 8086, '张艺林 John', '张艺林 John', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erEicuJv8W5CbictzHZicJ6ECUSpdoLlTYB3Z2jMwTqZ2RTTZCrnGMv95rAmiaibMFcpZIxQzj3O2n26WQ/132', '', NULL, NULL, '', '', '18817313655', '2020-10-20 21:22:18', '2020-10-20 21:22:22', '6077', '8086', 0, '2020-10-20 21:22:21.739');
INSERT INTO `employer_info` VALUES (8087, 8087, '席蕴俊', '席蕴俊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhx0aNiaBpicV1icXhwR9sF8GPiab94DQvfwYB9OiaclRYStk19nNCtCUXyC1HMFUaCOCDibHt0xrg3Q7w/132', '', NULL, NULL, '', '', '13567110082', '2020-10-21 10:00:40', '2020-10-21 10:00:43', '8085', '8087', 0, '2020-10-21 10:00:43.459');
INSERT INTO `employer_info` VALUES (8088, 8088, '王小超@联服企业服务', '王小超@联服企业服务', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epOJBffbo5iaafW1gLvPmkbAUC1qzmJ8tynFP3Y7LRfAsyq1ZKPDRpSXoPqHd90x2GODEZs1oXo6hw/132', '', NULL, NULL, '', '', '18817805554', '2020-10-21 10:22:04', '2020-10-21 10:22:07', '6077', '8088', 0, '2020-10-21 10:22:06.743');
INSERT INTO `employer_info` VALUES (8089, 8089, 'Bonnie', 'Bonnie', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erRZlDy8IJugtLDIjGeN961WPS4yh5a79LOib0PC0e0qQbg9cKkZAKAcFEwrGmPOVPiamtDau9vRqibg/132', '', NULL, NULL, '', '', '18911071331', '2020-10-21 15:38:18', '2020-10-21 15:38:22', '8071', '8089', 0, '2020-10-21 15:38:22.445');
INSERT INTO `employer_info` VALUES (8090, 8090, '思羽  Money💰', '思羽  Money💰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJo2ZvT9XJPiaHaOdfjO7mfc4ymCAgTXGvoF6TWA7XgFRnaT5AqtyJP3H9nQ8E1Un6cuEGkib5Ejwrw/132', '', NULL, NULL, '', '', '18667005608', '2020-10-21 15:42:49', '2020-10-21 15:42:53', '8089', '8090', 0, '2020-10-21 15:42:52.950');
INSERT INTO `employer_info` VALUES (8091, 8091, 'Tank', 'Tank', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqQSgXianTD2fdvyIKvWXiaeyJVuzvMXwPwR8nmH9BuVvacibFV8SESLU8dKjzMK3KphIYGF1WPmQjhw/132', '', NULL, NULL, '', '', '18658856332', '2020-10-21 15:43:29', '2020-10-21 15:43:32', '8089', '8091', 0, '2020-10-21 15:43:31.885');
INSERT INTO `employer_info` VALUES (8092, 8092, '夏天', '夏天', 'https://thirdwx.qlogo.cn/mmopen/vi_32/SKiageS2YRyAlS7dHicyU4xicmJvTGd3m5Y1JpYSDibq9JDtn5zWpROXjc0SnJqIJ1STNiboXHM4m6KmmBIjIQFZQJw/132', '', NULL, NULL, '', '', '18614288369', '2020-10-21 18:12:15', '2020-10-21 18:12:20', '6082', '8092', 0, '2020-10-21 18:12:20.123');
INSERT INTO `employer_info` VALUES (8093, 8093, '钢哥', '钢哥', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKEZvcMHzj4iaW6kkPNEGCTLicCO5zUyblMialyeMoFZktZfIrGRejLuoibqwuXdRyoE5y6ggpqfibD2VQ/132', '', NULL, NULL, '', '', '13911569777', '2020-10-21 19:01:34', '2020-10-21 19:01:40', '6084', '8093', 0, '2020-10-21 19:01:40.135');
INSERT INTO `employer_info` VALUES (8094, 8094, '无双上将潘凤', '无双上将潘凤', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqicpcicjzYhjFXjHFiczxuNTmmicEfKmdvcZ4lVuvHn8YfWtlZiaEib5sMQzaia9xHCtPkAVglzXZ1iab1rQ/132', '', NULL, NULL, '', '', NULL, '2020-10-21 19:45:43', '2020-10-21 19:45:43', '4000', '4000', 0, '2020-10-21 19:45:43.459');
INSERT INTO `employer_info` VALUES (8095, 8095, '韩励智', '韩励智', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ia9w3tFtngQJP6g58sRf2K40PmE0Jnoa2jVW4ICntaIvnl54xL7a74Z7fibe2f8Za5ibIYuJ7smfx6nQzFiaia79TJQ/132', '', NULL, NULL, '', '', '18204614870', '2020-10-22 11:14:36', '2020-10-22 11:14:39', '6084', '8095', 0, '2020-10-22 11:14:39.339');
INSERT INTO `employer_info` VALUES (8096, 8096, '周红飞 Jason Chou', '周红飞 Jason Chou', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqVHJF6iaPUDw2ibQeXjbK9PaL8yroAUlK8uJ0gNmrnoDXLvjZXSx04wkibvEdh35XTJBBVBHmWdbnIw/132', '', NULL, NULL, '', '', '15895970859', '2020-10-22 12:08:12', '2020-10-22 12:08:16', '4000', '8096', 0, '2020-10-22 12:08:16.465');
INSERT INTO `employer_info` VALUES (8097, 8097, 'zmhui', 'zmhui', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLegwOzRJibSSvnrhkfmpPhXVwKCmicGUzxAreV1zGpLauZ3htBZWiaQ4FTQur186ExCeJc55DVFZWCw/132', '', NULL, NULL, '', '', '13121453800', '2020-10-22 14:29:33', '2020-10-22 14:29:36', '6088', '8097', 0, '2020-10-22 14:29:35.843');
INSERT INTO `employer_info` VALUES (8098, 8098, '张德强', '张德强', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKmyUF0MWNDUdFPh6QmGG8xWVsRFkjPPAa5g7icHl9WQHUqNkpWFrtSujZgKh0hUmia8da5FB9bVq3Q/132', '', NULL, NULL, '', '', '15110286849', '2020-10-22 14:53:17', '2020-10-22 14:53:20', '8097', '8098', 0, '2020-10-22 14:53:19.605');
INSERT INTO `employer_info` VALUES (8099, 8099, 'Kiki Aria Inn', 'Kiki Aria Inn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/7MicosKnZk61p7b9Yps5y9NJPwSpsYCuknt3cQHI54vM2q65Lic46v9CcQG20PAT2oJacFIvicaMI9rRh7CdA0MJg/132', '', NULL, NULL, '', '', '13389880871', '2020-10-22 19:18:07', '2020-10-22 19:18:15', '6092', '8099', 0, '2020-10-22 19:18:15.002');
INSERT INTO `employer_info` VALUES (8100, 8100, 'A', 'A', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLqwGJIXBdice0kc2lhKCtKKbjialg2Qrmf0fusnysFS65yfSmibibzEaibDrn4L81xGFZibDLIV7Djic7Fw/132', '', NULL, NULL, '', '', NULL, '2020-10-22 19:30:35', '2020-10-22 19:30:35', '8099', '8099', 0, '2020-10-22 19:30:35.150');
INSERT INTO `employer_info` VALUES (8101, 8101, '宗鑫-华致酒行-人力资源部', '宗鑫-华致酒行-人力资源部', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIgJCQBU8fXJpsQRDFZYQh0CZHEQhiapYBwbvBjdnfTGz5fBNT8XHJibF774oou63AgNHMn2KibVsnBg/132', '', NULL, NULL, '', '', '18713342498', '2020-10-22 22:17:06', '2020-10-22 22:17:09', '6051', '8101', 0, '2020-10-22 22:17:09.427');
INSERT INTO `employer_info` VALUES (8102, 8102, '付剑南', '付剑南', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK5HdmFFmNiafTkVjVdGAtmjGia7P9SuLa6E1jibicJxibSrgdKYiab1C89xJ2DA8kYIlAibBGlozTn3Tlmw/132', '', NULL, NULL, '', '', '15801376059', '2020-10-23 03:08:16', '2020-10-23 03:08:20', '2007', '8102', 0, '2020-10-23 03:08:20.142');
INSERT INTO `employer_info` VALUES (8103, 8103, 'Silent', 'Silent', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJfUqEKHvN0oJibSiaA4ne6axXQA10icHibp6kMoIR2JyOGo3WUZNhmdw7NDuLSfia4YYT0kNJNzJbyflQ/132', '', NULL, NULL, '', '', '18221388671', '2020-10-23 14:01:13', '2020-10-23 14:01:18', '2007', '8103', 0, '2020-10-23 14:01:18.446');
INSERT INTO `employer_info` VALUES (8104, 8104, '苏碧绮', '苏碧绮', 'https://thirdwx.qlogo.cn/mmhead/oz6ooeIZaHUUgXkppow7ftEMicvu9SbiaWbx9HwYXBtrA/132', '', NULL, NULL, '', '', NULL, '2020-10-23 15:06:39', '2020-10-23 15:06:39', '8103', '8103', 0, '2020-10-23 15:06:38.885');
INSERT INTO `employer_info` VALUES (8105, 8105, '可能', '可能', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLqeib8OfVoRA2DNiarT4bHCVQN5xZOc0kGTr2fFh0fLo4guuStO3ibt3u3yzL6vml7ACErNoty1VcgA/132', '', NULL, NULL, '', '', '18406459159', '2020-10-23 17:07:43', '2020-10-23 17:07:47', '4000', '8105', 0, '2020-10-23 17:07:46.951');
INSERT INTO `employer_info` VALUES (8106, 8106, '庾航 Hank', '庾航 Hank', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoU2SG2ynSzkJMDdnbDHHNqjQCmic8cKHAObmsP0kvx9J6PxyvSOsXjl2ltVib991WDpM7BbLI11sibw/132', '', NULL, NULL, '', '', '18627566868', '2020-10-26 11:52:32', '2020-10-26 11:52:38', '6095', '8106', 0, '2020-10-26 11:52:37.692');
INSERT INTO `employer_info` VALUES (8107, 8107, '余钟~猎头老余18702536239', '余钟~猎头老余18702536239', 'https://thirdwx.qlogo.cn/mmopen/vi_32/d8mqJsPOcAkZLm65ahulHUq5AuUTgiaMlOwVia0ibkCUD9ZQTs07d8e6Zb1jt08pTyy6uOawnXFiaodrxricDRU82sg/132', '', NULL, NULL, '', '', '18702536239', '2020-10-26 16:28:10', '2020-10-26 16:28:14', '-1', '8107', 0, '2020-10-26 16:28:13.483');
COMMIT;

-- ----------------------------
-- Table structure for evaluation_info
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=2002 DEFAULT CHARSET=utf8 COMMENT='评价信息表';

-- ----------------------------
-- Records of evaluation_info
-- ----------------------------
BEGIN;
INSERT INTO `evaluation_info` VALUES (2000, 2000, 5, 6006, '20101416LK8256SP5', 4001, 4000, 5, 5, 5, '<p>OK</p>', '2020-10-14 17:21:26', 4001, '2020-10-14 17:21:26', 4001, '2020-10-14 17:21:26.372', 0);
INSERT INTO `evaluation_info` VALUES (2001, 2001, 5, 8003, '201014162GH479BPL', 4000, 4001, 5, 5, 5, '<p>yy</p>', '2020-10-14 17:26:20', 4000, '2020-10-14 17:26:20', 4000, '2020-10-14 17:26:19.785', 0);
COMMIT;

-- ----------------------------
-- Table structure for evaluation_info_tag
-- ----------------------------
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

-- ----------------------------
-- Records of evaluation_info_tag
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for freelancer_info
-- ----------------------------
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
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54003 DEFAULT CHARSET=utf8mb4 COMMENT='自由职业者信息表';

-- ----------------------------
-- Records of freelancer_info
-- ----------------------------
BEGIN;
INSERT INTO `freelancer_info` VALUES (2000, 2000, '波英冰', '波英冰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIqWm3ZZtoXVuO3xTUIckrHyRPSzrII3GTXY4QF6uR8IIYeRIjRwLnnyAOlHDvJToFD9pD8FtKTPQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18680506315', '2020-10-14 15:59:46', '2020-10-14 19:24:40', -1, 2000, 0, '2020-10-14 19:24:40.245');
INSERT INTO `freelancer_info` VALUES (2001, 2001, '康胜苏', '康胜苏', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJsjcw1SDskBDFyjYwcABNaRd9ZfWlmquoyseVmqtia7iaFlyDMVZbjrPGZZh3HBz72GI3icFuy6Fj2g/132', '', 10, 0, '', NULL, NULL, '', '', '', '15801227230', '2020-10-14 15:59:58', '2020-10-14 16:00:01', -1, 2001, 0, '2020-10-14 16:00:00.926');
INSERT INTO `freelancer_info` VALUES (2002, 2002, '孔令飞', '孔令飞', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erbP3G6OIm5zElMYyEWufBMTgO6kDiausGg9NLfEY3Pe0GQ6kJNlPNbrYKYhmHdYALJIuDdoTCATLg/132', '我一直在创造用户需求性、商业延续性、科技可行性的最佳融合。在工作中有很强的沟通推进能力及项目管理能力，善于从产品角度做设计将创 意落地到产品，有效实现设计价值到商业价值的转化。', 10, 0, '', '110000', '110100', '110113', '', '15010924982', '15010924982', '2020-10-14 18:06:21', '2020-10-14 18:08:28', 4001, 1, 0, '2020-10-14 18:08:27.702');
INSERT INTO `freelancer_info` VALUES (2003, 2003, '秋天离别-邓雷', '秋天离别-邓雷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLCnEPpM4WwSNRWZa1T3zOwA2x0icia0OSDMU8nfVunRWAdYOqmkZSia5FxAOcSRK7CfSTiaDFicaubibEw/132', '从事市场领域七年 大多数在出行领域 创造能力非常强 。在宁波创建了市场人联盟、白驹滑雪俱乐部、浙沪用车便民平台。', 10, 0, '', NULL, NULL, '', '', '', '18657675257', '2020-10-14 18:47:11', '2020-10-14 19:43:59', 4002, 1, 0, '2020-10-14 19:43:58.787');
INSERT INTO `freelancer_info` VALUES (2004, 2004, 'i舒克', 'i舒克', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIIPk9sbg3Nu6ZNBGsSsKAPIk1355iaTY7z32ybYbl93L9sLZGKEGys8yXyBxNnPly8Np7bJjA05vw/132', '我是舒克，我住在武汉，我是一名UI设计师个视觉设计师平面设计师。我有着丰富的UI设计经验，截止目前我有四款上线app，还有一款待上线，WEB端以及OA更是不计其数，目前我的目标是转战产品，应该不管设计对象是什么，都得从用户的角度思维出发，了解了用户群体才能真正的做好设计。', 10, 0, '', '420000', '420100', '420101', '', '', '18271676417', '2020-10-14 18:47:23', '2020-10-14 19:40:10', 4000, 1, 0, '2020-10-14 19:40:09.837');
INSERT INTO `freelancer_info` VALUES (2005, 2005, 'Carly 张蕾', '未兰教练', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIrVkpD3ck8XcQhpcAlNPZXmINHJUWSbC9SVriaKfnpLRxGt5x4tibwo5qTfteWrjvpT6Eo4piaPfPZQ/132', '超过20年世界500强企业管理咨询与管理实践工作经验，5年企业教练、高管教练经验。深刻意识到“人”是企业发展、变革的最重要成功因素或阻碍瓶颈，在为企业提供高管教练和企业教练服务时实际看到了内在动力、隐形模式的呈现与转变。以顾问视角看企业管理，以教练视角看人才发展，以心理学视角看心智模式。作为专家级顾问、项目负责人为中国众多知名企业提供组织与人力资源管理咨询服务，将传统咨询结合企业教练、培训方式，与企业共创，更快捷、见效，同时赋能。', 10, 0, '', NULL, NULL, '', '', '', '13801251875', '2020-10-14 18:47:34', '2020-10-14 20:01:34', 2004, 1, 0, '2020-10-14 20:01:33.883');
INSERT INTO `freelancer_info` VALUES (2006, 2006, 'W-', 'W-', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLJ2F2ibIlPic8fQHDpOIbgIcpfXSQJNavSdOIMEpkthGwToicnibvBn45zRzUm0BY6ZTtfDAYMSSLmew/132', '', 10, 0, '', NULL, NULL, '', '', '', '13261523952', '2020-10-14 19:18:04', '2020-10-14 19:18:06', 4004, 2006, 0, '2020-10-14 19:18:06.446');
INSERT INTO `freelancer_info` VALUES (2007, 2007, '孙欣Amanda', 'Amanda', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epzxl1othrI7L1KibF9uAHMW8pTKUiaicLKZyWKgyFkQmCWM01Kib5xRLwbsbQibufjFy4pSic4jOdkLibicQ/132', '从业10年知名企业人力资源管理经验，来自于互联网大厂高端人才甄选，全球化生态链HRD、人力资源业务合作伙伴，曾是职来职往BOSS团嘉宾，希望与我的相遇，让你再次看到不一样的自己。', 10, 0, '', '110000', '110100', '110105', '', 'sunxin19841014', '13120485009', '2020-10-14 19:22:30', '2020-10-18 18:04:54', 4002, 1, 0, '2020-10-18 18:04:54.007');
INSERT INTO `freelancer_info` VALUES (2008, 2008, '张苏k', '张苏k', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIKOs8aPC4ArJbsiaic0rSV4lEhkHabltxKia5P6mA5cKOvAibr0t2cCnD2EK2NVwJdoAHibn3E0suEdww/132', '我在上海，旗下有30多人，公司自主研发无代码后台管理系统。可以灵活配置各类管理系统。', 10, 0, '', NULL, NULL, '', '', '', '18017495714', '2020-10-14 19:29:29', '2020-10-14 19:55:31', 4005, 1, 0, '2020-10-14 19:55:31.089');
INSERT INTO `freelancer_info` VALUES (2009, 2009, '官方提醒', '官方提醒', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJcVC1nVcVVlJKNWcqkzomQtKWiciaBxrlWtlvL45KbqaV9zrwA9jbDQlvCuBt5mKls9MHgfSjeKnrw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18752867304', '2020-10-14 19:49:28', '2020-10-14 19:49:47', 4008, 2009, 0, '2020-10-14 19:49:46.573');
INSERT INTO `freelancer_info` VALUES (2010, 2010, 'Yu-Hsiu', 'Yu-Hsiu', 'https://thirdwx.qlogo.cn/mmopen/vi_32/0Jm9FRypCPkXQXExeeOUpTbv6UyrPxSrRzMLtGJWgeLmV1WYdRwpKxl80jLzYwzM6ibrvVC2qmaYsfyyibPnPVIA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611323185', '2020-10-14 19:51:23', '2020-10-14 19:51:26', 4009, 2010, 0, '2020-10-14 19:51:25.801');
INSERT INTO `freelancer_info` VALUES (2011, 2011, '帅炜玥（帅权晍）', '帅炜玥（帅权晍）', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLjO1ywuFNHOCjJuNbbj7UHAld6ib6qUAFtfxsdLYqict8PAfOmjia6DeAT97qAJcfMREtxVx3FrLOfg/132', '拥有世界500强企业高管经验，认证高级人力资源管理师，高级物流管理师，心理咨询师，组织变革与敏捷团队教练，本科和研究生专业战略与人力资源管理，北京大学在职学习金融学。服务过汉能、吉利汽车、现代汽车等众多企业的招聘测评、沟通培训等项目。', 10, 0, '', NULL, NULL, '', '', '', '13693376633', '2020-10-14 19:57:37', '2020-10-14 20:37:26', 2009, 1, 0, '2020-10-14 20:37:25.577');
INSERT INTO `freelancer_info` VALUES (2012, 2012, 'Judy', 'Judy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ8m41TE7yeRo6KmtyRDI1k30ia6ElbK9IkCp8IC1O3Gia56B86ic8VPbmVKeOj3sib8ibTO0zTPg2oURA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13501391246', '2020-10-14 20:12:06', '2020-10-14 20:12:12', 4013, 2012, 0, '2020-10-14 20:12:11.862');
INSERT INTO `freelancer_info` VALUES (2013, 2013, 'OK_Boy', 'OK_Boy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIetZBcibMqTLbrV3VZI7jsHy6gzHAQibMxibzAgWd33FuXEjD2DvoN9Ohd10mIuBmcia8jtRArbn799g/132', '', 10, 0, '', NULL, NULL, '', '', '', '13810998520', '2020-10-14 20:12:55', '2020-10-14 20:12:59', 4013, 2013, 0, '2020-10-14 20:12:59.078');
INSERT INTO `freelancer_info` VALUES (2014, 2014, 'winxie', 'winxie', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJhhjyWnerFSS9xTfgd8bolpy2UDb2xE5ibgQWhGPj20pVGY5LBUeDUpDoNcHQgYicdJV9iacgZnhx5g/132', '', 10, 0, '', NULL, NULL, '', '', '', '18500192168', '2020-10-14 20:13:48', '2020-10-14 20:13:52', 4016, 2014, 0, '2020-10-14 20:13:52.213');
INSERT INTO `freelancer_info` VALUES (2015, 2015, ' 嗯哼～', ' 嗯哼～', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoXpyeIdLk2YJABQufPes2gQUFTjEXY6eq9bfQjBGCk9EBJYy1Lg1eX6U78O8BaXJiaxKPtG2yibDLA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18500229693', '2020-10-14 20:14:42', '2020-10-14 20:14:45', 2013, 2015, 0, '2020-10-14 20:14:44.799');
INSERT INTO `freelancer_info` VALUES (2016, 2016, '菲菲', '菲菲', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ergDOQm9kh9xn8R4ICTUYRyLD5EwHBkpV2eebJxRmCt2hzu7VNBOjCVaJfS964djYegN2pCZD5CGw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910501580', '2020-10-14 20:37:30', '2020-10-14 20:37:33', 2013, 2016, 0, '2020-10-14 20:37:33.348');
INSERT INTO `freelancer_info` VALUES (2017, 2017, '杰子', '杰子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erTUVjd6pv0ft16qThVWGYZ31icEkia7lkMg2rJZHOzbwpfaAgpH6VJKTcmDpNyzAKR3pIu2bD4LwWA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13810469408', '2020-10-14 20:54:42', '2020-10-14 20:54:48', 4018, 2017, 0, '2020-10-14 20:54:47.647');
INSERT INTO `freelancer_info` VALUES (2018, 2018, '鹰子', '鹰子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erY4ZLFhWonZfM07q0KwV7ZQ0ftSoXCMVy6aHPFqm6ic5Gqnfwdglg4ThKkHcuLJyXEu37IORYXUYA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18600852299', '2020-10-14 21:12:20', '2020-10-14 21:12:24', 2016, 2018, 0, '2020-10-14 21:12:23.795');
INSERT INTO `freelancer_info` VALUES (2019, 2019, '桑雨', '桑雨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI8mJ99Xpo281MpgdibdxC0tBgbNtY3MSPTI8PkWABnU02Vt5eUuw1XoIC562gibxibs7Via5Ql9ajRWw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18811040547', '2020-10-14 21:12:21', '2020-10-14 21:12:26', 4002, 2019, 0, '2020-10-14 21:12:25.770');
INSERT INTO `freelancer_info` VALUES (2020, 2020, '圣灵居士（强哥）', '圣灵居士（强哥）', 'https://thirdwx.qlogo.cn/mmopen/vi_32/eNw07BdCEd4LOUEib5QQsIDhaRmuMeGSQIfwJMSricqb1SepmbQiaJnCybJHJQQUM4unzric38gC81P3x4gpiclSNbA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13810684286', '2020-10-14 21:23:16', '2020-10-14 21:23:40', 2018, 2020, 0, '2020-10-14 21:23:40.032');
INSERT INTO `freelancer_info` VALUES (2021, 2021, '刘海鸣', '刘海鸣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvGAUEPO8BsCFvO9qNWbzdjibC2gMKymXV6CxjWG0fiaElqrCqotll33giaMlJwEbHQmIDnwyyCVibFQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611098024', '2020-10-14 23:21:35', '2020-10-14 23:21:38', 2005, 2021, 0, '2020-10-14 23:21:37.882');
INSERT INTO `freelancer_info` VALUES (2022, 2022, 'why not', 'why not', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDFo6AERNIMLOl9YC9Wft4icGXlazDWNfSCkLbJicPbEhXDVxnkCgE1QTQrUmNnA6zicH8H1fxeIyFg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18810226137', '2020-10-14 23:21:53', '2020-10-14 23:21:56', 2021, 2022, 0, '2020-10-14 23:21:56.483');
INSERT INTO `freelancer_info` VALUES (2023, 2023, '祺', '祺', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epLPbr4Kbh71UaKIghS1U3DysKexannxz2BcibMZIpjLeJLTZ5TEc6cQiaMCDlD98z3ialWRRyWY5kOQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18510180570', '2020-10-15 00:08:02', '2020-10-15 00:08:13', 2022, 2023, 0, '2020-10-15 00:08:12.913');
INSERT INTO `freelancer_info` VALUES (2024, 2024, 'Lynnnnnnn🦄', 'Lynnnnnnn🦄', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCyRqwKL3sUwVJ5AwVpB7naZeTuvYwPmurTMpbZZ62Qzch9nSwrqaJc7VDzSRWTE5WFIicWmMPvDA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15620304128', '2020-10-15 00:52:06', '2020-10-15 00:52:19', 2000, 2024, 0, '2020-10-15 00:52:19.280');
INSERT INTO `freelancer_info` VALUES (4000, 4000, '麒少爷', '麒少爷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUSWrYgGK0rIlJDtMFRJpVxD5EAic299PnKPfVxu4rMTLKnd4JOQPK1j3LRZxbetKsCjZXDdlY4QQ/132', '你好，我是一名来自北京的平面设计师，学过美术，拥有视觉艺术研究硕士学位，当前在武汉为全国各地的客户工作。我最大的热情是了解你，你的品牌，并通过精心制作的品牌形象反映你真实的故事。我认为品牌应该更加人性化，大胆，感性，对他们渴望接触的人做出反应。这是我的职业挑战，也是我不断与我的每一位客户面对的挑战。我在每一个项目上都付出了额外的努力，以出色的方式讲述你的故事。随时联系我！\n', 10, 0, '', '110000', '110100', '110105', '', '15110245740', '15110245740', '2020-10-14 16:01:18', '2020-10-14 18:14:49', -1, 1, 0, '2020-10-14 18:14:49.109');
INSERT INTO `freelancer_info` VALUES (4001, 4001, 'HowWork客服', 'HowWork客服', 'https://thirdwx.qlogo.cn/mmopen/vi_32/nuLEiaxX0hzQHDQZqWuBuEBQUT4yr2icI7jaqk0g4FXS8jQ2iajGmqnWMa4VAn3lfORlMHEN0JtjD6BicNfkJOnMhA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13261773089', '2020-10-14 16:40:53', '2020-10-14 16:40:56', -1, 4001, 0, '2020-10-14 16:40:56.356');
INSERT INTO `freelancer_info` VALUES (4002, 4002, '大力🍋', '大力🍋', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erxgsdezJSjynLhOjZRhDdc1FMUichmv69jnCCZwAcztmeAxQZIp9wiaJXxTjV2kDJQKC8QBqxQs6aQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13331138761', '2020-10-14 16:51:41', '2020-10-14 16:51:44', -1, 4002, 0, '2020-10-14 16:51:43.831');
INSERT INTO `freelancer_info` VALUES (4003, 4003, '董亦', '董亦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK04GtFYBs2wEuDSheebJppicibXSrUlzeeYm6emKcqBicg5Y0Fp4gibnEcvo9djvroW9iarKHEtIUkuFQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13067817724', '2020-10-14 18:16:18', '2020-10-14 18:16:23', 2002, 4003, 0, '2020-10-14 18:16:22.761');
INSERT INTO `freelancer_info` VALUES (4004, 4004, 'Mr.MJ', 'Mr.MJ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqZjcJtcEHQaO1gk8YayfJerm2m24m6rIicGngqLr24YpZXBaxqsfq7EESJf79F67jIetYCb6RPKNw/132', '我叫王敏佳，我们团队从今年6月开始为第一个客户运营天猫和京东，经过4个月营业额从4w到13w，利润不降反升.一只朝气得90后团队，相信不断创造价值，不断突破，“变化”才是面对不确定性的最好方式.', 10, 0, '', '310000', '310100', '310104', '', 'ad53319819', '15221907328', '2020-10-14 18:51:49', '2020-10-14 19:21:23', 2003, 1, 0, '2020-10-14 19:21:23.017');
INSERT INTO `freelancer_info` VALUES (4005, 4005, '君扬', '君扬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJaD0xeiaicfgia0E9ia3s2blhjNia5ZO5phMzm7LVgj7jkglVeibdmqXW11icIEDWOrtn9UR8tOMciaqA1ng/132', '我住在天津，是一名成熟的python后台开发工程师，同时，我还有一个全栈的开发团队', 10, 0, '', NULL, NULL, '', '', '', '13302048330', '2020-10-14 19:23:04', '2020-10-14 19:25:31', 2006, 1, 0, '2020-10-14 19:25:31.216');
INSERT INTO `freelancer_info` VALUES (4006, 4006, '二东丶', '二东丶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLbrBKic45K6MSNYXbeCEBxGVsY9kIQxL4PmUKuJghFwvvubDxWACoHGwMOOlUIVph0PW5UKGAshdw/132', '金融，mysql、消息队列、spirng cloud、单元测试覆盖率，100%', 10, 0, '', NULL, NULL, '', '', '', '13264181224', '2020-10-14 19:33:54', '2020-10-14 19:48:40', 2008, 1, 0, '2020-10-14 19:48:40.082');
INSERT INTO `freelancer_info` VALUES (4007, 4007, 'Abby', 'Abby', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKKuXa6MoPRiczkFQTXkDxr4IibTGC5vNylWB7m3PocWhV106tTaChRMukQXeFvOM6M9EZc7icrNkfIA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15011103665', '2020-10-14 19:45:48', '2020-10-14 19:45:51', 2005, 4007, 0, '2020-10-14 19:45:51.221');
INSERT INTO `freelancer_info` VALUES (4008, 4008, '江声', '江声', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIJcnqT8h9u8DTO69AxseV7rRtakuCGILGicYz1TISBuKAcdmx6T2ceVYva76sod72s2wwUgGu3Bvw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13716988056', '2020-10-14 19:49:16', '2020-10-14 19:49:18', 2005, 4008, 0, '2020-10-14 19:49:18.288');
INSERT INTO `freelancer_info` VALUES (4009, 4009, 'FE', 'FE', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLOhHuWCdKrZTHyNcbg30VPTQZKg2wicyicSRKibJWeyibFhaU0sEucEDGZEPicIQw6I7rh9MkZBcdcXIA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15566899876', '2020-10-14 19:49:54', '2020-10-14 19:50:00', 2005, 4009, 0, '2020-10-14 19:50:00.291');
INSERT INTO `freelancer_info` VALUES (4010, 4010, 'Beyondsky', 'Beyondsky', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epOA01ibEIYceFvqyjtGD4eR9LvAOQzrEHAq5DoWzrC5Y4MnyuZA6oq2639qkXlWW9VFl2szbrr2xg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13522285321', '2020-10-14 19:50:09', '2020-10-14 19:50:24', 2009, 4010, 0, '2020-10-14 19:50:23.734');
INSERT INTO `freelancer_info` VALUES (4011, 4011, '阿白', '阿白', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM4C2qIotaBho6E2tu5wfmtTYAw6nViamQZibsMoFaGkUjgXKE9y1UEUMW5cgKIxy0yuDucQAWib7mMIg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13701246092', '2020-10-14 19:52:00', '2020-10-14 20:03:53', 2010, 4011, 0, '2020-10-14 20:03:53.492');
INSERT INTO `freelancer_info` VALUES (4012, 4012, 'Tigger', 'Tigger', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eru8vCvpIedl4uIc8edb5zicDRsQcgR7pv79ib3GJyUfVXpffLe1av94Ly5oBOVDzvwDmTjQwdoGeog/132', '', 10, 0, '', NULL, NULL, '', '', '', '13240119298', '2020-10-14 19:53:19', '2020-10-14 19:53:23', 4011, 4012, 0, '2020-10-14 19:53:22.712');
INSERT INTO `freelancer_info` VALUES (4013, 4013, 'Dennis', 'Dennis', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBCG76XZZVPuDENj2aSrnWtticsibckb4fKZtJhPZo7oroxhVXkRY7V4MdCpTeXCyibSwb5zfp4V8NvA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18516224166', '2020-10-14 19:56:30', '2020-10-14 19:56:33', 2009, 4013, 0, '2020-10-14 19:56:32.632');
INSERT INTO `freelancer_info` VALUES (4014, 4014, 'Leanne', 'Leanne', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI08UYkOdJziaicgmxGKiaooRpB8ic47JyicaTGYn3AJFHppEMSC2iaR7SFwx9qeNNU3gbhO8VYDF1MtePQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13683687235', '2020-10-14 20:04:56', '2020-10-14 20:05:00', 4013, 4014, 0, '2020-10-14 20:05:00.120');
INSERT INTO `freelancer_info` VALUES (4015, 4015, 'Victoria🦄', 'Victoria🦄', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqDto46VMrZf01mbs1AfyKLrGQ4O6XQibqLU6wZKRRL518u8GFZGddyGKwQymL3YUURSOC37UnicaeQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '17600498222', '2020-10-14 20:09:40', '2020-10-14 20:09:43', 4013, 4015, 0, '2020-10-14 20:09:42.936');
INSERT INTO `freelancer_info` VALUES (4016, 4016, '郭峰', '郭峰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eriagictpucFF6ibeL1mRL7rfQPju5KV1H3zias0CnJ4sBc4ysFlEV4CoG0Nb5ccGrVOP2m4gZs3uGKUQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611687063', '2020-10-14 20:12:53', '2020-10-14 20:12:57', 4013, 4016, 0, '2020-10-14 20:12:57.102');
INSERT INTO `freelancer_info` VALUES (4017, 4017, '惠鹏|盛世三人行', '惠鹏|盛世三人行', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK14wx7cL8PEc8TnpaBpLI7n2tIbRQRhIyF1mcPUIlzQ6tnteD3uyFunyHpcTIL2k8t8d9qeHKH4g/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-14 20:43:55', '2020-10-14 20:43:55', 2015, 2015, 0, '2020-10-14 20:43:55.228');
INSERT INTO `freelancer_info` VALUES (4018, 4018, '毛毛钱儿', '毛毛钱儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIlJicNmiaibib3Jzl9QX3mE8DVuicv4ukicSddkkYWT23BPeecQgHZc2GN5Kjw8roOicX3ziahKrr2DxjAhQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13811602180', '2020-10-14 20:51:07', '2020-10-14 20:51:16', 2016, 4018, 0, '2020-10-14 20:51:16.234');
INSERT INTO `freelancer_info` VALUES (4019, 4019, '郭项玉', '郭项玉', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKgA8bMuSpADlj8y8FTX8D6ciarcN1aXx5nfhp5F9ThaNv1O3vnByib9Lp4jGvBGJiaaKwqWRd7ltuKg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13121813382', '2020-10-14 20:55:19', '2020-10-14 20:55:25', 2017, 4019, 0, '2020-10-14 20:55:25.241');
INSERT INTO `freelancer_info` VALUES (4020, 4020, 'sun', 'sun', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoUmVMortCC1GEEnjic1ibNIM6jUHsabMDKb0ZQKnMVsCRomibqwqnhqwIY3jUP6cnpZ4T3r7MtrvPSA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13718911001', '2020-10-14 20:55:46', '2020-10-14 20:55:50', 2015, 4020, 0, '2020-10-14 20:55:49.611');
INSERT INTO `freelancer_info` VALUES (4021, 4021, '巴拉巴拉不啦', '巴拉巴拉不啦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/RNic9ILGf7zA15L0oqoHJnG7wh3yBPxPsDgpP98bBFshBRgibIjjY32wlomgz4CqzBExNZLch7WTria3phEhHKIyw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18519580645', '2020-10-14 21:21:22', '2020-10-14 21:21:26', 2018, 4021, 0, '2020-10-14 21:21:25.543');
INSERT INTO `freelancer_info` VALUES (4022, 4022, 'stan.j', 'stan.j', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK2IGjBHxn5N8mNznQBw8P7M7JtzRuKLJV7BgyCBjpnw2XKG9m5Dsczf00AoM4wQtorMicKSsQkakA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18810178690', '2020-10-14 21:25:31', '2020-10-14 21:25:37', 2020, 4022, 0, '2020-10-14 21:25:36.872');
INSERT INTO `freelancer_info` VALUES (4023, 4023, 'MAOXT', 'MAOXT', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqgJaiaS4uxy06cq9N2UEHial5gDiceV038s6p5phktV05cj6wrUHDGpUj0QQBsGic10Xe7duLM2gtcWA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18618284020', '2020-10-14 21:27:40', '2020-10-14 21:27:47', 2020, 4023, 0, '2020-10-14 21:27:47.235');
INSERT INTO `freelancer_info` VALUES (4024, 4024, '你没', '你没', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIZ7wT7fOlAz3ad9ZwdxImvcjxicoy7ByIXqnyNPkQv64mwDrOxGXhayUguGMy6s6ytx9VdQdNoKvA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-14 21:41:40', '2020-10-14 21:41:40', 4023, 4023, 0, '2020-10-14 21:41:39.867');
INSERT INTO `freelancer_info` VALUES (4025, 4025, '马俊', '马俊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqSn7SKIwE2NF7ALa48LbickYAtcibuJ1jQJDDFCJ3y9qPjdictiasj9E5ibCKzDvwN2tiaINtibZX4ribjTA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-14 21:44:55', '2020-10-14 21:44:55', 4023, 4023, 0, '2020-10-14 21:44:55.397');
INSERT INTO `freelancer_info` VALUES (4026, 4026, '高高', '高高', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqsxdVNykRAznxrCdWXbR4B47eRKLpsib4TbJN4Ayw3DNTzAOTbeOUq64onTR8kwicdK9PlX43Biajog/132', '15年互联网品牌公关学习和实践经验，拥有专业系统的品牌建设打造手法和经验 。个人微博8万+粉丝，拥有大量明星资源，可提供明星代言，短期商业授权，明星合作等。（在一手明星报价基础上，根据难易程度收取佣金5—8%）；文笔出众，独立出书和杂志上百本。个人微博8万+粉丝，微信公众号和视频号均有一定影响力。（文稿费:纯原创2000元/1000字；修改类1500元/1000字)', 10, 0, '', NULL, NULL, '', '', '', '15011353173', '2020-10-14 22:13:50', '2020-10-14 22:42:29', 2013, 1, 0, '2020-10-14 22:42:28.685');
INSERT INTO `freelancer_info` VALUES (6000, 6000, '汤继荣律师 15618301701', '汤继荣律师 15618301701', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTICBrkJyDjjHey5WzykZa6kqswJiatG81srqg2XA5HWLuPZ5YIawEUA95SNIYLqyO46ZDyLFVUntzw/132', '原上海普陀区人民法院法官、刑庭、执行庭、民商事审判庭主审法官，现任多家企业法务总监、顾问.烁光法税平台创始人，可组织专业团队从多专业领域交叉综合解决企业痛点问题\n接受免费电话咨询，专案项目按照专案确认', 10, 0, '', NULL, NULL, '', '', '', '13818872885', '2020-10-15 03:39:26', '2020-10-17 00:35:18', 2000, 1, 0, '2020-10-17 00:35:17.973');
INSERT INTO `freelancer_info` VALUES (6001, 6001, '冯 宁', '冯 宁', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL2GBvNwxu4PVCIDWnOdrqszjGBD9Layr3ibN4XcHCdk3CQicNL9nekrAT95qERqKsmuO8LGYkNq5Qw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910429707', '2020-10-15 08:59:17', '2020-10-15 08:59:21', 4005, 6001, 0, '2020-10-15 08:59:21.148');
INSERT INTO `freelancer_info` VALUES (6002, 6002, 'Leo', 'Leo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/umBbHGdic4jV4libLU9o8UXkfyvLZo1J7nlszqgwiaHjwJGqaIqZUcYTYuTk1FDMhfAORlqKqcYqFF0csQJEScOiaA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 10:12:12', '2020-10-15 10:12:12', 4005, 4005, 0, '2020-10-15 10:12:12.404');
INSERT INTO `freelancer_info` VALUES (6003, 6003, '小锅锅', '小锅锅', 'https://thirdwx.qlogo.cn/mmopen/vi_32/mAGK7Wtn392B6bdZDyd4p8ia5GdcR2huGlN2KqPfEJ6RGbERCgnhyuFrr0ZgdvmHwwvgjJkibGb9IvfflV57M28A/132', '', 10, 0, '', NULL, NULL, '', '', '', '18511697147', '2020-10-15 10:14:46', '2020-10-15 10:14:51', 4005, 6003, 0, '2020-10-15 10:14:50.851');
INSERT INTO `freelancer_info` VALUES (6004, 6004, '木子', '木子', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJsjcw1SDskBJxlK6JX7XicPOEU3OTk2aFDqEGtLZUoYl74mKnLYXqEZkujszfYOVibeAqxSMicWeBBA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15011322815', '2020-10-15 10:33:56', '2020-10-15 10:33:59', 4000, 6004, 0, '2020-10-15 10:33:58.673');
INSERT INTO `freelancer_info` VALUES (6005, 6005, 'WhenUBelieve', 'WhenUBelieve', 'https://thirdwx.qlogo.cn/mmopen/vi_32/wVJLKmibyYdrCGCeiaaBt5ibQwiaPxrNLgx8AmAEYPibOicL8VIuCaicFrtrZldgJSW8HxbKiaXJP0qDibhiaPWSrwXmFwCg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 10:37:49', '2020-10-15 10:37:49', 2007, 2007, 0, '2020-10-15 10:37:48.771');
INSERT INTO `freelancer_info` VALUES (6006, 6006, '轩辕客', '轩辕客', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqnx3Y4WEwsD80awtVcCPeK2Pm8KUerVUEWoOxD4Jm9vXUTnSaa7De4OKbgQg64D4h4iaVbPDU1opA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15901476757', '2020-10-15 11:22:03', '2020-10-15 11:22:09', 2007, 6006, 0, '2020-10-15 11:22:09.222');
INSERT INTO `freelancer_info` VALUES (6007, 6007, 'Samson孙峰', 'Samson孙峰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKP02vhVpuXoKS3qhbyAnZmqtq9SvLxBDciaUYBs3cKPs4cT2Gn6cxD4vUhaLf0nQ8TrBwXz5vicsTA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13901328854', '2020-10-15 11:25:50', '2020-10-15 11:25:53', 6006, 6007, 0, '2020-10-15 11:25:52.834');
INSERT INTO `freelancer_info` VALUES (6008, 6008, '敬淞  ྃ༄༅།འགུ་རུ་།', '敬淞  ྃ༄༅།འགུ་རུ་།', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM5mqiaRDoAhajND8ia91E7lyoqGqcEDcR4pLDChI7LMfJKljAsuxtQvt1kTsXolM6v8JQekEb8qkicnw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13522137269', '2020-10-15 11:26:48', '2020-10-15 11:26:51', 6001, 6008, 0, '2020-10-15 11:26:50.940');
INSERT INTO `freelancer_info` VALUES (6009, 6009, '那谁', '那谁', 'https://thirdwx.qlogo.cn/mmopen/vi_32/GQp8bndH8SwDC7uWQLVDDB3IVCaib7kiaB32WKElG6wZyiaeib6nsZ99KBOmOBlbak9pptFAbIr4RqC8wFwcxTSLFw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 11:43:48', '2020-10-15 11:43:48', 4023, 4023, 0, '2020-10-15 11:43:47.808');
INSERT INTO `freelancer_info` VALUES (6010, 6010, '九言', '九言', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ephqYEb1kicCR1BJdHoib4WEtkHZk8l7QM7yzMUzaicNKTah6GYlLZW3SrPfC4skunCAYWqw1OftuTEg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13653958513', '2020-10-15 11:59:47', '2020-10-15 11:59:50', 8004, 6010, 0, '2020-10-15 11:59:49.603');
INSERT INTO `freelancer_info` VALUES (6011, 6011, '🦡小明🦊', '🦡小明🦊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKaSdSDpHf9jwE1hzVu1W2TP4ajVANMSprjXCHB5DC1rKMdGjTibMxseMWvSTRd2R46YibXkJLFPjtQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 12:00:26', '2020-10-15 12:00:26', 6010, 6010, 0, '2020-10-15 12:00:26.347');
INSERT INTO `freelancer_info` VALUES (6012, 6012, '胡博', '胡博', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLFg5tqQZ0MAYVibj1GcPtLdpG1uwSoG8sF197ZVfEM0MdWzNhyzqjCOhZxK0blzhqq4xHFJ4njvfw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13466336122', '2020-10-15 12:01:22', '2020-10-15 12:01:26', 2000, 6012, 0, '2020-10-15 12:01:26.344');
INSERT INTO `freelancer_info` VALUES (6013, 6013, '张泡面', '张泡面', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLGhUVNkpWcgLttLcTtIwNlyqpd1dP0jd6VblyDCaoPvN4291ic4Ht5JpFa1VXECVMQricJApibuxuzA/132', '', 10, 0, '', NULL, NULL, '', '', '', '16619715506', '2020-10-15 12:05:43', '2020-10-15 12:05:45', 8009, 6013, 0, '2020-10-15 12:05:45.491');
INSERT INTO `freelancer_info` VALUES (6014, 6014, 'Sarah Cui 崔艳荣', 'Sarah Cui 崔艳荣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKBjb9zHPLciasrZOExKyjHwdRBeuhZsJ2DBnDxicIM6fwzphjBJXnIqtpR64wMkUuF9tOTpCW3ic9Mg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18516265080', '2020-10-15 12:25:43', '2020-10-15 12:25:47', 8011, 6014, 0, '2020-10-15 12:25:47.306');
INSERT INTO `freelancer_info` VALUES (6015, 6015, '黄婷', '黄婷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJe1PH2ctrLXo7GLKNDUPQUZk4bS3BCM3ic6AA9YVroVSlz1Y8LkWWQMbBnRRNOrP8UGcLVjdxIubQ/132', '德国斯图加特大学毕业（Uni-Stuttgart 精英大学联盟校），10年招聘工作经验，曾服务留学行业头部公司，有海外高端人才（含外籍教师）以及国内教育To B/C销售和市场人才、分公司分总（校长）招聘经验。个人性格：执行力、责任心、学习能力以及自律性强，快速挖掘公司业务流程以及深刻理解行业特点和发展机遇，挖掘职位和个人匹配亮点', 10, 0, '', NULL, NULL, '', '', '', '18618296273', '2020-10-15 12:25:56', '2020-10-15 14:07:16', 8011, 1, 0, '2020-10-15 14:07:15.899');
INSERT INTO `freelancer_info` VALUES (6016, 6016, '李雪', '李雪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlRicM4EutouH8pTZsYltHWseCT9qEXLZ66BtZ32JawC2ibmpbgKiaDk3drlmbScLAwwicPNsfjyVMFw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15268631865', '2020-10-15 12:34:33', '2020-10-15 12:34:36', 6015, 6016, 0, '2020-10-15 12:34:36.199');
INSERT INTO `freelancer_info` VALUES (6017, 6017, 'mistletoe🍀', 'mistletoe🍀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/3Nb8UuhjwiaVzSYqQHCTlzpCErC5u1qwCTvcCwd91UUghza0VFrI0PT0TOv9cnajqQQ5FCicD7Ew8AJfFwc93L9w/132', '', 10, 0, '', NULL, NULL, '', '', '', '15768716486', '2020-10-15 12:43:12', '2020-10-15 12:43:16', 6016, 6017, 0, '2020-10-15 12:43:16.145');
INSERT INTO `freelancer_info` VALUES (6018, 6018, '乐成', '乐成', 'https://thirdwx.qlogo.cn/mmopen/vi_32/na6MRMnZwRl4gHbibXOHmLsSutodUN5EpzpicyKGTHjwDpsKVicVia4nLicC87fia87BkxkaZIbMr83wyicZzUwfFFvibw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18800176762', '2020-10-15 12:48:57', '2020-10-15 12:49:01', 8013, 6018, 0, '2020-10-15 12:49:01.323');
INSERT INTO `freelancer_info` VALUES (6019, 6019, '蓝果', '蓝果', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI3HKb6YtXbibUnjvPqDMibmOJM35MvrLict2vTrbvnqbVSpUmo4jwY5MErsjNmXx6XofttfGgEZ7x4g/132', '', 10, 0, '', NULL, NULL, '', '', '', '13301312051', '2020-10-15 12:52:12', '2020-10-15 12:52:15', 8012, 6019, 0, '2020-10-15 12:52:15.436');
INSERT INTO `freelancer_info` VALUES (6020, 6020, '威能&贝雷塔壁挂炉13391653950', '威能&贝雷塔壁挂炉13391653950', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJDExlPBTcsr2MoWBv941ia3fjosIibOoXicPpxFvVcafVGib4buSHe6nxicG3yZcAmnxmqUZyPBynLbOw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13391653950', '2020-10-15 12:54:07', '2020-10-15 12:54:13', 8012, 6020, 0, '2020-10-15 12:54:13.085');
INSERT INTO `freelancer_info` VALUES (6021, 6021, 'guoxlong', 'guoxlong', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMFcwG2UicNSPH8kFyg0pBDcViaLKbnPwFDKia5kXnr7WaqMAGfEtIFkAw8LsghNFLXvT4FNwwH1OuQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18311238336', '2020-10-15 13:03:49', '2020-10-15 13:04:35', 8017, 6021, 0, '2020-10-15 13:04:34.740');
INSERT INTO `freelancer_info` VALUES (6022, 6022, '阿白', '阿白', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLsLkkF6cCgdGLPY8hAibg03PfLHFvFQG5FaG8GFDG5atiaWIXLQAtxHC70XdPA4ibzfawlKd6qKslUw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18601350717', '2020-10-15 13:14:37', '2020-10-15 13:14:43', 6021, 6022, 0, '2020-10-15 13:14:42.550');
INSERT INTO `freelancer_info` VALUES (6023, 6023, 'Jason-AICO', 'Jason-AICO', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ephmeHBXjZU0cia3BAsI0F3tqOxzeKd4jS1g1QHbybE8plN74w4DucWyqWuZ41SKaXdrLClMNAQRog/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910210808', '2020-10-15 13:21:16', '2020-10-15 13:21:30', 8023, 6023, 0, '2020-10-15 13:21:29.624');
INSERT INTO `freelancer_info` VALUES (6024, 6024, '张卷🕴', '张卷🕴', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkQYWxoGC8hEibld9KQ3hvcdeeMCicqCrKwtPzoMHTyAKjsbc0euotB4uYrfhpSguHnPbrA4JeibbAQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 13:26:19', '2020-10-15 13:26:19', 8027, 8027, 0, '2020-10-15 13:26:18.664');
INSERT INTO `freelancer_info` VALUES (6025, 6025, 'David.Li', 'David.Li', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoo6uFTgKySGHRP5t0KB0GX6fXflkXddBFpJFia59bkeNSTjo0fJ38j0sxTlZUPXXM5TR2LlYauk6Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '18355380522', '2020-10-15 13:29:55', '2020-10-15 13:29:59', 8027, 6025, 0, '2020-10-15 13:29:59.066');
INSERT INTO `freelancer_info` VALUES (6026, 6026, 'atreyu', 'atreyu', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ermWNtiajr22z8rcFvFY0T65q9icaD2j0fehWsMHmYiaRKK6pBA5aib4CK3RMXyngQ4PTrpDF5Dk8ib8cQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13862026360', '2020-10-15 13:30:00', '2020-10-15 13:30:03', 8027, 6026, 0, '2020-10-15 13:30:03.367');
INSERT INTO `freelancer_info` VALUES (6027, 6027, '東叔(^㉨^)', '東叔(^㉨^)', 'https://thirdwx.qlogo.cn/mmopen/vi_32/KKV7U228SaJx1A1MYG0Q7aibibdDGMSFQDWZfsywibKrMgXHoTTesPJSj1oKGRjEric4PqJgVZ84u8zMf1xGmd8X9A/132', '', 10, 0, '', NULL, NULL, '', '', '', '13436820396', '2020-10-15 13:30:14', '2020-10-15 13:30:20', 8027, 6027, 0, '2020-10-15 13:30:20.445');
INSERT INTO `freelancer_info` VALUES (6028, 6028, '知遇', '知遇', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLsRhFESf3TwibyJ4xZUtJHTwqICfUz0YmlXNlgPBwYdr0ectNKhS6m6HgxI21sfXlmKPJibPGKfWCA/132', '', 10, 0, '', NULL, NULL, '', '', '', '17093032020', '2020-10-15 13:31:14', '2020-10-15 13:31:17', 6026, 6028, 0, '2020-10-15 13:31:16.530');
INSERT INTO `freelancer_info` VALUES (6029, 6029, 'Econear HR_Grace', 'Econear HR_Grace', 'https://thirdwx.qlogo.cn/mmopen/vi_32/reMf8x6NaE7yWfOvEIVUic7ico3HU4y4MH7Gxo0ia2RbmHObicjjVNEeGiaLWD6gnzRWTib9gHDmlsYy7LxFCYJyq6Sg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 13:32:04', '2020-10-15 13:32:04', 8023, 8023, 0, '2020-10-15 13:32:04.219');
INSERT INTO `freelancer_info` VALUES (6030, 6030, '志轩', '志轩', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0ojpGnRMCXxmwyOsDBCOML7bWnaFUGSW0EaQl3Sruibw2qibEUldUB1B2AYGVCObEl6DfDm8h86oA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15010827586', '2020-10-15 13:33:55', '2020-10-15 13:33:58', 8012, 6030, 0, '2020-10-15 13:33:58.079');
INSERT INTO `freelancer_info` VALUES (6031, 6031, '🎀germaine🎀', '🎀germaine🎀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/0iaiauALtEFdUVrb5lGsbhJl37aZficEnZGNCaBsyWK7mibjeLlcfelw4xcp2icCCcdTl6kYicHia5kuI8Vhbr3jnibkrw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18516614855', '2020-10-15 13:42:51', '2020-10-15 13:42:55', 8017, 6031, 0, '2020-10-15 13:42:55.140');
INSERT INTO `freelancer_info` VALUES (6032, 6032, '马成功', '马成功', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJO3xWwgMlqWxdZUHE0KFUjfoXQvh15Jj9NZueZuicIKibJUYl3MKeNLn8HicIFzgykg7GaVS7APrptw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910906162', '2020-10-15 13:43:14', '2020-10-15 13:43:18', 8030, 6032, 0, '2020-10-15 13:43:17.555');
INSERT INTO `freelancer_info` VALUES (6033, 6033, 'zoe', 'zoe', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoZq04zg7Ym4IAkJlA8aNwKozu9ebD9JTxT1LbHZ64Jic7AgzLHgtUFDiaAUQ1sBNIqUUhv0v3mkD1w/132', '', 10, 0, '', NULL, NULL, '', '', '', '18768177858', '2020-10-15 13:49:38', '2020-10-15 13:49:41', 6028, 6033, 0, '2020-10-15 13:49:40.616');
INSERT INTO `freelancer_info` VALUES (6034, 6034, '宁溘死以流亡兮', '宁溘死以流亡兮', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Uq8ibgONzWvwENdYhcHFUfblh2PbC5YUXE4qp35YbHKRJgCye9caM8jIp3cnIXpSDNbWMiashGQyA3nZSw9exxGg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18510786711', '2020-10-15 14:01:09', '2020-10-15 14:01:13', 8025, 6034, 0, '2020-10-15 14:01:12.532');
INSERT INTO `freelancer_info` VALUES (6035, 6035, '林。', '林。', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELaFwfVsJtNNZARlWJZOM8jE4e7dgyianEH7bWEkszCt4yN8jQu0d5lpuMvWvJybfldepkWZFeMXcQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18705040300', '2020-10-15 14:02:59', '2020-10-15 14:03:02', 8031, 6035, 0, '2020-10-15 14:03:02.407');
INSERT INTO `freelancer_info` VALUES (6036, 6036, 'Anan', 'Anan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6pjAcqAwjE9vREzDicEicyygHrKdhiaBS5J3DDW9VsW8TJfCtOt2iaibRvZ5NciajAc6pOehnub54U0ribQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '15848798130', '2020-10-15 14:03:47', '2020-10-15 14:03:52', 6032, 6036, 0, '2020-10-15 14:03:52.351');
INSERT INTO `freelancer_info` VALUES (6037, 6037, 'Claire.J阿章🦑', 'Claire.J阿章🦑', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er73rJ1CtTVSQibWfqluEiagG3IbY0PNp7EE4y807IeYIvxv4yEu9OBDxb5ROD9D10onMD2Pjb1DBaA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15651716250', '2020-10-15 14:07:14', '2020-10-15 14:07:17', 6032, 6037, 0, '2020-10-15 14:07:17.068');
INSERT INTO `freelancer_info` VALUES (6038, 6038, 'Tony,刘跃生', 'Tony,刘跃生', 'https://thirdwx.qlogo.cn/mmopen/vi_32/LLyKWMqboIiaDgar1ElITjQRj8yDZhWD0IZF2iaCwjgQPtUCG0mIfGuou5xC37sX9Vic8SQKPX8WSMUibfBvicKGKPQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 14:15:24', '2020-10-15 14:15:24', 8000, 8000, 0, '2020-10-15 14:15:24.256');
INSERT INTO `freelancer_info` VALUES (6039, 6039, '王小君', '王小君', 'https://thirdwx.qlogo.cn/mmopen/vi_32/FQib9TdrgQwLHJkhxIul1TapmEEQLav5DwMISKXsAvjtzSycPVmRDyofy2PZ92GbmVXHLV4kPLicibpkcAgZgaJRw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18910526134', '2020-10-15 14:54:35', '2020-10-15 14:54:42', 8038, 6039, 0, '2020-10-15 14:54:41.612');
INSERT INTO `freelancer_info` VALUES (6040, 6040, '璠', '璠', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep1TuFVvfjkHSBoEibVgAGge9FNTib2mujPhXv5uWWtcZJrhUGuaKWnaibvYoWtAQ8N5oFumKRtlOwSA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15210361561', '2020-10-15 15:13:50', '2020-10-15 15:14:05', 6001, 6040, 0, '2020-10-15 15:14:04.656');
INSERT INTO `freelancer_info` VALUES (6041, 6041, '邢越', '邢越', 'https://thirdwx.qlogo.cn/mmopen/vi_32/zV5GshvC0GZr0qWu56xLyHOE0GhEEjl3gugE6wFsG1NtnspPpPxTjOG3RYsYBeLA3icEBfWeW5l5Wia9hl1G3gmQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13366203998', '2020-10-15 15:15:27', '2020-10-15 15:15:31', 6040, 6041, 0, '2020-10-15 15:15:31.123');
INSERT INTO `freelancer_info` VALUES (6042, 6042, '黄明月', '黄明月', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFAeZ8ibXJ9DCb9aCGWcYicINryWA0vYJWlSkPGB1HYFRkrrxOTf683PZ1PYph9XiccGsRI3ZQj7Ohg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18801352878', '2020-10-15 15:42:50', '2020-10-15 15:42:53', 8043, 6042, 0, '2020-10-15 15:42:53.392');
INSERT INTO `freelancer_info` VALUES (6043, 6043, '不愧是我', '不愧是我', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKrVnISvhlRt4LRKXmxwKfhJdpy1w3JdbtILr0td2NN1xKyvZlQMMmbd30q3tIdrBJqQsicmjliczVw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18510694664', '2020-10-15 18:09:29', '2020-10-15 18:09:38', 4006, 6043, 0, '2020-10-15 18:09:38.079');
INSERT INTO `freelancer_info` VALUES (6044, 6044, 'laughing.', 'laughing.', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKlHV0UAj0X8LfGQzooiat3Q9oh93e9Olh8AfTL0ksxyU7D0FmyVcicLnxyVYldo4Txh3h2m8wobIyg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13777419035', '2020-10-15 18:14:46', '2020-10-15 18:14:49', 4006, 6044, 0, '2020-10-15 18:14:49.037');
INSERT INTO `freelancer_info` VALUES (6045, 6045, 'STR', 'STR', 'https://thirdwx.qlogo.cn/mmopen/vi_32/fwYrSMM8GyJIlbFZTlQDXPeOz6MNLlynhZQcZSicHBEPZ7KqjN5A2DYajPu1WLYaXuLAx89ZyCWBLFyGarlbHqw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15142314727', '2020-10-15 20:18:05', '2020-10-15 20:18:15', 4000, 6045, 0, '2020-10-15 20:18:15.429');
INSERT INTO `freelancer_info` VALUES (6046, 6046, '东篱南山品牌设计', '东篱南山品牌设计', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEIXnfgQDv2l5p7kOhzSbKq3rMb10z12yUjG84jbSQAjqQFbZHe1vCsWks2L0Y4jKNnWj1qAhoOBibA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18201500208', '2020-10-15 21:27:38', '2020-10-15 21:27:58', 2000, 6046, 0, '2020-10-15 21:27:57.730');
INSERT INTO `freelancer_info` VALUES (6047, 6047, 'zyn', 'zyn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqCKbuKJNxS8xpXe4PjcibXkUzlhoQvjxRGgOnJNMibqQ8fHtjC5uWibmGL6DPOY8XfYlRLVAOp18ibqw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18601279221', '2020-10-15 22:18:14', '2020-10-15 22:18:18', 6012, 6047, 0, '2020-10-15 22:18:17.583');
INSERT INTO `freelancer_info` VALUES (6048, 6048, 'May🎨', 'May🎨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epkKbmIVtwWUtibicyC6muBMibicrxLBIoB132R0UYa3FvMvqueBSAibAzfULhbbiauE5L9rbzA7TypQqvw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18817576509', '2020-10-15 22:32:18', '2020-10-15 22:32:21', 4006, 6048, 0, '2020-10-15 22:32:21.453');
INSERT INTO `freelancer_info` VALUES (6049, 6049, '姚颖', '姚颖', 'https://thirdwx.qlogo.cn/mmopen/vi_32/MVSskmbLBI8JwguAaHVHCsCbhxfdIeFZTLo1hTbV0sAppba6p5Bm7dOr7NtJbwvUCialXZ0dgfZn6ZmqntQaMxw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13671146571', '2020-10-15 23:14:09', '2020-10-15 23:14:14', 2000, 6049, 0, '2020-10-15 23:14:14.201');
INSERT INTO `freelancer_info` VALUES (6050, 6050, 'argo', 'argo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM7T7x4juP79mADfm66IehFNwp68jSGLunkwiczvQkicGOmx3vyTAmtufpUDbXlHicONBRew8pDtQDEibw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-16 02:55:13', '2020-10-16 02:55:13', 2000, 2000, 0, '2020-10-16 02:55:13.188');
INSERT INTO `freelancer_info` VALUES (6051, 6051, '杨建宏@HowWork', '杨建宏@HowWork', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8NMONgicic7pSbkpNOMEx0u2MMV1gM5XORttrBHKmHnO5zZl9ZgVeSwuALaJkibHz5kXAHK84iaIuIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611928615', '2020-10-16 06:17:35', '2020-10-16 06:17:39', 2000, 6051, 0, '2020-10-16 06:17:38.817');
INSERT INTO `freelancer_info` VALUES (6052, 6052, 'Hoody', 'Hoody', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIleB7ribGFFGjgwdTMBPicibPDpy8CWFxSAYFicr1B2WVx5ia57FefZc88rBqG0hzJo58cFluUvEtMIYg/132', '', 10, 0, '', NULL, NULL, '', '', '', '17611669300', '2020-10-16 08:05:38', '2020-10-16 08:05:43', 4002, 6052, 0, '2020-10-16 08:05:42.799');
INSERT INTO `freelancer_info` VALUES (6053, 6053, 'Wangyuan', 'Wangyuan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIyGC6TqAOyeBLTQWbFgyN2mPvQmXhibZ7jib6axagibNR5EKNKNWyHiaUKfflHXuytXIgyVvoveD9OCw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18616193720', '2020-10-16 10:15:09', '2020-10-16 10:15:17', 6001, 6053, 0, '2020-10-16 10:15:17.174');
INSERT INTO `freelancer_info` VALUES (6054, 6054, '雪迈', '雪迈', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI6nRIhgjVOM9FyJYAfkBBYldBV76DIfCicQtqTTvvR76yyYh2gK3yAbN5vdd1HlANScYxp1EFcDCw/132', '毕业于湖南师范大学，社会心理学硕士，国家二级心理咨询师，2005至今分别在高校和企业担任心理健康咨询师，擅长领域：成长辅导、亲子教育以及青少年心理咨询和婚姻情感咨询辅导等。', 10, 0, '', NULL, NULL, '', '', '', '13456966710', '2020-10-16 10:39:01', '2020-10-20 17:24:13', 8058, 1, 0, '2020-10-20 17:24:13.472');
INSERT INTO `freelancer_info` VALUES (6055, 6055, '王小央ོ', '王小央ོ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJdursINmHvQCNfBzvzk9udTAhLWrmjAz7lUxDDQ0pWdWfRj4I8pReaJTPIdvCpphRIeSSy6DicujA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13605813737', '2020-10-16 10:40:28', '2020-10-16 10:40:30', 6054, 6055, 0, '2020-10-16 10:40:30.384');
INSERT INTO `freelancer_info` VALUES (6056, 6056, '🎀Le Papillon🎀', '🎀Le Papillon🎀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2Ynhnd93otFJicAVibaBNebiakVuBdA67icTcOx4cFicNib7SKictGNaibbL5hCWrNvia1MadkXT0kT1ekuw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13735494363', '2020-10-16 10:59:24', '2020-10-16 10:59:27', 6054, 6056, 0, '2020-10-16 10:59:27.154');
INSERT INTO `freelancer_info` VALUES (6057, 6057, 'Annie 毛豆', 'Annie 毛豆', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epibZ9NtMMRyjYyViaCK5G3JGUibfh9RUkAvmPguWjFlYrK1BPG1nuklsQHeIk2rE8icSZbtV8vvjZleQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18668075325', '2020-10-16 12:11:27', '2020-10-16 12:11:32', 8064, 6057, 0, '2020-10-16 12:11:32.045');
INSERT INTO `freelancer_info` VALUES (6058, 6058, '光阴的故事', '光阴的故事', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eox2aVWNRiaXLK7XxMjuicYAEZghFNicVPn1zgzKE5BOSEMkQu5yZUNTVgJ2Xsxa3piajvjgibhvNxRZhQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-16 19:15:19', '2020-10-16 19:15:19', 6051, 6051, 0, '2020-10-16 19:15:19.449');
INSERT INTO `freelancer_info` VALUES (6059, 6059, '王超', '王超', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLC1qvkb7LHMb2Z8ClTbqJqntyXdVmOuPjBL0nFiaKqibzgrN3pVtEMDIiaqfNg0ssamf2TQeZuVt0dQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '15810804929', '2020-10-16 19:39:23', '2020-10-16 19:39:32', 6051, 6059, 0, '2020-10-16 19:39:32.486');
INSERT INTO `freelancer_info` VALUES (6060, 6060, '神经蛙', '神经蛙', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM4yp2lVBsPmTDGp7RzWIEUjDjmic29cJPciaU6pK0pFcrH4n8GBq9N6U13WFqeRHZUkrVhYjv6YHT5A/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-16 19:47:13', '2020-10-16 19:47:13', 8067, 8067, 0, '2020-10-16 19:47:13.115');
INSERT INTO `freelancer_info` VALUES (6061, 6061, 'Timo', 'Timo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELNoKQeKo5UJIXxF9iaEefYRIjibcAIpwTGibaiaTR6Ue8LjTjDibrNOrJ7jvtq2kCTCUyI44wQyCIOzGA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18311080582', '2020-10-16 20:08:02', '2020-10-16 20:08:05', 8045, 6061, 0, '2020-10-16 20:08:04.959');
INSERT INTO `freelancer_info` VALUES (6062, 6062, '李文波', '李文波', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLHDy8U1uurf45bf0f2DlGRal9hVzkYm0600UW06CLbLHu5wsm7X5UtNKAvPKCljWnsRGdZ07yyTQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18223455359', '2020-10-17 10:02:18', '2020-10-17 10:02:28', 2000, 6062, 0, '2020-10-17 10:02:28.119');
INSERT INTO `freelancer_info` VALUES (6063, 6063, '谷堆那儿', '谷堆那儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqwoahL8O0Wndx9IjR0sZyxu1eaPpPzFOdmY6yjCNWjHPkPnqQ2TROF54hkpXQLwcPhkicwZrU580w/132', '', 10, 0, '', NULL, NULL, '', '', '', '13525516792', '2020-10-17 12:14:49', '2020-10-17 12:14:59', 6007, 6063, 0, '2020-10-17 12:14:59.084');
INSERT INTO `freelancer_info` VALUES (6064, 6064, 'nora', 'nora', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJAqVXYe3LJ7IBlUvSx5GwuDLaKqoD2I7bkb3LrxPCS1K2Cd2hn7W6O2dLEYonruBTLKKIX5mt0lQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13693065582', '2020-10-18 18:26:46', '2020-10-18 18:26:51', 2000, 6064, 0, '2020-10-18 18:26:51.392');
INSERT INTO `freelancer_info` VALUES (6065, 6065, '怡然', '怡然', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIUrbLAzgYEiaAO3tC99hKnmayErfHEt02iacoKw1pcvO72GEdWYnEFS535iaeGkhqiaQZ7Ko1gRbjWCw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-18 19:11:53', '2020-10-18 19:11:53', 2000, 2000, 0, '2020-10-18 19:11:53.477');
INSERT INTO `freelancer_info` VALUES (6066, 6066, '陈碧天', '陈碧天', 'https://thirdwx.qlogo.cn/mmhead/Yr1LMYX6KTaOlic5qThibhniaX1T6hiciaLYsFhy1tIC8UQw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-18 20:55:40', '2020-10-18 20:55:40', 2000, 2000, 0, '2020-10-18 20:55:40.349');
INSERT INTO `freelancer_info` VALUES (6067, 6067, '品牌创新@李前承', '品牌创新@李前承', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er3dqNm0UyWrSLMnQumsBGVeK7uzI1lk3JiaLBqFPRXq7hIvSlK5IlBBlNCtTUAsU8QBeNatoaZwKA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18610441168', '2020-10-19 13:31:50', '2020-10-19 13:31:58', 2000, 6067, 0, '2020-10-19 13:31:57.853');
INSERT INTO `freelancer_info` VALUES (6068, 6068, '乔儿天堂', '乔儿天堂', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJlnvVBN1uUEbgSSTz3Vztk7k4Yj2lpicTFCSscVVxmTT1T3KZ4icUicfaX6qOJaqJ9SgHRp84Ohicnhg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18610846949', '2020-10-19 16:22:07', '2020-10-19 16:22:11', 2007, 6068, 0, '2020-10-19 16:22:11.371');
INSERT INTO `freelancer_info` VALUES (6069, 6069, '🍓🍓Candice🍫🍫', '🍓🍓Candice🍫🍫', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqjso4Rb5ckR7GnUmdhYiblicbjpguoEUGSmx3fliadvHtYnMC4IeTQlkIZ4m00ibtMzUOiaFKNmmxCQug/132', '', 10, 0, '', NULL, NULL, '', '', '', '15158001797', '2020-10-19 16:48:35', '2020-10-19 16:48:39', 2007, 6069, 0, '2020-10-19 16:48:38.530');
INSERT INTO `freelancer_info` VALUES (6070, 6070, 'CAIAMOON.', 'CAIAMOON.', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELAI2gF3cf0vEic33ewOkLxDJFZ3E4aE8scRvXOic0ibJWNiacg8GopJhYh2s3DAzAUALUdy4ccE3Biaew/132', '', 10, 0, '', NULL, NULL, '', '', '', '13312179561', '2020-10-19 17:22:05', '2020-10-19 17:22:07', 4000, 6070, 0, '2020-10-19 17:22:07.058');
INSERT INTO `freelancer_info` VALUES (6071, 6071, '何同学', '何同学', 'https://thirdwx.qlogo.cn/mmopen/vi_32/1hWoDcsZhfPHyZ4xt9XeFqPSwqX89oMwnVwNTF4nxJ9Qof1Nwt7OktfljwTiaUqDuzrd2BB6zYnugn8uef9sibWg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18848427790', '2020-10-19 21:31:02', '2020-10-19 21:31:06', 4000, 6071, 0, '2020-10-19 21:31:05.649');
INSERT INTO `freelancer_info` VALUES (6072, 6072, '刘育轩', '刘育轩', 'https://thirdwx.qlogo.cn/mmhead/T9CEia0v4OAyhxhrHxUzOkzBozsK8O4vGzcNciagUJF7w/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-20 06:58:02', '2020-10-20 06:58:02', 6051, 6051, 0, '2020-10-20 06:58:01.701');
INSERT INTO `freelancer_info` VALUES (6073, 6073, 'Forward', 'Forward', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJN4dfKu52ZJjkK7MQO1KZaUJfLOpr928Osvic2ibvPOplxaBZB6urZuwDPgNGLrsnflFtCBSxrJ4Mg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-20 09:30:38', '2020-10-20 09:30:38', 8082, 8082, 0, '2020-10-20 09:30:37.873');
INSERT INTO `freelancer_info` VALUES (6074, 6074, '梁东东', '梁东东', 'https://thirdwx.qlogo.cn/mmopen/vi_32/arTfyC2qkmC5icc1ld04oVkxjmbFzoTjTQSC5ncqxurD4u7zGvQgFCRk9jOSasXMweySNtWLdY6Zu3ImfDMkpLg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18758063850', '2020-10-20 09:33:58', '2020-10-20 09:34:02', 8082, 6074, 0, '2020-10-20 09:34:01.539');
INSERT INTO `freelancer_info` VALUES (6075, 6075, '七月WYJ', '七月WYJ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI2Pn31hdYEmaWck2GcMUVLLs4PfZTLZvD6BOKDs6Eia1NC7G4MF82OshChukDzICutpe7XeRiajCIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15801255241', '2020-10-20 10:21:48', '2020-10-20 10:21:52', 4000, 6075, 0, '2020-10-20 10:21:52.283');
INSERT INTO `freelancer_info` VALUES (6076, 6076, '窦恒山', '窦恒山', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PFjOr4mUMXNTPe94Jnd461neS96tUXD044EgzxwNk4cIX9WIgORuLYTFYYZlRIykw0qp6asGL7X0yZGyvpibEicg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13412133311', '2020-10-20 14:57:08', '2020-10-20 14:57:12', 8038, 6076, 0, '2020-10-20 14:57:12.289');
INSERT INTO `freelancer_info` VALUES (6077, 6077, '邓一些', '邓一些', 'https://thirdwx.qlogo.cn/mmopen/vi_32/V5Q9iapkWRXatRhcl0Sj2YjgBHhgV9vkpTOxxMKNamTIzUJ59xLyqtHCS7n83qfYyI2pOCfSO3dI8efQibDVI4oQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18200261273', '2020-10-20 19:43:53', '2020-10-20 19:43:56', 8057, 6077, 0, '2020-10-20 19:43:55.863');
INSERT INTO `freelancer_info` VALUES (6078, 6078, 'Li', 'Li', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eosBbjRJshvOAfWWqF1xIRUsJa8icbicD5wnXWMVEuI46uWL8dBWfUjsmnO367fKOOfmwu1HHQNE06Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '13152682260', '2020-10-21 12:54:12', '2020-10-21 12:54:16', 8088, 6078, 0, '2020-10-21 12:54:15.951');
INSERT INTO `freelancer_info` VALUES (6079, 6079, '静下来', '静下来', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvGAUEPO8BsJGvR1gd1kclib3IJOAusLzyvneIUSOtzUY6UqMiaXJ6CNJBOYHsm8MHpiaV7yvRY7eKA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13588198469', '2020-10-21 13:42:37', '2020-10-21 13:42:40', 6078, 6079, 0, '2020-10-21 13:42:40.394');
INSERT INTO `freelancer_info` VALUES (6080, 6080, 'ivy Han', 'ivy Han', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNbIV6xOa8ZFfuN9lyO54aMxEO0MIYib8TSndleJPOoqyS8HqFF0aC8bHo15rICCd8XQvhvflmiaibw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13911797317', '2020-10-21 16:54:09', '2020-10-21 16:54:13', 8071, 6080, 0, '2020-10-21 16:54:12.711');
INSERT INTO `freelancer_info` VALUES (6081, 6081, '方静', '方静', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKu71e4qLenziaoIqXov5U4ykVicpbWswH7UG4gicoLbuIGDqs3hXXt31L6o3kG8ib7KemzsXrXHGquEw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18511879025', '2020-10-21 17:36:48', '2020-10-21 17:36:53', 8071, 6081, 0, '2020-10-21 17:36:53.075');
INSERT INTO `freelancer_info` VALUES (6082, 6082, '王慧龙', '王慧龙', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLzozxBUdRvxq2tSic1Ea2UG9kmY9tadp2AtRw6SbFCNWhX6twLxUmbRKmiciah5R3CMS6UtojicOaBWw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18518889381', '2020-10-21 18:09:38', '2020-10-21 18:09:42', 2007, 6082, 0, '2020-10-21 18:09:42.481');
INSERT INTO `freelancer_info` VALUES (6083, 6083, '黄旭', '黄旭', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJHxkkgSjibsAZoaicYuuGibbPq6Ce8tVia1YMfMhtHVENFib03vfSLRWFOGYib0UF8YuL3c6mJrV3vgMHg/132', '', 10, 0, '', NULL, NULL, '', '', '', '15801054575', '2020-10-21 18:15:25', '2020-10-21 18:15:27', 6082, 6083, 0, '2020-10-21 18:15:27.466');
INSERT INTO `freelancer_info` VALUES (6084, 6084, '九日', '九日', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKn4kHQ8TTzaegUzHtEXvG2kcJTZu0rjVlqkWqo8bAaHb3bib4bVDnnJP9juibLS5G1zGOKneiaiaqz2A/132', '', 10, 0, '', NULL, NULL, '', '', '', '15545140725', '2020-10-21 18:17:51', '2020-10-21 18:17:54', 8092, 6084, 0, '2020-10-21 18:17:53.512');
INSERT INTO `freelancer_info` VALUES (6085, 6085, '莹冰瑾儿', '莹冰瑾儿', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epjqiaHW4b2vXBT9KZ0DWMOURleRo26R5ibj3icn9EsCaibe6akK2B9FkaITF4zh7fXNhiaIDqT8Z6qlpg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611488140', '2020-10-21 18:38:53', '2020-10-21 18:38:57', 6084, 6085, 0, '2020-10-21 18:38:56.864');
INSERT INTO `freelancer_info` VALUES (6086, 6086, '王振', '王振', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gIiarlMOiaFbboIjJ4hiahjoCcibKzpGPW5YK00Y8ibhxKicezm0RH97JXJoC69AYib9QrbqNxIOiaTVCHv0HtnSYaGnag/132', '', 10, 0, '', NULL, NULL, '', '', '', '17607092191', '2020-10-21 22:00:14', '2020-10-21 22:00:17', 4002, 6086, 0, '2020-10-21 22:00:17.154');
INSERT INTO `freelancer_info` VALUES (6087, 6087, 'Marlboro', 'Marlboro', 'https://thirdwx.qlogo.cn/mmopen/vi_32/M0TTYA7lvC2crMFYYscn0ovo3TuNAbVMLfiarDibKC0LicuebwqRia98n7H9g4YAJR2ktiaia8CAJZIsscbXsNy4aZ0w/132', '', 10, 0, '', NULL, NULL, '', '', '', '17710859219', '2020-10-21 22:44:08', '2020-10-21 22:44:13', 4000, 6087, 0, '2020-10-21 22:44:12.798');
INSERT INTO `freelancer_info` VALUES (6088, 6088, '晨', '晨', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJAFFqEfyLFBfpgmibEVGtnMqCttGHXe4e35AsSvN1z9427OORibIFRx9y5jmYYLOgia16MApEpmFWYA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15110035921', '2020-10-22 12:33:34', '2020-10-22 12:33:40', 8096, 6088, 0, '2020-10-22 12:33:39.875');
INSERT INTO `freelancer_info` VALUES (6089, 6089, '宋彬', '宋彬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqOy2ibz4SMIniaic7teEj5S3L2f6lmTJmWSI8sbUJn80HZC2iaXzUAJEWWdFggMVBHmibI87DicJz4icibTA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611408328', '2020-10-22 15:09:41', '2020-10-22 15:09:45', 8097, 6089, 0, '2020-10-22 15:09:45.176');
INSERT INTO `freelancer_info` VALUES (6090, 6090, '张天翼', '张天翼', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK4iawQfJ55JXAVnx1xRJVxMYrsjYlFG5ticpDdzrqyfiaIABODdGBHua5XqjMA43rtHbQibJibsVXZGoA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18618359599', '2020-10-22 17:13:03', '2020-10-22 17:13:06', 6089, 6090, 0, '2020-10-22 17:13:05.839');
INSERT INTO `freelancer_info` VALUES (6091, 6091, 'Samuel', 'Samuel', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJHhWv7puygLAeOC79G4GxjTQWdoibgZgc2NcdTKvUcMGXHFHzDEv60biaDAorIKI3ELWVWjaDnazg/132', '', 10, 0, '', NULL, NULL, '', '', '', '17610398193', '2020-10-22 17:17:51', '2020-10-22 17:17:53', 6090, 6091, 0, '2020-10-22 17:17:53.257');
INSERT INTO `freelancer_info` VALUES (6092, 6092, '曲玉杰', '曲玉杰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epM5Ka8Nmm1wOnr2MHU8hQ9icpykJGhjxGWslNS18qibc2oMxO3zRIwOU3kE00511FHq388HlglTvjw/132', '', 10, 0, '', NULL, NULL, '', '', '', '17790005266', '2020-10-22 19:14:40', '2020-10-22 19:14:42', 6051, 6092, 0, '2020-10-22 19:14:42.201');
INSERT INTO `freelancer_info` VALUES (6093, 6093, '王晶', '王晶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/sSj0tx5KicEUeWiar1hmtemxEoSl3ibW98MfOrwrGL1LrlhE43bW3M0ZIwuHbyapa0rKiciaiaQLPur6zbVribaZ9JWzA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15801573218', '2020-10-23 15:49:18', '2020-10-23 15:49:22', 4000, 6093, 0, '2020-10-23 15:49:21.886');
INSERT INTO `freelancer_info` VALUES (6094, 6094, 'Jan_keor', 'Jan_keor', 'https://thirdwx.qlogo.cn/mmopen/vi_32/3fRpE6VAWTPsH8yUh4YjbymfZHOHfgHqQI2Zyvec5U9yLZcHIW1ucd53JnaHzBjB7wicSa0jOxyY0wNrLU3Qu3A/132', '', 10, 0, '', NULL, NULL, '', '', '', '17339803665', '2020-10-25 21:45:18', '2020-10-25 21:45:21', 4000, 6094, 0, '2020-10-25 21:45:21.254');
INSERT INTO `freelancer_info` VALUES (6095, 6095, 'Aser Uni.  刘浩', 'Aser Uni.  刘浩', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epF5HjX9nJJg43UPKn9blG3fp9viaopDRfmzxic8Z7Mialiacx6u9Cj3D8YOiaQ5YKO0TgJYFvmZjJ9uZg/132', '', 10, 0, '', NULL, NULL, '', '', '', '15901210350', '2020-10-26 10:50:05', '2020-10-26 10:50:09', 6042, 6095, 0, '2020-10-26 10:50:08.829');
INSERT INTO `freelancer_info` VALUES (6096, 6096, '欢乐马', '欢乐马', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6k7ic5JOARZrh4wWV5lxC7xNALwudqib8h4CgLibHadhoO1yRh5UhONGsMBjTJIxxevQhwWSIlxhsZg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-26 11:28:07', '2020-10-26 11:28:07', 6095, 6095, 0, '2020-10-26 11:28:06.737');
INSERT INTO `freelancer_info` VALUES (6097, 6097, '小南🌀', '小南🌀', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8uiaErzMEKjGGaukYuOJQ1iauLkL3HhebdVzkjb3TY5Idgvfd0j9kfmzxmlCKLCn1cKt23XD37noQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '17891938143', '2020-10-26 12:53:35', '2020-10-26 12:53:38', 8106, 6097, 0, '2020-10-26 12:53:37.555');
INSERT INTO `freelancer_info` VALUES (6098, 6098, 'echo-做灵魂有香气的女人', 'echo-做灵魂有香气的女人', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK1AEBmld3BjASpC3A9lBKAC7KVTSdM77cxKXhJ6ddPX5uvtzIXicnYuVMzhQGgJ48NH4S65vcqP8w/132', '', 10, 0, '', NULL, NULL, '', '', '', '13911526263', '2020-10-27 13:17:20', '2020-10-27 13:17:23', 8105, 6098, 0, '2020-10-27 13:17:22.886');
INSERT INTO `freelancer_info` VALUES (8000, 8000, '海欧', '海欧', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELichXBRHPFJJjEBqtqeEcTsk0yOh1KkIibO3MY3ttZSdfpQfqlEPCICSLhJ9N2KsApe2y8pGJSQCLw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15910991142', '2020-10-15 08:47:35', '2020-10-15 08:47:38', 4005, 8000, 0, '2020-10-15 08:47:38.039');
INSERT INTO `freelancer_info` VALUES (8001, 8001, '海康', '海康', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM6pvv3THEQbUY98UojFWzk0AVYpRmr5Mia8o9vJNC9719RAicNpCMxGMIGt4brztlEaZiboQmVr3iaYng/132', '香港大学战略人力资源管理硕士，阿里集团组织发展项目经理。从20到800人组织发展和HR的实战者。对于能力素质模型，晋升标准，结构化面试，组织结构设计，不同阶段hr团队的搭建有些沉淀和实际经验。', 10, 0, '', NULL, NULL, '', '', '', '13957101219', '2020-10-15 10:52:32', '2020-10-15 11:09:10', 6004, 1, 0, '2020-10-15 11:09:09.900');
INSERT INTO `freelancer_info` VALUES (8002, 8002, '春雪', '春雪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzAlRUIpHn19hxzdibP91hV2GGfY79dGItfNlXqBibDV3pox2EZFZCtic8cA1XDhukAUfatSmkyM6icA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13810990272', '2020-10-15 11:00:04', '2020-10-15 11:00:08', 8001, 8002, 0, '2020-10-15 11:00:08.226');
INSERT INTO `freelancer_info` VALUES (8003, 8003, '职小氧', '职小氧', 'https://thirdwx.qlogo.cn/mmopen/vi_32/iblPs6icGX5tHiasTce2V19Hfg20FRU6iazghGSX5CDLlyqabdE8Qvlichdb46L3iafTXq7KAWCTuoURzU8eU4qQq4Sw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13241937740', '2020-10-15 11:46:31', '2020-10-15 11:46:44', 4023, 8003, 0, '2020-10-15 11:46:44.472');
INSERT INTO `freelancer_info` VALUES (8004, 8004, 'QwwwtQ.Garlic', 'QwwwtQ.Garlic', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIr5qh5IzgYOwicLP8O24g94vK3Yr79LUnZ98c88UVDIvU2BBUDdsUvUBXHaGpaKEkvZib7q6H8Q0Fw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15684235313', '2020-10-15 11:52:34', '2020-10-15 11:52:38', 2001, 8004, 0, '2020-10-15 11:52:37.735');
INSERT INTO `freelancer_info` VALUES (8005, 8005, 'Ashley', 'Ashley', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoqjHhMt0NJMMFibPuKafiaAcwA1IatbzOpGV7S8IPx2yWBIaKxyt7YFyKWv8JFcd4uLX3CBemVCLbA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18622048296', '2020-10-15 11:58:22', '2020-10-15 11:58:24', 4023, 8005, 0, '2020-10-15 11:58:23.758');
INSERT INTO `freelancer_info` VALUES (8006, 8006, 'Wei魏Xin欣', 'Wei魏Xin欣', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epPYGNLqbQqkXPHznghqmfKeicvR5xILxCfq2ZIbkSZwgWSWHNjaBEDrrac5r8uSqJoKiaSBkE6PvLg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13911096678', '2020-10-15 12:00:20', '2020-10-15 12:00:23', 6010, 8006, 0, '2020-10-15 12:00:23.288');
INSERT INTO `freelancer_info` VALUES (8007, 8007, 'XIBEI', 'XIBEI', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUBK2NThItVVXyUwBsAzMkldwRMkeJUzGF1BM6Lm1MxMTNdwTywzkCtbcEzqeNrTD1NDjD0222Vg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 12:02:37', '2020-10-15 12:02:37', 6012, 6012, 0, '2020-10-15 12:02:36.765');
INSERT INTO `freelancer_info` VALUES (8008, 8008, 'Sabrina 随心而动🌻🌻', 'Sabrina 随心而动🌻🌻', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFJTkiavo03epmkh6ye8S2lepl2WXmVjmmpwDUbq3TwiaLauyMUx56fYrjS3oVK313LiaudsLQIn7LQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18911867225', '2020-10-15 12:03:44', '2020-10-15 12:03:48', 8006, 8008, 0, '2020-10-15 12:03:47.617');
INSERT INTO `freelancer_info` VALUES (8009, 8009, 'max', 'max', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhox8vabohu5ia2TibQEMr6sd6XzN1Iia0k7uNYXOP9BZnzLPYE4g45SmdlN8ibDjLtzI2gJbKtdzS0A/132', '', 10, 0, '', NULL, NULL, '', '', '', '18660787032', '2020-10-15 12:04:46', '2020-10-15 12:05:09', 8008, 8009, 0, '2020-10-15 12:05:08.769');
INSERT INTO `freelancer_info` VALUES (8010, 8010, 'mikeliang', 'mikeliang', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep7hHnEjgzNXibWnN4OJhw1ZwncGjl7PVLDHAHmURbgxHRlLaXOH4UjBriawIVM0fbkAhgtqP23CDXw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 12:09:59', '2020-10-15 12:09:59', 6013, 6013, 0, '2020-10-15 12:09:58.771');
INSERT INTO `freelancer_info` VALUES (8011, 8011, '梅子·王', '梅子·王', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLxVbGPArsC7fibdRsgLWnn72tdGfkwMh4PgVuYrxLjJbIIhJHNcqtvuCxv9rEXVTT76KYhbjib4myA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13601171808', '2020-10-15 12:17:04', '2020-10-15 12:17:07', 2023, 8011, 0, '2020-10-15 12:17:07.377');
INSERT INTO `freelancer_info` VALUES (8012, 8012, 'Soymilk_伟伟', 'Soymilk_伟伟', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo0792qtdS7OdQkR4ETO7hd21yp2USVhq4ln20jUChS1F2XfhIUClBNhA3Q8rWe9Rzl4UZnsZ4p0Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '15011403503', '2020-10-15 12:46:36', '2020-10-15 12:46:39', 2016, 8012, 0, '2020-10-15 12:46:39.033');
INSERT INTO `freelancer_info` VALUES (8013, 8013, '四点木', '四点木', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epYxxeNAaAbJ6ibEDoI40BiaLM7Oq7nXh8AKvoV4N1besvfmzkHjow1zNiachMUbrp0Vibg9VDfSHOR3g/132', '', 10, 0, '', NULL, NULL, '', '', '', '17338132894', '2020-10-15 12:48:35', '2020-10-15 12:48:37', 8012, 8013, 0, '2020-10-15 12:48:37.488');
INSERT INTO `freelancer_info` VALUES (8014, 8014, '羊羊', '羊羊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqnstgIcP9rjEoqcJNRibqI39PIiaGz0MGkicN6jXBR2iaelmmTTeSXLTT1DJXBfV77EpIK4E3fZJZTXA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15810487960', '2020-10-15 12:51:27', '2020-10-15 12:51:29', 8013, 8014, 0, '2020-10-15 12:51:29.373');
INSERT INTO `freelancer_info` VALUES (8015, 8015, 'Xiaoluxin', 'Xiaoluxin', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoe2f5xCkDU6xsdu3bXtcDRiczy6NWwW9lDfxicIacSlNFMuUUtGEedVIOpdTdTibxfTE6zE1ibE3HXKg/132', '', 10, 0, '', NULL, NULL, '', '', '', '17600117292', '2020-10-15 12:53:01', '2020-10-15 12:53:06', 6019, 8015, 0, '2020-10-15 12:53:05.669');
INSERT INTO `freelancer_info` VALUES (8016, 8016, 'yuan', 'yuan', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erxFSbdeu9BzrcNX4ialX0nLwpu92yJ4EnObwVWEL7MriccKNlThqNktB6f2j3BGYic8Cts3wbsA0mcA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15110084810', '2020-10-15 13:02:03', '2020-10-15 13:02:06', 8015, 8016, 0, '2020-10-15 13:02:05.825');
INSERT INTO `freelancer_info` VALUES (8017, 8017, '陈雪芳-招募优秀合伙人', '陈雪芳-招募优秀合伙人', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKnshNur7anWHic367tLyhRWMklFxAF5nkjkfX9SGqA5rmxHYic7zwC92eqgGVcD66taka35QPsWkaQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18001276699', '2020-10-15 13:03:22', '2020-10-15 13:03:26', 8016, 8017, 0, '2020-10-15 13:03:25.968');
INSERT INTO `freelancer_info` VALUES (8018, 8018, '何艳Emma', '何艳Emma', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eokaqGurEhbEatAoaW90qDkDbSyY3GN7vvrBIicOa1yibu8DOhnsaBtHRoT1kmvjiaYtjkW1dbQzcdFg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13814898564', '2020-10-15 13:04:05', '2020-10-15 13:04:08', 8016, 8018, 0, '2020-10-15 13:04:07.668');
INSERT INTO `freelancer_info` VALUES (8019, 8019, '见清丶', '见清丶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Uh0jwI3gFfYPiaMyZlkMYfqxicZF6qDq7yWheZXd4TM5PSbCbNdOMBxLCkE2dcaVVxdMG1Od2rJ6vudsXxcVaFSw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13263113883', '2020-10-15 13:05:50', '2020-10-15 13:05:53', 6021, 8019, 0, '2020-10-15 13:05:53.186');
INSERT INTO `freelancer_info` VALUES (8020, 8020, 'lzm', 'lzm', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJUXwG4RBCSRnFRtUic9tBv6Z7pAKc8PRicKQbS52Ou23veGEqF5dhDwvoUugCGbAVW3rJsluQpkJlQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18600185840', '2020-10-15 13:13:10', '2020-10-15 13:13:14', 6021, 8020, 0, '2020-10-15 13:13:13.493');
INSERT INTO `freelancer_info` VALUES (8021, 8021, 'Molly', 'Molly', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq5tGdX9BaiaOqic8BScoUsvXIB1JxgJdIZn6kicMjuLhDObTz1USvZnvzPgciaEqCAko0IFJt3ibME3qA/132', '', 10, 0, '', NULL, NULL, '', '', '', '17717373289', '2020-10-15 13:14:00', '2020-10-15 13:14:07', 8017, 8021, 0, '2020-10-15 13:14:06.702');
INSERT INTO `freelancer_info` VALUES (8022, 8022, '小盆胡同26号', '小盆胡同26号', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzZ4X8pyxDBI5KSTZLoh1YuE9Lvqrel3b4WuiasUCjia9aq0lTx6wTodxiamWLDkzdrZprkicibic6RBNA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 13:14:36', '2020-10-15 13:14:36', 2000, 2000, 0, '2020-10-15 13:14:35.508');
INSERT INTO `freelancer_info` VALUES (8023, 8023, '尹東亮', '尹東亮', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er1PWO9LvHrCJ88iaQLiaiauSMGjBpXtgUSjIVJmnf0hmSUqVFDzxOFueNPGZ1PfJe6baKhnkBeXRr4Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '13953167399', '2020-10-15 13:18:53', '2020-10-15 13:18:59', 6014, 8023, 0, '2020-10-15 13:18:59.008');
INSERT INTO `freelancer_info` VALUES (8024, 8024, '逸少', '逸少', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKHS6mbJv3Cq81AnEh9UUNibeB1rAq0jwhRiaNIMQot3mhYvSK9sWNBqg6ib2BIJOS49cQ9c6t2pvusA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18911599015', '2020-10-15 13:21:58', '2020-10-15 13:22:02', 6022, 8024, 0, '2020-10-15 13:22:01.836');
INSERT INTO `freelancer_info` VALUES (8025, 8025, 'Rita 💅🏼', 'Rita 💅🏼', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqbfcFTFtXUTbb9wBOK2NHqjOLrgZE15GnKqU2M3audIOBQWia3vSvVlOJIZLj91REOH4CeF09Ds9w/132', '', 10, 0, '', NULL, NULL, '', '', '', '15101132569', '2020-10-15 13:23:20', '2020-10-15 13:23:25', 6022, 8025, 0, '2020-10-15 13:23:24.722');
INSERT INTO `freelancer_info` VALUES (8026, 8026, 'Jimmy', 'Jimmy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqOJicoW6pibhIibacZzasRb92YrVRhkxRxfSiaibMS3fpkD3ZllM8mXLNd98Uvib41WXoA3mjYsOxB1SIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 13:24:37', '2020-10-15 13:24:37', 6022, 6022, 0, '2020-10-15 13:24:37.340');
INSERT INTO `freelancer_info` VALUES (8027, 8027, '桑雷德', '桑雷德', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKvEAPIBicZTWRFhXsQM4DJ99CDRm9Ria1qOy5OS7AXY1VAPF7cRqJJibq00x5OLVrMrV5ul7yCJIc9g/132', '', 10, 0, '', NULL, NULL, '', '', '', '18614085713', '2020-10-15 13:25:55', '2020-10-15 13:25:57', 8025, 8027, 0, '2020-10-15 13:25:57.080');
INSERT INTO `freelancer_info` VALUES (8028, 8028, 'Klein', 'Klein', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erFX1iaOwOQNbVP1x4NBq4x9toic96MMk5tHh7iaRHChIuISyPKBfnrepUsiaGEWKNBljzj1HSHBDkkBA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18500202468', '2020-10-15 13:26:34', '2020-10-15 13:26:38', 8027, 8028, 0, '2020-10-15 13:26:38.274');
INSERT INTO `freelancer_info` VALUES (8029, 8029, '孙宇铃', '孙宇铃', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLCeW8CkSDSvM8fzUI4MLSh8ibR1vXxWf4hBmulI0shc7l77hEUYibqvHNdXaq9ibBuOIBIjmicFZicKiaibg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 13:38:01', '2020-10-15 13:38:01', 8017, 8017, 0, '2020-10-15 13:38:00.982');
INSERT INTO `freelancer_info` VALUES (8030, 8030, 'Peter Wang', 'Peter Wang', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq7Xn99rwicjibkaz05ibdYfvD9RvUgQLBl5FIZN53cd6RSUy3o0I8JNn3mQZFkLZmmTUR3tBQkZibSkA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13820979077', '2020-10-15 13:38:54', '2020-10-15 13:38:59', 8017, 8030, 0, '2020-10-15 13:38:58.525');
INSERT INTO `freelancer_info` VALUES (8031, 8031, 'cteen”', 'cteen”', 'https://thirdwx.qlogo.cn/mmopen/vi_32/9GfxzBVyich4eBXLcARcWc9fj9vib8h9TlwMbCP0tS1JeaoAsw1Jg3CV3Wl1GnibpKib4LgQ0XialO1rDcqia0oYLjQA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15889967907', '2020-10-15 13:46:37', '2020-10-15 13:46:40', 6032, 8031, 0, '2020-10-15 13:46:40.203');
INSERT INTO `freelancer_info` VALUES (8032, 8032, 'July', 'July', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq80Ns72njENQlGlXGicPibB25ZGOic8hSJ6DhvicNyh9N5zhJG4uOzDX61L7Ll2xWRNe2KvV5fJcHPrg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18210566605', '2020-10-15 13:53:56', '2020-10-15 13:53:58', 6033, 8032, 0, '2020-10-15 13:53:58.218');
INSERT INTO `freelancer_info` VALUES (8033, 8033, '岸芷汀兰', '岸芷汀兰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJXZOE1LAocibr1CetxMnyBP8vJlib1HCMBP4IKrpGSJou4luDteiaYqJNNSF3BJZQVTrkLKuj9yFD3w/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 14:04:58', '2020-10-15 14:04:58', 8017, 8017, 0, '2020-10-15 14:04:58.065');
INSERT INTO `freelancer_info` VALUES (8034, 8034, '刘德深', '刘德深', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKQxjfRMbm4Y2v6Cy2no7Tnria9TID9TTHTqlYvv5ryVjzkXSTuQpG3Qcrn7I3NEReH03rIAqT9Xng/132', '', 10, 0, '', NULL, NULL, '', '', '', '15618938725', '2020-10-15 14:10:31', '2020-10-15 14:10:45', 8030, 8034, 0, '2020-10-15 14:10:45.272');
INSERT INTO `freelancer_info` VALUES (8035, 8035, '胥博', '胥博', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIBYicns3ugAyibCsmHviaEicB9wvwiaIJc0fORuj4QT4xEXlvfOzOYlsfxTIkI6DjfzTV8OfLv17kN1pQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '17512588868', '2020-10-15 14:25:16', '2020-10-15 14:25:21', 8000, 8035, 0, '2020-10-15 14:25:20.493');
INSERT INTO `freelancer_info` VALUES (8036, 8036, 'skcl', 'skcl', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqA3Gz9ibbWwMRke1o8ObncFRkyr9hiaX5Gq1fQia5dNtH07Rdx9I5vLAll6IibicpdKpTge0ic3P7wrAIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '17625193410', '2020-10-15 14:31:55', '2020-10-15 14:31:57', 8017, 8036, 0, '2020-10-15 14:31:57.349');
INSERT INTO `freelancer_info` VALUES (8037, 8037, '蓝黎冲   ', '蓝黎冲   ', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJpdoetgNjXACibmgIWb9FXHTUgBpsOWwIPDz6IAh8uTjm0zMbhZT0PrgNQXxicubE8wbeAYkwIqr3A/132', '', 10, 0, '', NULL, NULL, '', '', '', '15122025218', '2020-10-15 14:33:56', '2020-10-15 14:34:01', 8003, 8037, 0, '2020-10-15 14:34:01.016');
INSERT INTO `freelancer_info` VALUES (8038, 8038, '-', '-', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzmBzIeVHkjkIIBYbxtzelTjdDpDobSDFcPmic0ibMs5OO37e1edPmyv7mnjDwCsBr8YTX87Go0WQw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13051150079', '2020-10-15 14:42:28', '2020-10-15 14:42:30', 8003, 8038, 0, '2020-10-15 14:42:30.420');
INSERT INTO `freelancer_info` VALUES (8039, 8039, '卡卡卓', '卡卡卓', 'https://thirdwx.qlogo.cn/mmopen/vi_32/fxrdfHVd8zbTmMdFibdqnoickXEUtXSkK1x1hx0C3bJHO2y3ArvVBg0CcTc9ErAJjygskn6Sk7exAEZEIMAIAScw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18049362492', '2020-10-15 14:58:53', '2020-10-15 14:58:56', 6039, 8039, 0, '2020-10-15 14:58:56.232');
INSERT INTO `freelancer_info` VALUES (8040, 8040, '三木', '三木', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL1nUufFmnUITbNzrfbyv0sSrN63Zes3c4NUDlZWmocEfs6UDKYhxwRicgSeVEO7WicfkkUW3Ep8DAA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13282829515', '2020-10-15 15:00:43', '2020-10-15 15:00:49', 8003, 8040, 0, '2020-10-15 15:00:48.624');
INSERT INTO `freelancer_info` VALUES (8041, 8041, 'NancyShi', 'NancyShi', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIXpbAttHr0F2oPEQKlKLY75aVxtkRZj8XBNrU7zYQrYalXhCqZSr1sLcIktibfagViaT5uicyZnQCsA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 15:05:11', '2020-10-15 15:05:11', 8040, 8040, 0, '2020-10-15 15:05:11.162');
INSERT INTO `freelancer_info` VALUES (8042, 8042, 'momo', 'momo', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLuu9YlJp7AuDuZsI9vsianu018GWehDHu7icaiboqPGziaTD4rKg0GEdfa2dmcEu6ficQiahphSxlmnjrA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 15:05:47', '2020-10-15 15:05:47', 8003, 8003, 0, '2020-10-15 15:05:47.298');
INSERT INTO `freelancer_info` VALUES (8043, 8043, '家犬', '家犬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJMrl3FOMUCXPicSPdqSlyViajLp9mmWydviaExnicXOE1ibIuoy6o8iaDhQnWJriaK5YZHDZgk68CHOTssQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '15021012515', '2020-10-15 15:40:35', '2020-10-15 15:40:38', 8038, 8043, 0, '2020-10-15 15:40:37.795');
INSERT INTO `freelancer_info` VALUES (8044, 8044, '安尼💗', '安尼💗', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epUJ5UkanJGyFgt30jUyoVgqFk3iag8mQwwX5mpakpcReKEpA8k0Y1b6jpXsT2KmGA0hCAoJgX8S7g/132', '', 10, 0, '', NULL, NULL, '', '', '', '13071188020', '2020-10-15 15:45:02', '2020-10-15 15:45:06', 6042, 8044, 0, '2020-10-15 15:45:06.372');
INSERT INTO `freelancer_info` VALUES (8045, 8045, 'Elly刘', 'Elly刘', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKoOicBeZibr7nM9lG1icKpTXgjaXOyiagj8A2BaIfQib9gF6QpZqT6vkkNqXWpBdENfK4fSiaylzRQdSlA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13701095136', '2020-10-15 15:47:18', '2020-10-15 15:47:25', 8044, 8045, 0, '2020-10-15 15:47:25.265');
INSERT INTO `freelancer_info` VALUES (8046, 8046, '薛小婷', '薛小婷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoxXuMyicEptPFia9W05uNI5YCJgS3ibYddMsINw6tjqSEdjJUkpc0ke5pxDF5iccjoDMfPOEziaWVCDWw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18610373336', '2020-10-15 16:55:43', '2020-10-15 16:55:46', 8003, 8046, 0, '2020-10-15 16:55:46.320');
INSERT INTO `freelancer_info` VALUES (8047, 8047, 'rufei.cn', 'rufei.cn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erf1o3QrluWmYBhxYsIbBZ8lTcJwNs3n2IbU3kKF5diaSHt8QUvuPJUnPpEz9Y5bjp5Lv2k9a7VKeg/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 17:14:22', '2020-10-15 17:14:22', 8046, 8046, 0, '2020-10-15 17:14:22.183');
INSERT INTO `freelancer_info` VALUES (8048, 8048, '晖晖', '晖晖', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIOP4klM32tWqbMAJunR9fVguwDiaDejric7CSwarmKM45vibzk5ceTgeicpiaaJVV2fgwMwiabdWjcGU6w/132', '', 10, 0, '', NULL, NULL, '', '', '', '15810251145', '2020-10-15 17:43:56', '2020-10-15 17:44:00', 4006, 8048, 0, '2020-10-15 17:44:00.061');
INSERT INTO `freelancer_info` VALUES (8049, 8049, 'Cindy', 'Cindy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/qqfZcibDJY3nia4l2CfpqzB10U1MxSScCFnZWVV4NH2TSptA5wI5pso8XwK3xQAUdnAiaJ3uOWP26cibPpL5hHkrEw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 18:06:58', '2020-10-15 18:06:58', 8048, 8048, 0, '2020-10-15 18:06:58.049');
INSERT INTO `freelancer_info` VALUES (8050, 8050, '耀君_百当@Yashi', '耀君_百当@Yashi', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqXtEWzCAic6AZW0BzaqNdQajeYwics6fl3DgYvevKhddXZS3xAQr01NPw8XT8r1YTmicgw9Rcib6z2TA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18668119280', '2020-10-15 18:20:15', '2020-10-15 18:20:19', 4006, 8050, 0, '2020-10-15 18:20:18.588');
INSERT INTO `freelancer_info` VALUES (8051, 8051, '李兆彬', '李兆彬', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKKVUz9m9NCz5WXgZPAPGEJYt3UmHqTstPwbbBDUjKJUCszvx4aCmibJsAz3GnBHQwDtQiaPdTR43zg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910974080', '2020-10-15 19:13:41', '2020-10-15 19:13:44', 2015, 8051, 0, '2020-10-15 19:13:44.290');
INSERT INTO `freelancer_info` VALUES (8052, 8052, '兴风踏浪', '兴风踏浪', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL9f2IRkfAb3wL4Np47JeAmS9jnZHMUJfKX28s1iaEibVia5alx6JWcIN71hOPNuLTThTMlVQhzC3ibwQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 19:47:45', '2020-10-15 19:47:45', 4000, 4000, 0, '2020-10-15 19:47:45.006');
INSERT INTO `freelancer_info` VALUES (8053, 8053, '林晓薇', '林晓薇', 'https://thirdwx.qlogo.cn/mmhead/fDUgH9bFtIT8LG5zXXiczfQf2Po4a2CqaDsCzM38jPAs/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 20:24:05', '2020-10-15 20:24:05', 4000, 4000, 0, '2020-10-15 20:24:04.634');
INSERT INTO `freelancer_info` VALUES (8054, 8054, 'Betty', 'Betty', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLbKp0Id2libic3tFXdjTTz3icpwP0EWq31o1Svnic5FeC4rtq4ybcGeDpEb4r6ibaPzTtEDuqMaHaNibLg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13522370887', '2020-10-15 21:51:51', '2020-10-15 21:53:07', 2023, 8054, 0, '2020-10-15 21:53:06.755');
INSERT INTO `freelancer_info` VALUES (8055, 8055, '马腾', '马腾', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIsCeMiaA1tbuxiaQ2fHibyxy4jwWxxl6LicuSxqqvYec05iaGsBt2Rx7gDXO5iaRZvURUFSxEkoIDFbzrg/132', '', 10, 0, '', NULL, NULL, '', '', '', '15501085058', '2020-10-15 22:24:40', '2020-10-15 22:24:44', 6047, 8055, 0, '2020-10-15 22:24:43.579');
INSERT INTO `freelancer_info` VALUES (8056, 8056, '叶宝珍', '叶宝珍', 'https://thirdwx.qlogo.cn/mmhead/dbmbvl7UYS8hcRelNJTkocl0MhM0LLmDlApB27KHLlw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-15 23:34:46', '2020-10-15 23:34:46', 2000, 2000, 0, '2020-10-15 23:34:45.710');
INSERT INTO `freelancer_info` VALUES (8057, 8057, 'xiaofan|Fruitage', 'xiaofan|Fruitage', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er3gf9mtgW90tjvacdgmq4efdKFheowhtBUKALyXIAw7pQ6gT0z0e61vfK09DwvyFxMkcSj2ZMP9w/132', '', 10, 0, '', NULL, NULL, '', '', '', '18510665571', '2020-10-16 09:23:27', '2020-10-16 09:23:30', 6051, 8057, 0, '2020-10-16 09:23:30.417');
INSERT INTO `freelancer_info` VALUES (8058, 8058, '暖暖🍃 诗里', '暖暖🍃 诗里', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep57xKEpeyFJPQJubNicEz4GSYmuBLwHjVeRdiak6k2oEVddMyU5rwf9BHP8JReLn58icovOmdzWdHng/132', '', 10, 0, '', NULL, NULL, '', '', '', '18658157611', '2020-10-16 10:30:19', '2020-10-16 10:30:22', 6053, 8058, 0, '2020-10-16 10:30:21.824');
INSERT INTO `freelancer_info` VALUES (8059, 8059, 'loverose', 'loverose', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q3auHgzwzM5fHibMuHpkOgUqTZBdbnccxaNsPJHIZlrJU1icvp7Gy5b0gB5z1WLRKZXRrnQpnaTknYfXFhicuzVJQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13516813035', '2020-10-16 10:38:54', '2020-10-16 10:39:05', 4002, 8059, 0, '2020-10-16 10:39:04.994');
INSERT INTO `freelancer_info` VALUES (8060, 8060, '高丽丽', '高丽丽', 'https://thirdwx.qlogo.cn/mmopen/vi_32/eH67YutzOic6cvq5Ql9gqGBO8ugmV3MK9KukLxCTx93wKiar8IPhP3Ia14RP51c5JEwKWpsbl08icJenoAPdKokXA/132', '', 10, 0, '', NULL, NULL, '', '', '', '15658117627', '2020-10-16 10:59:24', '2020-10-16 10:59:28', 8057, 8060, 0, '2020-10-16 10:59:27.565');
INSERT INTO `freelancer_info` VALUES (8061, 8061, '文强', '文强', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er49qI4ricscCcWN3w2BS2WusQdibqFh5CQkxRvOfA5AsQdOib2RCnZP40eYrM7RUUFXcEntbaGpppsQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '15067158859', '2020-10-16 11:03:22', '2020-10-16 11:03:25', 6054, 8061, 0, '2020-10-16 11:03:25.125');
INSERT INTO `freelancer_info` VALUES (8062, 8062, 'Anna', 'Anna', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTy7GKvduQo8MaRcqklJTTicIWgGdkQ3AJ0HbccbkQ95RdUnTYXwRia2q6mJp1E4wCmMQ0l7OhyQhw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18667132261', '2020-10-16 11:03:41', '2020-10-16 11:03:43', 8060, 8062, 0, '2020-10-16 11:03:43.186');
INSERT INTO `freelancer_info` VALUES (8063, 8063, '仲秋.晴', '仲秋.晴', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ0K4Ea95u4mTlKqicxCzG1opvx3saaC5yk8IicMIdC5QqAYmTMNbNQKgvtGTmMSxXO5bxpdePB3uIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13666698249', '2020-10-16 11:13:50', '2020-10-16 11:13:52', 8062, 8063, 0, '2020-10-16 11:13:52.255');
INSERT INTO `freelancer_info` VALUES (8064, 8064, 'Katy', 'Katy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eovY5YhcicuuhblibQQjrWjm89NkHH1ibDz5nl0SFIckVW9Uk0hBibPvoYDrHtqUd30kK6S9bvfJY5FAw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15906665740', '2020-10-16 12:00:50', '2020-10-16 12:00:53', 4002, 8064, 0, '2020-10-16 12:00:52.937');
INSERT INTO `freelancer_info` VALUES (8065, 8065, '咖啡师爷', '咖啡师爷', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKAAjrpSzJE6ToORaAVgIBUXXwEOViaZNzWtSwW8kMmVt6RZokSjTFbdlCSr19EzsDlicUVfy40RqlQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13758137221', '2020-10-16 13:02:56', '2020-10-16 13:02:59', 6057, 8065, 0, '2020-10-16 13:02:59.479');
INSERT INTO `freelancer_info` VALUES (8066, 8066, '忘', '忘', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJNf0qg9pM2cbyY6D9hk4CKrbicicsNIlKbia54Fd3ib8QIh9l8DRo0eylP5Dc5QO9P36yiamkBMvHCBog/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-16 13:54:03', '2020-10-16 13:54:03', 6057, 6057, 0, '2020-10-16 13:54:02.842');
INSERT INTO `freelancer_info` VALUES (8067, 8067, '不失本色', '不失本色', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8ZEzZjlpMk20G132dA99xlJ9KQN7dl6skyueSYYzpooxt7xDKKUpDWnuiaP2jsZBLW6QsjCGZ0Rg/132', '', 10, 0, '', NULL, NULL, '', '', '', '15625018926', '2020-10-16 19:17:36', '2020-10-16 19:46:17', 4000, 8067, 0, '2020-10-16 19:46:16.810');
INSERT INTO `freelancer_info` VALUES (8068, 8068, 'sky', 'sky', 'https://thirdwx.qlogo.cn/mmopen/vi_32/oVTZZspdwoHiavcodWkz5uQfPITSlmmLQiariapCcare8rNgAYkp67TNn6YLUUO4XaSLwHPIkS3Ymmicz4iaFr0Q3jA/132', '', 10, 0, '', NULL, NULL, '', '', '', '13602546400', '2020-10-16 21:38:17', '2020-10-16 21:38:23', 6007, 8068, 0, '2020-10-16 21:38:23.349');
INSERT INTO `freelancer_info` VALUES (8069, 8069, '秋天来了', '秋天来了', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJbSPetaEBiaofEElKNZjJskayUfNA5rqUTUnglKJAowclUonw0c7wvgvY4GLsFicQIPB7OXWIgcbxw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18101928491', '2020-10-16 21:40:36', '2020-10-16 21:40:47', 6007, 8069, 0, '2020-10-16 21:40:46.913');
INSERT INTO `freelancer_info` VALUES (8070, 8070, '就不告诉你', '就不告诉你', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8uiaErzMEKjMQQnuetiazbVUmR94o9m1I1AI88qib2kemHPA5RTr2bOicp6pECDBKqPnnxcRhNUhXpA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18210526775', '2020-10-16 22:00:51', '2020-10-16 22:00:54', 8069, 8070, 0, '2020-10-16 22:00:54.414');
INSERT INTO `freelancer_info` VALUES (8071, 8071, '卓', '卓', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqpKdSsjASicx09dfeEa6pZQUNsiaI7L97nlXaL8aHPMgPe4iaaWXkweibt1zMBWH0kFPU4YKxTwOBGGQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13911233734', '2020-10-16 22:48:00', '2020-10-16 22:48:05', 8070, 8071, 0, '2020-10-16 22:48:05.430');
INSERT INTO `freelancer_info` VALUES (8072, 8072, '林慧齐', '林慧齐', 'https://thirdwx.qlogo.cn/mmhead/8crE0icJmlhkyC1WJWqJ6ibuTxOpqUAABp3lRumxCq43U/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-17 10:26:37', '2020-10-17 10:26:37', 2000, 2000, 0, '2020-10-17 10:26:36.941');
INSERT INTO `freelancer_info` VALUES (8073, 8073, '张可依', '张可依', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epHNkyMkOeLa9s3W2wGBjlMvuBqbJb3hZl7YGSgkRjdqMxq2qSafbDLlGGj2NIsvBJRibCFEIDJWRA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18482050775', '2020-10-17 17:24:05', '2020-10-17 17:24:07', 6062, 8073, 0, '2020-10-17 17:24:07.275');
INSERT INTO `freelancer_info` VALUES (8074, 8074, '许志霖', '许志霖', 'https://thirdwx.qlogo.cn/mmhead/DX1nQyXf4GTjCHopwWkMMuAfUwnW0fIPj15IxcHxPA8/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-18 02:21:42', '2020-10-18 02:21:42', 2000, 2000, 0, '2020-10-18 02:21:42.345');
INSERT INTO `freelancer_info` VALUES (8075, 8075, '刘垚功', '刘垚功', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJqUkoCXOxRrZ2CyE7BEad4ye3hIV7Yic6JBoFqQOsSQlAXeibribgoLI6Zabib3d6gdNje8ibb08Juq7Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '18611945229', '2020-10-18 06:36:19', '2020-10-18 06:36:28', 2000, 8075, 0, '2020-10-18 06:36:27.583');
INSERT INTO `freelancer_info` VALUES (8076, 8076, '曦瑶', '曦瑶', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIfI4IVbPPia8x3azUNCF5PDC4VGp8xSvxzKj96SgdlIyLhYL0RWuAibFS6bAlCf8oLjJ75fU2Ja7IQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13910714819', '2020-10-18 14:15:46', '2020-10-18 14:15:52', 2007, 8076, 0, '2020-10-18 14:15:51.826');
INSERT INTO `freelancer_info` VALUES (8077, 8077, '兰  丫头', '兰  丫头', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIBYricK9KtTZgO2BC5zQpzfttlnERy2we2ibszxuE5DGsQPibZDRNiaooJIWPlllIO6xgdcL6Myrq41w/132', '', 10, 0, '', NULL, NULL, '', '', '', '13718868375', '2020-10-19 09:38:48', '2020-10-19 09:38:51', 4002, 8077, 0, '2020-10-19 09:38:51.431');
INSERT INTO `freelancer_info` VALUES (8078, 8078, '劉Jian', '劉Jian', 'https://thirdwx.qlogo.cn/mmopen/vi_32/gebz9R2KoicIzP4766zib19bMgajWDHeWibu1jf9AxrukdWsucbibwj2MKia2s1yVlhPKoibR2BQrSa5pIic6XS9NjO6w/132', '', 10, 0, '', NULL, NULL, '', '', '', '18801209353', '2020-10-19 13:38:45', '2020-10-19 13:38:48', 2000, 8078, 0, '2020-10-19 13:38:47.790');
INSERT INTO `freelancer_info` VALUES (8079, 8079, '郭雨桦', '郭雨桦', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJKzUzFEcDaicRib9o1Wt1a4NCPAM0pmWEycPoK0RMrzsUslAibsZzCpbgibOUCQp5ClO6MH1rUIO0xAw/132', '15年人力资源招聘、心理咨询专家，擅长招聘和人才梯队搭建、职业规划、心理员工辅导', 10, 0, '', '110000', '110100', '110108', '', '', '13126717896', '2020-10-19 15:43:38', '2020-10-23 17:16:48', 2007, 1, 0, '2020-10-23 17:16:47.590');
INSERT INTO `freelancer_info` VALUES (8080, 8080, 'Ivy', 'Ivy', 'https://thirdwx.qlogo.cn/mmopen/vi_32/J6QAFH0QPCfX28nicQ2SD8yAPWbugGic0lbBicZN9NBWxR8OIW6mbHGthXypibJmB1UzDqlD8TahJeibme4icAHibIqjA/132', '', 10, 0, '', NULL, NULL, '', '', '', '17002200088', '2020-10-19 18:54:20', '2020-10-19 18:54:25', 4000, 8080, 0, '2020-10-19 18:54:25.002');
INSERT INTO `freelancer_info` VALUES (8081, 8081, '张帆', '张帆', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eokmgMic76YFnAf37tMrC0fFwM8Yd8194sjvXiadxf7hAibOibjT4QsNtOPDxr33A7bHMcZdyN1sIs2uQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13466765575', '2020-10-19 22:41:35', '2020-10-19 22:41:40', 6071, 8081, 0, '2020-10-19 22:41:40.404');
INSERT INTO `freelancer_info` VALUES (8082, 8082, '敏娟', '敏娟', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLGhUVNkpWcgDwFliaSczKLHxSBGbSV4KpTSUTbNrD6oHoP8x6Vu3zIJwKMX2l9MWDG0mI4yPYVxicw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15201277758', '2020-10-20 07:30:46', '2020-10-20 07:30:49', 2020, 8082, 0, '2020-10-20 07:30:49.324');
INSERT INTO `freelancer_info` VALUES (8083, 8083, 'Samson', 'Samson', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erZ8svwT73clDzuBYzS58HFcIJ0N9gPFA1llraSO5avVm90JaSuqonM8AsBKib5Le2CNGTF0AumS9Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-20 09:45:41', '2020-10-20 09:45:41', 6074, 6074, 0, '2020-10-20 09:45:40.849');
INSERT INTO `freelancer_info` VALUES (8084, 8084, '周全', '周全', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8QkD9V6I7OoHWpp8Y4b0ckfPafEdmer68CqwJRzeib8Kh3hsE58hJbJ7LZNAGZsP3P0lrN2lx52w/132', '', 10, 0, '', NULL, NULL, '', '', '', '18910357327', '2020-10-20 13:20:45', '2020-10-20 13:20:56', 8040, 8084, 0, '2020-10-20 13:20:56.071');
INSERT INTO `freelancer_info` VALUES (8085, 8085, '安东旭', '安东旭', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKaNtEXTK3uj7BicC3u55vJSGgQRUWT1lpRKAKfnth5G1qL8frDhibUda8K7WhW3LCgJWWUkIdkBjaA/132', '', 10, 0, '', NULL, NULL, '', '', '', '17326097257', '2020-10-20 21:22:18', '2020-10-20 21:22:21', 8045, 8085, 0, '2020-10-20 21:22:21.029');
INSERT INTO `freelancer_info` VALUES (8086, 8086, '张艺林 John', '张艺林 John', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erEicuJv8W5CbictzHZicJ6ECUSpdoLlTYB3Z2jMwTqZ2RTTZCrnGMv95rAmiaibMFcpZIxQzj3O2n26WQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18817313655', '2020-10-20 21:22:18', '2020-10-20 21:22:22', 6077, 8086, 0, '2020-10-20 21:22:21.736');
INSERT INTO `freelancer_info` VALUES (8087, 8087, '席蕴俊', '席蕴俊', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhx0aNiaBpicV1icXhwR9sF8GPiab94DQvfwYB9OiaclRYStk19nNCtCUXyC1HMFUaCOCDibHt0xrg3Q7w/132', '', 10, 0, '', NULL, NULL, '', '', '', '13567110082', '2020-10-21 10:00:40', '2020-10-21 10:00:43', 8085, 8087, 0, '2020-10-21 10:00:43.457');
INSERT INTO `freelancer_info` VALUES (8088, 8088, '王小超@联服企业服务', '王小超@联服企业服务', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epOJBffbo5iaafW1gLvPmkbAUC1qzmJ8tynFP3Y7LRfAsyq1ZKPDRpSXoPqHd90x2GODEZs1oXo6hw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18817805554', '2020-10-21 10:22:04', '2020-10-21 10:22:07', 6077, 8088, 0, '2020-10-21 10:22:06.741');
INSERT INTO `freelancer_info` VALUES (8089, 8089, 'Bonnie', 'Bonnie', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erRZlDy8IJugtLDIjGeN961WPS4yh5a79LOib0PC0e0qQbg9cKkZAKAcFEwrGmPOVPiamtDau9vRqibg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18911071331', '2020-10-21 15:38:18', '2020-10-21 15:38:22', 8071, 8089, 0, '2020-10-21 15:38:22.442');
INSERT INTO `freelancer_info` VALUES (8090, 8090, '思羽  Money💰', '思羽  Money💰', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJo2ZvT9XJPiaHaOdfjO7mfc4ymCAgTXGvoF6TWA7XgFRnaT5AqtyJP3H9nQ8E1Un6cuEGkib5Ejwrw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18667005608', '2020-10-21 15:42:49', '2020-10-21 15:42:53', 8089, 8090, 0, '2020-10-21 15:42:52.948');
INSERT INTO `freelancer_info` VALUES (8091, 8091, 'Tank', 'Tank', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqQSgXianTD2fdvyIKvWXiaeyJVuzvMXwPwR8nmH9BuVvacibFV8SESLU8dKjzMK3KphIYGF1WPmQjhw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18658856332', '2020-10-21 15:43:29', '2020-10-21 15:43:32', 8089, 8091, 0, '2020-10-21 15:43:31.883');
INSERT INTO `freelancer_info` VALUES (8092, 8092, '夏天', '夏天', 'https://thirdwx.qlogo.cn/mmopen/vi_32/SKiageS2YRyAlS7dHicyU4xicmJvTGd3m5Y1JpYSDibq9JDtn5zWpROXjc0SnJqIJ1STNiboXHM4m6KmmBIjIQFZQJw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18614288369', '2020-10-21 18:12:15', '2020-10-21 18:12:20', 6082, 8092, 0, '2020-10-21 18:12:20.120');
INSERT INTO `freelancer_info` VALUES (8093, 8093, '钢哥', '钢哥', 'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKEZvcMHzj4iaW6kkPNEGCTLicCO5zUyblMialyeMoFZktZfIrGRejLuoibqwuXdRyoE5y6ggpqfibD2VQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '13911569777', '2020-10-21 19:01:34', '2020-10-21 19:01:40', 6084, 8093, 0, '2020-10-21 19:01:40.132');
INSERT INTO `freelancer_info` VALUES (8094, 8094, '无双上将潘凤', '无双上将潘凤', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqicpcicjzYhjFXjHFiczxuNTmmicEfKmdvcZ4lVuvHn8YfWtlZiaEib5sMQzaia9xHCtPkAVglzXZ1iab1rQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-21 19:45:43', '2020-10-21 19:45:43', 4000, 4000, 0, '2020-10-21 19:45:43.458');
INSERT INTO `freelancer_info` VALUES (8095, 8095, '韩励智', '韩励智', 'https://thirdwx.qlogo.cn/mmopen/vi_32/ia9w3tFtngQJP6g58sRf2K40PmE0Jnoa2jVW4ICntaIvnl54xL7a74Z7fibe2f8Za5ibIYuJ7smfx6nQzFiaia79TJQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18204614870', '2020-10-22 11:14:36', '2020-10-22 11:14:39', 6084, 8095, 0, '2020-10-22 11:14:39.336');
INSERT INTO `freelancer_info` VALUES (8096, 8096, '周红飞 Jason Chou', '周红飞 Jason Chou', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqVHJF6iaPUDw2ibQeXjbK9PaL8yroAUlK8uJ0gNmrnoDXLvjZXSx04wkibvEdh35XTJBBVBHmWdbnIw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15895970859', '2020-10-22 12:08:12', '2020-10-22 12:08:16', 4000, 8096, 0, '2020-10-22 12:08:16.463');
INSERT INTO `freelancer_info` VALUES (8097, 8097, 'zmhui', 'zmhui', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLegwOzRJibSSvnrhkfmpPhXVwKCmicGUzxAreV1zGpLauZ3htBZWiaQ4FTQur186ExCeJc55DVFZWCw/132', '', 10, 0, '', NULL, NULL, '', '', '', '13121453800', '2020-10-22 14:29:33', '2020-10-22 14:29:36', 6088, 8097, 0, '2020-10-22 14:29:35.840');
INSERT INTO `freelancer_info` VALUES (8098, 8098, '张德强', '张德强', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKmyUF0MWNDUdFPh6QmGG8xWVsRFkjPPAa5g7icHl9WQHUqNkpWFrtSujZgKh0hUmia8da5FB9bVq3Q/132', '', 10, 0, '', NULL, NULL, '', '', '', '15110286849', '2020-10-22 14:53:17', '2020-10-22 14:53:20', 8097, 8098, 0, '2020-10-22 14:53:19.602');
INSERT INTO `freelancer_info` VALUES (8099, 8099, 'Kiki Aria Inn', 'Kiki Aria Inn', 'https://thirdwx.qlogo.cn/mmopen/vi_32/7MicosKnZk61p7b9Yps5y9NJPwSpsYCuknt3cQHI54vM2q65Lic46v9CcQG20PAT2oJacFIvicaMI9rRh7CdA0MJg/132', '', 10, 0, '', NULL, NULL, '', '', '', '13389880871', '2020-10-22 19:18:07', '2020-10-22 19:18:15', 6092, 8099, 0, '2020-10-22 19:18:15.000');
INSERT INTO `freelancer_info` VALUES (8100, 8100, 'A', 'A', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLqwGJIXBdice0kc2lhKCtKKbjialg2Qrmf0fusnysFS65yfSmibibzEaibDrn4L81xGFZibDLIV7Djic7Fw/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-22 19:30:35', '2020-10-22 19:30:35', 8099, 8099, 0, '2020-10-22 19:30:35.149');
INSERT INTO `freelancer_info` VALUES (8101, 8101, '宗鑫-华致酒行-人力资源部', '宗鑫-华致酒行-人力资源部', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIgJCQBU8fXJpsQRDFZYQh0CZHEQhiapYBwbvBjdnfTGz5fBNT8XHJibF774oou63AgNHMn2KibVsnBg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18713342498', '2020-10-22 22:17:06', '2020-10-22 22:17:09', 6051, 8101, 0, '2020-10-22 22:17:09.424');
INSERT INTO `freelancer_info` VALUES (8102, 8102, '付剑南', '付剑南', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK5HdmFFmNiafTkVjVdGAtmjGia7P9SuLa6E1jibicJxibSrgdKYiab1C89xJ2DA8kYIlAibBGlozTn3Tlmw/132', '', 10, 0, '', NULL, NULL, '', '', '', '15801376059', '2020-10-23 03:08:16', '2020-10-23 03:08:20', 2007, 8102, 0, '2020-10-23 03:08:20.140');
INSERT INTO `freelancer_info` VALUES (8103, 8103, 'Silent', 'Silent', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJfUqEKHvN0oJibSiaA4ne6axXQA10icHibp6kMoIR2JyOGo3WUZNhmdw7NDuLSfia4YYT0kNJNzJbyflQ/132', '', 10, 0, '', NULL, NULL, '', '', '', '18221388671', '2020-10-23 14:01:13', '2020-10-23 14:01:18', 2007, 8103, 0, '2020-10-23 14:01:18.444');
INSERT INTO `freelancer_info` VALUES (8104, 8104, '苏碧绮', '苏碧绮', 'https://thirdwx.qlogo.cn/mmhead/oz6ooeIZaHUUgXkppow7ftEMicvu9SbiaWbx9HwYXBtrA/132', '', 10, 0, '', NULL, NULL, '', '', '', '', '2020-10-23 15:06:39', '2020-10-23 15:06:39', 8103, 8103, 0, '2020-10-23 15:06:38.884');
INSERT INTO `freelancer_info` VALUES (8105, 8105, '可能', '可能', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLqeib8OfVoRA2DNiarT4bHCVQN5xZOc0kGTr2fFh0fLo4guuStO3ibt3u3yzL6vml7ACErNoty1VcgA/132', '', 10, 0, '', NULL, NULL, '', '', '', '18406459159', '2020-10-23 17:07:43', '2020-10-23 17:07:47', 4000, 8105, 0, '2020-10-23 17:07:46.948');
INSERT INTO `freelancer_info` VALUES (8106, 8106, '庾航 Hank', '庾航 Hank', 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoU2SG2ynSzkJMDdnbDHHNqjQCmic8cKHAObmsP0kvx9J6PxyvSOsXjl2ltVib991WDpM7BbLI11sibw/132', '', 10, 0, '', NULL, NULL, '', '', '', '18627566868', '2020-10-26 11:52:32', '2020-10-26 11:52:38', 6095, 8106, 0, '2020-10-26 11:52:37.689');
INSERT INTO `freelancer_info` VALUES (8107, 8107, '余钟~猎头老余18702536239', '余钟~猎头老余18702536239', 'https://thirdwx.qlogo.cn/mmopen/vi_32/d8mqJsPOcAkZLm65ahulHUq5AuUTgiaMlOwVia0ibkCUD9ZQTs07d8e6Zb1jt08pTyy6uOawnXFiaodrxricDRU82sg/132', '', 10, 0, '', NULL, NULL, '', '', '', '18702536239', '2020-10-26 16:28:10', '2020-10-26 16:28:13', -1, 8107, 0, '2020-10-26 16:28:13.480');
COMMIT;

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
BEGIN;
INSERT INTO `leaf_alloc` VALUES ('attachment_info', 24000, 2000, NULL, '2020-10-23 17:04:57');
INSERT INTO `leaf_alloc` VALUES ('bd_job_cate', 22000, 2000, NULL, '2020-10-23 09:47:46');
INSERT INTO `leaf_alloc` VALUES ('bd_job_skill', 12000, 2000, NULL, '2020-10-18 22:05:36');
INSERT INTO `leaf_alloc` VALUES ('bd_job_tag', 2000, 2000, NULL, '2020-10-11 10:28:30');
INSERT INTO `leaf_alloc` VALUES ('demand_info', 10000, 2000, NULL, '2020-10-15 01:26:48');
INSERT INTO `leaf_alloc` VALUES ('demand_production_relation', 10000, 2000, NULL, '2020-10-23 13:12:21');
INSERT INTO `leaf_alloc` VALUES ('display_config', 16000, 2000, NULL, '2020-10-21 20:22:36');
INSERT INTO `leaf_alloc` VALUES ('employer_info', 10000, 2000, NULL, '2020-10-15 08:47:35');
INSERT INTO `leaf_alloc` VALUES ('evaluation_info', 4000, 2000, NULL, '2020-10-14 17:21:26');
INSERT INTO `leaf_alloc` VALUES ('evaluation_info_tag', 2000, 2000, NULL, '2020-10-11 10:28:30');
INSERT INTO `leaf_alloc` VALUES ('freelancer_info', 10000, 2000, NULL, '2020-10-15 08:47:35');
INSERT INTO `leaf_alloc` VALUES ('leaf-segment-test', 1, 2000, 'Test leaf Segment Mode Get Id', '2020-10-11 10:28:30');
INSERT INTO `leaf_alloc` VALUES ('order_follow', 10000, 2000, NULL, '2020-10-15 11:21:43');
INSERT INTO `leaf_alloc` VALUES ('order_info', 10000, 2000, NULL, '2020-10-15 11:21:43');
INSERT INTO `leaf_alloc` VALUES ('order_info_detail', 10000, 2000, NULL, '2020-10-15 11:21:43');
INSERT INTO `leaf_alloc` VALUES ('order_operate_info', 8000, 2000, NULL, '2020-10-22 22:36:44');
INSERT INTO `leaf_alloc` VALUES ('production_info', 24000, 2000, NULL, '2020-10-23 17:16:13');
INSERT INTO `leaf_alloc` VALUES ('production_review_info', 16000, 2000, NULL, '2020-10-21 20:26:55');
INSERT INTO `leaf_alloc` VALUES ('production_skill_relation', 20000, 2000, NULL, '2020-10-18 14:28:31');
INSERT INTO `leaf_alloc` VALUES ('sys_base_dict', 2000, 2000, NULL, '2020-10-11 10:28:30');
INSERT INTO `leaf_alloc` VALUES ('sys_user', 10000, 2000, NULL, '2020-10-15 08:47:35');
COMMIT;

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
  `operate_user` bigint(20) NOT NULL,
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8020 DEFAULT CHARSET=utf8 COMMENT='订单流水';

-- ----------------------------
-- Records of order_follow
-- ----------------------------
BEGIN;
INSERT INTO `order_follow` VALUES (2000, 2000, 20, NULL, '2020-10-14 17:14:24', '2020-10-14 17:14:24', 4000, 4001, 4001, 0, '2020-10-14 17:14:23.841');
INSERT INTO `order_follow` VALUES (2001, NULL, 20, NULL, '2020-10-14 17:14:24', '2020-10-14 17:14:24', 4001, 4001, 4001, 0, '2020-10-14 17:14:23.865');
INSERT INTO `order_follow` VALUES (2002, 2000, 40, NULL, '2020-10-14 17:19:27', '2020-10-14 17:19:27', 4000, 4000, 4000, 0, '2020-10-14 17:19:27.172');
INSERT INTO `order_follow` VALUES (2003, 2000, 60, NULL, '2020-10-14 17:21:01', '2020-10-14 17:21:01', 4000, 4000, 4000, 0, '2020-10-14 17:21:00.972');
INSERT INTO `order_follow` VALUES (2004, 2000, 80, NULL, '2020-10-14 17:21:13', '2020-10-14 17:21:13', 4001, 4001, 4001, 0, '2020-10-14 17:21:13.307');
INSERT INTO `order_follow` VALUES (2005, 2001, 20, NULL, '2020-10-14 17:24:34', '2020-10-14 17:24:34', 4001, 4000, 4000, 0, '2020-10-14 17:24:33.997');
INSERT INTO `order_follow` VALUES (2006, NULL, 20, NULL, '2020-10-14 17:24:34', '2020-10-14 17:24:34', 4000, 4000, 4000, 0, '2020-10-14 17:24:34.001');
INSERT INTO `order_follow` VALUES (2007, 2001, 40, NULL, '2020-10-14 17:24:44', '2020-10-14 17:24:44', 4001, 4001, 4001, 0, '2020-10-14 17:24:44.063');
INSERT INTO `order_follow` VALUES (2008, 2001, 60, NULL, '2020-10-14 17:25:09', '2020-10-14 17:25:09', 4001, 4001, 4001, 0, '2020-10-14 17:25:09.407');
INSERT INTO `order_follow` VALUES (2009, 2001, 61, NULL, '2020-10-14 17:25:42', '2020-10-14 17:25:42', 4001, 4001, 4001, 0, '2020-10-14 17:25:42.080');
INSERT INTO `order_follow` VALUES (2010, 4000, 30, NULL, '2020-10-14 20:14:39', '2020-10-14 20:14:39', 2013, 2013, 2013, 0, '2020-10-14 20:14:39.256');
INSERT INTO `order_follow` VALUES (2011, 2002, 20, NULL, '2020-10-14 22:15:30', '2020-10-14 22:15:30', 4000, 4023, 4023, 0, '2020-10-14 22:15:29.951');
INSERT INTO `order_follow` VALUES (4000, 2001, 70, NULL, '2020-10-14 17:25:25', '2020-10-14 17:25:25', 4000, 4000, 4000, 0, '2020-10-14 17:25:25.043');
INSERT INTO `order_follow` VALUES (4001, 2001, 80, NULL, '2020-10-14 17:26:07', '2020-10-14 17:26:07', 4000, 4000, 4000, 0, '2020-10-14 17:26:07.469');
INSERT INTO `order_follow` VALUES (4002, 4000, 20, NULL, '2020-10-14 20:14:25', '2020-10-14 20:14:25', 2006, 2013, 2013, 0, '2020-10-14 20:14:24.991');
INSERT INTO `order_follow` VALUES (4003, NULL, 20, NULL, '2020-10-14 20:14:25', '2020-10-14 20:14:25', 2013, 2013, 2013, 0, '2020-10-14 20:14:24.998');
INSERT INTO `order_follow` VALUES (4004, 4001, 20, NULL, '2020-10-14 22:15:26', '2020-10-14 22:15:26', 4000, 4023, 4023, 0, '2020-10-14 22:15:25.802');
INSERT INTO `order_follow` VALUES (6000, 6000, 20, NULL, '2020-10-15 01:18:37', '2020-10-15 01:18:37', 2006, 2000, 2000, 0, '2020-10-15 01:18:36.930');
INSERT INTO `order_follow` VALUES (6001, NULL, 20, NULL, '2020-10-15 01:18:37', '2020-10-15 01:18:37', 2000, 2000, 2000, 0, '2020-10-15 01:18:36.953');
INSERT INTO `order_follow` VALUES (6002, 6001, 20, NULL, '2020-10-15 01:21:01', '2020-10-15 01:21:01', 4026, 2023, 2023, 0, '2020-10-15 01:21:01.179');
INSERT INTO `order_follow` VALUES (6003, NULL, 20, NULL, '2020-10-15 01:21:01', '2020-10-15 01:21:01', 2023, 2023, 2023, 0, '2020-10-15 01:21:01.184');
INSERT INTO `order_follow` VALUES (6004, 6001, 30, NULL, '2020-10-15 08:01:02', '2020-10-15 08:01:02', 2023, 2023, 2023, 0, '2020-10-15 08:01:02.099');
INSERT INTO `order_follow` VALUES (6005, 6002, 20, NULL, '2020-10-15 11:12:58', '2020-10-15 11:12:58', 6001, 2007, 2007, 0, '2020-10-15 11:12:57.859');
INSERT INTO `order_follow` VALUES (6006, NULL, 20, NULL, '2020-10-15 11:12:58', '2020-10-15 11:12:58', 2007, 2007, 2007, 0, '2020-10-15 11:12:57.865');
INSERT INTO `order_follow` VALUES (6007, 8000, 40, NULL, '2020-10-15 11:26:25', '2020-10-15 11:26:25', 6001, 6001, 6001, 0, '2020-10-15 11:26:25.275');
INSERT INTO `order_follow` VALUES (6008, 6002, 40, NULL, '2020-10-15 11:26:32', '2020-10-15 11:26:32', 6001, 6001, 6001, 0, '2020-10-15 11:26:32.179');
INSERT INTO `order_follow` VALUES (6009, 6003, 20, NULL, '2020-10-15 12:50:51', '2020-10-15 12:50:51', 4000, 8012, 8012, 0, '2020-10-15 12:50:50.611');
INSERT INTO `order_follow` VALUES (6010, 6004, 20, NULL, '2020-10-15 12:51:22', '2020-10-15 12:51:22', 4000, 8012, 8012, 0, '2020-10-15 12:51:21.905');
INSERT INTO `order_follow` VALUES (6011, 6005, 20, NULL, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 4000, 8012, 8012, 0, '2020-10-15 12:51:55.715');
INSERT INTO `order_follow` VALUES (6012, 6006, 20, NULL, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 4000, 8012, 8012, 0, '2020-10-15 12:51:56.077');
INSERT INTO `order_follow` VALUES (6013, 6007, 20, NULL, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 4000, 8012, 8012, 0, '2020-10-15 12:51:56.393');
INSERT INTO `order_follow` VALUES (6014, 6008, 20, NULL, '2020-10-15 12:52:08', '2020-10-15 12:52:08', 4000, 8012, 8012, 0, '2020-10-15 12:52:07.568');
INSERT INTO `order_follow` VALUES (6015, NULL, 20, NULL, '2020-10-15 12:52:08', '2020-10-15 12:52:08', 8012, 8012, 8012, 0, '2020-10-15 12:52:07.571');
INSERT INTO `order_follow` VALUES (6016, 6009, 20, NULL, '2020-10-15 16:07:38', '2020-10-15 16:07:38', 4026, 8003, 8003, 0, '2020-10-15 16:07:38.297');
INSERT INTO `order_follow` VALUES (6017, NULL, 20, NULL, '2020-10-15 16:07:38', '2020-10-15 16:07:38', 8003, 8003, 8003, 0, '2020-10-15 16:07:38.301');
INSERT INTO `order_follow` VALUES (6018, 6010, 20, NULL, '2020-10-15 21:32:59', '2020-10-15 21:32:59', 2006, 2023, 2023, 0, '2020-10-15 21:32:58.892');
INSERT INTO `order_follow` VALUES (6019, NULL, 20, NULL, '2020-10-15 21:32:59', '2020-10-15 21:32:59', 2023, 2023, 2023, 0, '2020-10-15 21:32:58.895');
INSERT INTO `order_follow` VALUES (6020, 8006, 30, NULL, '2020-10-16 21:44:04', '2020-10-16 21:44:04', 8069, 8069, 8069, 0, '2020-10-16 21:44:04.245');
INSERT INTO `order_follow` VALUES (6021, 6011, 20, NULL, '2020-10-16 21:45:31', '2020-10-16 21:45:31', 4026, 8069, 8069, 0, '2020-10-16 21:45:30.502');
INSERT INTO `order_follow` VALUES (6022, NULL, 20, NULL, '2020-10-16 21:45:31', '2020-10-16 21:45:31', 8069, 8069, 8069, 0, '2020-10-16 21:45:30.506');
INSERT INTO `order_follow` VALUES (6023, 6011, 30, NULL, '2020-10-16 21:45:51', '2020-10-16 21:45:51', 8069, 8069, 8069, 0, '2020-10-16 21:45:51.484');
INSERT INTO `order_follow` VALUES (6024, 6012, 20, NULL, '2020-10-17 01:10:04', '2020-10-17 01:10:04', 6001, 2007, 2007, 0, '2020-10-17 01:10:03.909');
INSERT INTO `order_follow` VALUES (6025, NULL, 20, NULL, '2020-10-17 01:10:04', '2020-10-17 01:10:04', 2007, 2007, 2007, 0, '2020-10-17 01:10:03.913');
INSERT INTO `order_follow` VALUES (6026, 6013, 20, NULL, '2020-10-22 19:53:11', '2020-10-22 19:53:11', 8099, 6051, 6051, 0, '2020-10-22 19:53:10.857');
INSERT INTO `order_follow` VALUES (6027, NULL, 20, NULL, '2020-10-22 19:53:11', '2020-10-22 19:53:11', 6051, 6051, 6051, 0, '2020-10-22 19:53:10.861');
INSERT INTO `order_follow` VALUES (6028, 6013, 40, NULL, '2020-10-22 19:54:14', '2020-10-22 19:54:14', 8099, 8099, 8099, 0, '2020-10-22 19:54:13.631');
INSERT INTO `order_follow` VALUES (6029, 6014, 20, NULL, '2020-10-23 17:08:01', '2020-10-23 17:08:01', 8099, 4002, 4002, 0, '2020-10-23 17:08:00.618');
INSERT INTO `order_follow` VALUES (6030, NULL, 20, NULL, '2020-10-23 17:08:01', '2020-10-23 17:08:01', 4002, 4002, 4002, 0, '2020-10-23 17:08:00.621');
INSERT INTO `order_follow` VALUES (8000, 8000, 20, NULL, '2020-10-15 11:21:43', '2020-10-15 11:21:43', 6001, 2007, 2007, 0, '2020-10-15 11:21:43.226');
INSERT INTO `order_follow` VALUES (8001, NULL, 20, NULL, '2020-10-15 11:21:43', '2020-10-15 11:21:43', 2007, 2007, 2007, 0, '2020-10-15 11:21:43.239');
INSERT INTO `order_follow` VALUES (8002, 8001, 20, NULL, '2020-10-15 12:51:06', '2020-10-15 12:51:06', 4000, 8012, 8012, 0, '2020-10-15 12:51:05.800');
INSERT INTO `order_follow` VALUES (8003, 8002, 20, NULL, '2020-10-15 12:51:55', '2020-10-15 12:51:55', 4000, 8012, 8012, 0, '2020-10-15 12:51:54.652');
INSERT INTO `order_follow` VALUES (8004, 8003, 20, NULL, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 4000, 8012, 8012, 0, '2020-10-15 12:51:55.907');
INSERT INTO `order_follow` VALUES (8005, 8004, 20, NULL, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 4000, 8012, 8012, 0, '2020-10-15 12:51:56.233');
INSERT INTO `order_follow` VALUES (8006, 8005, 20, NULL, '2020-10-15 12:52:03', '2020-10-15 12:52:03', 4000, 8012, 8012, 0, '2020-10-15 12:52:02.725');
INSERT INTO `order_follow` VALUES (8007, 6009, 30, NULL, '2020-10-15 16:08:05', '2020-10-15 16:08:05', 8003, 8003, 8003, 0, '2020-10-15 16:08:04.740');
INSERT INTO `order_follow` VALUES (8008, 6008, 40, NULL, '2020-10-15 20:25:40', '2020-10-15 20:25:40', 4000, 4000, 4000, 0, '2020-10-15 20:25:40.061');
INSERT INTO `order_follow` VALUES (8009, 6010, 30, NULL, '2020-10-15 21:33:10', '2020-10-15 21:33:10', 2023, 2023, 2023, 0, '2020-10-15 21:33:09.704');
INSERT INTO `order_follow` VALUES (8010, 8006, 20, NULL, '2020-10-16 21:43:31', '2020-10-16 21:43:31', 2004, 8069, 8069, 0, '2020-10-16 21:43:31.325');
INSERT INTO `order_follow` VALUES (8011, NULL, 20, NULL, '2020-10-16 21:43:31', '2020-10-16 21:43:31', 8069, 8069, 8069, 0, '2020-10-16 21:43:31.329');
INSERT INTO `order_follow` VALUES (8012, 6012, 40, NULL, '2020-10-17 13:43:06', '2020-10-17 13:43:06', 6001, 6001, 6001, 0, '2020-10-17 13:43:06.239');
INSERT INTO `order_follow` VALUES (8013, 8007, 20, NULL, '2020-10-20 07:31:55', '2020-10-20 07:31:55', 2009, 8082, 8082, 0, '2020-10-20 07:31:54.902');
INSERT INTO `order_follow` VALUES (8014, NULL, 20, NULL, '2020-10-20 07:31:55', '2020-10-20 07:31:55', 8082, 8082, 8082, 0, '2020-10-20 07:31:54.906');
INSERT INTO `order_follow` VALUES (8015, 8008, 20, NULL, '2020-10-22 19:39:58', '2020-10-22 19:39:58', 2007, 6051, 6051, 0, '2020-10-22 19:39:58.306');
INSERT INTO `order_follow` VALUES (8016, NULL, 20, NULL, '2020-10-22 19:39:58', '2020-10-22 19:39:58', 6051, 6051, 6051, 0, '2020-10-22 19:39:58.310');
INSERT INTO `order_follow` VALUES (8017, 8008, 40, NULL, '2020-10-22 20:37:01', '2020-10-22 20:37:01', 2007, 2007, 2007, 0, '2020-10-22 20:37:01.069');
INSERT INTO `order_follow` VALUES (8018, 8008, 60, NULL, '2020-10-22 22:36:44', '2020-10-22 22:36:44', 2007, 2007, 2007, 0, '2020-10-22 22:36:44.443');
INSERT INTO `order_follow` VALUES (8019, 8008, 80, NULL, '2020-10-23 16:20:40', '2020-10-23 16:20:40', 6051, 6051, 6051, 0, '2020-10-23 16:20:39.595');
COMMIT;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `code` varchar(32) NOT NULL COMMENT '订单编码',
  `job_cate_id` bigint(20) NOT NULL COMMENT '需求类型',
  `cate_tree_code` varchar(256) NOT NULL COMMENT '需求类型',
  `status` tinyint(4) NOT NULL COMMENT '订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）',
  `order_mny` decimal(20,8) NOT NULL DEFAULT '0.00000000' COMMENT '订单金额',
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
) ENGINE=InnoDB AUTO_INCREMENT=8009 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES (2000, '20101417DDSKR3UTT', 6006, '20101416LK8256SP5', 90, 1000.00000000, 500.00000000, 2, '2020-10-16 00:00:00', NULL, NULL, NULL, 4000, 4001, '2020-10-14 17:14:24', '2020-10-14 17:21:26', 4001, 4001, 0, '2020-10-14 17:21:26.381');
INSERT INTO `order_info` VALUES (2001, '20101417BASDEVZ2Y', 8003, '201014162GH479BPL', 90, 150.00000000, 50.00000000, 3, '2020-10-15 00:00:00', NULL, NULL, NULL, 4001, 4000, '2020-10-14 17:24:34', '2020-10-14 17:26:20', 4000, 4000, 0, '2020-10-14 17:26:19.775');
INSERT INTO `order_info` VALUES (2002, '20101422BQZMV8G68', 8005, '20101416BFWRLETTM', 20, 1500.00000000, 500.00000000, 3, '2020-10-21 00:00:00', NULL, NULL, NULL, 4000, 4023, '2020-10-14 22:15:30', '2020-10-14 22:15:30', 4023, 4023, 0, '2020-10-14 22:15:29.946');
INSERT INTO `order_info` VALUES (4000, '20101420MLFVLYGQ5', 6006, '20101416LK8256SP5', 30, 400.00000000, 400.00000000, 1, '2020-10-14 00:00:00', NULL, NULL, NULL, 2006, 2013, '2020-10-14 20:14:25', '2020-10-14 20:14:39', 2013, 2013, 0, '2020-10-14 20:14:39.241');
INSERT INTO `order_info` VALUES (4001, '20101422GUHGWFCHR', 8005, '20101416BFWRLETTM', 20, 1500.00000000, 500.00000000, 3, '2020-10-21 00:00:00', NULL, NULL, NULL, 4000, 4023, '2020-10-14 22:15:26', '2020-10-14 22:15:26', 4023, 4023, 0, '2020-10-14 22:15:25.798');
INSERT INTO `order_info` VALUES (6000, '20101501HW2USJMSL', 6006, '20101416LK8256SP5', 20, 400.00000000, 400.00000000, 1, '2023-12-15 00:00:00', NULL, NULL, NULL, 2006, 2000, '2020-10-15 01:18:37', '2020-10-15 01:18:37', 2000, 2000, 0, '2020-10-15 01:18:36.897');
INSERT INTO `order_info` VALUES (6001, '201015012EBBHANS5', 8002, '20101416FXF34XL4A', 30, 500.00000000, 500.00000000, 1, '2020-10-17 00:00:00', NULL, NULL, NULL, 4026, 2023, '2020-10-15 01:21:01', '2020-10-15 08:01:02', 2023, 2023, 0, '2020-10-15 08:01:02.090');
INSERT INTO `order_info` VALUES (6002, '20101511KXEWC53S9', 6011, '20101417FTC6GTHYF', 40, 500.00000000, 500.00000000, 1, '2020-10-20 00:00:00', NULL, NULL, NULL, 6001, 2007, '2020-10-15 11:12:58', '2020-10-15 11:26:32', 2007, 6001, 0, '2020-10-15 11:26:32.159');
INSERT INTO `order_info` VALUES (6003, '20101512LJQT9PPPD', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:50:51', '2020-10-15 12:50:51', 8012, 8012, 0, '2020-10-15 12:50:50.607');
INSERT INTO `order_info` VALUES (6004, '201015122E96J27NS', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:22', '2020-10-15 12:51:22', 8012, 8012, 0, '2020-10-15 12:51:21.900');
INSERT INTO `order_info` VALUES (6005, '20101512LAWDVGMSL', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 8012, 8012, 0, '2020-10-15 12:51:55.711');
INSERT INTO `order_info` VALUES (6006, '20101512M3NAWWTQL', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 8012, 8012, 0, '2020-10-15 12:51:56.073');
INSERT INTO `order_info` VALUES (6007, '20101512HJAWPY8KY', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 8012, 8012, 0, '2020-10-15 12:51:56.389');
INSERT INTO `order_info` VALUES (6008, '20101512NA67HD888', 8005, '20101416BFWRLETTM', 40, 1000.00000000, 500.00000000, 2, '2020-10-16 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:52:08', '2020-10-15 20:25:40', 8012, 4000, 0, '2020-10-15 20:25:40.041');
INSERT INTO `order_info` VALUES (6009, '201015162JA25584W', 8002, '20101416FXF34XL4A', 30, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4026, 8003, '2020-10-15 16:07:38', '2020-10-15 16:08:05', 8003, 8003, 0, '2020-10-15 16:08:04.728');
INSERT INTO `order_info` VALUES (6010, '20101521LS72K76K2', 6006, '20101416LK8256SP5', 30, 400.00000000, 400.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 2006, 2023, '2020-10-15 21:32:59', '2020-10-15 21:33:10', 2023, 2023, 0, '2020-10-15 21:33:09.713');
INSERT INTO `order_info` VALUES (6011, '20101621F87ZPN2R9', 8002, '20101416FXF34XL4A', 30, 500.00000000, 500.00000000, 1, '2020-10-16 00:00:00', NULL, NULL, NULL, 4026, 8069, '2020-10-16 21:45:30', '2020-10-16 21:45:51', 8069, 8069, 0, '2020-10-16 21:45:51.486');
INSERT INTO `order_info` VALUES (6012, '20101701BVPDR2FXU', 6011, '20101417FTC6GTHYF', 40, 500.00000000, 500.00000000, 1, '2020-10-17 00:00:00', NULL, NULL, NULL, 6001, 2007, '2020-10-17 01:10:04', '2020-10-17 13:43:06', 2007, 6001, 0, '2020-10-17 13:43:06.243');
INSERT INTO `order_info` VALUES (6013, '20102219BWTPNYA5G', 6008, '20101416ABGPCU5KC', 50, 1000.00000000, 100.00000000, 10, '2020-10-31 00:00:00', NULL, NULL, NULL, 8099, 6051, '2020-10-22 19:53:11', '2020-10-22 19:57:30', 6051, 1, 0, '2020-10-22 19:57:30.049');
INSERT INTO `order_info` VALUES (6014, '20102317KZURHETBH', 6008, '20101416ABGPCU5KC', 20, 100.00000000, 100.00000000, 1, '2020-10-23 00:00:00', NULL, NULL, NULL, 8099, 4002, '2020-10-23 17:08:01', '2020-10-23 17:08:01', 4002, 4002, 0, '2020-10-23 17:08:00.615');
INSERT INTO `order_info` VALUES (8000, '20101511GJFDDPZ78', 6011, '20101417FTC6GTHYF', 40, 500.00000000, 500.00000000, 1, '2020-10-16 00:00:00', NULL, NULL, NULL, 6001, 2007, '2020-10-15 11:21:43', '2020-10-15 11:26:25', 2007, 6001, 0, '2020-10-15 11:26:25.255');
INSERT INTO `order_info` VALUES (8001, '2010151225PKABGMZ', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:06', '2020-10-15 12:51:06', 8012, 8012, 0, '2020-10-15 12:51:05.796');
INSERT INTO `order_info` VALUES (8002, '20101512NR5YYHXY3', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:55', '2020-10-15 12:51:55', 8012, 8012, 0, '2020-10-15 12:51:54.649');
INSERT INTO `order_info` VALUES (8003, '20101512GD55CTRHR', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 8012, 8012, 0, '2020-10-15 12:51:55.903');
INSERT INTO `order_info` VALUES (8004, '20101512AX5ZPHSW7', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-15 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:51:56', '2020-10-15 12:51:56', 8012, 8012, 0, '2020-10-15 12:51:56.229');
INSERT INTO `order_info` VALUES (8005, '20101512M4MDLJADB', 8005, '20101416BFWRLETTM', 20, 500.00000000, 500.00000000, 1, '2020-10-16 00:00:00', NULL, NULL, NULL, 4000, 8012, '2020-10-15 12:52:03', '2020-10-15 12:52:03', 8012, 8012, 0, '2020-10-15 12:52:02.719');
INSERT INTO `order_info` VALUES (8006, '20101621BVX3SNRHR', 6006, '20101416LK8256SP5', 30, 630.00000000, 90.00000000, 7, '2020-10-16 00:00:00', NULL, NULL, NULL, 2004, 8069, '2020-10-16 21:43:31', '2020-10-16 21:44:04', 8069, 8069, 0, '2020-10-16 21:44:04.248');
INSERT INTO `order_info` VALUES (8007, '20102007C96DMZ3S9', 8007, '201014163Y7MN5KY7', 20, 600.00000000, 300.00000000, 2, '2020-10-20 00:00:00', NULL, NULL, NULL, 2009, 8082, '2020-10-20 07:31:55', '2020-10-20 07:31:55', 8082, 8082, 0, '2020-10-20 07:31:54.898');
INSERT INTO `order_info` VALUES (8008, '20102219DWVBF4MSL', 8003, '201014162GH479BPL', 80, 2000.00000000, 500.00000000, 4, '2020-10-31 00:00:00', NULL, NULL, NULL, 2007, 6051, '2020-10-22 19:39:58', '2020-10-23 16:20:40', 6051, 6051, 0, '2020-10-23 16:20:39.576');
COMMIT;

-- ----------------------------
-- Table structure for order_info_detail
-- ----------------------------
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

-- ----------------------------
-- Records of order_info_detail
-- ----------------------------
BEGIN;
INSERT INTO `order_info_detail` VALUES (2000, 2000, '110000', '110100', '110101', NULL, '测试购买', '购买', '2020-10-14 17:14:24', '2020-10-14 17:14:24', 4001, 4001, 0, '2020-10-14 17:14:23.860');
INSERT INTO `order_info_detail` VALUES (2001, 2001, '110000', '110100', '110101', NULL, '来吧', '来吧', '2020-10-14 17:24:34', '2020-10-14 17:24:34', 4000, 4000, 0, '2020-10-14 17:24:34.000');
INSERT INTO `order_info_detail` VALUES (4000, 4000, '110000', '110100', '110101', NULL, '1', '是', '2020-10-14 20:14:25', '2020-10-14 20:14:25', 2013, 2013, 0, '2020-10-14 20:14:24.996');
INSERT INTO `order_info_detail` VALUES (6000, 6000, '110000', '110100', '110106', NULL, '图', '祝你今天愉快，你明天的愉快留着我明天再祝 —— 王小波', '2020-10-15 01:18:37', '2020-10-15 01:18:37', 2000, 2000, 0, '2020-10-15 01:18:36.947');
INSERT INTO `order_info_detail` VALUES (6001, 6001, '110000', '110100', '110102', NULL, '购买服务', '购买服务', '2020-10-15 01:21:01', '2020-10-15 01:21:01', 2023, 2023, 0, '2020-10-15 01:21:01.181');
INSERT INTO `order_info_detail` VALUES (6002, 6002, '110000', '110100', '110105', NULL, '我需要视频', '1.企业拍摄2.网红打造', '2020-10-15 11:12:58', '2020-10-15 11:12:58', 2007, 2007, 0, '2020-10-15 11:12:57.863');
INSERT INTO `order_info_detail` VALUES (6008, 6008, '110000', '110100', '110101', NULL, 'UI海报设计', '订单费用如何计算？需求文案描述不够，如何进一步详细沟通？', '2020-10-15 12:52:08', '2020-10-15 12:52:08', 8012, 8012, 0, '2020-10-15 12:52:07.569');
INSERT INTO `order_info_detail` VALUES (6009, 6009, '110000', '110100', '110101', NULL, '农药房', '哦哦哦具体', '2020-10-15 16:07:38', '2020-10-15 16:07:38', 8003, 8003, 0, '2020-10-15 16:07:38.299');
INSERT INTO `order_info_detail` VALUES (6010, 6010, '110000', '110100', '110101', NULL, '111', '    ', '2020-10-15 21:32:59', '2020-10-15 21:32:59', 2023, 2023, 0, '2020-10-15 21:32:58.894');
INSERT INTO `order_info_detail` VALUES (6011, 6011, '110000', '110100', '110101', NULL, '咨询', '咨询', '2020-10-16 21:45:31', '2020-10-16 21:45:31', 8069, 8069, 0, '2020-10-16 21:45:30.504');
INSERT INTO `order_info_detail` VALUES (6012, 6012, '110000', '110100', '110101', NULL, '需要拍摄', '1.实现拍摄', '2020-10-17 01:10:04', '2020-10-17 01:10:04', 2007, 2007, 0, '2020-10-17 01:10:03.911');
INSERT INTO `order_info_detail` VALUES (6013, 6013, '110000', '110100', '110105', NULL, '找一个会做新媒体运营的大学生', '小程序上线需要大学生协助', '2020-10-22 19:53:11', '2020-10-22 19:53:11', 6051, 6051, 0, '2020-10-22 19:53:10.860');
INSERT INTO `order_info_detail` VALUES (6014, 6014, '110000', '110100', '110101', NULL, '购买一个运营服务', '需要一个运营', '2020-10-23 17:08:01', '2020-10-23 17:08:01', 4002, 4002, 0, '2020-10-23 17:08:00.620');
INSERT INTO `order_info_detail` VALUES (8000, 8000, '110000', '110100', '110105', NULL, '视频拍摄', '1.视频需求', '2020-10-15 11:21:43', '2020-10-15 11:21:43', 2007, 2007, 0, '2020-10-15 11:21:43.237');
INSERT INTO `order_info_detail` VALUES (8006, 8006, NULL, NULL, NULL, NULL, '设计小程序', '小程序', '2020-10-16 21:43:31', '2020-10-16 21:43:31', 8069, 8069, 0, '2020-10-16 21:43:31.327');
INSERT INTO `order_info_detail` VALUES (8007, 8007, '110000', '110100', '110105', NULL, '需要剪辑短视频', '剪辑卡点短视频', '2020-10-20 07:31:55', '2020-10-20 07:31:55', 8082, 8082, 0, '2020-10-20 07:31:54.904');
INSERT INTO `order_info_detail` VALUES (8008, 8008, NULL, NULL, NULL, NULL, '购买4小时专业服务', '项目启动辛苦费', '2020-10-22 19:39:58', '2020-10-22 19:39:58', 6051, 6051, 0, '2020-10-22 19:39:58.308');
COMMIT;

-- ----------------------------
-- Table structure for order_operate_info
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=6002 DEFAULT CHARSET=utf8mb4 COMMENT='岗位技能表';

-- ----------------------------
-- Records of order_operate_info
-- ----------------------------
BEGIN;
INSERT INTO `order_operate_info` VALUES (2000, 2000, 10, 4000, 4000, '测试', '2020-10-14 17:21:01', '2020-10-14 17:21:01', 4000, 4000, 0, '2020-10-14 17:21:00.978');
INSERT INTO `order_operate_info` VALUES (2001, 2000, 20, 4001, 4001, '', '2020-10-14 17:21:13', '2020-10-14 17:21:13', 4001, 4001, 0, '2020-10-14 17:21:13.310');
INSERT INTO `order_operate_info` VALUES (2002, 2001, 10, 4001, 4001, '看看', '2020-10-14 17:25:09', '2020-10-14 17:25:09', 4001, 4001, 0, '2020-10-14 17:25:09.410');
INSERT INTO `order_operate_info` VALUES (2003, 2001, 11, 4001, 4001, '再来', '2020-10-14 17:25:42', '2020-10-14 17:25:42', 4001, 4001, 0, '2020-10-14 17:25:42.083');
INSERT INTO `order_operate_info` VALUES (4000, 2001, 30, 4000, 4000, '不过', '2020-10-14 17:25:25', '2020-10-14 17:25:25', 4000, 4000, 0, '2020-10-14 17:25:25.052');
INSERT INTO `order_operate_info` VALUES (4001, 2001, 20, 4000, 4000, '', '2020-10-14 17:26:07', '2020-10-14 17:26:07', 4000, 4000, 0, '2020-10-14 17:26:07.472');
INSERT INTO `order_operate_info` VALUES (6000, 8008, 10, 2007, 2007, '已完成项目上线。', '2020-10-22 22:36:44', '2020-10-22 22:36:44', 2007, 2007, 0, '2020-10-22 22:36:44.449');
INSERT INTO `order_operate_info` VALUES (6001, 8008, 20, 6051, 6051, '', '2020-10-23 16:20:40', '2020-10-23 16:20:40', 6051, 6051, 0, '2020-10-23 16:20:39.596');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=22001 DEFAULT CHARSET=utf8 COMMENT='作品表';

-- ----------------------------
-- Records of production_info
-- ----------------------------
BEGIN;
INSERT INTO `production_info` VALUES (2000, '20101416E258ULR9T', 8001, '为你提供嵌入式人力资源服务', 'DDI卡片分析法；通过数据库能力快速构建各岗位素质模型；结构化面试、晋升标准；三板斧、共创会等团队共创建设', 1000.00, 40, 8003, '', 1, 0, '2020-10-14 16:44:01', '2020-10-15 11:09:59', 1, 1, 0, '2020-10-15 11:09:58.910');
INSERT INTO `production_info` VALUES (2001, '20101416A7V5W5DJC', 4026, '明星资源经纪和品牌专业打造者', '15年互联网品牌公关学习和实践经验，拥有专业系统的品牌建设打造手法和经验 。个人微博8万+粉丝，拥有大量明星资源，可提供明星代言，短期商业授权，明星合作等。（在一手明星报价基础上，根据难易程度收取佣金5—8%）；文笔出众，独立出书和杂志上百本。个人微博8万+粉丝，微信公众号和视频号均有一定影响力。（文稿费:纯原创2000元/1000字；修改类1500元/1000字)', 500.00, 40, 8002, '', 1, 0, '2020-10-14 16:46:22', '2020-10-23 10:01:12', 1, 1, 0, '2020-10-23 10:01:12.451');
INSERT INTO `production_info` VALUES (2002, '20101416H8LCQZR9T', 2004, ' 波球买手App设计2', '我是一名UI设计师个视觉设计师平面设计师，擅长LOGO设计，UI界面设计，VIS视觉识别设计。我有着丰富的UI设计经验，截止目前我有四款上线app，还有一款待上线，WEB端以及OA更是不计其数，目前我的目标是转战产品，应该不管设计对象是什么，都得从用户的角度思维出发，了解了用户群体才能真正的做好设计。', 90.00, 40, 6006, '', 1, 0, '2020-10-14 16:48:05', '2020-10-19 14:56:15', 1, 1, 0, '2020-10-19 14:56:15.039');
INSERT INTO `production_info` VALUES (2003, '20101416KNQD6GTBH', 2011, '组织变革和敏捷团队教练', '擅长人力资源战略，企业组织变革，文创文旅IP建设。拥有世界500强企业高管经验，认证高级人力资源管理师，高级物流管理师，心理咨询师，组织变革与敏捷团队教练，本科和研究生专业战略与人力资源管理，北京大学在职学习金融学。服务过汉能、吉利汽车、现代汽车等众多企业的招聘测评、沟通培训等项目。', 800.00, 40, 8003, '', 1, 0, '2020-10-14 16:50:21', '2020-10-19 14:57:34', 1, 1, 0, '2020-10-19 14:57:34.090');
INSERT INTO `production_info` VALUES (2004, '20101416NXHDY6FXU', 2005, '中国前200名全球认证PCC专业级教练', '组织层面：战略梳理、组织变革、领导力提升、团队凝聚、人才发展；个人层面：成长突破、情绪管理、与他人关系、人生脚本', 2500.00, 40, 12000, '', 1, 0, '2020-10-14 16:51:49', '2020-10-14 20:02:50', 1, 1, 0, '2020-10-14 20:02:49.870');
INSERT INTO `production_info` VALUES (2005, '20101416GSM4J38S5', 4004, '高客单价电商综合运营', '90后团队，擅长挖掘客户需求、提炼卖点、打造单品爆款、用户生态圈的打造（抖音、群）', 100.00, 40, 6007, '', 1, 0, '2020-10-14 16:54:59', '2020-10-14 19:24:14', 1, 1, 0, '2020-10-14 19:24:14.078');
INSERT INTO `production_info` VALUES (2006, '20101416BSTZNNTMK', 2002, '新加坡区块链交易所全线产品体验设计', '我一直在创造用户需求性、商业延续性、科技可行性的最佳融合。擅长标志设计、界面设计、交互设计、APP设计。在工作中有很强的沟通推进能力及项目管理能力，善于从产品角度做设计将创 意落地到产品，有效实现设计价值到商业价值的转化。', 800.00, 40, 8005, '', 1, 0, '2020-10-14 16:57:02', '2020-10-19 14:53:03', 1, 1, 0, '2020-10-19 14:53:03.262');
INSERT INTO `production_info` VALUES (2007, '20101416GSNGT96GJ', 4005, '网站、工具，APP、小程序，我都可以', 'python开发', 400.00, 40, 6009, '', 1, 0, '2020-10-14 16:58:55', '2020-10-14 19:34:23', 1, 1, 0, '2020-10-14 19:34:23.181');
INSERT INTO `production_info` VALUES (4000, '20101416HKU9N9XRL', 4000, '电影风格的海报设计', '我会根据你的故事为你设计一张专属的电影风格的海报 ', 500.00, 20, 8005, '', 1, 0, '2020-10-14 16:48:41', '2020-10-18 09:07:59', 1, 4000, 0, '2020-10-18 09:07:59.182');
INSERT INTO `production_info` VALUES (4001, '201014164ZTQVRFEQ', 2005, '超过20年有实践经验的咨询顾问', '组织管控、组织变革、领导力发展、企业文化、人力资源转型、人才发展、薪酬绩效优化', 1000.00, 40, 8004, '', 1, 0, '2020-10-14 16:52:39', '2020-10-15 11:05:31', 1, 1, 0, '2020-10-15 11:05:30.695');
INSERT INTO `production_info` VALUES (4002, '20101416BWML373S9', 4001, '视频剪辑师，用每一帧表达你想表达的', '视频制作软件，脚本制作', 300.00, 20, 8007, '', 1, 0, '2020-10-14 16:53:49', '2020-10-14 20:15:56', 1, 1, 0, '2020-10-14 20:15:55.708');
INSERT INTO `production_info` VALUES (4003, '20101416JMTPRDAAA', 2003, '活动策划咨询助你市场大火', '从事市场领域七年,擅长活动策划、品牌运营、数据分析。大多数在出行领域 创造能力非常强 。在宁波创建了市场人联盟、白驹滑雪俱乐部、浙沪用车便民平台。', 100.00, 40, 8006, '', 1, 0, '2020-10-14 16:56:17', '2020-10-19 14:55:06', 1, 1, 0, '2020-10-19 14:55:06.325');
INSERT INTO `production_info` VALUES (4004, '20101416KXV3N3G68', 4006, '我擅长分布式系统开发，可单兵可团队', 'java服务端以及javaweb开发，开发高效，价格便宜', 100.00, 40, 6009, '', 1, 0, '2020-10-14 16:58:12', '2020-10-17 23:29:07', 1, 4006, 0, '2020-10-17 23:29:07.910');
INSERT INTO `production_info` VALUES (4005, '20101416MQTRENNV6', 2008, '管理系统技术搭建者', '管理系统开发', 100.00, 40, 6009, '', 1, 0, '2020-10-14 16:59:39', '2020-10-14 19:56:13', 1, 1, 0, '2020-10-14 19:56:12.753');
INSERT INTO `production_info` VALUES (6000, '20101417KQ2U5GEEJ', 4000, '线上测试作品', '线上测试作品', 500.00, 40, 6006, '', 1, 0, '2020-10-14 17:13:34', '2020-10-14 17:22:02', 4000, 4000, 1, '2020-10-14 17:22:02.408');
INSERT INTO `production_info` VALUES (6001, '20101417DGDPHJHRD', 4001, '测试云hr', '云hr', 50.00, 40, 8003, '', 1, 0, '2020-10-14 17:23:27', '2020-10-14 17:27:06', 4001, 4001, 1, '2020-10-14 17:27:06.005');
INSERT INTO `production_info` VALUES (6002, '20101420KKM9DKLVE', 4013, '资深C端产品顾问', '资深C端产品顾问', 300.00, 40, 6007, '', 1, 0, '2020-10-14 20:11:20', '2020-10-17 23:29:40', 4013, 4013, 0, '2020-10-17 23:29:40.701');
INSERT INTO `production_info` VALUES (6003, '20101421L43FM49JC', 2018, '培训', '金牌面试官速成训练', 2000.00, 40, 8003, '', 1, 0, '2020-10-14 21:14:52', '2020-10-17 23:29:55', 2018, 2018, 0, '2020-10-17 23:29:55.080');
INSERT INTO `production_info` VALUES (6004, '20101500DX9FB5NV6', 2022, 'kjhjk', 'kjhkhj', 87.00, 20, 6003, '', 1, 0, '2020-10-15 00:13:30', '2020-10-15 00:13:57', 2022, 2022, 1, '2020-10-15 00:13:57.116');
INSERT INTO `production_info` VALUES (6005, '20101500LEHR2R6Z3', 2022, 'asdas', 'asda', 211.00, 30, 6006, '', 1, 0, '2020-10-15 00:27:27', '2020-10-21 20:26:38', 2022, 2022, 0, '2020-10-21 20:26:38.188');
INSERT INTO `production_info` VALUES (6006, '20101500L2UNVTMGJ', 2015, '万壑泉声松外去，数行秋色雁边来', '南来北往，不辜负生活，不迷失方向', 998.00, 20, 6004, '', 1, 0, '2020-10-15 00:37:11', '2020-10-15 00:37:53', 2015, 2015, 1, '2020-10-15 00:37:53.425');
INSERT INTO `production_info` VALUES (8000, '20101417D2GY4Z6Z3', 2004, ' 波球买手App设计1', '我是一名UI设计师个视觉设计师平面设计师，擅长LOGO设计，UI界面设计，VIS视觉识别设计。我有着丰富的UI设计经验，截止目前我有四款上线app，还有一款待上线，WEB端以及OA更是不计其数，目前我的目标是转战产品，应该不管设计对象是什么，都得从用户的角度思维出发，了解了用户群体才能真正的做好设计。', 90.00, 40, 8005, '', 1, 0, '2020-10-14 17:37:02', '2020-10-19 14:56:24', 1, 1, 0, '2020-10-19 14:56:23.956');
INSERT INTO `production_info` VALUES (8001, '20101419KM52ZW2R9', 2006, '途隆安全云官网', '视觉设计、品牌插画及线上线下营销设计', 400.00, 40, 10000, '', 1, 0, '2020-10-14 19:16:14', '2020-10-14 19:46:44', 1, 1, 0, '2020-10-14 19:46:44.006');
INSERT INTO `production_info` VALUES (8002, '20101423GDVH7JWYF', 4001, '室内设计师，出图高手', '建筑装修、环境艺术设计、室内设计', 400.00, 20, 10002, '', 1, 0, '2020-10-14 23:11:44', '2020-10-14 23:11:44', 1, 1, 0, '2020-10-14 23:11:43.544');
INSERT INTO `production_info` VALUES (8003, '20101423F6S2FJZ78', 4001, '专业BIM设计师', 'BIM、模型搭建，效果渲染，视频制作，工程量计算', 300.00, 20, 10002, '', 1, 0, '2020-10-14 23:13:32', '2020-10-14 23:13:32', 1, 1, 0, '2020-10-14 23:13:31.618');
INSERT INTO `production_info` VALUES (10000, '20101419E36RUYKU6', 2006, ' 途隆安全云官网', '视觉设计、品牌插画及线上线下营销设计', 400.00, 40, 6006, '', 1, 0, '2020-10-14 19:18:32', '2020-10-14 19:46:57', 1, 1, 0, '2020-10-14 19:46:57.298');
INSERT INTO `production_info` VALUES (10001, '201014224PL2GYGQ5', 6000, '法税专家、企业家的风险管理师', '擅长股权设计专案、争议及纠纷处理、财富保全专案、法税常年顾问。原上海普陀区人民法院法官、刑庭、执行庭、民商事审判庭主审法官，现任多家企业法务总监、顾问.烁光法税平台创始人，可组织专业团队从多专业领域交叉综合解决企业痛点问题 接受免费电话咨询，专案项目按照专案确认。', 2500.00, 40, 10001, '', 1, 0, '2020-10-14 22:39:10', '2020-10-19 15:00:00', 1, 1, 0, '2020-10-19 15:00:00.482');
INSERT INTO `production_info` VALUES (12000, '201014193VL2QURAP', 2009, '视频剪辑', '宣传片 抖音视频等剪辑', 300.00, 40, 8007, '', 1, 0, '2020-10-14 19:55:50', '2020-10-20 17:56:28', 2009, 1, 0, '2020-10-20 17:56:27.768');
INSERT INTO `production_info` VALUES (14000, '20101500DQBYHE4AW', 2000, '565', '565', 999.00, 30, 6006, '', 1, 0, '2020-10-15 00:58:11', '2020-10-21 20:26:55', 2000, 2000, 0, '2020-10-21 20:26:55.708');
INSERT INTO `production_info` VALUES (14001, '20101501ATR29CKU6', 2000, '9', '999999999999999', 9090.00, 30, 8008, '', 1, 0, '2020-10-15 01:14:58', '2020-10-21 20:27:16', 2000, 2000, 0, '2020-10-21 20:27:16.067');
INSERT INTO `production_info` VALUES (14002, '20101513NKCEWZR5V', 8027, '数码产品视频拍摄', '全网15万粉，ID 撒姆SANG，以b站，知乎，微博，优酷，头条为主。还有另外一套平台，单期视频播放20万左右。接全套产品推广/植入视频，定制8000，五分钟左右，植入另算。另提供视频拍摄后期服务，价格单谈。', 11000.00, 40, 8007, '', 1, 0, '2020-10-15 13:29:40', '2020-10-17 23:34:19', 8027, 8027, 0, '2020-10-17 23:34:19.111');
INSERT INTO `production_info` VALUES (14003, '20102010C5Q3KHNS5', 6075, '流量购买整合营销（线上/SEM/信息流/SEO）', '10年➕网络推广从业经验，熟悉包括：SEM/信息流/DSP/SEO等广告形式；以ROI为核心KPI的广告整合；熟悉整个转化链条各个业务环节，特别是获客以及用户增长；5年➕的团队管理经验；', 200.00, 40, 8006, '', 1, 0, '2020-10-20 10:25:36', '2020-10-20 17:57:34', 6075, 1, 0, '2020-10-20 17:57:33.958');
INSERT INTO `production_info` VALUES (14004, '20102113HBXDVKSHY', 6079, '初创/项目型团队招聘组建、管理方案设计', '人资源工作15年，电商行业耕耘10年+，经历并组建从创业团队到规模企业（500人+），擅长薪酬绩效设计、人员招聘、团队组建、管理顾问。', 500.00, 40, 6003, '', 1, 0, '2020-10-21 13:54:38', '2020-10-21 16:17:17', 6079, 6079, 0, '2020-10-21 16:17:17.709');
INSERT INTO `production_info` VALUES (14005, '20102611KSDUHKJ3K', 6095, '深度操盘4个上市公司咨询团队', '蒙牛  小肥羊  蒙草   科拓生物上市入股咨询企业', 1000.00, 40, 8002, '', 1, 0, '2020-10-26 11:09:55', '2020-10-27 14:16:17', 6095, 6095, 0, '2020-10-27 14:16:17.272');
INSERT INTO `production_info` VALUES (16000, '201015004B7WAJLN4', 2015, '流水不争先，争的是滔滔不绝', '白昼之光，岂知夜色之深 —— 尼采', 998.00, 20, 6005, '', 1, 0, '2020-10-15 00:59:32', '2020-10-15 09:16:23', 2015, 2015, 1, '2020-10-15 09:16:23.791');
INSERT INTO `production_info` VALUES (16001, '20101501EARMMVXRL', 2000, '测试的路上注意安全！么么哒', '121距离产生美——以下内容仅对你可见——', 3636.00, 30, 8007, '', 1, 0, '2020-10-15 01:00:13', '2020-10-21 20:27:22', 2000, 2000, 0, '2020-10-21 20:27:22.764');
INSERT INTO `production_info` VALUES (16002, '20101501LM66LELKC', 2000, '@163.com个电话', '自爱，沉稳，而后爱人 —— 亦舒白昼之光，岂知夜色之深 —— 尼采今天比昨天好，就是希望必须敢于正视，这才可望敢想、敢说、敢做、敢当 —— 鲁迅我的脑袋是个小小星球，每天只有你开着月亮车巡游想变成一架小飞机 噗嗤噗嗤的飞进你的心里⌯\'▾\'⌯如果你要拥抱我请提前告诉我，我好把小肚子收起来', 155.00, 30, 8008, '', 1, 0, '2020-10-15 01:16:50', '2020-10-21 20:27:28', 2000, 2000, 0, '2020-10-21 20:27:28.460');
INSERT INTO `production_info` VALUES (16003, '20101501CNRA6K8V6', 2000, '测的', '你应该是一场梦，我应该是一阵风 —— 顾城', 39.00, 30, 6010, '', 1, 0, '2020-10-15 01:26:12', '2020-10-21 20:27:35', 2000, 2000, 0, '2020-10-21 20:27:35.724');
INSERT INTO `production_info` VALUES (16004, '20101512CK7LLQ2FQ', 6016, '文案策划', '擅长文案撰写，根据需求目的，目标受众，需求效果撰写文案。缺图，后补', 80.00, 40, 8006, '', 1, 0, '2020-10-15 12:37:16', '2020-10-17 23:30:39', 6016, 6016, 0, '2020-10-17 23:30:39.796');
INSERT INTO `production_info` VALUES (16005, '20101513F39V493GQ', 6022, '合同审核专家', '审核商业合同是一项复杂的专业工作，合同审核犹如影视创作，合同审核人员犹如影视项目的主创，优秀的主创能产生优秀的影视作品，而优秀的合同审核人员也能产出优质的合同内容，优质的合同在形式上结构合理、层次清晰，内容上名副其实、通熟易懂、条款完备，在风险防控上进可攻、退可守、鉴往知来。', 200.00, 40, 10001, '', 1, 0, '2020-10-15 13:22:05', '2020-10-17 23:30:55', 6022, 6022, 0, '2020-10-17 23:30:55.038');
INSERT INTO `production_info` VALUES (16006, '20101515DWE94MNGX', 8040, '全栈工程师', '本人熟练掌握 前后台开发包括小程序公众号，6年相关工作经验，只接受兼职，欢迎来撩。', 150.00, 40, 8008, '', 1, 0, '2020-10-15 15:06:40', '2020-10-17 23:31:12', 8040, 8040, 0, '2020-10-17 23:31:12.482');
INSERT INTO `production_info` VALUES (16007, '201015152T85GNEJ2', 8045, '服务采购专家', '20年企业服务采购经验（国际服务采购不含实物贸易）教你迅速匹配可用的经验和教训，避开采购的坑。', 960.00, 40, 8004, '', 1, 0, '2020-10-15 15:56:47', '2020-10-17 23:33:50', 8045, 8045, 0, '2020-10-17 23:33:50.924');
INSERT INTO `production_info` VALUES (16008, '20101606GDVHNTTTM', 6051, '一个拥有15年互联网实战经验的HR', 'HR中的战斗机，骁勇善战', 500.00, 40, 8003, '', 1, 0, '2020-10-16 06:25:53', '2020-10-18 14:28:31', 6051, 1, 0, '2020-10-18 14:28:31.193');
INSERT INTO `production_info` VALUES (16009, '20101610L4RPYNPAA', 4002, '我可以帮助企业代运营电商', '本人擅长商祥页设计，商品类目设计，活动策划…', 100.00, 20, 6007, '', 1, 0, '2020-10-16 10:35:19', '2020-10-16 10:35:19', 4002, 4002, 0, '2020-10-16 10:35:18.541');
INSERT INTO `production_info` VALUES (16010, '20101610FMFJNGUQ9', 6054, '线上心理咨询和辅导', '国家二级心理咨询师，211重点院校社会心理学硕士，多年高校和企业心理健康辅导经验；擅长婚姻困惑、情感纠葛和职场中碰到的各种问题的咨询和处理，专业专注，坚持职业操守，值得信赖。', 300.00, 40, 6003, '', 1, 0, '2020-10-16 10:55:05', '2020-10-23 17:04:57', 6054, 1, 0, '2020-10-23 17:04:57.470');
INSERT INTO `production_info` VALUES (16011, '20101612J9ZEBTETM', 6057, '中小型初创企业人力资源实操辅导', '中小企业初创企业团队组建，人员培训，薪酬体系搭建，绩效考核梳理落地，内部管理常见问题辅导，制度流程建设……', 300.00, 40, 8003, '', 1, 0, '2020-10-16 12:23:50', '2020-10-17 23:31:29', 6057, 6057, 0, '2020-10-17 23:31:29.214');
INSERT INTO `production_info` VALUES (16012, '20101809DXUTEBDXF', 2007, '创业团队从0-1人才招聘', '互联网全球化人才选拨和招聘，带领招聘团队组建至千人以上规模，HRBP业务伙伴丰富人才发展赋能落地，打造企业文化建设，陪伴业务多次打硬仗销售团队辅导与建设落地管理，实现销售目标增长与突破。', 500.00, 40, 8003, '', 1, 0, '2020-10-18 09:21:08', '2020-10-19 10:14:02', 2007, 2007, 0, '2020-10-19 10:14:02.549');
INSERT INTO `production_info` VALUES (16013, '20101909FS6XU2CWU', 8077, '14年企业运营实战HRD管理经验', '08年开始从事人力资源工作，从起步阶段的人事总监助理一路走到自己创业，经历了11年之久的专心学习、潜修专业的阶段，也经历了2年激情创业、夜不能寐的阶段，在工作期间看到了很多老板创业守业的卓绝信念，更对梦想、信念、创业等关键词多了敏感和期待的心情。小女子文能执笔潜修，武能点兵点将，期待慧眼识珠，定不负所望。', 500.00, 40, 12000, '', 1, 0, '2020-10-19 09:53:33', '2020-10-19 10:48:13', 8077, 8077, 0, '2020-10-19 10:48:13.940');
INSERT INTO `production_info` VALUES (16014, '20101914L5KSAF6K2', 8078, '室内空间设计工作站', '主室内空间设计，工装商业展示、家装住宅会所，可附带小景观园林设计。全套专业概念展示ppt+效果图+方案施工图纸。全流程设计展示、沟通、呈现，设计到施工概念落地跟进。', 300.00, 40, 10002, '', 1, 0, '2020-10-19 14:06:38', '2020-10-20 17:37:04', 8078, 8078, 0, '2020-10-20 17:37:04.877');
INSERT INTO `production_info` VALUES (16015, '20102219JHGWUU4LZ', 8099, '内容运营/新媒体运营/社区运营实习生', '擅长PS绘画修图、PR视频剪辑、AU音频后期，LOFTER平台官方认证内容创作者，个人博客内拥有100余篇原创文章，包括插画、小说、专栏文章、视频剪辑、表情包等等，共计700万+阅读量，5万+点赞或推荐；作品曾被学校官方媒体宣传，也曾获得过网信办举办的大学生网络文化节优胜奖，拥有比较丰富的创作经验和内容策划经验。', 100.00, 40, 6008, '', 1, 0, '2020-10-22 19:42:49', '2020-10-22 19:50:20', 8099, 8099, 0, '2020-10-22 19:50:20.584');
INSERT INTO `production_info` VALUES (16016, '20102307F3MWGZWFB', 6010, '视频剪辑，图片后期', '会lr  pr，抖音快手各大段视频平台的视频剪辑经验以及图片的后期处理', 100.00, 40, 8007, '', 1, 0, '2020-10-23 07:41:08', '2020-10-23 09:39:46', 6010, 6010, 0, '2020-10-23 09:39:46.193');
INSERT INTO `production_info` VALUES (16017, '20102313AKEEZZXUM', 4000, '测试', '测试', 5.00, 20, 6003, '', 1, 0, '2020-10-23 13:29:58', '2020-10-23 13:29:58', 4000, 4000, 0, '2020-10-23 13:29:58.415');
INSERT INTO `production_info` VALUES (16018, '20102611EXHJ8AMVM', 6095, '高档设计', '高档画册设计，制作，覆盖全国另有包装设计制作打样澳门上海台湾设计师', 600.00, 40, 6006, '', 1, 0, '2020-10-26 11:06:59', '2020-10-27 14:16:42', 6095, 6095, 0, '2020-10-27 14:16:42.327');
INSERT INTO `production_info` VALUES (18000, '20101510BTLEYWDTE', 4001, '激励制度解决专家', '制度设计 、绩效、薪酬体系设计，股权激励方案设计', 200.00, 20, 8003, '', 1, 0, '2020-10-15 10:04:48', '2020-10-15 10:04:48', 1, 1, 0, '2020-10-15 10:04:48.222');
INSERT INTO `production_info` VALUES (20000, '20101510C92QKZJUM', 6001, '电商全品类产品拍摄；短视频、信息流广告、宣传片等拍摄。', '平面类：从事电商各类产品平面拍摄十余年；视频类：信息流广告、MCN剧情、宣传片等拍摄。', 500.00, 40, 6011, '', 1, 0, '2020-10-15 10:07:31', '2020-10-17 00:28:58', 1, 6001, 0, '2020-10-17 00:28:58.052');
INSERT INTO `production_info` VALUES (20001, '20101510AVLE5A58G', 6015, '大教育类海外与市场类岗位招聘', '海外招聘、市场专家、校长（分总）等高端招聘', 200.00, 40, 8003, '', 1, 0, '2020-10-15 10:08:34', '2020-10-15 14:07:57', 1, 1, 0, '2020-10-15 14:07:56.595');
INSERT INTO `production_info` VALUES (22000, '20102317B4BP3TUJR', 8079, '心理咨询', '15年人力资源招聘、心理咨询专家，擅长招聘和人才梯队搭建、职业规划、心理员工辅导', 300.00, 40, 8003, '', 1, 0, '2020-10-23 17:16:13', '2020-10-23 17:16:13', 1, 1, 0, '2020-10-23 17:16:13.148');
COMMIT;

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
  PRIMARY KEY (`id`),
  KEY `IDX_PRO_ID` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14004 DEFAULT CHARSET=utf8 COMMENT='作品审核表';

-- ----------------------------
-- Records of production_review_info
-- ----------------------------
BEGIN;
INSERT INTO `production_review_info` VALUES (2000, 6000, 1, '', 30, '2020-10-14 17:13:48', '2020-10-14 17:13:48', 1, 1, 0, '2020-10-14 17:13:47.776');
INSERT INTO `production_review_info` VALUES (4000, 6001, 1, '', 30, '2020-10-14 17:23:46', '2020-10-14 17:23:46', 1, 1, 0, '2020-10-14 17:23:45.651');
INSERT INTO `production_review_info` VALUES (6000, 20000, 1, '', 30, '2020-10-17 00:28:58', '2020-10-17 00:28:58', 1, 1, 0, '2020-10-17 00:28:58.061');
INSERT INTO `production_review_info` VALUES (6001, 10001, 1, '', 30, '2020-10-17 00:36:10', '2020-10-17 00:36:10', 1, 1, 0, '2020-10-17 00:36:09.884');
INSERT INTO `production_review_info` VALUES (6002, 6002, 1, '', 30, '2020-10-17 23:29:41', '2020-10-17 23:29:41', 1, 1, 0, '2020-10-17 23:29:40.716');
INSERT INTO `production_review_info` VALUES (6003, 6003, 1, '', 30, '2020-10-17 23:29:55', '2020-10-17 23:29:55', 1, 1, 0, '2020-10-17 23:29:54.984');
INSERT INTO `production_review_info` VALUES (6004, 16005, 1, '', 30, '2020-10-17 23:30:55', '2020-10-17 23:30:55', 1, 1, 0, '2020-10-17 23:30:55.033');
INSERT INTO `production_review_info` VALUES (6005, 16006, 1, '', 30, '2020-10-17 23:31:12', '2020-10-17 23:31:12', 1, 1, 0, '2020-10-17 23:31:12.465');
INSERT INTO `production_review_info` VALUES (6006, 16008, 1, '图片不合规', 20, '2020-10-17 23:33:27', '2020-10-17 23:33:27', 1, 1, 0, '2020-10-17 23:33:27.112');
INSERT INTO `production_review_info` VALUES (6007, 16007, 1, '', 30, '2020-10-17 23:33:51', '2020-10-17 23:33:51', 1, 1, 0, '2020-10-17 23:33:50.911');
INSERT INTO `production_review_info` VALUES (6008, 16013, 1, '', 30, '2020-10-19 10:48:14', '2020-10-19 10:48:14', 1, 1, 0, '2020-10-19 10:48:13.932');
INSERT INTO `production_review_info` VALUES (6009, 16014, 1, '', 30, '2020-10-20 17:37:05', '2020-10-20 17:37:05', 1, 1, 0, '2020-10-20 17:37:04.865');
INSERT INTO `production_review_info` VALUES (6010, 14003, 1, '', 30, '2020-10-20 17:37:33', '2020-10-20 17:37:33', 1, 1, 0, '2020-10-20 17:37:33.018');
INSERT INTO `production_review_info` VALUES (8000, 4004, 1, '', 30, '2020-10-17 23:29:08', '2020-10-17 23:29:08', 1, 1, 0, '2020-10-17 23:29:07.914');
INSERT INTO `production_review_info` VALUES (8001, 12000, 1, '', 30, '2020-10-17 23:30:11', '2020-10-17 23:30:11', 1, 1, 0, '2020-10-17 23:30:11.078');
INSERT INTO `production_review_info` VALUES (8002, 16004, 1, '', 30, '2020-10-17 23:30:40', '2020-10-17 23:30:40', 1, 1, 0, '2020-10-17 23:30:39.793');
INSERT INTO `production_review_info` VALUES (8003, 16011, 1, '', 30, '2020-10-17 23:31:29', '2020-10-17 23:31:29', 1, 1, 0, '2020-10-17 23:31:29.201');
INSERT INTO `production_review_info` VALUES (8004, 16010, 1, '', 30, '2020-10-17 23:33:03', '2020-10-17 23:33:03', 1, 1, 0, '2020-10-17 23:33:03.439');
INSERT INTO `production_review_info` VALUES (8005, 14002, 1, '', 30, '2020-10-17 23:34:19', '2020-10-17 23:34:19', 1, 1, 0, '2020-10-17 23:34:19.097');
INSERT INTO `production_review_info` VALUES (8006, 16012, 1, '', 30, '2020-10-18 14:28:56', '2020-10-18 14:28:56', 1, 1, 0, '2020-10-18 14:28:56.225');
INSERT INTO `production_review_info` VALUES (8007, 16012, 1, '', 30, '2020-10-18 18:04:32', '2020-10-18 18:04:32', 1, 1, 0, '2020-10-18 18:04:31.540');
INSERT INTO `production_review_info` VALUES (8008, 16012, 1, '', 30, '2020-10-19 10:14:03', '2020-10-19 10:14:03', 1, 1, 0, '2020-10-19 10:14:02.557');
INSERT INTO `production_review_info` VALUES (10000, 14004, 1, '', 30, '2020-10-21 16:17:18', '2020-10-21 16:17:18', 1, 1, 0, '2020-10-21 16:17:17.703');
INSERT INTO `production_review_info` VALUES (12000, 6005, 1, '', 20, '2020-10-21 20:26:38', '2020-10-21 20:26:38', 1, 1, 0, '2020-10-21 20:26:38.195');
INSERT INTO `production_review_info` VALUES (12001, 14000, 1, '', 20, '2020-10-21 20:27:09', '2020-10-21 20:27:09', 1, 1, 0, '2020-10-21 20:27:08.641');
INSERT INTO `production_review_info` VALUES (12002, 14001, 1, '', 20, '2020-10-21 20:27:16', '2020-10-21 20:27:16', 1, 1, 0, '2020-10-21 20:27:16.080');
INSERT INTO `production_review_info` VALUES (12003, 16003, 1, '', 20, '2020-10-21 20:27:36', '2020-10-21 20:27:36', 1, 1, 0, '2020-10-21 20:27:35.739');
INSERT INTO `production_review_info` VALUES (12004, 16016, 1, '', 30, '2020-10-23 09:39:46', '2020-10-23 09:39:46', 1, 1, 0, '2020-10-23 09:39:46.176');
INSERT INTO `production_review_info` VALUES (12005, 14005, 1, '', 30, '2020-10-27 14:16:17', '2020-10-27 14:16:17', 1, 1, 0, '2020-10-27 14:16:17.281');
INSERT INTO `production_review_info` VALUES (12006, 16018, 1, '', 30, '2020-10-27 14:16:42', '2020-10-27 14:16:42', 1, 1, 0, '2020-10-27 14:16:42.339');
INSERT INTO `production_review_info` VALUES (14000, 14000, 1, '', 20, '2020-10-21 20:26:56', '2020-10-21 20:26:56', 1, 1, 0, '2020-10-21 20:26:55.707');
INSERT INTO `production_review_info` VALUES (14001, 16001, 1, '', 20, '2020-10-21 20:27:23', '2020-10-21 20:27:23', 1, 1, 0, '2020-10-21 20:27:22.779');
INSERT INTO `production_review_info` VALUES (14002, 16002, 1, '', 20, '2020-10-21 20:27:28', '2020-10-21 20:27:28', 1, 1, 0, '2020-10-21 20:27:28.476');
INSERT INTO `production_review_info` VALUES (14003, 16015, 1, '', 30, '2020-10-22 19:50:21', '2020-10-22 19:50:21', 1, 1, 0, '2020-10-22 19:50:20.575');
COMMIT;

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
  PRIMARY KEY (`id`),
  KEY `IDX_PRO_ID` (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18005 DEFAULT CHARSET=utf8 COMMENT='作品与技能关联表';

-- ----------------------------
-- Records of production_skill_relation
-- ----------------------------
BEGIN;
INSERT INTO `production_skill_relation` VALUES (2000, 4004, 6013, '', '2020-10-14 16:58:12', '2020-10-14 16:58:55', 1, 1, 1, '2020-10-14 16:58:55.209');
INSERT INTO `production_skill_relation` VALUES (2001, 4005, 6013, '', '2020-10-14 16:59:39', '2020-10-14 17:13:34', 1, 1, 1, '2020-10-14 17:13:34.343');
INSERT INTO `production_skill_relation` VALUES (4000, 2007, 8013, '', '2020-10-14 16:58:55', '2020-10-14 16:59:38', 1, 1, 1, '2020-10-14 16:59:38.903');
INSERT INTO `production_skill_relation` VALUES (6000, 6000, 8006, '', '2020-10-14 17:13:34', '2020-10-14 17:52:34', 4000, 4000, 1, '2020-10-14 17:52:34.243');
INSERT INTO `production_skill_relation` VALUES (6001, 6003, 6002, '', '2020-10-14 21:14:52', '2020-10-15 00:27:27', 2018, 2018, 1, '2020-10-15 00:27:27.465');
INSERT INTO `production_skill_relation` VALUES (6002, 6003, 8001, '', '2020-10-14 21:14:52', '2020-10-15 00:27:27', 2018, 2018, 1, '2020-10-15 00:27:27.465');
INSERT INTO `production_skill_relation` VALUES (6003, 6003, 8002, '', '2020-10-14 21:14:52', '2020-10-15 00:27:27', 2018, 2018, 1, '2020-10-15 00:27:27.465');
INSERT INTO `production_skill_relation` VALUES (6004, 6005, 6006, '', '2020-10-15 00:27:27', '2020-10-15 00:27:46', 2022, 2022, 1, '2020-10-15 00:27:46.078');
INSERT INTO `production_skill_relation` VALUES (6005, 6006, 8000, '', '2020-10-15 00:37:11', '2020-10-15 00:37:20', 2015, 2015, 1, '2020-10-15 00:37:20.981');
INSERT INTO `production_skill_relation` VALUES (6006, 6006, 8000, '', '2020-10-15 00:37:21', '2020-10-15 00:37:26', 2015, 2015, 1, '2020-10-15 00:37:26.038');
INSERT INTO `production_skill_relation` VALUES (6007, 6006, 6001, '', '2020-10-15 00:37:21', '2020-10-15 00:37:26', 2015, 2015, 1, '2020-10-15 00:37:26.038');
INSERT INTO `production_skill_relation` VALUES (6008, 6006, 6001, '', '2020-10-15 00:37:26', '2020-10-15 00:37:41', 2015, 2015, 1, '2020-10-15 00:37:41.728');
INSERT INTO `production_skill_relation` VALUES (6009, 6006, 8000, '', '2020-10-15 00:37:26', '2020-10-15 00:37:41', 2015, 2015, 1, '2020-10-15 00:37:41.728');
INSERT INTO `production_skill_relation` VALUES (6010, 6006, 6001, '', '2020-10-15 00:37:42', '2020-10-15 00:37:42', 2015, 2015, 0, '2020-10-15 00:37:41.722');
INSERT INTO `production_skill_relation` VALUES (6011, 6006, 8000, '', '2020-10-15 00:37:42', '2020-10-15 00:37:42', 2015, 2015, 0, '2020-10-15 00:37:41.722');
INSERT INTO `production_skill_relation` VALUES (8000, 4004, 6013, '', '2020-10-14 17:52:34', '2020-10-14 17:55:37', 1, 1, 1, '2020-10-14 17:55:37.691');
INSERT INTO `production_skill_relation` VALUES (8001, 4005, 6013, '', '2020-10-14 17:55:38', '2020-10-14 19:34:23', 1, 1, 1, '2020-10-14 19:34:23.191');
INSERT INTO `production_skill_relation` VALUES (8002, 2007, 6013, '', '2020-10-14 19:34:23', '2020-10-14 19:55:50', 1, 1, 1, '2020-10-14 19:55:50.332');
INSERT INTO `production_skill_relation` VALUES (10000, 12000, 8011, '', '2020-10-14 19:55:50', '2020-10-14 21:14:52', 2009, 2009, 1, '2020-10-14 21:14:52.211');
INSERT INTO `production_skill_relation` VALUES (10001, 12000, 8012, '', '2020-10-14 19:55:50', '2020-10-14 21:14:52', 2009, 2009, 1, '2020-10-14 21:14:52.211');
INSERT INTO `production_skill_relation` VALUES (10002, 12000, 8010, '', '2020-10-14 19:55:50', '2020-10-14 21:14:52', 2009, 2009, 1, '2020-10-14 21:14:52.211');
INSERT INTO `production_skill_relation` VALUES (10003, 12000, 6012, '', '2020-10-14 19:55:50', '2020-10-14 21:14:52', 2009, 2009, 1, '2020-10-14 21:14:52.211');
INSERT INTO `production_skill_relation` VALUES (10004, 6005, 8005, '', '2020-10-15 00:27:46', '2020-10-15 00:27:59', 2022, 2022, 1, '2020-10-15 00:27:59.667');
INSERT INTO `production_skill_relation` VALUES (10005, 6005, 6005, '', '2020-10-15 00:27:46', '2020-10-15 00:27:59', 2022, 2022, 1, '2020-10-15 00:27:59.667');
INSERT INTO `production_skill_relation` VALUES (10006, 6005, 6005, '', '2020-10-15 00:28:00', '2020-10-15 00:37:10', 2022, 2022, 1, '2020-10-15 00:37:10.774');
INSERT INTO `production_skill_relation` VALUES (10007, 6005, 8005, '', '2020-10-15 00:28:00', '2020-10-15 00:37:10', 2022, 2022, 1, '2020-10-15 00:37:10.774');
INSERT INTO `production_skill_relation` VALUES (12000, 14000, 8006, '', '2020-10-15 00:58:11', '2020-10-15 01:01:12', 2000, 2000, 1, '2020-10-15 01:01:12.295');
INSERT INTO `production_skill_relation` VALUES (12001, 16000, 8003, '', '2020-10-15 00:59:48', '2020-10-15 00:59:57', 2015, 2015, 1, '2020-10-15 00:59:57.860');
INSERT INTO `production_skill_relation` VALUES (12002, 16000, 8003, '', '2020-10-15 00:59:58', '2020-10-15 01:00:14', 2015, 2015, 1, '2020-10-15 01:00:14.679');
INSERT INTO `production_skill_relation` VALUES (12003, 16000, 8004, '', '2020-10-15 00:59:58', '2020-10-15 01:00:14', 2015, 2015, 1, '2020-10-15 01:00:14.679');
INSERT INTO `production_skill_relation` VALUES (12004, 16000, 8003, '', '2020-10-15 01:00:15', '2020-10-15 01:00:22', 2015, 2015, 1, '2020-10-15 01:00:22.129');
INSERT INTO `production_skill_relation` VALUES (12005, 16000, 8004, '', '2020-10-15 01:00:15', '2020-10-15 01:00:22', 2015, 2015, 1, '2020-10-15 01:00:22.129');
INSERT INTO `production_skill_relation` VALUES (12006, 16000, 8004, '', '2020-10-15 01:00:22', '2020-10-15 01:00:36', 2015, 2015, 1, '2020-10-15 01:00:36.289');
INSERT INTO `production_skill_relation` VALUES (12007, 16000, 8004, '', '2020-10-15 01:00:36', '2020-10-15 01:00:44', 2015, 2015, 1, '2020-10-15 01:00:44.493');
INSERT INTO `production_skill_relation` VALUES (12008, 16000, 8004, '', '2020-10-15 01:00:45', '2020-10-15 01:03:52', 2015, 2015, 1, '2020-10-15 01:03:52.406');
INSERT INTO `production_skill_relation` VALUES (12009, 16000, 8003, '', '2020-10-15 01:00:45', '2020-10-15 01:03:52', 2015, 2015, 1, '2020-10-15 01:03:52.406');
INSERT INTO `production_skill_relation` VALUES (12010, 14001, 6021, '', '2020-10-15 01:14:58', '2020-10-15 01:14:58', 2000, 2000, 0, '2020-10-15 01:14:58.328');
INSERT INTO `production_skill_relation` VALUES (12011, 16012, 8001, '', '2020-10-18 09:22:12', '2020-10-18 09:26:23', 2007, 2007, 1, '2020-10-18 09:26:23.086');
INSERT INTO `production_skill_relation` VALUES (12012, 16012, 6002, '', '2020-10-18 09:22:12', '2020-10-18 09:26:23', 2007, 2007, 1, '2020-10-18 09:26:23.086');
INSERT INTO `production_skill_relation` VALUES (12013, 16012, 8002, '', '2020-10-18 09:22:12', '2020-10-18 09:26:23', 2007, 2007, 1, '2020-10-18 09:26:23.086');
INSERT INTO `production_skill_relation` VALUES (12014, 16012, 6002, '', '2020-10-18 09:26:23', '2020-10-18 18:04:23', 2007, 2007, 1, '2020-10-18 18:04:23.689');
INSERT INTO `production_skill_relation` VALUES (12015, 16012, 8001, '', '2020-10-18 09:26:23', '2020-10-18 18:04:23', 2007, 2007, 1, '2020-10-18 18:04:23.689');
INSERT INTO `production_skill_relation` VALUES (12016, 16012, 8002, '', '2020-10-18 09:26:23', '2020-10-18 18:04:23', 2007, 2007, 1, '2020-10-18 18:04:23.689');
INSERT INTO `production_skill_relation` VALUES (14000, 16000, 8003, '', '2020-10-15 00:59:32', '2020-10-15 00:59:48', 2015, 2015, 1, '2020-10-15 00:59:48.142');
INSERT INTO `production_skill_relation` VALUES (14001, 16001, 6018, '', '2020-10-15 01:00:13', '2020-10-15 01:00:55', 2000, 2000, 1, '2020-10-15 01:00:55.723');
INSERT INTO `production_skill_relation` VALUES (14002, 16001, 6020, '', '2020-10-15 01:00:13', '2020-10-15 01:00:55', 2000, 2000, 1, '2020-10-15 01:00:55.723');
INSERT INTO `production_skill_relation` VALUES (14003, 16001, 6018, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14004, 16001, 6020, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14005, 16001, 6021, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14006, 16001, 6019, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14007, 16001, 8011, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14008, 16001, 8010, '', '2020-10-15 01:00:56', '2020-10-15 01:00:56', 2000, 2000, 0, '2020-10-15 01:00:55.736');
INSERT INTO `production_skill_relation` VALUES (14009, 14000, 8006, '', '2020-10-15 01:01:12', '2020-10-15 01:01:12', 2000, 2000, 0, '2020-10-15 01:01:12.302');
INSERT INTO `production_skill_relation` VALUES (14010, 16000, 8003, '', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.239');
INSERT INTO `production_skill_relation` VALUES (14011, 16000, 8004, '', '2020-10-15 01:06:44', '2020-10-15 01:07:03', 2015, 2015, 1, '2020-10-15 01:07:03.239');
INSERT INTO `production_skill_relation` VALUES (14012, 16000, 8003, '', '2020-10-15 01:07:36', '2020-10-15 01:07:36', 2015, 2015, 0, '2020-10-15 01:07:36.104');
INSERT INTO `production_skill_relation` VALUES (14013, 16000, 8004, '', '2020-10-15 01:07:36', '2020-10-15 01:07:36', 2015, 2015, 0, '2020-10-15 01:07:36.104');
INSERT INTO `production_skill_relation` VALUES (14014, 16002, 6020, '', '2020-10-15 01:16:50', '2020-10-15 01:16:50', 2000, 2000, 0, '2020-10-15 01:16:49.912');
INSERT INTO `production_skill_relation` VALUES (14015, 16002, 6019, '', '2020-10-15 01:16:50', '2020-10-15 01:16:50', 2000, 2000, 0, '2020-10-15 01:16:49.912');
INSERT INTO `production_skill_relation` VALUES (14016, 4004, 6013, '', '2020-10-15 17:26:19', '2020-10-15 17:26:19', 4006, 4006, 0, '2020-10-15 17:26:18.848');
INSERT INTO `production_skill_relation` VALUES (14017, 16008, 8001, '', '2020-10-16 06:25:53', '2020-10-18 14:28:31', 6051, 6051, 1, '2020-10-18 14:28:31.197');
INSERT INTO `production_skill_relation` VALUES (14018, 16008, 6002, '', '2020-10-16 06:25:53', '2020-10-18 14:28:31', 6051, 6051, 1, '2020-10-18 14:28:31.197');
INSERT INTO `production_skill_relation` VALUES (14019, 16012, 6002, '', '2020-10-18 18:39:44', '2020-10-18 18:39:44', 2007, 2007, 0, '2020-10-18 18:39:44.321');
INSERT INTO `production_skill_relation` VALUES (14020, 16012, 8001, '', '2020-10-18 18:39:44', '2020-10-18 18:39:44', 2007, 2007, 0, '2020-10-18 18:39:44.321');
INSERT INTO `production_skill_relation` VALUES (14021, 16012, 8002, '', '2020-10-18 18:39:44', '2020-10-18 18:39:44', 2007, 2007, 0, '2020-10-18 18:39:44.321');
INSERT INTO `production_skill_relation` VALUES (14022, 16015, 6009, '', '2020-10-22 19:42:49', '2020-10-22 19:42:49', 8099, 8099, 0, '2020-10-22 19:42:49.113');
INSERT INTO `production_skill_relation` VALUES (14023, 16015, 6008, '', '2020-10-22 19:42:49', '2020-10-22 19:42:49', 8099, 8099, 0, '2020-10-22 19:42:49.113');
INSERT INTO `production_skill_relation` VALUES (14024, 16015, 8009, '', '2020-10-22 19:42:49', '2020-10-22 19:42:49', 8099, 8099, 0, '2020-10-22 19:42:49.113');
INSERT INTO `production_skill_relation` VALUES (14025, 16018, 6005, '', '2020-10-26 11:06:59', '2020-10-26 11:06:59', 6095, 6095, 0, '2020-10-26 11:06:59.241');
INSERT INTO `production_skill_relation` VALUES (14026, 16018, 8005, '', '2020-10-26 11:06:59', '2020-10-26 11:06:59', 6095, 6095, 0, '2020-10-26 11:06:59.241');
INSERT INTO `production_skill_relation` VALUES (14027, 16018, 8006, '', '2020-10-26 11:06:59', '2020-10-26 11:06:59', 6095, 6095, 0, '2020-10-26 11:06:59.241');
INSERT INTO `production_skill_relation` VALUES (14028, 16018, 6006, '', '2020-10-26 11:06:59', '2020-10-26 11:06:59', 6095, 6095, 0, '2020-10-26 11:06:59.241');
INSERT INTO `production_skill_relation` VALUES (16000, 16000, 8004, '', '2020-10-15 01:03:52', '2020-10-15 01:03:57', 1, 1, 1, '2020-10-15 01:03:57.713');
INSERT INTO `production_skill_relation` VALUES (16001, 16000, 8003, '', '2020-10-15 01:03:52', '2020-10-15 01:03:57', 1, 1, 1, '2020-10-15 01:03:57.713');
INSERT INTO `production_skill_relation` VALUES (16002, 16000, 8003, '', '2020-10-15 01:03:58', '2020-10-15 01:06:44', 1, 1, 1, '2020-10-15 01:06:44.390');
INSERT INTO `production_skill_relation` VALUES (18000, 16008, 8001, '', '2020-10-18 14:28:31', '2020-10-18 14:28:31', 1, 1, 0, '2020-10-18 14:28:31.223');
INSERT INTO `production_skill_relation` VALUES (18001, 16008, 6002, '', '2020-10-18 14:28:31', '2020-10-18 14:28:31', 1, 1, 0, '2020-10-18 14:28:31.223');
INSERT INTO `production_skill_relation` VALUES (18002, 16012, 6002, '', '2020-10-18 18:04:24', '2020-10-18 18:39:44', 1, 1, 1, '2020-10-18 18:39:44.326');
INSERT INTO `production_skill_relation` VALUES (18003, 16012, 8001, '', '2020-10-18 18:04:24', '2020-10-18 18:39:44', 1, 1, 1, '2020-10-18 18:39:44.326');
INSERT INTO `production_skill_relation` VALUES (18004, 16012, 8002, '', '2020-10-18 18:04:24', '2020-10-18 18:39:44', 1, 1, 1, '2020-10-18 18:39:44.326');
COMMIT;

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
  UNIQUE KEY `IDX_UN_CODE` (`code`) COMMENT '唯一索引',
  KEY `idx_group` (`belong_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

-- ----------------------------
-- Records of sys_base_dict
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
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

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '系统管理员', '21232f297a57a5a743894a0e4a801fc3', NULL, '2020-10-11 10:28:38', '2020-10-11 10:28:38', 0, '2020-10-11 10:20:13.494', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2000, 'o9kHZ5T2xTZ7jzC-JAZ_gvTWq-Ks', '波英冰', '', '18680506315', NULL, NULL, 0, '2020-10-14 19:24:40.254', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2001, 'o9kHZ5Tls68wk7KCF3bc8J7ujStQ', '康胜苏', '', '15801227230', NULL, NULL, 0, '2020-10-14 16:00:00.993', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2002, 'o9kHZ5YykCaJ-YK0AlRAjlH1JLAY', '孔令飞', '', '15010924982', NULL, NULL, 0, '2020-10-14 18:06:23.864', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2003, 'o9kHZ5ek4ZT0j9uCe-YO4qhGOvtA', '秋天离别-邓雷', '', '18657675257', NULL, NULL, 0, '2020-10-14 18:47:16.666', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2004, 'o9kHZ5QLvfRlem8krDngxoLYbb_M', 'i舒克', '', '18271676417', NULL, NULL, 0, '2020-10-14 18:47:25.475', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2005, 'o9kHZ5fjSDS1VD_y_X9SIJP-MhNM', 'Carly 张蕾', '', '13801251875', NULL, NULL, 0, '2020-10-14 18:47:41.173', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2006, 'o9kHZ5Zjmyol1sFk3jqIcUr7A7u8', 'W-', '', '13261523952', NULL, NULL, 0, '2020-10-14 19:18:06.451', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2007, 'o9kHZ5aHpTfzyPVLSgm9hwFpxqxk', '孙欣Amanda', '', '13120485009', NULL, NULL, 0, '2020-10-14 19:22:32.441', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2008, 'o9kHZ5WrYyAT2Lmc1G5kAxrjUAVU', '张苏k', '', NULL, NULL, NULL, 0, '2020-10-14 19:29:29.026', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2009, 'o9kHZ5Z75I1ZywgpeYj-IJcv6kAo', '官方提醒', '', '18752867304', NULL, NULL, 0, '2020-10-14 19:49:46.578', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2010, 'o9kHZ5SaCiXMaUFtUwAyvEPJBNBI', 'Yu-Hsiu', '', '18611323185', NULL, NULL, 0, '2020-10-14 19:51:25.807', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2011, 'o9kHZ5V0W7A-xfMeAAA83nm0YJMw', '帅炜玥（帅权晍）', '', '13693376633', NULL, NULL, 0, '2020-10-14 19:57:41.306', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2012, 'o9kHZ5eCBk8VrmazjMIMI2Oz0vlk', 'Judy', '', '13501391246', NULL, NULL, 0, '2020-10-14 20:12:11.867', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2013, 'o9kHZ5eAAuqxOlI2EK_u3QcRDoOw', 'OK_Boy', '', '13810998520', NULL, NULL, 0, '2020-10-14 20:12:59.083', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2014, 'o9kHZ5a1Cj3I8M6laT4v7wFSXee0', 'winxie', '', '18500192168', NULL, NULL, 0, '2020-10-14 20:13:52.219', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2015, 'o9kHZ5f5VpDpIHPZ93CQREzTN9mw', ' 嗯哼～', '', '18500229693', NULL, NULL, 0, '2020-10-14 20:14:44.805', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2016, 'o9kHZ5Si6FQktHc4NCtObx0vs2Yk', '菲菲', '', '13910501580', NULL, NULL, 0, '2020-10-14 20:37:33.353', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2017, 'o9kHZ5eOAMyORimaifok31DPNWZY', '杰子', '', '13810469408', NULL, NULL, 0, '2020-10-14 20:54:47.653', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2018, 'o9kHZ5VmUKy_zhgeclhbCSChVpfc', '鹰子', '', '18600852299', NULL, NULL, 0, '2020-10-14 21:12:23.800', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2019, 'o9kHZ5bhuvqKEGJhlzcfJ-duTiN0', '桑雨', '', '18811040547', NULL, NULL, 0, '2020-10-14 21:12:25.775', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2020, 'o9kHZ5TwdNBEO9KSDH8yAMmQM3Q4', '圣灵居士（强哥）', '', '13810684286', NULL, NULL, 0, '2020-10-14 21:23:40.038', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2021, 'o9kHZ5ZhWJvn7yAFSeoxmOuz-Zss', '刘海鸣', '', '18611098024', NULL, NULL, 0, '2020-10-14 23:21:37.913', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2022, 'o9kHZ5RVsiYjCOnQ_I2BVsYwsq6Y', 'why not', '', '18810226137', NULL, NULL, 0, '2020-10-14 23:21:56.492', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2023, 'o9kHZ5biqMlTd7yWesFjip984v34', '祺', '', '18510180570', NULL, NULL, 0, '2020-10-15 00:08:12.919', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (2024, 'o9kHZ5Vpf8MFlMupbBQAMUaFc8qA', 'Lynnnnnnn🦄', '', '15620304128', NULL, NULL, 0, '2020-10-15 00:52:19.285', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4000, 'o9kHZ5VdcI4ZP9fwKCaG82BBqAFw', '麒少爷', '', '15110245740', NULL, NULL, 0, '2020-10-14 16:01:20.744', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4001, 'o9kHZ5Wq8VySe4vaJeVuXM5r8mJk', 'HowWork客服', '', '13261773089', NULL, NULL, 0, '2020-10-14 16:40:56.372', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4002, 'o9kHZ5ezz9uHpgI-T9AuzcRlB23g', '大力🍋', '', '13331138761', NULL, NULL, 0, '2020-10-14 16:51:43.840', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4003, 'o9kHZ5Yn6bXm6Oo2frqnXM0HFm5o', '董亦', '', '13067817724', NULL, NULL, 0, '2020-10-14 18:16:22.767', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4004, 'o9kHZ5ajoAL4Yg8Wt_aeFKn2C1oo', 'Mr.MJ', '', '15221907328', NULL, NULL, 0, '2020-10-14 18:51:52.248', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4005, 'o9kHZ5euzWFHCTkExbwWVd35SkJY', '君扬', '', '13302048330', NULL, NULL, 0, '2020-10-14 19:23:06.600', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4006, 'o9kHZ5cPf0yGEvKBqymwXTBEbZcE', '二东丶', '', '13264181224', NULL, NULL, 0, '2020-10-14 19:34:09.575', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4007, 'o9kHZ5V2rVOeu6kO6XLVggqm7fmw', 'Abby', '', '15011103665', NULL, NULL, 0, '2020-10-14 19:45:51.227', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4008, 'o9kHZ5QEH1pgAevYhtoQJp4gEQgE', '江声', '', '13716988056', NULL, NULL, 0, '2020-10-14 19:49:18.293', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4009, 'o9kHZ5QiMGpd_eyWF0Y1Va9iik78', 'FE', '', '15566899876', NULL, NULL, 0, '2020-10-14 19:50:00.296', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4010, 'o9kHZ5V0hU-blOJNLtYEwGYxjN_0', 'Beyondsky', '', '13522285321', NULL, NULL, 0, '2020-10-14 19:50:23.739', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4011, 'o9kHZ5W-1tsqGYAnBDqntfhRJSNw', '阿白', '', '13701246092', NULL, NULL, 0, '2020-10-14 20:03:53.497', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4012, 'o9kHZ5RYEaOBDILxdvGnMtiLaWJo', 'Tigger', '', '13240119298', NULL, NULL, 0, '2020-10-14 19:53:22.717', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4013, 'o9kHZ5UgjnGNkyyoo_e348Fg6knA', 'Dennis', '', '18516224166', NULL, NULL, 0, '2020-10-14 19:56:32.636', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4014, 'o9kHZ5cBGhqvu-SxyEQpZDHqteZs', 'Leanne', '', '13683687235', NULL, NULL, 0, '2020-10-14 20:05:00.127', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4015, 'o9kHZ5eYyd3mekyZkFEGcnKUwkH4', 'Victoria🦄', '', '17600498222', NULL, NULL, 0, '2020-10-14 20:09:42.940', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4016, 'o9kHZ5c6onau5wnD8CxI-mQPnabE', '郭峰', '', '18611687063', NULL, NULL, 0, '2020-10-14 20:12:57.107', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4017, 'o9kHZ5ZMhl_MxDf7qFt2zKXUqjKE', '惠鹏|盛世三人行', '', NULL, NULL, NULL, 0, '2020-10-14 20:43:55.224', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4018, 'o9kHZ5dvzvHtYp-7sGEzVN_T5IAs', '毛毛钱儿', '', '13811602180', NULL, NULL, 0, '2020-10-14 20:51:16.242', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4019, 'o9kHZ5bMrbVXf8k00yxxbRntYUtw', '郭项玉', '', '13121813382', NULL, NULL, 0, '2020-10-14 20:55:25.245', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4020, 'o9kHZ5T4ec8rUDj3uxlRWJW4d-Tc', 'sun', '', '13718911001', NULL, NULL, 0, '2020-10-14 20:55:49.616', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4021, 'o9kHZ5UuGiIRx8RjwcqFRvUA1oR8', '巴拉巴拉不啦', '', '18519580645', NULL, NULL, 0, '2020-10-14 21:21:25.548', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4022, 'o9kHZ5c8EeYRap025e_CH2tyHFB0', 'stan.j', '', '18810178690', NULL, NULL, 0, '2020-10-14 21:25:36.877', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4023, 'o9kHZ5cWMlS8tVYsw1GY9IbZN9SQ', 'MAOXT', '', '18618284020', NULL, NULL, 0, '2020-10-14 21:27:47.241', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4024, 'o9kHZ5X-lPDfG2VCcfd6QNn-bX3g', '你没', '', NULL, NULL, NULL, 0, '2020-10-14 21:41:39.861', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4025, 'o9kHZ5fxlQvUjAlfrzDyGCeJIBZg', '马俊', '', NULL, NULL, NULL, 0, '2020-10-14 21:44:55.394', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4026, 'o9kHZ5RgMFejKfz_bKlDSbkD5-hU', '高高', '', '15011353173', NULL, NULL, 0, '2020-10-14 22:13:53.205', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6000, 'o9kHZ5f36tk6Upwf-PHkHdkk8yXo', '汤继荣律师 15618301701', '', '13818872885', NULL, NULL, 0, '2020-10-15 03:39:35.573', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6001, 'o9kHZ5Sq8SJ5I4nXwaIAv8G38L5U', '冯 宁', '', '13910429707', NULL, NULL, 0, '2020-10-15 08:59:21.153', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6002, 'o9kHZ5daYqtZ_h0peqLZhn49XbDU', 'Leo', '', NULL, NULL, NULL, 0, '2020-10-15 10:12:12.401', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6003, 'o9kHZ5YvsTYO9350Ex-QTnkO_3ds', '小锅锅', '', '18511697147', NULL, NULL, 0, '2020-10-15 10:14:50.857', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6004, 'o9kHZ5YKS8I2hrKjK4sU0ETtL9Go', '木子', '', '15011322815', NULL, NULL, 0, '2020-10-15 10:33:58.679', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6005, 'o9kHZ5VhcQIdODKHB_ZT-8n73qIA', 'WhenUBelieve', '', NULL, NULL, NULL, 0, '2020-10-15 10:37:48.768', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6006, 'o9kHZ5WRvFbmgpKM6aro_O9NXR04', '轩辕客', '', '15901476757', NULL, NULL, 0, '2020-10-15 11:22:09.227', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6007, 'o9kHZ5etOGiCPV_Yf-irgXI6CHYE', 'Samson孙峰', '', '13901328854', NULL, NULL, 0, '2020-10-15 11:25:52.839', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6008, 'o9kHZ5fdyVSe4akPoBmR6_tgY5QU', '敬淞  ྃ༄༅།འགུ་རུ་།', '', '13522137269', NULL, NULL, 0, '2020-10-15 11:26:50.947', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6009, 'o9kHZ5dIQ2n8TVAFFsbD5QUtNR94', '那谁', '', NULL, NULL, NULL, 0, '2020-10-15 11:43:47.805', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6010, 'o9kHZ5ce4WZ90_qF1RoF7otl8mtI', '九言', '', '13653958513', NULL, NULL, 0, '2020-10-15 11:59:49.610', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6011, 'o9kHZ5eCsZdClmPN_6l6CAnAx5iQ', '🦡小明🦊', '', NULL, NULL, NULL, 0, '2020-10-15 12:00:26.344', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6012, 'o9kHZ5cW2Cs8Htwy2llhYPLAMs1I', '胡博', '', '13466336122', NULL, NULL, 0, '2020-10-15 12:01:26.349', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6013, 'o9kHZ5bgVMmeKnpnx7ET4A6zUlfs', '张泡面', '', '16619715506', NULL, NULL, 0, '2020-10-15 12:05:45.496', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6014, 'o9kHZ5Yh1a1g52jGCu62K5a15aVA', 'Sarah Cui 崔艳荣', '', '18516265080', NULL, NULL, 0, '2020-10-15 12:25:47.311', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6015, 'o9kHZ5Sh9hyarWD9yfdR0wjyuZ3s', '黄婷', '', '18618296273', NULL, NULL, 0, '2020-10-15 12:25:59.209', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6016, 'o9kHZ5a2aOtiHOTxSELqBqGr-te8', '李雪', '', '15268631865', NULL, NULL, 0, '2020-10-15 12:34:36.204', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6017, 'o9kHZ5ZL88kUWb5-qPR0ZYQrqRQA', 'mistletoe🍀', '', '15768716486', NULL, NULL, 0, '2020-10-15 12:43:16.151', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6018, 'o9kHZ5WzcNiDI1GJtX3hr-2M3X5g', '乐成', '', '18800176762', NULL, NULL, 0, '2020-10-15 12:49:01.328', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6019, 'o9kHZ5fWq5zy-AfM3ot5dDsqgTbg', '蓝果', '', '13301312051', NULL, NULL, 0, '2020-10-15 12:52:15.443', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6020, 'o9kHZ5bhgpq3zVnWz3f2ajGavm6I', '威能&贝雷塔壁挂炉13391653950', '', '13391653950', NULL, NULL, 0, '2020-10-15 12:54:13.090', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6021, 'o9kHZ5UVyysJr9QfniBc_LtRXYeA', 'guoxlong', '', '18311238336', NULL, NULL, 0, '2020-10-15 13:04:34.745', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6022, 'o9kHZ5YCZPEcTcZ1MFxZUMbAfxGQ', '阿白', '', '18601350717', NULL, NULL, 0, '2020-10-15 13:14:42.556', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6023, 'o9kHZ5TFuzVvnBBq9PuCNTmRQwv0', 'Jason-AICO', '', '13910210808', NULL, NULL, 0, '2020-10-15 13:21:29.630', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6024, 'o9kHZ5QirzoGuRcKV0H8SNEalNwk', '张卷🕴', '', NULL, NULL, NULL, 0, '2020-10-15 13:26:18.660', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6025, 'o9kHZ5cWrB_ZbXWqWEO5FWors5E4', 'David.Li', '', '18355380522', NULL, NULL, 0, '2020-10-15 13:29:59.072', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6026, 'o9kHZ5TqN2EM91pXPsSNLz2-dx4I', 'atreyu', '', '13862026360', NULL, NULL, 0, '2020-10-15 13:30:03.372', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6027, 'o9kHZ5ayNuniYlX2FAAeFNkaGXEo', '東叔(^㉨^)', '', '13436820396', NULL, NULL, 0, '2020-10-15 13:30:20.451', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6028, 'o9kHZ5QUjdNK22dpIvCP23l9Gr4o', '知遇', '', '17093032020', NULL, NULL, 0, '2020-10-15 13:31:16.536', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6029, 'o9kHZ5RZjKkQ8SFfK45sjpthJnCE', 'Econear HR_Grace', '', NULL, NULL, NULL, 0, '2020-10-15 13:32:04.216', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6030, 'o9kHZ5ZaUJorlXIrNPDxSfxauFcw', '志轩', '', '15010827586', NULL, NULL, 0, '2020-10-15 13:33:58.084', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6031, 'o9kHZ5Zt2t2gR8g6bsOIKzPTymRs', '🎀germaine🎀', '', '18516614855', NULL, NULL, 0, '2020-10-15 13:42:55.145', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6032, 'o9kHZ5csMwXBJgSduHGRcmzrHKk4', '马成功', '', '13910906162', NULL, NULL, 0, '2020-10-15 13:43:17.560', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6033, 'o9kHZ5dcsAoOEshxJ_lo7w6lZ2xs', 'zoe', '', '18768177858', NULL, NULL, 0, '2020-10-15 13:49:40.623', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6034, 'o9kHZ5ZWgxwEMi4mg9KVXQ0XHK6c', '宁溘死以流亡兮', '', '18510786711', NULL, NULL, 0, '2020-10-15 14:01:12.539', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6035, 'o9kHZ5cZz-SjCidQsbinFos_yI7s', '林。', '', '18705040300', NULL, NULL, 0, '2020-10-15 14:03:02.412', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6036, 'o9kHZ5Xw_Nd3-ni7k-PZsJD6dGbI', 'Anan', '', '15848798130', NULL, NULL, 0, '2020-10-15 14:03:52.357', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6037, 'o9kHZ5d5ln_4rpuunuCdR_aEHk18', 'Claire.J阿章🦑', '', '15651716250', NULL, NULL, 0, '2020-10-15 14:07:17.073', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6038, 'o9kHZ5UlucqPI8y2u-5S_ohaqMyU', 'Tony,刘跃生', '', NULL, NULL, NULL, 0, '2020-10-15 14:15:24.253', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6039, 'o9kHZ5YuJhtDJ7oEgcK1PI-ixwLQ', '王小君', '', '18910526134', NULL, NULL, 0, '2020-10-15 14:54:41.617', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6040, 'o9kHZ5UKlTTyFUOWc4q-Zyz88X60', '璠', '', '15210361561', NULL, NULL, 0, '2020-10-15 15:14:04.661', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6041, 'o9kHZ5QZ8BDnYJ9oxMiPULNvSCug', '邢越', '', '13366203998', NULL, NULL, 0, '2020-10-15 15:15:31.128', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6042, 'o9kHZ5S0Y0VLLj-zAKJze8kgGs3Y', '黄明月', '', '18801352878', NULL, NULL, 0, '2020-10-15 15:42:53.397', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6043, 'o9kHZ5U6m4F4r6GAhxqJqQjnjeXA', '不愧是我', '', '18510694664', NULL, NULL, 0, '2020-10-15 18:09:38.084', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6044, 'o9kHZ5StA-tWJzmPYlxxCkaZqExo', 'laughing.', '', '13777419035', NULL, NULL, 0, '2020-10-15 18:14:49.043', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6045, 'o9kHZ5YC-j3zP8FVzkwE6XSwa5Z4', 'STR', '', '15142314727', NULL, NULL, 0, '2020-10-15 20:18:15.446', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6046, 'o9kHZ5UUA1HK6SVAb8HSIXHR32Gc', '东篱南山品牌设计', '', '18201500208', NULL, NULL, 0, '2020-10-15 21:27:57.735', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6047, 'o9kHZ5aWdu_g9cK5LBqDEvLnfRCo', 'zyn', '', '18601279221', NULL, NULL, 0, '2020-10-15 22:18:17.588', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6048, 'o9kHZ5Xh_wAkgdo_dATMDt6FI4BA', 'May🎨', '', '18817576509', NULL, NULL, 0, '2020-10-15 22:32:21.458', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6049, 'o9kHZ5TiHQ3Q_GgHB76D183Xd7K0', '姚颖', '', '13671146571', NULL, NULL, 0, '2020-10-15 23:14:14.207', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6050, 'o9kHZ5WMjdOJQRGSOyL2q5hNnY84', 'argo', '', NULL, NULL, NULL, 0, '2020-10-16 02:55:13.184', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6051, 'o9kHZ5cx93NXGDly1XH7Pu6QUWj4', '杨建宏@HowWork', '', '18611928615', NULL, NULL, 0, '2020-10-16 06:17:38.823', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6052, 'o9kHZ5QH4Gc0JoaJpeL3Jh66XbzU', 'Hoody', '', '17611669300', NULL, NULL, 0, '2020-10-16 08:05:42.804', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6053, 'o9kHZ5Y7yNwkfO5_7cwyAYyd2LI8', 'Wangyuan', '', '18616193720', NULL, NULL, 0, '2020-10-16 10:15:17.180', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6054, 'o9kHZ5XKgNbLXZ_zkYHfJf1dICb8', '雪迈', '', '13456966710', NULL, NULL, 0, '2020-10-16 10:39:06.259', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6055, 'o9kHZ5dBHYJtup_KMgy5dOcS_8_k', '王小央ོ', '', '13605813737', NULL, NULL, 0, '2020-10-16 10:40:30.389', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6056, 'o9kHZ5WeKpsNg7_FNIA98s75a2Qs', '🎀Le Papillon🎀', '', '13735494363', NULL, NULL, 0, '2020-10-16 10:59:27.159', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6057, 'o9kHZ5Y6wsPRyMOC63kKey4owdR8', 'Annie 毛豆', '', '18668075325', NULL, NULL, 0, '2020-10-16 12:11:32.050', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6058, 'o9kHZ5cIKTp73Q7ZN_ajO4Vr4q28', '光阴的故事', '', NULL, NULL, NULL, 0, '2020-10-16 19:15:19.446', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6059, 'o9kHZ5QL69k2nLDDThhseF1QB5io', '王超', '', '15810804929', NULL, NULL, 0, '2020-10-16 19:39:32.491', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6060, 'o9kHZ5eSfFSy0dz0mupU1RWNPYLs', '神经蛙', '', NULL, NULL, NULL, 0, '2020-10-16 19:47:13.112', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6061, 'o9kHZ5YA_ixoKHoFXzuOG-Nw70Vg', 'Timo', '', '18311080582', NULL, NULL, 0, '2020-10-16 20:08:04.963', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6062, 'o9kHZ5erIAWc_4yEo1-wdjGPK1xE', '李文波', '', '18223455359', NULL, NULL, 0, '2020-10-17 10:02:28.124', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6063, 'o9kHZ5S7R6APGhZ_wq9grYH6Ju20', '谷堆那儿', '', '13525516792', NULL, NULL, 0, '2020-10-17 12:14:59.090', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6064, 'o9kHZ5RDgsks3dDDCPHQBBhIWT8s', 'nora', '', '13693065582', NULL, NULL, 0, '2020-10-18 18:26:51.397', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6065, 'o9kHZ5Zeaaibgk4hSLXbiqG7aGKA', '怡然', '', NULL, NULL, NULL, 0, '2020-10-18 19:11:53.474', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6066, 'o9kHZ5fjtInoeZsVD9MuUdiNUtkQ', '陈碧天', '', NULL, NULL, NULL, 0, '2020-10-18 20:55:40.345', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6067, 'o9kHZ5WezwKF9a1jP6tLOOHreAnM', '品牌创新@李前承', '', '18610441168', NULL, NULL, 0, '2020-10-19 13:31:57.857', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6068, 'o9kHZ5ccRpycz_zqJtNRmwrj8PjA', '乔儿天堂', '', '18610846949', NULL, NULL, 0, '2020-10-19 16:22:11.376', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6069, 'o9kHZ5Yj2B3U3m7T9k9zM9oQNMeU', '🍓🍓Candice🍫🍫', '', '15158001797', NULL, NULL, 0, '2020-10-19 16:48:38.535', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6070, 'o9kHZ5be3rTe35Hqg_F8UoeSbt7M', 'CAIAMOON.', '', '13312179561', NULL, NULL, 0, '2020-10-19 17:22:07.063', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6071, 'o9kHZ5RWNfZO4f6symIcB8RI3hKM', '何同学', '', '18848427790', NULL, NULL, 0, '2020-10-19 21:31:05.655', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6072, 'o9kHZ5QBsuqVPEdEDR-RXO0tsGx4', '刘育轩', '', NULL, NULL, NULL, 0, '2020-10-20 06:58:01.697', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6073, 'o9kHZ5chxhP-xqTo5gAiWDWeS80Y', 'Forward', '', NULL, NULL, NULL, 0, '2020-10-20 09:30:37.870', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6074, 'o9kHZ5dsKi5CuV7EeJTZSedV-VxY', '梁东东', '', '18758063850', NULL, NULL, 0, '2020-10-20 09:34:01.544', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6075, 'o9kHZ5c14pDH-9fPWt3xWHxw1DkU', '七月WYJ', '', '15801255241', NULL, NULL, 0, '2020-10-20 10:21:52.288', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6076, 'o9kHZ5VdC7Ffni3JT9ovaM7PmF5Q', '窦恒山', '', '13412133311', NULL, NULL, 0, '2020-10-20 14:57:12.294', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6077, 'o9kHZ5T4ikAMQqiHIDmbbF7qQzpo', '邓一些', '', '18200261273', NULL, NULL, 0, '2020-10-20 19:43:55.867', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6078, 'o9kHZ5cskpw2QgrP3OfCzVhbtCYU', 'Li', '', '13152682260', NULL, NULL, 0, '2020-10-21 12:54:15.956', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6079, 'o9kHZ5fmnSLkAPuXeA07GXI7NYW8', '静下来', '', '13588198469', NULL, NULL, 0, '2020-10-21 13:42:40.400', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6080, 'o9kHZ5eFhG2tkfkTi68RmE-PfVoI', 'ivy Han', '', '13911797317', NULL, NULL, 0, '2020-10-21 16:54:12.717', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6081, 'o9kHZ5aODo7phr4bZXXOlqXJPhxs', '方静', '', '18511879025', NULL, NULL, 0, '2020-10-21 17:36:53.080', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6082, 'o9kHZ5euKXjhww__L1eopUjp2acY', '王慧龙', '', '18518889381', NULL, NULL, 0, '2020-10-21 18:09:42.486', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6083, 'o9kHZ5TZrRTIVqLTI8uJ8MOdk8Ns', '黄旭', '', '15801054575', NULL, NULL, 0, '2020-10-21 18:15:27.471', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6084, 'o9kHZ5TMuZ9NG-Xy1qH700k02d-M', '九日', '', '15545140725', NULL, NULL, 0, '2020-10-21 18:17:53.517', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6085, 'o9kHZ5UHeNCKj0ZlPV8jzDNF4ps4', '莹冰瑾儿', '', '18611488140', NULL, NULL, 0, '2020-10-21 18:38:56.868', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6086, 'o9kHZ5QwB6CqQbXJFm1pne_HNB9s', '王振', '', '17607092191', NULL, NULL, 0, '2020-10-21 22:00:17.158', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6087, 'o9kHZ5bFfm-435DRMTZMm7r7GhYk', 'Marlboro', '', '17710859219', NULL, NULL, 0, '2020-10-21 22:44:12.802', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6088, 'o9kHZ5SL1KDlmOhX-wFjWgEwxiCI', '晨', '', '15110035921', NULL, NULL, 0, '2020-10-22 12:33:39.880', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6089, 'o9kHZ5ZgmiDFLiVIg6ZLEJkziUeo', '宋彬', '', '18611408328', NULL, NULL, 0, '2020-10-22 15:09:45.181', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6090, 'o9kHZ5WzJSXsP1HAiVrxsRU4XMqM', '张天翼', '', '18618359599', NULL, NULL, 0, '2020-10-22 17:13:05.862', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6091, 'o9kHZ5e7-JhZyKP2Lk89qsIglyDM', 'Samuel', '', '17610398193', NULL, NULL, 0, '2020-10-22 17:17:53.262', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6092, 'o9kHZ5UpTLrxeZjPArWCf5431hwI', '曲玉杰', '', '17790005266', NULL, NULL, 0, '2020-10-22 19:14:42.206', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6093, 'o9kHZ5QOkdnUDen2t0N_cP8Ow_L0', '王晶', '', '15801573218', NULL, NULL, 0, '2020-10-23 15:49:21.891', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6094, 'o9kHZ5W9kCKAX8B4abwUAZGRC2oc', 'Jan_keor', '', '17339803665', NULL, NULL, 0, '2020-10-25 21:45:21.259', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6095, 'o9kHZ5QpwOB_9eRda_QD906-aMh0', 'Aser Uni.  刘浩', '', '15901210350', NULL, NULL, 0, '2020-10-26 10:50:08.834', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6096, 'o9kHZ5VQEZwk9GG0Bn9-FLVjZ2jU', '欢乐马', '', NULL, NULL, NULL, 0, '2020-10-26 11:28:06.733', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6097, 'o9kHZ5Q_h9-peoeViU_Xa4X6gWQI', '小南🌀', '', '17891938143', NULL, NULL, 0, '2020-10-26 12:53:37.560', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (6098, 'o9kHZ5Sqh29_Om2FSzKBbx9H2_vY', 'echo-做灵魂有香气的女人', '', '13911526263', NULL, NULL, 0, '2020-10-27 13:17:22.890', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8000, 'o9kHZ5Yt_39W__dkoRo45v4Nvz5k', '海欧', '', '15910991142', NULL, NULL, 0, '2020-10-15 08:47:38.050', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8001, 'o9kHZ5Splf1tDxb1bq6SkiifdgbY', '海康', '', '13957101219', NULL, NULL, 0, '2020-10-15 10:52:41.777', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8002, 'o9kHZ5U36_PiSxr4l9A-Zk1HHbjQ', '春雪', '', '13810990272', NULL, NULL, 0, '2020-10-15 11:00:08.231', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8003, 'o9kHZ5RSGoFXzwgzt08zzuDoqTTg', '职小氧', '', '13241937740', NULL, NULL, 0, '2020-10-15 11:46:44.478', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8004, 'o9kHZ5XECxlKN0fjUr8YzpGn8DgE', 'QwwwtQ.Garlic', '', '15684235313', NULL, NULL, 0, '2020-10-15 11:52:37.740', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8005, 'o9kHZ5QSAnQE2C7gdAHkbzGnBWe0', 'Ashley', '', '18622048296', NULL, NULL, 0, '2020-10-15 11:58:23.763', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8006, 'o9kHZ5eAx4FTngyi4_IUhm08B7os', 'Wei魏Xin欣', '', '13911096678', NULL, NULL, 0, '2020-10-15 12:00:23.294', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8007, 'o9kHZ5a5C3EkPuKuDUjYXUUYq5Vs', 'XIBEI', '', NULL, NULL, NULL, 0, '2020-10-15 12:02:36.761', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8008, 'o9kHZ5Zay2OjWk7xhpW65TyMGqEc', 'Sabrina 随心而动🌻🌻', '', '18911867225', NULL, NULL, 0, '2020-10-15 12:03:47.623', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8009, 'o9kHZ5ZRLsDJelYcXYFTgtGv_AvY', 'max', '', '18660787032', NULL, NULL, 0, '2020-10-15 12:05:08.774', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8010, 'o9kHZ5Wpcr4eh3twfdgmuTJm-QNw', 'mikeliang', '', NULL, NULL, NULL, 0, '2020-10-15 12:09:58.768', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8011, 'o9kHZ5cqND4NF0UiVH-8qM6LlJ48', '梅子·王', '', '13601171808', NULL, NULL, 0, '2020-10-15 12:17:07.382', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8012, 'o9kHZ5WnhjI41Ee-drMjMaym3QTw', 'Soymilk_伟伟', '', '15011403503', NULL, NULL, 0, '2020-10-15 12:46:39.038', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8013, 'o9kHZ5XfKqVuDMgwolOrk9AGSigY', '四点木', '', '17338132894', NULL, NULL, 0, '2020-10-15 12:48:37.493', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8014, 'o9kHZ5ems-75qul2xCtKnScW-mmQ', '羊羊', '', '15810487960', NULL, NULL, 0, '2020-10-15 12:51:29.378', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8015, 'o9kHZ5cyMluosY-KaNSQJDJK61o0', 'Xiaoluxin', '', '17600117292', NULL, NULL, 0, '2020-10-15 12:53:05.674', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8016, 'o9kHZ5WaFozw6SsjCsWX6DXcUjKc', 'yuan', '', '15110084810', NULL, NULL, 0, '2020-10-15 13:02:05.831', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8017, 'o9kHZ5bZrKIHBklqkjlZBgzyy8_Y', '陈雪芳-招募优秀合伙人', '', '18001276699', NULL, NULL, 0, '2020-10-15 13:03:25.974', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8018, 'o9kHZ5Y9VJOpFvOD5lmUu6nPNxjE', '何艳Emma', '', '13814898564', NULL, NULL, 0, '2020-10-15 13:04:07.673', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8019, 'o9kHZ5Yinf3pw9GctFzvM99c_i4o', '见清丶', '', '13263113883', NULL, NULL, 0, '2020-10-15 13:05:53.191', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8020, 'o9kHZ5fCbzXDdC3nCiu2NHwhQngA', 'lzm', '', '18600185840', NULL, NULL, 0, '2020-10-15 13:13:13.498', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8021, 'o9kHZ5Vi7GAYp7iXwAYx5FdsgchA', 'Molly', '', '17717373289', NULL, NULL, 0, '2020-10-15 13:14:06.707', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8022, 'o9kHZ5dmcHxDQoO9p0nqVOjViNK8', '小盆胡同26号', '', NULL, NULL, NULL, 0, '2020-10-15 13:14:35.505', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8023, 'o9kHZ5ZlDCbU1VmNsSqNzNOsB7uU', '尹東亮', '', '13953167399', NULL, NULL, 0, '2020-10-15 13:18:59.013', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8024, 'o9kHZ5ap9MsylQWZM6KnY8l9WAvk', '逸少', '', '18911599015', NULL, NULL, 0, '2020-10-15 13:22:01.841', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8025, 'o9kHZ5csbHATeip1RGHf2ur504QU', 'Rita 💅🏼', '', '15101132569', NULL, NULL, 0, '2020-10-15 13:23:24.727', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8026, 'o9kHZ5bjCJfKvsaLXY5ofjz6i17M', 'Jimmy', '', NULL, NULL, NULL, 0, '2020-10-15 13:24:37.333', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8027, 'o9kHZ5ZAdQsa-Boz4sLYEUQs_xE0', '桑雷德', '', '18614085713', NULL, NULL, 0, '2020-10-15 13:25:57.085', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8028, 'o9kHZ5b11yynTLm9z6xTwYc9FDNg', 'Klein', '', '18500202468', NULL, NULL, 0, '2020-10-15 13:26:38.279', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8029, 'o9kHZ5djhG6GLoc3L11vIFrjIBAY', '孙宇铃', '', NULL, NULL, NULL, 0, '2020-10-15 13:38:00.977', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8030, 'o9kHZ5ayuGts_Z66gToXxfM1nez0', 'Peter Wang', '', '13820979077', NULL, NULL, 0, '2020-10-15 13:38:58.530', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8031, 'o9kHZ5came_akQVS85Bjg8fO2bBw', 'cteen”', '', '15889967907', NULL, NULL, 0, '2020-10-15 13:46:40.208', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8032, 'o9kHZ5aIfsyuNJFbUd4hJC2yh09E', 'July', '', '18210566605', NULL, NULL, 0, '2020-10-15 13:53:58.223', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8033, 'o9kHZ5YTP6-fnyiNrTHILOHn0514', '岸芷汀兰', '', NULL, NULL, NULL, 0, '2020-10-15 14:04:58.059', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8034, 'o9kHZ5Zmg8SPzkc3ppDZBOo_-Df0', '刘德深', '', '15618938725', NULL, NULL, 0, '2020-10-15 14:10:45.277', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8035, 'o9kHZ5ei0upczuuO_zgbr2kesOLQ', '胥博', '', '17512588868', NULL, NULL, 0, '2020-10-15 14:25:20.498', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8036, 'o9kHZ5R5DwWpBl_F46I6sYzy_QZg', 'skcl', '', '17625193410', NULL, NULL, 0, '2020-10-15 14:31:57.354', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8037, 'o9kHZ5f4z7q0BU8hKByD3mu0YnaY', '蓝黎冲   ', '', '15122025218', NULL, NULL, 0, '2020-10-15 14:34:01.021', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8038, 'o9kHZ5TMSIIp8yIi3jugdRTvf8N8', '-', '', '13051150079', NULL, NULL, 0, '2020-10-15 14:42:30.424', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8039, 'o9kHZ5Y9W5rN0fomDHrADNwbeNT0', '卡卡卓', '', '18049362492', NULL, NULL, 0, '2020-10-15 14:58:56.237', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8040, 'o9kHZ5WCxe8U8ZKgKRAzePwvozHY', '三木', '', '13282829515', NULL, NULL, 0, '2020-10-15 15:00:48.629', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8041, 'o9kHZ5VBPcJq3M7UvLCB2bhW6L6Y', 'NancyShi', '', NULL, NULL, NULL, 0, '2020-10-15 15:05:11.158', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8042, 'o9kHZ5Uyu2WzHo6NadOQ9l1AROcA', 'momo', '', NULL, NULL, NULL, 0, '2020-10-15 15:05:47.294', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8043, 'o9kHZ5cGcu1mHG7Po8cpCrFAFNbQ', '家犬', '', '15021012515', NULL, NULL, 0, '2020-10-15 15:40:37.799', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8044, 'o9kHZ5ZqJqIPv6mhqYz9B5__-Aj4', '安尼💗', '', '13071188020', NULL, NULL, 0, '2020-10-15 15:45:06.377', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8045, 'o9kHZ5Wtr8IS7lfHxnXTLHEX6qMk', 'Elly刘', '', '13701095136', NULL, NULL, 0, '2020-10-15 15:47:25.270', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8046, 'o9kHZ5WzbSH6VpOS8m7wZcV2Xoe8', '薛小婷', '', '18610373336', NULL, NULL, 0, '2020-10-15 16:55:46.325', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8047, 'o9kHZ5Xw7K2cix4I-XP8aVeRIH3Q', 'rufei.cn', '', NULL, NULL, NULL, 0, '2020-10-15 17:14:22.180', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8048, 'o9kHZ5RF-b94cisLNmL_ObfvjY20', '晖晖', '', '15810251145', NULL, NULL, 0, '2020-10-15 17:44:00.068', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8049, 'o9kHZ5RTrD4FBkiHkNDyHw_T7tag', 'Cindy', '', NULL, NULL, NULL, 0, '2020-10-15 18:06:58.045', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8050, 'o9kHZ5fc6ewii36qZQOH2KJaJxEc', '耀君_百当@Yashi', '', '18668119280', NULL, NULL, 0, '2020-10-15 18:20:18.593', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8051, 'o9kHZ5X5NkQUx9NrBKc2OoXy-RwE', '李兆彬', '', '13910974080', NULL, NULL, 0, '2020-10-15 19:13:44.295', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8052, 'o9kHZ5UL6o_9syraj2phlrm87Yv4', '兴风踏浪', '', NULL, NULL, NULL, 0, '2020-10-15 19:47:45.002', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8053, 'o9kHZ5c2WJ24CrLK-kbZO0xsymuQ', '林晓薇', '', NULL, NULL, NULL, 0, '2020-10-15 20:24:04.630', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8054, 'o9kHZ5TwruXsfBtCQsbiULSpUNFQ', 'Betty', '', '13522370887', NULL, NULL, 0, '2020-10-15 21:53:06.761', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8055, 'o9kHZ5ZqH5uCkOh-t9MjQfZC5Bj0', '马腾', '', '15501085058', NULL, NULL, 0, '2020-10-15 22:24:43.584', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8056, 'o9kHZ5d4YhemoVc7Pm3VT3V5jPvg', '叶宝珍', '', NULL, NULL, NULL, 0, '2020-10-15 23:34:45.707', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8057, 'o9kHZ5TzaTjORHYPiGafd9U6ImLo', 'xiaofan|Fruitage', '', '18510665571', NULL, NULL, 0, '2020-10-16 09:23:30.423', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8058, 'o9kHZ5Qsa9i_wSNXGa1Oc8UV4-WE', '暖暖🍃 诗里', '', '18658157611', NULL, NULL, 0, '2020-10-16 10:30:21.829', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8059, 'o9kHZ5V4--KpJ7X7ytRrnucN6Czg', 'loverose', '', '13516813035', NULL, NULL, 0, '2020-10-16 10:39:04.998', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8060, 'o9kHZ5Vwp_TIw0vKuMaALDp5zDa8', '高丽丽', '', '15658117627', NULL, NULL, 0, '2020-10-16 10:59:27.570', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8061, 'o9kHZ5Tyv85QTXYIAPziWNIbZ3d8', '文强', '', '15067158859', NULL, NULL, 0, '2020-10-16 11:03:25.129', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8062, 'o9kHZ5V97PRzxvh_MvTo8vjupA34', 'Anna', '', '18667132261', NULL, NULL, 0, '2020-10-16 11:03:43.193', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8063, 'o9kHZ5RhwfAzjbABjnu25Qj0fxLQ', '仲秋.晴', '', '13666698249', NULL, NULL, 0, '2020-10-16 11:13:52.260', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8064, 'o9kHZ5TilSzm56NklKhRB1a97Kls', 'Katy', '', '15906665740', NULL, NULL, 0, '2020-10-16 12:00:52.942', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8065, 'o9kHZ5QB44Q6-btlUMeu0oYhxXQs', '咖啡师爷', '', '13758137221', NULL, NULL, 0, '2020-10-16 13:02:59.484', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8066, 'o9kHZ5SgJe7wokNjCu1UMdgfebeI', '忘', '', NULL, NULL, NULL, 0, '2020-10-16 13:54:02.832', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8067, 'o9kHZ5cvnMmr2wl0XYod6KP_Bgr8', '不失本色', '', '15625018926', NULL, NULL, 0, '2020-10-16 19:46:16.815', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8068, 'o9kHZ5fOapU5pHbf_j2-gz8rEXZ4', 'sky', '', '13602546400', NULL, NULL, 0, '2020-10-16 21:38:23.354', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8069, 'o9kHZ5ddNO16Fhi2T39klp5eZGeI', '秋天来了', '', '18101928491', NULL, NULL, 0, '2020-10-16 21:40:46.917', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8070, 'o9kHZ5azKFG0zth5u8kvMwiNqeBM', '就不告诉你', '', '18210526775', NULL, NULL, 0, '2020-10-16 22:00:54.418', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8071, 'o9kHZ5UFG24bd4srKRK3q6n-9CYQ', '卓', '', '13911233734', NULL, NULL, 0, '2020-10-16 22:48:05.434', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8072, 'o9kHZ5RcZWY9YlwlHGjygrSFYRnU', '林慧齐', '', NULL, NULL, NULL, 0, '2020-10-17 10:26:36.938', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8073, 'o9kHZ5bcJICnWwGPXA1AF-rS_VaU', '张可依', '', '18482050775', NULL, NULL, 0, '2020-10-17 17:24:07.279', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8074, 'o9kHZ5dOnudtEu8OKulw5QbOkHog', '许志霖', '', NULL, NULL, NULL, 0, '2020-10-18 02:21:42.342', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8075, 'o9kHZ5docPJxbG3ixckmPFyoDJ84', '刘垚功', '', '18611945229', NULL, NULL, 0, '2020-10-18 06:36:27.587', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8076, 'o9kHZ5TnweRNVgRwg7WAdLqb8An8', '曦瑶', '', '13910714819', NULL, NULL, 0, '2020-10-18 14:15:51.831', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8077, 'o9kHZ5a_WhyiYPWx8x7uK9PFyXIM', '兰  丫头', '', '13718868375', NULL, NULL, 0, '2020-10-19 09:38:51.436', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8078, 'o9kHZ5UuQ-TcE6NDGKaom9pDKiSU', '劉Jian', '', '18801209353', NULL, NULL, 0, '2020-10-19 13:38:47.795', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8079, 'o9kHZ5QafacieWVZSrSjh7RjSaVA', '郭雨桦', '', '13126717896', NULL, NULL, 0, '2020-10-19 15:43:41.937', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8080, 'o9kHZ5ThzdxyVfHjVRJQPSdE18tI', 'Ivy', '', '17002200088', NULL, NULL, 0, '2020-10-19 18:54:25.007', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8081, 'o9kHZ5YejVOjqrSLV2kOdrXfR0Ws', '张帆', '', '13466765575', NULL, NULL, 0, '2020-10-19 22:41:40.408', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8082, 'o9kHZ5UpkUlk1PyOhacfUPGIxM64', '敏娟', '', '15201277758', NULL, NULL, 0, '2020-10-20 07:30:49.329', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8083, 'o9kHZ5eHhRSkV7Pam07rD3xY9gI8', 'Samson', '', NULL, NULL, NULL, 0, '2020-10-20 09:45:40.846', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8084, 'o9kHZ5ZLUd2jq26I2SiW_F9TNwaU', '周全', '', '18910357327', NULL, NULL, 0, '2020-10-20 13:20:56.077', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8085, 'o9kHZ5bq9iS7Qcbk1PTxGaLm--9c', '安东旭', '', '17326097257', NULL, NULL, 0, '2020-10-20 21:22:21.035', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8086, 'o9kHZ5d25gPTMnCNKk-JRj2e4W1E', '张艺林 John', '', '18817313655', NULL, NULL, 0, '2020-10-20 21:22:21.741', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8087, 'o9kHZ5XtSb-b2yH7wvuCv9zv7MiQ', '席蕴俊', '', '13567110082', NULL, NULL, 0, '2020-10-21 10:00:43.462', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8088, 'o9kHZ5dV2ARgC0A7jlxlvttKBW_k', '王小超@联服企业服务', '', '18817805554', NULL, NULL, 0, '2020-10-21 10:22:06.746', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8089, 'o9kHZ5fDjicFn7DP40f_ecqf5Uno', 'Bonnie', '', '18911071331', NULL, NULL, 0, '2020-10-21 15:38:22.448', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8090, 'o9kHZ5YrHV6S6YC1nvAGSMbypXBc', '思羽  Money💰', '', '18667005608', NULL, NULL, 0, '2020-10-21 15:42:52.953', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8091, 'o9kHZ5Xkb3Z77BP-gqKXLrXkX6hA', 'Tank', '', '18658856332', NULL, NULL, 0, '2020-10-21 15:43:31.887', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8092, 'o9kHZ5ZcT9ta-wGll5ieHRfGIzTQ', '夏天', '', '18614288369', NULL, NULL, 0, '2020-10-21 18:12:20.125', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8093, 'o9kHZ5f8ycvMqKK9qi0i0UXpcbeA', '钢哥', '', '13911569777', NULL, NULL, 0, '2020-10-21 19:01:40.137', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8094, 'o9kHZ5VT2hBSZuSgUW4hnl39tcXs', '无双上将潘凤', '', NULL, NULL, NULL, 0, '2020-10-21 19:45:43.455', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8095, 'o9kHZ5Sjm7grBTjVFwIx1mGyf6Iw', '韩励智', '', '18204614870', NULL, NULL, 0, '2020-10-22 11:14:39.341', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8096, 'o9kHZ5UQFGIPdCjtjZ5sPsWpZySw', '周红飞 Jason Chou', '', '15895970859', NULL, NULL, 0, '2020-10-22 12:08:16.468', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8097, 'o9kHZ5U5S9IqUye6tbOAbnqg7OUA', 'zmhui', '', '13121453800', NULL, NULL, 0, '2020-10-22 14:29:35.845', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8098, 'o9kHZ5aLOhb8qik6rdxfa1RWzwgE', '张德强', '', '15110286849', NULL, NULL, 0, '2020-10-22 14:53:19.607', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8099, 'o9kHZ5btHX_tlvf6XoNLI4WlwC7g', 'Kiki Aria Inn', '', '13389880871', NULL, NULL, 0, '2020-10-22 19:18:15.005', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8100, 'o9kHZ5YLpdb9CkFBJoE7DG01HwuM', 'A', '', NULL, NULL, NULL, 0, '2020-10-22 19:30:35.146', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8101, 'o9kHZ5aeQ1QRVkaTYSernZSEwTas', '宗鑫-华致酒行-人力资源部', '', '18713342498', NULL, NULL, 0, '2020-10-22 22:17:09.429', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8102, 'o9kHZ5ShfzG3AeZf9tKcE2bzucRM', '付剑南', '', '15801376059', NULL, NULL, 0, '2020-10-23 03:08:20.144', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8103, 'o9kHZ5V4rYRhzi0-kLR-uMERpc3Y', 'Silent', '', '18221388671', NULL, NULL, 0, '2020-10-23 14:01:18.448', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8104, 'o9kHZ5c5eAdEjSjXauc062IGENp8', '苏碧绮', '', NULL, NULL, NULL, 0, '2020-10-23 15:06:38.881', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8105, 'o9kHZ5eoze26LM5wuw8uAAov-uQA', '可能', '', '18406459159', NULL, NULL, 0, '2020-10-23 17:07:46.954', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8106, 'o9kHZ5WNk8j8XtBw7Q_lS4AsDtWA', '庾航 Hank', '', '18627566868', NULL, NULL, 0, '2020-10-26 11:52:37.694', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (8107, 'o9kHZ5fSzWNF3z-ynYVnxodRqY10', '余钟~猎头老余18702536239', '', '18702536239', NULL, NULL, 0, '2020-10-26 16:28:13.485', NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
