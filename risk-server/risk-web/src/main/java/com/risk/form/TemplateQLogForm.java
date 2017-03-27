package com.risk.form;

import com.risk.dal.credit.entity.ConsumerTemplateDetail;
import com.risk.dto.BasePage;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/8/26.
 */
public class TemplateQLogForm extends BasePage {

    private String orderid;

    private String personname;

    private String cardid;

    private String consumername;

    private Integer consumerid;

    private Integer companyid;

    @Size(max = 10)
    private String startDate;

    @Size(max = 10)
    private String endDate;

    public Integer getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Integer consumerid) {
        this.consumerid = consumerid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getConsumername() {
        return consumername;
    }

    public void setConsumername(String consumername) {
        this.consumername = consumername;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
