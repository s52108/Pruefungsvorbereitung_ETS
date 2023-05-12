package Urlaub;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111)) {


            while (true) {
                System.out.println("Warte auf Client");
                Socket client = ss.accept();

                System.out.println("Client verbunden");
                UrlaubClient uc = new UrlaubClient(client);
                new Thread(uc).start();
                //uc.run();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
