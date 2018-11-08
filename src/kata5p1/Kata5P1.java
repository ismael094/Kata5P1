package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Kata5P1 {
    
    public static void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Name") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
        + " id integer PRIMARY KEY AUTOINCREMENT,\n"
        + " mail text NOT NULL);";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        //selectAll();
        createNewTable();
    }
    
    private static Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:C:\\Users\\Usuario\\Prueba.db";
        conn = DriverManager.getConnection(url);
        return conn;
        
    }
    
}
