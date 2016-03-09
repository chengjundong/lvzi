<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<link rel="stylesheet" href="css/admin/index1.css" type="text/css" media="all" />
<style>
    .bg{position:absolute; background-color:#fff;display:none;width:500px;height:200px;left:0;top:0;}
    .loading{position:absolute; z-index:99999; left:150px; top:70px; width:200px; height:50px; display:none;}
    .info{position:absolute;display:none;left:0;top:0; z-index:99999;width:500px;background-color:#fff;text-align:left;}
</style>
</head>
<body>
	<c:if test="${sessionScope.batchUploadResult}">
		<div style="color:green">上传成功！</div><br/><br/>
	</c:if>
	<div id="append"></div>
    <div>
        <form id="theform" method="post" action="admin/addRFIDBatch" enctype="multipart/form-data">
        	选择文件：<input type="file" class="txt" id="files" name="batch" />
            <input type="button" value="上 传" class="btn" id="uploadbtn" />
            <span style="color:red;" id="infospan">（暂只支持.xlsx文件）</span>
        </form>
    </div>
    <div class="bg"></div>
    <div class="loading">
        <div style="margin-bottom:10px;" class="msgbox">文件上传中……请稍候</div>
        <div id="imgbox"><img src="image/Images/loading1.gif" /></div>
    </div>

    <div class="info"></div>
    
    <script src="js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $(document).ready(function () {
	        $('#uploadbtn').click(function () {
	            $('.loading').show();
	            $('#theform').submit();
	            return true;
	        });
	    });
	</script>
</body>
</html>