package org.example.service;

import org.example.model.User;

import java.util.Map;

public interface IEnrollmentService {
    Map<String, Object> getMyEnrollment(User user);
    boolean checkEnrollment(User user);
}
