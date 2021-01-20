package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ORDER")
public class Order {

    private LocalDateTime dhClosed;

    private LocalDateTime dhCreation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_order", allocationSize = 1)
    private Integer id;

    private BigDecimal orderDicount;

    private BigDecimal orderPrice;

    private OrderStatus orderStatus;

    @OneToOne
    private User user;

    public LocalDateTime getDhClosed() {
	return dhClosed;
    }

    public LocalDateTime getDhCreation() {
	return dhCreation;
    }

    public Integer getId() {
	return id;
    }

    public BigDecimal getOrderDicount() {
	return orderDicount;
    }

    public BigDecimal getOrderPrice() {
	return orderPrice;
    }

    public OrderStatus getOrderStatus() {
	return orderStatus;
    }

    public User getUser() {
	return user;
    }

    public void setDhClosed(final LocalDateTime pDhClosed) {
	dhClosed = pDhClosed;
    }

    public void setDhCreation(final LocalDateTime pDhCreation) {
	dhCreation = pDhCreation;
    }

    public void setId(final Integer pId) {
	id = pId;
    }

    public void setOrderDicount(final BigDecimal pOrderDicount) {
	orderDicount = pOrderDicount;
    }

    public void setOrderPrice(final BigDecimal pOrderPrice) {
	orderPrice = pOrderPrice;
    }

    public void setOrderStatus(final OrderStatus pOrderStatus) {
	orderStatus = pOrderStatus;
    }

    public void setUser(final User pUser) {
	user = pUser;
    }
}
