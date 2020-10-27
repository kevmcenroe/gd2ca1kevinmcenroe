// Kevin McEnroe, Student ID: D00242092
package com.dkit.gd2.ca1.kevinmcenroe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<StudentRecord> studentRecords = new ArrayList<StudentRecord>(readResultsFromFile("JC_Results.txt"));
        getAverageGradePerStudent(studentRecords);
    }

    static public ArrayList<StudentRecord> readResultsFromFile(String readFileName) {
        ArrayList<StudentRecord> readStudentRecords = new ArrayList<>();

        try(Scanner fileScanner = new Scanner(new BufferedReader( new FileReader(readFileName)))) {
            fileScanner.useDelimiter(",");

            while(fileScanner.hasNextLine()) {
                String[] lineContent = fileScanner.nextLine().split(",");

                int studentNumber = Integer.parseInt(lineContent[0]);
                ArrayList<Integer> studentGrades = new ArrayList<>();
                ArrayList<Integer> studentSubjects = new ArrayList<>();

                for (int i = 1; i < lineContent.length - 1; i+=2) {
                    int subjectCode = Integer.parseInt(lineContent[i]);
                    int subjectGrade = Integer.parseInt(lineContent[i+1]);

                    studentSubjects.add(subjectCode);
                    studentGrades.add(subjectGrade);
                }

                readStudentRecords.add(new StudentRecord(studentNumber, studentSubjects, studentGrades));
            }
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        return readStudentRecords;
    }

    public static int[] selectFiveGrades(int[] codes, int[] grades){
        final int subjectCode_Irish = 1;
        final int subjectCode_English = 2;
        final int subjectCode_Maths = 3;
        final int subjectCode_CSPE = 218;

        int[] selectedGrades = {0,0,0,0,0};
        ArrayList<Integer> remainingGrades = new ArrayList<>();
        int selectedGradesCounted = 0;

        for (int i = 0; i < codes.length; i++) {
            if(codes[i] == subjectCode_Irish || codes[i] == subjectCode_English || codes[i] == subjectCode_Maths){
                selectedGrades[selectedGradesCounted] = grades[i];
                selectedGradesCounted++;
            }
            else if(codes[i] != subjectCode_CSPE){
                remainingGrades.add(grades[i]);
            }
        }

        Collections.sort(remainingGrades);
        int highestGrade = remainingGrades.get(remainingGrades.size() - 1);
        int secondHighestGrade = remainingGrades.get(remainingGrades.size() - 2);

        selectedGrades[selectedGradesCounted] = highestGrade;
        selectedGradesCounted++;
        selectedGrades[selectedGradesCounted] = secondHighestGrade;

        Arrays.sort(selectedGrades);
        return selectedGrades;
    }

    protected static double calculateAverageGrade( int[] selectedGrades) {
        double average = 0.0;

        for(double grade : selectedGrades){
            average += grade;
        }

        average /= selectedGrades.length;
        return average;
    }

    protected static void getAverageGradePerStudent(ArrayList<StudentRecord> inputStudentRecords){
        for (StudentRecord inputStudentRecord : inputStudentRecords) {
            int[] subjectCodes = inputStudentRecord.subjectCodes.stream().mapToInt(i -> i).toArray();
            int[] subjectGrades = inputStudentRecord.subjectGrades.stream().mapToInt(i -> i).toArray();
            int[] chosenGrades = selectFiveGrades(subjectCodes, subjectGrades);
            double averageGrade = calculateAverageGrade(chosenGrades);

            System.out.println(inputStudentRecord.studentNumber + " " + averageGrade);
        }
    }
}