/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.persistance;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.iit.entities.Enseignant;
import tn.iit.entities.Niveau;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class EnseignantDAO {
    
    public Enseignant addEnseignant(Enseignant a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Insert into enseignant values ('" + a.getId() + "','" + a.getCin() + "','" + a.getPrenom() + "','" + a.getNom() + "','" + a.getAdresse() + "','" + a.getEmail() + "','" + a.getPhone() + "','" + a.getLogin() + "','" + a.getPassword() + "','" + a.getId_grade() + "')";
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeEnseignant(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From enseignant where id_enseignant = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEnseignant(Enseignant a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Update enseignant set id_enseignant= '" + a.getId() + "',cin = '" + a.getCin() + "', prenom ='" + a.getPrenom() + "', nom ='" + a.getNom() + "', adresse = '" + a.getAdresse() +"', email = '" + a.getEmail() + "', phone = '" + a.getPhone() + "', login = '" + a.getLogin() + "', password = '" + a.getPassword() + "', id_grade = '" + a.getId_grade() + "' where id_enseignant = '" + a.getId() + "';";
        System.out.println(req);
        try {
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Enseignant> getEnseignants() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from enseignant;";

        List<Enseignant> list = new ArrayList<Enseignant>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Enseignant a = new Enseignant(rs.getInt("id_enseignant"), Integer.parseInt(rs.getString("cin")),rs.getString("prenom"),rs.getString("nom"),rs.getString("adresse"),rs.getString("email"),Integer.parseInt(rs.getString("phone")),rs.getString("login"),rs.getString("password"),Integer.parseInt(rs.getString("id_grade")));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Enseignant getEnseignantByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from enseignant where id_enseignant = '" + id + "';";
        Enseignant a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Enseignant(rs.getInt("id_enseignant"), Integer.parseInt(rs.getString("cin")),rs.getString("prenom"),rs.getString("nom"),rs.getString("adresse"),rs.getString("email"),Integer.parseInt(rs.getString("phone")),rs.getString("login"),rs.getString("password"),Integer.parseInt(rs.getString("id_grade")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
   
    
}
