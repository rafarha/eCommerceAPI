package com.rafarha.ecommerce;

import com.rafarha.ecommerce.domain.Product;
import com.rafarha.ecommerce.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
public class ProductTest {

    @Autowired IProductRepository produtoRepository;

    @Test
    void inclusaoProdutoTest() {
	Product product = new Product();
	product.setName("Bateria");
	product.setDescription("Bateria modelo tr44");
	product.setId(1l);

	produtoRepository.save(product);
	final Optional<Product> produtoIncluido = produtoRepository.findById(1l);
	Assert.notNull(produtoIncluido, "Produto não foi Cadastrado na base de dados");
    }
}
