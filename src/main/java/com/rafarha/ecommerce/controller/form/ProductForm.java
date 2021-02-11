package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.domain.ProductCategory;
import com.rafarha.ecommerce.domain.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductForm {

    @NotNull
    private ProductCategory productCategory;

    @NotNull @NotEmpty @Length(min = 10)
    private String productDescription;

    @NotNull @NotEmpty @Length(max = 10)
    private String productName;

    private User productOwner;

    private BigDecimal productPrice;

    @NotNull
    private Integer productStock;

    private Long id;

    public ProductForm(final String pProductName, final BigDecimal pProductPrice, String pProductDescription,
		    Integer pProductStock, ProductCategory pProductCategory, User pProductOwner, Long pId) {
	productName = pProductName;
	productPrice = pProductPrice;
	productDescription = pProductDescription;
	productStock = pProductStock;
	productCategory = pProductCategory;
	productOwner = pProductOwner;
	id =pId;
    }


    public ProductForm() {
    }

    public static Product converter(ProductForm pProductForm) {
	return new Product(pProductForm.getProductDescription(), pProductForm.getProductName(), pProductForm.getProductPrice(),
			pProductForm.getProductStock(), pProductForm.getProductOwner(), pProductForm.getProductCategory(), pProductForm.getId());
    }

    public ProductCategory getProductCategory() {
	return productCategory;
    }

    public String getProductDescription() {
	return productDescription;
    }

    public String getProductName() {
	return productName;
    }

    public User getProductOwner() {
	return productOwner;
    }

    public BigDecimal getProductPrice() {
	return productPrice;
    }

    public Integer getProductStock() {
	return productStock;
    }

    public Long getId() {
	return id;
    }
}
