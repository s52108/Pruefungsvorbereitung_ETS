package PersonManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PersonClient2 {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 1111);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
             ObjectInputStream ois = new ObjectInputStream(client.getInputStream())) {

            bw.write("GETALL");
            bw.newLine();
            bw.flush();

            Person2 person2;


            while ((person2 = (Person2) ois.readObject()) != null) {
                System.out.println(person2);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
