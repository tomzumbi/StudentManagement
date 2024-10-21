package org.example.model;

import java.sql.Date;

public class Student extends User {
    private String idStudent;
    private String nameStudent;
    private String emailStudent;
    private String phoneStudent;
    private Date dateStudent;
    private int statusStudent;
    private boolean genderStudent;
    private int role;
    private String idClass;


    public Student(String username, String password, int role) {
        super(username, password, role);
    }

    public Student(String username, String password, int role, String idStudent, String nameStudent, String emailStudent, String phoneStudent, Date dateStudent, int statusStudent, boolean genderStudent, int role1, String idClass) {
        super(username, password, role);
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.emailStudent = emailStudent;
        this.phoneStudent = phoneStudent;
        this.dateStudent = dateStudent;
        this.statusStudent = statusStudent;
        this.genderStudent = genderStudent;
        this.role = role1;
        this.idClass = idClass;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public Date getDateStudent() {
        return dateStudent;
    }

    public void setDateStudent(Date dateStudent) {
        this.dateStudent = dateStudent;
    }

    public int getStatusStudent() {
        return statusStudent;
    }

    public void setStatusStudent(int statusStudent) {
        this.statusStudent = statusStudent;
    }

    public boolean isGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(boolean genderStudent) {
        this.genderStudent = genderStudent;
    }

    @Override
    public int getRole() {
        return role;
    }

    @Override
    public void setRole(int role) {
        this.role = role;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }
}
