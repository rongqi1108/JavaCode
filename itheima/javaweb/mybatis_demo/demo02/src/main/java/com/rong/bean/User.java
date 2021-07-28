package com.rong.bean;

import java.util.Date;

public class User {
    private String uid;
    private String ucode;
    private String loginname;
    private String PASSWORD;
    private String username;
    private String gender;
    private Date birthday;
    private Date dutydate;

    public User() {
    }

    public User(String uid, String ucode, String loginname, String PASSWORD, String username, String gender, Date birthday, Date dutydate) {
        this.uid = uid;
        this.ucode = ucode;
        this.loginname = loginname;
        this.PASSWORD = PASSWORD;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.dutydate = dutydate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDutydate() {
        return dutydate;
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", ucode='" + ucode + '\'' +
                ", loginname='" + loginname + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", dutydate=" + dutydate +
                '}';
    }
}
