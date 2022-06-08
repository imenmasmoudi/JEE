/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.iit.entities;

import java.math.BigInteger;

/**
 *
 * @author tunin
 */
public class Enseignant {
    
    private int id;
    private int cin;
    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private int phone;
    private String login;
    private String password;
    private int id_grade;

    public Enseignant() {
    }

    public Enseignant(int id, int cin, String prenom, String nom, String adresse, String email, int phone, String login, String password, int id_grade) {
        this.id = id;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.id_grade = id_grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }
    
    
    
    
    
    
    
}
