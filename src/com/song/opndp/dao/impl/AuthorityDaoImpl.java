package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.opndp.dao.AuthorityDao;
import com.song.opndp.dao.Database.AuthorityF;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.entity.Authority;

public class AuthorityDaoImpl extends BasicDao<Authority> implements
		AuthorityDao {

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(AuthorityF.ADD_TIME).append(",");
		fields.append(tabPoint).append(AuthorityF.MENU_ID).append(",");
		fields.append(tabPoint).append(AuthorityF.OPE_IDS).append(",");
		fields.append(tabPoint).append(AuthorityF.ROLE_ID).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?,?";
	}

	@Override
	protected Object[] getParams(Authority t) {
		return new Object[] { t.getAddTime(), t.getMenuId(), t.getOpeIds(),
				t.getRoleId() };
	}

	@Override
	protected List<Object> getParams(Authority t, StringBuffer sqlWhere) {
		if (t == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		if (t.getMenuId() != null) {
			sqlWhere.append(" and ").append(AuthorityF.MENU_ID).append("=?");
			params.add(t.getMenuId());
		}
		if (t.getRoleId() != null) {
			sqlWhere.append(" and ").append(AuthorityF.ROLE_ID).append("=?");
			params.add(t.getRoleId());
		}

		return params;
	}

	@Override
	protected void init(Authority t) {
		t.init();
	}

	@Override
	protected Authority rowMapper(ResultSet rs, int rowNum) throws SQLException {
		Authority a = new Authority();
		a.setAddTime(rs.getTimestamp(AuthorityF.ADD_TIME.name()));
		a.setMenuId(rs.getLong(AuthorityF.MENU_ID.name()));
		a.setOpeIds(rs.getString(AuthorityF.OPE_IDS.name()));
		a.setRoleId(rs.getLong(AuthorityF.ROLE_ID.name()));
		return a;
	}

	@Override
	public List<Authority> queryLst(Long roleId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_AUTHORITY);
		
		Authority a = new Authority();
		a.setRoleId(roleId);
		StringBuffer sqlWhere = new StringBuffer();
		List<Object> oList = this.getParams(a, sqlWhere);
		
		sql.append(sqlWhere.toString());
		
		return this.getEntityList(sql.toString(), oList.toArray());
	}

}
