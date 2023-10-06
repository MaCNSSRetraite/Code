package com.macnss.helpers;

import java.util.Random;

import static java.lang.String.format;


import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class helpers {
    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 100;
        }
    }
    public static int generateCode(){
        Random rand = new Random();

        int code = rand.nextInt(999999);

        String codeString = format("%06d", code);

        return Integer.parseInt(codeString);
    }
    public static String generateMatrecule(String nom, String prenom, String email,int Taille){
        String Matrecule = null;

        String nomReturn = nom.substring(0, Taille).toUpperCase();
        String prenomReturn = prenom.substring(0, Taille).toUpperCase();
        String emailReturn = email.substring(0, Taille).toUpperCase();

        Matrecule = nomReturn + prenomReturn + emailReturn;

        return Matrecule;
    };




}
