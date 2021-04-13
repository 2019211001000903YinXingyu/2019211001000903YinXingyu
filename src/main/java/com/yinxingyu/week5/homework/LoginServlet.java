package com.yinxingyu.week5.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException {
        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String sql = "select * from usertable where Username='" + Username + "' and Password='" + Password + "'";

        try {
            System.out.println("con:" + con);
            Statement sta = con.createStatement();
            System.out.println(sql);
            ResultSet rs = sta.executeQuery(sql);

            if (rs.next()) {
//                writer.println("Login Success!!!");
//                writer.println("Welcome" + Username);
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("Username", rs.getString("Username"));
                request.setAttribute("Password", rs.getString("Password"));
                request.setAttribute("Email", rs.getString("Email"));
                request.setAttribute("Gender", rs.getString("Gender"));
                request.setAttribute("BirthDate", rs.getString("BirthDate"));

                request.getRequestDispatcher("UserInfo.jsp").forward(request, response);

            } else {
//                writer.println("Username or Password Error!!!");
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
