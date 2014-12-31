package com.song.opndp.entity;

import java.util.Date;

import com.song.commons.entity.LazyLoadEntity;

public class Operation extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7426033876984309686L;

	@Override
	public void init() {
		if (addTime == null) addTime = new Date();
	}

	/** 操作项ID */
	private Long opeId;
	/** 操作项名称 */
	private String opeName;
	/** 添加时间 */
	private Date addTime;

	public Long getOpeId() {
		return opeId;
	}

	public void setOpeId(Long opeId) {
		this.opeId = opeId;
	}

	public String getOpeName() {
		return opeName;
	}

	public void setOpeName(String opeName) {
		this.opeName = opeName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
