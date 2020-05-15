package com.rafarha.ecommerce.constants;

public enum EnumStatusCart {
    IN_PROGRESS("Purchase is in progress"),
    SUCSSES_CONCLUDE("Purchase was conclude with sucsses"),
    EXPIRED_TIME("Purchase was not conclude, cart duration expired");

    private String description;

    EnumStatusCart(String pDescription) {
	description = pDescription;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(final String pDescription) {
	description = pDescription;
    }
}
