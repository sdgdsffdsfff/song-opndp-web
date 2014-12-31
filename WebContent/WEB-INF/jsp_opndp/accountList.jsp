<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>账号管理 - 微录客CMS后台运营中心</title>
    
	<jsp:include page="/WEB-INF/jsp_opndp/global.jsp"></jsp:include>
	<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_cms/account_manager.js?version=<%=cm.getWebsiteVersion()%>"></script>
  </head>
  
  <body>
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/mainNav.jsp">
    	<jsp:param name="item" value=""/>
    </jsp:include>
    </div>
    
    <div class="top_css win_990">
    <div class="framework_left">
    <h2 class="line_css padding_css title_h2">账号管理</h2>
    <div class="top_css" id="loading_ajax_1">
	<jsp:include page="/WEB-INF/jsp_opndp/accountTable.jsp"></jsp:include>
	</div>
    </div>
    <div class="framework_right">
    <a href="#" class="btn_css" onclick="Account.addPage(this);" id="account_add">账号添加</a>
    
    <div class="top_css" id="loading_ajax_2">
    <jsp:include page="/WEB-INF/jsp_opndp/accountSearch.jsp"></jsp:include>
    </div>
    </div>
    <div class="clear"></div>
    <iframe class="hidden_css" name="assistant"></iframe>
    </div>
    
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/foot.jsp"></jsp:include>
    </div>
  </body>
</html>