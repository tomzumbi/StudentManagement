package org.example.view;

import org.example.model.User;

import java.util.Scanner;

public class UserView {
    public AdminView adminView;
    public void menuStudent(User user) {

        System.out.println("Hiển thị");
        System.out.println(user.getUsername());



    }


    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        // đăng nhập được với STUDENT

        User user = new User(username, password);
        // ROLE LÀ 1
        menuStudent(user);


    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.login();
    }



}
