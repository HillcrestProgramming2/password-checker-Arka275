package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CriteriaCheckerTest {

    @Test
    void testEvaluateCriteria_AllCriteriaMet() {
        String password = "Strong1!";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(5, score);
    }

    @Test
    void testEvaluateCriteria_OnlyLengthMet() {
        String password = "abcdefgh";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(2, score); // length + lowercase
    }

    @Test
    void testEvaluateCriteria_NoCriteriaMet() {
        String password = "abc";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(1, score); // lowercase only
    }

    @Test
    void testEvaluateCriteria_UppercaseAndNumberOnly() {
        String password = "ABCD123";
        int score = CriteriaChecker.evaluateCriteria(password);
        assertEquals(2, score); // uppercase + number
    }

    @Test
    void testDetermineStrength_Weak() {
        assertEquals("Weak", CriteriaChecker.determineStrength(0));
        assertEquals("Weak", CriteriaChecker.determineStrength(2));
    }

    @Test
    void testDetermineStrength_Moderate() {
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));
    }

    @Test
    void testDetermineStrength_Strong() {
        assertEquals("Strong", CriteriaChecker.determineStrength(4));
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }
}
