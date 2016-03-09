<%@ page import="com.alu.lvzi.action.background.AdminAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<link rel="stylesheet" href="css/admin/index.css" type="text/css" media="all" />
<meta content="Comsenz Inc." name="Copyright" />
<style>
    #lock{cursor:pointer;}
</style>
</head>
<body>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		// 锁定IP地址
		function lockIp() {
			// 获取操作类型
			var operation = $('#lock').attr('operation');
			
			// 请用户确认是否进行操作
			if (operation == '<%=AdminAction.IP_LOCK%>') {
				var i = confirm('此操作将把账号与IP绑定');
			} else if(operation == '<%=AdminAction.IP_UNLOCK%>'){
				var i = confirm('此操作将把账号与IP解除绑定');
			}

			// 发送AJAX请求给后台action进行操作并根据返回结果修改当前页面的按钮名字
			if (i) {
				$.post('admin/ajax/user_lockIP', {
					operation : operation
				}, function(data) {
					if (data == '<%=AdminAction.IP_LOCK_SUCCESS%>') {
						document.getElementById('lock').innerHTML = '解除IP锁定';
						document.getElementById('lock').operation = '<%=AdminAction.IP_UNLOCK%>';
					} else if(data == '<%=AdminAction.IP_UNLOCK_SUCCESS%>') {
						document.getElementById('lock').innerHTML = 'IP锁定';
						document.getElementById('lock').operation = '<%=AdminAction.IP_LOCK%>';
					}
				});
			}
		}
		
		function clearcache() {
			$.post('/admin/Index/clearCache', {}, function(data) {
				if (data) {
					alert('清除完毕');
				}
			});
		}
		
	</script>
	<div class="mainhd">
		<div class="logo">绿子后台管理系统</div>
		<div class="uinfo">
			<div>
				<a class="sgbtn" href="verification.html" target="_blank">网站首页</a>
				<a class="sgbtn" onclick="clearcache()">清除缓存</a>
				&nbsp;&nbsp;&nbsp;&nbsp;您好,<em>${sessionScope.user.nickName}</em> 
				当前登录IP:<em id="loginIp">${pageContext.request.remoteAddr}</em>
				<c:choose>
					<c:when test="${sessionScope.user.boundedIP == null}">
						[ <a id="lock" operation="<%=AdminAction.IP_LOCK%>" onclick="lockIp()">IP锁定</a> ] 
					</c:when>
					<c:otherwise>
						[ <a id="lock" operation="<%=AdminAction.IP_UNLOCK%>" onclick="lockIp()">解除IP锁定</a> ] 
					</c:otherwise>
				</c:choose> 
				[ <a href="admin/logout" target="_top" onclick="return confirm('您确定退出吗？');">退出</a> ]
			</div>
		</div>
	</div>
</body>
</html>