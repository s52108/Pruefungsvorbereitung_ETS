package DateiServer_Klausur.textfile;

import java.util.ArrayList;

public class DemoApp {
    public static void main(String[] args) throws TextFileSaveException, TextFileLoadException {
        TextFileHandler tfh = new TextFileHandler("data/");

        tfh.saveTextFile(new TextFile("textfile.txt", "Zeile1 \nZeile 2"));

        //tfh.loadTextFile();
        System.out.println(tfh.loadTextFile("textfile.txt").getContent());


        tfh.loadTextFiles();

        ArrayList<TextFile> textFiles = new ArrayList<>();
        textFiles = tfh.loadTextFiles();

        for (TextFile textFile : textFiles) {
            System.out.println(textFile.getFilename());

        }

        textFiles.sort(new FileSizeComparator());

        for (TextFile textFile : textFiles) {
            System.out.println(textFile);

        }
    }
}
