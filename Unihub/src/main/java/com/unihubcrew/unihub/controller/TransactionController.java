package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.TransactionsListData;
import com.unihubcrew.unihub.service.TransactionService;
import com.unihubcrew.unihub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/id")
    public ApiResponse<Transaction> getTransactionById(@RequestParam Long recordId) {
        try{
            Transaction transaction=transactionService.getTransactionById(recordId);

            return ApiResponse.success("获取交易详情成功",transaction);
        } catch (Exception e) {
            return ApiResponse.failed("获取交易详情失败："+e.getMessage());
        }
    }

    @GetMapping("/all")
    public ApiResponse<TransactionsListData> getAllTransactions(
            @RequestParam(value = "userId", required = false)String userId,
            @RequestParam(value = "merchantId", required = false)String merchantId,
            @RequestParam(value = "resourceId", required = false)Long resourceId
    ) {
        try{
            List<Transaction> transactions = transactionService.getAllTransactions(userId,merchantId,resourceId);
            TransactionsListData transactionsListData=new TransactionsListData(transactions.size(),transactions);

            return ApiResponse.success("获取交易记录成功",transactionsListData);
        }catch (Exception e){
            return ApiResponse.failed("获取交易记录失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addTransaction(@RequestBody Transaction transaction) {
        try{
            Long recordId = transactionService.addTransaction(transaction);
            Map<String,Long> map = new HashMap<>();
            map.put("record_id", recordId);

            return ApiResponse.success("创建交易记录成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("创建交易记录失败"+e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ApiResponse<Void> updateTransaction(
            @RequestParam Long recordId,
            @RequestParam String status,
            @RequestParam String remarks
    ) {
        try{
            transactionService.updateTransaction(recordId,status,remarks);

            return ApiResponse.success("更新交易记录成功",null);
        } catch (Exception e) {
            return ApiResponse.failed("更新交易记录失败："+e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
