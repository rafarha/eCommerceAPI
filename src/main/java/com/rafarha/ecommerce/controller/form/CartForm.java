package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.domain.Product;

public class CartForm {

    private String productName;

    private Integer productQuantity;

    public CartForm(final String pProductName, final Integer pProductQuantity) {
	productName = pProductName;
	productQuantity = pProductQuantity;
    }

    public String getProductName() {
	return productName;
    }

    public Integer getProductQuantity() {
	return productQuantity;
    }

    public static CartDetail converter(CartForm pCartForm){
	Product product = new Product();
	product.setProductName(pCartForm.getProductName());
        return new CartDetail(product, pCartForm.getProductQuantity());
    }
}
