/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desmashh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Artem
 */
public class WorkDB {
    
    public static Connection ConnectDB() throws ClassNotFoundException, 
            SQLException {
        Class.forName("com.mysql.jdbc.Driver");  
        String url = "jdbc:mysql://localhost:3306/desMash";
        String name = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, name, pass);
        return con;
    }
    
    public static String SelectTable(String nameTable) {
        String sql = ("SELECT * FROM " + nameTable);
        return sql;
    }
    
    public static String SelectTable (String nameTable, String condition){
        String sql = ("SELECT * FROM " + nameTable + " WHERE " + condition);
        return sql;
    }
    
    
}
