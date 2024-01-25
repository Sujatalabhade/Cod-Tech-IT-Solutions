import java.util.ArrayList;

class GradeManagementSystem {
    
        private ArrayList<Student> students = new ArrayList<>();
        private final int numSubjects = 5; // Assuming 5 subjects
        private final double passPercentage = 40.0; // Define your pass percentage
        private final char[] gradeScale = {'A', 'B', 'C', 'D', 'F'}; // Define your grade scale
    
    
    
        // Function to calculate overall percentage
        private double calculatePercentage(double[] subjectMarks) {
            double totalMarks = 0;
            for (double mark : subjectMarks) {
                totalMarks += mark;
            }
            return totalMarks / numSubjects;
        }
    
        // Function to calculate grade based on predefined criteria
        private char calculateGrade(double percentage) {
            if (percentage >= 90) return gradeScale[0];
            else if (percentage >= 80) return gradeScale[1];
            else if (percentage >= 70) return gradeScale[2];
            else if (percentage >= 60) return gradeScale[3];
            else return gradeScale[4];
        }
    
        // Function to add a new student record
        public void addStudent(String name, int rollNumber, double[] subjectMarks) {
            Student newStudent = new Student(name, rollNumber, subjectMarks);
            students.add(newStudent);
            System.out.println("Student record added successfully.");
        }
    
        // Function to update an existing student record
        public void updateStudent(int rollNumber, double[] newSubjectMarks) {
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    student = new Student(student.getName(), rollNumber, newSubjectMarks);
                    System.out.println("Student record updated successfully.");
                    return;
                }
            }
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    
        // Function to delete a student record
        public void deleteStudent(int rollNumber) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRollNumber() == rollNumber) {
                    students.remove(i);
                    System.out.println("Student record deleted successfully.");
                    return;
                }
            }
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    
        // Function to display student information
        public void displayStudentInfo(int rollNumber) {
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    double percentage = calculatePercentage(student.getSubjectMarks());
                    char grade = calculateGrade(percentage);
                    System.out.println("Student Name: " + student.getName());
                    System.out.println("Roll Number: " + student.getRollNumber());
                    System.out.println("Overall Percentage: " + percentage);
                    System.out.println("Grade: " + grade);
                    return;
                }
            }
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    
        // Function to display all student records
        public void displayAllStudents() {
            for (Student student : students) {
                double percentage = calculatePercentage(student.getSubjectMarks());
                char grade = calculateGrade(percentage);
                System.out.println("Student Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Overall Percentage: " + percentage);
                System.out.println("Grade: " + grade);
                System.out.println("-------------");
            }
        }
    }