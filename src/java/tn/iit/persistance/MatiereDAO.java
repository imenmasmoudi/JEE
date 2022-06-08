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
import tn.iit.entities.Matiere;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class MatiereDAO {
    
    public Matiere addMatiere(Matiere a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Insert into matiere values ('" + a.getId_matiere() + "','" + a.getLibelle() + "','" + a.getCh_cours() + "','" + a.getCh_tp() + "','" + a.getCh_td() + "','" + a.getId_departement() + "','" + a.getId_niveau() + "','" + a.getId_enseignant() + "')";
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(MatiereDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeMatiere(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From matiere where id_matiere = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMatiere(Matiere a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Update matiere set id_matiere = '" + a.getId_matiere() + "',libelle = '" + a.getLibelle() + "', ch_cours ='" + a.getCh_cours() + "', ch_tp ='" + a.getCh_tp() + "', ch_td = '" + a.getCh_td() +"', id_departement = '" + a.getId_departement() + "', id_niveau = '" + a.getId_niveau() + "', id_enseignant = '" + a.getId_enseignant() + "';";
        System.out.println(req);
        try {
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Matiere> getMatieres() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from matiere;";

        List<Matiere> list = new ArrayList<Matiere>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Matiere a = new Matiere(rs.getInt("id_matiere"), rs.getString("libelle"),rs.getFloat("ch_cours"),rs.getFloat("ch_tp"),rs.getFloat("ch_td"),rs.getInt("id_departement"),rs.getInt("id_niveau"),rs.getInt("id_enseignant"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatiereDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Matiere getMatiereByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from matiere where id_matiere = '" + id + "';";
        Matiere a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Matiere(rs.getInt("id_matiere"), rs.getString("libelle"),rs.getFloat("ch_cours"),rs.getFloat("ch_tp"),rs.getFloat("ch_td"),rs.getInt("id_departement"),rs.getInt("id_niveau"),rs.getInt("id_enseignant"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatiereDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
