package com.song.opndp.dao;

import java.util.List;

import com.song.opndp.entity.Operation;

public interface OperationDao {

	/**
	 * 通过主键查询
	 * @param opeId
	 * @return
	 */
	public Operation queryById(Long opeId);
	
	/**
	 * 通过多值操作ID查询
	 * @param opeIds 多个值之间用“,”分割
	 * @return
	 */
	public List<Operation> queryList(String opeIds);
	
}
