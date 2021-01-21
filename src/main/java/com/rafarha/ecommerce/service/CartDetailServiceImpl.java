package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.config.MessageBundle;
import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.exception.ProductStockUnavailableException;
import com.rafarha.ecommerce.repository.ICartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CartDetailServiceImpl implements ICartDetailService {

    @Autowired ICartDetailRepository cartDetailRepository;

    @Autowired
    ICartService cartService;

    @Autowired
    IProductService productService;

    public void deleteCartDetail(Long pId) {
	cartDetailRepository.deleteById(pId);
    }

    @Override public CartDetail insertProductInCart(CartDetail pCartDetail) throws ProductStockUnavailableException {

	final Product product = productService.searchProductByName(pCartDetail.getProduct().getProductName());
	if (product == null) {
	    return null;
	}
	if (product.getProductStock() < pCartDetail.getProductQuantity()) {
	    throw new ProductStockUnavailableException(MessageBundle.bindMessage("product.quantity_unavaiable"));
	}
	Cart cartInprogress = cartService.findCartByStatus(EnumStatusCart.IN_PROGRESS);
	if (cartInprogress == null) {
	    cartInprogress = cartService.createNewCart(cartInprogress);
	}
	pCartDetail.setProduct(product);
	pCartDetail.setCart(cartInprogress);
	final CartDetail cartDetail = cartDetailRepository.save(pCartDetail);
	if (cartDetail != null) {
	    //TODO subtrair a quantidade de produto no stock
	}
	return cartDetail;
    }

    @Transactional
    public CartDetail updateProductQuantityOnCart(final CartDetail pCartDetail) {
	final Optional<CartDetail> cartDetailOptional = cartDetailRepository.findById(pCartDetail.getId());
	if (!cartDetailOptional.isPresent()) {
	    return null;
	}
	CartDetail cartDetail = cartDetailOptional.get();
	cartDetail.setProductQuantity(pCartDetail.getProductQuantity());
	return cartDetail;
    }

}
