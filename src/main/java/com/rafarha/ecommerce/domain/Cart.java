package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.EnumStatusCart;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_CART")
public class Cart implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartDetail> cartDetailList;

    private LocalDateTime dhCreation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cart", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumStatusCart statusCart;

    @OneToOne
    private User user;

    private BigDecimal cartValue;

    public Cart() {
	dhCreation = LocalDateTime.now();
	statusCart = EnumStatusCart.IN_PROGRESS;
    }

    public List<CartDetail> getCartDetailList() {
	return cartDetailList;
    }

    public LocalDateTime getDhCreation() {
	return dhCreation;
    }

    public Long getId() {
	return id;
    }

    public EnumStatusCart getStatusCart() {
	return statusCart;
    }

    public void setCartDetailList(final List<CartDetail> pCartDetailList) {
	cartDetailList = pCartDetailList;
    }

    public void setDhCreation(final LocalDateTime pDhCreation) {
	dhCreation = pDhCreation;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setStatusCart(final EnumStatusCart pStatusCart) {
	statusCart = pStatusCart;
    }

    public User getUser() {
	return user;
    }

    public void setUser(final User pUser) {
	user = pUser;
    }

    public BigDecimal getCartValue() {
	return cartValue;
    }

    public void setCartValue(final BigDecimal pCartValue) {
	cartValue = pCartValue;
    }
}
