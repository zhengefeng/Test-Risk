package com.risk.dal.credit.mapper;

import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.entity.InterParam;
import com.risk.dal.credit.entity.Product;
import com.risk.dal.credit.entity.ProviderInter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhenge.feng.
 */
public interface ReportMapper {
    List<InterParam> getTemplateParams(@Param("templateId")Integer templateId);

    List<ProviderInter> getProviderInters(@Param("templateId")Integer templateId);

    List<InterParam> getInterParamsByPid(@Param("providerId")Integer providerId);

    List<Product>  getProducts(@Param("templateId")Integer templateId);

    Product getProductByPIid(@Param("providerInterId")Integer providerInterId);

    Consumer getConsumerByLoginName(@Param("loginName") String loginName);
}
