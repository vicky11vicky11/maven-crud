package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.UserDAO;
import com.daoimp.UserDAOImp;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fetchData")
public class FetchUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserDAO userDao = new UserDAOImp();
        List<User> usersList = userDao.getAllUsers();
        HttpSession session = req.getSession();
        session.setAttribute("usersList", usersList);
        res.sendRedirect("home.jsp");
    }

}
