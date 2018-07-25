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
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == "aaralk" && password == "aaralk") {

                Cookie c1 = new Cookie("KSESSIONID", "anything");
                c1.setMaxAge(60 * 60);
                c1.setSecure(true);

                response.addHeader("Set-Cookie", "name=value; HttpOnly");

                response.addCookie(c1);
            } else {
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
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
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("aaralk".equals(username) && "aaralk".equals(password)) {
                //Generate UUIDs for sessionId and tokenId
                String sessionId = UUID.randomUUID().toString();
                
                //Set the session cookie in the response
                Cookie c1 = new Cookie("SESSIONID", sessionId);
                c1.setMaxAge(60 * 60);
                c1.setSecure(true);
                response.addCookie(c1);

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
