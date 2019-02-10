package com.rowsun.myapplication.model;

public class User {
    private int id;
    private String fullname, userName, password;

    public User(String fullname, String userName, String password) {

        this.fullname = fullname;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String fullname, String userName, String password) {
        this.id = id;
        this.fullname = fullname;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
