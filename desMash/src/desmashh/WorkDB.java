/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desmashh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artem
 */
public class WorkDB {

    public static Connection connectDB() throws ClassNotFoundException,
            SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/desMash";
        String name = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, name, pass);
        return con;
    }

    public static String selectTable(String nameTable) {
        String sql = ("SELECT * FROM " + nameTable);
        return sql;
    }

    public static String selectTable(String nameTable, String condition) throws SQLException, ClassNotFoundException {
        String sql = ("SELECT * FROM " + nameTable + " WHERE " + condition);
        return sql;
    }

    public static String postNewOrder(javax.swing.JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int countRow = model.getRowCount(); //количество строк
        java.util.Date a = java.util.Calendar.getInstance().getTime(); //текущая дата и время
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM-HH:mm");//формат вывода даты
        String date = formatDate.format(a);
        for (int i = 0; i < countRow; i++) {
            if (model.getValueAt(i, 1).equals(Integer.toString(0))) { //сравниваем с 0 каждый второй элемент            
            } else {
                String name = model.getValueAt(i, 0).toString();
                String quantity = model.getValueAt(i, 1).toString();
                try (Connection con = connectDB()) {
                    PreparedStatement ps;
                    ps = con.prepareStatement("INSERT INTO `desMash`.`Orders` "
                            + "(`Date`, `Name`, `Quantity`) "
                            + "VALUES (?, ?, ?);");
                    ps.setString(1, date);
                    ps.setString(2, name);
                    ps.setString(3, quantity);
                    ps.executeUpdate();
                    ps.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO `desMash`.`ListOrders` "
                    + "(`id`, `Date`) VALUES (NULL, ?);");
            ps.setString(1, date);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return date;
    }

    public static void showTableOfTwoColumns(DefaultTableModel model, String sql, int firstColumn, int secondColumn) {
        try (Connection con = connectDB()) {
            try (java.sql.Statement st = con.createStatement();
                    ResultSet res = st.executeQuery(sql)) {
                while (res.next()) {
                    String d1 = res.getString(firstColumn);
                    String d2 = res.getString(secondColumn);
                    model.addRow(new Object[]{d1, d2});
                }
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
