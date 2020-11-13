

-- 修改结果打分为响应速度
ALTER TABLE `evaluation_info`
CHANGE result_score response_speed DOUBLE COMMENT '响应速度（5分制）'


-- 修改过程打分为沟通能力
ALTER TABLE `evaluation_info`
CHANGE process_score  communicate_capacity DOUBLE COMMENT '沟通能力（5分制）'


-- 添加完成时间字段
ALTER TABLE `evaluation_info`
ADD COLUMN completion_time DOUBLE COMMENT '完成时间（5分制）' AFTER communicate_capacity


-- 添加完成质量字段
ALTER TABLE `evaluation_info`
ADD COLUMN accomplish_quality DOUBLE COMMENT '完成质量（5分制）' AFTER completion_time

-- 添加评价审核状态字段
ALTER TABLE `evaluation_info`
ADD COLUMN audit_status TINYINT(4) NOT NULL DEFAULT 10 COMMENT '审核状态（10-审核中，20审核不通过，30审核通过）' AFTER description

--修改评分字段的类型长度
ALTER TABLE evaluation_info
MODIFY COLUMN total_score DOUBLE(3,2),
MODIFY COLUMN response_speed DOUBLE(3,2),
MODIFY COLUMN communicate_capacity DOUBLE(3,2),
MODIFY COLUMN completion_time DOUBLE(3,2),
MODIFY COLUMN accomplish_quality DOUBLE(3,2),
MODIFY COLUMN  recommend_score DOUBLE(3,2)