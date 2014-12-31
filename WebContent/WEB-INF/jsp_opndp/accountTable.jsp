<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://opndp.yimeipei.com/taglib/util" prefix="cms"%>
<%@ page import="com.song.opndp.web.config.*"%>
<%ConfigManager cm = ConfigManager.getInstance();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<table id="account_table">
	<thead>
		<tr>
			<th>
				序号 / ID
			</th>
			<th>
				账号
			</th>
			<th>
				昵称
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
	<s:iterator value="%{#pageInfo.result}" var="admin" status="sta">
		<tr>
			<td>${pageInfo.pageSize*(pageInfo.currPage-1)+(sta.index + 1)}
				 / ${admin.adminId}
			</td>
			<td>
				<s:property value="#admin.account"/>
			</td>
			<td>
				<a href="<%=cm.getWebsiteDapeiUri()%>/${admin.adminId}" target="_blank"><s:property value="#admin.nickName"/></a>
			</td>
			<td>
				<s:date name="#admin.addTime" format="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>
				<a href="${request.contextPath}/opn/accountEdit.html?adminId=${admin.adminId}" id="account_edit_btn_${admin.adminId}" class="dgbox">修改</a><span> | </span>
				<a href="${request.contextPath}/opn/accountRoleEdit.html?adminId=${admin.adminId}" id="account_role_btn_${admin.adminId}" class="dgbox">设置角色</a><span> | </span>
				<a href="${request.contextPath}/opn/accountCatEdit.html?adminId=${admin.adminId}" id="account_category_btn_${admin.adminId}" class="dgbox">分类范围</a><span> | </span>
				<a href="javascript:Account.delAccount(${admin.adminId});">删除</a>
			</td>
		</tr>
	</s:iterator>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<s:if test="%{#pageInfo.totalNum == 0}">当前无数据</s:if>
				<s:else>
				<cms:pagination actionName="accountList.html" currPage="${pageInfo.currPage}" pageSize="${pageInfo.pageSize}" totalNum="${pageInfo.totalNum}"/>
				</s:else>
			</td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">
$("#account_table").table({rowHeight: 35, rowColor: true});
$('.dgbox').dgbox({title:'账号编辑',modal : true});
</script>