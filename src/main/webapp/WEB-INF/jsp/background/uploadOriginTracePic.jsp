<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<link rel="stylesheet" href="css/admin/index.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/tipswindown.css" type="text/css" media="all" />
</head>
<body>
<div id="append"></div>
	<div class="container">
		<div>
			<h3>
				上传溯源图片 <a href="admin/uploadAuthenticationPic" class="sgbtn">上传资质图片</a>
			</h3>
			<div style="text-align: left; margin-top: 20px;">
				<form method="post" id="theform" action="admin/uploadPic_uploadOriginTracePic" enctype="multipart/form-data">
					<input type="hidden" name="type" value="suyuan" />
					<input type="file" id="upload" name="uploadedImg" class="txt" style="width: 400px; vertical-align: text-bottom;" /> 
					<input type="button" value="上 传" class="btn" onclick="return check()" />
				</form>
			</div>
		</div>
	</div>
	
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/tipswindown.js" type="text/javascript"></script>
	<script type="text/javascript">
		function check() {
			var file = document.getElementById('upload').value;
			if (file == '') {
				alert('没有选择文件');
				return false;
			}
			document.getElementById('theform').submit();
		}
	</script>
</body>
</html>