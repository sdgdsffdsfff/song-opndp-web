package com.song.opndp.entity;

import java.util.Date;

import com.song.commons.entity.LazyLoadEntity;

public class Authority extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = -2360381323633187205L;

	@Override
	public void init() {
		if (addTime == null) addTime = new Date();
	}

	/** 角色ID */
	private Long roleId;
	/** 菜单id */
	private Long menuId;
	/** 操作范围 */
	private String opeIds;
	/** 添加时间 */
	private Date addTime;

	public Date getAddTime() {
		return addTime;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getOpeIds() {
		return opeIds;
	}

	public void setOpeIds(String opeIds) {
		this.opeIds = opeIds;
	}
}
