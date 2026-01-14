package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeedbackGeneratorTest {

    @Test
    void testGenerateFeedback_AllCriteriaMet() {
        String password = "Strong1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertEquals("", feedback);
    }

    @Test
    void testGenerateFeedback_MissingUppercase() {
        String password = "strong1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("uppercase"));
    }

    @Test
    void testGenerateFeedback_MissingLowercase() {
        String password = "STRONG1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("lowercase"));
    }

    @Test
    void testGenerateFeedback_MissingNumber() {
        String password = "Strong!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("number"));
    }

    @Test
    void testGenerateFeedback_MissingSpecialCharacter() {
        String password = "Strong12";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("special"));
    }

    @Test
    void testGenerateFeedback_TooShortPassword() {
        String password = "S1!";
        String feedback = FeedbackGenerator.generateFeedback(password);
        assertTrue(feedback.contains("Increase the length"));
    }

    @Test
    void testGenerateFeedback_MultipleMissingCriteria() {
        String password = "abc";
        String feedback = FeedbackGenerator.generateFeedback(password);

        assertTrue(feedback.contains("uppercase"));
        assertTrue(feedback.contains("number"));
        assertTrue(feedback.contains("special"));
        assertTrue(feedback.contains("Increase the length"));
    }
}
