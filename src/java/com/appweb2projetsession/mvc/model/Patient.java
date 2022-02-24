/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.model;

/**
 *
 * @author 1723144
 */
public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private String nam; //numero d'assurance maladie
    private int nbSequentiel;
    private String dateNaissance;
    private char sexe;
    private Clinique clinique_id;
    private Medecin medecin_id;
    private int id_clinique;
    private int id_medecin;

    public Patient() {
    }

    public Patient(String nom, String prenom, String nam, int nbSequentiel, String dateNaissance, char sexe, Clinique clinique_id, Medecin medecin_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.nam = nam;
        this.nbSequentiel = nbSequentiel;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.clinique_id = clinique_id;
        this.medecin_id = medecin_id;
    }

    // Constructeur pour le INSERT
    public Patient(String nom, String prenom, String nam, int nbSequentiel, String dateNaissance, char sexe, int id_clinique, int id_medecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.nam = nam;
        this.nbSequentiel = nbSequentiel;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.id_clinique = id_clinique;
        this.id_medecin = id_medecin;
    }

//    public Patient(String nom, String adresse, String numeroDeTelephone, String services) {
//        super(nom, adresse, numeroDeTelephone, services);
//    }
//    public Patient(String nom, String prenom, String nam, int nbSequentiel, char sexe, Clinique clinique_id, Medecin medecin_id, String nom, String adresse, String numeroDeTelephone, String services) {
//        super(nom, adresse, numeroDeTelephone, services);
//        this.nom = nom;
//        this.prenom = prenom;
//        this.nam = nam;
//        this.nbSequentiel = nbSequentiel;
//        this.sexe = sexe;
//        this.clinique_id = clinique_id;
//        //this.medecin_id = medecin_id;
//    }
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

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getNbSequentiel() {
        return nbSequentiel;
    }

    public void setNbSequentiel(int nbSequentiel) {
        this.nbSequentiel = nbSequentiel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public Clinique getClinique_id() {
        return clinique_id;
    }

    public void setClinique_id(Clinique clinique_id) {
        this.clinique_id = clinique_id;
    }

    public int getId_clinique() {
        return id_clinique;
    }

    public void setId_clinique(int id_clinique) {
        this.id_clinique = id_clinique;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nam=" + nam + ", nbSequentiel=" + nbSequentiel + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", clinique_id=" + clinique_id + ", medecin_id=" + medecin_id + '}';
    }

}