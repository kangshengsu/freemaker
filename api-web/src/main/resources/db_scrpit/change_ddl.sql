
-- 新增简历库
CREATE TABLE `resume_attachment_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '简历所属人',
  `phone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
  `freelancer_id` bigint(20) DEFAULT NULL COMMENT '所属人才',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '附件名称',
  `resume_type` varchar(50) DEFAULT NULL COMMENT '简历格式(doc,docx,pdf,jpg,png,jpeg)',
  `job_cate_id` bigint(20) DEFAULT NULL COMMENT '简历所属岗位',
  `path` varchar(255) NOT NULL COMMENT '存放路径',
  `other_path` varchar(255)  COMMENT '预览路径',
  `is_replace` tinyint(20) NOT NULL DEFAULT '20' COMMENT '是否代发服务',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `update_user` bigint(20) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（0-否，1-是）',
  `ts` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '数据库时间戳',
  PRIMARY KEY (`id`),
  KEY `IDX_FREELANCER_id` (`freelancer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112047 DEFAULT CHARSET=utf8 COMMENT='简历附件表';
-- 在id分布式自增表添加新表
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES ('resume_attachment_info',1000,2000)