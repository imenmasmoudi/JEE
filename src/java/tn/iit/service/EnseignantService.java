/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.List;
import tn.iit.entities.Enseignant;
import tn.iit.entities.Grade;
import tn.iit.persistance.EnseignantDAO;
import tn.iit.persistance.GradeDAO;

/**
 *
 * @author tunin
 */
public class EnseignantService {

    EnseignantDAO enseignantdao = new EnseignantDAO();

    public Enseignant addEnseignant(int id, int cin, String prenom, String nom, String adresse, String email, int phone, String login, String password, int id_grade) {
        Enseignant a = new Enseignant(id, cin, prenom, nom, adresse, email, phone, login, password, id_grade);
        enseignantdao.addEnseignant(a);
        return a;
    }

    public void removeEnseignant(int id) {
        enseignantdao.removeEnseignant(id);
    }

    public void updateEnseignant(Enseignant a) {
        enseignantdao.updateEnseignant(a);

    }

    public List<Enseignant> getAll() {
        return enseignantdao.getEnseignants();
    }
    
}
