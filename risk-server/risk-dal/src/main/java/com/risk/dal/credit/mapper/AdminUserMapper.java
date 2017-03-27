package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.common.utils.db.IParentMapper;
import com.risk.dal.credit.entity.AdminUser;

public interface AdminUserMapper extends IParentMapper<AdminUser>{

    int insertSelective(AdminUser record);
    
    /**
	 * 查询总数
	 * 
	 * @param adminUser
	 * @return
	 */
	int queryAdminUsersCount(AdminUser adminUser);
    
    /**
	 * 分页查询
	 * 
	 * @param adminUser
	 * @param rb
	 * @return
	 */
	List<AdminUser> queryAdminUsers(AdminUser adminUser, RowBounds rb);

}