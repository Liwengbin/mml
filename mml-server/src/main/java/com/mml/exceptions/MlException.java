package com.mml.exceptions;

public class MlException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MlException() {
        super();
    }

    public MlException(String message) {
        super(message);
    }

    public MlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MlException(Throwable cause) {
        super(cause);
    }

    public MlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
