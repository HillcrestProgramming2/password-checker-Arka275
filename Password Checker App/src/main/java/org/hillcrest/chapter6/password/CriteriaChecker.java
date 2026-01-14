package org.hillcrest.chapter6.password;
/**
 * Utility class that evaluates a password against strength criteria.
 */
public class CriteriaChecker {
/**
 * Evaluates how many password criteria are met.
 *
 * @param password the password to evaluate
 * @return score from (0-5) based on criteria met
 */
    public static int evaluateCriteria(String password) {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwuxyz";
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "1234567890";
        String special = "!@#$%^&*()-+=";
        int score = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() >= 8) {
            score++;
        }

        for (int i = 0; i < password.length(); i++) {

            if (upperCaseLetters.contains(password.substring(i, i + 1))) {
                hasUpper = true;
            }
            if (lowerCaseLetters.contains(password.substring(i, i + 1))) {
                hasLower = true;
            }
            if (number.contains(password.substring(i, i + 1))) {
                hasNumber = true;
            }
            if (special.contains(password.substring(i, i + 1))) {
                hasSpecial = true;
            }

        }

        if (hasUpper) {
            score++;
        }
        if (hasLower) {
            score++;
        }
        if (hasNumber) {
            score++;
        }
        if (hasSpecial) {
            score++;
        }
        return score;

    }
    /**
    * Determines password strength label from score.
            *
            * @param score number of criteria met
     * @return strength label
     */
        public static String determineStrength ( int score){
            String strength = "";
            if (score >= 0 && score <= 2) {
                strength = "Weak";
            }
            if (score == 3) {
                strength = "Moderate";
            }
            if (score == 4 || score == 5) {
                strength = "Strong";
            }

            return strength;

        }


}
