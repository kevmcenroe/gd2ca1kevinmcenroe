package com.dkit.gd2.ca1.kevinmcenroe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<StudentRecord> allRecords = new ArrayList<StudentRecord>(readResults());

        int[] testCodes = allRecords.get(0).subjectCodes.stream().mapToInt(i->i).toArray();
        int[] testGrades = allRecords.get(0).subjectGrades.stream().mapToInt(i->i).toArray();

        int[] chosenGrades = selectFiveGrades(testCodes, testGrades);
        for (int i = 0; i < chosenGrades.length; i++) {
            System.out.println(chosenGrades[i]);
        }
    }

    static public ArrayList<StudentRecord> readResults() {
        HashMap<Integer, Integer> subjectGrades = new HashMap<Integer, Integer>();
        ArrayList<StudentRecord> allStudentRecords = new ArrayList<StudentRecord>();

        try(Scanner fileScanner = new Scanner(new BufferedReader( new FileReader("JC_Results.txt")))) {
            fileScanner.useDelimiter(",");

            while(fileScanner.hasNextLine()) {
                String lineContent[] = fileScanner.nextLine().split(",");

                int studentNumber = Integer.parseInt(lineContent[0]);
                ArrayList<Integer> studentGrades = new ArrayList<Integer>();
                ArrayList<Integer> studentSubjects = new ArrayList<Integer>();

                for (int i = 1; i < lineContent.length - 1; i+=2) {
                    int subjectCode = Integer.parseInt(lineContent[i]);
                    int subjectGrade = Integer.parseInt(lineContent[i+1]);

                    studentSubjects.add(subjectCode);
                    studentGrades.add(subjectGrade);
                }

                allStudentRecords.add(new StudentRecord(studentNumber, studentSubjects, studentGrades));
            }
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        return allStudentRecords;
    }

    public static int[] selectFiveGrades(int[] codes, int[] grades){
        int subjectCode_Irish = 1;
        int subjectCode_English = 2;
        int subjectCode_Maths = 3;
        int subjectCode_CSPE = 218;

        int[] selectedGrades = {0,0,0,0,0};
        int[] remainingGrades = {0,0,0,0,0};
        int selectedGradesCounted = 0;
        int remainingGradesCounted = 0;

        for (int i = 0; i < codes.length; i++) {
            if(codes[i] == subjectCode_Irish || codes[i] == subjectCode_English || codes[i] == subjectCode_Maths){
                selectedGrades[selectedGradesCounted] = grades[i];
                selectedGradesCounted++;
            }
            else if(codes[i] != subjectCode_CSPE){
                remainingGrades[remainingGradesCounted] = grades[i];
                remainingGradesCounted++;
            }
        }

        Arrays.sort(remainingGrades);
        int highestGrade = remainingGrades[remainingGrades.length - 1];
        int secondHighestGrade = remainingGrades[remainingGrades.length - 2];

        selectedGrades[selectedGradesCounted] = highestGrade;
        selectedGradesCounted++;
        selectedGrades[selectedGradesCounted] = secondHighestGrade;

        return selectedGrades;
    }

    private double calculateAverage( int[] selectedGrades) {
        double average = 1.0;

        return average;
    }
}