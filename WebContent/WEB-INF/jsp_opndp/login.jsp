<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>后台运营中心</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<jsp:include page="/WEB-INF/jsp_opndp/global.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_cms/css/login.css?version=<%=cm.getWebsiteVersion()%>"/>
    <script type="text/javascript">
    $(document).ready(function() {
    	
    });
    </script>
  </head>
  
  <body>
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/loginTop.jsp">
    	<jsp:param name="item" value="1"/>
    </jsp:include>
    </div>
    
    <div class="top-css win_360">
    <div class="top_css form_css login_form">
    	<form action="${request.contextPath}/checkLogin.html" method="post">
    	<h2 class="padding_css title_h2">后台运营中心</h2>
		<p class="top_css">
			<label class="required">
				账号：
			</label>
			<br />
			<input class="width_css_1" id="account" name="admin.account"
				type="text" value="${admin.account}" />
		</p>
		<p>
			<label class="required">
				密码：
			</label>
			<br />
			<input class="width_css_1" id="adminName" name="admin.password"
				type="password" value="" />
		</p>
		<p></p>
		${errInfo}
		<p>
			<button type="submit" class="btn_css btn_css_green">
				登入
			</button>
		</p>
		</form>
	</div>
    </div>
    
    <div class="top-css">
    <jsp:include page="/WEB-INF/jsp_opndp/foot.jsp"></jsp:include>
    </div>
  </body>
</html>