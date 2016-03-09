<%@ page language="java" import="com.alu.lvzi.message.MessageBox" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="Bookmark" href="image/favicon.ico" />
<link rel="Shortcut Icon" href="image/favicon.ico" />
<title>绿子食品官方网站后台管理</title>
<link rel="stylesheet" href="css/admin/index.css" type="text/css"
	media="all" />
</head>
<body onkeydown="onkeySubmit(event)">
	<script language="javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$('#username').focus();
	
		function onkeySubmit(evt) {
			evt = (evt) ? evt : ((window.event) ? window.event : "");
			var key = evt.keyCode ? evt.keyCode : evt.which;
			if (key == 13) {
				login();
				return true;
			}
			return;
		}

		function picreload() {
			var change = document.getElementById('codeimg');
			change.src = "admin/vcode.action?actionMessages=" + Math.random();
		}

		function login() {
			 $("#error").html("<img src='image/Images/loading.gif'/>");
			 var username = document.getElementById('username').value;
			 var password = document.getElementById('password').value;
			 var seccode = document.getElementById('seccode').value;
			 if (username == '') {
			     $("#error").html('请输入用户名');
			     $('#username').focus();
			     return false;
			 }
			 if (password == '') {
			     $("#error").html('请输入密码');
			     $('#password').focus();
			     return false;
			 }
			 if (seccode == '') {
			     $("#error").html('请输入验证码');
			     $('#seccode').focus();
			     return false;
			 }
			 $.post('admin/ajax/user_login',{'username':username,'password':password,'vcode':seccode},	
				function(data) {
					if (data == '<%=MessageBox.Login_Success.getMessage()%>') {
						window.location.href = "admin/frameset";
					} else {
						$('#password').val('');
						$('#seccode').val('');
						picreload();
						$("#error").html(data);
					}
			});
		}
	</script>

	<div id="append"></div>
	<div class="container">
		<form id="loginform" name="loginform" target="_top">
			<table class="mainbox">
				<tr>
					<td class="loginbox"><img src="image/Images/admin_logo.jpg" />
					</td>
					<td class="login">
						<div id="error" style="text-align: center; color: red; width: 100%; height: 22px;"></div>
						<p id="usernamediv">
							用户名:<input id="username" type="text" name="username" class="txt" tabindex="1" value="" />
						</p>
						<p>
							密 码:<input id="password" type="password" name="password" class="txt" tabindex="2"  value="123456" />
						</p>
						<p>
							<div style="margin-left: 5px;">
								<div style="float: left;">
									验证码:<input id="seccode" type="text" name="seccode" class="txt" tabindex="2"  value="" style="margin-right: 5px; width: 85px;" />
								</div>
								<div style="float: left; cursor: pointer;">
									<img id="codeimg" width="70" height="21" src="admin/vcode" title="点击换一张" onclick="picreload()" />
								</div>
								<div style="clear: both;"></div>
							</div>
						</p>
						<p class="loginbtn">
							<input type="button" id="button1" value="登 录" class="btn" tabindex="3" onclick="return login()" />
						</p>
					</td>
				</tr>
			</table>
			<input type="hidden" name="__hash__" alue="071dea6fdc9022b9f36a8f48e438debe" />
		</form>
	</div>
	
	<div class="footer">
		绿子食品官方网站后台管理
	</div>

</body>
</html>