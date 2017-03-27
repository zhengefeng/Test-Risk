package com.risk.dal.credit.dto;

import com.risk.dal.credit.entity.Template;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class TemplateDetailDto extends Template {
    private List<InterDto> types;

    public List<InterDto> getTypes() {
        return types;
    }

    public void setTypes(List<InterDto> types) {
        this.types = types;
    }
}
