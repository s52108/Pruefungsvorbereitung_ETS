package PersonManager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Person2 implements Serializable {
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private int id;
    private String firstName;
    private String lastName;

    public Person2(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person2)) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id && Objects.equals(firstName, person2.firstName) && Objects.equals(lastName, person2.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
