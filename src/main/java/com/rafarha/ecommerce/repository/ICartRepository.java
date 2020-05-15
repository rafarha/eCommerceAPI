package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {

}
