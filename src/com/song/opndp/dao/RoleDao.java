package com.song.opndp.dao;

import java.util.List;

import com.song.opndp.entity.Role;

public interface RoleDao {

	List<Role> queryList(String keyword);
	
	/**
	 * 根据Id查询
	 * @param roleId
	 * @return
	 */
	Role queryById(Long roleId);

	/**
	 * 查询管理员角色
	 * @param adminId
	 * @return
	 */
	List<Role> queryListByAdmin(Long adminId);
}
