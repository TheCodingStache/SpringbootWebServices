package com.dmspallas.webservices.restfulwebservices.versioning;

public class ItemDetails {
    private String name;
    private String stock;
    private String balance;

    public ItemDetails(String name, String stock, String balance) {
        this.name = name;
        this.stock = stock;
        this.balance = balance;

    }

    public String getName() {
        return name;
    }

    public String getStock() {
        return stock;
    }

    public String getBalance() {
        return balance;
    }
}
