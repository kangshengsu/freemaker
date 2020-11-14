package com.fm.business.base.enums;

/**
 * @author zhangleqi
 * @date 2020/10/9
 */
public enum EvaluationEnum {
    VERY_POOR("非常差", 0D, 1D),
    POOR("差", 1D, 2D),
    COMMON("一般", 2D, 3D),
    GOOD("满意", 3D, 4D),
    VERY_GOOD("超级棒", 4D, 5D);


    EvaluationEnum(String desc, Double minimum, Double maximum) {
        this.maximum = maximum;
        this.minimum = minimum;
        this.desc = desc;
    }

    /**
     * 最高范围
     */
    private Double maximum;
    /**
     * 最低
     */
    private Double minimum;
    /**
     * 描述
     */
    private String desc;

    public static String getEvaluationDescByScore(String score) {
        if (score == null) {
            return "";
        }
        for (EvaluationEnum value : EvaluationEnum.values()) {
            if (Double.valueOf(score) > value.getMinimum() && Double.valueOf(score) <= value.getMaximum()) {
                return value.getDesc();
            }
        }
        return "";
    }

    public Double getMaximum() {
        return maximum;
    }

    public Double getMinimum() {
        return minimum;
    }

    public String getDesc() {
        return desc;
    }
}
