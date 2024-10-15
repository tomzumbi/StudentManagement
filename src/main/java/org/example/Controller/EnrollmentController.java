package org.example.Controller;

import org.example.model.User;
import org.example.service.impl.EnrollmentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EnrollmentController {
    EnrollmentService enrollmentService = new EnrollmentService();
    public void getEnrollment(User user) {
        Map<String, Object> enrollments = new HashMap<>();
        enrollments = enrollmentService.getMyEnrollment(user);
        System.out.format("%-20s %-20s%n", "Tên học phần", "Ngày đăng ký");
        System.out.println("-------------------- --------------------");
        for (Map.Entry<String, Object> entry : enrollments.entrySet()) {
            String courseName = entry.getKey(); // Tên học phần
            String registrationDate = entry.getValue().toString(); // Ngày đăng ký (giả sử là String)
            System.out.format("%-20s %-20s%n", courseName, registrationDate);
        }
    }
    public boolean checkEnrollment(User user){
        if (enrollmentService.checkEnrollment(user)) {
            return true;
        } else {
            return false;
        }
    }
}
