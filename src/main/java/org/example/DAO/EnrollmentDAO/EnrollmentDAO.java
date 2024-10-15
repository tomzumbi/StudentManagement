package org.example.DAO.EnrollmentDAO;

import org.example.DAO.ConnectionMySql;
import org.example.model.Enrollment;
import org.example.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentDAO {
    private Connection connection = ConnectionMySql.getConnection();

    public boolean checkEnrollment(User user) {
        String sql = "select count(*) from enrollment where idUser = " + user.getIdUser();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Map <String, Object> getMyEnrollment(User user) {
        Map <String, Object> map = new HashMap<>();
        String sql = "select subjectname,enrollmentDate from enrollment INNER JOIN subject on enrollment.idSubject = subject.idSubject where idUser = " + user.getIdUser();
        try{
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                String subjectName = resultSet.getString("subjectname");
                Date dateEnroll = resultSet.getDate("enrollmentDate");
                map.put(subjectName, dateEnroll);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}
