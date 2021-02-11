package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.exception.ProductStockUnavailableException;

public interface ICartDetailService {

    void deleteCartDetail(Long pId);

    //    public List<CartDetail> searchPurchaseByIdCart(Long pId);

    CartDetail insertProductInCart(CartDetail pCartDetail) throws ProductStockUnavailableException;

    CartDetail searchCartDetailByProductAndCartId(Long pProductId, Long pCartId);

    void updateProductQuantity(CartDetail pCartDetail);

    CartDetail updateProductQuantityOnCart(CartDetail pCartDetail);

}
