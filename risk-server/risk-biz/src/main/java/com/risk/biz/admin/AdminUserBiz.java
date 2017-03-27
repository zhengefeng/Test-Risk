package com.risk.biz.admin;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.AdminUser;

/**
 * 后台人员管理业务接口
 * @author chenwenhai
 * @version $Id: AdminUserBiz.java, v 0.1 2016年8月11日 下午5:52:04 chenwenhai Exp $
 */
public interface AdminUserBiz {
	
	/**
	 * 新增
	 * @param adminUser
	 * @return
	 */
	int insertAdminUser(AdminUser adminUser);
	
	/**
	 * 根据id删除
	 */
	int deleteAdminUserById(Integer id);

	/**
	 * 根据id查询
	 */
	AdminUser getAdminUserById(Integer id);

	/**
	 * 修改
	 */
	int updateAdminUser(AdminUser adminUser);

	/**
	 * 增加或者修改
	 */
	int updateOrInsertAdminUser(AdminUser adminUser, List<Integer> roles);

	/**
	 * 分页查询
	 * 
	 * @param adminUser
	 * @param rb
	 * @return
	 */
	Pagination<AdminUser, AdminUser> queryAdminUsers(Pagination<AdminUser, AdminUser> pagination);


	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	AdminUser getAdminUserByUserName(String userName);
	
	/**
	 * 管理员登录
	 * 
	 * @param userName
	 *            - 用户名
	 * @param password
	 *            - 密码
	 * @return AdminUser - 管理员信息
	 */
	AdminUser login(String userName, String password);

	/**
	 * 修改登录密码
	 * @param adminUser
	 * @param newPassword
	 * @return
	 */
	boolean changeAdminPassword(AdminUser adminUser, String newPassword);
	
	/**
	 * 查询用户列表ByVO
	 * @param adminUser
	 * @return
	 */
	List<AdminUser> queryAdminUsers(AdminUser adminUser);

}
