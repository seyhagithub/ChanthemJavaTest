package com.example.operation.demo.services;

import com.example.operation.demo.models.Operation;
import org.apache.ibatis.annotations.Insert;


import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */

public interface OperationService {


    boolean saveOperation(Operation operation) throws Exception;


    boolean deleteOperationById(long id) throws Exception;

    List<Operation> getAllOperation();

}
