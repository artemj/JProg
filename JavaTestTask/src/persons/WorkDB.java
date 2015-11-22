package persons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artem
 */
public class WorkDB {
    
    public static int id;
    public static String name;
    public static int age;
    public static String city;
    public static String type;
    public static int price;
    
    public static Connection connectDB() throws ClassNotFoundException,
            SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/People";
        String name = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, name, pass);
        return con;
    }
    
    public static String selectTableAllColumns(String nameTable) {
        String sql = ("SELECT * FROM " + nameTable);
        return sql;
    }
    
    public static String selectTableProperty() {
        String sql = ("SELECT `property`.`id`, `property`.`type`, "
                + "`person`.`name`, `property`.`price` FROM `person`,`property`"
                + "WHERE `person`.`id`=`property`.`person_id`"
                + "order by `property`.`id`");
        return sql;
    }
    
    public static void showTableOfFourColumns(DefaultTableModel model, 
            String sql) {
        try (Connection con = connectDB()) {
            try (Statement st = con.createStatement();
                    ResultSet res = st.executeQuery(sql)) {
                while (res.next()) {
                    String d1 = res.getString(1);
                    String d2 = res.getString(2);
                    String d3 = res.getString(3);
                    String d4 = res.getString(4);
                    model.addRow(new Object[]{d1, d2, d3, d4});
                }
            }
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
//    public static void showTableProperty (DefaultTableModel model){
//        
//    }
    
    public static void deletedTableColumns(DefaultTableModel model) {
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public static void deletedRecordFromPerson(DefaultTableModel model, 
            String id) throws ClassNotFoundException, SQLException{
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE `Person` FROM `Person`"
                    + "WHERE `person`.`id` = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } 
    }    
    
    public static void deletedRecordFromProperty(DefaultTableModel model, 
            String id) throws ClassNotFoundException, SQLException {
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE `Property` FROM `Property`"
                    + "WHERE `property`.`id` = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        }         
    }
    
    public static void getDataFromOneColumnsTable(JComboBox comboBox, 
            String nameTable, String nameColumn){
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("Select `" + nameColumn + 
                    "` from `" + nameTable + "`");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String item = res.getString(1);
                comboBox.addItem(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveRecordInPerson(String age, String city, String name){
        try {
            try (Connection con = connectDB()) {
                PreparedStatement ps;
                ps = con.prepareStatement("insert into person "
                        + "(id, name, age, city) values (NULL, ?,?,?)");
                ps.setString(1, name);
                ps.setString(2, age);
                ps.setString(3, city);
                ps.executeUpdate();
                ps.close();
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }       
    }
    
    public static void saveRecordInProperty(String type, String namePerson, 
            String price){
        int idPerson = 0;
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("Select `id` from `person` "
                    + "where `name` = '" + namePerson + "'");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                idPerson = Integer.valueOf(res.getString(1));
            }            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try (Connection con = connectDB()) {
                PreparedStatement ps;
                ps = con.prepareStatement("insert into property "
                        + "(id, type, person_id, price) values (NULL, ?,?,?)");
                ps.setString(1, type);
                ps.setInt(2, idPerson);
                ps.setString(3, price);
                ps.executeUpdate();
                ps.close();
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }       
    }
    
    public static void saveUpdateRecordInPerson(String name, int age, 
            String city, int id){
        try {
            try (Connection con = connectDB()) {
                PreparedStatement ps;
                ps = con.prepareStatement("update `person` set `name` = ?, "
                        + "age = ?, city = ? WHERE id = ?");
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, city);
                ps.setInt(4, id);
                ps.executeUpdate();
                ps.close();
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }       
    }
    
    public static void saveUpdateRecordInProperty(String type, String name, 
            int price, int id){
        int person_id = 0;
        try {
            try (Connection con = connectDB()) {
                PreparedStatement ps1, ps2;
                ps1 = con.prepareStatement("Select `id` from `person`"
                        + "where `name` = ?");
                ps1.setString(1, name);
                ResultSet res = ps1.executeQuery();
                while (res.next()) {
                    person_id = res.getInt(1);
                }
                ps2 = con.prepareStatement("update `property` set `type` = ?,"
                        + "`person_id` = ?, `price` = ? WHERE `id` = ?");
                ps2.setString(1, type);
                ps2.setInt(2, person_id);
                ps2.setInt(3, price);
                ps2.setInt(4, id);
                ps2.executeUpdate();
                ps2.close();
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }       
    }
    
    public static void clearAll(DefaultTableModel model) 
            throws ClassNotFoundException, SQLException {
        try (Connection con = connectDB()) {
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE FROM `People`.`Person`");
            ps.executeUpdate();
            ps.close();
        } 
    }
        
}
