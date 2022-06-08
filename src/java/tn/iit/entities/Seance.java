/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.entities;

import java.util.Date;

/**
 *
 * @author tunin
 */
public class Seance {

    private int id_seance;
    private Date date;
    private Date h_debut;
    private float duree;
    private String methode;
    private boolean valide;
    private String type;
    private int id_matiere;
    private int id_enseignant;

    public Seance() {
    }

    public Seance(int id_seance, Date date, Date h_debut, float duree, String methode, boolean valide, String type, int id_matiere, int id_enseignant) {
        this.id_seance = id_seance;
        this.date = date;
        this.h_debut = h_debut;
        this.duree = duree;
        this.methode = methode;
        this.valide = valide;
        this.type = type;
        this.id_matiere = id_matiere;
        this.id_enseignant = id_enseignant;
    }

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getH_debut() {
        return h_debut;
    }

    public void setH_debut(Date h_debut) {
        this.h_debut = h_debut;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

}
