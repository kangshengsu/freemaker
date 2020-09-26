package com.fm.framework.core.enums;

/**
 * @author heshuang1
 * @date 2019/07/29
 * 是、否的枚举
 */
public enum YesNoEnum {

	No(0,"否"),

	Yes(1,"是");

	private Integer index;

	private String desc;

	public Integer getIndex() {
		return index;
	}

	public String getDesc() {
		return desc;
	}

	private YesNoEnum() {
	}

	private YesNoEnum(Integer index, String desc) {
		this.index = index;
		this.desc = desc;
	}
	
	/**
	 * 给定枚举值，获取描述
	 * */
	public static String getDescByIndex(Integer index) {
		for(YesNoEnum isValid : YesNoEnum.values()){
			if(isValid.index.equals(index)){
				return isValid.desc;
			}
		}
		return "";
	}
}
