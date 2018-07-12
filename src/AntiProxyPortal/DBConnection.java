/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntiProxyPortal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {
    
    static Connection connection = null;
    static String databaseName = "user_database";
    static String username = "root";
    static String password = "harshitjindal";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName+"?autoReconnect=true&useSSL=false";
    
    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps = connection.prepareStatement("SHOW DATABASES;");
        
        int status = ps.executeUpdate();
        if (status != 0){
            System.out.println("Database Connnection Successful");
            ps.close();
            connection.close();
            if (connection.isClosed()){
                System.out.println("Database Connection Terminated on Command by Administrator");
            }
        }else{
            System.out.println("Database Connection FAILED");
        }
        
 
    }
        
}


