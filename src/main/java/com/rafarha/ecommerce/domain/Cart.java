package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.EnumStatusCart;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_CART")
public class Cart implements Serializable {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CART_DETAIL_CART", joinColumns = {
		    @JoinColumn(name = "cart_id", referencedColumnName = "id") }, inverseJoinColumns = {
		    @JoinColumn(name = "cart_detail_id", referencedColumnName = "id") })
    private List<CartDetail> cartDetailList;

    private LocalDateTime dhCartCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cart", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumStatusCart statusCart;

    public Cart() {
	dhCartCreated = LocalDateTime.now();
	statusCart = EnumStatusCart.IN_PROGRESS;
    }

    public List<CartDetail> getCartDetailList() {
	return cartDetailList;
    }

    public LocalDateTime getDhCartCreated() {
	return dhCartCreated;
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

    public void setDhCartCreated(final LocalDateTime pDhCartCreated) {
	dhCartCreated = pDhCartCreated;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setStatusCart(final EnumStatusCart pStatusCart) {
	statusCart = pStatusCart;
    }
}
