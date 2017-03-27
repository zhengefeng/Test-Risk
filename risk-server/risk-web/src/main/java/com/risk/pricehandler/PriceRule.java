package com.risk.pricehandler;

/**
 * Created by zhenge.feng.
 */
public class PriceRule {
    private String queryType;
    private String statisType;
    private String fieldName;
    private double price;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getStaticType() {
        return statisType;
    }

    public void setStaticType(String staticType) {
        this.statisType = staticType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
