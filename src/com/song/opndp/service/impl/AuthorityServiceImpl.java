package com.song.opndp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.song.opndp.dao.AdminRoleDao;
import com.song.opndp.dao.AuthorityDao;
import com.song.opndp.dao.MenuDao;
import com.song.opndp.dao.OperationDao;
import com.song.opndp.dao.RoleDao;
import com.song.opndp.entity.AdminRole;
import com.song.opndp.entity.Authority;
import com.song.opndp.entity.Menu;
import com.song.opndp.entity.Operation;
import com.song.opndp.entity.Role;
import com.song.opndp.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {

	private MenuDao menuDao;

	private RoleDao roleDao;

	private OperationDao operationDao;

	private AuthorityDao authorityDao;

	private AdminRoleDao adminRoleDao;

	public void setAdminRoleDao(AdminRoleDao adminRoleDao) {
		this.adminRoleDao = adminRoleDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setOperationDao(OperationDao operationDao) {
		this.operationDao = operationDao;
	}

	@Override
	public List<Menu> getMenuListAll() {
		List<Menu> mList = menuDao.queryListTop();

		for (Menu m : mList) {
			List<Menu> submList = menuDao.queryListSub(m.getMenuId());
			for (Menu sm : submList) {
				List<Operation> opernList = operationDao.queryList(sm
						.getOpeIds());
				sm.setOpernList(opernList);
			}
			m.setSubMenuList(submList);
		}

		return mList;
	}

	@Override
	public List<Role> getRoleList(String keyword) {
		return roleDao.queryList(keyword);
	}

	@Override
	public List<Menu> getAuthorityByRole(Long roleId) {
		List<Authority> authList = authorityDao.queryLst(roleId);

		List<Menu> menuList = new ArrayList<Menu>();
		List<Menu> smList = new ArrayList<Menu>();
		for (Authority a : authList) {
			Menu m = menuDao.queryById(a.getMenuId());
			if (m.getPriorId() == null || m.getPriorId() == 0) {
				menuList.add(m);
			} else {
				smList.add(m);
				m.setOpeIds(a.getOpeIds());
			}
		}
		for (Menu m : menuList) {
			Long mId = m.getMenuId();
			for (Menu sm : smList) {
				Long smId = sm.getPriorId();
				if (mId.equals(smId)) {
					m.getSubMenuList().add(sm);
					// 操作项集
					sm.setOpernList(operationDao.queryList(sm.getOpeIds()));
				}
			}
		}

		return menuList;
	}

	@Override
	public Role getRorlById(Long roleId) {
		return roleDao.queryById(roleId);
	}

	@Override
	public void addAdminRole(Long adminId, Long... roleIdArr) {
		// 删除
		adminRoleDao.delRoleByAdmin(adminId);
		// 添加
		for (Long roleId : roleIdArr) {
			AdminRole ar = new AdminRole();
			ar.setRoleId(roleId);
			ar.setAdminId(adminId);
			adminRoleDao.insert(ar);
		}
	}

	@Override
	public List<Role> getRoleListByAdmin(Long adminId) {
		return roleDao.queryListByAdmin(adminId);
	}

	@Override
	public List<Menu> getAuthorityByAdmin(Long adminId) {
		List<Role> rList = this.getRoleListByAdmin(adminId);

		List<Menu> menuTargetList = new ArrayList<Menu>();
		List<Authority> authTargetList = new ArrayList<Authority>();
		for (Role r : rList) {
			List<Authority> authList = authorityDao.queryLst(r.getRoleId());
			this.parseAuhtList(authList, authTargetList);
		}

		parseMenuList(menuTargetList, authTargetList);
		return menuTargetList;
	}

	private void parseAuhtList(final List<Authority> authList,
			final List<Authority> authTargetList) {
		for (Authority a : authList) {
			boolean f = false;
			String opeIds = null;
			for (Authority at : authTargetList) {
				if (at.getMenuId().equals(a.getMenuId())) {
					f = true;
					// 综合ope_id
					opeIds = this.getOpeIds(a.getOpeIds(), at.getOpeIds());
					break;
				}
			}
			if (!f) {
				authTargetList.add(a);
			} else {
				getAuth(authTargetList, a.getMenuId()).setOpeIds(opeIds);
			}
		}
	}

	private Authority getAuth(List<Authority> authTargetList, Long menuId) {
		for (Authority at : authTargetList) {
			if (menuId.equals(at.getMenuId())) {
				return at;
			}
		}
		return null;
	}

	private String getOpeIds(String aOpeIds, String atOpeIds) {
		if (aOpeIds == null || "".equals(aOpeIds)) {
			return atOpeIds;
		}
		if (atOpeIds == null || "".equals(atOpeIds)) {
			return aOpeIds;
		}
		return atOpeIds + "," + aOpeIds;
	}

	private void parseMenuList(final List<Menu> menuTargetList,
			final List<Authority> authTargetList) {
		List<Menu> smList = new ArrayList<Menu>();
		for (Authority a : authTargetList) {
			Menu m = menuDao.queryById(a.getMenuId());
			if (m.getPriorId() == null || m.getPriorId() == 0) {
				menuTargetList.add(m);
			} else {
				smList.add(m);
				m.setOpeIds(a.getOpeIds());
			}
		}
		for (Menu m : menuTargetList) {
			Long mId = m.getMenuId();
			for (Menu sm : smList) {
				Long smId = sm.getPriorId();
				if (mId.equals(smId)) {
					m.getSubMenuList().add(sm);
					// 操作项集
					sm.setOpernList(operationDao.queryList(sm.getOpeIds()));
				}
			}
		}
	}
}
