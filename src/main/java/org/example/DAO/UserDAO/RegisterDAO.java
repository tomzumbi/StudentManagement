package org.example.DAO.UserDAO;

import org.example.DAO.ConnectionMySql;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection = ConnectionMySql.getConnection();
    public boolean register(User user) {
        String sql = "insert into user (username, password, name, email) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getName());
            ps.setString(4,user.getEmail());
            return ps.execute();
        } catch (SQLException e) {
            return false;
        }
    }
}
