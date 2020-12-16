package com.elon.studydemo.constant;

import com.elon.studydemo.entity.User;

public class Constant {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void setUser(User user) {
        Constant.userThreadLocal.set(user);
    }
}
