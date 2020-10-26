package com.dkit.gd2.ca1.kevinmcenroe;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void readResultsFromFile() {
        int expectedStudentNumber_A = 891234;

        ArrayList<Integer> expectedSubjects_A = new ArrayList<>();
        expectedSubjects_A.add(1);
        expectedSubjects_A.add(2);
        expectedSubjects_A.add(3);
        expectedSubjects_A.add(4);
        expectedSubjects_A.add(5);
        expectedSubjects_A.add(12);
        expectedSubjects_A.add(42);
        expectedSubjects_A.add(46);

        ArrayList<Integer> expectedGrades_A = new ArrayList<>();
        expectedGrades_A.add(65);
        expectedGrades_A.add(58);
        expectedGrades_A.add(45);
        expectedGrades_A.add(60);
        expectedGrades_A.add(50);
        expectedGrades_A.add(48);
        expectedGrades_A.add(42);
        expectedGrades_A.add(60);

        StudentRecord studentA = new StudentRecord(expectedStudentNumber_A, expectedSubjects_A, expectedGrades_A);

        int expectedStudentNumber_B = 783461;

        ArrayList<Integer> expectedSubjects_B = new ArrayList<>();
        expectedSubjects_B.add(3);
        expectedSubjects_B.add(1);
        expectedSubjects_B.add(2);
        expectedSubjects_B.add(125);
        expectedSubjects_B.add(137);
        expectedSubjects_B.add(126);
        expectedSubjects_B.add(57);
        expectedSubjects_B.add(4);

        ArrayList<Integer> expectedGrades_B = new ArrayList<>();
        expectedGrades_B.add(65);
        expectedGrades_B.add(58);
        expectedGrades_B.add(45);
        expectedGrades_B.add(60);
        expectedGrades_B.add(68);
        expectedGrades_B.add(100);
        expectedGrades_B.add(77);
        expectedGrades_B.add(60);

        StudentRecord studentB = new StudentRecord(expectedStudentNumber_B, expectedSubjects_B, expectedGrades_B);

        ArrayList<StudentRecord> expectedRecords = new ArrayList<>();
        expectedRecords.add(studentA);
        expectedRecords.add(studentB);

        String fileName = "JC_Results.txt";
        assertEquals(expectedRecords.get(0).studentNumber, App.readResultsFromFile(fileName).get(0).studentNumber);
        assertEquals(expectedRecords.get(1).studentNumber, App.readResultsFromFile(fileName).get(1).studentNumber);
        assertEquals(expectedRecords.get(0).subjectCodes, App.readResultsFromFile(fileName).get(0).subjectCodes);
        assertEquals(expectedRecords.get(1).subjectCodes, App.readResultsFromFile(fileName).get(1).subjectCodes);
        assertEquals(expectedRecords.get(0).subjectGrades, App.readResultsFromFile(fileName).get(0).subjectGrades);
        assertEquals(expectedRecords.get(1).subjectGrades, App.readResultsFromFile(fileName).get(1).subjectGrades);
    }

    /* Notable Subject Codes:
    Irish   = 1
    English = 2
    Maths   = 3
    CSPE    = 218
    */
    @Test
    public void selectFiveGrades1() {
        // Testing standard functionality
        int[] codesA = {1, 2, 3, 218, 4, 5, 6, 7};
        int[] gradesA = {10, 20, 30, 100, 80, 90, 50, 60};
        int[] expectedResultA = {10, 20, 30, 80, 90};
        assertArrayEquals(expectedResultA, App.selectFiveGrades(codesA, gradesA));
    }
    @Test
    public void selectFiveGrades2() {
        // Testing alternative subject order
        int[] codesB = {4, 5, 6, 218, 4, 1, 2, 3};
        int[] gradesB = {90, 50, 60, 100, 80, 10, 20, 30};
        int[] expectedResultB = {10, 20, 30, 80, 90};
        assertArrayEquals(expectedResultB, App.selectFiveGrades(codesB, gradesB));
    }
    @Test
    public void selectFiveGrades3() {
        // Testing without CSPE
        int[] codesC = {1, 2, 3, 8, 4, 5, 6, 7};
        int[] gradesC = {10, 20, 30, 100, 80, 90, 50, 60};
        int[] expectedResultC = {10, 20, 30, 90, 100};
        assertArrayEquals(expectedResultC, App.selectFiveGrades(codesC, gradesC));
    }
    @Test
    public void selectFiveGrades4() {
        // Testing values of 0
        int[] codesD = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] gradesD = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedResultD = {0, 0, 0, 0, 0};
        assertArrayEquals(expectedResultD, App.selectFiveGrades(codesD, gradesD));
    }

    @Test
    public void calculateAverageGrade1() {
        // Testing standard functionality
        int[] selectedGradesA = {10, 20, 30, 40, 50};
        assertEquals(30, App.calculateAverageGrade(selectedGradesA), 0.1);
    }
    @Test
    public void calculateAverageGrade2() {
        // Testing alternative grade order
        int[] selectedGradesB = {50, 40, 30, 20, 10};
        assertEquals(30, App.calculateAverageGrade(selectedGradesB), 0.1);
    }
    @Test
    public void calculateAverageGrade3() {
        // Testing values of 0
        int[] selectedGradesC = {0, 0, 0, 0, 0};
        assertEquals(0, App.calculateAverageGrade(selectedGradesC), 0.1);
    }
}
