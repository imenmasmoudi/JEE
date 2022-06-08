/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.List;
import tn.iit.entities.Matiere;
import tn.iit.persistance.MatiereDAO;

/**
 *
 * @author tunin
 */
public class MatiereService {
    
    MatiereDAO matieredao = new MatiereDAO();

    public Matiere addMatiere(int id, String libelle, float ch_cours, float ch_tp, float ch_td, int id_departement, int id_niveau, int id_enseignant) {
        Matiere a = new Matiere(id_niveau, libelle, ch_cours, ch_td, ch_tp, id_departement, id_niveau, id_enseignant);
        matieredao.addMatiere(a);
        return a;
    }

    public void removeMatiere(int id) {
        matieredao.removeMatiere(id);
    }

    public void updateMatiere(Matiere a) {
        matieredao.updateMatiere(a);

    }

    public List<Matiere> getAll() {
        return matieredao.getMatieres();
    }
 
    
}
