/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.utilisateur;

import com.appweb2projetsession.dao.utilisateur.UtilisateurImpDAO;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.Scanner;

/**
 *
 * @author Shajaan
 */
public class UtilisateurTestDAO {

    private static UtilisateurImpDAO dao = new UtilisateurImpDAO();
    private static Scanner r = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;

        do {
            afficherMenu();
            choix = r.nextInt();
            switch (choix) {
                case 1:
                    isExiste();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    System.out.println("TEST COMPLETED!");
                    System.exit(0);
                default:
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 4);

    }

    public static void afficherMenu() {
        System.out.println("1. Utilisateur existe? ");
        System.out.println("2. Creer utilisateur");
        System.out.println("3. Modifier un utilisateur");
        System.out.println("4. Pour quitter  ");
        System.out.println("Faire votre choix : ");
    }

    private static void isExiste() {
        Utilisateur u = dao.isExiste("c", "b");
        System.out.println(u);
    }

    private static void create() {
        boolean verif = dao.create(new Utilisateur("b", "c", "d", "Patient"));
    }

    private static void modifier() {
        dao.update(new Utilisateur(1, "a", "b", "c", "d"));
    }
}
