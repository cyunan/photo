package com.example.photo.bean.init;

import com.example.photo.bean.User;
import com.example.photo.bean.User_Info;

public class UserBean {
    private User user;
    private User_Info user_info;

    public UserBean(User user, User_Info user_info) {
        this.user = user;
        this.user_info = user_info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User_Info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_Info user_info) {
        this.user_info = user_info;
    }
}
