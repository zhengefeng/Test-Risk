package com.risk.op.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.risk.biz.admin.AdminUserBiz;
import com.risk.dal.credit.entity.AdminUser;

/**
 * 后台用户管理
 * 
 * @author chenwenhai
 * @version $Id: AdminUserController.java, v 0.1 2016年8月11日 下午5:25:58 chenwenhai Exp $
 */
@Controller
@RequestMapping("admin")
public class AdminUserController {

	private final static String DEFAULT_PASSWORD = "111111";

	@Autowired
	private AdminUserBiz adminUserBiz;

	@RequestMapping(value = "admin_user_query", method = RequestMethod.GET)
	public String query() {
		return "admin/admin_user_query";
	}

	@RequestMapping(value = "admin_user_add", method = RequestMethod.GET)
	public String addAdminUser(ModelMap modelMap) {
		return "admin/admin_user_edit";
	}

	@ResponseBody
	@RequestMapping(value = "deleteAdminUser/{sid}", method = RequestMethod.GET)
	public Map<String, Object> deleteAdminUser(ModelMap modelMap, @PathVariable("sid") Integer id) {
		adminUserBiz.deleteAdminUserById(id);
		return null;
	}

	@RequestMapping(value = "admin_user_edit/{sid}", method = RequestMethod.GET)
	public String updateAdminUser(ModelMap modelMap, @PathVariable("sid") Integer id) {
		AdminUser adminUser = adminUserBiz.getAdminUserById(id);
		modelMap.put("adminUser", adminUser);

		// List<AdminRole> hadRoles = adminRoleBiz.findAllRolesByAdminUserId(adminUser.getId());
		// modelMap.put("hadRoles", hadRoles);
		return "admin/admin_user_edit";
	}

	@RequestMapping(value = "admin_user_view/{sid}/{action}", method = RequestMethod.GET)
	public String updateAdminUser(ModelMap modelMap, @PathVariable("sid") Integer id, @PathVariable("action") String action) {
		AdminUser adminUser = adminUserBiz.getAdminUserById(id);
		modelMap.put("adminUser", adminUser);

		// List<AdminRole> hadRoles = adminRoleBiz.findAllRolesByAdminUserId(adminUser.getId());
		// modelMap.put("hadRoles", hadRoles);
		return "admin/admin_user_edit";
	}

	@ResponseBody
	@RequestMapping(value = "resetAdminUserPassword/{sid}", method = RequestMethod.GET)
	public Map<String, Object> resetAdminUserPassword(ModelMap modelMap, @PathVariable("sid") Integer id) {
		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		adminUser.setPassword(DEFAULT_PASSWORD);
		adminUserBiz.updateAdminUser(adminUser);
		return null;
	}

}
