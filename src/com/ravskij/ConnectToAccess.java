package com.ravskij;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectToAccess {

    private String urltoconnect = "";
    private String urlstring = "jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\";
    private String selecttable = "";
    private String tablestring = "select * from ";
    private String text = "//";

    public ConnectToAccess(String urltoconnect, String selecttable) {
        this.urltoconnect = urltoconnect;
        this.selecttable = selecttable;
    }

    public String ConnectNOpen() {
        urlstring = urlstring + urltoconnect;
        tablestring = tablestring + selecttable;
        try {
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\KarandashShop.accdb"
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(tablestring); //"select * from Karandash"
            while(rs.next()) {
                text = text + rs.getString("basename") + "//" + rs.getString("basedate") + "//";
            }
            con.close();
            System.out.println("Table successfully opened");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void ConnectNSave(String textcollection) {
        urlstring = urlstring + urltoconnect;
        tablestring = tablestring + selecttable;
        int i = 0;
        int f = 0;
        try {
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\KarandashShop.accdb"
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(tablestring); //"select * from Karandash"
            while(rs.next()) {
                i = rs.getInt("baseid") + 1;
            }
        //    String textforsave = "INSERT INTO " + selecttable + " (baseid, basename, basedate) \n" +
        //            " VALUES (" + i + ", 'Headsfsdfsdfsfsdfsdd', '25/04/2021');";
            String[] splittext = textcollection.split("//");
            int length = splittext.length;
            for (int q = 1; q < length; ) {
                String textforsave = "INSERT INTO " + selecttable + " (baseid, basename, basedate) \n" +
                        " VALUES (" + f + ", '" + splittext[q++] + "', '" + splittext[q++] + "');";
                f++;
                stmt.executeUpdate(textforsave); //"select * from Karandash"
            }
        //    stmt.executeUpdate(textforsave); //"select * from Karandash"
            con.close();
            System.out.println("Table successfully saved");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void ConnectNCreate(String tablename) {
        urlstring = urlstring + urltoconnect;
        tablestring = tablestring + selecttable;
        try {
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\KarandashShop.accdb"
            Statement stmt = con.createStatement();
            String SQL = "CREATE TABLE " + tablename + "  \n" +
                    "(  \n" +
                    "    baseid int NOT NULL  \n" +
                    "    ,basename varchar(50) NULL  \n" +
                    "    ,basedate varchar(50) NULL  \n" +
                    ");";
            stmt.executeUpdate(SQL);
            System.out.println("Table successfully created");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
