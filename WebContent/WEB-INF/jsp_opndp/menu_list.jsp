<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>系统菜单 - 后台运营中心</title>
    
	<jsp:include page="/WEB-INF/jsp_opndp/global.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_cms/css/menu_manager.css?version=<%=cm.getWebsiteVersion()%>"/>
  </head>
  
  <body>
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/mainNav.jsp">
    	<jsp:param name="item" value=""/>
    </jsp:include>
    </div>
    
    <div class="top_css win_990">
    <!-- <div class="framework_left"> -->
    <h2 class="line_css padding_css title_h2">菜单管理</h2>
    <div class="top_css" id="loading_ajax">
	<s:iterator value="#menuList" var="menu">
	<table class="menu-table">
	<tr><th colspan="<s:property value="#menu.subMenuList.size()"/>">${menu.menuName}</th></tr>
	<tr>
	<s:iterator value="#menu.subMenuList" var="subMenu">
	<td>
	<p class="menu-sub"><a>${subMenu.menuName}</a></p>
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
	</div>
    <!-- </div> -->
    
    <div class="clear"></div>
    <iframe class="hidden_css" name="assistant"></iframe>
    </div>
    
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/foot.jsp"></jsp:include>
    </div>
  </body>
</html>