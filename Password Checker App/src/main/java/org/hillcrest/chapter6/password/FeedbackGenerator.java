package org.hillcrest.chapter6.password;
/**
 * Utility class that generates feedback for improving a password.
 */
public class FeedbackGenerator {
    /**
     * Generates feedback based on failed password criteria.
     *
     * @param password the password to analyze
     * @return feedback string with suggestions
     */
    public static String generateFeedback(String password){
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwuxyz";
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "1234567890";
        String special = "!@#$%^&*()-+=";
        int score = 0;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasLetter = false;
        String feedback = "";


        if (password.length() >= 8) {
            hasLetter = true;
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

        if (!hasUpper) {
            feedback += "Add at least one uppercase letter";
        }
        if (!hasLower) {
            feedback += "Add at least one lowercase letter.";
        }
        if (!hasNumber) {
            feedback += "Add at least one number.";
        }
        if (!hasSpecial) {
            feedback += "Add at least one special character.";
        }
        if (!hasLetter){
            feedback += "Increase the length to at  lease 8 characters.";
        }
        return feedback;
    }
}
