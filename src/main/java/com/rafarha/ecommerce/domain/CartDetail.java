package com.rafarha.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CART_DETAIL")
public class CartDetail implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CART_DETAIL_CART", joinColumns = {
		    @JoinColumn(name = "cart_detail_id", referencedColumnName = "id") }, inverseJoinColumns = {
		    @JoinColumn(name = "cart_id", referencedColumnName = "id") })
    private Cart cart;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cart_detail", allocationSize = 1)
    private Long id;

    @OneToOne
    private Product productAdded;

    private Integer qtdProduct;

    public CartDetail(Product pProduct, Integer pQtdProduct) {
	this.productAdded = pProduct;
	this.qtdProduct = pQtdProduct;
    }

    public CartDetail(Product pProduct, Integer pQtdProduct, Long pCartDetailId, Cart pCart) {
	this.productAdded = pProduct;
	this.qtdProduct = pQtdProduct;
	this.id = pCartDetailId;
	this.cart = pCart;
    }

    public CartDetail() {
    }

    public Cart getCart() {
	return cart;
    }

    public Long getId() {
	return id;
    }

    public Product getProductAdded() {
	return productAdded;
    }

    public Integer getQtdProduct() {
	return qtdProduct;
    }

    public void setCart(final Cart pCart) {
	cart = pCart;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setProductAdded(final Product pProductAdded) {
	productAdded = pProductAdded;
    }

    public void setQtdProduct(final Integer pQtdProduct) {
	qtdProduct = pQtdProduct;
    }
}
