package com.ravskij;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectToAccess {

    private String urltoconnect = "";
    private String urlstring = "jdbc:ucanaccess://H:\\programs\\Ij\\project\\";
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
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://H:\programs\Ij\project\\KarandashShop.accdb"
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
        try {
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://H:\programs\Ij\project\\KarandashShop.accdb"
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(tablestring); //"select * from Karandash"
            String[] splittext = textcollection.split("//");
            int length = splittext.length;
            int countid = 1;
            while(rs.next()) {
                countid = rs.getInt("baseid") + 1;
            }
            System.out.println(countid);
            for (int num = 1; num < length; ) {
                String textforsave = "INSERT INTO " + selecttable + " (baseid, basename, basedate) \n" +
                        " VALUES (" + countid + ", '" + splittext[num++] + "', '" + splittext[num++] + "');";
                countid++;
                stmt.executeUpdate(textforsave); //"select * from Karandash"
            }
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
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://H:\programs\Ij\project\\KarandashShop.accdb"
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
