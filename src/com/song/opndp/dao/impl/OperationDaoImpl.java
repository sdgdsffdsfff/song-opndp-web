package com.song.opndp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.song.commons.dao.BasicDao;
import com.song.opndp.dao.Database.Opndp;
import com.song.opndp.dao.Database.OperationF;
import com.song.opndp.dao.OperationDao;
import com.song.opndp.entity.Operation;

public class OperationDaoImpl extends BasicDao<Operation> implements
		OperationDao {

	@Override
	protected String getFields(String tableName) {
		String tabPoint = null;
		if (tableName == null || "".equals(tableName)) {
			tabPoint = "";
		} else {
			tabPoint = tableName + ".";
		}

		StringBuffer fields = new StringBuffer();
		fields.append(tabPoint).append(OperationF.ADD_TIME).append(",");
		fields.append(tabPoint).append(OperationF.OPE_ID).append(",");
		fields.append(tabPoint).append(OperationF.OPE_NAME).append("");
		return fields.toString();
	}

	@Override
	protected String getParamMarks() {
		return "?,?,?";
	}

	@Override
	protected Object[] getParams(Operation t) {
		return new Object[] { t.getAddTime(), t.getOpeId(), t.getOpeName() };
	}

	@Override
	protected List<Object> getParams(Operation t, StringBuffer sqlWhere) {
		if (t == null) {
			return new ArrayList<Object>();
		}

		List<Object> params = new ArrayList<Object>();
		sqlWhere.append(" where 1=1 ");
		return params;
	}

	@Override
	protected void init(Operation t) {
		t.init();
		if (t.getOpeId() == null) {
			t.setOpeId(getId(Opndp.OPN_OPERATION));
		}
	}

	@Override
	protected Operation rowMapper(ResultSet rs, int rowNum) throws SQLException {
		Operation o = new Operation();
		o.setAddTime(rs.getTimestamp(OperationF.ADD_TIME.name()));
		o.setOpeId(rs.getLong(OperationF.OPE_ID.name()));
		o.setOpeName(rs.getString(OperationF.OPE_NAME.name()));
		return o;
	}

	@Override
	public Operation queryById(Long opeId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(this.getFields(null));
		sql.append(" from ").append(Opndp.OPN_OPERATION);
		sql.append(" where ").append(OperationF.OPE_ID).append("=?");
		
		return this.getEntity(sql.toString(), opeId);
	}

	@Override
	public List<Operation> queryList(String opeIds) {
		if (opeIds == null || "".equals(opeIds)) opeIds = "0";
		
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(this.getFields(null));
		sql.append(" from ").append(Opndp.OPN_OPERATION);
		sql.append(" where ").append(OperationF.OPE_ID);
		sql.append(" in (" + opeIds + ")");
		
		return this.getEntityList(sql.toString(), null);
	}

}
