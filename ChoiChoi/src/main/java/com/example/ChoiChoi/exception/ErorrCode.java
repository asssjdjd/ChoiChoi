package com.example.ChoiChoi.exception;

import org.aspectj.bridge.IMessage;

public enum ErorrCode {
    UNCATEGORIZED_EXECPTION(9999, "uncategorized error"),
    USERNAME_INVALID(1003, "user name must be at least 3 characters"),
    USER_EXTSTED(1002, "User existed"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    KEY_INVALID(1001,"Invalid message key"),
    ;

    public int code;
    public String message;

    ErorrCode(int code, String message) {
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
