package com.risk.biz.credit.impl;

import com.alibaba.fastjson.JSON;
import com.common.utils.seq.OrderSeqUtil;
import com.common.utils.spring.SpringWebSocketSessionUtils;
import com.risk.biz.credit.ConsumerTemplateDetailBiz;
import com.risk.biz.credit.ProductCallDetailBiz;
import com.risk.biz.credit.ProviderInterDetailBiz;
import com.risk.biz.credit.ReportBiz;
import com.risk.dal.credit.dto.ParamValidateDto;
import com.risk.dal.credit.dto.ProductResultDto;
import com.risk.dal.credit.entity.*;
import com.risk.dal.credit.mapper.ReportMapper;
import com.risk.dal.credit.mapper.TemplateMapper;
import com.risk.integration.util.HttpPostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

/**
 * 报告逻辑生成实现
 * Created by zhenge.feng.
 */
@Service
public class ReportBizImpl implements ReportBiz {

    @Autowired
    private ConsumerTemplateDetailBiz consumerTemplateDetailBiz;

    @Autowired
    private ProductCallDetailBiz productCallDetailBiz;

    @Autowired
    private ProviderInterDetailBiz providerInterDetailBiz;

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private TemplateMapper templateMapper;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public List<InterParam> getTemplateParamsList(Integer templateId) {
        return reportMapper.getTemplateParams(templateId);
    }

    @Override
    public String getTemplateParams(Integer templateId) {
        //直接调用后台接口方法，获取要填参数
        List<InterParam> params = reportMapper.getTemplateParams(templateId);
        String interParams = JSON.toJSONString(params);

        System.out.println(interParams);
        return interParams;
    }

    @Override
    public List<ProductResultDto> invoke(Integer templateId, Map paramMap, Consumer consumer, String sessionId) {
        List<ProductResultDto> resultList = new ArrayList<ProductResultDto>();

        //Consumer consumer = reportMapper.getConsumerByLoginName(userId);
        Template template = templateMapper.selectByPrimaryKey(templateId);

        List<ProviderInter> providerInters = reportMapper.getProviderInters(templateId);

        // future用于得到任务执行完之后的返回 值
        Future<String> future = executorService.submit(new Callable<String>() {
            //回调方法
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        try {
            // 得到线程结束后返回的结果
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //创建一个线程池，该线程池中有3个 线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                threadPool2);
        //提交10个任务
        for(int i = 0;i<10;i++){
            final int value1 = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //Thread.sleep(1000);
                    return value1;
                }
            });
        }

        try {
            //得到线程执行完之后的结果，那个线程任务先执行完就先返回，因为提交了10个任务
            //所以得到的时候也要分10次得到
            for (int i = 0; i < 10; i++) {
                System.out.println(completionService.take().get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (ProviderInter providerInter : providerInters) {
            TreeMap<String,String> postParamTree =  new TreeMap<String,String>();
            TreeMap<String,Object> initProviderParam = new TreeMap<String,Object>();
            List<InterParam> interParams = reportMapper.getTemplateParams(templateId);
            for (InterParam interParam : interParams) {
                postParamTree.put(interParam.getName(), (String) paramMap.get(interParam.getName()));
                initProviderParam.put(interParam.getName(),paramMap.get(interParam.getName()));
            }
            String result = HttpPostUtil.getHttpJsons(providerInter.getIntercode(),postParamTree);
            //String result = ReturnDataTest.morePersonInfo();
            Map resultMap = JSON.parseObject(result, Map.class);
            //Map dataMap = (Map) resultMap.get("data");
            //System.out.println(dataMap.isEmpty());
            if((boolean)resultMap.get("success")){
                //无论请求成功与否，insert 服务商接口调用明细
                ProviderInterDetail providerInterDetail2 = new ProviderInterDetail();
                providerInterDetail2.setProviderinterid(providerInter.getId());
                providerInterDetail2.setProvidercode(Integer.valueOf(providerInter.getProvidercode()));
                providerInterDetail2.setProviderintercode(providerInter.getIntercode());
                providerInterDetail2.setPrice(providerInter.getPrice());
                providerInterDetail2.setStatus(Short.valueOf("1"));
                providerInterDetail2.setParams(JSON.toJSONString(paramMap));
                providerInterDetail2.setReturncode(resultMap.get("success").toString());
                providerInterDetail2.setReturndata(JSON.toJSONString(resultMap.get("data")));
                providerInterDetail2.setStatus(new Short((String) resultMap.get("status")));
                providerInterDetailBiz.insert(providerInterDetail2);

                Product product = reportMapper.getProductByPIid(providerInter.getId());
                ProductCallDetail productCallDetail = new ProductCallDetail();
                productCallDetail.setProductid(product.getId());
                productCallDetail.setConsumerid(consumer.getId());
                productCallDetail.setCompanyid(consumer.getCompanyid());
                productCallDetail.setProductname(product.getName());
                productCallDetail.setPrice(providerInter.getPrice());
                productCallDetail.setStatus(Short.valueOf("1"));
                productCallDetail.setReturncode(resultMap.get("success").toString());
                productCallDetail.setReturndata(JSON.toJSONString(resultMap.get("data")));
                productCallDetailBiz.insert(productCallDetail);

                ProductResultDto resultDto = new ProductResultDto();
                resultDto.setProductId(Integer.valueOf(product.getId()));
                resultDto.setProductName(product.getName());
                resultDto.setInfoType(product.getInfotype());
                resultDto.setProductParam(initProviderParam);
                resultDto.setProductData(resultMap.get("data") == null ? null : JSON.parseObject(JSON.toJSONString(resultMap.get("data")),Map.class));
                resultList.add(resultDto);
                //httpSession.setAttribute("reportData",resultList);
                //System.out.println(httpSession.getAttribute("reportData"));
            }else {
                ProviderInterDetail providerInterDetail2 = new ProviderInterDetail();
                providerInterDetail2.setProvidercode(Integer.valueOf(providerInter.getProvidercode()));
                providerInterDetail2.setProviderinterid(providerInter.getId());
                providerInterDetail2.setProviderintercode(providerInter.getIntercode());
                providerInterDetail2.setPrice(BigDecimal.valueOf(0.00));
                providerInterDetail2.setStatus(Short.valueOf("2"));
                providerInterDetail2.setParams(JSON.toJSONString(paramMap));
                providerInterDetail2.setReturncode(resultMap.get("success").toString());
                providerInterDetail2.setReturndata(JSON.toJSONString(resultMap.get("errors")));
                providerInterDetailBiz.insert(providerInterDetail2);

                Product product = reportMapper.getProductByPIid(providerInter.getId());
                ProductCallDetail productCallDetail = new ProductCallDetail();
                productCallDetail.setProductid(product.getId());
                productCallDetail.setConsumerid(consumer.getId());
                productCallDetail.setCompanyid(consumer.getCompanyid());
                productCallDetail.setProductname(product.getName());
                productCallDetail.setPrice(BigDecimal.valueOf(0.00));
                productCallDetail.setStatus(Short.valueOf("2"));
                productCallDetail.setReturncode(resultMap.get("success").toString());
                productCallDetail.setReturndata(JSON.toJSONString(resultMap.get("errors")));
                productCallDetailBiz.insert(productCallDetail);

                ProductResultDto resultDto = new ProductResultDto();
                resultDto.setProductId(Integer.valueOf(product.getId()));
                resultDto.setProductName(product.getName());
                resultDto.setInfoType(product.getInfotype());
                resultDto.setProductParam(initProviderParam);
                resultDto.setProductData(resultMap);
                resultList.add(resultDto);

            }


        }
        ConsumerTemplateDetail consumerTemplateDetail = new ConsumerTemplateDetail();
        consumerTemplateDetail.setTemplateid(templateId);
        consumerTemplateDetail.setCompanyid(consumer.getCompanyid());
        consumerTemplateDetail.setConsumerid(consumer.getId());
        consumerTemplateDetail.setConsumername(consumer.getName());
        consumerTemplateDetail.setCardid((String) paramMap.get("idCard"));
        consumerTemplateDetail.setOrderid(new OrderSeqUtil().getNum());
        consumerTemplateDetail.setParams(JSON.toJSONString(paramMap));
        consumerTemplateDetail.setPersonname((String) paramMap.get("name"));
        consumerTemplateDetail.setTotalprice(template.getTotalprice());
        consumerTemplateDetail.setReturndata(JSON.toJSONString(resultList));

        consumerTemplateDetailBiz.insert(consumerTemplateDetail);

        Map<String, Integer> tmpMap = new HashMap<>();
        tmpMap.put("id", consumerTemplateDetail.getId());
        SpringWebSocketSessionUtils.sendMessage(sessionId, JSON.toJSONString(tmpMap));
        return resultList;
    }

    @Override
    public ParamValidateDto validateParams(Integer templateId, Map param) {
        List<InterParam> interParams = reportMapper.getTemplateParams(templateId);
        List<Map<String,String>> validateInfos = new ArrayList<>();
        for (Object key : param.keySet()) {
            for (InterParam interParam : interParams) {
                if(key.toString().equals(interParam.getName())){
                    if( param.get(key)==null ||"".equals(param.get(key))){
                        Map<String,String> validateSingle =  new HashMap<>();
                        handlerErrorMsgMap(validateSingle, interParam.getName(), interParam.getDescription()+"不能为空");
                        validateInfos.add(validateSingle);
                    }else if( param.get(key).toString().length() > (int)interParam.getLengths() && !"".equals(JSON.toJSONString(param.get(key)))){
                        Map<String,String> validateSingle =  new HashMap<>();
                        handlerErrorMsgMap(validateSingle, interParam.getName(),interParam.getDescription()+"不能超过长度最大值");
                        validateInfos.add(validateSingle);
                    }
                }
            }

        }
        ParamValidateDto paramValidateDto = new ParamValidateDto();
        paramValidateDto.setValiateInfos(validateInfos);

        return paramValidateDto;
    }

    private void handlerErrorMsgMap(Map<String, String> map, String name, String desc) {
        map.put("name", name);
        map.put("msg", desc);
    }
}
