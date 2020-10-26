package com.dkit.gd2.ca1.kevinmcenroe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void readResultsFromFile() {
    }

    @Test
    public void selectFiveGrades() {
        /* Notable Subject Codes:
        Irish   = 1
        English = 2
        Maths   = 3
        CSPE    = 218
        */

        // Testing standard functionality
        int[] codesA = {1, 2, 3, 218, 4, 5, 6, 7};
        int[] gradesA = {10, 20, 30, 100, 80, 90, 50, 60};
        int[] expectedResultA = {10, 20, 30, 80, 90};
        assertArrayEquals(expectedResultA, App.selectFiveGrades(codesA, gradesA));

        // Testing alternative subject order
        int[] codesB = {4, 5, 6, 218, 4, 1, 2, 3};
        int[] gradesB = {90, 50, 60, 100, 80, 10, 20, 30};
        int[] expectedResultB = {10, 20, 30, 80, 90};
        assertArrayEquals(expectedResultB, App.selectFiveGrades(codesB, gradesB));

        // Testing without CSPE
        int[] codesC = {1, 2, 3, 8, 4, 5, 6, 7};
        int[] gradesC = {10, 20, 30, 100, 80, 90, 50, 60};
        int[] expectedResultC = {10, 20, 30, 90, 100};
        assertArrayEquals(expectedResultC, App.selectFiveGrades(codesC, gradesC));

        // Testing values of 0
        int[] codesD = {1, 2, 3, 8, 4, 5, 6, 7};
        int[] gradesD = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedResultD = {0, 0, 0, 0, 0};
        assertArrayEquals(expectedResultD, App.selectFiveGrades(codesD, gradesD));
    }

    @Test
    public void calculateAverageGrade() {
        // Testing standard functionality
        int[] selectedGradesA = {10, 20, 30, 40, 50};
        assertEquals(30, App.calculateAverageGrade(selectedGradesA), 0.1);

        // Testing alternative grade order
        int[] selectedGradesB = {50, 40, 30, 20, 10};
        assertEquals(30, App.calculateAverageGrade(selectedGradesB), 0.1);

        // Testing values of 0
        int[] selectedGradesC = {0, 0, 0, 0, 0};
        assertEquals(0, App.calculateAverageGrade(selectedGradesC), 0.1);
    }
}
