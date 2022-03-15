/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.clinique;

import com.appweb2projetsession.dao.clinique.CliniqueImpDAO;
import com.appweb2projetsession.mvc.model.Clinique;
import static com.appweb2projetsession.test.dao.patient.PatientTestDAO.afficherMenu;
import static com.appweb2projetsession.test.dao.patient.PatientTestDAO.afficherTous;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Robydul
 */
public class CliniqueTestDAO {

    private static CliniqueImpDAO dao = new CliniqueImpDAO();
    private static List<Clinique> listeClinique;
    private static Scanner r = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;

        do
        {
            afficherMenu();
            choix = r.nextInt();
            switch (choix)
            {
                case 1:
                    afficherTous();
                    break;
                case 2:
                    afficherParID();
                    break;
                case 3:
                    creerClinique();
                    break;
                case 4:
                    deleteClinique();
                    break;
                case 5:
                    updateClinique();
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
        System.out.println("1. Afficher la liste des cliniques ");
        System.out.println("2. Chercher une clinique par id");
        System.out.println("3. Creer une clinique");
        System.out.println("4. Supprimer un patient");
        System.out.println("5. Modifier un patient");

        System.out.println("6. Pour quitter  ");
        System.out.println("Faire votre choix : ");
    }

    private static void afficherTous() {
        listeClinique = dao.findAll();
        for (Clinique clinique : listeClinique)
        {
            System.out.println(clinique + "\n");
        }
    }

    private static void afficherParID() {
        System.out.println("Entrez l'id de la clinique ");
        int id = r.nextInt();
        Clinique clinique = dao.findById(id);
        System.out.println(clinique + "\n");
    }

    private static void creerClinique() {
        System.out.println("Entrez le nom de la clinique");
        String nom = r.next();

        System.out.println("Entrez l adresse de la clinique");
        String adresse = r.next();

        System.out.println("Entrez le numero de telephone");
        String tel = r.next();

        System.out.println("Entrez le service  de la clinique");
        String services = r.next();

        Clinique c1 = new Clinique(nom, adresse, tel, services, 1);
        boolean retour = dao.create(c1);

        if (retour)
        {
            listeClinique = dao.findAll();
            for (Clinique clinique : listeClinique)
            {
                System.out.println(clinique);
            }
        }
        System.out.println("");

    }

    private static void deleteClinique() {
        System.out.println("Entrez l'indice de la clinique  ");
        int indice = r.nextInt();
        boolean isDeleted = dao.delete(indice);

        if (isDeleted)
        {
            listeClinique = dao.findAll();
            for (Clinique clinique : listeClinique)
            {
                System.out.println(clinique);
            }
        }
        System.out.println("");
    }

    private static void updateClinique() {

        Clinique c1 = new Clinique();
        System.out.println("Entrez l'indice du patient ");
        int indice = r.nextInt();
        for (int i = 0; i < listeClinique.size(); i++)
        {
            if (listeClinique.get(i).getId() == indice)
            {
                c1 = new Clinique(listeClinique.get(i).getId(),
                        listeClinique.get(i).getNom(),
                        listeClinique.get(i).getAdresse(),
                        listeClinique.get(i).getTel(),
                        listeClinique.get(i).getServices(),
                        listeClinique.get(i).getId_user());

            }
        }

        System.out.println("Entrez le nom de la clinique");
        String nom = r.next();
        c1.setNom(nom);

        System.out.println("Entrez l adresse de la clinique");
        String adresse = r.next();
        c1.setAdresse(adresse);

        System.out.println("Entrez le numero de telephone");
        String tel = r.next();
        c1.setTel(tel);

        System.out.println("Entrez le service  de la clinique");
        String services = r.next();
        c1.setServices(services);

        boolean retour = dao.update(c1);
        if (retour)
        {
            listeClinique = dao.findAll();
            for (Clinique clinique : listeClinique)
            {
                System.out.println(clinique);
            }
        }
        System.out.println("");
    }

}
