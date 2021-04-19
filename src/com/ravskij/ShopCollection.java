package com.ravskij;

import java.util.ArrayList;

public class ShopCollection {
    private ArrayList<Shop> ShopList;

    public ShopCollection(){
        this.ShopList = new ArrayList<>();
    }

    public void add(Shop shop){
        ShopList.add(shop);
    }

    public void print(){
        for(Shop p : ShopList){
            System.out.println(p.getProductname() + " " + p.getDate());
        }
    }
}
