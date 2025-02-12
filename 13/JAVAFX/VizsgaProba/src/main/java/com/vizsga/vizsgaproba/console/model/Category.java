package com.vizsga.vizsgaproba.console.model;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
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
}
