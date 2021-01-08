package com.example.signupandsigninandroid;

public class Product {
    private int id;
    private String name;
//    private String image;
    private byte[] image;
    private int quality;
    private int price;

   public Product(int id, String name, byte[] image, int quality, int price) {
       this.id=id;
       this.name=name;
       this.image = image;
       this.quality = quality;
       this.price = price;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
