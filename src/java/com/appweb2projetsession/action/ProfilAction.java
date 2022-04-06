/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.action;

import com.appweb2projetsession.dao.profil.ProfilImpDAO;
import com.appweb2projetsession.mvc.model.Profil;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class ProfilAction {

    public static List<Profil> afficherTous() {
        ProfilImpDAO dao = new ProfilImpDAO();
        List<Profil> listeProfil = dao.findAll();
        return listeProfil;
    }

    public static boolean create(Profil profil) {
        ProfilImpDAO dao = new ProfilImpDAO();
        boolean verif = dao.create(profil);
        return verif;
    }
}
