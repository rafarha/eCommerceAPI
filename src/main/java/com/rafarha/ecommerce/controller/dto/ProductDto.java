package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    private String description;

    private Long id;

    private String name;

    private BigDecimal price;

    public ProductDto(Product pProduct) {
	this.name = pProduct.getProductName();
	this.price = pProduct.getProductPrice();
	this.description = pProduct.getDescription();
	this.id = pProduct.getId();
    }

    public static List<ProductDto> converter(List<Product> pProductList) {
	return pProductList.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public String getDescription() {
	return description;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public BigDecimal getPrice() {
	return price;
    }
}
