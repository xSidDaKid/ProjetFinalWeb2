/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.profil;

import com.appweb2projetsession.mvc.model.Profil;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public interface ProfilDAO {

    List<Profil> findAll();

    List<Profil> findByPatientMedecinId(int medecin_id, int patient_id);

    boolean create(Profil profil);

    boolean delete(int id);

    boolean update(Profil profil);
}
