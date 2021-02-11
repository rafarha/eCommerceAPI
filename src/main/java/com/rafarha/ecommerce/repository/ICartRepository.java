package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface ICartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.statusCart = :status")
    Cart findCartByStatus(@Param("status") EnumStatusCart pStatusCart);

    @Transactional
    @Modifying
    @Query(value = "update Cart c set c.cartValue = ?1 where c.id= ?2")
    void updateCartValue(BigDecimal pCartValue, Long pId);
}
