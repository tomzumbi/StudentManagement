package org.example.view;

import org.example.Controller.EnrollmentController;
import org.example.Controller.StudentController;
import org.example.Controller.SubjectController;
import org.example.model.User;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    StudentController controller = new StudentController();
    SubjectController subjectController = new SubjectController();
    EnrollmentController enrollmentController = new EnrollmentController();
    public void menuStudentView(User user) {
        System.out.println("Xin chào sinh viên: " + user.getName());
        while (true) {
            System.out.println("");
            System.out.println("1. Hiển thị thông tin sinh viên");
            System.out.println("2. Cập nhật thông tin");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Kiểm tra các học phần");
            System.out.println("5. Kiểm tra các học phần đã đăng kí");
            System.out.println("6. Đăng kí học phần");
            System.out.println("7. Hủy bỏ học phần đã đăng kí");
            System.out.println("8. Kiểm tra tình trạng học tập");
            System.out.println("9. Đăng xuất");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            System.out.println("");
            switch (choice) {
                case "1":
                    controller.getInformation(user);
                    break;
                case "2":
                    controller.updateInformation(user);
                    break;
                case "3":
                    editStudentView(user);
                    break;
                case "4":
                    subjectController.getAllSubjects();
                    break;
                case "5":
                    if (enrollmentController.checkEnrollment(user)) {
                        enrollmentController.getEnrollment(user);

                    } else {
                        System.out.println("Bạn chưa đăng kí học phần nào vui lòng đăng kí trước khi kiểm tra");
                    }

                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":

                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ!");
                    break;
            }
        }
    }


    public void editStudentView(User user) {
        System.out.println("");
        System.out.println("Bạn muốn sửa: ");
        while (true) {
            System.out.println("1. Số điện thoại");
            System.out.println("2. Email");
            System.out.println("3. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    controller.editPhone(user);
                    break;
                case "2":
                    controller.editEmail(user);
                    break;
                case "3":
                    menuStudentView(user);
                    break;
                default:
                    break;
            }
        }
    }

}
