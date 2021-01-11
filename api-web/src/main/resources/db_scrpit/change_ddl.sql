
-- 需求表添加是否已下单列
ALTER TABLE `demand_info` ADD COLUMN is_order TINYINT DEFAULT 20 COMMENT '是否已下单(10-已下单 20-未下单)' AFTER  attestation