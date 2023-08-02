package com.app.shoplist.exception.errors;

import com.app.shoplist.exception.BaseException;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends BaseException {

    public CategoryNotFoundException(String message) { super(HttpStatus.NOT_FOUND, message);}
}
