

-- 修改结果打分为响应速度
ALTER TABLE `evaluation_info`
CHANGE result_score response_speed DOUBLE COMMENT '响应速度（5分制）'


-- 修改过程打分为沟通能力
ALTER TABLE `evaluation_info`
CHANGE process_score  communicate_capacity DOUBLE COMMENT '沟通能力（5分制）'

-- 审核状态字段修改名称
ALTER TABLE
`evaluation_info`
CHANGE audit_status `status` TINYINT(4) DEFAULT 10




