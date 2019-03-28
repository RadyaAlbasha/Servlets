/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Radya
 */
public class SetterServlet implements Servlet{

    ServletConfig myConfig;
    @Override
    public void init(ServletConfig config) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        myConfig=config;
    }

    @Override
    public ServletConfig getServletConfig() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
       
       myConfig.getServletContext().setAttribute("userMail", "radya@gmail.com");
        res.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = res.getWriter();
        out.println("<h1>Setter Servelet is Run</h1>");
    }

    @Override
    public String getServletInfo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
