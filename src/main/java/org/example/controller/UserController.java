package org.example.controller;

import org.example.config.RandomString;
import org.example.config.Validate;
import org.example.model.User;
import org.example.service.impl.UserService;

import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);
    String idRandom = RandomString.generateRandomString();
    UserService userService = new UserService();

    public boolean register() {
        System.out.print("Nhập tài khoản: ");
        String username = scanner.nextLine();
        if (!userService.checkUsername(username)) {
            System.out.print("Nhập mật khẩu: ");
            String password = scanner.nextLine();
            if (Validate.validatePassword(password)) {
                System.out.print("Nhập lại mật: ");
                String confirmPassword = scanner.nextLine();
                while (!confirmPassword.equals(password)) {
                    System.out.print("Mật khẩu nhập lại không khớp vui lòng nhập lại: ");
                    confirmPassword = scanner.nextLine();
                }
                User user = new User(idRandom, username, password, 2);
                userService.register(user);
                System.out.println("Đăng kí thành công! ");
                return true;
            } else {
                System.out.println("Mật khẩu phải ít nhất 8 kí tự. Bao gồm chữ hoa, chữ thường, sô và kí tự đặc biệt!");
            }

        } else {
            System.out.println("Tài khoản đã tồn tại!");
        }


        return false;
    }

    public User login() {
        User user;
        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();
        user = userService.findByUserName(username);
        if (user == null) {
            System.out.println("Tài khoản không tồn tại! Vui lòng đăng kí trước khi sử dụng");
            return null;
        } else {
            System.out.print("Mật khẩu: ");
            String password = scanner.nextLine();
            while (!password.equals(user.getPassword())) {
                System.out.println("Mật khẩu không chính xác vui lòng nhập lại: ");
                password = scanner.nextLine();
            }

            return user;


        }
    }

    public boolean forgotPassword() {
        User user;
        System.out.print("Nhập tên tài khoản của bạn: ");
        String username = scanner.nextLine();
        user = userService.findByUserName(username);
        if (user == null) {
            System.out.println("Tài khoản không tồn tại vui lòng kiểm tra lại!");
        } else {
            System.out.print("Nhập mật khẩu mới: ");
            String password = scanner.nextLine();
            while (!Validate.validatePassword(password)) {
                System.out.print("Mật khẩu phải bao gồm chữ hoa, chữ thường, số và kí tự đặc biệt");
                password = scanner.nextLine();
            }
            user.setPassword(password);
            userService.forgetPassword(user);
            System.out.println("Ban đã thay đổi mật khẩu thành công!");
            return true;
        }

        return false;
    }

}
