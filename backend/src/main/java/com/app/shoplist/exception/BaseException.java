package com.app.shoplist.exception;

import lombok.Generated;
import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final HttpStatus status;

    public BaseException(HttpStatus status, Throwable cause) {
        super(cause);
        this.status = status;
    }

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    @Generated
    public HttpStatus getStatus() {
        return this.status;
    }
}
