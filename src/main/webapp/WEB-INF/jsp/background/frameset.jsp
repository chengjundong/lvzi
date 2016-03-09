<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Bookmark" href="image/favicon.ico" />
<link rel="Shortcut Icon" href="image/favicon.ico" />
<title>绿子食品官方网站后台系统</title>
</head>
<frameset rows="69,*" cols="*" id="all_content" frameborder="0" framespacing="0" border="1">
	<frame src="admin/top" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset cols="160,*" id="center_content" frameborder="0" framespacing="0">
		<frame src="admin/left" name="menu" scrolling="no" noresize="noresize" id="leftFrame" />
		<frame src="admin/basicInfor" name="main" id="mainFrame" frameborder="0" />
	</frameset>
</frameset>
<noframes>
	<body>您的浏览器不支持框架！</body>
</noframes>
</html>