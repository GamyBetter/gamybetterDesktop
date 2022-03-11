/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author skon1
 */
public class DataSource {

    private Connection cnx;
    private String server = "sql11.freesqldatabase.com";
    private String url = "https://www.phpmyadmin.co/";
    private String user = "sql11472700";
    private String password = "ZzGwufiEDM";
    private String database_name = "sql11472700";
    

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
            return instance;
        } else {
            return instance;
        }
    }

    private DataSource() {
        
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev","root","");
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        
        return cnx;
    }

}
