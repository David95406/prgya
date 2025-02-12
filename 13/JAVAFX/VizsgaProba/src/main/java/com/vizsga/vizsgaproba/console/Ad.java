package com.vizsga.vizsgaproba.console;

import com.vizsga.vizsgaproba.console.model.Category;
import com.vizsga.vizsgaproba.console.model.Seller;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ad {
    private int id;
    private String description;
    private int rooms;
    private int area;
    private int floors;
    private Category category;
    private Seller seller;
    private boolean freeOfCharge;
    private String imageUrl;
    private String latlong;
    private String createAt;

    public Ad(int id, String description, int rooms, int area, int floors, Category category, Seller seller,
              boolean freeOfCharge, String imageUrl, String latlong, String createAt) {
        setId(id);
        setDescription(description);
        setRooms(rooms);
        setArea(area);
        setFloors(floors);
        setCategory(category);
        setSeller(seller);
        setFreeOfCharge(freeOfCharge);
        setImageUrl(imageUrl);
        setLatlong(latlong);
        setCreateAt(createAt);
    }

    public Ad(String[] data) {
    //id;rooms;latlong;floors;area;description;freeOfCharge;imageUrl;createAt;sellerId;sellerName;sellerPhone;categoryId;categoryName
        this(
                Integer.parseInt(data[0]),
                data[5],
                Integer.parseInt(data[1]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[3]),
                new Category(Integer.parseInt(data[12]), data[13]),
                new Seller(Integer.parseInt(data[9]), data[10], data[11]),
                data[6].equals("1"),
                data[7],
                data[2],
                data[8]
        );
    }

    public static ArrayList<Ad> loadFromCsv() {
        RandomAccessFile raf;
        ArrayList<Ad> ads = new ArrayList<>();

        try {
            raf = new RandomAccessFile("realestates.csv", "r");
            raf.readLine();
            String line = raf.readLine();

            while (line != null) {
                String utf8 = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                ads.add(new Ad(utf8.split(";")));

                line = raf.readLine();
            }

        } catch (Exception e) {
            System.out.println("hiba: " + e);
        }

        return ads;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", rooms=" + getRooms() +
                ", area=" + getArea() +
                ", floors=" + getFloors() +
                ", category=" + getCategory() +
                ", seller=" + getSeller() +
                ", freeOfCharge=" + isFreeOfCharge() +
                ", imageUrl='" + getImageUrl() + '\'' +
                ", latlong='" + getLatlong() + '\'' +
                ", createAt='" + getCreateAt() + '\'' +
                '}';
    }

    public double[] getCords() {
        String[] data = getLatlong().split(",");
        return new double[]{Double.parseDouble(data[0]), Double.parseDouble(data[1])};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public boolean isFreeOfCharge() {
        return freeOfCharge;
    }

    public void setFreeOfCharge(boolean freeOfCharge) {
        this.freeOfCharge = freeOfCharge;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
