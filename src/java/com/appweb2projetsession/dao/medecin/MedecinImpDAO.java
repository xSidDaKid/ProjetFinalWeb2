/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.medecin;

import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.Medecin;
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
public class MedecinImpDAO implements MedecinDAO {

    //Liste des requetes
    private static final String SQL_SELECT = "SELECT * FROM medecin";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM medecin where id = ?";
    private static final String SQL_SELECT_PAR_IDUSER = "SELECT * FROM medecin where utilisateur_id = ?";
    private static final String SQL_INSERT = "INSERT INTO medecin (nom,prenom,profession,nbProfessionnel,ententes,adresse,lieuProfession,clinique_id,utilisateur_id) value (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM medecin WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE medecin SET nom = ?, prenom = ?, profession = ?,  nbProfessionnel = ?,  ententes = ?,  adresse = ?, lieuProfession = ?, clinique_id = ?, utilisateur_id = ? WHERE id = ?";

    @Override
    public List<Medecin> findAll() {
        List<Medecin> listeMedecin = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listeMedecin = new ArrayList<>();

            while (result.next()) {
                Medecin m1 = new Medecin();
                m1.setId(result.getInt("id"));
                m1.setNom(result.getString("nom"));
                m1.setPrenom(result.getString("prenom"));
                m1.setProfession(result.getString("profession"));
                m1.setNbProfessionnel(result.getString("nbProfessionnel"));
                m1.setEntentes(result.getString("ententes"));
                m1.setAdresse(result.getString("adresse"));
                m1.setLieuProfession(result.getString("lieuProfession"));
                m1.setId_clinique(result.getInt("clinique_id"));
                m1.setId_user(result.getInt("utilisateur_id"));
                listeMedecin.add(m1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public Medecin findById(int id) {
        Medecin m1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                m1 = new Medecin();
                m1.setId(result.getInt("id"));
                m1.setNom(result.getString("nom"));
                m1.setPrenom(result.getString("prenom"));
                m1.setProfession(result.getString("profession"));
                m1.setNbProfessionnel(result.getString("nbProfessionnel"));
                m1.setEntentes(result.getString("ententes"));
                m1.setAdresse(result.getString("adresse"));
                m1.setLieuProfession(result.getString("lieuProfession"));
                m1.setId_user(result.getInt("clinique_id"));
                m1.setId_user(result.getInt("utilisateur_id"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return m1;
    }

    @Override
    public Medecin findByIdUser(int id) {
        Medecin m1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_IDUSER);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                m1 = new Medecin();
                m1.setId(result.getInt("id"));
                m1.setNom(result.getString("nom"));
                m1.setPrenom(result.getString("prenom"));
                m1.setProfession(result.getString("profession"));
                m1.setNbProfessionnel(result.getString("nbProfessionnel"));
                m1.setEntentes(result.getString("ententes"));
                m1.setAdresse(result.getString("adresse"));
                m1.setLieuProfession(result.getString("lieuProfession"));
                m1.setId_user(result.getInt("clinique_id"));
                m1.setId_user(result.getInt("utilisateur_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return m1;
    }

    @Override
    public boolean create(Medecin medecin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getProfession());
            ps.setString(4, medecin.getNbProfessionnel());
            ps.setString(5, medecin.getEntentes());
            ps.setString(6, medecin.getAdresse());
            ps.setString(7, medecin.getLieuProfession());
            ps.setInt(8, medecin.getId_clinique());
            ps.setInt(9, medecin.getId_user());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Medecin medecin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getProfession());
            ps.setString(4, medecin.getNbProfessionnel());
            ps.setString(5, medecin.getEntentes());
            ps.setString(6, medecin.getAdresse());
            ps.setString(7, medecin.getLieuProfession());
            ps.setInt(8, medecin.getId_clinique());
            ps.setInt(9, medecin.getId_user());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(MedecinImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

}
