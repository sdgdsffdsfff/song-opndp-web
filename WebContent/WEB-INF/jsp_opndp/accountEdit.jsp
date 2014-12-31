<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div>
<form target="assistantTop" action="${request.contextPath}/opn/editAccount.html" method="post" onsubmit="return Account.editCheck(this);">
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
		<label class="required" id="genderLabel">
			性别：
		</label>
		<br />
		<label><input type="radio" id="gender_1" name="gender" value="1" <s:if test="#admin.gender == 1">checked="checked"</s:if>/>男</label>&nbsp;&nbsp;
		<label><input type="radio" id="gender_2" name="gender" value="2" <s:if test="#admin.gender == 2">checked="checked"</s:if>/>女</label>
	</p>
	<p>
		<label class="required" for="nickName" id="nickNameLabel">
			昵称：
		</label><br />
		<input class="width_css" id="nickName" name="nickName"
			type="text" value="${admin.nickName}" />
	</p>
	<p>
		<label for="password" id="passwordLabel">
			账号密码：（不填不修改）
		</label>
		<br />
		<input class="width_css" id="password" name="password" type="password"/>
	</p>
	<p>
		<label for="passwSecond" id="passwSecondLabel">
			密码确认：
		</label>
		<br />
		<input class="width_css" id="passwSecond" name="passwSecond" type="password"/>
	</p>
	<p>
		<label class="required" for="email" id="emailLabel">
			邮箱：
		</label><br />
		<input class="width_css" id="email" name="email" type="text" value="${admin.email}"/>
	</p>
	<p>
		<label for="phone" id="phoneLabel">
			电话：
		</label><br />
		<input class="width_css" id="phone" name="phone" type="text" value="${admin.phone}"/>
	</p>
	<p>
		<button type="submit" class="btn_css btn_css_green">
			修改
		</button>
		<input type="button" class="btn_css" value="取消" onclick="Dgbox.get(this).close();"/>
	</p>
	</div>
</form>
</div>