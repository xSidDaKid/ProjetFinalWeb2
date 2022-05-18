/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import javax.servlet.http.HttpServletRequest;

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
        Action action = null;
        String actionAFaire;
        String servletPath = request.getServletPath();
        System.out.println("servletPath : " + servletPath);
        servletPath = servletPath.substring(1);//ignore le premier /
        System.out.println("servletPath 1 : " + servletPath);
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
        System.out.println("Action a faire = " + actionAFaire);
        switch (actionAFaire) {
            case "":
                action = new HomeServlet();
                break;
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
            case "login":
                action = new Login();
                break;
            case "logout":
                action = new Logout();
                break;
            case "admin":
                action = new Admin();
                break;
            case "profile":
                action = new Admin();
                break;
            case "priseDeRendezVous":
                action = new PriseDeRendezVous();
                break;
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
            case "espacePatient":
                action = new EspacePatient();
                break;
            case "envoyerEmail":
                action = new EnvoyerEmail();
                break;
            case "afficherPageEmail":
                action = new AfficherPageEmail();
                break;
            case "envoieInfo":
                action = new EnvoieInfo();
                break;
            case "disponibilite":
                action = new Disponibilite();
                break;
        }
        return action;
    }
}
