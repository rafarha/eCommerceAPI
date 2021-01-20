package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired IProductRepository productRepository;

    @Transactional
    public void deleteProduct(final Long pId) {
	productRepository.deleteById(pId);
    }

    @Transactional
    public Product insertProduct(final Product pProduct) {
	return productRepository.save(pProduct);
    }

    @Override public List<Product> listAllProducts() {
	return productRepository.findAll();
    }

    @Override public Product searchProductById(final Long pId) {
	final Optional<Product> productOptional = productRepository.findById(pId);
	if (productOptional.isPresent()) {
	    return productOptional.get();
	}
	return null;
    }

    @Override public Product searchProductByName(final String pName) {
	final Optional<Product> product = productRepository.findByProductName(pName);
	if (product.isPresent()) {
	    return product.get();
	}
	return null;
    }

    @Transactional
    public Product updateProduct(Long pId, Product pProduct) {
	final Product product = searchProductById(pId);
	if (product == null) {
	    return null;
	}
	product.setDescription(pProduct.getDescription());
	product.setProductName(pProduct.getProductName());
	product.setProductPrice(pProduct.getProductPrice());
	return product;
    }
}
