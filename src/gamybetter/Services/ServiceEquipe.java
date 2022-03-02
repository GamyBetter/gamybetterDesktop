/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.modeles.Equipe;
import tn.edu.esprit.utils.DataSource;

/**
 *
 * @author snoussi amine
 */
public class ServiceEquipe implements IService<Equipe> {
    Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void add(Equipe t) {
       String query = "INSERT INTO `equipe`(`id_equipe`, `id_coach`, `nom_eq`, `description_equipe`, `nom_coach`, `membre_equipe1`, `membre_equipe2`, `membre_equipe3`, `membre_equipe4`, `membre_equipe5`, `match`) VALUES ('" + t.getId_equipe() + "','" + t.getId_coach() + "','" + t.getNom_eq() + "','" +t.getDescription_equipe() + "','" + t.getNom_coach() + "','" + t.getMembre_equipe1() + "','" + t.getMembre_equipe2() + "','" + t.getMembre_equipe3() + "','" + t.getMembre_equipe4() + "','" + t.getMembre_equipe5() + "','" + t.getMatch() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean update(Equipe t) {
        String query = "UPDATE `equipe` SET `id_coach`=?,`nom_eq`=?,`description_equipe`=?,`nom_coach`=?,`membre_equipe1`=?,`membre_equipe2`=?,`membre_equipe3`=?,`membre_equipe4`=?,`membre_equipe5`=?,`match`=? WHERE `id_equipe`=" + t.getId_equipe();
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setObject(1, t.getId_coach());
            statement.setObject(2, t.getNom_eq());
            statement.setObject(3, t.getDescription_equipe());
            statement.setObject(4, t.getNom_coach());
            statement.setObject(5, t.getMembre_equipe1());
            statement.setObject(6, t.getMembre_equipe2());
            statement.setObject(7, t.getMembre_equipe3());
            statement.setObject(8, t.getMembre_equipe4());
            statement.setObject(9, t.getMembre_equipe5());
            statement.setObject(10, t.getMatch());
           
            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(Equipe t) {
        String query = "DELETE FROM equipe where id_equipe=? ";

        boolean rowDeleted = false;
        try {
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, t.getId_equipe());
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowDeleted;
    }

    @Override
    public List<Equipe> getAll() {
        List<Equipe> list = new ArrayList<>();
        String query = "Select * from `equipe`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Equipe e = new Equipe(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9),rs.getObject(10),rs.getObject(11));
                list.add(e);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Equipe getOne(Equipe t) {
       System.out.println(t.getId_equipe()+ "---80");
        String query = "select * from `equipe` where id_equipe=" + t.getId_equipe();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Equipe e = new Equipe(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9),rs.getObject(10),rs.getObject(11));
                return e;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Equipe();
    }

    @Override
    public Equipe getById(int id) {
        String query = "select * from equipe where id_equipe=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Equipe e = new Equipe(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9),rs.getObject(10),rs.getObject(11));

                return e;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Equipe();
    }
    
}
