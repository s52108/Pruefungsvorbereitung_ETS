package PersonManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonServer2 {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111)) {

            while (true) {
                System.out.println("Wait for Client");
                Socket client = ss.accept();
                System.out.println("Client ready");

                ClientCommunication2 cc = new ClientCommunication2(client);
                // cc.start();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
