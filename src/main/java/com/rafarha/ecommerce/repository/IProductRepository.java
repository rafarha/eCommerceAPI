package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String name);

}
