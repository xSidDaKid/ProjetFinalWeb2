/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Shajaan
 */
public class RendezVous implements Serializable{

    private int id;
    private String date;
    private int medecin_id;
    private int patient_id;
    private String raison;
    private String description;

    public RendezVous() {
    }

    public RendezVous(int id, String date, int medecin_id, int patient_id, String raison, String description) {
        this.id = id;
        this.date = date;
        this.medecin_id = medecin_id;
        this.patient_id = patient_id;
        this.raison = raison;
        this.description = description;
    }

    public RendezVous(String date, int medecin_id) {
        this.date = date;
        this.medecin_id = medecin_id;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public int getMedecin_id() {
        return medecin_id;
    }
    
    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }
    
    public int getPatient_id() {
        return patient_id;
    }
    
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    
    public String getRaison() {
        return raison;
    }
    
    public void setRaison(String raison) {
        this.raison = raison;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + id + ", date=" + date + ", medecin_id=" + medecin_id + ", patient_id=" + patient_id + ", raison=" + raison + ", description=" + description + '}';
    }
    
    
    
}
