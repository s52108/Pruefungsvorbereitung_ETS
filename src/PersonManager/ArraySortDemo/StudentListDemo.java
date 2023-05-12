package PersonManager.ArraySortDemo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentListDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1234, "Max", "Mustermann"));
        students.add(new Student(2345, "Lisa", "Müller"));
        students.add(new Student(3456, "Anna", "Schmidt"));
        students.add(new Student(4567, "Tom", "Schmidt"));
        students.add(new Student(5678, "Johann", "Schmidt"));
        students.add(new Student(6789, "Sarah", "Müller"));


        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int result = s1.getLastName().compareTo(s2.getLastName());
                if (result == 0) {
                    result = s2.getFirstName().compareTo(s1.getFirstName());
                }
                return result;
            }
        };

        // Sortiere die Liste mit dem Comparator
        students.sort(nameComparator);

        // Gib die sortierte Liste auf der Konsole aus
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
