package com.song.opndp.dao;

import java.util.List;

import com.song.opndp.entity.Menu;

public interface MenuDao {

	/**
	 * 查询所有一级菜单
	 * @return
	 */
	List<Menu> queryListTop();
	
	/**
	 * 查询子菜单
	 * @param menuId
	 * @return
	 */
	List<Menu> queryListSub(Long menuId);
	
	/**
	 * 根据主键查询
	 * @param menuId
	 * @return
	 */
	Menu queryById(Long menuId);
}
