package com.risk.op.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.CompanyBiz;
import com.risk.dal.credit.entity.Company;
import com.risk.op.pojo.form.DataTableResult;

/**
 * 
 * @author chenwenhai
 * @version $Id: CompanyController.java, v 0.1 2016年8月18日 上午10:50:10 chenwenhai Exp $
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CompanyBiz companyBiz;

    @RequestMapping(value = "/{companyId}/add",method = RequestMethod.GET)
    public Model detail(@PathVariable Integer companyId, Model model){
    	Company company = companyBiz.selectByPrimaryKey(companyId);
    	model.addAttribute("company",company);
        return model;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String queryCompanyList(Model model,Pagination<Company,Company> pagination){
    	Pagination<Company, Company> pagination2 = new Pagination<Company, Company>(pagination.getParam(), pagination.getNumPerPage(), pagination.getCurrentPage());
        Pagination<Company, Company> companys = companyBiz.queryCompanys(pagination2);
        model.addAttribute("companys",companys.getDataList());
        return "company/companyQuery";
    }
    
    @ResponseBody
	@RequestMapping(value = "queryCompanyList", method = RequestMethod.POST)
	public DataTableResult<Company> queryCompanyList(Integer offset, Integer limit, Company company) {
    	
    	try {
			Pagination<Company, Company> pagination = new Pagination<Company, Company>(offset, limit, company);
			pagination = companyBiz.queryCompanys(pagination);
			return new DataTableResult<Company>(pagination.getTotalCount(), pagination.getDataList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  null;
	}

}
