/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc2.controllerFrontal;

import com.appweb2projetsession.mvc.controller.Action;
import com.appweb2projetsession.mvc.controller.ActionBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Le contrôleur frontal est une servlet configurée pour recevoir toutes les
 * requêtes
 *
 * @author dahamada
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
public class ControllerFrontal extends HttpServlet {

    private String host;
    private String port;
    //On pourrait également initialisé l'email et le password ici:
    private String user;
    private String pass;

    @Override
    public void init() {
        // lit les paramètres du serveur SMTP à partir du fichier web.xml
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Action action;
        String vue;

        //On demande à l'action-builder de nous fournir le bon contrôleur :
        action = ActionBuilder.getAction(request);
        System.out.println(" action : " + action);

        //On injecte dans le contrôleur les objets request et response :
        action.setRequest(request);
        action.setResponse(response);

        //On exécute l'action qui nous retourne la vue qui présentera la réponse au client :
        vue = action.execute();
        System.out.println("vue : " + vue);

        //On transfert la requête à la vue :
        request.getRequestDispatcher("/WEB-INF/jsp/" + vue + ".jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
