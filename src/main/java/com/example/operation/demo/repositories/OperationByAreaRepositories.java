package com.example.operation.demo.repositories;

import com.example.operation.demo.models.OperationArea;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hiemseyha on 2/27/18.
 */
@Repository
public interface OperationByAreaRepositories {

    /**
     * saveOperation
     * @param operationArea
     * @return
     * @throws Exception
     */
    @Insert("INSERT INTO tblarea(area_id, province_area, dlt_charge, wage) " +
            "VALUES(#{areaId}, #{provinceArea}, #{dtlCharge}, #{wage})")
    boolean saveOperationArea(OperationArea operationArea) throws Exception;


    /**
     * deleteOperationById
     * @param id
     * @return
     * @throws Exception
     */
    @Delete("DELETE FROM tblarea WHERE area_id = #{areaId}")
    boolean deleteOperationAreaById(long id) throws Exception;


    /**
     * getAllOperation
     * @return
     */
    @Select("SELECT * FROM tblarea")
    @Results(value = {
            @Result(property = "areaId",column = "area_id"),
            @Result(property = "provinceArea",column = "province_area"),
            @Result(property = "dtlCharge",column = "dlt_charge"),
            @Result(property = "wage",column = "wage")
    })
    List<OperationArea> getAllOperationArea();
}
