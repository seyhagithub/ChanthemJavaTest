package com.example.operation.demo.models;

/**
 * Created by hiemseyha on 2/27/18.
 */
public class Operation {

    private long operationCode;
    private String operationDesc;
    private long receiptCode;
    private float price;
    private float defaultDLT;
    private float defaultWage;


    public long getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(long operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public long getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(long receiptCode) {
        this.receiptCode = receiptCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDefaultDLT() {
        return defaultDLT;
    }

    public void setDefaultDLT(float defaultDLT) {
        this.defaultDLT = defaultDLT;
    }

    public float getDefaultWage() {
        return defaultWage;
    }

    public void setDefaultWage(float defaultWage) {
        this.defaultWage = defaultWage;
    }
}
