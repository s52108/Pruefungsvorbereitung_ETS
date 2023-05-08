package PersonManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class PersonLoader implements Comparator {
    public static void main(String[] args) {
        ArrayList<Person2> people2 = new PersonLoader("src/PersonManager/persons.csv").load();

        for (Person2 person2 : people2) {
            System.out.println(person2);
        }
    }


    private String pathToFile;

    public PersonLoader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ArrayList<Person2> load() {
        ArrayList<Person2> people2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] personData = line.split(";");
                int id = Integer.parseInt(personData[0]);
                String fn = personData[1];
                String ln = personData[2];

                Person2 p = new Person2(id, fn, ln);

                people2.add(p);

            }
            people2.sort(new idAsclnDesc());
        } catch (FileNotFoundException f) {
            throw new RuntimeException("File not Found", f);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }

        return people2;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
