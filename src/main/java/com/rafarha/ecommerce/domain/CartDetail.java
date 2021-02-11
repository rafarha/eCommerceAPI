package com.rafarha.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_CART_DETAIL", uniqueConstraints = @UniqueConstraint(columnNames = { "product_id", "cart_id" }, name = "tb_cart_detail_uk"))
public class CartDetail implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(name = "cart_detail_cart_fk"))
    private Cart cart;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cart_detail", allocationSize = 1)
    private Long id;

    @OneToOne
    private Product product;

    private BigDecimal productPrice;

    private Integer productQuantity;

    public CartDetail(Product pProduct, Integer pProductQuantity) {
	this.product = pProduct;
	this.productQuantity = pProductQuantity;
    }

    public CartDetail(Product pProduct, Integer pProductQuantity, Long pCartDetailId, Cart pCart) {
	this.product = pProduct;
	this.productQuantity = pProductQuantity;
	this.id = pCartDetailId;
	this.cart = pCart;
    }

    public CartDetail(Product pProduct, Integer pProductQuantity, Cart pCart) {
	this.product = pProduct;
	this.productQuantity = pProductQuantity;
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

    public Product getProduct() {
	return product;
    }

    public BigDecimal getProductPrice() {
	return productPrice;
    }

    public Integer getProductQuantity() {
	return productQuantity;
    }

    public void setCart(final Cart pCart) {
	cart = pCart;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setProduct(final Product pProduct) {
	product = pProduct;
    }

    public void setProductPrice(final BigDecimal pProductPrice) {
	productPrice = pProductPrice;
    }

    public void setProductQuantity(final Integer pProductQuantity) {
	productQuantity = pProductQuantity;
    }
}
