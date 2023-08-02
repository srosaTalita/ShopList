package com.app.shoplist.exception;

import com.app.shoplist.exception.errors.CategoryNotFoundException;
import com.app.shoplist.exception.errors.ShopListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessage.CATEGORY_NOT_FOUND);
    }

    @ExceptionHandler(ShopListNotFoundException.class)
    public ResponseEntity<String> handleShopListNotFoundException(ShopListNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessage.SHOPLIST_NOT_FOUND);
    }
}
