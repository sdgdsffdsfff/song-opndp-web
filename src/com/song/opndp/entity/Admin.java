package com.song.opndp.entity;

import java.util.Date;

import com.song.commons.entity.LazyLoadEntity;

/**
 * 管理员
 * 
 * @author 张松
 * 
 */
public class Admin extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = -5125932738801454625L;

	/** 管理员ID */
	private Long adminId;
	/** 添加时间 */
	private Date addTime;
	/** 账号 */
	private String account;
	/** 密码 */
	private String password;
	/** 姓名 */
	private String adminName;
	/** 用户头像 */
	private String photoPath;
	/** 邮箱 */
	private String email;
	/** 电话 */
	private String phone;
	/** 1男 2女 */
	private Integer gender;
	/** 关联用户ID（一旦关联不能修改） */
	private Long userId;

	@Override
	public void init() {
		if (this.addTime == null)
			this.addTime = new Date();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/** 添加时间 */
	public Date getAddTime() {
		return addTime;
	}

	/** 添加时间 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/** 用户ID */
	public Long getAdminId() {
		return adminId;
	}

	/** 用户ID */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	/** 姓名 */
	public String getAdminName() {
		return adminName;
	}

	/** 姓名 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/** 账号 */
	public String getAccount() {
		return account;
	}

	/** 账号 */
	public void setAccount(String account) {
		this.account = account;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		return true;
	}
}