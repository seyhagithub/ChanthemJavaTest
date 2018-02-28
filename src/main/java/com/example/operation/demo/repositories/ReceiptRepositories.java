package com.example.operation.demo.repositories;

import com.example.operation.demo.models.ReceiptCode;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Repository
public interface ReceiptRepositories {

    /**
     * getAllReceiptCode
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM tblreceipt_code")
    @Results(value = {
            @Result(property = "receiptCode",column = "receipt_code"),
            @Result(property = "receiptDesc",column = "receipt_desc")
    })
    List<ReceiptCode> getAllReceiptCode() throws Exception;


    /**
     * getAllReceiptCode
     * @param id
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM tblreceipt_code WHERE receipt_code = #{receiptCode}")
    @Results(value = {
            @Result(property = "receiptCode",column = "receipt_code"),
            @Result(property = "receiptDesc",column = "receipt_desc")
    })
    ReceiptCode getReceiptCodeById(long id) throws Exception;
}
