package PersonManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonServer3 {

    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(1111)) {
            while(true){
                System.out.println("Warte auf Client");
                Socket client = ss.accept();
                System.out.println("Client ist da");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
