ALTER TABLE employer_info
ADD COLUMN `company` VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '公司名称' AFTER `phone`,
ADD COLUMN `job_title` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '职务名称' AFTER `phone`;
