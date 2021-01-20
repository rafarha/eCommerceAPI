package com.rafarha.ecommerce.constants;

public enum EnumStatusCart {
    IN_PROGRESS("Purchase is in progress"),
    SUCSSES_CONCLUDE("Purchase was conclude with sucsses"),
    EXPIRED_TIME("Purchase was not conclude, cart duration expired");

    private java.lang.String description;

    EnumStatusCart(java.lang.String pDescription) {
	description = pDescription;
    }

    public java.lang.String getDescription() {
	return description;
    }

    public void setDescription(final java.lang.String pDescription) {
	description = pDescription;
    }
}
