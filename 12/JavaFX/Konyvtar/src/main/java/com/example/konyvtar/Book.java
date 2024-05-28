package com.example.konyvtar;

public class Book {
    private String author;
    private String title;
    private int year;
    private int categoryIndex;
    private String acquisitionDate;
    private String category;

    public Book(String author, String title, int year, int categoryIndex, String acquisitionDate) {
        setAuthor(author);
        setTitle(title);
        setYear(year);
        setCategory(categoryIndex);
        setAcquisitionDate(acquisitionDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + getAuthor() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear() +
                ", category='" + getCategory() + '\'' +
                ", acquisitionDate='" + getAcquisitionDate() + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int categoryIndex) {
        String categorys[] = {"szépirodalom", "scifi", "nyelvkönyv", "tudomány"};
        this.category = categorys[categoryIndex];
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }
}
