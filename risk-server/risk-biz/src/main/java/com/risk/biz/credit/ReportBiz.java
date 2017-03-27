package com.risk.biz.credit;

import java.util.List;
import java.util.Map;

import com.risk.dal.credit.dto.ParamValidateDto;
import com.risk.dal.credit.dto.ProductResultDto;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.entity.InterParam;

/**
 * 报告生成逻辑
 * Created by zhenge.feng.
 */
public interface ReportBiz {

    /**
     * 根据模板id查询模板参数
     * @param templateId
     * @return
     */
    public List<InterParam> getTemplateParamsList(Integer templateId);

    public String getTemplateParams(Integer templateId);

    public  List<ProductResultDto> invoke(Integer templateId, Map paramMap, Consumer consumer, String id);

    public ParamValidateDto validateParams(Integer templateId, Map paramMap);

}
