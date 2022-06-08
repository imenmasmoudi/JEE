/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.iit.entities.Seance;
import tn.iit.utils.JdbcUtils;

/**
 *
 * @author tunin
 */
public class SeanceDAO {

    public Seance addSeance(Seance a) {
        Statement st = JdbcUtils.getStatement();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(a.getDate());

        formatter = new SimpleDateFormat("HH:mm:ss");
        String heure = formatter.format(a.getH_debut());

        String req = "Insert into seance values ('" + a.getId_seance() + "','" + date + "','" + heure + "','" + a.getDuree() + "','" + a.getMethode() + "','" + 0 + "','" + a.getType() + "','" + a.getId_matiere() + "','" + a.getId_enseignant() + "')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeSeance(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From seance where id_seance = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSeance(Seance a) {
        Statement st = JdbcUtils.getStatement();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(a.getDate());

        formatter = new SimpleDateFormat("HH:mm:ss");
        String heure = formatter.format(a.getH_debut());

        int valide = (a.isValide()) ? 1 : 0;

        String req = "Update seance set id_seance = '" + a.getId_seance() + "',date = '" + date + "', h_debut ='" + heure + "', duree='" + a.getDuree() + "', methode_ens = '" + a.getMethode() + "', valide = '" + valide + "', type = '" + a.getType() + "', id_matiere = '" + a.getId_matiere() + "', id_enseignant = '" + a.getId_enseignant() + "' where id_seance='" + a.getId_seance() + "';";
        System.out.println(req);
        try {
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Seance> getSeances() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from seance;";

        List<Seance> list = new ArrayList<Seance>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Date date = null;

                date = rs.getDate("date");
                //rs.gett
                /*try {
                    date=new SimpleDateFormat("yyyy/MM/dd").parse(rs.getString("date"));
                } catch (ParseException ex) {
                    Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Seance a = new Seance(rs.getInt("id_seance"), date, rs.getTime("h_debut"), rs.getFloat("duree"), rs.getString("methode_ens"), rs.getBoolean("valide"), rs.getString("type"), rs.getInt("id_matiere"), rs.getInt("id_enseignant"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Seance getSeanceByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from seance where id_seance = '" + id + "';";
        Seance a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Seance(rs.getInt("id_seance"), rs.getDate("date"), rs.getDate("h_debut"), rs.getFloat("duree"), rs.getString("methode_ens"), rs.getBoolean("valide"), rs.getString("type"), rs.getInt("id_matiere"), rs.getInt("id_enseignant"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public List<Seance> getSeancesByIdEnseignant(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from seance where id_enseignant = '" + id + "';";

        List<Seance> list = new ArrayList<Seance>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Date date = null;

                date = rs.getDate("date");
                //rs.gett
                /*try {
                    date=new SimpleDateFormat("yyyy/MM/dd").parse(rs.getString("date"));
                } catch (ParseException ex) {
                    Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Seance a = new Seance(rs.getInt("id_seance"), date, rs.getTime("h_debut"), rs.getFloat("duree"), rs.getString("methode_ens"), rs.getBoolean("valide"), rs.getString("type"), rs.getInt("id_matiere"), rs.getInt("id_enseignant"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
