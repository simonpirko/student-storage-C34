package by.studentstorage.validator;

public class UserValidator {
    public static boolean validLogin(String login){
        return login.length() > 3;
    }

    public static boolean validPassword(String pass){
        return pass.length() >= 4;
    }

    public static boolean validName(String name){
        return name.length() > 0;
    }

    public static boolean validSurname(String surName){
        return surName.length() > 0;
    }

    public static boolean validEmail(String email){
        return email.length() > 6;
    }

    public static  boolean validRole(String role){
        return role.equals("STUDENT") || role.equals("ADMIN")|| role.equals("HEADMAN")|| role.equals("TEACHER");
    }
}
