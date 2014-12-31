package com.song.opndp.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.song.commons.service.ServiceException;
import com.song.opndp.entity.Admin;
import com.song.opndp.web.bean.ConstantVal;
import com.song.opndp.web.config.ConfigManager;

public class LoginAction extends BasicAction {

	public static Logger logger = Logger.getLogger(LoginAction.class);

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String toLoginPage() {
		return Action.SUCCESS;
	}

	/**
	 * 验证登入信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String checkLogin() throws IOException {
		if (admin == null || "".equals(admin.getAccount())) {
			this.put("errInfo", "<div class='box box-error'>账号不能为空</div>");
			return Action.INPUT;
		}

		// 检测账号登入的合法性
		boolean flag = false;
		try {
			flag = getAdminService().checkLogin(admin.getAccount(),
					admin.getPassword());
		} catch (ServiceException e) {
			StringBuilder mes = new StringBuilder();
			mes.append("LoginAction.checkLogin():");
			mes.append("账号登入异常");
			mes.append("Account:" + admin.getAccount());
			logger.error(mes.toString(), e);
		} catch (Exception e) {
			StringBuilder mes = new StringBuilder();
			mes.append("LoginAction.checkLogin():");
			mes.append("账号登入异常");
			mes.append("Account:" + admin.getAccount());
			logger.error(mes.toString(), e);
			this.sendSysErrNotic();
			return Action.INPUT;
		}
		if (!flag) {
			this.put("errInfo", "<div class='box box-error'>账号或密码错误</div>");
			return Action.INPUT;
		}

		// 将用户账号放入SESSION
		Admin adminSession = getAdminService().getAdminByAccount(
				admin.getAccount());
		ActionContext
				.getContext()
				.getSession()
				.put(ConstantVal.SESSION_ADMINID_KEY, adminSession.getAdminId());

		return Action.SUCCESS;

	}

	/**
	 * 退出登入
	 * 
	 * @return
	 * @throws IOException
	 */
	public String logout() throws IOException {
		getRequest().getSession().invalidate();
		String ura = ConfigManager.getInstance().getWebsiteOpndpUri();
		getResponse().sendRedirect(ura + "/login.html");
		return null;
	}

	/**
	 * 获取在线管理员ID
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getAdminIdOnLine() throws IOException {
		Admin a = this.getAdminOnLine();

		HttpServletResponse response = getResponse();
		PrintWriter out = response.getWriter();
		// StringBuilder sb = new StringBuilder();
		// sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		// sb.append("<ret>");
		// sb.append("<account>" + account + "</account>");
		// sb.append("</ret>");
		// out.print(sb.toString());
		if (a != null) {
			out.print(a.getAdminId());
		}
		return null;
	}
}
