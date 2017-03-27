package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class PersonCredit {
    private RepayInfo[] repayInfo;
    private AcctInfo acctInfo;
    private GuarenteeInfo[] guarenteeInfo;

    public RepayInfo[] getRepayInfo() {
        return repayInfo;
    }

    public PersonCredit setRepayInfo(RepayInfo[] repayInfo) {
        this.repayInfo = repayInfo;
        return this;
    }

    public AcctInfo getAcctInfo() {
        return acctInfo;
    }

    public PersonCredit setAcctInfo(AcctInfo acctInfo) {
        this.acctInfo = acctInfo;
        return this;
    }

    public GuarenteeInfo[] getGuarenteeInfo() {
        return guarenteeInfo;
    }

    public void setGuarenteeInfo(GuarenteeInfo[] guarenteeInfo) {
        this.guarenteeInfo = guarenteeInfo;
    }
}
