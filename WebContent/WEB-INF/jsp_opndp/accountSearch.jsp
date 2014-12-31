<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div class="box_css_2">
<form action="${request.contextPath}/opn/accountList.html" method="get">
	<h3 class="title_css">
		账号查询
	</h3>
	<div class="form_css">
		<p>
			<label for="nick_or_account">
				账号/昵称：
			</label>
			<br />
			<input class="width_css" id="nick_or_account" name="nickOrAccount"
				type="text" value="${param.nickOrAccount}" />
		</p>
		<p>
			<button type="submit" class="btn_css btn_css_green">
				查询
			</button>
		</p>
	</div>
</form>
</div>