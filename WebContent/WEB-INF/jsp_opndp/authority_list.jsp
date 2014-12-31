<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div>
<div style="font-size: 14px;padding: 5px;font-weight: bold;color: #999;">${role.roleName}-角色权限范围</div>
<s:iterator value="#menuList" var="menu">
<table class="menu-table">
<tr><th colspan="<s:property value="#menu.subMenuList.size()"/>">${menu.menuName}</th></tr>
<tr>
<s:iterator value="#menu.subMenuList" var="subMenu">
<td>
<p class="menu-sub"><a target="_blank" href="<%=cm.getWebsiteOpndpUri()%>${subMenu.actUrl}">${subMenu.menuName}</a></p>
<ul class="menu-opern-ul">
<s:iterator value="#subMenu.opernList" var="opern">
<li>${opern.opeName}</li>
</s:iterator>
</ul>
</td>
</s:iterator>
</tr>
</table>
</s:iterator>
<s:if test="#menuList == null || #menuList.isEmpty()==true">
<div>无权限</div>
</s:if>
</div>