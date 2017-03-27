package com.risk.integration.api;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuarenteeInfo {
    private String org;
    private String sname;
    private String scerttype;
    private String scertno;

    private String ioccursum;




    private String istate;
    private String saccount;

    public String getIoccursum() {
        return ioccursum;
    }

    public void setIoccursum(String ioccursum) {
        this.ioccursum = ioccursum;
    }

    public String getIstate() {
        return istate;
    }

    public void setIstate(String istate) {
        this.istate = istate;
    }

    public String getSaccount() {
        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount;
    }



    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScerttype() {
        return scerttype;
    }

    public void setScerttype(String scerttype) {
        this.scerttype = scerttype;
    }

    public String getScertno() {
        return scertno;
    }

    public void setScertno(String scertno) {
        this.scertno = scertno;
    }
}
