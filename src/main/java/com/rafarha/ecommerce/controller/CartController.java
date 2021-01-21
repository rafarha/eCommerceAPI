package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.controller.dto.CartDetailDto;
import com.rafarha.ecommerce.controller.dto.CartDto;
import com.rafarha.ecommerce.controller.form.CartForm;
import com.rafarha.ecommerce.controller.form.UpdateCartForm;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.exception.ProductStockUnavailableException;
import com.rafarha.ecommerce.service.ICartDetailService;
import com.rafarha.ecommerce.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/carts")
public class CartController {

    private final String URI_NAME = "/api/carts";

    @Autowired ICartDetailService cartDetailService;

    @Autowired ICartService cartService;

    @PostMapping
    public ResponseEntity<CartDetailDto> addProductToCart(@RequestBody CartForm pCartForm,
		    UriComponentsBuilder pUriComponentsBuilder) throws ProductStockUnavailableException {
	final CartDetail cartDetail;
	try {
	    cartDetail = cartDetailService.insertProductInCart(CartForm.converter(pCartForm));
	} catch (ProductStockUnavailableException pE) {
	    throw new ProductStockUnavailableException(pE.getMessage());
	}
	URI uri = pUriComponentsBuilder.path(URI_NAME + "/{id}").buildAndExpand(cartDetail.getCart().getId()).toUri();
	return ResponseEntity.created(uri).body(new CartDetailDto(cartDetail));
    }

    @GetMapping
    public List<CartDto> listAllCart() {
	return CartDto.converter(cartService.findAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> listCart(@PathVariable(name = "id") Long pId) {
	final Cart cartById = cartService.findCartById(pId);
	if (cartById == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new CartDto(cartById));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable(name = "id") Long pId) {
	try {
	    cartDetailService.deleteCartDetail(pId);
	} catch (EmptyResultDataAccessException pE) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateCart(@RequestBody UpdateCartForm pUpdateCartForm,
		    UriComponentsBuilder pUriComponentsBuilder) {
	if (pUpdateCartForm.getStatusCart() != null) {

	    return updateCartStatus(UpdateCartForm.converter(pUpdateCartForm).getCart());
	}
	return updateCart(UpdateCartForm.converter(pUpdateCartForm));
    }

    private ResponseEntity<?> updateCart(CartDetail pCartDetail) {
	final CartDetail cartDetail = cartDetailService.updateProductQuantityOnCart(pCartDetail);
	if (cartDetail != null) {
	    return ResponseEntity.ok(new CartDetailDto(cartDetail));
	}
	return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> updateCartStatus(Cart pCart) {
	final Cart cart = cartService.updateCartStatus(pCart);
	if (cart != null) {
	    return ResponseEntity.ok(new CartDto(cart));
	}
	return ResponseEntity.notFound().build();
    }
}
