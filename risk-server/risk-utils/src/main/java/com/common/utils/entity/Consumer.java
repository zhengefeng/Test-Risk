package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.util.Date;

/**
 * 客户
 * Created by zhenge.feng.
 */
public class Consumer {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("公司ID")
    private Integer companyId;
    
    @ColumnDesc("用户名")
    private String loginName;

    @ColumnDesc("真实姓名")
    private String name;

    @ColumnDesc("客户密码")
    private String password;

    @ColumnDesc("职位级别")
    private String rankLevel;

    @ColumnDesc("客户状态: 1 正常 2.已禁用")
    private Short status;

    @ColumnDesc("身份证号")
    private Integer cardId;

    @ColumnDesc("地址")
    private String address;

    @ColumnDesc("手机号")
    private Integer phone;
    
    @ColumnDesc("邮箱")
    private String mail;

    @ColumnDesc("操作人名称")
    private String operName;

    @ColumnDesc("创建时间")
    private Date  updateTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date createTime;

    public Consumer(Integer id, Integer companyId, String name, String password, String rankLevel, Short status, Integer cardId, String address, Integer phone, String operName) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.password = password;
        this.rankLevel = rankLevel;
        this.status = status;
        this.cardId = cardId;
        this.address = address;
        this.phone = phone;
        this.operName = operName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(String rankLevel) {
        this.rankLevel = rankLevel;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
    
}
