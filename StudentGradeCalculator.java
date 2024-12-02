import java.util.Scanner;

public class StudentGradeCalculator {

    // Personalized motivational message based on grade
    public static String getMotivationalMessage(String grade) {
        switch (grade) {
            case "A":
                return "Outstanding! Keep shining like a star!";
            case "B":
                return "Great job! You're on your way to excellence!";
            case "C":
                return "Good effort! With more practice, you'll reach your goal!";
            case "D":
                return "You did it! A little more effort and you'll improve!";
            default:
                return "Don't give up! You have the potential to do better next time!";
        }
    }

    // Method to display result after calculations
    public static void resultCalculator(Scanner sc) {
        try {
            System.out.println("\n    * Welcome to the Student Grade Calculator *");
            System.out.println();

            // Personalized greeting
            System.out.print("Enter your name: ");
            String studentName = sc.nextLine();

            // Enter number of subjects
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            sc.nextLine(); // Consume newline after integer input

            // Create arrays to store subject names, marks, and feedback
            String[] subjectNames = new String[n];
            int[] subjMarks = new int[n];
            int tot = 0;

            // Input subject names and marks for each subject
            System.out.println("\nEnter subject names and marks (out of 100):");
            System.out.println("+-------+-----------------------+----------+");
            System.out.println("| Sr No.| Subject Name          |  Marks   |");
            System.out.println("+-------+-----------------------+----------+");

            // Variables to track highest and lowest marks
            int highestMarks = -1;
            int lowestMarks = 101;
            String highestSubject = "";
            String lowestSubject = "";

            for (int i = 0; i < n; i++) {
                System.out.print("Enter name of Subject " + (i + 1) + ": ");
                subjectNames[i] = sc.nextLine();
                System.out.printf("Enter marks for %s: ", subjectNames[i]);
                int marks = sc.nextInt();
                sc.nextLine(); // Consume newline after integer input

                // Validate marks input
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks entered! Please enter marks between 0 and 100.");
                    i--; // Decrement to retry this subject
                    continue;
                }

                subjMarks[i] = marks;
                tot += marks;

                // Track highest and lowest marks
                if (marks > highestMarks) {
                    highestMarks = marks;
                    highestSubject = subjectNames[i];
                }
                if (marks < lowestMarks) {
                    lowestMarks = marks;
                    lowestSubject = subjectNames[i];
                }
                System.out.println("+-------+-----------------------+----------+");
            }

            // Calculate average
            float average = (float) tot / n;
            String grade;
            if (average >= 90) {
                grade = "A";
            } else if (average >= 75) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else if (average >= 40) {
                grade = "D";
            } else {
                grade = "FAIL";
            }

            // Display results in a table format
            System.out.println("\n\n    ** Student Result **\n");
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Total Marks          |   %-3d/%d    |\n", tot, (n * 100));
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Average Percentage   |   %-6.2f     |\n", average);
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Grade                |   %-6s     |\n", grade);
            System.out.println("+----------------------+--------------+");

            // Subject-wise feedback
            for (int i = 0; i < n; i++) {
                String feedback = "";
                if (subjMarks[i] >= 85) {
                    feedback = "Excellent!";
                } else if (subjMarks[i] >= 70) {
                    feedback = "Good!";
                } else if (subjMarks[i] >= 50) {
                    feedback = "Needs Improvement.";
                } else {
                    feedback = "Please review your study material.";
                }
                System.out.printf("Feedback for %s: %s\n", subjectNames[i], feedback);
            }

            // Display Highest and Lowest Marks
            System.out.println("\nHighest Marks: " + highestMarks + " in " + highestSubject);
            System.out.println("Lowest Marks: " + lowestMarks + " in " + lowestSubject);

            // Ranking Message
            if (average >= 90) {
                System.out.println("You are in the top 10% of your class!");
            } else if (average >= 75) {
                System.out.println("You are in the top 20% of your class!");
            } else if (average >= 50) {
                System.out.println("You're doing well! Keep it up!");
            } else {
                System.out.println("Keep pushing! You can improve next time.");
            }

            // Display Progress Bar
            displayProgressBar(average);

            // Personalized message based on grade
            String message = getMotivationalMessage(grade);
            System.out.println(message);

            // Visual stars based on grade
            String stars = "* ".repeat(average >= 90 ? 5 : average >= 75 ? 4 : average >= 50 ? 3 : average >= 40 ? 2 : 0);
            System.out.println("Your Star Rating: " + stars);

            // Pass/Fail condition with feedback
            if (grade.equals("FAIL")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Sorry, You've Failed the Exam.");
                System.out.println("       _________");
                System.out.println("      /         \\");
                System.out.println("     /           \\");
                System.out.println("    |   FAILED!   |");
                System.out.println("    |   TRY AGAIN!|");
                System.out.println("    |_____________|");
                System.out.println("        |     |");
                System.out.println("        |     |");
                System.out.println("        |_____|");
                System.out.println("       /       \\");
                System.out.println("      *         *");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Don't give up!  Keep pushing, you'll do better next time!");
            } else { 
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Congratulations! You've Passed!");
                System.out.println("        _________");
                System.out.println("       /         \\");
                System.out.println("      /           \\");
                System.out.println("     |   PASSED!   |");
                System.out.println("     |    GREAT!   |");
                System.out.println("     |_____________|");
                System.out.println("        |     |");
                System.out.println("        |     |");
                System.out.println("        |_____|");
                System.out.println("       /       \\");
                System.out.println("      *         *");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("You're a champion! Keep going!");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    // Method to display progress bar
    public static void displayProgressBar(float average) {
        String bar = "";
        int percentage = (int) average;
        for (int i = 0; i < 10; i++) {
            if (i < percentage / 10) {
                bar += "[#]";
            } else {
                bar += "[ ]";
            }
        }
        System.out.println("Progress: [" + bar + "] " + percentage + "%");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            resultCalculator(s); // Call the result calculator method
            System.out.print("Do you want to calculate another student result (y/n): ");
            String ch = s.next();
            if (ch.equalsIgnoreCase("yes")) {
                continue;
            } else {
                System.out.println("Thank you! Have a good day!");
                break; 
            }
        }
        s.close();
    }
}
