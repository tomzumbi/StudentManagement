package org.example.service;

import org.example.model.User;

public interface IAdminService {
    void deleteStudent(String idUser);
    User findUserByID(String idUser);
    boolean updateStudentDateOfBirth(User user);

    boolean updateEmail(User user);

    boolean updateEmailStudent(User user);
}
