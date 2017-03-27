package com.risk.dal.credit.dto;

/**
 * Created by Administrator on 2016/8/31.
 */
public class StatisticsPersonDto {

    private Integer allQueryCount;
    private Integer allQueryCompanyCount;

    private Integer threeMonthQueryCount;
    private Integer threeMonthQueryCompanyCount;

    private Integer sixMonthQueryCount;
    private Integer sixMonthQueryCompanyCount;

    public Integer getAllQueryCount() {
        return allQueryCount;
    }

    public void setAllQueryCount(Integer allQueryCount) {
        this.allQueryCount = allQueryCount;
    }

    public Integer getAllQueryCompanyCount() {
        return allQueryCompanyCount;
    }

    public void setAllQueryCompanyCount(Integer allQueryCompanyCount) {
        this.allQueryCompanyCount = allQueryCompanyCount;
    }

    public Integer getThreeMonthQueryCount() {
        return threeMonthQueryCount;
    }

    public void setThreeMonthQueryCount(Integer threeMonthQueryCount) {
        this.threeMonthQueryCount = threeMonthQueryCount;
    }

    public Integer getThreeMonthQueryCompanyCount() {
        return threeMonthQueryCompanyCount;
    }

    public void setThreeMonthQueryCompanyCount(Integer threeMonthQueryCompanyCount) {
        this.threeMonthQueryCompanyCount = threeMonthQueryCompanyCount;
    }

    public Integer getSixMonthQueryCount() {
        return sixMonthQueryCount;
    }

    public void setSixMonthQueryCount(Integer sixMonthQueryCount) {
        this.sixMonthQueryCount = sixMonthQueryCount;
    }

    public Integer getSixMonthQueryCompanyCount() {
        return sixMonthQueryCompanyCount;
    }

    public void setSixMonthQueryCompanyCount(Integer sixMonthQueryCompanyCount) {
        this.sixMonthQueryCompanyCount = sixMonthQueryCompanyCount;
    }
}
