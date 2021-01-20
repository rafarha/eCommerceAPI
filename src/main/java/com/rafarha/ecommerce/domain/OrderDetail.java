package com.rafarha.ecommerce.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_order_detail", allocationSize = 1)
    private Integer id;

    @OneToOne
    private Product product;

    @OneToOne
    private Order order;

    private Integer quantity;

    private BigDecimal price;

    public Integer getId() {
	return id;
    }

    public void setId(final Integer pId) {
	id = pId;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(final Product pProduct) {
	product = pProduct;
    }

    public Order getOrder() {
	return order;
    }

    public void setOrder(final Order pOrder) {
	order = pOrder;
    }

    public Integer getQuantity() {
	return quantity;
    }

    public void setQuantity(final Integer pQuantity) {
	quantity = pQuantity;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(final BigDecimal pPrice) {
	price = pPrice;
    }
}
