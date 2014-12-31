package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.opndp.dao.Database.AdminRoleF;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.dao.Database.RoleF;
import com.song.opndp.dao.RoleDao;
import com.song.opndp.entity.Role;

public class RoleDaoImpl extends BasicDao<Role> implements RoleDao {

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(RoleF.ADD_TIME).append(",");
		fields.append(tabPoint).append(RoleF.ROLE_DESC).append(",");
		fields.append(tabPoint).append(RoleF.ROLE_ID).append(",");
		fields.append(tabPoint).append(RoleF.ROLE_NAME).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?,?";
	}

	@Override
	protected Object[] getParams(Role t) {
		return new Object[] { t.getAddTime(), t.getRoleDesc(), t.getRoleId(),
				t.getRoleName() };
	}

	@Override
	protected List<Object> getParams(Role t, StringBuffer sqlWhere) {
		if (t == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		if (t.getRoleName() != null && !"".equals(t.getRoleName())) {
			sqlWhere.append(" and ").append(RoleF.ROLE_NAME).append(" like ?");
			params.add("%" + t.getRoleName() + "%");
		}

		return params;
	}

	@Override
	protected void init(Role t) {
		t.init();
		if (t.getRoleId() == null) {
			t.setRoleId(getId(Opndp.OPN_ROLE));
		}
	}

	@Override
	protected Role rowMapper(ResultSet rs, int rowNum) throws SQLException {
		Role r = new Role();
		r.setAddTime(rs.getTimestamp(RoleF.ADD_TIME.name()));
		r.setRoleDesc(rs.getString(RoleF.ROLE_DESC.name()));
		r.setRoleId(rs.getLong(RoleF.ROLE_ID.name()));
		r.setRoleName(rs.getString(RoleF.ROLE_NAME.name()));
		return r;
	}

	@Override
	public List<Role> queryList(String keyword) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_ROLE);
		
		Role role = new Role();
		role.setRoleName(keyword);
		StringBuffer sqlWhere = new StringBuffer();
		List<Object> oList = this.getParams(role, sqlWhere);
		
		sql.append(sqlWhere.toString());
		System.out.println(sql);
		return this.getEntityList(sql.toString(), oList.toArray());
	}

	@Override
	public Role queryById(Long roleId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_ROLE);
		sql.append(" where ").append(RoleF.ROLE_ID).append("=?");
		
		return this.getEntity(sql.toString(), roleId);
	}

	@Override
	public List<Role> queryListByAdmin(Long adminId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields("r"));
		sql.append(" from ").append(Opndp.OPN_ROLE).append(" r ");
		sql.append(" inner join ").append(Opndp.OPN_ADMINROLE).append(" a ");
		sql.append(" on a.").append(RoleF.ROLE_ID).append("=").append("r.")
				.append(RoleF.ROLE_ID);
		sql.append(" where ").append(AdminRoleF.ADMIN_ID).append("=?");
		
		return this.getEntityList(sql.toString(), new Object[]{adminId});
	}

}
