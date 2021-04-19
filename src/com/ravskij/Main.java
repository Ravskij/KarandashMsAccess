package com.ravskij;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Класс коллекции
        ShopCollection shopCollection = new ShopCollection();
        //Выбор пункта "меню"
        int number;
        //Бесконечный цикл для функционирования "меню"
        do {
            System.out.println("""
                    Меню:
                    0. Закрыть программу
                    1. Добавить данные в конец
                    2. Добавить данные в указанную позицию
                    3. Удаление данных
                    4. Открыть файл
                    5. Сохранить файл
                    6. Ввести данные""");


            Scanner console = new Scanner(System.in);
            number = console.nextInt();
            String text = "";
            //    String text = "0 ручка 23/05/2021";
            Shop[] p = new Shop[1];
            switch (number){
                //Добавляет данные в конец списка
                case 1:
                    //Класс для добавления наименования и даты
                    Scanner addprodname1 = new Scanner(System.in);
                    Scanner adddate1 = new Scanner(System.in);
                    System.out.println("Введите наименование: ");
                    String productname1 = addprodname1.nextLine();
                    System.out.println("Введите дату продажи: ");
                    String date1 = adddate1.nextLine();
                    shopCollection.add(new Shop(productname1, date1));
                //    shopCollection.print();
                    break;
                //Добавляет данные в указанную позицию
                case 2:
                    //Класс для добавления наименования, даты и индекса
                    Scanner addprodname2 = new Scanner(System.in);
                    Scanner adddate2 = new Scanner(System.in);
                    Scanner addindex2 = new Scanner(System.in);
                    System.out.println("Введите куда добавить запись: ");
                    String index2str = addindex2.nextLine();
                    //Преобразование строки к int
                    int index2int = Integer.parseInt(index2str) - 1;
                    System.out.println("Введите наименование: ");
                    String productname2 = addprodname2.nextLine();
                    System.out.println("Введите дату продажи: ");
                    String date2 = adddate2.nextLine();
                    shopCollection.addin(index2int, new Shop(productname2, date2));
                //    shopCollection.print();
                    break;
                //Удаляет данные из указанной позиции
                case 3:
                    //Класс для добавления индекса
                    Scanner addindex3 = new Scanner(System.in);
                    System.out.println("Введите какую запись удалить: ");
                    String index3str = addindex3.nextLine();
                    //Преобразование строки к int
                    int index3int = Integer.parseInt(index3str) - 1;
                    shopCollection.remove(index3int);
                //    shopCollection.print();
                    break;
                //Не работает
                case 4:
                    System.out.println("Введите название файла: ");
                    Scanner openname = new Scanner(System.in);
                    String opentofile = openname.nextLine();
                    OpenFile open = new OpenFile(opentofile);
                    //    text = open.Open();
                    //    System.out.println(opentofile);
                    break;
                //Не работает
                case 5:
                    System.out.println("Введите название файла: ");
                    Scanner savename = new Scanner(System.in);
                    String savetofile = savename.nextLine();
                    SaveFile save = new SaveFile(text, savetofile);
                    save.Save();
                    //    System.out.println(savetofile);
                    break;
                //Вывод данных
                case 6:
                    shopCollection.print();
                    break;
                default:
                    break;
            }
        }
        while(number != 0);
    }
}