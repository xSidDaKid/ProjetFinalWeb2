/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.medecin.MedecinImpDAO;
import com.appweb2projetsession.mvc.model.Medecin;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class MedecinAction {

    public static List<Medecin> afficherTous() {
        MedecinImpDAO dao = new MedecinImpDAO();
        List<Medecin> listeMedecin = dao.findAll();
        return listeMedecin;
    }

    public static Medecin findById(int id) {
        MedecinImpDAO dao = new MedecinImpDAO();
        Medecin medecin = dao.findById(id);
        return medecin;
    }

    public static Medecin findByIdUser(int id) {
        MedecinImpDAO dao = new MedecinImpDAO();
        Medecin medecin = dao.findByIdUser(id);
        return medecin;
    }

    public static List<Medecin> findByIdClinique(int id) {
        MedecinImpDAO dao = new MedecinImpDAO();
        List<Medecin> listeMedecin = dao.findByIdClinique(id);
        return listeMedecin;
    }

    public static boolean delete(int id) {
        MedecinImpDAO dao = new MedecinImpDAO();
        boolean verif = dao.delete(id);
        return verif;
    }

    public static boolean update(Medecin medecin) {
        MedecinImpDAO dao = new MedecinImpDAO();
        boolean verif = dao.update(medecin);
        return verif;
    }

    public static boolean create(Medecin medecin) {
        MedecinImpDAO dao = new MedecinImpDAO();
        boolean verif = dao.create(medecin);
        return verif;
    }
}
