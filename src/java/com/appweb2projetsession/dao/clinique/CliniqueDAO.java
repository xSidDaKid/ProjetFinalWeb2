/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.clinique;

import com.appweb2projetsession.mvc.model.Clinique;
import java.util.List;

/**
 *
 * @author Robydul
 */
public interface CliniqueDAO {

    List<Clinique> findAll();

    Clinique findById(int id);

    Clinique findByIdUser(int id);

    boolean create(Clinique clinique);

    boolean delete(int id);

    boolean update(Clinique clinique);

    Clinique isExiste(String adresse, String tel);

}
