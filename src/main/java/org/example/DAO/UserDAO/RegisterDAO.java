package org.example.DAO.UserDAO;

import org.example.DAO.Conection.ConnectionMySql;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection = ConnectionMySql.getConnection();

    public boolean register(User user) {
        String sql = "insert into user (username,password,role) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3,user.getRole());
        } catch (SQLException e){
            return false;
        }
        return true;
    }
}
