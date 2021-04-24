package com.ravskij;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Создание Коллекции shop
        ArrayList<Shop> shop = new ArrayList<>();
        //Выбор пункта "меню"
        int number;
        //Бесконечный цикл для функционирования "меню"
        do {
            System.out.println("""
                    Меню:
                    0. Закрыть программу
                    1. Добавить данные в конец
                    2. Добавить данные в указанную позицию
                    3. Удалить данные
                    4. Вывести данные
                    5. Открыть файл
                    6. Сохранить файл
                    7. Сортировка по наименованию
                    8. Сортировка по дате продажи""");
            //Выбор пункта меню через консоль
            Scanner console = new Scanner(System.in);
            number = console.nextInt();
            String text;
            StringBuilder textbuilder = new StringBuilder();
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
                    shop.add(new Shop(productname1, date1));
                    System.out.println("Данные добавлены");
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
                    shop.add(index2int, new Shop(productname2, date2));
                    System.out.println("Данные добавлены на " + index2int + " позицию");
                    break;

                //Удаляет данные из указанной позиции
                case 3:
                    //Класс для добавления индекса
                    Scanner addindex3 = new Scanner(System.in);
                    System.out.println("Введите какую запись удалить: ");
                    String index3str = addindex3.nextLine();
                    //Преобразование строки к int
                    int index3int = Integer.parseInt(index3str) - 1;
                    shop.remove(index3int);
                    System.out.println("Данные из " + index3int + " позиции удалены");
                    break;

                //Вывод данных
                case 4:
                    for (Shop o : shop){
                        System.out.println("Наименование: " + o.getProductname() + " дата продажи " + o.getDate());
                    }
                    break;

                //Открытия файла
                case 5:
                    //Очистка коллекции
                    shop.clear();
                    System.out.println("Введите название файла: ");
                    Scanner openname = new Scanner(System.in);
                    String opentofile = openname.nextLine();
                    OpenFile open = new OpenFile(opentofile);
                    textbuilder = new StringBuilder(open.Open());
                    //Преобразование StringBuilder к String
                    text = textbuilder.toString();
                    //Разделение строки по "//"
                    String[] splittext = text.split("//");
                    //Размер строки
                    int length = splittext.length;
                    //Создание объекта
                    for (int i = 1; i < length; ) {
                        String productnamefile = splittext[i++];
                        String datefile = splittext[i++];
                    //    System.out.println("Наименование " + productnamefile + " дата " + datefile);
                        shop.add(new Shop(productnamefile, datefile));
                    }
                    break;

                //Сохранение файла
                case 6:
                    System.out.println("Введите название файла: ");
                    Scanner savename = new Scanner(System.in);
                    String savetofile = savename.nextLine();
                    for (Shop o : shop) {
                        textbuilder.append("//").append(o.getProductname()).append("//").append(o.getDate());
                    }
                    SaveFile save = new SaveFile(textbuilder.toString(), savetofile);
                    save.Save();
                    break;

                //Сортировка по наименованию
                case 7:
                    Collections.sort(shop, new SortByProductname());
                    System.out.println("Отсортировано по наименованию");
                    break;

                //Сортировка по дате продажи
                case 8:
                    Collections.sort(shop, new SortByDate());
                    System.out.println("Отсортировано по дате продажи");
                    break;
                default:
                    break;
            }
        }
        while(number != 0);
    }
}