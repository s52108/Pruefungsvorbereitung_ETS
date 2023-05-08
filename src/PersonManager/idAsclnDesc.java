package PersonManager;

import java.util.Comparator;

public class idAsclnDesc implements Comparator<Person2> {
    @Override
    public int compare(Person2 o1, Person2 o2) {
        int res = Integer.compare(o1.getId(),o2.getId());
        if(res==0){
            o1.getLastName().compareTo(o2.getLastName());
        }

        return res;
    }
}
