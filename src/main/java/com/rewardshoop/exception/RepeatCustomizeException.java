package com.rewardshoop.exception;

public class RepeatCustomizeException extends CustomizeException {
    public RepeatCustomizeException(String message) {
        super(message);
    }

    public RepeatCustomizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
