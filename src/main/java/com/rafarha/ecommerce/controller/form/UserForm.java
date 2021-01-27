package com.rafarha.ecommerce.controller.form;

import com.rafarha.ecommerce.constants.UserCategory;
import com.rafarha.ecommerce.domain.User;

import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull
    private UserCategory userCategory;

    @NotNull
    private String userName;

    public UserForm(final String pUserName,
		    final UserCategory pUserCategory) {
	userName = pUserName;
	userCategory = pUserCategory;
    }

    public static User converter(UserForm pUserForm) {
	return new User(pUserForm.getUserCategory(), pUserForm.getUserName());
    }

    public UserCategory getUserCategory() {
	return userCategory;
    }

    public String getUserName() {
	return userName;
    }
}
