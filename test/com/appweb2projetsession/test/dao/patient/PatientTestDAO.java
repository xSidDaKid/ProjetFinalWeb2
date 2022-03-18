/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.patient;

import com.appweb2projetsession.dao.patient.PatientImpDAO;
import com.appweb2projetsession.mvc.model.Patient;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1723144
 */
public class PatientTestDAO {

    private static PatientImpDAO dao = new PatientImpDAO();
    private static List<Patient> listePatient;
    private static Scanner r = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;

        do {
            afficherMenu();
            choix = r.nextInt();
            switch (choix) {
                case 1:
                    afficherTous();
                    break;
                case 2:
                    afficherParID();
                    break;
                case 3:
                    creerPatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    updatePatient();
                    break;
                case 6:
                    System.out.println("TEST COMPLETED!");
                    System.exit(0);
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 6);

    }

    public static void afficherMenu() {
        System.out.println("1. Afficher la liste des patients ");
        System.out.println("2. Chercher un étudiant par id");
        System.out.println("3. Creer un patient");
        System.out.println("4. Supprimer un patient");
        System.out.println("5. Modifier un patient");

        System.out.println("6. Pour quitter  ");
        System.out.println("Faire votre choix : ");
    }

    public static void afficherTous() {
        listePatient = dao.findAll();
        for (Patient patient : listePatient) {
            System.out.println(patient + "\n");
        }
    }

    private static void afficherParID() {
        System.out.println("Entrez l'id de l'étudiant ");
        int id = r.nextInt();
        Patient patient = dao.findByUserId(id);
        System.out.println(patient + "\n");
    }

    private static void creerPatient() {

        System.out.println("Entrez le nom du patient");
        String nom = r.next();

        System.out.println("Entrez le prenom du patient");
        String prenom = r.next();

        System.out.println("Entrez le numero d'assurance maladie");
        String nam = r.next();

        System.out.println("Entrez le numero sequentiel");
        int nbSequentiel = r.nextInt();

        System.out.println("Entrez la date naissance ");
        String dateNaissance = r.next();

        System.out.println("Entrez votre sexe: M ou F");
        char sexe = r.next().charAt(0);

        System.out.println("Entrez le id du clinique");
        int id_clinique = r.nextInt();

        System.out.println("Entrez le id du medecin");
        int id_medecin = r.nextInt();

        System.out.println("Entrez le id de l'utilisateur");
        int id_user = r.nextInt();

        Patient p1 = new Patient(nom, prenom, nam, nbSequentiel, dateNaissance, sexe, 1, 1, 1);
        boolean retour = dao.create(p1);
        if (retour) {
            listePatient = dao.findAll();
            for (Patient patient : listePatient) {
                System.out.println(patient);
            }
        }
        System.out.println("");
    }

    private static void deletePatient() {
        System.out.println("Entrez l'indice du patient ");
        int indice = r.nextInt();
        boolean isDeleted = dao.delete(indice);

        if (isDeleted) {
            listePatient = dao.findAll();
            for (Patient patient : listePatient) {
                System.out.println(patient);
            }
        }
        System.out.println("");
    }

    private static void updatePatient() {
        Patient p1 = new Patient();
        System.out.println("Entrez l'indice du patient ");
        int indice = r.nextInt();
        for (int i = 0; i < listePatient.size(); i++) {
            if (listePatient.get(i).getId() == indice) {
                p1 = new Patient(listePatient.get(i).getId(),
                        listePatient.get(i).getNom(),
                        listePatient.get(i).getPrenom(),
                        listePatient.get(i).getNam(),
                        listePatient.get(i).getNbSequentiel(),
                        listePatient.get(i).getDateNaissance(),
                        listePatient.get(i).getSexe(),
                        listePatient.get(i).getId_clinique(),
                        listePatient.get(i).getId_medecin(),
                        listePatient.get(i).getId_user());
            }
        }
        System.out.println("Entrez le nom du patient");
        String nom = r.next();
        p1.setNom(nom);

        System.out.println("Entrez le prenom du patient");
        String prenom = r.next();
        p1.setPrenom(prenom);

        System.out.println("Entrez le numero d'assurance maladie");
        String nam = r.next();
        p1.setNam(nam);

        System.out.println("Entrez le numero sequentiel");
        int nbSequentiel = r.nextInt();
        p1.setNbSequentiel(nbSequentiel);

        System.out.println("Entrez la date naissance ");
        String dateNaissance = r.nextLine();
        p1.setDateNaissance(dateNaissance);

        System.out.println("Entrez votre sexe: M ou F");
        char sexe = r.next().charAt(0);
        p1.setSexe(sexe);

        System.out.println("Entrez le id du clinique");
        int id_clinique = r.nextInt();
        p1.setId_clinique(id_clinique);

        System.out.println("Entrez le id du medecin");
        int id_medecin = r.nextInt();
        p1.setId_medecin(id_medecin);

        boolean retour = dao.update(p1);
        if (retour) {
            listePatient = dao.findAll();
            for (Patient patient : listePatient) {
                System.out.println(patient);
            }
        }
        System.out.println("");
    }
}
