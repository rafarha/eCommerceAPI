package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CartDto {
    private BigDecimal cartValue;

    private LocalDateTime dhCartCreated;

    private Long idCart;

    private List<CartDetailDto> productsInCartList;

    private EnumStatusCart statusCart;

    public CartDto(Cart pCart) {
	idCart = pCart.getId();
	dhCartCreated = pCart.getDhCreation();
	productsInCartList = CartDetailDto.converter(pCart.getCartDetailList());
	statusCart = pCart.getStatusCart();
	cartValue = pCart.getCartValue();
    }

    public static List<CartDto> converter(List<Cart> pCartList) {
	return pCartList.stream().map(CartDto::new).collect(Collectors.toList());
    }

    public BigDecimal getCartValue() {
	return cartValue;
    }

    public LocalDateTime getDhCartCreated() {
	return dhCartCreated;
    }

    public Long getIdCart() {
	return idCart;
    }

    public List<CartDetailDto> getProductsInCartList() {
	return productsInCartList;
    }

    public EnumStatusCart getStatusCart() {
	return statusCart;
    }
}
