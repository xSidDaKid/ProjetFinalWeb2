/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.utilisateur;

import com.appweb2projetsession.dao.utilisateur.UtilisateurImpDAO;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.util.Scanner;

/**
 *
 * @author Shajaan
 */
public class UtilisateurTestDAO {

    public static void main(String[] args) {
        UtilisateurImpDAO dao = new UtilisateurImpDAO();
        
        Utilisateur u = dao.isExiste("c", "b");
        System.out.println(u);
        
        boolean verif = dao.create(new Utilisateur("b", "c", "d", "Patient"));
    }
}
