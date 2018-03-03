package com.hao.enums;

/**
 * com.hao.enums
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 16:01
 */
public enum ResponseCodeMessageMappingEnum {

    SUCCESS(0, "SUCCESS"),
    FAILED(-1, "FAILED");

    private int code;
    private String message;

    ResponseCodeMessageMappingEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
