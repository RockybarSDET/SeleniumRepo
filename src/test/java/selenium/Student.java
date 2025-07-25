package selenium;

public class Student {

    // Instance variable (belongs to each object)
    String name;
    int rollNumber;

    // Class variable (shared by all objects)
    static String schoolName = "ABC Public School";

    // Constructor to initialize instance variables
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("School Name: " + Student.schoolName);  // accessing static variable
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        // Creating first student object
        Student s1 = new Student("Alice", 101);
        s1.displayStudentDetails();

        // Creating second student object
        Student s2 = new Student("Bob", 102);
        s2.displayStudentDetails();

        // Changing class variable using class name
        Student.schoolName = "XYZ International School";

        // Displaying again to show the effect of changing static variable
        s1.displayStudentDetails();
        s2.displayStudentDetails();
    }
}

