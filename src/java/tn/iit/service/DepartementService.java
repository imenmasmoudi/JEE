/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.List;
import tn.iit.entities.Departement;
import tn.iit.entities.Niveau;
import tn.iit.persistance.DepartementDAO;
import tn.iit.persistance.NiveauDAO;

/**
 *
 * @author tunin
 */
public class DepartementService {
    
    DepartementDAO departementdao = new DepartementDAO();

    public Departement addDepartement(int id, String lib,int id_enseignant) {
        Departement a = new Departement(id, lib, id_enseignant);
        departementdao.addDepartement(a);
        return a;
    }

    public void removeDepartement(int id) {
        departementdao.removeDepartement(id);
    }

    public void updateDepartement(Departement a) {
        departementdao.updateDepartement(a);

    }

    public List<Departement> getAll() {
        return departementdao.getDepartements();
    }
    
}
