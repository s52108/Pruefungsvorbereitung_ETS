package TransactionManager_Klausur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionManager {
    private String path;
    private ArrayList<Transaction> transactions;

    public TransactionManager(String path) {
        this.path = path;
        transactions = new ArrayList<Transaction>();
    }

    public void load() throws DataFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] transactionData = line.split(";");
                if (transactionData.length != 6) {
                    throw new DataFileException("Zeile konnte nicht eingelesen werden" + line);
                }

                Transaction transaction = new Transaction(
                        Integer.parseInt(transactionData[0]),
                        transactionData[1],
                        transactionData[2],
                        Double.parseDouble(transactionData[3]),
                        transactionData[4],
                        Integer.parseInt(transactionData[5]));

                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new DataFileException("File does not exist", e);
        }


    }

    public HashMap<String, ArrayList<Transaction>> groupByItemName() {
        HashMap<String, ArrayList<Transaction>> result = new HashMap<>();

        for (Transaction transaction : transactions) {
            String itemName = transaction.getItemName();

            if (!result.containsKey(itemName)) {
                result.put(itemName, new ArrayList<>());

            }

            result.get(itemName).add(transaction);
        }

        return result;
    }

    public ArrayList<Transaction> findByDate(String date) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionDate().equals(date)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public double getAverageTransactionPrice(String itemName) {
        double sum = 0.0;
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getItemName().equals(itemName)) {
                sum += transaction.getAmount() * transaction.getValue();
                count++;
            }
        }
        return sum / count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


}
