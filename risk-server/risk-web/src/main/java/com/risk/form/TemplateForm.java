package com.risk.form;

import com.risk.dal.credit.entity.Template;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class TemplateForm extends Template {

    private List<TemplateInterForm> detailList;

    public List<TemplateInterForm> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TemplateInterForm> detailList) {
        this.detailList = detailList;
    }
}
