package org.example.service.impl;

import org.example.DAO.EnrollmentDAO.EnrollmentDAO;
import org.example.model.User;
import org.example.service.IEnrollmentService;

import java.util.Map;

public class EnrollmentService implements IEnrollmentService {
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    @Override
    public Map<String, Object> getMyEnrollment(User user) {
        return enrollmentDAO.getMyEnrollment(user);
    }

    @Override
    public boolean checkEnrollment(User user) {
        return enrollmentDAO.checkEnrollment(user);
    }
}
