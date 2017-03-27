package com.risk.integration.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by li on 2015/11/9.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetSpecRrade extends RetBase {
    private SpecRrade[] data;

    public SpecRrade[] getData() {
        return data;
    }

    public void setData(SpecRrade[] data) {
        this.data = data;
    }

    public String toString() {
        return super.toString() + ",data:" +  toString(data) + "";
    }
}
