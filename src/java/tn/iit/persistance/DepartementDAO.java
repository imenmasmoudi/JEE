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
import tn.iit.entities.Departement;
import tn.iit.entities.Niveau;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class DepartementDAO {

    public Departement addDepartement(Departement a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Insert into departement values ('" + a.getId() + "','" + a.getLibelle() + "','" + a.getId_enseignant() + "')";
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(DepartementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeDepartement(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From departement where id_departement = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDepartement(Departement a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Update departement set libelle= '" + a.getLibelle() + "',id_enseignant= '" + a.getId_enseignant() + "' where id_departement = '" + a.getId() + "';";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DepartementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Departement> getDepartements() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from departement;";

        List<Departement> list = new ArrayList<Departement>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Departement a = new Departement(rs.getInt("id_departement"), rs.getString("libelle"), rs.getInt("id_enseignant"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Departement getDepartementByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from departement where id_departement = '" + id + "';";
        Departement a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Departement(rs.getInt("id_departement"), rs.getString("libelle"),rs.getInt("id_enseignant"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
