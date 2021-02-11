package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.domain.Cart;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class CartForm {

    @NotNull
    private CartDetailForm cartDetailForm;

    private Long id;

    @NotNull
    private UserForm user;

    public CartForm(final CartDetailForm pCartDetailForm, final Long pId, final UserForm pUser) {
	cartDetailForm = pCartDetailForm;
	id = pId;
	user = pUser;
    }

    public static Cart converter(CartForm pCartForm) {
	Set cartDetailSet = new HashSet<>();
	cartDetailSet.add(CartDetailForm.converter(pCartForm.getCartDetailForm()));
	return new Cart(pCartForm.getId(), UserForm.converter(pCartForm.getUser()), cartDetailSet);

    }

    public CartDetailForm getCartDetailForm() {
	return cartDetailForm;
    }

    public Long getId() {
	return id;
    }

    public UserForm getUser() {
	return user;
    }
}
