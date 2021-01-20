package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductForm {

    @NotNull @NotEmpty @Length(min = 10)
    private String description;

    @NotNull @NotEmpty @Length(max = 10)
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer productQuantityOnStock;

    public ProductForm(final String pName, final BigDecimal pPrice, String pDescription, Integer pProductQuantityOnStock) {
	name = pName;
	price = pPrice;
	description = pDescription;
	productQuantityOnStock = pProductQuantityOnStock;
    }

    public ProductForm() {
    }

    public static Product converter(ProductForm pProductForm) {
	return new Product(pProductForm.getDescription(), pProductForm.getName(), pProductForm.getPrice(),
			pProductForm.getProductQuantityOnStock());
    }

    public String getDescription() {
	return description;
    }

    public String getName() {
	return name;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public Integer getProductQuantityOnStock() {
	return productQuantityOnStock;
    }
}
