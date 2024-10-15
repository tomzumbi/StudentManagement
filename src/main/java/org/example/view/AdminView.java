package org.example.view;

import org.example.controller.adminController.ControllerSubject;
import org.example.controller.adminController.ControllerUser;
import org.example.model.User;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    ControllerSubject controllerSubject = new ControllerSubject();
    ControllerUser controllerUser = new ControllerUser();
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
                controllerUser.deleteStudent();
                break;
            case "2":
                String choice1 = "";
                editMenuStudent(choice1);
                sc.nextLine();
                break;
            case "3":
                controllerUser.findStudent();
                break;
            case "4":
                String choice2 = "";
                editMenuSubject(choice2);
                sc.nextLine();
                break;
            case "5":
                break;
            case "6":
                controllerUser.DisplayStudent();
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
                    controllerUser.updateStudentDateOfBirth();
                    break;
                case "2":
                    controllerUser.updateStudentDateOfBirth();
                    break;
                case "3":
                    controllerUser.updateStatusStudent();
                    break;
                case "4":
                    controllerUser.updateEmail();
                    break;
                case "5":
                    controllerUser.updatePhoneNumber();
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
                    controllerSubject.updateNameSubject();
                    break;
                case "2":
                    controllerSubject.updateCreditSubject();
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
