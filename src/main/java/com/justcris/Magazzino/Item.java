package com.justcris.Magazzino;

public class Item {
    private int id;
    private String title;
    private Double price;
    private int quantity;
    private String image;

    public Item() {
    }

    public Item(int id, String title, Double price, int quantity, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public Item(int id, String title, Double price, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeQuantity(int i) {
        this.quantity -= i;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                '}';
    }
}

