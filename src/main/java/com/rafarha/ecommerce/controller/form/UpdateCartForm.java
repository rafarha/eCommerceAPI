package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.domain.Product;

public class UpdateCartForm {
    private Long cartDetailId;

    private Long cartId;

    private Long productId;

    private Integer productQuantity;

    private EnumStatusCart statusCart;

    public UpdateCartForm(CartDetail pCartDetail) {
	productId = pCartDetail.getProductAdded().getId();
	productQuantity = pCartDetail.getQtdProduct();
	cartId = pCartDetail.getCart().getId();
	cartDetailId = pCartDetail.getId();
	statusCart = pCartDetail.getCart().getStatusCart();
    }

    public UpdateCartForm() {
    }

    public static CartDetail converter(UpdateCartForm pUpdateCartForm) {
	Product product = new Product();
	product.setId(pUpdateCartForm.getProductId());
	Cart cart = new Cart();
	cart.setId(pUpdateCartForm.getCartId());
	cart.setStatusCart(pUpdateCartForm.getStatusCart());
	return new CartDetail(product, pUpdateCartForm.getProductQuantity(),
			pUpdateCartForm.getCartDetailId(), cart);

    }

    public Long getCartDetailId() {
	return cartDetailId;
    }

    public Long getCartId() {
	return cartId;
    }

    public Long getProductId() {
	return productId;
    }

    public Integer getProductQuantity() {
	return productQuantity;
    }

    public EnumStatusCart getStatusCart() {
	return statusCart;
    }
}
