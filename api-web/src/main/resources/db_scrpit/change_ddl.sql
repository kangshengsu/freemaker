
-- 首页配置表加入推荐位权重字段
ALTER TABLE `display_config`
ADD COLUMN recommend_weight BIGINT NOT NULL DEFAULT 0 COMMENT '推荐位权重' AFTER display_type

-- 添加作品权重字段
ALTER TABLE `production_info`
ADD COLUMN production_weight BIGINT NOT NULL DEFAULT 0 COMMENT '作品权重' AFTER delivery_type
