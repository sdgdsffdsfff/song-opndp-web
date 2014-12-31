<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div>
<form target="assistantTop" action="${request.contextPath}/opn/editAdminInfo.html" method="post" onsubmit="return editAdminInfo(this);">
	<div class="form_css">
	<p>
		<label for="cp_id" id="cp_idLabel">
			内容提供商：
		</label>
		<br />
		<s:select cssStyle="width:230px;" theme="simple" list="#cpList" listKey="cpId" listValue="cpName" value="#admin.cpId" id="cp_id" name="cpId" disabled="true"></s:select>
		<input type="hidden" id="adminId" name="adminId" value="${admin.adminId}"/>
	</p>
	<p>
		<label for="account" id="accountLabel">
			账号：${admin.account}
		</label>
	</p>
	<p>
		<label id="genderLabel">
			性别：<s:if test="#admin.gender == 1">男</s:if><s:if test="#admin.gender == 2">女</s:if>
		</label>
	</p>
	<p>
		<label for="nickName" id="nickNameLabel">
			昵称：${admin.nickName}
		</label>
	</p>
	<p>
		<label class="required">
			账号旧密码：
		</label>
		<br />
		<input class="width_css" id="password_old" name="passwordOld" type="password"/>
	</p>
	<p>
		<label class="required" for="password" id="passwordLabel">
			账号新密码：
		</label>
		<br />
		<input class="width_css" id="password" name="password" type="password"/>
	</p>
	<p>
		<label class="required" for="passwSecond" id="passwSecondLabel">
			密码确认：
		</label>
		<br />
		<input class="width_css" id="passwSecond" name="passwSecond" type="password"/>
	</p>
	<p>
		<label for="email" id="emailLabel">
			邮箱：${admin.email}
		</label>
	</p>
	<p>
		<label for="phone" id="phoneLabel">
			电话：${admin.phone}
		</label>
	</p>
	<p>
		<label>
			角色：<s:iterator value="#arList" var="ar">${ar.roleName},</s:iterator>
		</label>
	</p>
	<p>
		<button type="submit" class="btn_css btn_css_green">
			修改
		</button>
		<input type="button" class="btn_css" value="取消" onclick="Dgbox.get(this).close();"/>
	</p>
	</div>
</form>
<script type="text/javascript">
function editAdminInfo(f) {
	if (f.passwSecond.value != f.password.value) {
		Dgbox.information('密码确认输入不一致！');
		return false;
	}
	return true;
}
</script>
</div>