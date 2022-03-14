/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.utilisateur;

import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shajaan
 */
public class UtilisateurImpDAO implements UtilisateurDAO {

    private static final String SQL_CONNEXION = "SELECT username FROM utilisateur WHERE email=? and password=?";

    @Override
    public Utilisateur isExiste(String email, String motDePasse) {
        Utilisateur u = null;

        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION);
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                u = new Utilisateur();
                u.setUsername(result.getString("username"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return u;
    }

}
