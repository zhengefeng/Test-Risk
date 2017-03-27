package com.risk.form;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2016/8/24.
 */
public class TemplateUpdateForm {

    @NotNull
    private Integer id;

    @NotNull
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
