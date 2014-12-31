package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.dao.Database.MenuF;
import com.song.opndp.dao.MenuDao;
import com.song.opndp.entity.Menu;

public class MenuDaoImpl extends BasicDao<Menu> implements MenuDao {

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(MenuF.ADD_TIME).append(",");
		fields.append(tabPoint).append(MenuF.ACT_URL).append(",");
		fields.append(tabPoint).append(MenuF.MENU_DESC).append(",");
		fields.append(tabPoint).append(MenuF.MENU_ID).append(",");
		fields.append(tabPoint).append(MenuF.MENU_NAME).append(",");
		fields.append(tabPoint).append(MenuF.OPE_IDS).append(",");
		fields.append(tabPoint).append(MenuF.PRIOR_ID).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?,?,?,?,?";
	}

	@Override
	protected Object[] getParams(Menu m) {
		return new Object[] { m.getAddTime(), m.getActUrl(), m.getMenuDesc(),
				m.getMenuId(), m.getMenuName(), m.getOpeIds(), m.getPriorId() };
	}

	@Override
	protected List<Object> getParams(Menu m, StringBuffer sqlWhere) {
		if (m == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		if (m.getPriorId() != null) {
			sqlWhere.append(" and ").append(MenuF.PRIOR_ID).append("=?");
			params.add(m.getPriorId());
		}

		return params;
	}

	@Override
	protected void init(Menu m) {
		m.init();
		if (m.getMenuId() == null) {
			m.setMenuId(getId(Opndp.OPN_MENU));
		}
	}

	@Override
	protected Menu rowMapper(ResultSet rs, int rowNum) throws SQLException {
		Menu m = new Menu();
		m.setAddTime(rs.getTimestamp(MenuF.ADD_TIME.name()));
		m.setActUrl(rs.getString(MenuF.ACT_URL.name()));
		m.setMenuDesc(rs.getString(MenuF.MENU_DESC.name()));
		m.setMenuId(rs.getLong(MenuF.MENU_ID.name()));
		m.setMenuName(rs.getString(MenuF.MENU_NAME.name()));
		m.setOpeIds(rs.getString(MenuF.OPE_IDS.name()));
		m.setPriorId(rs.getLong(MenuF.PRIOR_ID.name()));
		return m;
	}

	@Override
	public List<Menu> queryListTop() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_MENU);
		sql.append(" where ").append(MenuF.PRIOR_ID).append(" is null");
		sql.append(" or ").append(MenuF.PRIOR_ID).append("=0");
		
		return this.getEntityList(sql.toString(), null);
	}

	@Override
	public List<Menu> queryListSub(Long menuId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_MENU);
		
		Menu menu = new Menu();
		menu.setPriorId(menuId);
		StringBuffer sqlWhere = new StringBuffer();
		List<Object> oList = this.getParams(menu, sqlWhere);
		
		sql.append(sqlWhere.toString());
		
		return this.getEntityList(sql.toString(), oList.toArray());
	}

	@Override
	public Menu queryById(Long menuId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(getFields(null));
		sql.append(" from ").append(Opndp.OPN_MENU);
		sql.append(" where ").append(MenuF.MENU_ID).append("=?");
		
		return this.getEntity(sql.toString(), menuId);
	}
}
