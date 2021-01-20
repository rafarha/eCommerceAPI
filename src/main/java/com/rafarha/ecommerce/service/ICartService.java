package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;

import java.util.List;

public interface ICartService {

    Cart createNewCart(Cart pCart);

    List<Cart> findAllCarts();

    Cart findCartById(Long pId);

    Cart findCartByStatus(EnumStatusCart pEnumStatusCart);

    Cart updateCartStatus(Cart pCart);
}
