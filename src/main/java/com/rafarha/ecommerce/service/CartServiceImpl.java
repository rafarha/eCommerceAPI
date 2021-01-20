package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired ICartRepository cartRepository;

    @Override public Cart createNewCart(Cart pCart) {
	Cart cart = new Cart();
	cart.setDhCartCreated(LocalDateTime.now());
	cart.setStatusCart(EnumStatusCart.IN_PROGRESS);
	return cartRepository.save(cart);
    }

    public List<Cart> findAllCarts() {
	return cartRepository.findAll(Sort.by("id").descending());
    }

    @Override public Cart findCartById(final Long pId) {
	final Optional<Cart> optionalCart = cartRepository.findById(pId);
	if (!optionalCart.isPresent()) {
	    return null;
	}
	return optionalCart.get();
    }

    public Cart findCartByStatus(EnumStatusCart pEnumStatusCart) {
	return cartRepository.findCartByStatus(pEnumStatusCart);
    }

    @Transactional
    public Cart updateCartStatus(Cart pCart) {
	final Optional<Cart> optionalCart = cartRepository.findById(pCart.getId());
	if (!optionalCart.isPresent()) {
	    return null;
	}
	final Cart cart = optionalCart.get();
	cart.setStatusCart(pCart.getStatusCart());
	return cart;
    }

}
