package org.example.Controller;

import org.example.exception.AdminException;
import org.example.model.User;
import org.example.service.impl.AdminService;

import java.sql.*;
import java.util.Scanner;

public class AdminController {
    AdminService adminService = new AdminService();
    Scanner scanner = new Scanner(System.in);
    public boolean deleteStudent() {
        System.out.println("nhap id: ");
        String idUser = scanner.nextLine();
        User user = adminService.findUserByID(idUser);
        if (user != null) {
            adminService.deleteStudent(user.getIdUser());
            System.out.println("Xoa thanh cong");
            return true;
        } else {
            System.out.println("Chưa xóa");
            return false;
        }
    }
    public boolean updateStudentDateOfBirth(){
        System.out.println("nhap id: ");
        String idUser = scanner.nextLine();
        User user = new User();
        AdminException adminException = new AdminException();
        user = adminService.findUserByID(idUser);
        String day = "";
        String month = "";
        String year = "";
        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try{
                    System.out.print("Nhập ngày sinh: ");
                    day = scanner.nextLine();
                    System.out.print("Nhập tháng: ");
                    month = scanner.nextLine();
                    System.out.print("Nhập năm: ");
                    year = scanner.nextLine();

                    int intDay = Integer.parseInt(day);
                    int intMonth = Integer.parseInt(month);
                    int intYear = Integer.parseInt(year);

                    if (adminException.isValiDate(intDay, intMonth, intYear)) {
                        validInput = true;
                    }else {
                        System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại: ");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Giá trị nhập không phải là số vui lòng nhập lại.");
                }catch (Exception e){
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String birthday = year + "-" + month + "-" + day;
            Date date = Date.valueOf(birthday);
            user.setBirthday(date);
            adminService.updateStudentDateOfBirth(user);
            System.out.println("Sua thanh cong");

        }else {
            System.out.println("Không tìm thấy sinh viên có mã " + idUser);
        }
        return false;
    }
}