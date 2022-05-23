/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet de faire les redirections vers les pages jsp
 *
 * @author Shajaan, dahamada
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class ActionBuilder {

    public static Action getAction(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Action action = null;
        String actionAFaire;

        String servletPath = request.getServletPath();
        servletPath = servletPath.substring(1);//ignore le premier /

        //determiner le chemin
        int i = servletPath.indexOf("/");

        if (i == -1) {
            actionAFaire = servletPath;
        } else {
            actionAFaire = servletPath.substring(0, i);
        }

        //pour permettre que le nom de l'action soit suivie du
        // symbole point (.):
        i = actionAFaire.indexOf(".");
        if (i != -1) {
            actionAFaire = actionAFaire.substring(0, i);
        }
       
        switch (actionAFaire) {
            case "":
                action = new HomeServlet();
                break;
            //AJAX
            case "user":
                action = new User();
                break;
            case "clinique":
                action = new Clinique();
                break;
            case "medecin":
                action = new Medecin();
                break;
            case "patient":
                action = new PatientNombre();
                break;
            //INSCRIPTION
            case "inscriptionUser":
                action = new InscriptionUser();
                break;
            case "inscriptionPatient":
                action = new InscriptionPatientServlet();
                break;
            case "inscriptionMedecin":
                action = new InscriptionPatientServlet();
                break;
            case "inscriptionClinique":
                action = new InscriptionPatientServlet();
                break;
            //LOGIN-LOGOUT-PROFILE
            case "login":
                action = new Login();
                break;
            case "logout":
                action = new Logout();
                break;
            case "admin":
                if (session.getAttribute("username") != null) {
                    action = new Admin();
                } else {
                    action = new Login();
                }
                break;
            case "profile":
                if (session.getAttribute("User") != null) {
                    action = new Profile();
                } else {
                    action = new Login();
                }
                break;
            //OPTION PATIENT    
            case "priseDeRendezVous":
                if (session.getAttribute("Patient") != null) {
                    action = new PriseDeRendezVous();
                } else {
                    action = new Login();
                }
                break;
            case "envoieInfo":
                if (session.getAttribute("Patient") != null) {
                    action = new EnvoieInfo();
                } else {
                    action = new Login();
                }
                break;
            //OPTION MEDECIN
            case "espacePatient":
                if (session.getAttribute("Medecin") != null) {
                    action = new EspacePatient();
                } else {
                    action = new Login();
                }
                break;
            case "afficherPageEmail":
                if (session.getAttribute("Medecin") != null) {
                    action = new AfficherPageEmail();
                } else {
                    action = new Login();
                }
                break;
            case "envoyerEmail":
                if (session.getAttribute("Medecin") != null) {
                    action = new EnvoyerEmail();
                } else {
                    action = new Login();
                }
                break;
            case "disponibilite":
                if (session.getAttribute("Medecin") != null) {
                    action = new Disponibilite();
                    break;
                } else {
                    action = new Login();
                }
            //OPTION CLINIQUE
            case "infoClinique":
                if (session.getAttribute("Clinique") != null) {
                    action = new InfoClinique();
                } else {
                    action = new Login();
                }
                break;
        }
        return action;
    }
}
