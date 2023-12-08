package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Exception;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection(){
        String databaseName="quizfx";
        String databaseUser="root";
        String databasePassword="Mask@2004";
        String url="jdbc:mysql://localhost/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
