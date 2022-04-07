/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.profil;

import com.appweb2projetsession.dao.profil.ProfilImpDAO;
import com.appweb2projetsession.mvc.model.Profil;
import java.io.File;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class ProfilTestDAO {
        private static ProfilImpDAO dao = new ProfilImpDAO();
    private static List<Profil> listeProfil;
    
    public static void main(String[] args) {
//                listeProfil = dao.findAll();
//        for (Profil profil : listeProfil) {
//            System.out.println(profil + "\n");
//            File file = new File(profil.getNomFichier());
//            FileOutputStream output = new FileOutputStream(file);
//
//            System.out.println("Writing to file " + file.getAbsolutePath());
//            while (rs.next()) {
//                InputStream input = rs.getBinaryStream("resume");
//                byte[] buffer = new byte[1024];
//                while (input.read(buffer) > 0) {
//                    output.write(buffer);
//                }
//            }
//        }

//Profil profil = dao.findByPatientMedecinId(1,1);
//        System.out.println(profil);
    }
}
