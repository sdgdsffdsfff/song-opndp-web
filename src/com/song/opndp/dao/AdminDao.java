package com.song.opndp.dao;

import java.util.List;

import com.song.opndp.entity.Admin;

public interface AdminDao {

	Admin queryByAccount(String account);

	Admin queryByNickname(String nickName);

	Admin queryByAdminId(Long adminId);

	Admin queryByUserId(Long userId);

	void updatePassword(long adminId, String shaHex);

	void delByAdminId(Long adminId);

	void update(Admin admin);

	void insert(Admin admin);

	List<Admin> queryList(String nickOrAccount, int currPage, int pageSize);

}
