<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%@ page import="java.util.Calendar" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<style type="text/css">
	#foot {
		overflow: hidden;
		line-height:35px;
		text-align: center;
		margin-top: 25px;
	}
	</style>
  </head>
  
  <body>
    <div id="foot">
    <div class="line_css_3"></div>
    <%Calendar c = Calendar.getInstance();%>
    <span>Copyright © 2013 - <%=c.get(Calendar.YEAR)%> 微录客CMS. All Rights Reserved</span>
    </div>
  </body>
</html>
