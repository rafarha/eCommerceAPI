package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    IProductService produtoService;

    @DeleteMapping(value = "/product/delete/{pId}")
    public void deleteProduct(@PathVariable Long pId) {
	produtoService.deleteProduct(pId);
    }

    @GetMapping(value = "/product/{id}")
    public Product findProduct(@PathParam(value = "id") Long pId) {
	return produtoService.searchProductById(pId);
    }

    @GetMapping(value = "products")
    public List<Product> listAllProducts() {
	return produtoService.listAllProducts();

    }

    @PostMapping(value = "product")
    public Product saveProduto(@RequestBody Product pProduct) {
	return produtoService.insertProduct(pProduct);
    }
}
