package com.ravskij;

import java.util.Comparator;

class SortByProductname implements Comparator<Shop> {
    public int compare(Shop obj1, Shop obj2) {
        String str1 = ((Shop) obj1).getProductname();
        String str2 = ((Shop) obj2).getProductname();
        return str1.compareTo(str2);
    }
}

