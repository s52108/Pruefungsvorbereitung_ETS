package DateiServer_Klausur.fileserver;

import DateiServer_Klausur.textfile.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    Socket client;

    TextFileHandler textFileHandler;

    public ClientHandler(Socket client, String path) {
        this.client = client;
        this.textFileHandler = new TextFileHandler(path);


    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            String command;
            ArrayList<TextFile> textFiles = null;

            while ((command = br.readLine()) != null) {

                String[] cmds = command.split(" ");

                if (command.startsWith("Is")) {
                    if (cmds[1].equals("default")) {
                        try {
                            textFiles = textFileHandler.loadTextFiles();

                            for (TextFile textFile : textFiles) {
                                bw.write(textFile.toString());
                                bw.newLine();
                                bw.flush();

                            }


                        } catch (TextFileLoadException e) {
                            bw.write(e.getMessage());
                        }
                    } else if (cmds[1].equals("filesize")) {

                        try {
                            textFiles = textFileHandler.loadTextFiles();
                            textFiles.sort(new FileSizeComparator());

                            for (TextFile textFile : textFiles) {
                                bw.write(textFile.toString());
                                bw.newLine();
                                bw.flush();

                            }


                        } catch (TextFileLoadException e) {
                            bw.write(e.getMessage());
                        }

                    }
                    bw.write("#####END#####");
                    bw.newLine();
                    bw.flush();


                } else if (command.startsWith("put ")) {

                    textFileHandler.loadTextFile(cmds[1]);
                    String temp = "";
                    while ((command = br.readLine()).equals("#####END#####")) {
                        temp += command + "\n";
                        bw.write(command);
                        bw.newLine();
                        bw.flush();


                    }

                    TextFile tf = new TextFile(cmds[1], temp);
                    textFileHandler.saveTextFile(tf);


                } else if (command.startsWith("get ")) {
                    String filename = cmds[1];

                    for (TextFile textFile : textFiles) {


                        bw.write(textFileHandler.loadTextFile(filename).getFilename());
                        bw.newLine();
                        bw.flush();
                        bw.write(textFileHandler.loadTextFile(filename).getContent());

                        bw.newLine();
                        bw.flush();

                    }


                } else if (command.equalsIgnoreCase("bye")) {
                    bw.write("Kommunikation wird beendet.");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("error: command invalid");
                    bw.newLine();
                    bw.flush();
                }
            }


        } catch (IOException e) {

            try {
                throw new TextFileLoadException(e);
            } catch (TextFileLoadException ex) {
                throw new RuntimeException(ex);
            }


        } catch (TextFileLoadException e) {
            throw new RuntimeException(e);
        } catch (TextFileSaveException e) {
            throw new RuntimeException(e);
        }

    }
}
