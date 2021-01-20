package com.rafarha.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductQuantityUnavailableException extends Exception {

    public ProductQuantityUnavailableException(final String message) {
	super(message);
    }
}
