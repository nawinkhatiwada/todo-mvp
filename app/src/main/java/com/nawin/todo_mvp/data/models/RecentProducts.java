package com.nawin.todo_mvp.data.models;

/**
 * Created by nawin on 1/4/17.
 */

public class RecentProducts {

    private int productID;
    private int productName;
    private int productImage;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
