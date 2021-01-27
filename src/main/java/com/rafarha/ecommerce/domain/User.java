package com.rafarha.ecommerce.domain;

import com.rafarha.ecommerce.constants.UserCategory;

import javax.persistence.*;

@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    private String userName;

    public User(final UserCategory pUserCategory, final String pUserName) {
	userCategory = pUserCategory;
	userName = pUserName;
    }

    public User() {
    }

    public Long getId() {
	return id;
    }

    public UserCategory getUserCategory() {
	return userCategory;
    }

    public String getUserName() {
	return userName;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setUserCategory(final UserCategory pUserCategory) {
	userCategory = pUserCategory;
    }

    public void setUserName(final String pUserName) {
	userName = pUserName;
    }
}
