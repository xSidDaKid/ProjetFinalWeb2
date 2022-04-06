/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Shajaan
 */
public class Profil implements Serializable {

    private int id;
    private String nomFichier;
    private InputStream contenuFichier;
    private String info;
    private String date;
    private int patient_id;
    private int medecin_id;

    public Profil() {
    }

    public Profil(String nomFichier, InputStream contenuFichier, String info, String date, int patient_id, int medecin_id) {
        this.contenuFichier = contenuFichier;
        this.nomFichier = nomFichier;
        this.info = info;
        this.date = date;
        this.patient_id = patient_id;
        this.medecin_id = medecin_id;
    }

//<editor-fold defaultstate="collapsed" desc="GETTER & SETTER">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InputStream getContenuFichier() {
        return contenuFichier;
    }

    public void setContenuFichier(InputStream contenuFichier) {
        this.contenuFichier = contenuFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", contenuFichier=" + contenuFichier + ", nomFichier=" + nomFichier + ", info=" + info + ", date=" + date + ", patient_id=" + patient_id + ", medecin_id=" + medecin_id + '}';
    }

}
