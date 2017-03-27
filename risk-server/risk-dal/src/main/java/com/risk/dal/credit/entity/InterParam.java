package com.risk.dal.credit.entity;

import java.io.Serializable;
import java.util.Date;

public class InterParam implements Serializable {
    private static final long serialVersionUID = -6192984985911144005L;
    private Integer id;

    private String interid;

    private String intercode;

    private String name;

    private String paramtype;

    private Short ismust;

    private Integer lengths;

    private String description;

    private String label;

    private Date updatetime;

    private Date createtime;

    public InterParam() {
    }

    public InterParam(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public InterParam(String name, String description, Integer lengths) {
        this.name = name;
        this.description = description;
        this.lengths = lengths;
    }

    public InterParam(String name,  String description, Integer lengths,String label) {
        this.name = name;
        this.lengths = lengths;
        this.description = description;
        this.label = label;
    }

    public InterParam(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterid() {
        return interid;
    }

    public void setInterid(String interid) {
        this.interid = interid == null ? null : interid.trim();
    }

    public String getIntercode() {
        return intercode;
    }

    public void setIntercode(String intercode) {
        this.intercode = intercode == null ? null : intercode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype == null ? null : paramtype.trim();
    }

    public Short getIsmust() {
        return ismust;
    }

    public void setIsmust(Short ismust) {
        this.ismust = ismust;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getLengths() {
        return lengths;
    }

    public void setLengths(Integer lengths) {
        this.lengths = lengths;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}