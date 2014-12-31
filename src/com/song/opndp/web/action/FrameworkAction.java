package com.song.opndp.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.song.commons.StringUtil;
import com.song.opndp.entity.Admin;
import com.song.opndp.entity.Menu;
import com.song.opndp.entity.Role;
import com.song.opndp.service.AuthorityService;

public class FrameworkAction extends BasicAction {

	public static Logger logger = Logger.getLogger(FrameworkAction.class);

	private AuthorityService authorityService;

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	/**
	 * 到运营管理平台主页面
	 * 
	 * @return
	 */
	public String toFramework() {
		showAuthorityAdmin();
		return Action.SUCCESS;
	}

	/**
	 * 显示管理员权限范围
	 * 
	 * @return
	 */
	public String showAuthorityAdmin() {
		Admin admin = this.getAdminOnLine();

		List<Menu> menuList = authorityService.getAuthorityByAdmin(admin
				.getAdminId());
		this.put("menuList", menuList);

		return Action.SUCCESS;
	}

	/**
	 * 到登入用户设置页
	 * 
	 * @return
	 */
	public String toAdminLoginSet() {

		// HttpServletRequest req = this.getRequest();
		Admin admin = this.getAdminOnLine();
		this.put("admin", admin);
		List<Role> arList = authorityService.getRoleListByAdmin(admin
				.getAdminId());
		this.put("arList", arList);

		return Action.SUCCESS;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String editAdminInfo() throws IOException {
		HttpServletRequest req = getRequest();
		Long adminId = StringUtil.parseLong(req.getParameter("adminId"));
		String oldPwd = req.getParameter("passwordOld");
		String password = req.getParameter("password");

		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// response.setLocale(new java.util.Locale("zh", "CN"));

		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		try {
			getAdminService().changePassword(adminId, password, oldPwd);
			out.print("parent.Dgbox.information('修改成功');");
			out.print("parent.Dgbox.linkedTo(");
			out.print("parent.document.getElementById");
			out.println("('admin_login_set')).close();");
		} catch (Exception e) {
			logger.error(e);
			out.print("parent.Dgbox.information('修改失败');");
		}
		out.print("</script>");
		return null;
	}
}
