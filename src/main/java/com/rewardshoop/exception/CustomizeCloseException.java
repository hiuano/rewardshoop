package com.rewardshoop.exception;

public class CustomizeCloseException extends CustomizeException {

    public CustomizeCloseException(String message) {
        super(message);
    }

    public CustomizeCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
