package com.rafarha.ecommerce.config;

import com.rafarha.ecommerce.exception.ProductStockUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @Autowired MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFormDto> handler(MethodArgumentNotValidException pE) {
	List<ErrorFormDto> errorFormDtos = new ArrayList<>();

	pE.getBindingResult().getFieldErrors().forEach(e -> {
	    final String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
	    errorFormDtos.add(new ErrorFormDto(e.getField(), message));
	});
	return errorFormDtos;
    }

    @ExceptionHandler(ProductStockUnavailableException.class)
    public ErrorFormDto handler(ProductStockUnavailableException pE) {
	return new ErrorFormDto(null, pE.getMessage());
    }
}
