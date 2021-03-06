package com.wsh.user.domain;
/**
 *  entity class from database bookstore with table tb_user.
 *  Compiles all fields of a table into an entity class private property.
 *  And all attribute get/set methods are given.
 *  Create a constructor that has arguments and no arguments.
 *  Finally, the toString method is used to output the entity class attribute with String type.
 */
public class User {
    private String uid;
    private String username;
    private String password;
    private String email;
    private String code;
    private int state;

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public User() {
    }

    public User(String uid, String username, String password, String email, String code, int state) {

        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.code = code;
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
