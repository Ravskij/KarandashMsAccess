package com.ravskij;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
                    8. Сортировка по дате продажи
                    9. Создать таблицу в msAccess
                    10. Открыть таблицу msAccess
                    11. Сохранить в таблицу msAccess
                    12. Очистить коллекцию""");
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
                    try {
                        int index2int = Integer.parseInt(index2str) - 1;

                        System.out.println("Введите наименование: ");
                        String productname2 = addprodname2.nextLine();
                        System.out.println("Введите дату продажи: ");
                        String date2 = adddate2.nextLine();
                        shop.add(index2int, new Shop(productname2, date2));
                        System.out.println("Данные добавлены в " + index2str + " позицию");
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Невозможно добавить данные в " + index2str + " позицию");
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Введите число");
                    }
                    break;

                //Удаляет данные из указанной позиции
                case 3:
                    //Класс для добавления индекса
                    Scanner addindex3 = new Scanner(System.in);
                    System.out.println("Введите какую запись удалить: ");
                    String index3str = addindex3.nextLine();
                    //Преобразование строки к int
                    try {
                        int index3int = Integer.parseInt(index3str) - 1;
                        shop.remove(index3int);
                        System.out.println("Данные из " + index3str + " позиции удалены");
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Невозможно удалить данные из " + index3str + " позиции");
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Введите число");
                    }
                    break;

                //Вывод данных
                case 4:
                    if(!shop.isEmpty()) {
                        for (Shop o : shop){
                            System.out.println("Наименование: " + o.getProductname() + " дата продажи " + o.getDate());
                        }
                    }
                    //Если коллекция пуста
                    else {
                        System.out.println("Коллекция пуста");
                    }
                    break;

                //Открытие файла
                case 5:
                    //Очистка коллекции
                    shop.clear();
                    System.out.println("Введите название файла: ");
                    Scanner openname = new Scanner(System.in);
                    String opentofile = openname.nextLine();
                    try {
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
                            shop.add(new Shop(productnamefile, datefile));
                        }
                        System.out.println("Данные из файла прочитаны");
                    }
                    catch (IOException e){
                        System.out.println("Файл невозможно открыть");
                    }
                    break;

                //Сохранение файла
                case 6:
                    System.out.println("Введите название файла: ");
                    Scanner savename = new Scanner(System.in);
                    String savetofile = savename.nextLine();
                    try {
                    for (Shop o : shop) {
                        textbuilder.append("//").append(o.getProductname()).append("//").append(o.getDate());
                    }
                    SaveFile save = new SaveFile(textbuilder.toString(), savetofile);
                    save.Save();
                    System.out.println("Данные записаны в файл");
                    }
                    catch (IOException e){
                        System.out.println("Невозможно сохранить в файл");
                    }
                    break;

                //Сортировка по наименованию
                case 7:
                    //Если в коллекции есть данные то предлагает направление сортировки
                    if(!shop.isEmpty()) {
                        System.out.println("""
                                1. По убыванию
                                2. По возрастанию""");
                        Scanner sortn = new Scanner(System.in);
                        int sortnint = sortn.nextInt();
                        if (sortnint == 1) {
                            shop.sort(new SortByProductname());
                            System.out.println("Данные отсортированы по наименованию от A до Z");
                        } else if (sortnint == 2) {
                            shop.sort(new SortByProductname1());
                            System.out.println("Данные отсортированы по наименованию от Z до A");
                        } else {
                            System.out.println("Данные не были отсортированы");
                        }
                    }
                    //Если коллекция пуста
                    else{
                        System.out.println("Коллекция пуста");
                    }
                    break;

                //Сортировка по дате продажи
                case 8:
                    //Если в коллекции есть данные то предлагает направление сортировки
                    if(!shop.isEmpty()) {
                        System.out.println("""
                                1. По убыванию
                                2. По возрастанию""");
                        Scanner sortd = new Scanner(System.in);
                        int sortdint = sortd.nextInt();
                        if (sortdint == 1) {
                            shop.sort(new SortByDate());
                            System.out.println("Данные отсортированы по дате от наименьшего к большему");
                        } else if (sortdint == 2) {
                            shop.sort(new SortByDate1());
                            System.out.println("Данные отсортированы по дате от большего к наименьшему");
                        } else {
                            System.out.println("Данные не были отсортированы");
                        }
                    }
                    //Если коллекция пуста
                    else{
                        System.out.println("Коллекция пуста");
                    }
                    break;

                //Создать Таблицу в msAccess
                case 9:
                    System.out.println("Введите название файла целиком: ");
                    Scanner inputurlcreate = new Scanner(System.in);
                    String urltoconnectcreate = inputurlcreate.nextLine();
                    System.out.println("Введите название таблицы: ");
                    Scanner inputtablecreate = new Scanner(System.in);
                    String selecttablecreate = inputtablecreate.nextLine();
                    //Создание объекта
                    ConnectToAccess ctacreate = new ConnectToAccess(urltoconnectcreate, selecttablecreate);
                    ctacreate.ConnectNCreate(selecttablecreate);
                    break;

                //Открыть msAccess
                case 10:
                    if(!shop.isEmpty()) {
                        System.out.println("Введите название файла целиком: ");
                        Scanner inputurl = new Scanner(System.in);
                        String urltoconnect = inputurl.nextLine();
                        System.out.println("Введите название таблицы: ");
                        Scanner inputtable = new Scanner(System.in);
                        String selecttable = inputtable.nextLine();
                        //Создание объекта
                        ConnectToAccess cta = new ConnectToAccess(urltoconnect, selecttable);
                        //Текст из msAccess
                        text = cta.ConnectNOpen();
                        String[] splittext = text.split("//");
                        //Размер строки
                        int length = splittext.length;
                        //Создание добавление новго объекта в коллекцию
                        for (int i = 1; i < length; ) {
                            String productnamefile = splittext[i++];
                            String datefile = splittext[i++];
                            shop.add(new Shop(productnamefile, datefile));
                        }
                    }
                    else {
                        System.out.println("Коллекция пуста");
                    }
                    break;

                //Сохранить Коллекцию в msAccess
                case 11:
                    if(!shop.isEmpty()) {
                        System.out.println("Введите название файла целиком: ");
                        Scanner inputurlsave = new Scanner(System.in);
                        String urltoconnectsave = inputurlsave.nextLine();
                        System.out.println("Введите название таблицы: ");
                        Scanner inputtablesave = new Scanner(System.in);
                        String selecttablesave = inputtablesave.nextLine();
                        for (Shop o : shop) {
                            textbuilder.append("//").append(o.getProductname()).append("//").append(o.getDate());
                        }
                        ConnectToAccess ctasave = new ConnectToAccess(urltoconnectsave, selecttablesave);
                        ctasave.ConnectNSave(textbuilder.toString());
                    }
                    //Если коллекция пуста
                    else {
                        System.out.println("Коллекция пуста");
                    }
                    break;

                //Очистка коллекции
                case 12:
                    if(!shop.isEmpty()) {
                        shop.clear();
                        System.out.println("Коллекция очищена");
                    }
                    else {
                        System.out.println("Коллекция пуста");
                    }
                    break;
                default:
                    break;
            }
        }
        while(number != 0);
    }
}