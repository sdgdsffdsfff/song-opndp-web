<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.song.opndp.web.config.*" %>
<%ConfigManager cm = ConfigManager.getInstance();%>

<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>

<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_common/jquery-1.7.1.min.js?version=<%=cm.getWebsiteVersion()%>"></script>
<script type="text/javascript">
var Global = {
	URI : "<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()%>",
	contextPath : "${request.contextPath}"
};
</script>
<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/js_common/dgbox/css/song.dgbox.css?version=<%=cm.getWebsiteVersion()%>"/>
<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_common/dgbox/js/song.dgbox.js?version=<%=cm.getWebsiteVersion()%>"></script>
<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/js_common/table/css/song.table.css?version=<%=cm.getWebsiteVersion()%>"/>
<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_common/table/js/song.table.js?version=<%=cm.getWebsiteVersion()%>"></script>
<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_common/watermark/jquery.watermark.js?version=<%=cm.getWebsiteVersion()%>"></script>
<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_common/jquery.wookmark.js?version=<%=cm.getWebsiteVersion()%>"></script>
<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/js_common/pagination/css/pagination.css?version=<%=cm.getWebsiteVersion()%>"/>

<link rel="shortcut icon" href="<%=cm.getResOpndpUri()%>/res_opndp/images/favicon.ico?version=<%=cm.getWebsiteVersion()%>" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_opndp/css/styles.css?version=<%=cm.getWebsiteVersion()%>"/>
<link rel="stylesheet" type="text/css" href="<%=cm.getResOpndpUri()%>/res_opndp/css/foot.css?version=<%=cm.getWebsiteVersion()%>"/>
<script type="text/javascript" src="<%=cm.getResOpndpUri()%>/js_opndp/global.js?version=<%=cm.getWebsiteVersion()%>"></script>