<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<link rel="stylesheet" href="css/admin/index.css" type="text/css" media="all" />
<script src="js/jquery.js" type="text/javascript"></script>
 <style>
    .show{
        color:#666;
        outline:none;
        cursor:pointer;
        margin-left:0px;
    }
    .margin_left{
        margin-left:20px;
    }
</style>
</head>
<body>
	<div id="append"></div>
	<div class="container">
		<div style="margin-bottom: 20px;">
			<h3>基本信息</h3>
		</div>

		<h3>服务器参数</h3>
		<ul class="memlist fixwidth">
			<li><em>服务器域名/IP:</em>127.0.0.1(127.0.0.1)</li>
			<li><em>服务端口:</em>80</li>
			<li><em>服务器类型/版本:</em>Apache/2.4.10 (Win32) OpenSSL/1.0.1i
				PHP/5.5.15</li>
			<li><em>服务器操作系统:</em>Windows NT C2T1P1VXLKER83V 6.1 build 7601
				(Windows 7 Ultimate Edition Service Pack 1) i586</li>
			<li><em>MySQL 版本:</em>5.6.20</li>
		</ul>
		<h3>
			<a class="show" id="show" style="text-decoration: none;">登陆信息</a><a
				class="sgbtn show margin_left" id="update"
				style="text-decoration: none;">修改资料</a>
		</h3>
		<ul id="showbox" class="memlist fixwidth">
			<li><em>登录名：</em>admin2</li>
			<li><em>昵称：</em>测试管理员</li>
			<li><em>Email：</em><span id="showmail">admin2@admin.com</span></li>
			<li><em>上次登陆时间：</em>2014-09-12 10:15:27</li>
			<li><em>上次登陆IP：</em>127.0.0.1&nbsp;&nbsp;( <a
				href="http://www.ip138.com/ips.asp?ip=127.0.0.1&action=2"
				target="_block">查询IP地址</a> )</li>
			<li><em>总共登陆次数：</em>131 次</li>
		</ul>
		<ul id="updatebox" class="memlist fixwidth" style="display: none;">
			<li><em>登录名：</em>admin2</li>
			<li><em>昵称：</em>测试管理员</li>
			<li><em>密码：</em><input type="password" class="txt"
				style="width: 250px;" id="password" /></li>
			<li><em>重复密码：</em><input type="password" class="txt"
				style="width: 250px;" id="repassword" /></li>
			<li><em>Email：</em><input type="text" class="txt"
				style="width: 250px;" value="admin2@admin.com" id="email" /></li>
			<li><input type="button" value="修 改" class="btn" id="updatebtn" /></li>
		</ul>
	</div>
	<script type="text/javascript">
	<!--
	    $('#update').click(function () {
	        $(this).removeClass('sgbtn');
	        $('#show').addClass('sgbtn');
	        $('#updatebox').show();
	        $('#showbox').hide();
	    });
	    $('#show').click(function () {
	        $(this).removeClass('sgbtn');
	        $('#update').addClass('sgbtn');
	        $('#updatebox').hide();
	        $('#showbox').show();
	    });
	    $('#updatebtn').click(function () {
	        if ($('#password').val() != '') {
	            if ($('#password').val().length < 5) {
	                alert('密码长度不小于5');
	                $('#password').focus();
	                return false;
	            }
	            if ($('#password').val() != $('#repassword').val()) {
	                alert('两次密码输入不一致');
	                $('#repassword').focus();
	                return false;
	            }
	        }
	        if ($('#email').val() == '') {
	            alert('请输入Email');
	            $('#email').focus();
	            return false;
	        }
	        if (!/^\w+@[0-9a-zA-Z\.]+\.com|cn|net|gov|edu|com\.cn$/.test($('#email').val())) {
	            alert('Email格式不正确');
	            $('#email').focus();
	            return false;
	        }
	        $.post('/admin/Basic/update',{password:$('#password').val(),email:$('#email').val()},function (data) {
	            $('#password').val('');
	            $('#repassword').val('');
	            $('#showmail').html($('#email').val());
	            alert('修改成功');
	            $('#show').click();
	        });
	    });
	//-->
	</script>
</body>
</html>