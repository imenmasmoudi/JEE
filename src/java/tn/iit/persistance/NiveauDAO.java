/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.iit.entities.Grade;
import tn.iit.entities.Niveau;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class NiveauDAO {
     public Niveau addNiveau(Niveau a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Insert into niveau values ('" + a.getId() + "','" + a.getLibelle() + "')";
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(NiveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeNiveau(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From niveau where id_niveau = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateNiveau(Niveau a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Update niveau set libelle= '" + a.getLibelle() + "' where id_niveau = '" + a.getId() + "';";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(NiveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Niveau> getNiveaux() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from niveau;";

        List<Niveau> list = new ArrayList<Niveau>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Niveau a = new Niveau(rs.getInt("id_niveau"), rs.getString("libelle"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NiveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Niveau getNiveauByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from niveau where id_niveau = '" + id + "';";
        Niveau a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Niveau(rs.getInt("id_niveau"), rs.getString("libelle"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NiveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
