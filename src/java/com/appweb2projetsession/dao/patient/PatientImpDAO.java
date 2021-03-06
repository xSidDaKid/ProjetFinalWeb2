/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.patient;

import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1723144
 */
public class PatientImpDAO implements PatientDAO {

    //Liste des requetes
    private static final String SQL_SELECT = "SELECT * FROM patient";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM patient where id = ?";
    private static final String SQL_SELECT_PAR_USERID = "SELECT * FROM patient where utilisateur_id = ?";
    private static final String SQL_SELECT_PAR_MEDECINID = "SELECT * FROM patient where medecin_id = ?";
    private static final String SQL_SELECT_PAR_CLINIQUEID = "SELECT * FROM patient where clinique_id = ?";
    private static final String SQL_SELECT_PAR_NAM = "SELECT * FROM patient where nam = ?";
    private static final String SQL_SELECT_PAR_NB = "SELECT * FROM patient where nbSequentiel = ?";
    private static final String SQL_INSERT = "INSERT INTO patient (nom, prenom, nam, nbSequentiel, dateNaissance, sexe, clinique_id, medecin_id, utilisateur_id) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM patient WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE patient SET nom = ?, prenom = ?, nam = ?, nbSequentiel = ?, dateNaissance = ?, sexe = ?, clinique_id = ?, medecin_id = ?, utilisateur_id = ?  WHERE id = ?";
    private static final String SQL_CONNEXION = "SELECT nom, prenom FROM patient WHERE email=? and password=?";

    @Override
    public List<Patient> findAll() {
        List<Patient> listePatient = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listePatient = new ArrayList<>();

            while (result.next()) {
                Patient p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
                listePatient.add(p1);
            }
            result.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listePatient;
    }

    @Override
    public Patient findById(int id) {
        Patient p1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return p1;
    }

    @Override
    public boolean create(Patient patient) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getNam());
            ps.setInt(4, patient.getNbSequentiel());
            ps.setString(5, patient.getDateNaissance());
            ps.setString(6, String.valueOf(patient.getSexe()));
            ps.setInt(7, patient.getId_clinique());
            ps.setInt(8, patient.getId_medecin());
            ps.setInt(9, patient.getId_user());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Patient patient) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getNam());
            ps.setInt(4, patient.getNbSequentiel());
            ps.setString(5, patient.getDateNaissance());
            ps.setString(6, String.valueOf(patient.getSexe()));
            ps.setInt(7, patient.getId_clinique());
            ps.setInt(8, patient.getId_medecin());
            ps.setInt(9, patient.getId_user());
            ps.setInt(10, patient.getId());
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Patient isExiste(String email, String motDePasse) {
        Patient p1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION);
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                p1 = new Patient();
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return p1;
    }

    @Override
    public Patient findByUserId(int id) {
        Patient p1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_USERID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return p1;
    }

    @Override
    public List<Patient> findByMedecinId(int id) {
        List<Patient> listePatient = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_MEDECINID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            listePatient = new ArrayList<>();

            while (result.next()) {
                Patient p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
                listePatient.add(p1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listePatient;
    }

    @Override
    public List<Patient> findByCliniqueId(int id) {
        List<Patient> listePatient = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_CLINIQUEID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            listePatient = new ArrayList<>();

            while (result.next()) {
                Patient p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
                listePatient.add(p1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listePatient;
    }

    @Override
    public Patient findByNAM(String nam) {
        Patient p1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NAM);
            ps.setString(1, nam);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return p1;
    }

    @Override
    public Patient findByNbSequentiel(int nb) {
        Patient p1 = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NB);
            ps.setInt(1, nb);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                p1 = new Patient();
                p1.setId(result.getInt("id"));
                p1.setNom(result.getString("nom"));
                p1.setPrenom(result.getString("prenom"));
                p1.setNam(result.getString("nam"));
                p1.setNbSequentiel(result.getInt("nbSequentiel"));
                p1.setDateNaissance(result.getString("dateNaissance"));
                p1.setSexe(result.getString("sexe").charAt(0));
                p1.setId_clinique(result.getInt("clinique_id"));
                p1.setId_medecin(result.getInt("medecin_id"));
                p1.setId_user(result.getInt("utilisateur_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return p1;
    }

}
