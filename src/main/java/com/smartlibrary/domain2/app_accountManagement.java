package com.smartlibrary.domain2;
/**
 *  Creat by XiaoZhang
 */
public class app_accountManagement {
    String account;
    String password;
    String  school_id;
    int  permission_allocate;
    int  type;  // 超级管理院定义一般普通用户
    int pageSize;//一页多少数据
    int offset; //从第几条数据开始查'


    public String getAccount() {
        return account;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getPermission_allocate() {
        return permission_allocate;
    }

    public void setPermission_allocate(int permission_allocate) {
        this.permission_allocate = permission_allocate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
