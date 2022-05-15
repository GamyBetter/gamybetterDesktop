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
    private String url = "jdbc:mysql://localhost:3306/pidev";
    private String user = "root";
    private String password = "";
    private String database_name = "esprit3a21";
    

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
            CurrentUser.setCurrentUser(2);
            cnx = DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Connected to Database !");
        } catch (SQLException ex) {
            System.out.println("Error here"+ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }


    public Connection getCnx() {
        return cnx;
    }
}
