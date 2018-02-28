package com.example.operation.demo.services.impl;

import com.example.operation.demo.models.ReceiptCode;
import com.example.operation.demo.repositories.ReceiptRepositories;
import com.example.operation.demo.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    private ReceiptRepositories receiptRepositories;

    @Override
    public List<ReceiptCode> getAllReceiptCode() throws Exception {
        return receiptRepositories.getAllReceiptCode();
    }

    @Override
    public ReceiptCode getReceiptCodeById(long id) throws Exception {
        return receiptRepositories.getReceiptCodeById(id);
    }
}
