
-- 新增是否推荐列
ALTER TABLE `select_info`
ADD COLUMN is_recommend TINYINT(4) DEFAULT 20 COMMENT '是否上推荐' AFTER keyword