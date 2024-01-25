import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManagementSystem gradeSystem = new GradeManagementSystem();

        while (true) {
            System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. Display Student Info\n5. Display All Students\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.println("Enter Subject Marks (5 subjects): ");
                    double[] subjectMarks = new double[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Subject " + (i + 1) + ": ");
                        subjectMarks[i] = scanner.nextDouble();
                    }
                    gradeSystem.addStudent(name, rollNumber, subjectMarks);
                    break;
                case 2:
                    System.out.print("Enter Roll Number to Update: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.println("Enter New Subject Marks (5 subjects): ");
                    double[] newSubjectMarks = new double[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Subject " + (i + 1) + ": ");
                        newSubjectMarks[i] = scanner.nextDouble();
                    }
                    gradeSystem.updateStudent(updateRollNumber, newSubjectMarks);
                    break;
                case 3:
                    System.out.print("Enter Roll Number to Delete: ");
                    int deleteRollNumber = scanner.nextInt();
                    gradeSystem.deleteStudent(deleteRollNumber);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Display Info: ");
                    int displayRollNumber = scanner.nextInt();
                    gradeSystem.displayStudentInfo(displayRollNumber);
                    break;
                case 5:
                    gradeSystem.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting Program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
