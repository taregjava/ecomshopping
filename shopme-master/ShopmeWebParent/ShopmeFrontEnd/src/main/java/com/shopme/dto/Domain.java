package com.shopme.dto;

public enum Domain {
    CUSTOMER("CUSTOMER", "Customer"),
    AIRPORT("AIRPORT", "Airport"),
    COUNTRY("COUNTRY", "Country"),
    CITY("CITY", "City"),
    PACKAGE("PACKAGE", "Package"),
    FEATURE("FEATURE","Feature"),
    ACCESSRIGHT("ACCESSRIGHT","Accessright"),
    CURRENCY("CURRENCY","Currency"),
    SUPPLIER("SUPPLIER", "Supplier"),
    SUPPLIER_TYPE("SUPPLIER_TYPE", "Supplier Type"),
    FOP("FOP","Fop Type Master"),
    DOMAIN("DOMAIN", "Domain");

    private final String code;
    private final String description;

    private Domain(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}