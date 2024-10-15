package org.example;

import org.example.controller.adminController.ControllerSubject;
import org.example.controller.adminController.ControllerUser;
import org.example.view.AdminView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        AdminView adminView = new AdminView();
        ControllerSubject controllerSubject = new ControllerSubject();
        controllerSubject.displayStudentsByClassification();
    }
}