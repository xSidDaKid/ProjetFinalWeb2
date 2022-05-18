/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.action.CliniqueAction;
import com.appweb2projetsession.action.MedecinAction;
import com.appweb2projetsession.action.PatientAction;
import com.appweb2projetsession.action.UtilisateurAction;
import com.appweb2projetsession.mvc.model.Clinique;
import com.appweb2projetsession.mvc.model.Medecin;
import com.appweb2projetsession.mvc.model.Patient;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Classe qui permet d'afficher la page d'Admin qui peut gerer les divers
 * utilisateurs du site
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class Admin extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession(false);

        String deletePatientId = request.getParameter("deletePatientId");
        String deleteMedecinId = request.getParameter("deleteMedecinId");
        String deleteCliniqueId = request.getParameter("deleteCliniqueId");
        String deleteUserId = request.getParameter("deleteUserId");

        String modifPatientId = request.getParameter("modifPatientId");
        String modifMedecinId = request.getParameter("modifMedecinId");
        String modifCliniqueId = request.getParameter("modifCliniqueId");
        String modifUserId = request.getParameter("modifUserId");

        //Liste des tables SQL
        List<Patient> listePatient = PatientAction.afficherTous();
        List<Medecin> listeMedecin = MedecinAction.afficherTous();
        List<Clinique> listeClinique = CliniqueAction.afficherTousClinique();
        List<Utilisateur> listeUtilisateur = UtilisateurAction.findAll();

        //Messages d'erreurs---
        if (listePatient.isEmpty()) {
            request.setAttribute("erreurP", "La liste est vide");
        } else {
            request.setAttribute("listePatient", listePatient);
        }
        if (listeMedecin.isEmpty()) {
            request.setAttribute("erreurM", "La liste est vide");
        } else {
            request.setAttribute("listeMedecin", listeMedecin);
        }
        if (listeClinique.isEmpty()) {
            request.setAttribute("erreurC", "La liste est vide");
        } else {
            request.setAttribute("listeClinique", listeClinique);
        }
        if (listeUtilisateur.isEmpty()) {
            request.setAttribute("erreurU", "La liste est vide");
        } else {
            request.setAttribute("listeUtilisateur", listeUtilisateur);
        }

        //FONCTION: DELETE---
        //PATIENT---
        if (deletePatientId != null) {
            Patient foundPatient = PatientAction.findById(Integer.parseInt(deletePatientId));
            boolean verifPatient = PatientAction.delete(Integer.parseInt(deletePatientId));
            UtilisateurAction.delete(foundPatient.getId_user());

            //VERIFICATION DE LA FONCTION DELETE
            if (verifPatient) {
                request.setAttribute("erreurDeleteSucces", "Cet element a ete supprime avec succes");
            } else {
                request.setAttribute("erreurDelete", "Cet element ne peut pas etre supprimer");
            }

            //AFFICHER APRES SUPPRESSION
            listePatient = PatientAction.afficherTous();
            listeMedecin = MedecinAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();
            listeUtilisateur = UtilisateurAction.findAll();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeMedecin", listeMedecin);
            request.setAttribute("listeClinique", listeClinique);
            request.setAttribute("listeUtilisateur", listeUtilisateur);

            return "admin";
        }
        //MEDECIN---
        if (deleteMedecinId != null) {
            Medecin foundMedecin = MedecinAction.findById(Integer.parseInt(deleteMedecinId));
            boolean verifMedecin = MedecinAction.delete(Integer.parseInt(deleteMedecinId));
            UtilisateurAction.delete(foundMedecin.getId_user());

            //VERIFICATION DE LA FONCTION DELETE
            if (verifMedecin) {
                request.setAttribute("erreurDeleteSucces", "Cet element a ete supprime avec succes");
            } else {
                request.setAttribute("erreurDelete", "Cet element ne peut pas etre supprimer");
            }

            //AFFICHER APRES SUPPRESSION
            listePatient = PatientAction.afficherTous();
            listeMedecin = MedecinAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();
            listeUtilisateur = UtilisateurAction.findAll();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeMedecin", listeMedecin);
            request.setAttribute("listeClinique", listeClinique);
            request.setAttribute("listeUtilisateur", listeUtilisateur);

            return "admin";
        }
        //CLINIQUE---
        if (deleteCliniqueId != null) {
            Clinique foundClinique = CliniqueAction.rechercherCliniqueParId(Integer.parseInt(deleteCliniqueId));
            boolean verifClinique = CliniqueAction.supprimerClinique(Integer.parseInt(deleteCliniqueId));
            UtilisateurAction.delete(foundClinique.getId_user());

            //VERIFICATION DE LA FONCTION DELETE
            if (verifClinique) {
                request.setAttribute("erreurDeleteSucces", "Cet element a ete supprime avec succes");
            } else {
                request.setAttribute("erreurDelete", "Cet element ne peut pas etre supprimer");
            }

            //AFFICHER APRES SUPPRESSION
            listePatient = PatientAction.afficherTous();
            listeMedecin = MedecinAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();
            listeUtilisateur = UtilisateurAction.findAll();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeMedecin", listeMedecin);
            request.setAttribute("listeClinique", listeClinique);
            request.setAttribute("listeUtilisateur", listeUtilisateur);

            return "admin";
        }
        //USER---
        if (deleteUserId != null) {
            boolean verifUser = UtilisateurAction.delete(Integer.parseInt(deleteUserId));

            //VERIFICATION DE LA FONCTION DELETE
            if (verifUser) {
                request.setAttribute("erreurDeleteSucces", "Cet element a ete supprime avec succes");
            } else {
                request.setAttribute("erreurDelete", "Cet element ne peut pas etre supprimer");
            }

            //AFFICHER APRES SUPPRESSION
            listePatient = PatientAction.afficherTous();
            listeMedecin = MedecinAction.afficherTous();
            listeClinique = CliniqueAction.afficherTousClinique();
            listeUtilisateur = UtilisateurAction.findAll();

            request.setAttribute("listePatient", listePatient);
            request.setAttribute("listeMedecin", listeMedecin);
            request.setAttribute("listeClinique", listeClinique);
            request.setAttribute("listeUtilisateur", listeUtilisateur);

            return "admin";
        }
        //PATIENT---
        if (modifPatientId != null) {
            Patient patientModif = PatientAction.findById(Integer.parseInt(modifPatientId));
            Utilisateur user = UtilisateurAction.findByID(patientModif.getId_user());
            session.setAttribute("patientModif", patientModif);
            session.setAttribute("userModif", user);
            return "profile";
        }
        //MEDECIN---
        if (modifMedecinId != null) {
            Medecin medecinModif = MedecinAction.findById(Integer.parseInt(modifMedecinId));
            Utilisateur user = UtilisateurAction.findByID(medecinModif.getId_user());
            session.setAttribute("medecinModif", medecinModif);
            session.setAttribute("userModif", user);
            return "profile";
        }
        //CLINIQUE---
        if (modifCliniqueId != null) {
            Clinique cliniqueModif = CliniqueAction.rechercherCliniqueParId(Integer.parseInt(modifCliniqueId));
            Utilisateur user = UtilisateurAction.findByID(cliniqueModif.getId_user());
            session.setAttribute("cliniqueModif", cliniqueModif);
            session.setAttribute("userModif", user);
            return "profile";
        }
        //USER---
        if (modifUserId != null) {
            Utilisateur user = UtilisateurAction.findByID(Integer.parseInt(modifUserId));
            session.setAttribute("userModif", user);
            return "profile";

        }
        return "admin";

    }
}
