/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.patient.PatientImpDAO;
import com.appweb2projetsession.mvc.model.Patient;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class PatientAction {

    public static List<Patient> afficherTous() {
        PatientImpDAO dao = new PatientImpDAO();
        List<Patient> listePatient = dao.findAll();
        return listePatient;
    }

    public static Patient findById(int id) {
        PatientImpDAO dao = new PatientImpDAO();
        Patient patient = dao.findById(id);
        return patient;
    }

    public static boolean delete(int id) {
        PatientImpDAO dao = new PatientImpDAO();
        boolean verif = dao.delete(id);
        return verif;
    }

    public static boolean update(Patient patient) {
        PatientImpDAO dao = new PatientImpDAO();
        boolean verif = dao.equals(patient);
        return verif;
    }
}
