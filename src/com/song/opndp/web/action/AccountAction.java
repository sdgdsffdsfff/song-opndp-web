package com.song.opndp.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.song.commons.PageInfo;
import com.song.commons.StringUtil;
import com.song.opndp.entity.Admin;
import com.song.opndp.entity.Role;
import com.song.opndp.service.AuthorityService;
import com.song.opndp.web.tags.Pagination;

/**
 * 账号（管理员）管理
 * 
 * @author 张松
 * 
 */
public class AccountAction extends BasicAction {

	public static Logger logger = Logger.getLogger(AccountAction.class);

	private AuthorityService authorityService;

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	/**
	 * 到账号列表页
	 * 
	 * @return
	 */
	public String toAccountList() {
		HttpServletRequest request = this.getRequest();
		// 当前页
		int currPage = PageInfo.parseCurrPage(request
				.getParameter(Pagination.CURRPAGE));
		// 每页显示数量
		int pageSize = PageInfo.parsePageSize(request
				.getParameter(Pagination.PAGESIZE));
		String nickOrAccount = request.getParameter("nickOrAccount");

		try {
			List<Admin> adminList = getAdminService().getAdminList(
					nickOrAccount, currPage, pageSize);
			PageInfo<Admin> pageInfo = new PageInfo<Admin>(currPage, pageSize,
					1000);
			pageInfo.setResult(adminList);
			this.put("pageInfo", pageInfo);
		} catch (Exception e) {
			StringBuilder mes = new StringBuilder();
			mes.append("AccountAction.toAccountList():");
			mes.append("到账号列表页查询异常");
			logger.error(mes.toString(), e);
		}

		return Action.SUCCESS;
	}

	/**
	 * 到账号添加页
	 * 
	 * @return
	 */
	public String toAccountAdd() {
		return Action.SUCCESS;
	}

	/**
	 * 到账号修改页
	 * 
	 * @return
	 */
	public String toAccountEdit() {
		HttpServletRequest req = this.getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));
		Admin admin = getAdminService().getAdminById(adminId);
		this.put("admin", admin);

		return Action.SUCCESS;
	}

	/**
	 * 到账号搜索页
	 * 
	 * @return
	 */
	public String toAccountSearch() {
		return Action.SUCCESS;
	}

	/**
	 * 到账号表格显示页
	 * 
	 * @return
	 */
	public String toAccountTable() {
		toAccountList();
		return Action.SUCCESS;
	}

	/**
	 * 添加账号
	 * 
	 * @return
	 * @throws IOException
	 */
	public String addAccount() throws IOException {
		HttpServletRequest req = this.getRequest();
		// Admin a = this.getAdminOnLine();

		String account = req.getParameter("account");
		Integer gender = StringUtil.parseInt(req.getParameter("gender"));
		String nickname = req.getParameter("nickName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// response.setLocale(new java.util.Locale("zh", "CN"));
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		try {
			char[] pwd = null;
			if (password != null && !password.equals("")) {
				pwd = password.toCharArray();
			}
			getAdminService().addAdmin(account, pwd, nickname, gender, email,
					phone);
			out.print("parent.Dgbox.information('创建成功');");
			out.print("parent.Dgbox.linkedTo(");
			out.print("parent.document.getElementById");
			out.println("('account_add')).close();");
			out.println("parent.Account.loadTable();");
		} catch (Exception e) {
			logger.error("AccountAction.addAccount();", e);
			out.print("parent.Dgbox.information('创建失败');");
		}
		out.print("</script>");

		return null;
	}

	/**
	 * 编辑账号
	 * 
	 * @return
	 * @throws IOException
	 */
	public String editAccount() throws IOException {
		HttpServletRequest req = getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));
		Integer gender = StringUtil.parseInt(req.getParameter("gender"));
		String nickname = req.getParameter("nickName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		try {
			char[] pwd = null;
			if (!StringUtil.isEmptyOrNull(password)) {
				pwd = password.toCharArray();
			}
			getAdminService().updateAdmin(adminId, pwd, nickname, gender,
					email, phone);
			out.print("parent.Dgbox.information('编辑成功');");
			out.print("parent.Dgbox.linkedTo(");
			out.print("parent.document.getElementById");
			out.println("('account_edit_btn_" + adminId + "')");
			out.print(").close();");
			out.println("parent.Account.loadTable();");
		} catch (Exception e) {
			logger.error("AccountAction.editAccount();", e);
			out.print("parent.Dgbox.information('编辑失败');");
		}
		out.print("</script>");

		return null;
	}

	/**
	 * 到账号角色分配页
	 * 
	 * @return
	 */
	public String toAccountRoleEdit() {
		HttpServletRequest req = getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));
		List<Role> arList = authorityService.getRoleListByAdmin(adminId);
		this.put("arList", arList);

		List<Role> roleList = authorityService.getRoleList(null);
		this.put("roleList", roleList);
		return Action.SUCCESS;
	}

	/**
	 * 分配账号角色
	 * 
	 * @return
	 * @throws IOException
	 */
	public String editAccountRole() throws IOException {
		HttpServletRequest req = getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));
		String[] roleIds = req.getParameterValues("roleIds");

		Long[] roleIdArr = new Long[0];
		if (roleIds != null) {
			roleIdArr = new Long[roleIds.length];
			for (int i = 0; i < roleIds.length; i++) {
				roleIdArr[i] = StringUtil.parseLong(roleIds[i]);
			}
		}

		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		try {
			authorityService.addAdminRole(adminId, roleIdArr);
			out.print("parent.Dgbox.information('编辑成功');");
			out.print("parent.Dgbox.linkedTo(");
			out.print("parent.document.getElementById");
			out.println("('account_role_btn_" + adminId + "')");
			out.print(").close();");
		} catch (Exception e) {
			logger.error("AccountAction.editAccountRole();", e);
			out.print("parent.Dgbox.information('编辑失败');");
		}
		out.print("</script>");

		return null;
	}

	/*
	 * 删除管理员
	 * 
	 * @return
	 * 
	 * @throws IOException
	 */
	public String delAdmin() throws IOException {
		HttpServletRequest req = this.getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));

		getAdminService().delAdminById(adminId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", 1);
		// jsonObject.put("result", 0);
		// jsonObject.put("msg", "删除失败");

		PrintWriter out = this.getResponse().getWriter();
		out.print(jsonObject.toString());
		return null;
	}
}
