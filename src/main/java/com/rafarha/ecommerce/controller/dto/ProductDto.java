package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    private Long id;

    private ProductCategoryDto productCategory;

    private String productDescription;

    private String productName;

    private UserDto productOwner;

    private BigDecimal productPrice;

    private Integer productStock;

    public ProductDto(Product pProduct) {
	this.productName = pProduct.getProductName();
	this.productStock = pProduct.getProductStock();
	this.productDescription = pProduct.getDescription();
	this.id = pProduct.getId();
	this.productPrice = pProduct.getProductPrice();
	this.productOwner = new UserDto(pProduct.getProductOwner());
	this.productCategory = new ProductCategoryDto(pProduct.getProductCategory());
    }

    public static List<ProductDto> converter(List<Product> pProductList) {
	return pProductList.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Long getId() {
	return id;
    }

    public ProductCategoryDto getProductCategory() {
	return productCategory;
    }

    public String getProductDescription() {
	return productDescription;
    }

    public String getProductName() {
	return productName;
    }

    public UserDto getProductOwner() {
	return productOwner;
    }

    public BigDecimal getProductPrice() {
	return productPrice;
    }

    public Integer getProductStock() {
	return productStock;
    }
}
