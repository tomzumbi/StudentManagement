package org.example.service.impl;

import org.example.DAO.AdminDAO.AdminDAO;
import org.example.model.User;
import org.example.service.IAdminService;

public class AdminService implements IAdminService {
    AdminDAO adminDao = new AdminDAO();
    @Override
    public void deleteStudent(String idUser) {
         adminDao.deleteStudent(idUser);
    }

    @Override
    public User findUserByID(String idUser) {
        return adminDao.findUserByID(idUser);
    }

    @Override
    public boolean updateStudentDateOfBirth(User user) {
        return adminDao.updateStudentDateOfBirth(user);
    }

    @Override
    public boolean updateEmail(User user) {
        return false;
    }

    @Override
    public boolean updateEmailStudent(User user) {
        return adminDao.updateEmailStudent(user);
    }
}
