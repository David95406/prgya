package com.example.contactlist;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ContactFormController {
    @FXML
    protected TextField nameInput, phoneInput, emailInput;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void back() {
        System.exit(0);
    }

    public void save() {
        String name = nameInput.getText();
        String phone = phoneInput.getText();
        String email = emailInput.getText();
        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("Üres mezok :(");
        }

        Contact ujContact = new Contact(name, phone, email);
        contacts.add(ujContact);
        System.out.println(contacts);
        for (Contact egyContact : contacts) {
            egyContact.save();
        }
        clearTextFields();
    }

    public void clearTextFields() {
        nameInput.setText(null);
        phoneInput.setText(null);
        emailInput.setText(null);
    }
}