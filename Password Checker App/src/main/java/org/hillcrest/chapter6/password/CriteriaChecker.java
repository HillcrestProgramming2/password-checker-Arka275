package org.hillcrest.chapter6.password;

public class CriteriaChecker {

    public static int evaluateCriteria(String password){
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwuxyz";
        String upperCaseLetters= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "1234567890";
        int score = 0;
        boolean hasUpper = false;
        if (password.length() >= 8) {
            score++;
            for(int i = 0;i < password.length(); i++){
                if (upperCaseLetters.contains(password.substring(i, i+1))){
                    hasUpper = true;
                }else{

                }
            }
        }
        else {

        }


    }


}
