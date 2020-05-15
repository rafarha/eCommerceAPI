package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
