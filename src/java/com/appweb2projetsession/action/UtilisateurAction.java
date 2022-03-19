/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.utilisateur.UtilisateurDAO;
import com.appweb2projetsession.dao.utilisateur.UtilisateurImpDAO;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.List;

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

    public static List<Utilisateur> findAll() {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        List<Utilisateur> listeUtilisateur = dao.findAll();
        return listeUtilisateur;
    }

    public static Utilisateur findByEmail(String email) {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        Utilisateur user = dao.findByEmail(email);
        return user;
    }
   
    public static Utilisateur findByID (int id) {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        Utilisateur user = dao.findByID(id);
        return user;
    }

    public static boolean delete(int id) {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        boolean verif = dao.delete(id);
        return verif;
    }
    
    public static boolean update(Utilisateur utilisateur){
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        boolean verif = dao.update(utilisateur);
        return verif;
    }
}
