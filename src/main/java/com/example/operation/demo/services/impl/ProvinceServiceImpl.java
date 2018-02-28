package com.example.operation.demo.services.impl;

import com.example.operation.demo.models.Province;
import com.example.operation.demo.repositories.ProvinceRepositories;
import com.example.operation.demo.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    private ProvinceRepositories provinceRepositories;


    @Override
    public List<Province> getAllProvince() {
        return provinceRepositories.getAllProvince();
    }
}
