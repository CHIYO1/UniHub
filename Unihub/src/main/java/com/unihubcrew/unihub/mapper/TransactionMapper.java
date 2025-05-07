package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Transaction;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface TransactionMapper {
    @Select("SELECT * FROM transactions WHERE record_id= #{id} ")
    Transaction getTransactionById(Long id);

    List<Transaction> getAllTransactions(
            @Param("userId")String userId,
            @Param("merchantId")String merchantId,
            @Param("resourceId")Long resourceId
    );

    @Insert("INSERT INTO transactions(record_id, user_id,merchant_id,resource_id,quantity,status,remarks)"+
            "VALUES(#{recordId},#{userId},#{merchantId},#{resourceId},#{quantity},#{status},#{remarks})")
    @Options(useGeneratedKeys = true,keyProperty = "recordId")
    void addTransaction(Transaction transaction);

    @Insert("UPDATE transactions SET status=#{status},remarks=#{remarks} "+
            "WHERE record_id=#{recordId}")
    void updateTransaction(
            @Param("recordId") Long id,
            @Param("status") String status,
            @Param("remarks") String remarks
    );

    @Delete("DELETE FROM transactions WHERE record_id=#{id}")
    void deleteTransaction(Long id);
}
