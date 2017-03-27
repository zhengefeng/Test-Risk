package com.risk.integration.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * Created by li on 2015/11/9.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetSHShare extends RetBase {
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String toString() {
        return super.toString() + ",data:" +  data.toString() + "";
    }
}
