package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.util.Date;

/**
 * 公司
 * Created by zhenge.feng.
 */
public class Company {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("公司名称")
    private String companyName;

    @ColumnDesc("公司是否有业务往来 1 正常 2.已禁用")
    private Short status;

    @ColumnDesc("操作人名称")
    private String operName;

    @ColumnDesc("创建时间")
    private Date createTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date updateTime;

    public Company() {
    }

    public Company(Integer id, String companyName, Short status, String operName) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
