/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.List;
import tn.iit.entities.Grade;
import tn.iit.entities.Niveau;
import tn.iit.persistance.GradeDAO;
import tn.iit.persistance.NiveauDAO;

/**
 *
 * @author tunin
 */
public class NiveauService {
    NiveauDAO niveaudao = new NiveauDAO();

    public Niveau addNiveau(int id, String lib) {
        Niveau a = new Niveau(id, lib);
        niveaudao.addNiveau(a);
        return a;
    }

    public void removeNiveau(int id) {
        niveaudao.removeNiveau(id);
    }

    public void updateNiveau(Niveau a) {
        niveaudao.updateNiveau(a);

    }

    public List<Niveau> getAll() {
        return niveaudao.getNiveaux();
    }
}
