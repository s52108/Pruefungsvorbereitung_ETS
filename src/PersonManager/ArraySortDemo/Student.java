package PersonManager.ArraySortDemo;

import java.util.Arrays;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    private int matrNr;
    private String firstName;
    private String lastName;

    public Student(int matrNr, String firstName, String lastName) {
        this.matrNr = matrNr;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getMatrNr() {
        return matrNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Student [matrNr=" + matrNr + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    public static void main(String[] args) {
        // Erstellen von drei Arrays mit unterschiedlichen Datentypen
        int[] matrNrArray = {1234, 5678, 9012};
        String[] firstNameArray = {"Max", "Anna", "Tom"};
        String[] lastNameArray = {"Mustermann", "Müller", "Schmidt"};
        Student[] studentArray = {new Student(91234, "Max", "Mustermann"), new Student(55678, "Anna", "Müller"),
                new Student(89012, "Tom", "Schmidt")};

        // Sortieren der Arrays mit Arrays.sort()
        Arrays.sort(matrNrArray);
        Arrays.sort(firstNameArray);
        Arrays.sort(lastNameArray);
        Arrays.sort(studentArray);

        // Ausgabe der Arrays auf der Kommandozeile
        System.out.println("matrNrArray: " + Arrays.toString(matrNrArray));
        System.out.println("firstNameArray: " + Arrays.toString(firstNameArray));
        System.out.println("lastNameArray: " + Arrays.toString(lastNameArray));
        System.out.println("studentArray: " + Arrays.toString(studentArray));
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.matrNr, this.matrNr);
    }
}
