package com.wsh.domain;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class UserWrap {

    private int code;
    private String message;
    private User user;

    public UserWrap() {
    }

    @Override
    public String toString() {
        return "UserWrap{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserWrap(int code, String message, User user) {

        this.code = code;
        this.message = message;
        this.user = user;
    }

    public UserWrap(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
