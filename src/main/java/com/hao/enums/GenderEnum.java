package com.hao.enums;

/**
 * com.hao.enums
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 16:52
 */
public enum GenderEnum {

    MALE("male"),
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
