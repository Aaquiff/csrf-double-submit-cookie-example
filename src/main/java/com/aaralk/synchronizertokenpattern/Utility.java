/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaralk.synchronizertokenpattern;

import javax.servlet.http.Cookie;

/**
 *
 * @author aaralk
 */
public class Utility {

    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(cookieName)) {
                    return cookies[i];
                }
            }
        }
        return null;
    }
}
