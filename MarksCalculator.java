import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        int totalMarks = 0;

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numberOfSubjects];

        // Input: Marks obtained in each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i]; // Sum up the marks obtained
        }

        // Calculate total marks and average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Display total marks and average percentage
        System.out.println("\nTotal Marks Obtained: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Calculate Grade based on average percentage
        String grade = calculateGrade(averagePercentage);

        // Display Grade
        System.out.println("Grade: " + grade);
    }

    // Method to calculate grade based on average percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}
