package org.example.view;

import org.example.controller.AdminController;
import org.example.model.User;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();
    public void menu(){
        System.out.println("-----Menu----");
        System.out.println("1. Xóa sinh viên");
        System.out.println("2. Sửa thông tin sinh viên.");
        System.out.println("3. Tìm Kiếm sinh viên.");
        System.out.println("4. Thêm, sửa xóa học phần. ");
        System.out.println("5. Phân tích kết quả học tập của sinh viên.");
        System.out.println("6. Hiện thị danh sách sinh viên.");
        System.out.println("0. Thoát");
        System.out.println("Lua chon cua ban: ");
        String choice = sc.nextLine();
        switch(choice) {
            case "1":
                //Xóa sinh viên
                adminController.deleteStudent();
                break;
            case "2":
                String choice1 = "";
                editMenuStudent(choice1);
                sc.nextLine();
                break;
            case "3":
                adminController.findStudent();
                break;
            case "4":
                String choice2 = "";
                editMenuSubject(choice2);
                sc.nextLine();
                break;
            case "5":
                break;
            case "6":
                adminController.DisplayStudent();
                break;
            case "0":
                System.out.println("Thoát");
                //Quay trang đăng nhập đăng ki
                break;
            default:
                System.out.println("Không có chức năng mà bạn đã chọn");
        }
    }

   // người dùng
   public void editMenuStudent(String choice){
        do {
            System.out.println("-----Menu----");
            System.out.println("1. Sửa ngày sinh.");
            System.out.println("2. Địa chỉ.");
            System.out.println("3. Trạng thái.");
            System.out.println("4. Sửa email.");
            System.out.println("5. Sửa số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    adminController.updateStudentDateOfBirth();
                    break;
                case "2":
                    adminController.updateStudentDateOfBirth();
                    break;
                case "3":
                    adminController.updateStatusStudent();
                    break;
                case "4":
                    adminController.updateEmail();
                    break;
                case "5":
                    adminController.updatePhoneNumber();
                case "0":
                    System.out.println("Thoát thành công");
                    break;
                default:
                    System.out.println("Lỗi ");
                    break;
            }
        }while (choice.equals("0"));
   }

   //Môn học
    public void editMenuSubject(String choice){
        do {
            System.out.println("-----Menu----");
            System.out.println("1. Sửa tên môn học.");
            System.out.println("2. Sửa  số tín chỉ.");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    adminController.updateNameSubject();
                    break;
                case "2":
                    adminController.updateCreditSubject();
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
