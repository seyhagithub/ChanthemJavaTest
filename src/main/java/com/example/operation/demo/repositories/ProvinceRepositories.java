package com.example.operation.demo.repositories;

import com.example.operation.demo.models.Province;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Repository
public interface ProvinceRepositories {

    /**
     * getAllOperation
     * @return
     */
    @Select("SELECT * FROM tblprovince")
    @Results(value = {
            @Result(property = "provinceId",column = "province_id"),
            @Result(property = "provinceDesc",column = "province_desc")
    })
    List<Province> getAllProvince();
}
