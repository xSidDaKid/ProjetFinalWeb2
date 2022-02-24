/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.patient;

import com.appweb2projetsession.dao.patient.PatientImpDAO;
import com.appweb2projetsession.mvc.model.Patient;
import java.util.List;

/**
 *
 * @author 1723144
 */
public class PatientTestDAO {


    public static void main(String[] args) {
        PatientImpDAO dao = new PatientImpDAO();
        List<Patient> listePatient;
        listePatient = dao.findAll();
        for (Patient patient : listePatient) {
            System.out.println(patient);
        }
    }
}
