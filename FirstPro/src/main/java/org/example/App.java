package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
//            step 1 load the driver
            Class.forName("com.mysql.jdbc.Driver");
//            step 2 connect with db
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aj_2324_db",
                    "root",
                    "");
//            step 3 create statement
//            Statement statement = connection.createStatement();
//            String q = "insert into student_details(student_name, student_city, student_age) values(?,?,?)";
//            PreparedStatement ps = connection.prepareStatement(q);





//            ps.setString(1,"Arzoo");
//            ps.setString(2,"City");
//            ps.setInt(3,35);
//            ps.executeUpdate();

//            String qry = "insert into student_details(student_name,student_city,student_age)" +
//                    " values('Dev','Rajkot',21)";
////            String qry = "update student_details set student_status = 0 where student_city = 'Rajkot'";
//             qry = "delete from student_details  where student_age > 40";
//            int affectedRows = statement.executeUpdate(qry);
//            System.out.println("Total "+affectedRows+" row/s affected");
////            step 4 execute the query
//             qry = "select * from student_details";
//            ResultSet rs = statement.executeQuery(qry);
////            step 5 display the result
//            while(rs.next()){
//                System.out.println(rs.getString("student_name"));
//            }
            CallableStatement c = connection.prepareCall("{call fetch_student(?)}");
            c.setInt(1,1);
            ResultSet rs = c.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("student_name")+" "+rs.getString("student_city"));
            }
//            step 6
            connection.close();

        } catch (ClassNotFoundException|SQLException e) {
           // System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
