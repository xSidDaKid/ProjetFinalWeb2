/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.model;

import java.io.Serializable;

/**
 *
 * @author 1723144
 */
public class Medecin implements Serializable {

    private int id;
    private String nom;
    private String prenom;
    private String profession;
    private String nbProfessionnel;
    private String ententes;
    private String adresse;
    private String lieuProfession;
    private int id_clinique;
    private int id_user;

    public Medecin() {
    }

    public Medecin(int id, String nom, String prenom, String profession, String nbProfessionnel, String ententes, String adresse, String lieuProfession, int id_clinique, int id_user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.nbProfessionnel = nbProfessionnel;
        this.ententes = ententes;
        this.adresse = adresse;
        this.lieuProfession = lieuProfession;
        this.id_clinique = id_clinique;
        this.id_user = id_user;
    }

    public Medecin(String nom, String prenom, String profession, String nbProfessionnel, String ententes, String adresse, String lieuProfession, int id_clinique, int id_user) {
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.nbProfessionnel = nbProfessionnel;
        this.ententes = ententes;
        this.adresse = adresse;
        this.lieuProfession = lieuProfession;
        this.id_clinique = id_clinique;
        this.id_user = id_user;
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="GETTER & SETTER methods">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNbProfessionnel() {
        return nbProfessionnel;
    }

    public void setNbProfessionnel(String nbProfessionnel) {
        this.nbProfessionnel = nbProfessionnel;
    }

    public String getEntentes() {
        return ententes;
    }

    public void setEntentes(String ententes) {
        this.ententes = ententes;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLieuProfession() {
        return lieuProfession;
    }

    public void setLieuProfession(String lieuProfession) {
        this.lieuProfession = lieuProfession;
    }

    public int getId_clinique() {
        return id_clinique;
    }

    public void setId_clinique(int id_clinique) {
        this.id_clinique = id_clinique;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Medecin{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", profession=" + profession + ", nbProfessionnel=" + nbProfessionnel + ", ententes=" + ententes + ", adresse=" + adresse + ", lieuProfession=" + lieuProfession + ", id_clinique=" + id_clinique + ", id_user=" + id_user + '}';
    }

}
