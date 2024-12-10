package com.insurance.exception;

public enum ErrorCode {
    INSURANCE_NOT_FOUND("INS-001", "Insurance data not found"),
    EXTERNAL_API_ERROR("INS-002", "External API error"),
    DATABASE_ERROR("INS-003", "Database operation failed");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
