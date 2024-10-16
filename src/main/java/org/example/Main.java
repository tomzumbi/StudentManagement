package org.example;

import org.example.Controller.EnrollmentController;
import org.example.Controller.SubjectController;
import org.example.Controller.UserController;
import org.example.DAO.ConnectionMySql;
import org.example.DAO.EnrollmentDAO.EnrollmentDAO;
import org.example.DAO.StudentDAO.StudentDAO;
import org.example.DAO.SubjectDAO.SubjectDAO;
import org.example.DAO.UserDAO.LoginDAO;
import org.example.DAO.UserDAO.RegisterDAO;
import org.example.model.Enrollment;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.EnrollmentService;
import org.example.service.impl.UserService;
import org.example.view.UserView;

import java.security.SecureRandom;
import java.sql.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

        UserView userView = new UserView();
        userView.menuUserView();




    }
}
