package com.rafarha.ecommerce.service;

import com.rafarha.ecommerce.domain.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    void deleteProductCategoryById(Long pId);

    ProductCategory saveProductCategory(ProductCategory pProductCategory);

    List<ProductCategory> searchAllProductCategory();

    ProductCategory searchById(Long pId);

    ProductCategory updateProductCategory(Long pId, final ProductCategory pProductCategory);

}
