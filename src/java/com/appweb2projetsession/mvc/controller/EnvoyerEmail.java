/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appweb2projetsession.mvc.controller;

import com.appweb2projetsession.mvc.util.EmailUtility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Classe qui permet de traiter l'email envoyer par le medecin a son patient
 *
 * @author Shajaan
 * @Groupe 02
 * @Remis_a Dini Ahamada
 * @Cours 420-G26-RO
 * @Date_de_remise 26 mai 2022
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)		// 50MB
public class EnvoyerEmail extends AbstractAction {

    private String host;
    private String port;
    private String user;
    private String pass;

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);

        boolean langEN = false;
        if (session.getAttribute("lang").equals("en")) {
            langEN = true;
        }

        host = "smtp.gmail.com";
        port = "587";
        user = "dummyEmailDev87@gmail.com";
        pass = "pens87712981";

        // List<File> uploadedFiles = new ArrayList<>();
        String destinataire = request.getParameter("destinataire");
        String objet = request.getParameter("objet");
        String contenu = request.getParameter("contenu");
        String resultMessage = "L'email a été envoyé avec succès";
        String resultMessage2 = "Email sent";

        try {
            //uploadedFiles = saveUploadedFiles(request);

            // lit les champs du formulaire
            EmailUtility.sendEmail(host, port, user, pass, destinataire, objet, contenu);
        } catch (IllegalStateException ex) {
            Logger.getLogger(EnvoyerEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnvoyerEmail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //deleteUploadFiles(uploadedFiles);
            if (langEN) {
                request.setAttribute("Message", resultMessage2);
            } else {
                request.setAttribute("Message", resultMessage);
            }
            return "emailForm";
        }
    }

    /**
     * Enregistre les fichiers téléchargés depuis le client et renvoie une liste
     * de ces fichiers qui sera joint au message e-mail.
     */
    private List<File> saveUploadedFiles(HttpServletRequest request)
            throws IllegalStateException, IOException, ServletException {
        List<File> listFiles = new ArrayList<File>();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        Collection<Part> multiparts = request.getParts();
        if (multiparts.size() > 0) {
            for (Part part : request.getParts()) {
                // crée un fichier à enregistrer
                String fileName = extractFileName(part);
                if (fileName == null || fileName.equals("")) {
                    // pas de pièce jointe, continuer
                    continue;
                }

                File saveFile = new File(fileName);
                System.out.println("saveFile: " + saveFile.getAbsolutePath());
                FileOutputStream outputStream = new FileOutputStream(saveFile);

                // enregistre le fichier téléchargé
                InputStream inputStream = part.getInputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();

                listFiles.add(saveFile);
            }
        }
        return listFiles;
    }

    /**
     * Récupère le nom de fichier d'une partie de téléchargement à partir de son
     * en-tête HTTP
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }

    /**
     * Deletes all uploaded files, should be called after the e-mail was sent.
     */
    private void deleteUploadFiles(List<File> listFiles) {
        if (listFiles != null && listFiles.size() > 0) {
            for (File aFile : listFiles) {
                aFile.delete();
            }
        }
    }
}
