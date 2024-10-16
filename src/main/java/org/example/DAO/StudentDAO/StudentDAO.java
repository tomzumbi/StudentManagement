package org.example.DAO.StudentDAO;

import org.example.DAO.ConnectionMySql;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    private Connection connection = ConnectionMySql.getConnection();
    public boolean updateInformation(User user) {
        String sql = "update user set name=?, birthday=?, address=? where idUser=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setDate(2,user.getBirthday());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getIdUser());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean editEmail(User user) {
        String sql = "update user set email=? where idUser=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2,user.getIdUser());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editPhone(User user) {
        String sql = "update user set phone=? where idUser=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPhone());
            preparedStatement.setString(2,user.getIdUser());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
