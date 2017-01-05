package com.nawin.todo_mvp.data.models;

/**
 * Created by nawin on 1/4/17.
 */

public class RecentProducts {

    private int productID;
    private String productName;
    private String productImage;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
