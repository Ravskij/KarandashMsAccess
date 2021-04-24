package com.ravskij;

import java.util.Comparator;

class SortByDate implements Comparator<Shop> {
    public int compare(Shop o1, Shop o2) {
        String str1 = o1.getDate();
        String str2 = o2.getDate();
        String[] date1 = str1.split("/");
        String[] date2 = str2.split("/");
        int day1 = Integer.parseInt(date1[0]);
        int month1 = Integer.parseInt(date1[1]);
        int age1 = Integer.parseInt(date1[2]);
        int day2 = Integer.parseInt(date2[0]);
        int month2 = Integer.parseInt(date2[1]);
        int age2 = Integer.parseInt(date2[2]);
        if(age1 > age2){
            return 1;
        }
        else if(age1 < age2) {
            return -1;
        }
        else{
            if(month1 > month2){
                return 1;
            }
            else if(month1 < month2) {
                return -1;
            }
            else{
                if(day1 > day2){
                    return 1;
                }
                else if(day1 < day2) {
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }
}

