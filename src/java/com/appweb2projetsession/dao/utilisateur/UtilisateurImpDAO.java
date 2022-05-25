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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shajaan
 */
public class UtilisateurImpDAO implements UtilisateurDAO {

    private static final String SQL_CONNEXION = "SELECT * FROM utilisateur WHERE email=? and password=?";
    private static final String SQL_CREATE = "INSERT INTO utilisateur (username,password,email,role) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE utilisateur SET username = ?, password = ?, email = ? WHERE id = ?";
    private static final String SQL_SELECT = "SELECT * FROM utilisateur";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM utilisateur where email = ?";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM utilisateur where id = ?";
    private static final String SQL_DELETE = "DELETE FROM utilisateur WHERE id = ?";

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
                u.setId(result.getInt("id"));
                u.setUsername(result.getString("username"));
                u.setPassword(result.getString("password"));
                u.setEmail(result.getString("email"));
                u.setRole(result.getString("role"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return u;
    }

    @Override
    public boolean create(Utilisateur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE);

            ps.setString(1, utilisateur.getUsername());
            ps.setString(2, utilisateur.getPassword());
            ps.setString(3, utilisateur.getEmail());
            ps.setString(4, utilisateur.getRole());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Utilisateur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, utilisateur.getUsername());
            ps.setString(2, utilisateur.getPassword());
            ps.setString(3, utilisateur.getEmail());
            ps.setInt(4, utilisateur.getId());
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> listeUtilisateur = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listeUtilisateur = new ArrayList<>();

            while (result.next()) {
                Utilisateur p1 = new Utilisateur();
                p1.setId(result.getInt("id"));
                p1.setUsername(result.getString("username"));
                p1.setPassword(result.getString("password"));
                p1.setEmail(result.getString("email"));
                p1.setRole(result.getString("role"));
                listeUtilisateur.add(p1);
            }
            result.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeUtilisateur;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        Utilisateur u = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_EMAIL);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                u = new Utilisateur();
                u.setId(result.getInt("id"));
                u.setUsername(result.getString("username"));
                u.setPassword(result.getString("password"));
                u.setEmail(result.getString("email"));
                u.setRole(result.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return u;
    }

    @Override
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Utilisateur findByID(int id) {
        Utilisateur u = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                u = new Utilisateur();
                u.setId(result.getInt("id"));
                u.setUsername(result.getString("username"));
                u.setPassword(result.getString("password"));
                u.setEmail(result.getString("email"));
                u.setRole(result.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return u;
    }
}
