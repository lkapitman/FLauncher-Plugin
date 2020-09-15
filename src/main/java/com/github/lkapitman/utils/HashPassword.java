package com.github.lkapitman.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashPassword {

    public static String getSHA512(String password) {
        return Hashing.sha512().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
