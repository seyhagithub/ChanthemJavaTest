package com.example.operation.demo.services;

import com.example.operation.demo.models.OperationArea;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
public interface OperationByAreaService {

    boolean saveOperationArea(OperationArea operationArea) throws Exception;

    boolean deleteOperationAreaById(long id) throws Exception;

    List<OperationArea> getAllOperationArea();
}
