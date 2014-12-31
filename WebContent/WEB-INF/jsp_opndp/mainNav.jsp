<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_cms/css/mainNav.css?version=<%=cm.getWebsiteVersion()%>"/>
	<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_cms/css/menu_manager.css?version=<%=cm.getWebsiteVersion()%>"/>
  </head>
  <body>
  	<iframe class="hidden_css" name="assistantTop"></iframe>
  	<div class="main_nav">
    <!-- 顶部BEGIN -->
    <!-- 顶部END -->
    <div class="clear"></div>
    <!-- 中间BEGIN -->
    <div class="main_nav_middle_win">
    <div class="main_nav_middle win_990">
      <h1 class="header_logo">
      <a href="${request.contextPath}/opn/index.html" title="后台运营中心" target="_self">后台运营中心</a>
      </h1>
      <div class="admin_info">
      <a href="<%=cm.getWebsiteDapeiUri()%>/${requestScope.adminOnLine.adminId}" target="_blank"><img width="32" class="avatar" src="${requestScope.adminOnLine.photoPath}"/></a>
      <label>欢迎您，</label>
      <b>${requestScope.adminOnLine.nickName}</b>
      <span>|</span>
      <a href="${request.contextPath}/opn/adminLoginSet.html" id="admin_login_set">设置</a>
      <span>|</span>
      <a href="${request.contextPath}/logout.html">退出</a>
      <br/>
      <!--<a href="#" class="high" style="color: #FFC806;">您有<strong><i>0</i></strong> 条新消息！</a>-->
      </div>
    </div>
    </div>
    <!-- 中间END -->
    <div class="clear"></div>
    <!-- 底部BEGIN -->
    <div class="main_nav_bottom_win">
    <%String item = request.getParameter("item");%>
    <div class="main_nav_bottom win_990">
      <ul>
      <li><a <%=("1".equals(item) ? "class=\"checked\"" : "")%> href="${request.contextPath}/opn/index.html">首页</a></li>
      <li><a <%=("2".equals(item) ? "class=\"checked\"" : "")%> href="${request.contextPath}/opn/authorityAdmin.html" id="main_menu"><span>开始菜单 </span><span class="trig"></span></a></li>
      </ul>
      <div class="clear"></div>
      <!-- <div class="language"><b>中文</b> · <b>英文</b></div> -->
    </div>
    <div class="clear"></div>
    </div>
    <!-- 底部END -->
    </div>
    <script type="text/javascript">
    $('#main_menu').dgbox({title:'菜单选项',modal:true});
    $('#admin_login_set').dgbox({title:'个人账号设置',modal:true});
    function editAdminInfo(f) {
    	
    }
    </script>
  </body>
</html>
