alter table order_info add COLUMN is_upload_voucher tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否上传凭证'after demand_id;
