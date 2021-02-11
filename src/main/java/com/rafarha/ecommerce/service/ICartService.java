package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.exception.ProductNotFoundInStockException;
import com.rafarha.ecommerce.exception.ProductStockUnavailableException;

import java.util.List;

public interface ICartService {

    Cart addProductCart(Cart pCart) throws ProductStockUnavailableException;

    Cart createNewCart(Cart pCart);

    List<Cart> findAllCarts();

    Cart findCartById(Long pId);

    Cart findCartByStatus(EnumStatusCart pEnumStatusCart);

    Cart insertProductInCart(CartDetail pCartDetail) throws ProductStockUnavailableException, ProductNotFoundInStockException;

    Cart updateCartStatus(Cart pCart);
}
