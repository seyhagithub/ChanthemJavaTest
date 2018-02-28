package com.example.operation.demo.repositories;

import com.example.operation.demo.models.Operation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Repository
public interface OperationRepositories {

    /**
     * saveOperation
     * @param operation
     * @return
     * @throws Exception
     */
    @Insert("INSERT INTO tbloperation(operation_code, operation_desc, receipt_code, price, dlt_charge, wage) " +
            "VALUES(#{operationCode}, #{operationDesc}, #{receiptCode}, #{price}, #{defaultDLT}, #{defaultWage})")
    boolean saveOperation(Operation operation) throws Exception;


    /**
     * deleteOperationById
     * @param id
     * @return
     * @throws Exception
     */
    @Delete("DELETE FROM tbloperation WHERE operation_code = #{operationCode}")
    boolean deleteOperationById(long id) throws Exception;


    /**
     * getAllOperation
     * @return
     */
    @Select("SELECT * FROM tbloperation")
    @Results(value = {
            @Result(property = "operationCode",column = "operation_code"),
            @Result(property = "operationDesc",column = "operation_desc"),
            @Result(property = "receiptCode",column = "receipt_code"),
            @Result(property = "price",column = "price"),
            @Result(property = "defaultDLT",column = "dlt_charge"),
            @Result(property = "defaultWage",column = "wage")
    })
    List<Operation> getAllOperation();

}
