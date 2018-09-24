/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaralk.synchronizertokenpattern;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aaralk
 */
public class Login extends HttpServlet {
    
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
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("aaralk".equals(username) && "aaralk".equals(password)) {
                //Generate UUIDs for sessionId and tokenId
                String sessionId = UUID.randomUUID().toString();
                
                //Set the session cookie in the response                
                response.addHeader("Set-Cookie", "SESSIONID="+ sessionId + ";");

                response.sendRedirect("./adduser.jsp");
            }
            else {
                response.sendError(500, "Incorrect Credential " + username + password);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
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
