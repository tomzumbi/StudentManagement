package org.example;

import org.example.DAO.Conection.ConnectionMySql;
import org.example.controller.UserController;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = userController.login();

    }
}