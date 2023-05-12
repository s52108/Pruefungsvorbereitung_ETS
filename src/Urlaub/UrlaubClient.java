package Urlaub;

import Hangman_Spiel.DataFileException;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class UrlaubClient implements Runnable {
    private Socket client;

    public UrlaubClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            ArrayList<Urlaub> urlauben;
            UrlaubManager um = new UrlaubManager();

            String command;

            while ((command = br.readLine()) != null) {
                if (command.isEmpty()) {
                    continue;
                }

                String[] cmds = command.split(" ");
                if (command.startsWith("GET ")) {

                    String mitarbeiter = cmds[1] + " " + cmds[2];

                    urlauben = um.getUrlauben();
                    um.load(mitarbeiter);

                    for (Urlaub urlaub : urlauben) {
                        bw.write(urlaub.toString());
                        bw.newLine();
                        bw.flush();

                    }

                } else if (command.equalsIgnoreCase("Exit")) {
                    bw.write("client wird disconnected");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("Falsche Eingabe");
                    bw.newLine();
                    bw.flush();
                }
                bw.newLine();
                bw.flush();
            }


        } catch (IOException | DataFileException e) {
            try {
                throw new DataFileException("File does not exist.", e);
            } catch (DataFileException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
