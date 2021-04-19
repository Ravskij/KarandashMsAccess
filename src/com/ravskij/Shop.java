package com.ravskij;

public class Shop {
    private String productname;
    private String date;

    public Shop(String productname, String date){
        this.productname = productname;
        this.date = date;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
