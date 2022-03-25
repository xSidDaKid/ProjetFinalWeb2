/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.medecin;

import com.appweb2projetsession.mvc.model.Medecin;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public interface MedecinDAO {

    List<Medecin> findAll();

    Medecin findById(int id);

    Medecin findByIdUser(int id);

    boolean create(Medecin clinique);

    boolean delete(int id);

    boolean update(Medecin clinique);

}
