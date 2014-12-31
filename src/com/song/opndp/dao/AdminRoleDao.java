package com.song.opndp.dao;

import com.song.opndp.entity.AdminRole;

public interface AdminRoleDao {

	/**
	 * 删除管理员所有角色
	 * @param adminId
	 * @return
	 */
	int delRoleByAdmin(Long adminId);
	
	/**
	 * 插入管理员扮演角色
	 * @param adminRole
	 * @return
	 */
	int insert(AdminRole adminRole);
}
