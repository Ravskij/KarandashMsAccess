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
            while(rs.next()){
                text = text + rs.getString("basename") + "//" + rs.getString("basedate") + "//";
            }
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return text;
    }

    public void ConnectNSave() {
        urlstring = urlstring + urltoconnect;
        tablestring = tablestring + selecttable;
        try {
            Connection con = DriverManager.getConnection(urlstring); //"jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\KarandashShop.accdb"
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(tablestring); //"select * from Karandash"
            while(rs.next()){
                text = text + rs.getString("basename") + "//" + rs.getString("basedate") + "//";
            }
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
