/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.clinique.CliniqueImpDAO;
import com.appweb2projetsession.mvc.model.Clinique;
import java.util.List;

/**
 *
 * @author Robydul
 */
public class CliniqueAction {

    public static List<Clinique> afficherTousClinique() {
        CliniqueImpDAO dao = new CliniqueImpDAO();
        List<Clinique> listeClinique = dao.findAll();
        return listeClinique;
    }

    public static Clinique rechercherCliniqueParId(int id) {
        CliniqueImpDAO dao = new CliniqueImpDAO();
        Clinique c1 = dao.findById(id);
        return c1;
    }

    public static Clinique rechercherCliniqueParUserId(int id) {
        CliniqueImpDAO dao = new CliniqueImpDAO();
        Clinique c1 = dao.findByIdUser(id);
        return c1;
    }

    public static boolean miseajourEtudiant(Clinique clinique) {
        boolean retour = false;
        CliniqueImpDAO dao = new CliniqueImpDAO();
        if (dao.update(clinique)) {
            retour = true;
        }
        return retour;

    }

    public static boolean supprimerClinique(int id) {
        boolean retour = false;
        CliniqueImpDAO dao = new CliniqueImpDAO();
        if (dao.delete(id)) {
            retour = true;
        }
        return retour;
    }

    public static boolean ajouterClinique(Clinique clinique) {
        boolean retour = false;
        CliniqueImpDAO dao = new CliniqueImpDAO();
        if (dao.create(clinique)) {
            retour = true;
        }
        return retour;
    }

    public static Clinique existantClinique(String adresse, String tel) {
        CliniqueImpDAO dao = new CliniqueImpDAO();
        Clinique c1 = dao.isExiste(adresse, tel);
        return c1;

    }

}
