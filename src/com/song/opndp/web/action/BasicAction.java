package com.song.opndp.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.song.opndp.entity.Admin;
import com.song.opndp.service.AdminService;
import com.song.opndp.web.bean.ConstantVal;

public abstract class BasicAction {

	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 获取在线管理员信息
	 * 
	 * @return
	 */
	public Admin getAdminOnLine() {
		Long adminId = (Long) getSession().getAttribute(
				ConstantVal.SESSION_ADMINID_KEY);
		Admin a = null;
		if (adminId != null && !adminId.equals(0)) {
			a = adminService.getAdminById(adminId);
		}
		return a;
	}

	/**
	 * 发送系统错误通知
	 */
	public void sendSysErrNotic() {
		this.put("errInfo",
				"<div class='box box-error'>服务器异常^_^，请联系维护工程师！！！</div>");
	}

	public void setErrInfo() {
		this.put("errInfo", "用户非法操作，请不要提交恶意信息！");
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public ServletContext getApplication() {
		return getSession().getServletContext();
	}

	public void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}
}
