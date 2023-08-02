package com.app.shoplist.exception.errors;

import com.app.shoplist.exception.BaseException;
import org.springframework.http.HttpStatus;

public class ShopListNotFoundException extends BaseException {

    public ShopListNotFoundException(String message) { super(HttpStatus.NOT_FOUND, message);}
}

