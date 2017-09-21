package com.smartlibrary.dao2;

import com.smartlibrary.domain2.User;

import java.util.List;

/**
 * Created by tt on 2017/9/21.
 */
public interface UserDao {
    List<User> getUser(User user);
}
