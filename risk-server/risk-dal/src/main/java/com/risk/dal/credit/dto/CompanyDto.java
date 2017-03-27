package com.risk.dal.credit.dto;



import java.io.Serializable;

/**
 * 公司(商户)
 * Created by zhenge.feng.
 */
public class CompanyDto  implements Serializable {
    private static final long serialVersionUID = 2532302635625052182L;

    private Integer id;

    private String companyName; //公司名称

    private Short status;      //公司状态 1正常 2已无业务往来

    private String operName;   //操作人名称

    public CompanyDto(Integer id, String companyName, Short status, String operName) {
        this.id = id;
        this.companyName = companyName;
        this.status = status;
        this.operName = operName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }
}
