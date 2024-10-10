package org.example.view;

import org.example.model.User;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    public void menuStudentView(User user) {
        while (true) {
            System.out.println("--Menu--");
            System.out.println("1. Cập nhật thông tin");
            System.out.println("2. Sửa thông tin cá nhân");
            System.out.println("3. Xem thông tin cá nhân");
            System.out.println("4. Kiểm tra tình trạng học tập");
            System.out.println("5. Đăng kí học phần");
            System.out.println("6. Đổi mật khẩu");
            System.out.println("Đăng xuất");
            System.out.print("Lựa chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    return;
                case 4:
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("");
                    return;
                case 7:
                    System.out.println("");
                    return;
            }
        }
    }
    public void editSutdentView(User user){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Cập Nhập Thông Tin Của Bạn Vào Đây  ");
            System.out.println("1. Họ và tên");
            System.out.println("2. Ngày sinh");
            System.out.println("3. Giới tính");
            System.out.println("4. Quê quán");
            System.out.println("5. Email");
            System.out.println("6. Số CCCD");
            System.out.println("Lựa chọn");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên: ");
                    String newname = sc.nextLine();
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    return;
                case 4:
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("");
                    return;
                case 7:
                    System.out.println("");
                    return;
            }
        }
    }
}
