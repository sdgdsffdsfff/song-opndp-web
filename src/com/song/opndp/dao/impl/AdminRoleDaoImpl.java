package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.commons.dao.DaoUtils;
import com.song.opndp.dao.AdminRoleDao;
import com.song.opndp.dao.Database.AdminRoleF;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.entity.AdminRole;

public class AdminRoleDaoImpl extends BasicDao<AdminRole> implements
		AdminRoleDao {

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(AdminRoleF.ADD_TIME).append(",");
		fields.append(tabPoint).append(AdminRoleF.ADMIN_ID).append(",");
		fields.append(tabPoint).append(AdminRoleF.ROLE_ID).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?";
	}

	@Override
	protected Object[] getParams(AdminRole t) {
		return new Object[] { t.getAddTime(), t.getAdminId(), t.getRoleId() };
	}

	@Override
	protected List<Object> getParams(AdminRole t, StringBuffer sqlWhere) {
		if (t == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		if (t.getAdminId() != null) {
			sqlWhere.append(" and ").append(AdminRoleF.ADMIN_ID).append("=?");
			params.add(t.getAdminId());
		}
		if (t.getRoleId() != null) {
			sqlWhere.append(" and ").append(AdminRoleF.ROLE_ID).append("=?");
			params.add(t.getRoleId());
		}
		return params;
	}

	@Override
	protected void init(AdminRole t) {
		t.init();
	}

	@Override
	protected AdminRole rowMapper(ResultSet rs, int rowNum) throws SQLException {
		AdminRole ar = new AdminRole();
		ar.setAddTime(rs.getTimestamp(AdminRoleF.ADD_TIME.name()));
		ar.setAdminId(rs.getLong(AdminRoleF.ADMIN_ID.name()));
		ar.setRoleId(rs.getLong(AdminRoleF.ROLE_ID.name()));
		return ar;
	}

	@Override
	public int delRoleByAdmin(Long adminId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from ").append(Opndp.OPN_ADMINROLE);
		sql.append(" where ").append(AdminRoleF.ADMIN_ID).append("=?");
		
		return this.getJdbcTemplate().update(sql.toString(), adminId);
	}

	@Override
	public int insert(AdminRole adminRole) {
		String sql = DaoUtils.insertSql(Opndp.OPN_ADMINROLE, getFields(null), getParamMarks());
		this.init(adminRole);
		Object[] params = getParams(adminRole);
		return this.addEntity(sql, params);
	}

}
