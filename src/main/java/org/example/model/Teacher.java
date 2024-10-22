package org.example.model;

import java.sql.Date;

public class Teacher extends User {
    private String idTeacher;
    private String nameTeacher;
    private String genderTeacher;
    private String phoneTeacher;
    private String emailTeacher;
    private Date dateTeacher;
    private String idClass;


    public Teacher(String idUser, String username, String password, int role) {
        super(idUser, username, password, role);
    }

    public Teacher(String idUser, String username, String password, int role, String idTeacher, String nameTeacher, String genderTeacher, String phoneTeacher, String emailTeacher, Date dateTeacher, String idClass) {
        super(idUser, username, password, role);
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.genderTeacher = genderTeacher;
        this.phoneTeacher = phoneTeacher;
        this.emailTeacher = emailTeacher;
        this.dateTeacher = dateTeacher;
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

    public String getGenderTeacher() {
        return genderTeacher;
    }

    public void setGenderTeacher(String genderTeacher) {
        this.genderTeacher = genderTeacher;
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

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }
}
