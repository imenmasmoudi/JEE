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
public class Matiere {
    
    private int id_matiere;
    private String libelle;
    private float ch_cours;
    private float ch_td;
    private float ch_tp;
    private int id_departement;
    private int id_niveau;
    private int id_enseignant;

    public Matiere() {
    }

    public Matiere(int id_matiere, String libelle, float ch_cours, float ch_td, float ch_tp, int id_departement, int id_niveau, int id_enseignant) {
        this.id_matiere = id_matiere;
        this.libelle = libelle;
        this.ch_cours = ch_cours;
        this.ch_td = ch_td;
        this.ch_tp = ch_tp;
        this.id_departement = id_departement;
        this.id_niveau = id_niveau;
        this.id_enseignant = id_enseignant;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getCh_cours() {
        return ch_cours;
    }

    public void setCh_cours(float ch_cours) {
        this.ch_cours = ch_cours;
    }

    public float getCh_td() {
        return ch_td;
    }

    public void setCh_td(float ch_td) {
        this.ch_td = ch_td;
    }

    public float getCh_tp() {
        return ch_tp;
    }

    public void setCh_tp(float ch_tp) {
        this.ch_tp = ch_tp;
    }

    public int getId_departement() {
        return id_departement;
    }

    public void setId_departement(int id_departement) {
        this.id_departement = id_departement;
    }

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    
    
    
}
