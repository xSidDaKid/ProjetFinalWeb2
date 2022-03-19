/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.utilisateur;

import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public interface UtilisateurDAO {

    Utilisateur isExiste(String email, String motDePasse);

    boolean create(Utilisateur utilisateur);

    boolean update(Utilisateur utilisateur);

    List<Utilisateur> findAll();

    Utilisateur findByEmail(String email);
    
    Utilisateur findByID(int id);
    
    boolean delete(int id);
    
}
