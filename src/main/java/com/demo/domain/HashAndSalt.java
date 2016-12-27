package com.demo.domain;


public class HashAndSalt {

    private String hash;
    private String salt;

    public HashAndSalt(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }
}
