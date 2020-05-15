package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired ICartRepository cartRepository;

    @Override public Cart createNewCart(final Cart pCart) {
	pCart.setDhCartCreated(Timestamp.from(Instant.now()));
	pCart.setStatusCart(EnumStatusCart.IN_PROGRESS);
	return cartRepository.save(pCart);
    }
}
