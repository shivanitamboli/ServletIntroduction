package com.bridgelabz;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@webServlet("/fs")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<h3>Hello world !!! This is my First Servlet</h3>");
        out.close();
    }
}
