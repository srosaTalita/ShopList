package com.app.shoplist.exception;

import com.app.shoplist.exception.BaseException;
import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends BaseException {

    public ObjectNotFoundException(String message) { super(HttpStatus.NOT_FOUND, message);}
}
