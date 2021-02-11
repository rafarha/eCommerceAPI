package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.domain.Product;

import javax.validation.constraints.NotNull;

public class CartDetailForm {

    private Long cartId;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    public static CartDetail converter(CartDetailForm pCartDetailForm) {
	Product product = new Product(pCartDetailForm.getProductId());
	Cart cart = new Cart(pCartDetailForm.getCartId());
	return new CartDetail(product, pCartDetailForm.getQuantity(), cart);
    }

    public Long getCartId() {
	return cartId;
    }

    public Long getProductId() {
	return productId;
    }

    public Integer getQuantity() {
	return quantity;
    }
}
