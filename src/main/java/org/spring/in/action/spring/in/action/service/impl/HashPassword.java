package org.spring.in.action.spring.in.action.service.impl;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {

    public static void main(String[] args) {
        String plaintextPassword = "test";

        String hashedPassword= BCrypt.hashpw(plaintextPassword, BCrypt.gensalt());
        System.out.println("Hashed password: " + hashedPassword);
    }
}
