package org.joe.lab.spring;

public class Products {

    private String image, description;
    private float price;

    public Products() {
        image = "";
        description = "";
        price = 0.0f;
    }

    public Products(String image, String description, float price) {
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
