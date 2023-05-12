package Hangman_Spiel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DictionaryLoader {


    private String path;

    public DictionaryLoader() {
        this.path = "data\\liste.dat";
    }

    public static void main(String[] args) throws DataFileException {
        ArrayList<String> words = new DictionaryLoader().load();

        for (String word : words) {
            System.out.println(word);
        }

    }

    public ArrayList<String> load() throws DataFileException {

        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty() && !words.contains(line)) {
                    words.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            throw new DataFileException("File does not Exist", e);
        } catch (IOException e) {
            throw new DataFileException("Can not read file", e);
        }
        Collections.sort(words, new StringsDescAlphabetAsc());
        return words;

    }


}
