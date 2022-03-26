/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.dao.rendezVous;

import com.appweb2projetsession.db.singleton.ConnexionBD;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.sql.Date;
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
public class RendezVousImpDAO implements RendezVousDAO {

    //Liste des requetes
    private static final String SQL_SELECT = "SELECT * FROM rendezvous";
    private static final String SQL_SELECT_ID = "SELECT * FROM rendezvous WHERE id=?";
    private static final String SQL_SELECT_DATE = "SELECT * FROM rendezvous WHERE date=?";
    private static final String SQL_SELECT_PATIENT = "SELECT * FROM rendezvous WHERE patient_id IS NULL";
    private static final String SQL_INSERT = "INSERT INTO rendezvous (date, medecin_id) value (?, ?)";
    //Insert into rendezvous (id,date, medecin_id) value (1,"2020-04-04 10:00",1)
    private static final String SQL_UPDATE = "UPDATE rendezvous SET date = ?, medecin_id = ?, patient_id = ?, raison = ?, description = ?  WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM rendezvous WHERE id = ?";

    @Override
    public List<RendezVous> findAll() {
        List<RendezVous> listeRendezVous = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();

            listeRendezVous = new ArrayList<>();

            while (result.next()) {
                RendezVous rV = new RendezVous();
                rV.setId(result.getInt("id"));
                rV.setDate(result.getString("date"));
                rV.setMedecin_id(result.getInt("medecin_id"));
                rV.setPatient_id(result.getInt("patient_id"));
                rV.setRaison(result.getString("raison"));
                rV.setDescription(result.getString("description"));
                listeRendezVous.add(rV);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeRendezVous;
    }

    @Override
    public RendezVous findById(int id) {
        RendezVous rV = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                rV = new RendezVous();
                rV.setId(result.getInt("id"));
                rV.setDate(result.getString("date"));
                rV.setMedecin_id(result.getInt("medecin_id"));
                rV.setPatient_id(result.getInt("patient_id"));
                rV.setRaison(result.getString("raison"));
                rV.setDescription(result.getString("description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return rV;
    }

    @Override
    public RendezVous findByDate(String date) {
        RendezVous rV = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_DATE);
            ps.setString(1, date);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                rV = new RendezVous();
                rV.setId(result.getInt("id"));
                rV.setDate(result.getString("date"));
                rV.setMedecin_id(result.getInt("medecin_id"));
                rV.setPatient_id(result.getInt("patient_id"));
                rV.setRaison(result.getString("raison"));
                rV.setDescription(result.getString("description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return rV;
    }

    @Override
    public List<RendezVous> findByAvaiableDate() {
        List<RendezVous> listeRendezVous = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PATIENT);
            ResultSet result = ps.executeQuery();
            listeRendezVous = new ArrayList<>();
            
            while (result.next()) {
                RendezVous rV = new RendezVous();
                rV = new RendezVous();
                rV.setId(result.getInt("id"));
                rV.setDate(result.getString("date"));
                rV.setMedecin_id(result.getInt("medecin_id"));
                rV.setPatient_id(result.getInt("patient_id"));
                rV.setRaison(result.getString("raison"));
                rV.setDescription(result.getString("description"));
                listeRendezVous.add(rV);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeRendezVous;
    }

    @Override
    public boolean create(RendezVous rV) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, rV.getDate());
            ps.setInt(2, rV.getMedecin_id());
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(RendezVous rV) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, rV.getDate());
            ps.setInt(2, rV.getMedecin_id());
            ps.setInt(3, rV.getPatient_id());
            ps.setString(4, rV.getRaison());
            ps.setString(5, rV.getDescription());
            ps.setInt(10, rV.getId());
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(RendezVousImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

}
