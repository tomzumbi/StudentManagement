package org.example.Controller;

import org.example.config.Validate;
import org.example.model.User;
import org.example.service.impl.StudentService;

import java.sql.Date;
import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();
    Scanner scanner = new Scanner(System.in);

    public boolean updateInformation(User user) {
        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh của bạn: ");
        String day = scanner.nextLine();
        System.out.print("Nhập tháng sinh của bạn: ");
        String month = scanner.nextLine();
        System.out.print("Nhập năm sinh của bạn: ");
        String year = scanner.nextLine();
        String date = year + "-" + month + "-" + day;
        Date birthday = Date.valueOf(date);
        System.out.println("Nhập địa chỉ của bạn: ");
        String address = scanner.nextLine();
        user.setName(name);
        user.setBirthday(birthday);
        user.setAddress(address);
        studentService.updateInformation(user);
        return true;
    }

    public void getInformation(User user) {
        System.out.printf("%-15s %-20s %-15s %-10s %-30s %-15s %n",
                "Mã Sinh Viên", "Tên", "Ngày Sinh", "Giới Tính", "Email", "Số Điện Thoại");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-10s %-30s %-15s %n", user.getIdUser(), user.getName(), user.getBirthday(), user.getGender(), user.getEmail(), user.getPhone());
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    public boolean editEmail(User user) {
        System.out.print("Nhập email mới của bạn: ");
        String email = scanner.nextLine();
        while (!Validate.validateEmail(email)){
            System.out.print("Email của bạn không đúng định dạng vui lòng nhập lại");
        }
        user.setEmail(email);
        studentService.editEmail(user);
        System.out.println("Sửa email thành công! ");
        return true;
    }
    public boolean editPhone(User user) {
        System.out.print("Nhập số điện thoại mới của bạn: ");
        String phone = scanner.nextLine();
        while (!Validate.validatePhoneNumber(phone)){
            System.out.print("Số điện thoại của bạn không đúng định dạng vui lòng nhập lại");
        }
        user.setPhone(phone);
        studentService.editPhone(user);
        System.out.println("Sửa số điện thoại thành công! ");
        return true;
    }

}
