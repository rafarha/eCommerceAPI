package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.domain.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCategoryDto {
    private Long id;

    private String categoryName;

    public ProductCategoryDto(ProductCategory pProductCategory) {
	this.id = pProductCategory.getId();
	this.categoryName = pProductCategory.getCategoryName();
    }

    public static List<ProductCategoryDto> converter(List<ProductCategory> pProductCategoryList){
        return pProductCategoryList.stream().map(ProductCategoryDto::new).collect(Collectors.toList());
    }

    public Long getId() {
	return id;
    }

    public String getCategoryName() {
	return categoryName;
    }
}
