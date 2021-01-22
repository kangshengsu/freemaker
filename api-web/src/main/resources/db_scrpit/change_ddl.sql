
-- 订单添加取消原因审核备注列
ALTER TABLE `order_info`
ADD COLUMN audit_info VARCHAR(255) DEFAULT '' COMMENT '取消审核备注' AFTER STATUS



-- 加入是否开启Im列
ALTER TABLE `display_config`
ADD COLUMN is_show_im BOOLEAN COMMENT '是否开启Im' AFTER recommend_weight

-- 记得加入一条im初始化数据