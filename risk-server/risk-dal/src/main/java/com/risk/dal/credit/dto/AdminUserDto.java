package com.risk.dal.credit.dto;

import java.io.Serializable;

/**
 * 后台op用户
 * Created by zhenge.feng.
 */
public class AdminUserDto implements Serializable{
    private static final long serialVersionUID = -1305981073864144384L;

    private Integer id;

    private String userName;//用户名

    private String realName;//真实姓名

    private String phone;//手机号

    private String email;//邮件

    private String companyName;//公司

    private Integer roleType;//角色类型

    private Integer status;//状态  0 正常，1 冻结

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
