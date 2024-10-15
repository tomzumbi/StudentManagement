package org.example.controller.adminController;
import org.example.config.AdminConfig;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.AdminService;
import java.util.*; // Thư viện cho các kiểu dữ liệu như List, Map

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ControllerSubject {
    AdminService adminService = new AdminService();
    AdminConfig adminConfig = new AdminConfig();
    Scanner scanner = new Scanner(System.in);
    //Sửa tín chỉ
    public void updateCreditSubject() {
        Subject subject;
        String idSubject;
        AdminConfig adminConfig = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idSubject = scanner.nextLine();
            subject = adminService.findSubjectByID(idSubject);

            if (subject != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy môn học với ID: " + idSubject + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (subject != null) {
                System.out.print("Nhập số tín chỉ mới: ");
                if (scanner.hasNextInt()) {
                    int credit = scanner.nextInt();
                    subject.setCredit(credit);
                    boolean isUpdated = adminService.updateCreditSubject(subject);
                    if (isUpdated) {
                        System.out.println("Cập nhật tín chỉ thành công.");
                    } else {
                        System.out.println("Cập nhật tín chỉ không thành công.");
                    }
                    break;
                } else {
                    System.out.println("Vui lòng nhập một số nguyên hợp lệ (không được nhập ký tự chữ).");
                    scanner.next();
                }
            }
        }
    }
    //Sửa tên môn học
    public void updateNameSubject() {
        Subject subject;
        String idSubject;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idSubject = scanner.nextLine();
            subject = adminService.findSubjectByID(idSubject);
            if (subject != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy môn học với ID: " + idSubject + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (subject != null) {
                System.out.print("Nhập tên môn học mới: ");
                String name = scanner.nextLine();
                if(adminException.containsInvalidCharacters(name)) {
                    System.out.println("Vui lòng chỉ nhập ký tự chữ (không chứa số hoặc ký tự đặc biệt).");
                }else {
                    subject.setSubjectName(name);
                    boolean isUpdated = adminService.updateNameSubject(subject);
                    if (isUpdated) {
                        System.out.println("Cập nhật tên môn học thành công.");

                    }else {
                        System.out.println("Cập nhật tên môn học không thành công.");
                    }
                    break;
                }
            }
        }
    }
    // Phương thức hiển thị danh sách học sinh theo phân loại
    public void displayStudentsByClassification() {
        Map<String, List<Map<String, Object>>> studentsByClassification = adminService.getStudentsWithClassification();
        if (studentsByClassification != null) {
            // In tiêu đề bảng
            System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Tên", "Điểm", "Đánh giá");

            for (String classification : studentsByClassification.keySet()) {
                for (Map<String, Object> student : studentsByClassification.get(classification)) {
                    Integer avgScore = (Integer) student.get("avgScore"); // Giả định điểm số là Integer
                    String evaluation = adminConfig.evaluateScore(avgScore);

                    // In từng dòng thông tin của học sinh
                    System.out.printf("%-10s %-20s %-10s %-15s%n",
                            student.get("idUser"),
                            student.get("username"),
                            avgScore,
                            evaluation);
                }
            }
        }
    }
}
