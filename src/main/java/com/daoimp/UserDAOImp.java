package com.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDAO;
import com.db.ConnectDatabase;
import com.model.User;

@SuppressWarnings("CallToPrintStackTrace")
public class UserDAOImp implements UserDAO {
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private List<User> usersList = new ArrayList<>();

    private final String ADD_USER_QUERY = "insert into user(name,email,age,phone) values(?,?,?,?)";
    private final String GET_USER_QUERY = "select * from user";
    private final String DELETE_USER_QUERY = "delete from user where id=?";
    private final String UPDATE_USER_QUERY = " update user set name=?,email=?,age=?,phone=? where id=?";

    public UserDAOImp() {
        try {
            con = ConnectDatabase.connectDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addUser(User user) {
        try {
            pstmt = con.prepareStatement(ADD_USER_QUERY);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getPhone());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(GET_USER_QUERY);
            usersList = extractUserList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    private List<User> extractUserList(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setPhone(resultSet.getString(5));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public int deleteUser(int id) {
        try {
            pstmt = con.prepareStatement(DELETE_USER_QUERY);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUser(User user) {

        try {
            pstmt = con.prepareStatement(UPDATE_USER_QUERY);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getPhone());
            pstmt.setInt(5, user.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
