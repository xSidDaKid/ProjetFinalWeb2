/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.test.dao.rendezVous;

import com.appweb2projetsession.dao.rendezVous.RendezVousImpDAO;
import com.appweb2projetsession.mvc.model.RendezVous;
import java.util.List;

/**
 *
 * @author Shajaan
 */
public class RendezVousTestDAO {

    private static RendezVousImpDAO dao = new RendezVousImpDAO();

    public static void main(String[] args) {
        RendezVous rV = new RendezVous("2022-03-29", 1);
        boolean verif = dao.create(rV);
        System.out.println(verif);
        
        List<RendezVous>listeRendezVous = dao.findByAvaiableDate(1);
        for (RendezVous rv : listeRendezVous) {
            System.out.println(rv);
        }
    }

}
