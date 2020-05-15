package com.rafarha.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

    private String description;

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(final BigDecimal pPrice) {
	price = pPrice;
    }

    public String getDescription() {
	return description;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setDescription(final String pDescription) {
	description = pDescription;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setName(final String pName) {
	name = pName;
    }
}
