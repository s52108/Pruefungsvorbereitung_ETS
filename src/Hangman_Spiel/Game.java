package Hangman_Spiel;

import java.sql.Array;
import java.util.ArrayList;

public class Game {

    private char[] currentWord;
    private char[] foundWord;
    private int counter;


    public void loadWord() {

        ArrayList<String> words = null;


        int count = 0;
        try {
            words = new DictionaryLoader().load();

            currentWord = words.get(count).toCharArray();

            System.out.println(currentWord);

            foundWord = new char[currentWord.length];

            for (int i = 0; i < foundWord.length; i++) {
                foundWord[i] = '_';
            }
            System.out.println(foundWord);


        } catch (DataFileException e) {
            throw new RuntimeException(e);
        }


    }

    public String tryCharacter(char c) {
        for (int i = 0; i < currentWord.length; i++) {

            if (currentWord[i] == c) {
                foundWord[i] = c;
            }

        }

        System.out.println(foundWord);
        return String.valueOf(foundWord);
    }


    public boolean isFinished() {

        for (int i = 0; i < foundWord.length; i++) {
            if (foundWord[i] == '_') {
                return false;
            } else {
                loadWord();
                return true;
            }
        }
        return true;
    }

}
