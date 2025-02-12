package com.vizsga.vizsgaproba.console.model;

public class Seller {
    private int id;
    private String name;
    private String phone;

    public Seller(int id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
