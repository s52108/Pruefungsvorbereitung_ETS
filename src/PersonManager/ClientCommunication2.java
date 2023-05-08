package PersonManager;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication2 {

    private Socket client;

    public ClientCommunication2(Socket client) {
        this.client = client;
    }

    private void handleCommands() {

        ArrayList<Person2> people2 = new PersonLoader("src/PersonManager/persons.csv").load();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
             ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {
            String command;
            while ((command = br.readLine()) != null) {
                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Client wants to exit");
                    break;
                }

                if (command.equalsIgnoreCase("getall")) {
                    System.out.println("Alle Personen");
                    for (Person2 person2 : people2) {
                        oos.writeObject(person2);

                    }
                    oos.writeObject(null);


                } else {
                    String[] cmds = command.split(" ");
                    if (cmds.length != 2) {
                        System.out.println("Command Error");
                        oos.writeObject(null);
                    } else {
                        int desiredID = Integer.parseInt(cmds[1]);
                        for (Person2 person2 : people2) {
                            if (person2.getId() == desiredID) {
                                oos.writeObject(person2);
                            }


                        }

                    }
                }
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
