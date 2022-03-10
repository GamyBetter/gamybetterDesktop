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
    private String server = "";
    private String url = "jdbc:mysql://www.phpmyadmin.co:3306/db_structure.php?server=1&db=sql11472700";
    private String user = "root";
    private String password = "";
    private String database_name = "gamybetter";
    

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
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamybetter","root","");
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

}
