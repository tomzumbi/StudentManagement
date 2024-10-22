package org.example.service.impl;

import org.example.DAO.UserDAO.LoginDAO;
import org.example.DAO.UserDAO.RegisterDAO;
import org.example.model.User;
import org.example.service.IUSerService;

public class UserService implements IUSerService {
    LoginDAO loginDAO = new LoginDAO();
    RegisterDAO registerDAO = new RegisterDAO();
    @Override
    public boolean register(User user) {
        return registerDAO.register(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return registerDAO.checkUsername(username);
    }

    @Override
    public User findByUserName(String userName) {
        return loginDAO.findByUserName(userName);
    }

    @Override
    public boolean forgetPassword(User user) {
        return loginDAO.forgetPassword(user);
    }
}
