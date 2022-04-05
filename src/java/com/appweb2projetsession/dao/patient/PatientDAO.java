/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.patient;

import com.appweb2projetsession.mvc.model.Patient;
import java.util.List;

/**
 *
 * @author 1723144
 */
public interface PatientDAO {

    List<Patient> findAll();

    Patient findById(int id);

    Patient findByUserId(int id);

    List<Patient> findByMedecinId(int id);

    Patient findByNAM(String nam);

    Patient findByNbSequentiel(int nb);

    boolean create(Patient patient);

    boolean delete(int id);

    boolean update(Patient patient);

    Patient isExiste(String email, String motDePasse);
}
