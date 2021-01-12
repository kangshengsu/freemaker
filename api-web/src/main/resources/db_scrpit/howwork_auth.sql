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

/*Table structure for table `sm_account` */

DROP TABLE IF EXISTS `sm_account`;

CREATE TABLE `sm_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '账号名称',
  `password` varchar(100) NOT NULL COMMENT '账号密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1251 DEFAULT CHARSET=utf8 COMMENT='账户';

/*Data for the table `sm_account` */

insert  into `sm_account`(`id`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`,`status`,`memo`,`user_id`,`username`,`password`) values (151,0,'2020-11-12 21:51:37.042','2020-11-12 21:51:37',1,'2020-11-12 21:51:37',1,1,NULL,101,'admin','21232f297a57a5a743894a0e4a801fc3'),(1000,0,'2020-11-30 14:30:44.250','2020-11-30 14:26:21',101,'2020-11-30 14:30:44',101,1,NULL,1000,'dongyi','3e62f281e9fe8db1c5ff6cb10a1082bd'),(1001,0,'2020-11-30 18:58:30.596','2020-11-30 14:35:44',101,'2020-11-30 18:58:31',101,1,NULL,1001,'liz','56d50a506cbbfb4a918a26898a51c1aa'),(1002,0,'2020-12-11 12:01:49.341','2020-11-30 18:52:42',101,'2020-12-11 12:01:49',101,1,NULL,1002,'wangjiaqi','fdb532886a982bdeed5904144ab8638a'),(1003,0,'2020-11-30 19:26:05.460','2020-11-30 19:26:05',101,'2020-11-30 19:26:05',101,1,NULL,1003,'wanglijie','06ef23bdc6e82fc90064ce4ae07e52da'),(1050,0,'2020-11-30 15:15:22.339','2020-11-30 15:15:22',101,'2020-11-30 15:15:22',101,1,NULL,1050,'Anna','97a9d330e236c8d067f01da1894a5438'),(1051,0,'2020-11-30 15:50:12.364','2020-11-30 15:50:12',101,'2020-11-30 15:50:12',101,1,NULL,1051,'suya','3ca7867e04913a06d28681b0a24ad74e'),(1100,0,'2020-12-01 14:35:00.814','2020-12-01 14:35:01',101,'2020-12-01 14:35:01',101,1,NULL,1100,'Bonnie','d364e14e7ee56456450cc810ceedb0f6'),(1101,0,'2020-12-01 19:48:35.668','2020-12-01 14:51:20',101,'2020-12-01 19:48:36',101,1,NULL,1101,'daidong','9e0d7e197f2bf6da198945b6f6e7efaa'),(1102,0,'2020-12-01 19:59:55.202','2020-12-01 19:47:08',101,'2020-12-01 19:59:55',101,1,NULL,1102,'crow','9e0d7e197f2bf6da198945b6f6e7efaa'),(1103,0,'2020-12-02 14:54:39.027','2020-12-02 14:54:39',101,'2020-12-02 14:54:39',101,1,NULL,1103,'lSY77','cbed39c97c07404cb3401831091c7fa3'),(1150,0,'2020-12-01 14:40:33.911','2020-12-01 14:40:34',101,'2020-12-01 14:40:34',101,1,NULL,1150,'Jenny','2fd83a1b7aafccf8bf0c76c736d1f484'),(1151,0,'2020-12-01 14:45:13.184','2020-12-01 14:45:13',101,'2020-12-01 14:45:13',101,1,NULL,1151,'Annie','6952b841701eed67ab325c276f258bec'),(1200,0,'2020-12-08 19:11:49.332','2020-12-08 19:11:49',101,'2020-12-08 19:11:49',101,1,NULL,1200,'Diamond','8f7671185d590914ac21c7511767b699'),(1250,0,'2021-01-05 10:48:56.992','2021-01-05 10:48:57',101,'2021-01-05 10:48:57',101,1,NULL,1250,'zhuli015','b9db6f57aa4a2b18910598be6a7f5830');

/*Table structure for table `sm_menu` */

DROP TABLE IF EXISTS `sm_menu`;

CREATE TABLE `sm_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `name` varchar(200) NOT NULL COMMENT '菜单名称',
  `code` varchar(100) NOT NULL COMMENT '菜单编码',
  `incode` varchar(100) NOT NULL COMMENT '内码',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父节点',
  `sq` int(5) NOT NULL COMMENT '排序',
  `href` varchar(200) NOT NULL COMMENT '菜单链接',
  `icon` varchar(100) NOT NULL COMMENT '菜单icon',
  `component` varchar(100) DEFAULT NULL COMMENT '对应组件名',
  `type` tinyint(1) NOT NULL COMMENT '菜单类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1351 DEFAULT CHARSET=utf8 COMMENT='菜单';

/*Data for the table `sm_menu` */

insert  into `sm_menu`(`id`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`,`status`,`memo`,`name`,`code`,`incode`,`parent_id`,`sq`,`href`,`icon`,`component`,`type`) values (1,0,'2020-12-07 18:16:12.175','2020-11-12 20:05:32',1,'2020-12-07 18:16:12',101,1,NULL,'领域技能','skill','OEYSTVVI',1151,2,'/job/job-info','education','skill',1),(2,0,'2020-12-07 18:16:16.089','2020-11-12 20:05:32',1,'2020-12-07 18:16:16',101,1,NULL,'岗位默认图','jobImage','OEYSAEMD',1151,3,'/job/job-image','education','job-image',1),(3,0,'2020-11-12 23:40:34.051','2020-11-12 20:05:32',1,'2021-01-07 14:09:20',101,1,NULL,'系统管理','sm','SHSR',-1,21,'/sm','lock','layout',1),(4,0,'2020-11-12 23:42:44.345','2020-11-12 20:05:32',1,'2020-11-12 23:42:44',1,1,NULL,'组织管理','org','SHSR',3,1,'/sm/org','tree','org',1),(5,0,'2020-11-12 23:42:02.966','2020-11-12 22:01:07',1,'2020-11-12 23:42:03',1,1,NULL,'用户管理','user','SHSR1111',3,2,'/sm/user','user','user',1),(6,0,'2020-11-12 23:42:19.480','2020-11-12 22:01:07',1,'2020-11-12 23:42:19',1,1,NULL,'角色管理','role','SHSR2222',3,3,'/sm/role','list','role',1),(7,0,'2020-11-12 23:42:30.924','2020-11-12 22:01:07',1,'2020-11-12 23:42:31',1,1,NULL,'菜单管理','menu','SHSR3333',3,4,'/sm/menu','tree-table','menu',1),(101,0,'2020-12-07 18:16:19.599','2020-11-12 20:55:57',1,'2020-12-07 18:16:20',101,1,NULL,'标签管理','jobTag','OEYSFJYX',1151,4,'/tag/job-tag-info','tree-table','job-tag',1),(102,0,'2020-11-13 01:00:13.786','2020-11-12 20:57:03',1,'2020-11-13 01:00:14',1,1,NULL,'人才管理','freelancer','BYQRZWSA',253,5,'/freelancer-info','people','freelancer',1),(103,0,'2020-11-13 01:00:31.987','2020-11-12 20:58:36',1,'2020-11-13 01:00:32',1,1,NULL,'雇佣者管理','employer','LGWJXEQZ',254,6,'/employer/employer-info','peoples','employer',1),(104,0,'2020-12-07 18:16:26.439','2020-11-12 20:59:33',1,'2020-12-07 18:16:26',101,1,NULL,'需求管理','demand','OLYLZTAF',1101,8,'/demand/demand-info','excel','demand',1),(105,0,'2020-12-07 18:16:38.795','2020-11-12 21:00:45',1,'2020-12-07 18:16:39',101,1,NULL,'订单管理','order','OLYLNFRN',1101,9,'/order/order-info','shopping','order',1),(106,0,'2020-11-13 01:00:41.720','2020-11-12 21:01:20',1,'2020-11-13 01:00:42',1,1,NULL,'作品管理','production','XNOZJUJW',257,10,'/production/production-info','zip','production',1),(107,0,'2020-11-16 14:06:18.790','2020-11-12 21:02:08',1,'2021-01-07 14:09:20',101,1,NULL,'配置管理','config','NQQF',-1,20,'/config/diplay-config','lock','layout',1),(110,1,'2020-12-07 17:47:23.138','2020-11-12 20:05:32',1,'2020-12-07 17:46:01',101,1,NULL,'领域技能根','skillroot','SHSR',-1,4,'/job','','layout',1),(251,1,'2020-12-07 17:47:28.450','2020-11-13 00:32:54',1,'2020-12-07 17:46:01',101,1,NULL,'岗位默认图根','jobImageRoot','VRBP',-1,7,'/jobImageRoot','404','layout',1),(252,1,'2020-12-07 17:47:30.596','2020-11-13 00:42:24',1,'2020-12-07 17:46:01',101,1,NULL,'标签管理根','jobTagRoot','RGVT',-1,8,'/jobTagRoot','edit','layout',1),(253,0,'2020-11-13 12:10:02.152','2020-11-13 00:43:13',1,'2020-12-07 17:46:01',101,1,NULL,'人才管理根','freelancerRoot','BYQR',-1,9,'/freelancerRoot','','layout',1),(254,0,'2020-11-13 12:10:07.712','2020-11-13 00:44:09',1,'2020-12-07 17:46:01',101,1,NULL,'雇佣者管理根','employerRoot','LGWJ',-1,11,'/employerRoot','','layout',1),(255,1,'2020-12-07 17:49:01.741','2020-11-13 00:45:00',1,'2020-12-07 17:46:01',101,1,NULL,'需求管理根','demandRoot','VRGP',-1,10,'/demandRoot','example','layout',1),(256,1,'2020-12-07 17:48:59.834','2020-11-13 00:46:08',1,'2020-12-07 17:46:01',101,1,NULL,'订单管理根','orderRoot','NAIN',-1,6,'/orderRoot','excel','layout',1),(257,0,'2020-11-13 12:10:20.408','2020-11-13 00:46:51',1,'2020-12-07 17:46:01',101,1,NULL,'作品管理根','productionRoot','XNOZ',-1,12,'/productionRoot','','layout',1),(258,0,'2020-11-13 01:05:34.746','2020-11-13 00:49:17',1,'2020-11-13 00:49:17',1,1,NULL,'首页展示配置','displayConfig','NQQFBAEW',107,1,'/diplay-config/diplay-config','nested','displayConfig',1),(501,0,'2020-11-14 13:43:51.552','2020-11-14 13:43:52',101,'2020-11-14 13:43:52',101,1,NULL,'新增按钮','add','SHSR3333EUTG',7,1,'add','','',0),(551,0,'2020-11-15 14:16:00.104','2020-11-15 14:16:00',1,'2020-12-07 17:48:30',101,1,NULL,'支付','pay','OLYLNFRNRCTI',105,2,'pay','','button',0),(552,0,'2020-11-15 14:34:37.082','2020-11-15 14:34:37',1,'2020-12-07 17:48:30',101,1,NULL,'查看','detail','OLYLNFRNCRRT',105,1,'detail','','button',0),(601,0,'2020-11-16 14:07:34.868','2020-11-16 14:07:35',101,'2020-12-07 17:46:01',101,1,NULL,'评价审核根','evaluationRoot','OXSF',-1,13,'/evaluationRoot','nested','layout',1),(602,0,'2020-11-16 14:08:29.747','2020-11-16 14:08:30',101,'2020-11-16 14:08:30',101,1,NULL,'评价审核','evaluationAudit','OXSFYWRF',601,1,'/evaluation/evaluation-info','eye-open','evaluation-audit',1),(603,0,'2020-11-16 14:12:54.883','2020-11-16 14:12:16',101,'2020-12-07 17:46:01',101,1,NULL,'人才作品管理根','talentProductionRoot','HMKD',-1,14,'/talentProductionRoot','dashboard','layout',1),(604,0,'2020-11-16 14:13:36.509','2020-11-16 14:13:37',101,'2020-11-16 14:13:37',101,1,NULL,'人才作品管理','talentProduction','HMKDTFQY',603,1,'/talentProduction/talentProduction-info','dashboard','talentProduction',1),(1000,1,'2020-12-07 17:47:19.756','2020-11-27 19:45:44',101,'2020-11-27 19:45:44',101,1,NULL,'一级类目管理根','firstJobCateRoot','UCCF',-1,1,'/firstJobCateRoot','example','layout',1),(1001,0,'2020-12-07 18:16:05.626','2020-11-27 19:48:22',101,'2020-12-07 18:16:06',101,1,NULL,'一级类目管理','firstJobCate','OEYSOLIU',1151,1,'/jobCate/firstJobCate','documentation','firstJobCate',1),(1002,0,'2020-11-27 20:03:23.490','2020-11-27 20:03:23',101,'2020-11-27 20:03:23',101,1,NULL,'审核','examine','HMKDTFQYXHZQ',604,1,'examine','','',0),(1003,0,'2020-11-27 20:04:01.815','2020-11-27 20:04:02',101,'2020-11-27 20:04:02',101,1,NULL,'推荐人搜索','referrerSearch','HMKDTFQYHUQE',604,2,'referrerSearch','','',0),(1004,0,'2020-12-02 10:49:40.052','2020-11-27 20:08:05',101,'2020-12-02 10:49:40',101,1,NULL,'人才分配','freelancerdistr','UXTOGUQC',1052,1,'/freelancerDistribution/freelancerDistribution-info','peoples','freelancerDistribution',1),(1050,1,'2020-12-07 17:47:25.561','2020-11-27 19:46:20',101,'2020-12-07 17:46:01',101,1,NULL,'二级类目管理根','secondJobCateRoot','XJVV',-1,5,'/secondJobCateRoot','excel','layout',1),(1051,0,'2020-12-07 18:16:01.748','2020-11-27 19:49:20',101,'2020-12-07 18:16:02',101,1,NULL,'二级类目管理','secondJobCate','OEYSZFHB',1151,1,'/jobCate/secondJobCate','example','secondJobCate',1),(1052,0,'2020-12-02 10:49:30.910','2020-11-27 20:07:26',101,'2020-12-07 17:46:01',101,1,NULL,'人才分配根','freelancerDistrRoot','UXTO',-1,15,'/freelancerDistrRoot','peoples','layout',1),(1100,0,'2020-12-04 15:44:28.245','2020-12-04 15:41:08',101,'2020-12-07 17:46:01',101,1,NULL,'人才结算根','freelancerSettleR','ITPC',-1,16,'/freelancerSettleR','money','layout',1),(1101,0,'2020-12-07 17:48:13.370','2020-12-07 17:48:13',101,'2020-12-07 17:48:13',101,1,NULL,'订单需求管理','orderDemandRoot','OLYL',-1,2,'/orderDemandRoot','component','layout',1),(1150,0,'2020-12-04 15:43:21.626','2020-12-04 15:43:22',101,'2020-12-04 15:43:22',101,1,NULL,'人才结算','freelancerSettlement','ITPCYIOD',1100,1,'/freelancerSettlement/freelancerSettlement-info','money','freelancerSettlement',1),(1151,0,'2020-12-07 17:46:01.337','2020-12-07 17:46:01',101,'2020-12-07 17:46:01',101,1,NULL,'类目管理','jobCateRoot','OEYS',-1,3,'/jobCateRoot','chart','layout',1),(1200,0,'2020-12-11 21:48:34.664','2020-12-11 21:48:35',101,'2020-12-11 21:48:35',101,1,NULL,'合伙人人才管理根','partnerFreelancerR','NKZD',-1,17,'/partnerFreelanerR','','layout',1),(1201,0,'2020-12-11 21:49:35.943','2020-12-11 21:49:36',101,'2020-12-11 21:49:36',101,1,NULL,'合伙人人才管理','partnerFreelancer','NKZDGDSH',1200,1,'/partnerFreelancer/partnerFreelancer-info','international','partnerFreelancer',1),(1202,0,'2020-12-13 16:56:29.209','2020-12-13 16:56:29',101,'2020-12-13 16:56:29',101,1,NULL,'简历管理','resume','TYVOYRJK',1250,1,'/resume/resume-info','excel','resume',1),(1250,0,'2020-12-13 16:55:40.362','2020-12-13 16:55:40',101,'2020-12-13 16:55:40',101,1,NULL,'简历管理根','resumeRoot','TYVO',-1,18,'/resumeRoot','edit','layout',1),(1300,0,'2021-01-07 14:09:19.520','2021-01-07 14:09:20',101,'2021-01-07 14:09:20',101,1,NULL,'服务费配置管理根','serviceChargeRoot','GJTA',-1,19,'/serviceChargeRoot','guide','layout',1),(1350,0,'2021-01-07 14:09:49.212','2021-01-07 14:09:49',101,'2021-01-07 14:09:49',101,1,NULL,'服务费配置管理','serviceCharge','GJTANQVK',1300,1,'/serviceCharge/serviceCharge-info','guide','serviceCharge',1);

/*Table structure for table `sm_org` */

DROP TABLE IF EXISTS `sm_org`;

CREATE TABLE `sm_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织ID',
  `name` varchar(200) NOT NULL COMMENT '组织名称',
  `code` varchar(100) NOT NULL COMMENT '组织编码',
  `incode` varchar(50) NOT NULL COMMENT '组织树形内码',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点ID',
  `type` tinyint(2) NOT NULL COMMENT '类型',
  `principal` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(50) DEFAULT NULL COMMENT '负责人电话',
  `sq` int(5) NOT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1151 DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sm_org` */

insert  into `sm_org`(`id`,`name`,`code`,`incode`,`memo`,`status`,`parent_id`,`type`,`principal`,`phone`,`sq`,`create_time`,`create_user`,`update_time`,`update_user`,`ts`,`is_delete`) values (1,'集团','JT','TREA',NULL,1,-1,1,'王家麒','15110245740',1,'2020-11-09 19:31:47',1,NULL,NULL,'2020-11-09 19:31:49.836',0),(1000,'董毅团队','DYTeam','TREAOFKX','',1,1,3,'董毅','',1,'2020-11-30 14:21:29',101,'2020-11-30 14:21:29',101,'2020-11-30 14:21:29.439',0),(1001,'宋彬团队','STeam','TREAXSZM','',1,1,3,'宋彬','',2,'2020-11-30 18:51:05',101,'2020-11-30 19:16:04',101,'2020-11-30 19:16:03.548',0),(1002,'立杰团队','LJTeam','TREAMWKR','',1,1,3,'王立杰','',3,'2020-11-30 19:24:23',101,'2020-11-30 19:24:23',101,'2020-11-30 19:24:23.181',0),(1050,'Bonnie团队','BonnieTeam','TREABDBX','',1,1,3,'Bonnie','',4,'2020-12-01 14:33:56',101,'2020-12-01 14:33:56',101,'2020-12-01 14:33:56.442',0),(1051,'Jenny团队','JennyTeam','TREANLJD','',1,1,3,'Jenny','',5,'2020-12-01 14:40:07',101,'2020-12-01 14:40:07',101,'2020-12-01 14:40:06.501',0),(1052,'代冬团队','DDTeam','TREANXCS','',1,1,3,'代冬','',7,'2020-12-01 14:50:49',101,'2020-12-01 14:50:49',101,'2020-12-01 14:50:48.552',0),(1100,'Annie团队','AnnieTeam','TREAVFLC','',1,1,3,'Annie','',6,'2020-12-01 14:44:43',101,'2020-12-01 14:44:43',101,'2020-12-01 14:44:42.634',0),(1150,'合力东方','helidongfang','TREARLFZ','',1,1,3,'朱卫东','',8,'2021-01-05 10:47:51',101,'2021-01-05 10:47:51',101,'2021-01-05 10:47:50.730',0);

/*Table structure for table `sm_permission` */

DROP TABLE IF EXISTS `sm_permission`;

CREATE TABLE `sm_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1452 DEFAULT CHARSET=utf8 COMMENT='角色菜单权限';

/*Data for the table `sm_permission` */

insert  into `sm_permission`(`id`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`,`status`,`memo`,`role_id`,`menu_id`) values (51,0,'2020-11-12 22:04:51.116','2020-11-12 22:04:51',1,'2020-11-12 22:04:51',1,1,NULL,1,3),(52,0,'2020-11-12 22:04:51.116','2020-11-12 22:04:51',1,'2020-11-12 22:04:51',1,1,NULL,1,4),(53,0,'2020-11-12 22:04:51.116','2020-11-12 22:04:51',1,'2020-11-12 22:04:51',1,1,NULL,1,5),(54,0,'2020-11-12 22:04:51.116','2020-11-12 22:04:51',1,'2020-11-12 22:04:51',1,1,NULL,1,6),(55,0,'2020-11-12 22:04:51.116','2020-11-12 22:04:51',1,'2020-11-12 22:04:51',1,1,NULL,1,7),(201,0,'2020-11-13 00:50:26.278','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,1),(202,0,'2020-11-13 00:50:26.278','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,2),(203,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,101),(204,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,102),(205,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,103),(206,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,104),(207,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,105),(208,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,106),(209,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,107),(210,1,'2020-12-07 17:47:16.291','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,110),(211,1,'2020-12-07 17:47:16.291','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,251),(212,1,'2020-12-07 17:47:16.291','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,252),(213,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,253),(214,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,254),(215,1,'2020-12-07 17:48:54.524','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,255),(216,1,'2020-12-07 17:48:54.524','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,256),(217,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,257),(218,0,'2020-11-13 00:50:26.279','2020-11-13 00:50:26',1,'2020-11-13 00:50:26',1,1,NULL,1,258),(451,0,'2020-11-16 14:08:51.816','2020-11-16 14:08:52',101,'2020-11-16 14:08:52',101,1,NULL,1,601),(452,0,'2020-11-16 14:09:27.223','2020-11-16 14:09:27',101,'2020-11-16 14:09:27',101,1,NULL,1,602),(453,0,'2020-11-16 14:13:45.894','2020-11-16 14:13:46',101,'2020-11-16 14:13:46',101,1,NULL,1,603),(454,0,'2020-11-16 14:13:45.894','2020-11-16 14:13:46',101,'2020-11-16 14:13:46',101,1,NULL,1,604),(1000,1,'2020-12-07 17:47:16.291','2020-11-27 19:46:48',101,'2020-11-27 19:46:48',101,1,NULL,1,1000),(1001,1,'2020-12-07 17:47:16.291','2020-11-27 19:46:48',101,'2020-11-27 19:46:48',101,1,NULL,1,1050),(1002,0,'2020-11-30 14:23:59.629','2020-11-30 14:24:00',101,'2020-11-30 14:24:00',101,1,NULL,1050,604),(1003,0,'2020-11-30 14:23:59.629','2020-11-30 14:24:00',101,'2020-11-30 14:24:00',101,1,NULL,1050,1003),(1004,0,'2020-11-30 14:23:59.629','2020-11-30 14:24:00',101,'2020-11-30 14:24:00',101,1,NULL,1050,603),(1005,0,'2020-11-30 19:12:32.445','2020-11-30 19:12:32',101,'2020-11-30 19:12:32',101,1,NULL,1051,604),(1006,0,'2020-11-30 19:12:32.446','2020-11-30 19:12:32',101,'2020-11-30 19:12:32',101,1,NULL,1051,1003),(1007,0,'2020-11-30 19:12:32.446','2020-11-30 19:12:32',101,'2020-11-30 19:12:32',101,1,NULL,1051,603),(1050,0,'2020-11-27 19:49:53.567','2020-11-27 19:49:54',101,'2020-11-27 19:49:54',101,1,NULL,1,1001),(1051,0,'2020-11-27 19:49:53.567','2020-11-27 19:49:54',101,'2020-11-27 19:49:54',101,1,NULL,1,1051),(1052,0,'2020-11-27 20:04:13.490','2020-11-27 20:04:13',101,'2020-11-27 20:04:13',101,1,NULL,1,1002),(1053,0,'2020-11-27 20:04:13.490','2020-11-27 20:04:13',101,'2020-11-27 20:04:13',101,1,NULL,1,1003),(1054,0,'2020-11-27 20:08:22.091','2020-11-27 20:08:22',101,'2020-11-27 20:08:22',101,1,NULL,1,1004),(1055,0,'2020-11-27 20:08:22.091','2020-11-27 20:08:22',101,'2020-11-27 20:08:22',101,1,NULL,1,1052),(1056,0,'2020-11-30 14:22:46.114','2020-11-30 14:22:46',101,'2020-11-30 14:22:46',101,1,NULL,1000,604),(1057,0,'2020-11-30 14:22:46.114','2020-11-30 14:22:46',101,'2020-11-30 14:22:46',101,1,NULL,1000,1003),(1058,0,'2020-11-30 14:22:46.114','2020-11-30 14:22:46',101,'2020-11-30 14:22:46',101,1,NULL,1000,603),(1200,0,'2020-12-04 15:45:14.365','2020-12-04 15:45:14',101,'2020-12-04 15:45:14',101,1,NULL,1,1100),(1201,0,'2020-12-04 15:45:14.365','2020-12-04 15:45:14',101,'2020-12-04 15:45:14',101,1,NULL,1,1150),(1250,0,'2020-12-04 15:49:45.073','2020-12-04 15:49:45',101,'2020-12-04 15:49:45',101,1,NULL,1,501),(1251,0,'2020-12-04 15:49:45.073','2020-12-04 15:49:45',101,'2020-12-04 15:49:45',101,1,NULL,1,551),(1252,0,'2020-12-04 15:49:45.073','2020-12-04 15:49:45',101,'2020-12-04 15:49:45',101,1,NULL,1,552),(1300,0,'2020-12-11 21:49:53.191','2020-12-11 21:49:53',101,'2020-12-11 21:49:53',101,1,NULL,1,1200),(1301,0,'2020-12-11 21:49:53.191','2020-12-11 21:49:53',101,'2020-12-11 21:49:53',101,1,NULL,1,1201),(1350,0,'2020-12-13 16:56:44.888','2020-12-13 16:56:45',101,'2020-12-13 16:56:45',101,1,NULL,1,1202),(1351,0,'2020-12-13 16:56:44.888','2020-12-13 16:56:45',101,'2020-12-13 16:56:45',101,1,NULL,1,1250),(1400,0,'2021-01-05 10:46:59.909','2021-01-05 10:47:00',101,'2021-01-05 10:47:00',101,1,NULL,1100,105),(1401,0,'2021-01-05 10:46:59.909','2021-01-05 10:47:00',101,'2021-01-05 10:47:00',101,1,NULL,1100,552),(1402,0,'2021-01-05 10:46:59.909','2021-01-05 10:47:00',101,'2021-01-05 10:47:00',101,1,NULL,1100,1101),(1450,0,'2021-01-07 14:09:57.285','2021-01-07 14:09:57',101,'2021-01-07 14:09:57',101,1,NULL,1,1300),(1451,0,'2021-01-07 14:09:57.285','2021-01-07 14:09:57',101,'2021-01-07 14:09:57',101,1,NULL,1,1350);

/*Table structure for table `sm_role` */

DROP TABLE IF EXISTS `sm_role`;

CREATE TABLE `sm_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '角色名称',
  `type` tinyint(1) NOT NULL COMMENT '角色类型',
  `code` varchar(100) NOT NULL COMMENT '角色编码',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1101 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sm_role` */

insert  into `sm_role`(`id`,`name`,`type`,`code`,`status`,`memo`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`) values (1,'管理员',1,'admin',1,NULL,0,'2021-01-07 14:09:57.187','2020-11-11 22:30:44',1,'2021-01-07 14:09:57',101),(1000,'业务合伙制leader',2,'YWHHZadmin',1,'',0,'2020-11-30 19:11:09.822','2020-11-30 14:22:46',101,'2020-11-30 19:11:10',101),(1050,'业务合伙制员工',2,'YWHHZ_YG',1,'',0,'2020-11-30 14:23:59.625','2020-11-30 14:24:00',101,'2020-11-30 14:24:00',101),(1051,'宋彬团队管理者',2,'songbinadmin',1,'',0,'2020-11-30 19:12:32.441','2020-11-30 19:12:32',101,'2020-11-30 19:12:32',101),(1100,'订单管理角色',2,'order_manager',1,'用于给外部合作伙伴使用，主要用于创建订单',0,'2021-01-05 10:46:59.881','2021-01-05 10:47:00',101,'2021-01-05 10:47:00',101);

/*Table structure for table `sm_role_user` */

DROP TABLE IF EXISTS `sm_role_user`;

CREATE TABLE `sm_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1301 DEFAULT CHARSET=utf8 COMMENT='用户关联角色';

/*Data for the table `sm_role_user` */

insert  into `sm_role_user`(`id`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`,`status`,`role_id`,`user_id`) values (101,0,'2020-11-12 21:51:37.033','2020-11-12 21:51:37',1,'2020-11-12 21:51:37',1,1,1,101),(1000,0,'2020-11-30 14:27:20.816','2020-11-30 14:27:21',101,'2020-11-30 14:27:21',101,1,1000,1000),(1001,1,'2020-11-30 19:09:53.226','2020-11-30 18:52:42',101,'2020-11-30 18:52:42',101,1,1000,1002),(1002,0,'2020-11-30 18:58:30.598','2020-11-30 18:58:31',101,'2020-11-30 18:58:31',101,1,1050,1001),(1003,1,'2020-11-30 19:10:39.499','2020-11-30 19:09:53',101,'2020-11-30 19:09:53',101,1,1050,1002),(1004,1,'2020-11-30 19:12:51.781','2020-11-30 19:10:40',101,'2020-11-30 19:10:40',101,1,1000,1002),(1005,1,'2020-11-30 20:41:43.329','2020-11-30 19:18:35',101,'2020-11-30 19:18:35',101,1,1051,1002),(1006,0,'2020-11-30 19:26:05.458','2020-11-30 19:26:05',101,'2020-11-30 19:26:05',101,1,1000,1003),(1050,0,'2020-11-30 15:15:22.335','2020-11-30 15:15:22',101,'2020-11-30 15:15:22',101,1,1050,1050),(1051,0,'2020-11-30 15:50:12.363','2020-11-30 15:50:12',101,'2020-11-30 15:50:12',101,1,1050,1051),(1052,1,'2020-11-30 19:16:39.029','2020-11-30 19:12:52',101,'2020-11-30 19:12:52',101,1,1051,1002),(1053,1,'2020-11-30 19:18:35.375','2020-11-30 19:16:39',101,'2020-11-30 19:16:39',101,1,1050,1002),(1150,0,'2020-11-30 20:41:43.315','2020-11-30 20:41:43',101,'2020-11-30 20:41:43',101,1,1000,1002),(1151,0,'2020-12-01 14:40:33.907','2020-12-01 14:40:34',101,'2020-12-01 14:40:34',101,1,1000,1150),(1152,0,'2020-12-01 14:45:13.183','2020-12-01 14:45:13',101,'2020-12-01 14:45:13',101,1,1000,1151),(1200,0,'2020-12-01 14:35:00.810','2020-12-01 14:35:01',101,'2020-12-01 14:35:01',101,1,1000,1100),(1201,0,'2020-12-01 14:51:20.104','2020-12-01 14:51:20',101,'2020-12-01 14:51:20',101,1,1000,1101),(1202,0,'2020-12-01 19:47:08.188','2020-12-01 19:47:08',101,'2020-12-01 19:47:08',101,1,1050,1102),(1203,0,'2020-12-02 14:54:39.026','2020-12-02 14:54:39',101,'2020-12-02 14:54:39',101,1,1050,1103),(1250,0,'2020-12-08 19:11:49.328','2020-12-08 19:11:49',101,'2020-12-08 19:11:49',101,1,1050,1200),(1300,0,'2021-01-05 10:48:56.979','2021-01-05 10:48:57',101,'2021-01-05 10:48:57',101,1,1100,1250);

/*Table structure for table `sm_user` */

DROP TABLE IF EXISTS `sm_user`;

CREATE TABLE `sm_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` tinyint(1) NOT NULL COMMENT '删除标志',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `code` varchar(100) NOT NULL COMMENT '员工编码',
  `name` varchar(50) NOT NULL COMMENT '员工姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `mail` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `avatar_href` varchar(200) DEFAULT NULL COMMENT '头像',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `memo` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1251 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `sm_user` */

insert  into `sm_user`(`id`,`is_delete`,`ts`,`create_time`,`create_user`,`update_time`,`update_user`,`status`,`code`,`name`,`phone`,`mail`,`avatar_href`,`org_id`,`role_id`,`memo`) values (101,0,'2020-11-12 21:59:22.868','2020-11-12 21:51:37',1,'2020-11-12 21:59:23',51,1,'0000','管理员','13588997766','admin@haohuoer.cn','https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1,NULL,NULL),(1000,0,'2020-11-30 14:30:44.234','2020-11-30 14:26:21',101,'2020-11-30 14:30:44',101,1,'4003','董毅','13067817724',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1000,NULL,NULL),(1001,0,'2020-11-30 18:58:30.590','2020-11-30 14:35:44',101,'2020-11-30 18:58:31',101,1,'14017','Liz','18958105665',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1000,NULL,NULL),(1002,0,'2020-12-11 12:01:49.311','2020-11-30 18:52:42',101,'2020-12-11 12:01:49',101,1,'6089','宋彬','18611408328',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1001,NULL,NULL),(1003,0,'2020-11-30 19:26:05.455','2020-11-30 19:26:05',101,'2020-11-30 19:26:05',101,1,'8114','王立杰','18683567985',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1002,NULL,NULL),(1050,0,'2020-11-30 15:15:22.328','2020-11-30 15:15:22',101,'2020-11-30 15:15:22',101,1,'8062','Anna','18667132261',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1000,NULL,NULL),(1051,0,'2020-11-30 15:50:12.361','2020-11-30 15:50:12',101,'2020-11-30 15:50:12',101,1,'14058','舒雅','13454119029',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1000,NULL,NULL),(1100,0,'2020-12-01 14:35:00.803','2020-12-01 14:35:01',101,'2020-12-01 14:35:01',101,1,'8089','Bonnie','18911071331',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1050,NULL,NULL),(1101,0,'2020-12-01 19:48:35.657','2020-12-01 14:51:20',101,'2020-12-01 19:48:36',101,1,'8111','代冬','13425042945',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1052,NULL,NULL),(1102,0,'2020-12-01 19:59:55.197','2020-12-01 19:47:08',101,'2020-12-01 19:59:55',101,1,'64039','crow','18819064326',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1052,NULL,NULL),(1103,0,'2020-12-02 14:54:39.023','2020-12-02 14:54:39',101,'2020-12-02 14:54:39',101,1,'64052','lSY77','15203581444',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1052,NULL,NULL),(1150,0,'2020-12-01 14:40:33.904','2020-12-01 14:40:34',101,'2020-12-01 14:40:34',101,1,'6051','Jenny','18611928615',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1051,NULL,NULL),(1151,0,'2020-12-01 14:45:13.181','2020-12-01 14:45:13',101,'2020-12-01 14:45:13',101,1,'6057','Annie','18668075325',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1100,NULL,NULL),(1200,0,'2020-12-08 19:11:49.322','2020-12-08 19:11:49',101,'2020-12-08 19:11:49',101,1,'66119','Diamond','13672757942',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1052,NULL,NULL),(1250,0,'2021-01-05 10:48:56.970','2021-01-05 10:48:57',101,'2021-01-05 10:48:57',101,1,'7001','7001','13331138761',NULL,'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',1,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
