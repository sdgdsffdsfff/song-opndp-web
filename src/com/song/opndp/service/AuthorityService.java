package com.song.opndp.service;

import java.util.List;

import com.song.opndp.entity.Menu;
import com.song.opndp.entity.Role;

/**
 * 权限（角色、菜单、操作项等等）控制业务逻辑
 * @author 张松
 *
 */
public interface AuthorityService {

	/**
	 * 查询所有的菜单信息
	 * @return
	 */
	List<Menu> getMenuListAll();
	
	/**
	 * 查询角色
	 * @param keyword
	 * @return
	 */
	List<Role> getRoleList(String keyword);
	
	/**
	 * 查询角色的权限范围
	 * @param roleId
	 * @return
	 */
	List<Menu> getAuthorityByRole(Long roleId);
	
	/**
	 * 查询管理员的权限范围
	 * @param adminId
	 * @return
	 */
	List<Menu> getAuthorityByAdmin(Long adminId);
	
	/**
	 * 根据主键查询角色
	 * @param roleId
	 * @return
	 */
	Role getRorlById(Long roleId);
	
	/**
	 * 查询管理员角色
	 * @param adminId
	 * @return
	 */
	List<Role> getRoleListByAdmin(Long adminId);
	
	/**
	 * 给管理员分配角色
	 * @param adminId
	 * @param roleIdArr
	 */
	void addAdminRole(Long adminId, Long... roleIdArr);
}
