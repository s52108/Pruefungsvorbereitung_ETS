package TransactionManager_Klausur;

import java.util.Objects;

public class Transaction {

    private int transactionID;
    private String itemName;
    private String currencyID;
    private double value;
    private String transactionDate;
    private int amount;

    public Transaction(int transactionID, String itemName, String currenryID, double value, String transactionDate, int amount) {
        this.transactionID = transactionID;
        this.itemName = itemName;
        this.currencyID = currenryID;
        this.value = value;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", itemName='" + itemName + '\'' +
                ", currenryID='" + currencyID + '\'' +
                ", value=" + value +
                ", transactionDate='" + transactionDate + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return transactionID == that.transactionID && Double.compare(that.value, value) == 0 && amount == that.amount && Objects.equals(itemName, that.itemName) && Objects.equals(currencyID, that.currencyID) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, itemName, currencyID, value, transactionDate, amount);
    }
}
