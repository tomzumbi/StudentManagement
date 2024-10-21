package org.example.model;

public class Subject {
    private String idSubject;
    private String subjectName;
    private String idTeacher;

    public Subject(String idSubject, String subjectName, String idTeacher) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.idTeacher = idTeacher;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }
}
