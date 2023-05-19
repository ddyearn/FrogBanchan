package com.frog.frogbanchan.controller;


import com.frog.frogbanchan.domain.Users;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

    private Users user;

    public UserSession(Users user) {
        this.user = user;
    }

}
