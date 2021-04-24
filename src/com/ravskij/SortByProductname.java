package com.ravskij;

import java.util.Comparator;

class SortByProductname implements Comparator<Shop> {
    public int compare(Shop o1, Shop o2) {
        String str1 = o1.getProductname();
        String str2 = o2.getProductname();
        return str1.compareTo(str2);
    }
}

class SortByProductname1 implements Comparator<Shop> {
    public int compare(Shop o1, Shop o2) {
        String str1 = o1.getProductname();
        String str2 = o2.getProductname();
        return str2.compareTo(str1);
    }
}

