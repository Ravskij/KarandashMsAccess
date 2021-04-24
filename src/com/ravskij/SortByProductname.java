package com.ravskij;

import java.util.Comparator;

class SortByProductname implements Comparator<Shop> {
    public int compare(Shop o1, Shop o2) {
        String str1 = ((Shop) o1).getProductname();
        String str2 = ((Shop) o2).getProductname();
        return str1.compareTo(str2);
    }
}

