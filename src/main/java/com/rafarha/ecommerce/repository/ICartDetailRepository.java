package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {

}
