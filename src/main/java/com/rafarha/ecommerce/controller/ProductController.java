package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.controller.dto.ProductDto;
import com.rafarha.ecommerce.controller.form.ProductForm;
import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final String URI_NAME = "/api/products";

    @Autowired
    IProductService produtoService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long pId) {
	try {
	    produtoService.deleteProduct(pId);
	} catch (EmptyResultDataAccessException pE){
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> detailProduct(@PathVariable(value = "id") Long pId) {
	final Product product = produtoService.searchProductById(pId);
	if (product == null) {
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new ProductDto(product));
    }

    @GetMapping
    public List<ProductDto> listAllProducts() {
	return ProductDto.converter(produtoService.listAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduto(@RequestBody @Valid ProductForm pProductForm,
		    UriComponentsBuilder pUriComponentsBuilder) {
	final Product product = produtoService.insertProduct(ProductForm.converter(pProductForm));
	URI uri = pUriComponentsBuilder.path(URI_NAME + "/{id}").buildAndExpand(product.getId()).toUri();
	return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long pId, @RequestBody @Valid ProductForm pProductForm) {
	final Product product = produtoService.updateProduct(pId, ProductForm.converter(pProductForm));
	if(product==null){
	    return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new ProductDto(product));
    }
}
