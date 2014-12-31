<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>角色管理 - 后台运营中心</title>
    
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
    <div class="framework_left">
    <h2 class="line_css padding_css title_h2">角色管理</h2>
    <div class="top_css" id="loading_ajax">
	<table id="role_table">
		<thead>
			<tr>
				<th>
					序号 / ID
				</th>
				<th>
					角色名称
				</th>
				<th>
					创建时间
				</th>
				<th>
					操作
				</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="#roleList" var="role" status="sta">
			<tr>
				<td>${sta.index + 1} / ${role.roleId}</td>
				<td>
					<s:property value="#role.roleName"/>
				</td>
				<td>
					<s:date name="#role.addTime" format="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<a href="${request.contextPath}/opn/authority.html?roleId=${role.roleId}" class="dgbox">权限范围查看</a>
					<!--<span> | </span><a>权限范围设置</a>-->
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	</div>
    </div>
    <div class="framework_right">
    <div class="top_css" id="loading_ajax_2">
	<div class="box_css_2">
	<form action="${request.contextPath}/opn/roleList.html" method="get">
		<h3 class="title_css">
			角色查询
		</h3>
		<div class="form_css">
			<p>
				<label for="key_word">
					角色关键字：
				</label>
				<br />
				<input class="width_css" id="key_word" name="keyword"
					type="text" value="${param.keyword}" />
			</p>
			<p>
				<button type="submit" class="btn_css btn_css_green">
					查询
				</button>
			</p>
		</div>
	</form>
	</div>
    </div>
    </div>
    <div class="clear"></div>
    <iframe class="hidden_css" name="assistant"></iframe>
    </div>
    
    <div>
    <jsp:include page="/WEB-INF/jsp_opndp/foot.jsp"></jsp:include>
    </div>
<script type="text/javascript">
$("#role_table").table({rowHeight: 35, rowColor: true});
$('.dgbox').dgbox({title:'权限范围'});
</script>
  </body>
</html>