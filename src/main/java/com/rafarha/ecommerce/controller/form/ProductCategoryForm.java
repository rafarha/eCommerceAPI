package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.ProductCategory;

import javax.validation.constraints.NotNull;

public class ProductCategoryForm {

    @NotNull
    private String categoryName;

    public ProductCategoryForm(final String pCategoryName) {
	categoryName = pCategoryName;
    }

    public ProductCategoryForm() {
    }

    public static ProductCategory converter(ProductCategoryForm pProductCategoryForm) {
	return new ProductCategory(pProductCategoryForm.getCategoryName());
    }

    public String getCategoryName() {
	return categoryName;
    }
}
