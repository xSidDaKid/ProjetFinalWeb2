/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.utilisateur;

import com.appweb2projetsession.mvc.model.Utilisateur;

/**
 *
 * @author Shajaan
 */
public interface UtilisateurDAO {

    Utilisateur isExiste(String email, String motDePasse);

}
