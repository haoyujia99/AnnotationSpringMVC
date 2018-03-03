package com.hao.util;

import com.hao.enums.ResponseCodeMessageMappingEnum;

/**
 * com.hao.common
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 12:07
 */
public class ResponseJsonResult<T> {

    private int code;
    private String message;
    private T data;

    public ResponseJsonResult(ResponseCodeMessageMappingEnum responseMessageMapping) {
        this.code = responseMessageMapping.getCode();
        this.message = responseMessageMapping.getMessage();
    }

    public ResponseJsonResult(ResponseCodeMessageMappingEnum responseMessageMapping, T data) {
        this.code = responseMessageMapping.getCode();
        this.message = responseMessageMapping.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseJsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
