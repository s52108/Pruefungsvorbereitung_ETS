package DateiServer_Klausur.textfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFileHandler {


    private String path;

    public TextFileHandler(String path) {
        this.path = path;
    }

    public void saveTextFile(TextFile textFile) throws TextFileSaveException {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + textFile.getFilename()))) {

            bw.write(textFile.getContent());
            bw.flush();


        } catch (IOException e) {
            throw new TextFileSaveException(e);
        }

    }

    public TextFile loadTextFile(String filename) throws TextFileLoadException {
        TextFile tf = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path + filename))) {

            String line;
            String temp = "";

            while ((line = br.readLine()) != null) {
                temp += line + "\n";

            }
            tf = new TextFile(filename, temp);


        } catch (FileNotFoundException e) {
            throw new TextFileLoadException(e);
        } catch (IOException e) {
            throw new TextFileLoadException(e);
        }


        return tf;


    }

    public ArrayList<TextFile> loadTextFiles() throws TextFileLoadException {

        ArrayList<TextFile> textFiles = new ArrayList<>();
        File[] files = new File(path).listFiles();
        for (File file : files) {
            textFiles.add(loadTextFile(file.getName()));

        }

        return textFiles;
    }
}
