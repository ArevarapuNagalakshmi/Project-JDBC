package JDBCDemo;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/textdb";
        String user="root";
        String password="root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to Database...");
            Statement stmt=con.createStatement();
            String query="Select * From student";
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("ID\tName");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                System.out.println(id +"\t"+name);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
