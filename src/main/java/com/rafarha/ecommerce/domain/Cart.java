package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.EnumStatusCart;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Cart {

    private Timestamp dhCartCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    private Long productQuantity;

    private EnumStatusCart statusCart;

    public Timestamp getDhCartCreated() {
	return dhCartCreated;
    }

    public Long getId() {
	return id;
    }

    public Product getProduct() {
	return product;
    }

    public Long getProductQuantity() {
	return productQuantity;
    }

    public EnumStatusCart getStatusCart() {
	return statusCart;
    }

    public void setDhCartCreated(final Timestamp pDhCartCreated) {
	dhCartCreated = pDhCartCreated;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setProduct(final Product pProduct) {
	product = pProduct;
    }

    public void setProductQuantity(final Long pProductQuantity) {
	productQuantity = pProductQuantity;
    }

    public void setStatusCart(final EnumStatusCart pStatusCart) {
	statusCart = pStatusCart;
    }
}
