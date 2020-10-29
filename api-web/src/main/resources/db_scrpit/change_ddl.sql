-- ----------------------------
-- Table alter for order_info
-- 201029 订单表新增预算计算方式字段
-- ----------------------------
ALTER TABLE `order_info`
ADD COLUMN `budget_type`  TINYINT(4) NULL DEFAULT 0 COMMENT '预算计算方式:0:时薪,1:一口价,2:面谈' AFTER `status`
