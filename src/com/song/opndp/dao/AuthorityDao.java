package com.song.opndp.dao;

import java.util.List;

import com.song.opndp.entity.Authority;

public interface AuthorityDao {

	/**
	 * 查询角色权限范围
	 * @param roleId
	 * @return
	 */
	public List<Authority> queryLst(Long roleId);
	
}
