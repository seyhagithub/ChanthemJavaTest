package com.example.operation.demo.services.impl;

import com.example.operation.demo.models.Operation;
import com.example.operation.demo.models.OperationArea;
import com.example.operation.demo.repositories.OperationByAreaRepositories;
import com.example.operation.demo.services.OperationByAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Service
public class OperationByAreaServiceServiceImpl implements OperationByAreaService {

    @Autowired
    private OperationByAreaRepositories operationByAreaRepositories;


    @Override
    public boolean saveOperationArea(OperationArea operationArea) throws Exception {
        if (operationArea == null) {
            return  false;
        }
        return operationByAreaRepositories.saveOperationArea(operationArea);
    }

    @Override
    public boolean deleteOperationAreaById(long id) throws Exception {
        return operationByAreaRepositories.deleteOperationAreaById(id);
    }

    @Override
    public List<OperationArea> getAllOperationArea() {
        return operationByAreaRepositories.getAllOperationArea();
    }




}
