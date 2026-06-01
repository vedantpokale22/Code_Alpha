import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("=================================");

        int n = 0;
        while (true) {
            System.out.print("Enter number of students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n > 0) break;
                System.out.println("Number of students must be greater than 0.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            double grade = 0;
            while (true) {
                System.out.print("Enter Grade: ");
                if (sc.hasNextDouble()) {
                    grade = sc.nextDouble();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Invalid grade. Please enter a numeric value.");
                    sc.nextLine();
                }
            }

            students.add(new Student(name, grade));
        }

        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();

        String highestStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        for (Student s : students) {
            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
                highestStudent = s.getName();
            }

            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
                lowestStudent = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n=================================");
        System.out.println("         SUMMARY REPORT");
        System.out.println("=================================");

        System.out.printf("Total Students : %d%n", students.size());

        System.out.printf("%-20s %-10s%n", "Student Name", "Grade");
        System.out.println("---------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %-10.2f%n",
                    s.getName(), s.getGrade());
        }

        System.out.println("---------------------------------");
        System.out.printf("Average Score : %.2f%n", average);
        System.out.printf("Highest Score : %.2f (%s)%n",
                highest, highestStudent);
        System.out.printf("Lowest Score  : %.2f (%s)%n",
                lowest, lowestStudent);

        sc.close();
    }
}
