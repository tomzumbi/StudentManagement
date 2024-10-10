package org.example.Controller;

import org.example.config.RandomString;
import org.example.config.Validate;
import org.example.model.User;
import org.example.service.impl.UserService;

import java.util.Scanner;

public class UserController {
    UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in);
    String idRandom = RandomString.generateRandomString();

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
                    System.out.println("Mật khẩu nhập lại không khớp vui lòng nhập lại: ");
                    confirmPassword = scanner.nextLine();
                }
                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();
                while (!Validate.validatePhoneNumber(phone)) {
                    System.out.println("Số điện thoại không đúng định dạng vui lòng thử lại");
                    phone = scanner.nextLine();
                }
                while (userService.checkPhoneNumber(phone)) {
                    System.out.println("Số điện thoại đã được sử dụng vui lòng nhập số khác");
                    phone = scanner.nextLine();
                }

                System.out.print("Nhập email: ");
                String email = scanner.nextLine();
                while (!Validate.validateEmail(email)) {
                    System.out.println("Email không đúng định dạng vui lòng nhập lại: ");
                    email = scanner.nextLine();
                }
                while (userService.checkEmail(email)) {
                    System.out.println("Email đã được sử dụng vui lòng nhập email khác: ");
                    email = scanner.nextLine();
                }

                String choice = scanner.nextLine();
                while (!choice.equals("1") && !choice.equals("2")) {
                    System.out.print("Lựa chọn không hợp lệ vui lòng chọn lại: ");
                    choice = scanner.nextLine();
                }

                if (choice.equals("1")) {
                    User user = new User(idRandom, username, password, email, phone, "nam", 1, true);
                    userService.register(user);
                    System.out.println("Đăng kí thành công!");
                } else if (choice.equals("2")) {
                    User user = new User(idRandom, username, password, email, phone, "nữ", 1, true);
                    userService.register(user);
                    System.out.println("Đăng kí thành công!");
                }


                return true;


            } else {
                System.out.println("Mật khẩu phải ít nhất 8 kí tự. Bao gồm chữ hoa, chữ thường, sô và kí tự đặc biệt!");
            }

        } else {
            System.out.println("Tài khoản đã tồn tại!");
        }


        return false;
    }

    public User login(){
        User user = new User();
        System.out.println("Tên đăng nhập: ");
        String username = scanner.nextLine();
        user = userService.findByUserName(username);
        if (user == null) {
            System.out.println("Tài khoản không tồn tại! Vui lòng đăng kí trước khi sử dụng");
            return null;
        } else {
            String password = scanner.nextLine();
            while (!password.equals(user.getPassword())) {
                System.out.println("Mật khẩu không chính xác vui lòng nhập lại: ");
                password = scanner.nextLine();
            }

            if (user.isRole()){
                System.out.println("xin chào sinh viên: " + user.getUsername());
            } else {
                System.out.println("Chào quản lí: " + user.getUsername());
            }

            return user;
        }
    }


}
