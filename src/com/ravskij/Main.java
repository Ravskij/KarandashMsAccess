package com.ravskij;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        //Класс коллекции
        ShopCollection shopCollection = new ShopCollection();
        //Выбор пункта "меню"
        int number;
        //Бесконечный цикл для функционирования "меню"
        do {
            System.out.println("""
                    Меню:
                    0. Закрыть программу
                    1. Открыть файл
                    2. Сохранить файл
                    3. Ввести данные
                    4. Вывести данные
                    5. Добавить данные в конец
                    6. Добавить данные в указанную позицию""");


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
                    //Класс для добавления наименования и даты
                    Scanner addprodname5 = new Scanner(System.in);
                    Scanner adddate5 = new Scanner(System.in);
                    System.out.println("Введите наименование: ");
                    String productname5 = addprodname5.nextLine();
                    System.out.println("Введите дату продажи: ");
                    String date5 = adddate5.nextLine();
                    shopCollection.add(new Shop(productname5, date5));
                    shopCollection.print();
                    break;
                case 6:
                    //Класс для добавления наименования и даты
                    Scanner addprodname6 = new Scanner(System.in);
                    Scanner adddate6 = new Scanner(System.in);
                    Scanner addindex6 = new Scanner(System.in);
                    System.out.println("Введите куда добавить запись: ");
                    String index6str = addindex6.nextLine();
                    //Преобразование строки к int
                    int index6int = Integer.parseInt(index6str) - 1;
                    System.out.println("Введите наименование: ");
                    String productname6 = addprodname6.nextLine();
                    System.out.println("Введите дату продажи: ");
                    String date6 = adddate6.nextLine();
                    shopCollection.addin(index6int, new Shop(productname6, date6));
                    shopCollection.print();
                    break;
                case 7:
                //    Arrays.sort(p, new SortByDate());
                //    for(Shop i : p){
                //        System.out.println(i.getProductname() + " " + i.getDate());
                //    }
                    shopCollection.print();
                    break;
                default:
                    break;
            }
        }
        while(number != 0);
    }
}