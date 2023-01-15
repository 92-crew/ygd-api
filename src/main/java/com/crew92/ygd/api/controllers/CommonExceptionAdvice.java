package com.crew92.ygd.api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(value = Throwable.class)
    public ResponseObject<?> handleThrowable(Exception e) {
        log.error("Exception thrown !! message: {}", e.getMessage(), e);

        return new ResponseObject<>(e, e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseObject<?> handleRuntimeException(Exception e) {
        log.error("RuntimeException thrown !! message: {}", e.getMessage(), e);

        return new ResponseObject<>(e, e.getMessage());
    }
}
