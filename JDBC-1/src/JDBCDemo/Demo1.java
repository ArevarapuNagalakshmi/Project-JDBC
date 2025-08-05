package JDBCDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/textdb";
        String user = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database...");

            Statement stmt = con.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50))";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table Checked/Created...");

            String insert1 = "INSERT IGNORE INTO student (id, name) VALUES (3, 'Naga')";
            String insert2 = "INSERT IGNORE INTO student (id, name) VALUES (4, 'Lakshmi')";
            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            System.out.println("Sample Data Inserted...");

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            System.out.println("ID\tName");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "\t" + name);
            }

            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection Closed...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

