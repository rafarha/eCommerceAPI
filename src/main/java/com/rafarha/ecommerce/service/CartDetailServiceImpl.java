package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.CartDetail;
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

	//	final Product product = productService.searchProductById(pCartDetail.getProduct().getId());
	//	if (product == null) {
	//	    return null;
	//	}
	//	if (product.getProductStock() < pCartDetail.getProductQuantity()) {
	//	    throw new ProductStockUnavailableException(MessageBundle.bindMessage("product.quantity_unavaiable"));
	//	}
	//	Cart cart = hasCartInprogress(pCartDetail);
	//	if (cart == null) {
	//	    cart = cartService.createNewCart(cart);
	//	}
	//	pCartDetail.setProduct(product);
	//	pCartDetail.setCart(cart);
	//	pCartDetail.setProductPrice(product.getProductPrice());
	//	cart.setCartValue(cart.getCartValue().add(pCartDetail.getProductPrice().multiply(
	//			BigDecimal.valueOf(pCartDetail.getProductQuantity()))));
	//
	//	final CartDetail cartDetail = cartDetailRepository.save(pCartDetail);
	//	if (cartDetail != null) {
	//	    //TODO subtrair a quantidade de produto no stock
	//	    cart = cartService.findCartById(cart.getId());
	//	}
	//	//Atualizar Valor Carrinho

	return null;
    }

    @Override public CartDetail searchCartDetailByProductAndCartId(final Long pProductId, final Long pCartId) {
	return cartDetailRepository.findCartDetailByProductIdAndCartId(pProductId, pCartId);
    }

    @Override public void updateProductQuantity(final CartDetail pCartDetail) {
	cartDetailRepository.updateProductQuantity(pCartDetail.getProductQuantity(), pCartDetail.getId());
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
