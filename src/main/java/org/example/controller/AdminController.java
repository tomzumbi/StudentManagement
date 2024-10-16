package org.example.controller;

import org.example.config.AdminConfig;
import org.example.model.Subject;
import org.example.model.User;
import org.example.service.impl.AdminService;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminController {
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
    //Sinh viên
    public boolean deleteStudent() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        if (user != null) {
            adminService.deleteStudent(user.getIdUser());
            System.out.println("Xoa thanh cong");
            return true;
        } else {
            System.out.println("Chưa xóa");
            return false;
        }
    }
    //Update ngày sinh
    public boolean updateStudentDateOfBirth(){
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
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
            System.out.println("Sửa thành công");

        }else {
            System.out.println("Không tìm thấy sinh viên có mã " + idUser);
        }
        return false;
    }
    //Hiên thị thông tin sinh viên
    public  void DisplayStudent () {
        List<User> users = adminService.studentList();
        if (users != null && !users.isEmpty())  {
            System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");
            System.out.print("|    ID      |       Username      |       Password      |        Name         |             Email               |      Phone      |   Gender   |      Birthday       |                         Address                         | Status | Role  |\n");
            for (User user : users) {
                System.out.print(user.toString());
            }
            System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");

        }else {
            System.out.println("Không có sinh viên nào.");
        }
    }
    //tìm kiêm sinh viên
    public void findStudent() {
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();
            user = adminService.findUserByID(idUser);
            if (user != null) {
                System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");
                System.out.print("|    ID      |       Username      |       Password      |        Name         |             Email               |      Phone      |   Gender   |      Birthday       |                         Address                         | Status | Role  |\n");
                System.out.print(user.toString());
                System.out.print("+------------+---------------------+---------------------+---------------------+---------------------------------+-----------------+------------+---------------------+---------------------------------------------------------+--------+-------+\n");
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
    }
    //Sửa email sinh viên
    public void updateEmail(){
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }

        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Nhập Email: ");
                    String email = scanner.nextLine();
                    if (!adminException.isValidEmail(email)) {
                        throw  new IllegalArgumentException("Email không hợp lệ. Vui lòng nhập dúng định dạng.");
                    }
                    user.setEmail(email);
                    adminService.updateEmailStudent(user);
                    System.out.println("Sửa thành công.");
                    validInput = true;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }else {
            System.out.println("Không tìm tháy người dùng");
        }
    }
    //Sửa số điện thoại
    public void updatePhoneNumber(){
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser); // Giả định phương thức này tìm người dùng theo ID

            if (user != null) {
                break; // Thoát vòng lặp nếu tìm thấy người dùng
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        if (user != null) {
            boolean validInput = false;
            while (!validInput) {
                try{
                    System.out.print("Nhập số diện thoại mới: ");
                    String phoneNumber = scanner.nextLine();
                    if (!adminException.isValidPhoneNumber(phoneNumber)) {
                        throw new IllegalArgumentException("Số điện thoại không hợp lệ. Vui lòng nhập lai số điện thoại đúng định dạng (VD: 09xxxxxxxx).");

                    }
                    user.setPhone(phoneNumber);
                    adminService.updateStudentPhone(user);
                    System.out.println("Cập nhật số điện thoại thành công.");
                    validInput = true;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    //Sửa trạng thái
    public void updateStatusStudent(){
        User user;
        String idUser;
        AdminConfig adminException = new AdminConfig();
        while (true) {
            System.out.print("Nhập ID: ");
            idUser = scanner.nextLine();

            user = adminService.findUserByID(idUser);

            if (user != null) {
                break;
            } else {
                System.out.println("ID không hợp lệ. Không tìm thấy người dùng với ID: " + idUser + ". Vui lòng nhập lại.");
            }
        }
        while (true) {
            if (user != null) {
                try {
                    System.out.println("Nhập trạng thái mới của sinh viên: ");
                    System.out.println("1. Đang học");
                    System.out.println("2. Nghỉ học");
                    System.out.println("3. Đình chỉ");
                    System.out.println("4. Bảo lưu");
                    System.out.print("Nhập lựa chọn (0-4): ");
                    int choice = scanner.nextInt();

                    if (choice < 1 || choice > 4) {
                        throw new IllegalArgumentException("Trạng thái không hợp lệ. Vui lòng nhập lại.");
                    }
                    user.setStatus(choice);
                    boolean isUpdated = adminService.updateStatus(user);
                    if (isUpdated) {
                        System.out.println("Cập nhật trạng thái thành công.");
                    } else {
                        System.out.println("Cập nhật trạng thái không thành công");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
                break;
            }
        }
    }


}