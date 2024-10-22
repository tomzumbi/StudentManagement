package org.example.DAO.UserDAO;

import org.example.DAO.Conection.ConnectionMySql;
import org.example.model.User;

import java.sql.*;

public class LoginDAO {
    private Connection connection = ConnectionMySql.getConnection();


    public User findByUserName(String userName) {
        String sql = "select * from user where username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("idUser");
            String username = rs.getString("username");
            String password = rs.getString("password");
            int role = rs.getInt("role");
            return new User(id,username,password,role);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean forgetPassword(User user) {
        String sql = "update user set password = ? where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getUsername());
            return ps.execute();
        } catch (SQLException e) {
            return false;
        }
    }
}
