package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "shivani"),
                @WebInitParam(name = "password", value = "shivani")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get request param for usr and password
        String user=req.getParameter("SHIVANI");
        String pwd=req.getParameter("Bridgelabz");
        //get servlet config init params
        String userID=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");
        if (userID.equals(user) && password.equals(pwd)){
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp" ).forward(req,resp);

        }
        else {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red> Either User Name Or Password is Wrong </font> ");
            rd.include(req,resp);
        }
        // UC3 : Validating name of the user
        String nameValidate = "^[A-Z][a-z]{2,}";
        if(userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd)) {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out  = resp.getWriter();
            out.println("<font color = red> Either username or password is wrong</font>");
            rd.include(req, resp);
        }

        // UC4 : Validating password of the user
        String passwordValidate = "^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$";

        if(userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd) && password.matches(passwordValidate)) {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out  = resp.getWriter();
            out.println("<font color = red> Either username or password is wrong</font>");
            rd.include(req, resp);
        }
    }
}