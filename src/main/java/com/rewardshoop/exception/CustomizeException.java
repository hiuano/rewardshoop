package com.rewardshoop.exception;

/**
 * 自定义异常
 */
public class CustomizeException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomizeException(String message) {
        super(message);
        this.message = message;
    }

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
}
