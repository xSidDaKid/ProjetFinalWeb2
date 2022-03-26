/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.rendezVous.RendezVousImpDAO;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class RendezVousAction {

    public static List<RendezVous> findAll() {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        List<RendezVous> listeRendezVous = dao.findAll();
        return listeRendezVous;
    }

    public static RendezVous findById(int id) {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        RendezVous rV = dao.findById(id);
        return rV;
    }

    public static RendezVous findByDate(String date) {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        RendezVous rV = dao.findByDate(date);
        return rV;
    }

    public static List<RendezVous> findByAvaiableDate() {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        List<RendezVous> listeRendezVous = dao.findByAvaiableDate();
        return listeRendezVous;
    }

    public static boolean create(RendezVous rV) {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        boolean verif = dao.create(rV);
        return verif;
    }

    public static boolean update(RendezVous rV) {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        boolean verif = dao.update(rV);
        return verif;
    }

    public static boolean delete(int id) {
        RendezVousImpDAO dao = new RendezVousImpDAO();
        boolean verif = dao.delete(id);
        return verif;
    }

}
