package org.example.model;

public class Enrollment {
    private String idStudent;
    private String idSubject;
    private float avgScore;

    public Enrollment(String idStudent, String idSubject, float avgScore) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.avgScore = avgScore;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
}
