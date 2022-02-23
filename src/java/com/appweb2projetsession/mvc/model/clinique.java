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
public class clinique implements Serializable {

    private String nom;
    private String adresse;
    private String numeroDeTelephone;
    private String services;

    public clinique(String nom, String adresse, String numeroDeTelephone, String services) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroDeTelephone = numeroDeTelephone;
        this.services = services;
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

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String infoClinique() {
        return "clinique{" + "nom=" + nom + ", adresse=" + adresse + ", numeroDeTelephone=" + numeroDeTelephone + ", services=" + services + '}';

    }

    @Override
    public String toString() {
        return "clinique{" + "nom=" + nom + ", adresse=" + adresse + ", numeroDeTelephone=" + numeroDeTelephone + ", services=" + services + '}';
    }

}
