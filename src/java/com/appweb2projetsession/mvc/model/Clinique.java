/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.model;

import java.io.Serializable;

/**
 *
 * @author RbAwa
 */
public class Clinique implements Serializable {

    private int id;
    private String nom;
    private String adresse;
    private String tel;
    private String services;
    private int id_user;

    public Clinique() {
    }

    public Clinique(String nom, String adresse, String tel, String services, int id_user) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.services = services;
        this.id_user = id_user;
    }

    public Clinique(int id, String nom, String adresse, String tel, String services, int id_user) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.services = services;
        this.id_user = id_user;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String infoClinique() {
        return "clinique{" + "nom=" + nom + ", adresse=" + adresse + ", numeroDeTelephone=" + tel + ", services=" + services + '}';

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Clinique{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + ", services=" + services + ", id_user=" + id_user + '}';
    }

}
