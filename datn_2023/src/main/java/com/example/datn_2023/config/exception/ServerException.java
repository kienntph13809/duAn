package com.example.datn_2023.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerException extends RuntimeException {
    private ErrorCode errorCode;
    private HttpStatus status;

    public ServerException() {
        super(new Throwable());
    }

    public ServerException(String message) {
        super(message, new Throwable());
        this.errorCode = ErrorCode.UNEXPECTED;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ServerException(String message, HttpStatus status) {
        this(message);
        this.status = status;
    }

    public ServerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
