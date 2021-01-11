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

insert  into `leaf_alloc`(`biz_tag`,`max_id`,`step`,`description`,`update_time`) values ('advert_info',2000,10,NULL,'2021-01-07 13:51:58'),('attachment_info',160000,2000,NULL,'2021-01-08 16:09:34'),('bd_job_cate',26000,2000,NULL,'2020-11-20 19:06:24'),('bd_job_cate_detail',6000,50,NULL,'2020-11-27 19:19:01'),('bd_job_skill',16000,2000,NULL,'2020-11-22 00:03:00'),('bd_job_tag',2000,2000,NULL,'2020-10-11 10:28:30'),('collect_info',6000,2000,NULL,'2020-12-24 13:44:04'),('demand_info',70000,2000,NULL,'2020-12-28 18:20:50'),('demand_production_relation',72000,2000,NULL,'2020-12-25 15:27:30'),('display_config',48000,2000,NULL,'2020-12-29 13:15:44'),('education_info',2000,2000,NULL,'2020-11-27 19:20:39'),('employer_info',80000,2000,NULL,'2020-12-24 16:26:06'),('evaluation_info',34000,2000,NULL,'2021-01-08 16:11:14'),('evaluation_info_tag',2000,2000,NULL,'2020-10-11 10:28:30'),('evaluation_review_info',14000,2000,NULL,'2020-11-18 17:23:55'),('freelancer_info',80000,2000,NULL,'2020-12-24 16:26:06'),('leaf-segment-test',1,2000,'Test leaf Segment Mode Get Id','2020-10-11 10:28:30'),('order_amount',1001,1000,NULL,'2021-01-08 16:02:08'),('order_follow',70000,2000,NULL,'2021-01-08 16:02:08'),('order_info',60000,2000,NULL,'2021-01-08 16:02:08'),('order_info_detail',60000,2000,NULL,'2021-01-08 16:02:08'),('order_operate_info',64000,2000,NULL,'2021-01-08 16:09:34'),('partner_info',33000,2000,NULL,'2020-12-24 16:26:06'),('production_info',140000,2000,NULL,'2020-12-25 09:40:08'),('production_review_info',138000,2000,NULL,'2020-12-30 10:41:56'),('production_skill_relation',140000,2000,NULL,'2020-12-18 10:45:45'),('resume_attachment_info',13000,2000,NULL,'2020-12-28 11:56:58'),('rotation_info',2000,10,NULL,'2021-01-07 13:51:58'),('select_info',6000,2000,NULL,'2021-01-08 15:57:10'),('service_charge',1,10,NULL,'2021-01-07 13:51:59'),('sm_account',1300,50,NULL,'2021-01-05 10:48:56'),('sm_menu',1400,50,NULL,'2021-01-07 14:09:49'),('sm_org',1200,50,NULL,'2021-01-05 10:47:50'),('sm_permission',1500,50,NULL,'2021-01-07 14:09:57'),('sm_role',1150,50,NULL,'2021-01-05 10:46:59'),('sm_role_user',1350,50,NULL,'2021-01-05 10:48:56'),('sm_user',1300,50,NULL,'2021-01-05 10:48:56'),('sys_base_dict',2000,2000,NULL,'2020-10-11 10:28:30'),('sys_user',88000,2000,NULL,'2020-12-24 16:26:06'),('work_info',2000,2000,NULL,'2020-11-27 19:20:39');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
