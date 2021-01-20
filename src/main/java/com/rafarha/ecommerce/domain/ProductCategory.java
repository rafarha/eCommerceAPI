package com.rafarha.ecommerce.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUCT_CATEGORY")
public class ProductCategory {

    private String categoryName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_product_category", allocationSize = 1)
    private Integer id;

    public String getCategoryName() {
	return categoryName;
    }

    public Integer getId() {
	return id;
    }

    public void setCategoryName(final String pCategoryName) {
	categoryName = pCategoryName;
    }

    public void setId(final Integer pId) {
	id = pId;
    }
}
