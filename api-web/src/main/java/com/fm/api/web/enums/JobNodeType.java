package com.fm.api.web.enums;

public enum JobNodeType {
    JOB(10, "领域"),
    POST(20, "岗位"),
    SKILL(30, "技能");

    private Integer type;
    private String name;
    JobNodeType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return this.type;
    }
}
