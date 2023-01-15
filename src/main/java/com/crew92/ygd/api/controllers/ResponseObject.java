package com.crew92.ygd.api.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class ResponseObject<T> {

    public boolean success;
    public T data;
    public T error;
    public String message;

    public ResponseObject(T data) {
        this.success = true;
        this.data = data;
    }

    public ResponseObject(T error, String message) {
        this.success = false;
        this.error = error;
        this.message = message;
    }
}
