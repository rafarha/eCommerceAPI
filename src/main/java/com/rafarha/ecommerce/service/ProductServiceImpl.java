package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired IProductRepository productRepository;

    @Override public Product insertProduct(final Product pProduct) {
	return productRepository.save(pProduct);
    }

    @Override public List<Product> listAllProducts() {
	return productRepository.findAll();
    }

    @Override public Product searchProductById(final Long pId) {
	return productRepository.getOne(pId);
    }

    public void deleteProduct(final Long pId){
        productRepository.deleteById(pId);
    }
}
