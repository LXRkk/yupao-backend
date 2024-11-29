package com.yupi.yupao.model.enums;

/**
 * 队伍状态枚举
 *
 * @author : LXRkk
 * @date : 2024/11/25 21:13
 */
public enum TeamStatusEnum {

    /**
     * 公开
     */
    PUBLIC(0,"公开"),
    /**
     * 私有
     */
    PRIVATE(1,"私有"),
    /**
     * 加密
     */
    SECRET(2,"加密");

    private int value;
    private String text;

    TeamStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static TeamStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }
        TeamStatusEnum[] values = TeamStatusEnum.values();
        for (TeamStatusEnum teamStatusEnum : values) {
            if (teamStatusEnum.getValue() == value) {
                return teamStatusEnum;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
