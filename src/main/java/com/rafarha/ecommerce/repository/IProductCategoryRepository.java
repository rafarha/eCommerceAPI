package com.rafarha.ecommerce.repository;

import com.rafarha.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
