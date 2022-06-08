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
public class Grade {

    private int id_grade;
    private String libelle;
    private float prix_c;
    private float prix_tp;
    private float prix_td;

    public Grade() {
    }

    public Grade(int id_grade, String libelle, float prix_c, float prix_tp, float prix_td) {
        this.id_grade = id_grade;
        this.libelle = libelle;
        this.prix_c = prix_c;
        this.prix_tp = prix_tp;
        this.prix_td = prix_td;
    }

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_c() {
        return prix_c;
    }

    public void setPrix_c(float prix_c) {
        this.prix_c = prix_c;
    }

    public float getPrix_tp() {
        return prix_tp;
    }

    public void setPrix_tp(float prix_tp) {
        this.prix_tp = prix_tp;
    }

    public float getPrix_td() {
        return prix_td;
    }

    public void setPrix_td(float prix_td) {
        this.prix_td = prix_td;
    }

}
