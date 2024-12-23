package com.servlet;

import java.io.IOException;

import com.dao.UserDAO;
import com.daoimp.UserDAOImp;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");

        User user = new User(name, email, age, phone);

        UserDAO userDao = new UserDAOImp();
        int result = userDao.addUser(user);

        if (result > 0) {
            res.sendRedirect("fetchData");
        } else {
            res.sendRedirect("failure.html");
        }
    }

}
