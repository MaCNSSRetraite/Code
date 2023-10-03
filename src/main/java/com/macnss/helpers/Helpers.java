package com.macnss.helpers;

import java.security.SecureRandom;
public class Helpers {

    public static int generateCode() {
        SecureRandom random = new SecureRandom();
        int code = random.nextInt(900000) + 100000; // Génère un nombre aléatoire entre 100000 et 999999
        return code;
    }
}
