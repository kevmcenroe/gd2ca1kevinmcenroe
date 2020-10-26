// Kevin McEnroe, Student ID: D00242092
package com.dkit.gd2.ca1.kevinmcenroe;

import java.util.ArrayList;

public class StudentRecord {
    int studentNumber;
    ArrayList<Integer> subjectCodes;
    ArrayList<Integer> subjectGrades;

    public StudentRecord(int inputStudentNumber, ArrayList<Integer> inputSubjects, ArrayList<Integer> inputGrades) {
        this.studentNumber = inputStudentNumber;
        this.subjectCodes = inputSubjects;
        this.subjectGrades = inputGrades;
    }
}
