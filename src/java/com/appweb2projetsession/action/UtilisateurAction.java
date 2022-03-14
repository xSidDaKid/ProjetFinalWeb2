/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.utilisateur.UtilisateurImpDAO;
import com.appweb2projetsession.mvc.model.Utilisateur;

/**
 *
 * @author Shajaan
 */
public class UtilisateurAction {

    public static Utilisateur connexion(String email, String motDePasse) {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        Utilisateur u = dao.isExiste(email, motDePasse);
        return u;
    }

    public static boolean create(Utilisateur u) {
        boolean retour = false;
        UtilisateurImpDAO dao = new UtilisateurImpDAO();

        if (dao.create(u)) {
            retour = true;
        }
        return retour;
    }
}
