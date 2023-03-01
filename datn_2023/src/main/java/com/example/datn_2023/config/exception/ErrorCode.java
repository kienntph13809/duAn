package com.example.datn_2023.config.exception;

public enum ErrorCode {
    NOT_FOUND("1000"),
    ALREADY_EXIST("1001"),
    UNEXPECTED("4000");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
