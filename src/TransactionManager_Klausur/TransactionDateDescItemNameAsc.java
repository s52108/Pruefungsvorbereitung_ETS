package TransactionManager_Klausur;

import java.util.Comparator;

public class TransactionDateDescItemNameAsc implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {

        int res = o2.getTransactionDate().compareTo(o1.getTransactionDate());

        if (res == 0) {
            o1.getItemName().compareTo(o2.getItemName());
        }

        return res;
    }
}

