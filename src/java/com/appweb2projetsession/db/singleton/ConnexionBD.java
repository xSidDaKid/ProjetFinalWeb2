/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.db.singleton;

import com.appweb2projetsession.db.config.ConfigBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dahamada
 */
public class ConnexionBD implements ConfigBD {

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        try {
            //chargement du driver
            Class.forName(ConfigBD.DRIVER);
            //DriverManager est responsable de la sélection de la BD et
            //la création de la connexion

            conn = DriverManager.getConnection(ConfigBD.URL, ConfigBD.USER, ConfigBD.PASSWORD);
            // set auto commit false
            // conn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated catch block
        //   conn.commit();
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
