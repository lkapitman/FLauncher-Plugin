package com.github.lkapitman.utils;

import fr.xephi.authme.api.v3.AuthMeApi;

public class Auth {

    private AuthMeApi authMe = AuthMeApi.getInstance();

    public boolean isRegistered(String name) {
        return authMe.isRegistered(name);
    }

    public boolean checkPassword(String playerName, String password) {
        return authMe.checkPassword(playerName, password);
    }

    public boolean registerPlayer(String playerName, String password) {
        return authMe.registerPlayer(playerName, password);
    }

}
