package com.rafarha.ecommerce.config;

public class ErrorFormDto {

    private String field;

    private String message;

    public ErrorFormDto(final String pField, final String pMessage) {
	field = pField;
	message = pMessage;
    }

    public String getField() {
	return field;
    }

    public String getMessage() {
	return message;
    }
}
