package org.example.service.impl;

import org.example.DAO.UserDAO.RegisterDAO;
import org.example.model.User;
import org.example.service.IUSerService;

public class UserService implements IUSerService {

    RegisterDAO registerDAO = new RegisterDAO();
    @Override
    public boolean register(User user) {
        return registerDAO.register(user);
    }
}
