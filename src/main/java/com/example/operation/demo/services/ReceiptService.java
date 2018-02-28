package com.example.operation.demo.services;

import com.example.operation.demo.models.ReceiptCode;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */

public interface ReceiptService {

    List<ReceiptCode> getAllReceiptCode() throws Exception;

    ReceiptCode getReceiptCodeById(long id) throws Exception;
}
