package org.example.service;

import org.example.model.User;

public interface IStudentService {
    boolean updateInformation(User user);
    boolean editEmail(User user);
    boolean editPhone(User user);
}
