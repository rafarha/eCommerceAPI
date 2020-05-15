package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired ICartService cartService;

    @PostMapping(value = "cart")
    public Cart insertProductCart(@RequestBody Cart pCart) {
	return cartService.createNewCart(pCart);
    }
}
