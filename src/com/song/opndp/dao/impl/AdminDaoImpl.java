package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.opndp.dao.AdminDao;
import com.song.opndp.dao.Database.AdminF;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.entity.Admin;

public class AdminDaoImpl extends BasicDao<Admin> implements AdminDao {

	@Override
	protected Admin rowMapper(ResultSet rs, int rowNum) throws SQLException {
		Admin a = new Admin();
		a.setAddTime(rs.getTimestamp(AdminF.ADD_TIME.name()));
		a.setAccount(rs.getString(AdminF.ACCOUNT.name()));
		a.setAdminId(rs.getLong(AdminF.ADMIN_ID.name()));
		a.setEmail(rs.getString(AdminF.EMAIL.name()));
		a.setGender(rs.getInt(AdminF.GENDER.name()));
		a.setAdminName(rs.getString(AdminF.ADMIN_NAME.name()));
		a.setPassword(rs.getString(AdminF.PASSWORD.name()));
		a.setPhone(rs.getString(AdminF.PHONE.name()));
		a.setPhotoPath(rs.getString(AdminF.PHOTO_PATH.name()));
		a.setUserId(rs.getLong(AdminF.USER_ID.name()));
		return a;
	}

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(AdminF.ADD_TIME).append(",");
		fields.append(tabPoint).append(AdminF.ACCOUNT).append(",");
		fields.append(tabPoint).append(AdminF.ADMIN_ID).append(",");
		fields.append(tabPoint).append(AdminF.EMAIL).append(",");
		fields.append(tabPoint).append(AdminF.GENDER).append(",");
		fields.append(tabPoint).append(AdminF.ADMIN_NAME).append(",");
		fields.append(tabPoint).append(AdminF.PASSWORD).append(",");
		fields.append(tabPoint).append(AdminF.PHONE).append(",");
		fields.append(tabPoint).append(AdminF.PHOTO_PATH).append(",");
		fields.append(tabPoint).append(AdminF.USER_ID).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?,?,?,?,?,?,?,?";
	}

	@Override
	protected Object[] getParams(Admin t) {
		return new Object[] { t.getAddTime(), t.getAccount(), t.getAdminId(),
				t.getEmail(), t.getGender(), t.getAdminName(), t.getPassword(),
				t.getPhone(), t.getPhotoPath(), t.getUserId() };
	}

	@Override
	protected List<Object> getParams(Admin t, StringBuffer sqlWhere) {
		if (t == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		if (t.getAdminName() != null && !"".equals(t.getAdminName())) {
			sqlWhere.append(" and ").append(AdminF.ADMIN_NAME).append(" like ?");
			params.add("%" + t.getAdminName() + "%");
		}
		if (t.getUserId() != null) {
			sqlWhere.append(" and ").append(AdminF.USER_ID).append("=?");
			params.add(t.getUserId());
		}
		if (t.getAdminId() != null) {
			sqlWhere.append(" and ").append(AdminF.ADMIN_ID).append("=?");
			params.add(t.getAdminId());
		}
		if (t.getAccount() != null) {
			sqlWhere.append(" and ").append(AdminF.ACCOUNT).append("=?");
			params.add(t.getAccount());
		}
		return params;
	}

	@Override
	protected void init(Admin t) {
		t.init();
		if (t.getAdminId() == null) {
			t.setAdminId(this.getId(Opndp.OPN_ADMIN));
		}
	}

	@Override
	public Admin queryByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin queryByNickname(String nickName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin queryByAdminId(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin queryByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(long adminId, String shaHex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByAdminId(Long adminId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> queryList(String nickOrAccount, int currPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
