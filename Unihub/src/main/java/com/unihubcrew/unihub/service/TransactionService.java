package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.TransactionMapper;
import com.unihubcrew.unihub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    public Transaction getTransactionById(Long id) {
        return transactionMapper.getTransactionById(id);
    }

    public List<Transaction> getAllTransactions(String userId,String merchantId,Long resourceId) {
        return transactionMapper.getAllTransactions(userId,merchantId,resourceId);
    }

    public Long addTransaction(Transaction transaction) {
        transactionMapper.addTransaction(transaction);
        return transaction.getRecordId();
    }

    public void updateTransaction(Long recordId,String status,String remarks) {
        transactionMapper.updateTransaction(recordId,status,remarks);
    }

    public void deleteTransaction(Long id) {
        transactionMapper.deleteTransaction(id);
    }
}
