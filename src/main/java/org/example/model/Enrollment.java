package org.example.model;

import java.sql.Date;

public class Enrollment {
    private int idUser;
    private int idSubject;
    private Date enrollmentDate;
    private float avgScore;

    public Enrollment(int idUser, int idSubject, Date enrollmentDate, float avgScore) {
        this.idUser = idUser;
        this.idSubject = idSubject;
        this.enrollmentDate = enrollmentDate;
        this.avgScore = avgScore;
    }

    public Enrollment() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
}
