package com.ravskij;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectToAccess {

    public ConnectToAccess() throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Andrey\\Desktop\\KarandashShop.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Karandash");
            while(rs.next()){
                System.out.println(rs.getInt("baseid") + " " + rs.getString("basename") +  " "  + rs.getString("basedate"));
            }
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
