package com.example.ChoiChoi.dto.Request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // khai bao chi ding chi bao hien thi cai nao la NON_NULL
public class ApiResponse<T> {
    private int code = 1000;  // chi dinh 1000 neu thanh cong
    private String message;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    
}
