package com.song.opndp.service;

import java.util.List;

import com.song.opndp.entity.Admin;

/**
 * 管理员业务逻辑
 * 
 * @author Administrator
 * 
 */
public interface AdminService {

	void addAdmin(String account, char[] pwd, String nickname, int gender,
			String email, String phone);

	void updateAdmin(long adminId, char[] pwd, String nickname, int gender,
			String email, String phone);

	/**
	 * 验证账号是否重复
	 * 
	 * @param account
	 * @return
	 */
	boolean verifyAccountRep(String account);

	/**
	 * 验证昵称是否重复
	 * 
	 * @param nickName
	 * @return
	 */
	public boolean verifyNicknameRep(String nickName);

	/**
	 * 验证用户登入信息
	 * 
	 * @param account
	 * @param password
	 * @return 合法true，否则false。
	 */
	boolean checkLogin(String account, String password);

	/**
	 * 分页查询管理员信息
	 * 
	 * @param nickOrAccount
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<Admin> getAdminList(String nickOrAccount, int currPage, int pageSize);

	/**
	 * 通过账号查询
	 * 
	 * @param account
	 * @return
	 */
	Admin getAdminByAccount(String account);

	/**
	 * 通过昵称查询
	 * 
	 * @param nickName
	 * @return
	 */
	Admin getAdminByNickname(String nickName);

	/**
	 * 通过唯一（管理员ID）标示查询
	 * 
	 * @param adminId
	 * @return
	 */
	Admin getAdminById(Long adminId);

	/**
	 * 通过唯一（用户名ID）标示查询
	 * 
	 * @param userId
	 * @return
	 */
	Admin getAdminByUserId(Long userId);

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 */
	void delAdminById(Long adminId);

	/**
	 * 修改管理员密码
	 * 
	 * @param adminId
	 * @param password
	 * @param oldPwd
	 */
	void changePassword(long adminId, String password, String oldPwd);

}
