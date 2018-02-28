package com.example.operation.demo.services.impl;

import com.example.operation.demo.models.Operation;
import com.example.operation.demo.repositories.OperationRepositories;
import com.example.operation.demo.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepositories operationRepositories;


    @Override
    public boolean saveOperation(Operation operation) throws Exception {
        if (operation == null) {
            return false;
        }
        return operationRepositories.saveOperation(operation);
    }

    @Override
    public boolean deleteOperationById(long id) throws Exception {

        return operationRepositories.deleteOperationById(id);
    }

    @Override
    public List<Operation> getAllOperation() {
        return operationRepositories.getAllOperation();
    }
}
