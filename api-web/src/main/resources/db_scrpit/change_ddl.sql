
-- 订单添加取消原因审核备注列
ALTER TABLE `order_info`
ADD COLUMN audit_info VARCHAR(255) DEFAULT '' COMMENT '取消审核备注' AFTER STATUS