<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://opndp.yimeipei.com/taglib/util" prefix="cms"%>
<%@ page import="com.song.opndp.web.config.*"%>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div>
<form target="assistant" action="${request.contextPath}/opn/editAccountCat.html" method="post">
<input type="hidden" name="adminId" value="${param.adminId}"/>
<p><button type="submit" class="btn_css btn_css_green">保存可分类的范围</button>
<button type="button" class="btn_css" onclick="Dgbox.get(this).close();">取消</button></p>
<table class="no-style">
	<thead>
		<tr>
			<th> </th>
			<th>
				序号
			</th>
			<th>
				分类名称
			</th>
			<th>
				创建时间
			</th>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="#catList" var="cat" status="sta">
		<tr>
			<td><input type="checkbox" name="catIds" 
			<s:iterator value="#coList" var="co">
			<s:if test="%{#co.categoryb.catId == #cat.catId}">checked="checked"</s:if>
			</s:iterator> value="${cat.catId}"/></td>
			<td>${sta.index + 1}</td>
			<td>
				<s:property value="#cat.catName"/>(${cat.catId})
			</td>
			<td>
				<s:date name="#cat.addTime" format="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
	</s:iterator>
	</tbody>
</table>
</form>
</div>