package org.arctic.jackson.bean_test;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/25 0025.
 */
public class User {
    private String username;
    private String password;
    private Date datetime;

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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
