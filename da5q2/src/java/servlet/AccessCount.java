/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gagan
 */
public class AccessCount extends HttpServlet
{
     //Instance variable used for counting hits on this servlet
     private int iHitCounter;

     //init method just initializes the hitCounter to zero
     @Override
     public void init() throws ServletException
     {
          iHitCounter = 0;
     }
     @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          PrintWriter out =  response.getWriter();
          response.setContentType("text/html");
          out.println("<body>");
          out.println("<h3>Welcome to 20BIT0025 website</h3>");
          out.println("You are visitor number: "+ (++iHitCounter));
          out.println("<br/><br/>Every refresh counts as an access and increases the count by 1");
          out.println("</body>");
     }
     @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          doGet(request, response);
     }
}
