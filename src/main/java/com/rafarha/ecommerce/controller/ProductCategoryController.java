package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.controller.dto.ProductCategoryDto;
import com.rafarha.ecommerce.controller.form.ProductCategoryForm;
import com.rafarha.ecommerce.domain.ProductCategory;
import com.rafarha.ecommerce.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productCategories")
public class ProductCategoryController {

    private final String URI_NAME = "/api/productCategories";

    @Autowired
    private IProductCategoryService productCategoryService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable(value = "id") Long pId) {
	try {
	    productCategoryService.deleteProductCategoryById(pId);
	} catch (EmptyResultDataAccessException pE) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().build();

    }

    @GetMapping
    public List<ProductCategoryDto> listAllProductCategory() {
	return ProductCategoryDto.converter(productCategoryService.searchAllProductCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listProductById(@PathVariable(value = "id") Long pId) {
	ProductCategory productCategory = productCategoryService.searchById(pId);
	if (productCategory == null) {
	    ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new ProductCategoryDto(productCategory));
    }

    @PostMapping
    public ResponseEntity<?> saveProductCategory(@RequestBody @Valid ProductCategoryForm pProductCategoryForm,
		    UriComponentsBuilder pUriComponentsBuilder) {
	ProductCategory productCategory = productCategoryService
			.saveProductCategory(ProductCategoryForm.converter(pProductCategoryForm));
	URI uri = pUriComponentsBuilder.path(URI_NAME + "/{id}").buildAndExpand(productCategory.getId()).toUri();
	return ResponseEntity.created(uri).body(new ProductCategoryDto(productCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductCategory(@PathVariable(value = "id") Long pId,
		    @RequestBody @Valid ProductCategoryForm pProductCategoryForm) {
	ProductCategory productCategory = productCategoryService
			.updateProductCategory(pId, ProductCategoryForm.converter(pProductCategoryForm));
	if (productCategory == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new ProductCategoryDto(productCategory));
    }
}
