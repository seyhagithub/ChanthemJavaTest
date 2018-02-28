package com.example.operation.demo.controllers;

import com.example.operation.demo.models.Operation;
import com.example.operation.demo.services.OperationService;
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
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveOperation(@RequestBody Operation operation) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (operationService.saveOperation(operation)) {
                responseInfoClient(map, "200", true, "Insert Data Successful");
            } else {
                responseInfoClient(map, "400", false, "Bad Request");
            }
        }catch (Exception e){
            responseInfoClient(map, "500", false, "Internal Server Error");
            e.printStackTrace();
        }

        return  new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteOperation(@PathVariable long id) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (operationService.deleteOperationById(id)) {
                responseInfoClient(map, "200", true, "Deleted Data Successful");
            } else {
                responseInfoClient(map, "404", false, "Code Not Found");
            }
        }catch (Exception e){
            responseInfoClient(map, "500", false, "Internal Server Error");
            e.printStackTrace();
        }

        return  new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllOperation", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllOperation() {
        Map<String, Object> map = new HashMap<>();
        List<Operation> operationList = new ArrayList<>();
        try {

            operationList = operationService.getAllOperation();

            if (operationList.size() > 0) {
                map.put("data", operationList);
                responseInfoClient(map, "200", true, "Success");
            } else {
                map.put("data", operationList);
                responseInfoClient(map, "404", true, "Data Not Found");
            }

        }catch (Exception e){

            responseInfoClient(map, "500", false, "Internal Server Error");
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
