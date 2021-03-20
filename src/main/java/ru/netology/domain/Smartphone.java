package ru.netology.domain;

public class Smartphone extends Product {
    private String produser;

    public Smartphone(int id, String name, int price, String produser) {
        super(id, name, price);
        this.produser = produser;
    }

    public String getProduser() {
        return produser;
    }

}
