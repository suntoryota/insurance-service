package com.insurance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private String errorCode;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(boolean success, String message, String errorCode) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
    }

}
