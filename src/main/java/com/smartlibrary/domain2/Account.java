package com.smartlibrary.domain2;

/**
 * Created by zian on 2017/9/24.
 */
public class Account {
    String account;
    String password;
    int type;
    int school_id;
    int permision_allocate;  // 权限分配（用于前段展示// ）

    public void setType(int type) { this.type = type; }

    public int getPermision_allocate() { return permision_allocate; }

    public void setPermision_allocate(int permision_allocate) { this.permision_allocate = permision_allocate; }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }
}
