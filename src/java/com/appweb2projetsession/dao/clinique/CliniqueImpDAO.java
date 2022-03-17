/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.clinique;

import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.Clinique;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robydul
 */
public class CliniqueImpDAO implements CliniqueDAO {

    //Liste des requetes
    private static final String SQL_SELECT = "SELECT * FROM clinique";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM clinique where id = ?";
    private static final String SQL_INSERT = "INSERT INTO clinique (nom,adresse,tel,services,utilisateur_id) value (?, ?, ?, ?,?)";
    private static final String SQL_DELETE = "DELETE FROM clinique WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE clinique SET nom = ?, adresse = ?, tel = ?, services = ? utilisateur_id = ? WHERE id = ?";
    //private static final String SQL_CONNEXION = "SELECT nom FROM clinique WHERE adresse=? and tel=?";

    @Override
    public List<Clinique> findAll() {
        List<Clinique> listeClinique = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listeClinique = new ArrayList<>();

            while (result.next()) {
                Clinique c1 = new Clinique();
                c1.setId(result.getInt("id"));
                c1.setNom(result.getString("nom"));
                c1.setAdresse(result.getString("adresse"));
                c1.setTel(result.getString("tel"));
                c1.setServices(result.getString("services"));
                c1.setId_user(result.getInt("utilisateur_id"));
                listeClinique.add(c1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeClinique;
    }

    @Override
    public Clinique findById(int id) {
        Clinique c1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                c1 = new Clinique();
                c1.setId(result.getInt("id"));
                c1.setNom(result.getString("nom"));
                c1.setAdresse(result.getString("adresse"));
                c1.setTel(result.getString("tel"));
                c1.setServices(result.getString("services"));
                c1.setId_user(result.getInt("utilisateur_id"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return c1;
    }

    @Override
    public boolean create(Clinique clinique) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, clinique.getNom());
            ps.setString(2, clinique.getAdresse());
            ps.setString(3, clinique.getTel());
            ps.setString(4, clinique.getServices());
            ps.setInt(5, clinique.getId_user());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
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
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Clinique clinique) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, clinique.getNom());
            ps.setString(2, clinique.getAdresse());
            ps.setString(3, clinique.getTel());
            ps.setString(4, clinique.getServices());
            ps.setInt(5, clinique.getId_user());
            ps.setInt(6, clinique.getId());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Clinique isExiste(String adresse, String tel) {
        Clinique c1 = null;
//        try {
//            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION);
//            ps.setString(1, adresse);
//            ps.setString(2, tel);
//            ResultSet result = ps.executeQuery();
//            while (result.next()) {
//                c1 = new Clinique();
//                c1.setNom(result.getString("nom"));
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        ConnexionBD.closeConnection();
        return c1;
    }

}
