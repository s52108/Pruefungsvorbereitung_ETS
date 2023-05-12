package Urlaub;

import Hangman_Spiel.DataFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UrlaubManager {

    private ArrayList<Urlaub> urlauben = new ArrayList<>();

    public ArrayList<Urlaub> getUrlauben() {
        return urlauben;
    }

    public void load(String mitarbeiter) throws DataFileException {
        //ArrayList<Urlaub> urlauben = new ArrayList<>();
        String path = "data/urlaube.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;


            while ((line = br.readLine()) != null) {

                String[] urlaubData = line.split(",");

                if (urlaubData[1].equals(mitarbeiter)) {
                    int id = Integer.parseInt(urlaubData[0]);
                    String von = urlaubData[2];
                    String bis = urlaubData[3];


                    Urlaub u = new Urlaub(id, mitarbeiter, von, bis);
                    this.urlauben.add(u);


                }
            }
            this.urlauben.sort(new VonDescMitarbeiterAsc());

        } catch (FileNotFoundException e) {
            throw new DataFileException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
