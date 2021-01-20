package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.CartDetail;
import com.rafarha.ecommerce.exception.ProductQuantityUnavailableException;

public interface ICartDetailService {

    void deleteCartDetail(Long pId);

    //    public List<CartDetail> searchPurchaseByIdCart(Long pId);

    CartDetail insertProductInCart(CartDetail pCartDetail) throws ProductQuantityUnavailableException;

    CartDetail updateProductQuantityOnCart(CartDetail pCartDetail);

}
