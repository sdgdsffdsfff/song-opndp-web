<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div>
<form target="assistant" action="${request.contextPath}/opn/addAccount.html" method="post" onsubmit="return Account.addCheck(this);">
	<div class="form_css">
	<p>
		<label class="required" for="cp_id" id="cp_idLabel">
			内容提供商：
		</label>
		<br />
		<s:select cssStyle="width:230px;" theme="simple" list="#cpList" listKey="cpId" listValue="cpName" value="#cpId" id="cp_id" name="cpId"></s:select>
	</p>
	<p>
		<label class="required" for="account" id="accountLabel">
			账号：
		</label>
		<br />
		<input class="width_css" id="account" name="account"
			type="text" value="${admin.account}" />
	</p>
	<p>
		<label class="required" id="genderLabel">
			性别：
		</label>
		<br />
		<label><input type="radio" id="gender_1" name="gender" value="1" checked="checked"/>男</label>&nbsp;&nbsp;
		<label><input type="radio" id="gender_2" name="gender" value="2"/>女</label>
	</p>
	<p>
		<label class="required" for="nickName" id="nickNameLabel">
			昵称：
		</label>
		<br />
		<input class="width_css" id="nickName" name="nickName"
			type="text" value="${admin.nickName}" />
	</p>
	<p>
		<label class="required" for="password" id="passwordLabel">
			账号密码：
		</label>
		<br />
		<input class="width_css" id="password" name="password"
			type="password" value="${admin.password}" />
	</p>
	<p>
		<label class="required" for="passwSecond" id="passwSecondLabel">
			密码确认：
		</label>
		<br />
		<input class="width_css" id="passwSecond" name="passwSecond"
			type="password" value="" />
	</p>
	<p>
		<label class="required" for="email" id="emailLabel">
			邮箱：
		</label>
		<br />
		<input class="width_css" id="email" name="email" type="text"/>
	</p>
	<p>
		<label for="phone" id="phoneLabel">
			电话：
		</label>
		<br />
		<input class="width_css" id="phone" name="phone" type="text"/>
	</p>
	<p>
		<button type="submit" class="btn_css btn_css_green">
			保存
		</button>
		<input type="button" class="btn_css" value="取消" onclick="Dgbox.get(this).close();"/>
	</p>
	</div>
</form>
</div>