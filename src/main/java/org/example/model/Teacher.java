package org.example.model;

import java.sql.Date;

public class Teacher extends User {
    private String idTeacher;
    private String nameTeacher;
    private String phoneTeacher;
    private String emailTeacher;
    private Date dateTeacher;
    private int role;
    private String idClass;

    public Teacher(String username, String password, int role) {
        super(username, password, role);
    }

    public Teacher(String username, String password, int role, String idTeacher, String nameTeacher, String phoneTeacher, String emailTeacher, Date dateTeacher, int role1, String idClass) {
        super(username, password, role);
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.phoneTeacher = phoneTeacher;
        this.emailTeacher = emailTeacher;
        this.dateTeacher = dateTeacher;
        this.role = role1;
        this.idClass = idClass;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getPhoneTeacher() {
        return phoneTeacher;
    }

    public void setPhoneTeacher(String phoneTeacher) {
        this.phoneTeacher = phoneTeacher;
    }

    public String getEmailTeacher() {
        return emailTeacher;
    }

    public void setEmailTeacher(String emailTeacher) {
        this.emailTeacher = emailTeacher;
    }

    public Date getDateTeacher() {
        return dateTeacher;
    }

    public void setDateTeacher(Date dateTeacher) {
        this.dateTeacher = dateTeacher;
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
