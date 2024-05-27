package com.example.contactlist;

import javafx.fxml.FXML;

import java.io.RandomAccessFile;

public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) throws IllegalArgumentException {
        setName(name);
        setPhone(phone);
        setEmail(email);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }

    private String getData() {
        return getEmail() + "-" + getPhone() + "-" + getEmail();
    }

    protected void save() {
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("contacts.txt", "rw");
            raf.writeBytes(this.getData());
        } catch (Exception e) {
            System.out.println("Hiba: " + e);
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Hibas email!");
        }
    }
}
