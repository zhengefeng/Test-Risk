package com.risk.dal.credit.dto;

import com.risk.dal.credit.entity.ConsumerTemplateDetail;

import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ConsumerTemplateDetailDto extends ConsumerTemplateDetail {

    private String startDate;

    private String endDate;

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
