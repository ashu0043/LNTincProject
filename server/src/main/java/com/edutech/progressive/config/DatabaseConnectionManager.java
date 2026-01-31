package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionManager {
   
    private static final Properties properties = new Properties();

    private static void loadProperties()throws IOException{
        properties.load(new FileInputStream("/home/coder/app/server/src/main/resources/application.properties"));
    }
    public static Connection getConnection()throws SQLException{
        try{
        loadProperties();
        }
        catch(IOException e){
            System.out.println(e);
        }
        return DriverManager.getConnection(properties.getProperty("spring.datasource.url"),
        properties.getProperty("spring.datasource.username"), properties.getProperty("spring.datasource.password"));
    }

}
