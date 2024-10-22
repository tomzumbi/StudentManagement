package org.example.model;

public class User {
    private String idUser;
    private String username;
    private String password;
    private int role;

    public User(String idUser, String username, String password, int role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
