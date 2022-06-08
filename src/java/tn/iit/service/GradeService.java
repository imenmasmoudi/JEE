/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.List;
import tn.iit.entities.Grade;
import tn.iit.persistance.GradeDAO;

/**
 *
 * @author tunin
 */
public class GradeService {

    GradeDAO gradedao = new GradeDAO();

    public Grade addGrade(int id, String lib, float prix_c, float prix_td, float prix_tp) {
        Grade a = new Grade(id, lib, prix_c, prix_td, prix_tp);
        gradedao.addGrade(a);
        return a;
    }

    public void removeGrade(int id) {
        gradedao.removeGrade(id);
    }

    public void updateGrade(Grade a) {
        gradedao.updateGrade(a);

    }

    public List<Grade> getAll() {
        return gradedao.getGrades();
    }

}
