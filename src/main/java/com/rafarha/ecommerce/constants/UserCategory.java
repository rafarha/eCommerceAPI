package com.rafarha.ecommerce.constants;

public enum UserCategory {
    BUYER("This users usually make some purchase on ecommerce"),
    SELLER("This user can insert their products to sell"),
    ADMINISTRATOR("This user can do everything on ecommerce");

    private String description;

    UserCategory(final String pDescription) {
	description = pDescription;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(final String pDescription) {
	description = pDescription;
    }
}
