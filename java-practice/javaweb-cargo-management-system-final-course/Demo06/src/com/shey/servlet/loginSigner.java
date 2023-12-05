package com.shey.servlet;

import com.shey.entity.User;

public class loginSigner {
    private User userSigner;

    public loginSigner() {
    }

    public loginSigner(User userSigner) {
        this.userSigner = userSigner;
    }

    public User getUserSigner() {
        return userSigner;
    }

    public void setUserSigner(User userSigner) {
        this.userSigner = userSigner;
    }
}
