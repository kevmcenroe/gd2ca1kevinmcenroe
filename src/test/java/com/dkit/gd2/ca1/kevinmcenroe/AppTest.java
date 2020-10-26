package com.dkit.gd2.ca1.kevinmcenroe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    }

    @Test
    public void calculateAverageGrade() {
        int[] grades = {10,20,30,40,50};
        assertEquals(30, App.calculateAverageGrade(grades), 0.1);
    }
}
