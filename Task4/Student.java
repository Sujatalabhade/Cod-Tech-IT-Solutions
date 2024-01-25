class Student {
    private String name;
    private int rollNumber;
    private double[] subjectMarks;

    // Constructor
    public Student(String name, int rollNumber, double[] subjectMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = subjectMarks;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double[] getSubjectMarks() {
        return subjectMarks;
    }
}

