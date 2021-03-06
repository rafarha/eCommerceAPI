package com.rafarha.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_product", allocationSize = 1)
    private Long id;

    @OneToOne
    private ProductCategory productCategory;

    private String productName;

    @OneToOne
    private User productOwner;

    private BigDecimal productPrice;

    private Integer productStock;

    public Product(final String pDescription, final String pProductName, final BigDecimal pProductPrice,
		    final Integer pProductStock, final User pProductOwner, final ProductCategory pProductCategory,
		    final Long pId) {
	description = pDescription;
	productName = pProductName;
	productPrice = pProductPrice;
	productStock = pProductStock;
	productOwner = pProductOwner;
	productCategory = pProductCategory;
	id = pId;
    }

    public Product() {
    }

    public Product(final Long pProductId) {
	this.id = pProductId;
    }

    public String getDescription() {
	return description;
    }

    public Long getId() {
	return id;
    }

    public ProductCategory getProductCategory() {
	return productCategory;
    }

    public String getProductName() {
	return productName;
    }

    public User getProductOwner() {
	return productOwner;
    }

    public BigDecimal getProductPrice() {
	return productPrice;
    }

    public Integer getProductStock() {
	return productStock;
    }

    public void setDescription(final String pDescription) {
	description = pDescription;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setProductCategory(final ProductCategory pProductCategory) {
	productCategory = pProductCategory;
    }

    public void setProductName(final String pProductName) {
	productName = pProductName;
    }

    public void setProductOwner(final User pProductOwner) {
	productOwner = pProductOwner;
    }

    public void setProductPrice(final BigDecimal pProductPrice) {
	productPrice = pProductPrice;
    }

    public void setProductStock(final Integer pProductStock) {
	productStock = pProductStock;
    }
}
