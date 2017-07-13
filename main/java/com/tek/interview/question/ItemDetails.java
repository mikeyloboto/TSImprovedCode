package com.tek.interview.question;

 
/*
 * represents an item details, contains a price and a description.
 *
 */
public class ItemDetails {

    private String description;
    private float price;

    public ItemDetails(String description, float price) {
        super();
        this.description = description;
        this.price = price;
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
