package org.example.view;

import org.example.Controller.UserController;
import org.example.model.User;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    public void menuUserView() {
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("3. Quên mật khẩu");
            System.out.println("4. Thoát chương trình");
            System.out.print("Mời bạn nhập lựa chọn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    userController.login();
                    break;
                case "2":
                    userController.register();
                    break;
                case "3":
                    break;
                default:
                    break;


            }


        }
    }




    public void menuStudentView(User user) {

    }

}
