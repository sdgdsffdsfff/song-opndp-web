package com.song.opndp.dao;

import com.song.commons.dao.Fields;
import com.song.commons.dao.Tables;

public class Database {

	/**
	 * 数据表名称
	 * @author 张松
	 *
	 */
	public static enum Opndp implements Tables {
		/** 菜单（权限） */
		OPN_MENU,
		/** 角色 */
		OPN_ROLE,
		/** 操作项 */
		OPN_OPERATION,
		/** 角色权限范围 */
		OPN_AUTHORITY,
		/** 管理员扮演角色 */
		OPN_ADMINROLE,
		/** 管理员 */
		OPN_ADMIN,
	}
	
	/**
	 * 管理员
	 * 
	 * @author 张松
	 * 
	 */
	public static enum AdminF implements Fields {
		/** 管理员ID */
		ADMIN_ID,
		/** 添加时间 */
		ADD_TIME,
		/** 账号 */
		ACCOUNT,
		/** 密码 */
		PASSWORD,
		/** 昵称 */
		NICK_NAME,
		/** 用户头像 */
		PHOTO_PATH,
		/** 邮箱 */
		EMAIL,
		/** 电话 */
		PHONE,
		/** 1男 2女 */
		GENDER,
		/** 关联用户ID（一旦关联不能修改） */
		USER_ID,
	}
	
	/**
	 * 菜单（权限）表的字段
	 * 
	 * @author 张松
	 * 
	 */
	public static enum MenuF implements Fields {
		/** 菜单ID */
		MENU_ID,
		/** 菜单名称 */
		MENU_NAME,
		/** 菜单描述 */
		MENU_DESC,
		/** 添加时间 */
		ADD_TIME,
		/** 上级ID */
		PRIOR_ID,
		/** ACT_URL */
		ACT_URL,
		/** 操作范围（“,”隔开） */
		OPE_IDS,
	}
	
	/**
	 * 操作项表字段
	 * @author 张松
	 *
	 */
	public static enum OperationF implements Fields {
		/** 操作项ID */
		OPE_ID,
		/** 操作项名称 */
		OPE_NAME,
		/** 添加时间 */
		ADD_TIME,
	}
	
	/**
	 * 角色表的字段
	 * @author 张松
	 *
	 */
	public static enum RoleF implements Fields {
		/** 角色ID */
		ROLE_ID,
		/** 角色名称 */
		ROLE_NAME,
		/** 角色描述 */
		ROLE_DESC,
		/** 添加时间 */
		ADD_TIME,
	}
	
	/**
	 * 角色权限范围
	 * @author 张松
	 *
	 */
	public static enum AuthorityF implements Fields {
		/** 角色ID */
		ROLE_ID,
		/** 菜单ID */
		MENU_ID,
		/** 操作范围 */
		OPE_IDS,
		/** 添加时间 */
		ADD_TIME,
	}
	
	/**
	 * 管理员扮演角色
	 * @author 张松
	 *
	 */
	public static enum AdminRoleF implements Fields {
		/** 管理员ID */
		ADMIN_ID,
		/** 角色ID */
		ROLE_ID,
		/** 添加时间 */
		ADD_TIME,
	}
}
