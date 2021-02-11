package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {

    @Query(value = "select * from tb_cart_detail cd where cd.product_id = ?1 and cd.cart_id = ?2", nativeQuery = true)
    CartDetail findCartDetailByProductIdAndCartId(Long pProductId, Long pCartId);

    @Transactional
    @Modifying
    @Query(value = "update CartDetail cd set cd.productQuantity = ?1 where cd.id = ?2")
    void updateProductQuantity(Integer pProductQuantity, Long pId);
}
