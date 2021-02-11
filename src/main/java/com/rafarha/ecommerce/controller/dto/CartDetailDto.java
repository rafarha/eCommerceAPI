package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.domain.CartDetail;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CartDetailDto {

    private String prductName;

    private Long productId;

    private Integer productQuantity;

    public CartDetailDto(CartDetail pCartDetail) {
	prductName = pCartDetail.getProduct().getProductName();
	productQuantity = pCartDetail.getProductQuantity();
	productId = pCartDetail.getProduct().getId();
    }

    public static List<CartDetailDto> converter(Set<CartDetail> pCartDetailList) {
	return pCartDetailList.stream().map(CartDetailDto::new).collect(Collectors.toList());
    }

    public String getPrductName() {
	return prductName;
    }

    public Long getProductId() {
	return productId;
    }

    public Integer getProductQuantity() {
	return productQuantity;
    }
}
