package com.example.operation.demo.controllers;

import com.example.operation.demo.models.Province;
import com.example.operation.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/getAllOperation", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllOperation() {
        Map<String, Object> map = new HashMap<>();
        List<Province> provinceList = new ArrayList<>();
        try {

            provinceList = provinceService.getAllProvince();

            map.put("data", provinceList);

            if (provinceList.size() > 0) {

                responseInfoClient(map, "200", true, "Success");
            } else {
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
