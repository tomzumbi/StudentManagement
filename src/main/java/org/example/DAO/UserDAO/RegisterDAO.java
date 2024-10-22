package org.example.DAO.UserDAO;

import org.example.DAO.Conection.ConnectionMySql;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection = ConnectionMySql.getConnection();

    public boolean register(User user) {
        String sql = "insert into user (idUser,username,password,role) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getIdUser());
            ps.setString(2, user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setInt(4,user.getRole());
            return ps.execute();
        } catch (SQLException e){
            return false;
        }

    }

    public boolean checkUsername(String username) {
        String sql = "select count(*) from user where username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

}
