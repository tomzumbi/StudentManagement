package org.example.DAO.AdminDAO;
import java.sql.Date;
import org.example.DAO.ConnectionMySql;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; // Nhập ResultSet


public class AdminDAO {
    Connection connection = ConnectionMySql.getConnection();

    // Xóa sinh viên
    public void deleteStudent(String idUser) {
        String sqlFK = "delete from enrollment where idUser =" + idUser ; // Thay 'students' bằng tên bảng của bạn
        String sqlPK = "delete from user where idUser = " + idUser ; // Thay 'students' bằng tên bảng của bạn

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlFK);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlPK);

            preparedStatement.execute();
            preparedStatement1.execute();
        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    // Phương thức sửa ngày sinh sinh viên
    public boolean updateStudentDateOfBirth(User user) {
        String sql = "UPDATE user SET birthday = ? WHERE idUser = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, user.getBirthday());
            preparedStatement.setString(2, user.getIdUser());
            return  preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức sửa địa chỉ sinh viên
    public boolean updateStudentAddress(User user) {
        String updateAddress = "UPDATE user SET address = ? WHERE idUser = ? WHERE " ;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateAddress);
            preparedStatement.setString(1, user.getAddress());
            preparedStatement.setString(2, user.getIdUser());
            return preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        }

    // Update email
    public boolean updateEmailStudent(User user) {
        String updateEmail = "UPDATE user SET email = ? WHERE idUser = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateEmail);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getIdUser());
            return preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //Update status
    public  boolean uppdateStatus(User user) {
        String updateStatus = "UPDATE user SET status = ? WHERE idUser = ? ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatus);
            preparedStatement.setInt(1, user.getStatus());
            preparedStatement.setString(2, user.getIdUser());
            return preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public User findUserByID(String userId) {
        String sql = "SELECT * FROM user WHERE idUser = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String ID = resultSet.getString("idUser");
            String userName = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String gender = resultSet.getString("gender");
            Date birthday = resultSet.getDate("birthday");
            int status = resultSet.getInt("status");
            boolean role = resultSet.getBoolean("role");
            return new User(ID, userName, password, name,email, phone, gender,birthday,address, status, role);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    }
