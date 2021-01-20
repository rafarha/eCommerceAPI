package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.UserCategory;

import javax.persistence.*;

@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    private String userName;

    public Integer getId() {
	return id;
    }

    public void setId(final Integer pId) {
	id = pId;
    }

    public UserCategory getUserCategory() {
	return userCategory;
    }

    public void setUserCategory(final UserCategory pUserCategory) {
	userCategory = pUserCategory;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(final String pUserName) {
	userName = pUserName;
    }
}
