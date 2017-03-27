package com.risk.dal.credit.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户用户
 */
public class AdminUser implements Serializable{
	
    private static final long serialVersionUID = 4443662081821960701L;

	@IncrementAuto
	private Integer id;

	@ColumnDesc("用户名称")
    private String userName;

	@ColumnDesc("用户密码")
    private String password;

	@ColumnDesc("真实姓名")
    private String realName;

	@ColumnDesc("手机号")
    private String phone;

	@ColumnDesc("邮件")
    private String email;

	@ColumnDesc("状态: 1正常 2冻结")
    private Integer status;

	@ColumnDesc("操作员类型:01 管理 02普通用户")
	private Integer operType;


	@ColumnDesc("更新时间")
	private Date updateTime;

	@TimeStampAuto
    private Date createTime;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getOperType() {
		return operType;
	}

	public void setOperType(Integer operType) {
		this.operType = operType;
	}
}