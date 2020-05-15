package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.Product;

import java.util.List;

public interface IProductService {

    void deleteProduct(final Long pId);

    public Product insertProduct(Product pProduct);

    List<Product> listAllProducts();

    Product searchProductById(Long pId);
}
