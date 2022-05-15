/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import gamybetter.Models.Personne;
import gamybetter.Utils.Encryption;
import gamybetter.Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
  
public class ServicePersonne implements IService<Personne> {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date date = new Date(); 
    Connection cnx = DataSource.getInstance().getCnx();

    @Override

    public void ajouter(Personne t) {
        try {
            String req = "INSERT INTO `personne` (`nom`,`prenom`,`contact`,`username`,`age`,`mot_de_passe`,`role`,`email`,`description`,`DateofBirth`,`image`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            String passwordCryption = Encryption.crypt(t.getMot_de_passe());
            
            ps.setObject(1, t.getNom_personne());
            ps.setObject(2, t.getPrenom());
            ps.setInt(3, t.getContact());
            ps.setObject(4, t.getUsername());
            ps.setInt(5, t.getAge());
            ps.setObject(6, passwordCryption);
            ps.setObject(7, t.getRole());
            ps.setObject(8, t.getEmail());
            ps.setObject(9, t.getDescription());
            ps.setObject(10, formatter.format(date));
            ps.setObject(11, t.getImage());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> getAll() {
        List<Personne> list = new ArrayList<>();
        try {
            String req = "Select id_personne,`contact`,`age`,`nom`,`prenom`,`mot_de_passe`,`role`,`email`,`description`,`username`,`image`,`DateofBirth` from `personne`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Personne p = new Personne(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10), rs.getObject(11), rs.getObject(12));
                //Personne p = new Personne(); 
                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(Personne t) {
        String sql = "UPDATE `personne` SET `nom`=?,`prenom`=?,`contact`=?,`username`=?,`age`=?,`mot_de_passe`=?,`role`=?,`email`=?,`description`=?,`DateofBirth`=?,`image`=? WHERE id_personne=?";
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            String passwordCryption = Encryption.crypt(t.getMot_de_passe());
            
             statement.setObject(1, t.getNom_personne());
            statement.setObject(2, t.getPrenom());
            statement.setInt(3, t.getContact());
            statement.setObject(4, t.getUsername());
            statement.setInt(5, t.getAge());
            statement.setObject(6, passwordCryption);
            statement.setObject(7, t.getRole());
            statement.setObject(8, t.getEmail());
            statement.setObject(9, t.getDescription());
            statement.setObject(10, formatter.format(date));
            statement.setObject(11, t.getImage());
            statement.setInt(12, t.getId_personne());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully");
                return true;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean supprimer(Personne t) {
        String sql = "DELETE FROM personne WHERE id_personne=?";
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setObject(1, t.getId_personne());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
    }

    @Override
    public Personne getById(int id) {
        String query = "select id_personne,`contact`,`age`,`nom`,`prenom`,`mot_de_passe`,`role`,`email`,`description`,`username`,`image`,`DateofBirth` from personne where id_personne=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Personne p = new Personne(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10), rs.getObject(11), rs.getObject(12));

                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Personne();
    }

    @Override
    public Personne getOne(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Personne getByMail(String email) {
        String query = "select * from personne where email=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Personne p = new Personne(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10), rs.getObject(11), rs.getObject(12));
                System.out.println(p);
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
    

}
