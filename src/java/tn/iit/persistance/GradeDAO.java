/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.persistance;

import tn.iit.utils.JdbcUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.iit.entities.Grade;

/**
 *
 * @author tunin
 */
public class GradeDAO {

    public Grade addGrade(Grade a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Insert into grade values ('" + a.getId_grade() + "','" + a.getLibelle() + "', " + a.getPrix_c() + ", " + a.getPrix_td() + ", " + a.getPrix_tp() + ")";
        try {
            st.executeUpdate(req);
        } catch (Exception ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public void removeGrade(int id) {

        Statement st = JdbcUtils.getStatement();
        String req = "DELETE From grade where id_grade = '" + id + "'";

        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGrade(Grade a) {
        Statement st = JdbcUtils.getStatement();
        String req = "Update grade set libelle= '" + a.getLibelle() + "', prix_c= '" + a.getPrix_c() + "', prix_td= '" + a.getPrix_td() + "', prix_tp= '" + a.getPrix_tp() + "' where id_grade = '" + a.getId_grade() + "';";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Grade> getGrades() {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from grade;";

        List<Grade> list = new ArrayList<Grade>();
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Grade a = new Grade(rs.getInt("id_grade"), rs.getString("libelle"), rs.getFloat("prix_c"), rs.getFloat("prix_td"), rs.getFloat("prix_tp"));
                list.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Grade getGradeByID(int id) {
        Statement st = JdbcUtils.getStatement();
        String req = "select * from grade where id_grade = '" + id + "';";
        Grade a = null;
        System.out.println(req);
        try {
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                a = new Grade(rs.getInt("id_grade"), rs.getString("libelle"), rs.getFloat("prix_c"), rs.getFloat("prix_td"), rs.getFloat("prix_tp"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
