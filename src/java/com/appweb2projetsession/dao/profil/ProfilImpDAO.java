/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.profil;

import com.appweb2projetsession.dao.patient.PatientImpDAO;
import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.Profil;
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
public class ProfilImpDAO implements ProfilDAO {

    //Liste des requetes
    private static final String SQL_SELECT = "SELECT * FROM profil";
    private static final String SQL_SELECT_MEDECIN_PATIENT = "SELECT * FROM profil WHERE patient_id=? AND medecin_id=?";
    private static final String SQL_INSERT = "INSERT INTO profil (nomFichier, contenuFichier, information, date, patient_id, medecin_id) value (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM profil WHERE id = ?";

    @Override
    public List<Profil> findAll() {
        List<Profil> listeProfil = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listeProfil = new ArrayList<>();

            while (result.next()) {
                Profil p1 = new Profil();
                p1.setId(result.getInt("id"));
                p1.setNomFichier(result.getString("nomFichier"));
                p1.setContenuFichier(result.getBinaryStream("contenuFichier"));
                p1.setInfo(result.getString("information"));
                p1.setDate(result.getString("date"));
                p1.setPatient_id(result.getInt("patient_id"));
                p1.setMedecin_id(result.getInt("medecin_id"));
                listeProfil.add(p1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfilImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProfil;
    }

    @Override
    public List<Profil> findByPatientMedecinId(int patient_id, int medecin_id) {
        List<Profil> listeProfil = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PATIENT);
            ps.setInt(1, patient_id);
            ps.setInt(2, medecin_id);
            ResultSet result = ps.executeQuery();

            listeProfil = new ArrayList<>();
            
            while (result.next()) {
                Profil p1 = new Profil();
                p1.setId(result.getInt("id"));
                p1.setNomFichier(result.getString("nomFichier"));
                p1.setContenuFichier(result.getBinaryStream("contenuFichier"));
                p1.setInfo(result.getString("information"));
                p1.setDate(result.getString("date"));
                p1.setPatient_id(result.getInt("patient_id"));
                p1.setMedecin_id(result.getInt("medecin_id"));
                listeProfil.add(p1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProfil;
    }

    @Override
    public boolean create(Profil profil) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, profil.getNomFichier());
            ps.setBlob(2, profil.getContenuFichier());
            ps.setString(3, profil.getInfo());
            ps.setString(4, profil.getDate());
            ps.setInt(5, profil.getPatient_id());
            ps.setInt(6, profil.getMedecin_id());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(ProfilImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Profil profil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
