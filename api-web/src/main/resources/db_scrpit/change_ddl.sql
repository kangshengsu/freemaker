ALTER TABLE `demand_info`
ADD COLUMN demand_type TINYINT(4) NOT NULL DEFAULT 10 COMMENT '需求类型（10-普通需求  20-悬赏招聘）' AFTER CODE;

ALTER TABLE `demand_info`
ADD COLUMN salary_range VARCHAR(32)DEFAULT '' NOT NULL COMMENT '薪资范围' AFTER company_name;

ALTER TABLE `demand_info`
ADD COLUMN education_require VARCHAR(32) DEFAULT '' NOT NULL COMMENT '学历要求' AFTER salary_range;


ALTER TABLE `demand_info`
ADD COLUMN work_experience TINYINT(4) DEFAULT NULL COMMENT '工作经验' AFTER education_require;


ALTER TABLE `demand_info`
ADD COLUMN age_require TINYINT(4) NOT NULL COMMENT '年龄要求' AFTER work_experience;

ALTER TABLE `demand_info`
ADD COLUMN recommend_award BIGINT(50) NOT NULL COMMENT '推荐奖励' AFTER age_require;

ALTER TABLE `demand_info`
ADD COLUMN recruit_amount TINYINT(10) NOT NULL COMMENT '招聘人数' AFTER recommend_award;

ALTER TABLE `demand_info`
ADD COLUMN sum_money DECIMAL(20,3) NOT NULL COMMENT '总金额' AFTER recruit_amount;
