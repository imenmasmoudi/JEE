/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.service;

import java.util.Date;
import java.util.List;
import tn.iit.entities.Matiere;
import tn.iit.entities.Seance;
import tn.iit.persistance.MatiereDAO;
import tn.iit.persistance.SeanceDAO;

/**
 *
 * @author tunin
 */
public class SeanceService {
    
     SeanceDAO seancedao = new SeanceDAO();

    public Seance addSeance(int id, Date date, Date h_debut, float duree, String methode,boolean valid,String type ,int id_matiere,int id_enseignant ) {
        Seance a = new Seance(id, date,h_debut,duree,methode,valid,type ,id_matiere,id_enseignant);
        seancedao.addSeance(a);
        return a;
    }
      
    public void removeSeance(int id) {
        seancedao.removeSeance(id);
    }

    public void updateSeance(Seance a) {
        seancedao.updateSeance(a);

    }

    public List<Seance> getAll() {
        return seancedao.getSeances();
    }
 
    
    
}
