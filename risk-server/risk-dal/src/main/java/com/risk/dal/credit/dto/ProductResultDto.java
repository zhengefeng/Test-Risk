package com.risk.dal.credit.dto;


import java.util.Map;

/**
 * Created by Administrator on 2016/8/29.
 */
public class ProductResultDto {


    private Integer productId;

    private String productName;

    private String infoType;

    private Map<String,Object> productParam;

    private Map<String, Object> productData;

    public ProductResultDto() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Map<String, Object> getProductParam() {
        return productParam;
    }

    public void setProductParam(Map<String, Object> productParam) {
        this.productParam = productParam;
    }

    public Map<String, Object> getProductData() {
        return productData;
    }

    public void setProductData(Map<String, Object> productData) {
        this.productData = productData;
    }
}
