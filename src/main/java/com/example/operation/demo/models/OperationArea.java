package com.example.operation.demo.models;

/**
 * Created by hiemseyha on 2/27/18.
 */
public class OperationArea {

    private long areaId;
    private String provinceArea;
    private float dtlCharge;
    private float wage;

    public long getProvinceId() {
        return areaId;
    }

    public void setProvinceId(long areaId) {
        this.areaId = areaId;
    }

    public String getProvinceArea() {
        return provinceArea;
    }

    public void setProvinceArea(String provinceArea) {
        this.provinceArea = provinceArea;
    }

    public float getDtlCharge() {
        return dtlCharge;
    }

    public void setDtlCharge(float dtlCharge) {
        this.dtlCharge = dtlCharge;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }
}
