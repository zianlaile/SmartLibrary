package com.smartlibrary.domain2;

import com.smartlibrary.domain.BaseObject;

/**
 * Created by tt on 2017/9/21.
 */
public class User extends BaseObject {
    private static final long serialVersionUID = -1775298611168938621L;
    int id;
    String name;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
