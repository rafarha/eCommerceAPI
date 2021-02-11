package com.rafarha.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundInStockException extends Exception {
    private String fieldName;

    public ProductNotFoundInStockException(final String message, final String pFieldName) {
	super(message);
	this.fieldName = pFieldName;
    }



    public String getFieldName() {
	return fieldName;
    }

    public void setFieldName(final String pFieldName) {
	fieldName = pFieldName;
    }
}
