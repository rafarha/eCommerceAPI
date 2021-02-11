package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.EnumStatusCart;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_CART")
public class Cart implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartDetail> cartDetailList = new HashSet<>();

    private BigDecimal cartValue;

    private LocalDateTime dhCreation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cart", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumStatusCart statusCart;

    @OneToOne
    private User user;

    public Cart(final Long pId, final User pUser, final Set<CartDetail> pCartDetailList) {
	id = pId;
	user = pUser;
	cartDetailList = pCartDetailList;
    }

    public Cart() {
	dhCreation = LocalDateTime.now();
	statusCart = EnumStatusCart.IN_PROGRESS;
    }

    public Cart(final Long pCartId) {
	id = pCartId;
    }

    public void addCartDetail(CartDetail pCartDetail) {
	pCartDetail.setCart(this);
	cartDetailList.add(pCartDetail);
    }

    public Set<CartDetail> getCartDetailList() {
	return cartDetailList;
    }

    public BigDecimal getCartValue() {
	return cartValue;
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

    public User getUser() {
	return user;
    }

    public void setCartDetailList(final Set<CartDetail> pCartDetailList) {
	cartDetailList = pCartDetailList;
    }

    public void setCartValue(final BigDecimal pCartValue) {
	cartValue = pCartValue;
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

    public void setUser(final User pUser) {
	user = pUser;
    }
}
