/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import gamybetter.Models.Personne;
import gamybetter.Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ServicePersonne implements IService<Personne> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override

    public void ajouter(Personne t) {
        try {
            String req = "INSERT INTO `personne` (`nom_personne`,`contact`,`rating`,`ig_rank`,`mot_de_passe`,`role`,`email`,`description`,`competence`,`jeux`,`heros`,`ig_name`,`ig_role`,`prix`, `id_equipe`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, t.getNom_personne());
            ps.setInt(2, t.getContact());
            ps.setInt(3, t.getRating());
            ps.setInt(4, t.getIg_rank());
            ps.setString(5, t.getMot_de_passe());
            ps.setString(6, t.getRole());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getDescription());
            ps.setString(9, t.getCompetence());
            ps.setString(10, t.getJeux());
            ps.setString(11, t.getHeros());
            ps.setString(12, t.getIg_name());
            ps.setString(13, t.getIg_role());
            ps.setFloat(14, t.getPrix());
            ps.setInt(15, t.getId_equipe());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> getAll() {
        List<Personne> list = new ArrayList<>();
        try {
            String req = "Select * from `personne`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Personne p = new Personne(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10), rs.getObject(11), rs.getObject(12), rs.getObject(13), rs.getObject(14), rs.getObject(15), rs.getObject(16));
                //Personne p = new Personne(); 
                System.out.println(p + "-------------------");
                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean modifier(Personne t) {
        String sql = "UPDATE `personne` SET id_personne=?,nom_personne=?,contact=?,rating=?,ig_rank=?,mot_de_passe=?,role=?,email=?,description=?,competence=?,jeux=?,heros=?,ig_name=?,ig_role=?, prix=?, id_equipe=?  WHERE id_personne=?";
        try {
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, t.getId_personne());
            statement.setString(2, t.getNom_personne());
            statement.setInt(3, t.getContact());
            statement.setInt(4, t.getRating());
            statement.setInt(5, t.getIg_rank());
            statement.setString(6, t.getMot_de_passe());
            statement.setString(7, t.getRole());
            statement.setString(8, t.getEmail());
            statement.setString(9, t.getDescription());
            statement.setString(10, t.getCompetence());
            statement.setString(11, t.getJeux());
            statement.setString(12, t.getHeros());
            statement.setString(13, t.getIg_name());
            statement.setString(14, t.getIg_role());
            statement.setFloat(15, t.getPrix());
            statement.setInt(16, t.getId_equipe());
            statement.setInt(17, t.getId_personne());

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
        String query = "select * from personne where id_personne=" + id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Personne p1 = new Personne(rs.getObject(1), rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6), rs.getObject(7), rs.getObject(8), rs.getObject(9), rs.getObject(10), rs.getObject(11), rs.getObject(12), rs.getObject(13), rs.getObject(14), rs.getObject(15), rs.getObject(16));

                return p1;
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

}
