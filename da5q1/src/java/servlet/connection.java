package servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author gagan
 */

public class connection extends HttpServlet {
 
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      List<Dairy> journal=new ArrayList<Dairy>();
      String date=request.getParameter("date");
      String entry=request.getParameter("textentry");
      
      journal.add(new Dairy(date,entry));
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
         
      out.println("<body>");
      out.println("<h3>Welcome to 20BIT0025 website</h3>");
      out.println("You are visitor number: ");
//      journal.forEach(e->System.out.println());
      out.println("<br/><br/>Every refresh counts as an access and increases the count by 1");
      out.println("</body>");
   }
   @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          doGet(request, response);
     }
}