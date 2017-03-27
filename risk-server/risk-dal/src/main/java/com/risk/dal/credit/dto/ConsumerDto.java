package com.risk.dal.credit.dto;



import java.io.Serializable;

/**
 * 商户客户
 * Created by zhenge.feng.
 */
public class ConsumerDto  implements Serializable {
    private static final long serialVersionUID = 8963363924956909218L;

    private Integer id;

    private Integer companyName;//公司名称

    private String name;    //客户名称

    private String rankLevel; //职位级别

    private Short status;  //客户状态: 1 正常 2.已禁用

    private Integer cardId;  //身份证号

    private String address;  //地址

    private Integer phone;   //手机号

    public ConsumerDto(Integer id, Integer companyName, String name, String rankLevel, Short status, Integer cardId, String address, Integer phone) {
        this.id = id;
        this.companyName = companyName;
        this.name = name;
        this.rankLevel = rankLevel;
        this.status = status;
        this.cardId = cardId;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Integer companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
