package com.example.datn_2023.config;

import com.example.datn_2023.config.exception.ServerException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
@NoArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ServerException.class)
    public ResponseEntity<Object> exception(ServerException exception) {
        String msg = exception.getMessage();
        return new ResponseEntity<>(msg, exception.getStatus());
    }
}
