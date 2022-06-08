/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.entities;

/**
 *
 * @author tunin
 */
public class Departement {
    
    private int id;
    private String libelle;
    private int id_enseignant;

    public Departement() {
    }

    public Departement(int id, String libelle, int id_enseignant) {
        this.id = id;
        this.libelle = libelle;
        this.id_enseignant = id_enseignant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
    
    
    
    
    
    
    
    
    
    
    
}
