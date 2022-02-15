package com.company.Array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Transaction
{
    String name;        // Transaction name
    String record;        // Data object from the database
    int timestamp;      // Timestamp of the current transaction
    char operation;     // Operation type: Read/Write

    public Transaction(String name, String record, int timestamp, char operation)
    {
        this.name = name;
        this.record = record;
        this.timestamp = timestamp;
        this.operation = operation;
    }
}

public class ReadWriteConflicts {
    /*

    Given a list of database transactions, find all read-write conflicts among them. Assume that there is no strict two-phase locking (Strict 2PL) protocol to prevent read-write conflicts.

    Each database transaction is given in the form of a tuple. A tuple (T, A, t, R) indicates that a transaction T accessed a database record A at a time t, and a read operation is performed on the record.

    Assume that a data conflict happens when two transactions access the same record in the database within an interval of 5 units. At least one write operation is performed on the record.

    Input:

    transactions = [
        (T1, A, 0, R),
        (T2, A, 2, W),
        (T3, B, 4, W),
        (T4, C, 5, W),
        (T5, B, 7, R),
        (T6, C, 8, W),
        (T7, A, 9, R)
    ]

    Output: {(T1, T2, RW), (T3, T5, WR), (T4, T6, WW)}

    Explanation:

    • Transaction T1 and T2 are involved in RW conflict.
    • Transaction T3 and T5 are involved in WR conflict.
    • Transaction T4 and T6 are involved in WW conflict.

    */
    public static Set<Tuple<String, String, String>> selectTransaction(List<Transaction> transactions){
        Set<Tuple<String, String, String>> set = new HashSet<>();

        transactions.sort((a, b) ->{
            if (!a.record.equals(b.record))
                return a.record.compareTo(b.record);
            return a.timestamp - b.timestamp;
        });

        for (int i = 0; i < transactions.size(); i++){
            int j = i - 1;
            while (j >= 0 && transactions.get(i).record.equals(transactions.get(j).record) && transactions.get(i).timestamp <= transactions.get(j).timestamp + 5){
                if (transactions.get(i).operation == 'W' || transactions.get(j).operation == 'W'){
                    set.add(Tuple.of(transactions.get(j).name, transactions.get(i).name, transactions.get(j).operation + "" + transactions.get(i).operation));
                }

                j--;
            }
        }

        return set;
    }
}
