package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.config.MessageBundle;
import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.exception.ProductNotFoundInStockException;
import com.rafarha.ecommerce.exception.ProductStockUnavailableException;
import com.rafarha.ecommerce.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    ICartDetailService cartDetailService;

    @Autowired ICartRepository cartRepository;

    @Autowired
    IProductService productService;

    @Override public Cart addProductCart(final Cart pCart) throws ProductStockUnavailableException {
	Cart cart = pCart;
	final Set<CartDetail> cartDetailSet = pCart.getCartDetailList();
	final Optional<CartDetail> cartDetailOptional = cartDetailSet.stream().findFirst();
	CartDetail cartDetail;
	if (cartDetailOptional.isPresent()) {
	    cartDetail = cartDetailOptional.get();
	} else {
	    //TODO Uma excecao carrinho nao encontrado
	    return null;
	}
	Product product = productService.searchProductById(cartDetail.getProduct().getId());

	if (cartDetail.getProductQuantity() > product.getProductStock()) {
	    throw new ProductStockUnavailableException("");
	}
	if (pCart.getId() != null) {
	    final boolean cartExists = cartRepository.existsById(pCart.getId());
	}
	cartRepository.save(pCart);
	return cart;
    }

    @Override public Cart createNewCart(Cart pCart) {
	Cart cart = new Cart();
	cart.setDhCreation(LocalDateTime.now());
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

    @Override public Cart insertProductInCart(CartDetail pCartDetail)
		    throws ProductStockUnavailableException, ProductNotFoundInStockException {

	final Product product = productService.searchProductById(pCartDetail.getProduct().getId());
	if (product == null) {
	    throw new ProductNotFoundInStockException(MessageBundle.bindMessage("product.not_found"), "product");
	}
	if (product.getProductStock() < pCartDetail.getProductQuantity()) {
	    throw new ProductStockUnavailableException(MessageBundle.bindMessage("product.quantity_unavaiable"));
	}
	Integer productQuantity = pCartDetail.getProductQuantity();
	Cart cart = hasCartInprogress(pCartDetail);
	if (cart == null) {
	    //TODO add user do contexto
	    cart = createNewCart(cart);
	}

	final Set<CartDetail> cartDetailSet = cart.getCartDetailList();
	final Optional<CartDetail> optional = cartDetailSet.stream().filter(c -> c.getProduct() == product).findFirst();
	CartDetail cartDetail;
	//This means that already exists one cartDetail for the product
	if (optional.isPresent()) {
	    cartDetail = optional.get();
	    cartDetail.setProductQuantity(cartDetail.getProductQuantity() + productQuantity);
	} else {
	    cartDetail = pCartDetail;
	    cartDetail.setProductPrice(product.getProductPrice());
	    cartDetail.setCart(cart);
	}
	cartDetailSet.add(cartDetail);
	cart.setCartDetailList(cartDetailSet);
	updateCartValue(cartDetail, cart);
	cart = cartRepository.save(cart);
	productService.updateProductStock(productQuantity, pCartDetail.getProduct());
	return cart;
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

    private Cart hasCartInprogress(final CartDetail pCartDetail) {
	Cart cart = null;
	if (pCartDetail.getCart().getId() == null) {
	    return null;
	}
	cart = findCartById(pCartDetail.getCart().getId());
	if (cart == null) {
	    return null;
	}
	//return null case cart not foun or not in progress.
	return (cart != null && EnumStatusCart.IN_PROGRESS.equals(cart.getStatusCart())) ? cart : null;
    }

    private BigDecimal updateCartValue(final CartDetail pCartDetail, final Cart pCart) {
	BigDecimal cartValue;
	if (pCart.getCartValue() == null) {
	    cartValue = pCartDetail.getProductPrice().multiply(BigDecimal.valueOf(pCartDetail.getProductQuantity()));
	    pCart.setCartValue(cartValue);
	} else {
	    cartValue = pCart.getCartValue().add(pCartDetail.getProductPrice().multiply(
			    BigDecimal.valueOf(pCartDetail.getProductQuantity())));
	    pCart.setCartValue(cartValue);
	}
	return cartValue;
    }

    private void updateProductCart(CartDetail pCartDetail) {
	CartDetail cartDetail = cartDetailService
			.searchCartDetailByProductAndCartId(pCartDetail.getProduct().getId(), pCartDetail.getCart().getId());

	cartDetail.setProductQuantity(cartDetail.getProductQuantity() + pCartDetail.getProductQuantity());
	cartDetail.setProductPrice(pCartDetail.getProductPrice());
	cartDetailService.updateProductQuantity(pCartDetail);
    }

}
