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
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 3);

    }

    public static void afficherMenu() {
        System.out.println("1. Afficher la liste des patients ");
        System.out.println("2. Chercher un étudiant par id");

        System.out.println("3. Pour quitter  ");
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
        Patient patient = dao.findById(id);
        System.out.println(patient + "\n");
    }

}
