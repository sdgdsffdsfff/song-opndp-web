package com.song.opndp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.song.commons.StringUtil;
import com.song.commons.service.ServiceException;
import com.song.opndp.dao.AdminDao;
import com.song.opndp.entity.Admin;
import com.song.opndp.service.AdminService;
import com.song.opndp.service.ErrService.AdminS;
import com.song.opndp.service.ErrService.Common;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean checkLogin(String account, String password) {
		Admin admin = this.getAdminByAccount(account);
		if (admin == null) {
			// 不合法
			return false;
		}

		String pass = admin.getPassword();
		if (!pass.equals(DigestUtils.shaHex(password))) {
			// 不合法
			return false;
		}
		return true;
	}

	@Override
	public Admin getAdminByAccount(String account) {
		return adminDao.queryByAccount(account);
	}

	@Override
	public Admin getAdminByNickname(String nickName) {
		return adminDao.queryByNickname(nickName);
	}

	@Override
	public Admin getAdminById(Long adminId) {
		return adminDao.queryByAdminId(adminId);
	}

	@Override
	public Admin getAdminByUserId(Long userId) {
		return adminDao.queryByUserId(userId);
	}

	@Override
	public List<Admin> getAdminList(String nickOrAccount, int currPage,
			int pageSize) {
		List<Admin> adminList = new ArrayList<Admin>();

		if (!StringUtil.isEmptyOrNull(nickOrAccount)) {
			nickOrAccount = nickOrAccount.trim();

			Admin admin = this.getAdminByNickname(nickOrAccount);
			if (admin == null) {
				admin = this.getAdminByAccount(nickOrAccount);
			}
			if (admin == null) {
				return adminList;
			}
			if (admin != null) {
				adminList.add(admin);
				return adminList;
			}
		}

		adminList = adminDao.queryList(nickOrAccount, currPage, pageSize);

		return adminList;
	}

	@Override
	public boolean verifyAccountRep(String account) {
		return false;
	}

	@Override
	public boolean verifyNicknameRep(String nickName) {
		return false;
	}

	@Override
	public void delAdminById(Long adminId) {
		adminDao.delByAdminId(adminId);
	}

	@Override
	public void changePassword(long adminId, String password, String oldPwd) {
		if (password == null || password.trim().equals("")) {
			throw new ServiceException(Common.ERR_000_001, "最新密码格式有误");
		}

		Admin admin = adminDao.queryByAdminId(adminId);
		String dbPwd = new String(admin.getPassword());
		if (!dbPwd.equals(DigestUtils.shaHex(oldPwd))) {
			throw new ServiceException(AdminS.ERR_100_002, "原始密码错误");
		}
		adminDao.updatePassword(adminId, DigestUtils.shaHex(password));
	}

	@Override
	public void updateAdmin(long adminId, char[] pwd, String nickname,
			int gender, String email, String phone) {
		String tempPwd = null;
		if (pwd != null && pwd.length != 0) {
			tempPwd = DigestUtils.shaHex(new String(pwd));
		}

		Admin admin = new Admin();
		admin.setPassword(tempPwd);
		admin.setGender(gender);
		admin.setEmail(email);
		admin.setPhone(phone);

		adminDao.update(admin);
	}

	@Override
	public void addAdmin(String account, char[] pwd, String nickname,
			int gender, String email, String phone) {
		String password = new String(pwd);
		password = DigestUtils.shaHex(password);

		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setPassword(password);
		admin.setGender(gender);
		admin.setEmail(email);
		admin.setPhone(phone);

		adminDao.insert(admin);
	}
}
