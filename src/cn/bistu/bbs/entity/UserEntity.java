package cn.bistu.bbs.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户实体类
 */
public class UserEntity {

    //	private String user_id;
    private int userid;
    private String username;
    private String password;
    private String email;
    private String is_admin;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }
}
