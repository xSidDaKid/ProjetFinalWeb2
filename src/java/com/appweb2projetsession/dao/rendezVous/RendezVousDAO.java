/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.rendezVous;

import com.appweb2projetsession.mvc.model.RendezVous;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public interface RendezVousDAO {

    List<RendezVous> findAll();

    RendezVous findById(int id);

    List<RendezVous> findByIdMedecin(int idMedecin);

    RendezVous findByDate(String date);

    List<RendezVous> findByAvaiableDate();

    boolean create(RendezVous rV);

    boolean update(RendezVous rV);

    boolean delete(int id);
}
