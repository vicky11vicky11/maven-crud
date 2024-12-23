package com.servlet;

import java.io.IOException;

import com.dao.UserDAO;
import com.daoimp.UserDAOImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserDAO userDao = new UserDAOImp();
        int id = Integer.parseInt(req.getParameter("id"));
        int result = userDao.deleteUser(id);
        if (result > 0) {
            res.sendRedirect("fetchData");
        } else {
            res.sendRedirect("failure.html");
        }
    }

}
