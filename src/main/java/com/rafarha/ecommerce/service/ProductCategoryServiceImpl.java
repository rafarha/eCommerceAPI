package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.ProductCategory;
import com.rafarha.ecommerce.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    IProductCategoryRepository productCategoryRepository;

    @Override public void deleteProductCategoryById(final Long pId) {
	productCategoryRepository.deleteById(pId);
    }

    @Override public ProductCategory saveProductCategory(final ProductCategory pProductCategory) {
	return productCategoryRepository.save(pProductCategory);
    }

    @Override public List<ProductCategory> searchAllProductCategory() {
	return productCategoryRepository.findAll(Sort.by("id"));
    }

    @Override public ProductCategory searchById(final Long pId) {
	final Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(pId);
	if (!productCategoryOptional.isPresent()) {
	    return null;
	}
	return productCategoryOptional.get();
    }

    @Override
    @Transactional
    public ProductCategory updateProductCategory(final Long pId,
		    final ProductCategory pProductCategory) {
	final Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(pId);
	if (!productCategoryOptional.isPresent()) {
	    return null;
	}
	final ProductCategory productCategory = productCategoryOptional.get();
	productCategory.setCategoryName(pProductCategory.getCategoryName());
	return productCategory;
    }
}
