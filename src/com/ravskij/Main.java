package com.ravskij;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number, count = 0;
        do {
            System.out.println("Меню:" +
                    "\n0. Закрыть программу" +
                    "\n1. Открыть файл" +
                    "\n2. Сохранить файл" +
                    "\n3. Ввести данные" +
                    "\n4. Вывести данные");
            Scanner console = new Scanner(System.in);
            number = console.nextInt();
            String text = "";
            //    String text = "0 ручка 23/05/2021";
            Shop[] p = new Shop[1];
            switch (number){
                case 1:
                    System.out.println("Введите название файла: ");
                    Scanner openname = new Scanner(System.in);
                    String opentofile = openname.nextLine();
                    OpenFile open = new OpenFile(opentofile);
                //    text = open.Open();
                    //    System.out.println(opentofile);
                    break;
                case 2:
                    System.out.println("Введите название файла: ");
                    Scanner savename = new Scanner(System.in);
                    String savetofile = savename.nextLine();
                    SaveFile save = new SaveFile(text, savetofile);
                    save.Save();
                    //    System.out.println(savetofile);
                    break;
                case 3:
                //    p[count] = new Shop();
                    System.out.println("Введите наменование продукта: ");
                    Scanner nameofproduct = new Scanner(System.in);
                    String prodname = nameofproduct.nextLine();
                    p[count].setProductname(prodname);
                    System.out.println("Введите дату продажи: ");
                    Scanner dateofsale = new Scanner(System.in);
                    String daysale = dateofsale.nextLine();
                    p[count].setDate(daysale);
                    text = count + " " + prodname + " " + daysale;
                    System.out.println(text);
                    //    System.out.println(count);
                    //    count++;

                    for (Shop i : p) {
                        System.out.println(i.getProductname() + " день продажи " + i.getDate());
                    }
                    break;
                case 4:
                    for (Shop i : p) {
                        System.out.println(i.getProductname() + " день продажи " + i.getDate());
                    }
                    break;
                case 5:
                    ShopCollection shopCollection = new ShopCollection();
                    shopCollection.add(new Shop("hello", "world"));
                    shopCollection.add(new Shop("bb", "world!"));
                    shopCollection.print();
                    break;
                default:
                    break;
            }
        }
        while(number != 0);
    }
}