package org.example.DAO.AdminDAO;
import java.sql.Date;
import org.example.DAO.ConnectionMySql;
import org.example.config.AdminConfig;
import org.example.model.Subject;
import org.example.model.User;
import java.sql.*; // Thư viện cho JDBC
import java.util.*; // Thư viện cho các kiểu dữ liệu như List, Map
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; // Nhập ResultSet
import java.util.ArrayList;
import java.util.List;


public class AdminDAO {
    Connection connection = ConnectionMySql.getConnection();
    AdminConfig adminConfig = new AdminConfig();

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
        String updateAddress = "UPDATE user SET address = ? WHERE idUser = ?" ;
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
    // Sưa SDT
    public boolean updateStudentPhone(User user) {
        String updatePhone = "UPDATE user SET phone = ? WHERE idUser = ? ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updatePhone);
            preparedStatement.setString(1, user.getPhone());
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
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //Hiện thị thông tin
    public  List<User> studentList() {
        String sql = "select * from user "  ;
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                User user1 = new User(ID, userName, password, name,email, phone, gender,birthday,address, status, role);
                userList.add(user1);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return userList;
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
    //Sửa tên môn học
    public boolean updateNameSubject(Subject subject) {
        String updateAddress = "UPDATE subject SET subjectname = ? WHERE idSubject = ?" ;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateAddress);
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setString(2, subject.getIdSubject());
            return preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateCreditSubject(Subject subject) {
        String updateCredit = "UPDATE subject SET credit = ? WHERE idSubject = ?" ;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateCredit);
            preparedStatement.setInt(1, subject.getCredit());
            preparedStatement.setString(2, subject.getIdSubject());
            return preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public Subject findSubjectByID(String subjectId) {
        String sql = "SELECT * FROM subject WHERE idSubject = ?";
        Subject subject = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String ID = resultSet.getString("idSubject");
            String subjectName = resultSet.getString("subjectname");
            int credit = resultSet.getInt("credit");
            return new Subject(ID, subjectName, credit);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //Hiện thị sinh viên có điểm > 8
    public  Map<String, List<Map<String, Object>>> getStudentsWithClassification()  {
        String sql = "SELECT user.idUser, user.username, enrollment.avgScore\n" +
                     "FROM user\n" +
                     "JOIN enrollment ON user.idUser = enrollment.idUser;";
        // Tạo Map để lưu trữ danh sách theo phân loại
        Map<String, List<Map<String, Object>>> classificationMap = new HashMap<>();
        classificationMap.put("Giỏi", new ArrayList<>());
        classificationMap.put("Khá", new ArrayList<>());
        classificationMap.put("Trung bình", new ArrayList<>());
        classificationMap.put("Yếu", new ArrayList<>());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> studentData = new HashMap<>();
                studentData.put("idUser", resultSet.getString("idUser"));
                studentData.put("username", resultSet.getString("username"));
                int avgScore = resultSet.getInt("avgScore");

                // Xác định mã phân loại dựa trên điểm
                int classificationCode;
                if (avgScore >= 9) {
                    classificationCode = 1; // Giỏi
                } else if (avgScore >= 7) {
                    classificationCode = 2; // Khá
                } else if (avgScore >= 5) {
                    classificationCode = 3; // Trung bình
                } else {
                    classificationCode = 4; // Yếu
                }

                // Thêm dữ liệu sinh viên vào danh sách phân loại tương ứng
                String classification = adminConfig.evaluateScore(classificationCode);
                studentData.put("avgScore", avgScore);
                classificationMap.get(classification).add(studentData); // Thêm vào danh sách tương ứng
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return classificationMap;
    }

}