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
public class Clinique  {
    private int id;
    private String nom;
    private String adresse;
    private String tel;
    private String services;

       
   public Clinique() {
   }

    public Clinique(String nom, String adresse, String tel, String services) {
      this.nom = nom;
     this.adresse = adresse;
      this.tel = tel;
      this.services = services;
   }

    public Clinique(int id, String nom, String adresse, String tel, String services) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.services = services;
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

    @Override
    public String toString() {
        return "Clinique{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + ", services=" + services + '}';
    }

 
}
