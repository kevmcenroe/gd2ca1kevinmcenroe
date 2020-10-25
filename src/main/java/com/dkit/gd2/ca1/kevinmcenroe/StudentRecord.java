// Kevin McEnroe
package com.dkit.gd2.ca1.kevinmcenroe;

import java.util.ArrayList;

public class StudentRecord {
    int studentNumber;
    ArrayList<Integer> subjectCodes = new ArrayList<Integer>();
    ArrayList<Integer> subjectGrades = new ArrayList<Integer>();


    public StudentRecord(int inputStudentNumber, ArrayList<Integer> inputSubjects, ArrayList<Integer> inputGrades) {
        this.studentNumber = inputStudentNumber;
        this.subjectCodes = inputSubjects;
        this.subjectGrades = inputGrades;
    }
}
