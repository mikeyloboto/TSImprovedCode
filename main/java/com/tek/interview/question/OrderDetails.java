package com.tek.interview.question;

/*
 * represents an order details which contains the @link Item and the quantity.
 *
 */
public class OrderDetails {

    private int quantity;
    private ItemDetails itemDetails;

    /*
     * @param item Item of the order
     *
     * @param quantity Quantity of the item
     */
    public OrderDetails(ItemDetails itemDetails, int quantity) throws IllegalArgumentException {
        if (itemDetails == null) {
            System.err.println("ERROR - Item is NULL");
            throw new IllegalArgumentException("Item is NULL");
        }
        
        this.setItemDetails(itemDetails);
        this.quantity = quantity;
    }

    //Pojo Getter and Setters for private variables.

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetails itemDetails) {
        this.itemDetails = itemDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}