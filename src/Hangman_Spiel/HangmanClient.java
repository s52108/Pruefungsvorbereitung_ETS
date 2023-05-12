package Hangman_Spiel;

import java.io.*;
import java.net.Socket;

public class HangmanClient implements Runnable {

    private Game game;
    private Socket client;
    private String name;

    public HangmanClient(Game game, Socket client) {
        this.game = game;
        this.client = client;
    }

    @Override
    public void run() {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {


            String command;
            boolean notSet = false;
            game.loadWord();

            while ((command = br.readLine()) != null) {
                String[] cmds = command.split(" ");
                if (command.startsWith("NAME ")) {

                    if (cmds.length > 3) {
                        bw.write("Der Spielername darf nur aus einem Wort bestehen");
                        continue;
                    }


                    name = cmds[1];
                    notSet = true;
                    bw.write(name);
                    bw.newLine();
                    bw.flush();
                } else if (command.equals("NAME")) {
                    bw.write("Der Name muss mit einem ' ' getrennt geschrieben werden.");
                    bw.newLine();
                    bw.flush();


                } else if (notSet) {
                    bw.write("Bitte mittels Befehl <NAME> name Ihren Spielernamen zuerst eingeben.");
                    bw.newLine();
                    bw.flush();


                } else if (command.startsWith("TRY ")) {

                    if (cmds.length > 2) {
                        bw.write("Der Spielername darf nur aus einem Wort bestehen");
                        continue;
                    } else if (cmds[1].length() > 1) {
                        bw.write("Bitte nur einen Buchstaben angeben.");
                        bw.newLine();
                        bw.flush();
                        continue;
                    }

                    bw.write(this.game.tryCharacter(cmds[1].toCharArray()[0]));
                    bw.newLine();
                    bw.flush();

                    if (game.isFinished()) {
                        bw.write("„Gratulation! Gesuchtes Wort erfolgreich gefunden. Neues Game startet…");
                        bw.newLine();
                        bw.flush();
                    }
                } else if (command.equalsIgnoreCase("Exit")) {
                    bw.write("Auf Wiedersehen. Bis zum nächsten mal.");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("Befehl wurde falsch geschrieben.");
                    bw.newLine();
                    bw.write(" Mögliche Befehle:");
                    bw.newLine();
                    bw.write(" <NAME>, <TRY>, <EXIT>");
                    bw.newLine();
                    bw.flush();


                }
            }


        } catch (IOException e) {
            try {
                throw new DataFileException("Fehler", e);
            } catch (DataFileException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
