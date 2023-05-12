package TransactionManager_Klausur;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class TransactionClient implements Runnable {

    Socket socket;

    public TransactionClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<Transaction> trans;
                TransactionManager tm = null;

                if (line.startsWith("openFile")) {
                    String path = line.split(";")[1];
                    tm = new TransactionManager(path);
                    tm.load();
                    trans = tm.getTransactions();
                    bw.write("TransactionManager " + path + "loaded with");
                } else if (tm == null) {
                    bw.write("Please run command <openFile> first");
                    bw.newLine();
                    bw.flush();
                } else if (line.startsWith("findByDate ")) {
                    String date = line.split(" ")[1];
                    ArrayList<Transaction> transByDate = tm.findByDate(date);
                    for (Transaction transaction : transByDate) {
                        bw.write(transaction.toString());
                        bw.newLine();
                        bw.flush();

                    }
                } else if (line.equalsIgnoreCase("groupByItemName")) {
                    HashMap<String, ArrayList<Transaction>> temp = tm.groupByItemName();
                    for (String s : temp.keySet()) {
                        bw.write(s + temp.get(s).size() + " transaction");
                        bw.newLine();
                        bw.flush();
                    }
                } else if (line.startsWith("getAverageTransactionPrice ")) {
                    String name = line.split(" ")[1];
                    double avg = tm.getAverageTransactionPrice(name);
                    bw.write("average value of " + name + " is " + avg + " EUR ");
                    bw.newLine();
                    bw.flush();
                } else if (line.equalsIgnoreCase("Exit")) {
                    return;
                } else {
                    bw.write("");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (DataFileException e) {
            throw new RuntimeException(e);
        }


    }
}
