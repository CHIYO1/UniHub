package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Transaction;
import java.util.List;

public class TransactionsListData {
    private int total_count;
    private List<Transaction> transactions;

    public TransactionsListData(int total_count, List<Transaction> transactions) {
        this.total_count = total_count;
        this.transactions = transactions;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TransactionsListData{" +
                "total_count=" + total_count +
                ", transactions=" + transactions +
                '}';
    }
}
