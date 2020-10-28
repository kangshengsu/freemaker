alter table order_info add COLUMN is_upload_voucher tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否上传凭证'after demand_id;

-- ----------------------------
-- Table alter for freelancer_info
-- 201028 自由职业者新增字段
-- ----------------------------
ALTER TABLE `freelancer_info`
ADD COLUMN `referral_code`  varchar(64) NULL DEFAULT '' COMMENT '推荐码' AFTER `phone`