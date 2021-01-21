package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.domain.CartDetail;

import java.util.List;
import java.util.stream.Collectors;

public class CartDetailDto {

    private Long cartId;

    private String prductName;

    private Integer productQuantity;

    private Long productId;

    private Long cartDetailId;

    public CartDetailDto(CartDetail pCartDetail) {
	prductName = pCartDetail.getProduct().getProductName();
	productQuantity = pCartDetail.getProductQuantity();
	cartId = pCartDetail.getCart().getId();
	productId = pCartDetail.getProduct().getId();
	cartDetailId = pCartDetail.getId();
    }

    public static List<CartDetailDto> converter(List<CartDetail> pCartDetailList) {
	return pCartDetailList.stream().map(CartDetailDto::new).collect(Collectors.toList());
    }

    public Long getCartId() {
	return cartId;
    }

    public String getPrductName() {
	return prductName;
    }

    public Integer getProductQuantity() {
	return productQuantity;
    }

    public Long getProductId() {
	return productId;
    }

    public Long getCartDetailId() {
	return cartDetailId;
    }
}
