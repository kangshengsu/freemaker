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

/*Data for the table `leaf_alloc` */

insert  into `leaf_alloc`(`biz_tag`,`max_id`,`step`,`description`,`update_time`) values ('attachment_info',34000,2000,NULL,'2020-10-30 22:09:50'),('bd_job_cate',22000,2000,NULL,'2020-10-23 09:47:46'),('bd_job_skill',12000,2000,NULL,'2020-10-18 22:05:36'),('bd_job_tag',2000,2000,NULL,'2020-10-11 10:28:30'),('demand_info',14000,2000,NULL,'2020-11-04 16:45:45'),('demand_production_relation',14000,2000,NULL,'2020-11-06 21:33:17'),('display_config',20000,2000,NULL,'2020-11-05 21:14:22'),('employer_info',16000,2000,NULL,'2020-10-30 22:18:59'),('evaluation_info',6000,2000,NULL,'2020-11-05 08:55:07'),('evaluation_info_tag',2000,2000,NULL,'2020-10-11 10:28:30'),('freelancer_info',16000,2000,NULL,'2020-10-30 22:18:59'),('leaf-segment-test',1,2000,'Test leaf Segment Mode Get Id','2020-10-11 10:28:30'),('order_follow',14000,2000,NULL,'2020-10-31 12:25:22'),('order_info',14000,2000,NULL,'2020-11-05 09:38:34'),('order_info_detail',14000,2000,NULL,'2020-11-05 09:38:34'),('order_operate_info',12000,2000,NULL,'2020-11-04 12:52:22'),('production_info',30000,2000,NULL,'2020-10-30 21:51:10'),('production_review_info',20000,2000,NULL,'2020-11-01 22:24:36'),('production_skill_relation',30000,2000,NULL,'2020-10-30 22:11:50'),('sys_base_dict',2000,2000,NULL,'2020-10-11 10:28:30'),('sys_user',16000,2000,NULL,'2020-10-30 22:18:59');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
