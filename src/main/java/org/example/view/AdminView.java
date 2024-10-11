package org.example.view;

import org.example.model.User;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    public void menu(){
        System.out.println("-----Menu----");
        System.out.println("1. Xóa sinh viên");
        System.out.println("2. Sửa thông tin sinh viên.");
        System.out.println("3. Tìm Kiếm sinh viên.");
        System.out.println("4. Thêm, sửa xóa học phần. ");
        System.out.println("5. Phân tích kết quả học tập của sinh viên.");
        System.out.println("0. Thoát");
        System.out.println("Lua chon cua ban: ");
        String choice = sc.nextLine();
        switch(choice) {
            case "1":
                System.out.println("Xóa sinh viên.");
                break;
            case "2":
                System.out.println("Sửa thông tin sinh viên.");
                String choice1 = "";
                editMenu(choice1);
                sc.nextLine();
                break;
            case "0":
                System.out.println("Thoát");
                //Quay trang đăng nhập đăng ki
                break;
            default:
                System.out.println("Không có chức năng mà bạn đã chọn");
        }
    }

    public void menuStudent(User user) {

    }

   public void editMenu(String choice){
        do {
            System.out.println("-----Menu----");
            System.out.println("1. Sửa tên.");
            System.out.println("2. Sửa ngày sinh.");
            System.out.println("3. Địa chỉ.");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    System.out.println("sửa tên thành công");
                    break;
                case "2":
                    System.out.println("Sửa ngày sinh thành công.");
                    break;
                case "3":
                    System.out.println("Sửa địa chỉ thành công");
                    break;
                case "0":
                    System.out.println("Thoát thành công");
                    break;
                default:
                    System.out.println("Lỗi ");
                    break;
            }
        }while (choice.equals("0"));
   }
}
