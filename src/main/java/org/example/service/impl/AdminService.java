package org.example.service.impl;

import org.example.DAO.AdminDAO.AdminDAO;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.IAdminService;

import java.util.List;
import java.util.Map;

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
    public boolean updateEmailStudent(User user) {
        return adminDao.updateEmailStudent(user);
    }

    @Override
    public boolean updateStudentPhone(User user) {
        return adminDao.updateStudentPhone(user);
    }

    @Override
    public boolean updateStatus(User user) {
        return adminDao.uppdateStatus(user);
    }

    @Override
    public List<User> studentList() {
        return adminDao.studentList();
    }

    @Override
    public void findStudent(String idUser) {
        adminDao.findUserByID(idUser);

    }

    @Override
    public boolean updateCreditSubject(Subject subject) {
        return adminDao.updateCreditSubject(subject);
    }

    @Override
    public boolean updateNameSubject(Subject subject) {
        return adminDao.updateNameSubject(subject);
    }

    @Override
    public Subject findSubjectByID(String subjectId) {
        return adminDao.findSubjectByID(subjectId);
    }

    @Override
    public Map<String, List<Map<String, Object>>> getStudentsWithClassification() {
        return adminDao.getStudentsWithClassification();
    }

}
