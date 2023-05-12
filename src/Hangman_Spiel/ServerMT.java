package Hangman_Spiel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111)) {


            while (true) {
                System.out.println("Warte auf Client");

                Socket client = ss.accept();
                System.out.println("Client wurde verbunden");
                HangmanClient hc = new HangmanClient(new Game(), client);

                new Thread(hc).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}