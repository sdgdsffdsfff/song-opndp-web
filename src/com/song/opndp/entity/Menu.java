package com.song.opndp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.song.commons.entity.LazyLoadEntity;

/**
 * 菜单（权限）
 * @author songzigw
 *
 */
public class Menu extends LazyLoadEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7872697722944607953L;

	@Override
	public void init() {
		if (addTime == null) addTime = new Date();
	}
	
	/** 菜单ID */
	private Long menuId;
	/** 菜单名称 */
	private String menuName;
	/** 菜单描述 */
	private String menuDesc;
	/** 添加时间 */
	private Date addTime;
	/** 上级ID */
	private Long priorId;
	/** ACT_URL */
	private String actUrl;
	/** 操作范围（,隔开） */
	private String opeIds;

	/** 子菜单 */
	private List<Menu> subMenuList;
	/** 操作项集 */
	private List<Operation> opernList;
	
	public Long getMenuId() {
		return menuId;
	}
	
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getPriorId() {
		return priorId;
	}

	public void setPriorId(Long priorId) {
		this.priorId = priorId;
	}

	public String getActUrl() {
		return actUrl;
	}

	public void setActUrl(String actUrl) {
		this.actUrl = actUrl;
	}

	public String getOpeIds() {
		return opeIds;
	}

	public void setOpeIds(String opeIds) {
		this.opeIds = opeIds;
	}

	public List<Menu> getSubMenuList() {
		if (subMenuList == null) {
			subMenuList = new ArrayList<Menu>();
		}
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public List<Operation> getOpernList() {
		return opernList;
	}

	public void setOpernList(List<Operation> opernList) {
		this.opernList = opernList;
	}
	
}
