package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.constants.EnumStatusCart;
import com.rafarha.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.statusCart = :status")
    Cart findCartByStatus(@Param("status") EnumStatusCart pStatusCart);
}
