package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.NotDbColumn;
import com.common.utils.table.TimeStampAuto;

import java.util.Date;

/**
 * 接口参数
 * Created by zhenge.feng.
 */
public class InterParam {
    @IncrementAuto
    private Integer id;

    @ColumnDesc("服务商接口id")
    private String interId;

    @ColumnDesc("服务商接口code(uri)")
    private String interCode;

    @ColumnDesc("服务商接口参数名称")
    private String name;

    @NotDbColumn
    private String value;

    @ColumnDesc("接口参数数据类型")
    private String paramType;

    @ColumnDesc("是否必填")
    private Boolean isMust;

    @ColumnDesc("描述")
    private String description;

    @ColumnDesc("创建时间")
    private Date updateTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterId() {
        return interId;
    }

    public void setInterId(String interId) {
        this.interId = interId;
    }

    public String getInterCode() {
        return interCode;
    }

    public void setInterCode(String interCode) {
        this.interCode = interCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Boolean getMust() {
        return isMust;
    }

    public void setMust(Boolean must) {
        isMust = must;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
