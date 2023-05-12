package DateiServer_Klausur.fileserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111)) {
            System.out.println("Warte auf den Client");
            Socket client = ss.accept();
            System.out.println("Client wurde verbunden");

            ClientHandler ch = new ClientHandler(client, "data/");

            new Thread(ch).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


