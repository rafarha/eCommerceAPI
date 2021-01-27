package com.rafarha.ecommerce.controller.dto;

import com.rafarha.ecommerce.constants.UserCategory;
import com.rafarha.ecommerce.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;

    private UserCategory userCategory;

    private String userName;

    public UserDto(User pUser) {
	this.id = pUser.getId();
	this.userName = pUser.getUserName();
	this.userCategory = pUser.getUserCategory();
    }

    public static List<UserDto> converter(List<User> pUserList) {
	return pUserList.stream().map(UserDto::new).collect(Collectors.toList());
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
}
