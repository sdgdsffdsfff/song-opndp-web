<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  </head>
  <body>
  	<div class="main_nav">
    <!-- 顶部END -->
    <div class="clear"></div>
    <!-- 中间BEGIN -->
    <div class="main_nav_middle_win">
    <div class="main_nav_middle win_360">
      <h1 class="header_logo">
      <a href="<%=cm.getWebsiteOpndpUri()%>/login.html" title="后台运营中心" target="_self"></a>
      </h1>
    </div>
    </div>
    <!-- 中间END -->
    <div class="clear"></div>
    <!-- 底部BEGIN -->
    <div class="main_nav_bottom_win">
    <%String item = request.getParameter("item");%>
    <div class="main_nav_bottom win_360">
      <ul>
      <li><a <%=("1".equals(item) ? "class=\"checked\"" : "")%> href="${request.contextPath}/login.html">运营登入</a></li>
      <li><a <%=("2".equals(item) ? "class=\"checked\"" : "")%> href="<%=cm.getWebsiteDapeiUri()%>" target="_blank">微录客宽网</a></li>
      </ul>
      <div class="clear"></div>
      <div class="language"><b>中文</b> · <b>英文</b></div>
    </div>
    <div class="clear"></div>
    </div>
    <!-- 底部END -->
    </div>
  </body>
</html>
