
-- 添加评价审核意见表
CREATE TABLE `evaluation_review_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `evaluation_id` bigint(20) NOT NULL COMMENT '评价id',
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
  KEY `IDX_PRO_ID` (`evaluation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26001 DEFAULT CHARSET=utf8 COMMENT='评价审核表';

-- 设置评价审核意见表的id
INSERT INTO `leaf_alloc`(biz_tag,max_id,step) VALUES('evaluation_review_info','10000','2000')

-- 在订单表添加作品id一列
ALTER TABLE `order_info`
ADD COLUMN production_id BIGINT(20) COMMENT '作品id' AFTER `code`

-- 在评价表添加作品id一列
ALTER TABLE `evaluation_info`
ADD COLUMN production_id BIGINT(20) COMMENT '作品id' AFTER order_id

-- 加入集团
INSERT INTO `sm_org` (
  `id`,
  `name`,
  `code`,
  `incode`,
  `memo`,
  `status`,
  `parent_id`,
  `type`,
  `principal`,
  `phone`,
  `sq`,
  `create_time`,
  `create_user`,
  `update_time`,
  `update_user`,
  `ts`,
  `is_delete`
)
VALUES
  (
    1,
    '集团',
    'JT',
    'TREA',
    NULL,
    1,
    - 1,
    1,
    '王家麒',
    '15110245740',
    1,
    '2020-11-09 19:31:47',
    1,
    NULL,
    NULL,
    '2020-11-09 19:31:49.836',
    0
  )
