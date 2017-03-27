package com.risk.dal.credit.dto;

import com.risk.dal.credit.entity.ProviderInter;

import java.io.Serializable;

/**
 * 服务商接口
 * Created by zhenge.feng.
 */
public class ProviderInterDto extends ProviderInter implements Serializable{

    public ProviderInterDto(Integer id, Integer productid, String intercode) {
        super(id, productid, intercode);
    }
}
