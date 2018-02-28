package com.example.operation.demo.controllers;

import com.example.operation.demo.models.Operation;
import com.example.operation.demo.models.ReceiptCode;
import com.example.operation.demo.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @RequestMapping(value = "/getAllReceiptCode", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllReceiptCode() {
        Map<String, Object> map = new HashMap<>();
        List<ReceiptCode> receiptCodeList = new ArrayList<>();
        try {
            receiptCodeList = receiptService.getAllReceiptCode();
            map.put("data", receiptCodeList);
            if (receiptCodeList.size() > 0) {

                responseInfoClient(map,"200", true, "Success");
            } else {

                responseInfoClient(map,"404", false, "Data Not Found");
            }
        }catch (Exception e){
            responseInfoClient(map,"500", false, "Failed");
            e.printStackTrace();
        }

        return  new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/getReceiptCodeById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getReceiptCodeById(@PathVariable long id) {
        Map<String, Object> map = new HashMap<>();
        ReceiptCode receiptCode = null;
        try {
            receiptCode = receiptService.getReceiptCodeById(id);
            map.put("data", receiptCode);
            if (receiptCode != null) {
                responseInfoClient(map,"200", true, "Success");
            } else {
                responseInfoClient(map,"404", false, "Data Not Found");
            }
        }catch (Exception e){
            responseInfoClient(map,"500", false, "Failed");
            e.printStackTrace();
        }

        return  new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }


    //TODO ============= Response message to notify user ============
    private void responseInfoClient(Map<String, Object> map, String code, boolean status, String message) {
        map.put("code", code);
        map.put("status", status);
        map.put("message", message);
    }
}
