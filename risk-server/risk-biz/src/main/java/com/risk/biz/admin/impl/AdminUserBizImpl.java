package com.risk.biz.admin.impl;

import java.util.List;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.codec.Md5Utils;
import com.common.utils.constant.GlobalConstance;
import com.common.utils.exception.RiskRunTimeException;
import com.common.utils.msg.RiskCodeEnum;
import com.common.utils.page.Pagination;
import com.risk.biz.admin.AdminUserBiz;
import com.risk.dal.credit.entity.AdminUser;
import com.risk.dal.credit.mapper.AdminUserMapper;

/**
 * 后台人员管理实现类
 * 
 * @author chenwenhai
 * @version $Id: AdminUserBizImpl.java, v 0.1 2016年8月11日 下午5:52:15 chenwenhai Exp $
 */
@Service("adminUserBiz")
public class AdminUserBizImpl implements AdminUserBiz {

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Override
	public int deleteAdminUserById(Integer id) {
		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		adminUser.setStatus(2);
		return adminUserMapper.updateByPrimaryKeySelective(adminUser);
	}

	
	
	@Override
	public int insertAdminUser(AdminUser adminUser) {
		return adminUserMapper.insert(adminUser);
	}

	@Override
	public AdminUser getAdminUserById(Integer id) {
		return adminUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateAdminUser(AdminUser adminUser) {
		return adminUserMapper.updateByPrimaryKeySelective(adminUser);
	}

	
	@Override
	public Pagination<AdminUser, AdminUser> queryAdminUsers(Pagination<AdminUser, AdminUser> pagination) {
		int totalCount = adminUserMapper.queryAdminUsersCount(pagination.getParam());
		pagination.setTotalCount(totalCount);
		if (totalCount > 0) {
			pagination.setDataList(adminUserMapper.queryAdminUsers(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

	@Override
	public int updateOrInsertAdminUser(AdminUser adminUser, List<Integer> roles) {

		return 0;
	}

	@Override
	public AdminUser login(String userName, String password) {
		AdminUser adminUser = getAdminUserByUserName(userName);

		if (adminUser != null) {
			if (null != adminUser.getStatus() && adminUser.getStatus().intValue() == 2) { // 用户被禁用
				throw new RiskRunTimeException(RiskCodeEnum.ERR_FROZE_RISK.getCode());
			}
			if (!StringUtils.equals(Md5Crypt.md5Crypt(password.getBytes(), GlobalConstance.DEFAULT_SALT), adminUser.getPassword())) {
				throw new RiskRunTimeException(RiskCodeEnum.CUST_1013.getCode());
			}
		} else {
			throw new RiskRunTimeException(RiskCodeEnum.CUST_1033.getCode());
		}

		return adminUser;
	}

	@Override
	public boolean changeAdminPassword(AdminUser adminUser, String newPassword) {
		adminUser.setPassword(Md5Utils.md5Encrypt(newPassword));
		int updateRowCount = updateAdminUser(adminUser);

		return updateRowCount > 0;
	}

	@Override
	public AdminUser getAdminUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<AdminUser> queryAdminUsers(AdminUser adminUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
