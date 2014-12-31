package com.song.opndp.entity;

import java.util.Date;

import com.song.commons.entity.LazyLoadEntity;

public class AdminRole extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = -8389572156424920340L;

	@Override
	public void init() {
		if (addTime == null)
			addTime = new Date();
	}

	/** 管理员ID */
	private Long adminId;
	/** 角色id */
	private Long roleId;
	/** 添加时间 */
	private Date addTime;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
