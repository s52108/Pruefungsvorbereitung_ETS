package Hangman_Spiel;

import java.util.Comparator;

public class StringsDescAlphabetAsc implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        int result = o2.length() - o1.length();
        if (result == 0) {
            result = o1.compareTo(o2);
        }
        return result;
    }




}
