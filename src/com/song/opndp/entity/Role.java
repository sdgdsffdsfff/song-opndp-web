package com.song.opndp.entity;

import java.util.Date;

import com.song.commons.entity.LazyLoadEntity;

/**
 * 角色
 * @author songzigw
 *
 */
public class Role extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7499491374812376273L;

	@Override
	public void init() {
		if (addTime == null) addTime = new Date();
	}

	/** 角色ID */
	private Long roleId;
	/** 角色名称 */
	private String roleName;
	/** 角色描述 */
	private String roleDesc;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
