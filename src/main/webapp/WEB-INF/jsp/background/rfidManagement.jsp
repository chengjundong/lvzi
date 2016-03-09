<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tipswindown.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
<script type="text/javascript" src="js/ui.datepicker-zh-CN.js"></script>
<link rel="stylesheet" href="css/admin/index.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/tipswindown.css" type="text/css" media="all" />
<link type="text/css" href="css/admin/blue2.css" rel="stylesheet" />
<style>
.bg {
	position: absolute;
	background-color: #fff;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	filter: alpha(opacity = 80);
	opacity: 0.8;
	z-index: 99999;
	display: none;
}

.updatebox {
	width: 320px;
	height: 50px;
	background-color: #F5F9FD;
	border: 1px solid #09c;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -160px;
	margin-top: -25px;
	z-index: 999991;
	line-height: 50px;
	text-align: left;
	display: none;
}

.pageBar {
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div id="append"></div>
	<div class="container">
		<div>
			<h3>
				验证码列表 <a href="javascript:void(0);" class="sgbtn" onclick="addCodePage()">添加验证码</a>
			</h3>
			<div class="mainbox" style="margin-top: 20px;">
				<!-- 验证码批次展示区 -->
				<table id="batchList" class="datalist fixwidth">
					<tr>
						<th>
							<input type="checkbox" name="chkall" id="chkall" onclick="checkall('delete[]')" class="checkbox" />
							<label for="chkall">删除</label>
						</th>
						<th>导入批次</th>
						<th>数据表名称</th>
						<th>验真码个数</th>
						<th>导入时间</th>
						<th>操作</th>
					</tr>
				</table>
				
				<!-- 分页页码条区 -->
				<div id="pageBar" class="pageBar" ></div>
				
				<!-- 删除功能区 -->
				<input type="button" value="删 除" class="btn"onclick="delall()" />
				<div style="margin-top: 20px;">
					按添加时间删除： 
					<input type="text" id="start" class="txt" value='选择开始时间' readonly style="width: 180px" />
					 - 
				 	<input type="text" id="end" class="txt" value='选择结束时间' readonly style="width: 180px" />&nbsp;&nbsp; 
				 	<input type="button" value="删 除" id="deleteRange" class="btn" style="margin: 0; padding: 2px 6px;" />
				</div>
			</div>
		</div>
	</div>

	<div class="bg"></div>
	<div class="updatebox">
		<div style="padding-left: 10px;">
			<input type="hidden" id="updateid" /> 验证码：<input type="text"
				class="txt" id="checkcode" />&nbsp;&nbsp; <input type="button"
				value="更 新" id="updatebtn" class="btn" />&nbsp;&nbsp; <input
				type="button" value="关 闭" id="closebtn" class="btn" />
		</div>
	</div>
	
	<s:debug />
	
	<script type="text/javascript">
		$(document).ready(function() {
			var myDate = new Date();
			var nowYear = myDate.getFullYear();
			var nowstartdate = $('#start').val();
			var nowenddate = $('#end').val();
			$("#start").datepicker({
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : true,
				yearRange : (Number(nowYear) - 20) + ':' + nowYear
			});
			$("#end").datepicker({
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : true,
				yearRange : (Number(nowYear) - 20) + ':' + nowYear
			});
			
			// 加载批次数据
			loadBatches(1);
		});
		
		// 加载批次数据的方法，使用Ajax方式
		function loadBatches(currentPageNo) 
		{
			$.post(
				// 请求链接
				"admin/ajax/rfidBatch_queryRfidBatches",
				
				// 请求参数
				{
					currentPageNo : currentPageNo
				},
				
				// 回调函数
				function (data) 
				{
					// 获取表格
					var table = $("#batchList");
					
					// 删除内容
					$(".batchData").remove();
					
					// 获取所有的导入批次
					var batches = data.elements;
					for(var i=0;i < batches.length;i++)
					{
						// 生成每行的数据
						var tr = $("<tr class='batchData'></tr>");
						
						// 所有的列
						var col1 = $("<td class='option'><input type='checkbox' name='delete[]' value='"+batches[i].id+"' class='checkbox' /></td>");
						var col2 = $("<td></td>").text(batches[i].id);
						var col3 = $("<td></td>").text(batches[i].fileName);
						var col4 = $("<td></td>").text(batches[i].rfidCount);
						var col5 = $("<td></td>").text(batches[i].importingTime);
						var col6 = $("<td><a href='javascript:void(0)' onclick='suyuan("+batches[i].id+")'>溯源信息</a></td>");
						tr.append(col1);
						tr.append(col2);
						tr.append(col3);
						tr.append(col4);
						tr.append(col5);
						tr.append(col6);
						
						// 加入表格
						table.append(tr);
					}
					
					// 获取页码条对象并清空页码条
					var pageBar = $("#pageBar");
					pageBar.empty();
					
					// 如果当前页与页码条起始页不一样，则显示向前按钮
					if(data.currentPageNo != data.startPageNo)
					{
						pageBar.append($("<strong><a href='javascript:void(0)' onclick='loadBatches("+(data.currentPageNo - 1)+")' >上一页</a></strong>").css("margin-right","15px"));
					}
					
					// 循环生成中间页码
					for(var i=data.startPageNo;i<=data.endPageNo;i++)
					{
						if(i == data.currentPageNo)
						{
							pageBar.append($("<strong>"+i+"</strong>").css("margin-right","15px"));
						}
						else
						{
							pageBar.append($("<strong><a href='javascript:void(0)' onclick='loadBatches("+i+")' >"+i+"</a></strong>").css("margin-right","15px"));
						}	
					}
					
					// 如果当前页与页码条最后一页不易那个，则显示向后按钮
					if(currentPageNo != data.endPageNo)
					{
						pageBar.append($("<strong><a href='javascript:void(0)' onclick='loadBatches("+(data.currentPageNo + 1)+")' >下一页</a></strong>").css("margin-right","15px"));
					}
				}); 
		}
		
		function checkall(name) {
			var userAgent = navigator.userAgent.toLowerCase();
			var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
			var is_moz = (navigator.product == 'Gecko')
					&& userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
			var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera)
					&& userAgent.substr(userAgent.indexOf('msie') + 5, 3);
	
			var e = is_ie ? event : checkall.caller.arguments[0];
			obj = is_ie ? e.srcElement : e.target;
			var arr = document.getElementsByName(name);
			var k = arr.length;
			for (var i = 0; i < k; i++) {
				if (arr[i].value == 'admin') {
	
				} else {
					arr[i].checked = obj.checked;
				}
			}
		}
		function delall() {
			var checkAll = "";
			var e = document.getElementsByName('delete[]');
	
			for (var i = 0; i < e.length; i++) {
				if (e[i].checked) {
					var checkAll = checkAll + e[i].value + ',';
				}
			}
			if (checkAll == "") {
				alert("未选择");
			} else {
				var j = confirm('该操作不可恢复，您确认要删除吗？');
	
				if (j) {
					window.location.href = "/admin/Checkcode/del?checkAll="
							+ checkAll;
				} else {
	
				}
			}
		}
		function addCodePage() {
			tipsWindown("添加验证码", "iframe:admin/toAddRFIDBatch", "600", "200", "true", "", "true", "");
			$("#windownbg,#windown-close").click(function() {
				location.reload();
			});
		}
		function winClose3() {
			$("#windownbg").remove();
			$("#windown-box").remove();
		}
		function suyuan(batchId) {
			tipsWindown("编辑溯源信息", "iframe:admin/updateOriginTraceInfo?batchId="+ batchId, "650", "800", "true", "", "true", "");
		}
		$('.bg').click(function() {
			$(this).hide();
			$('.updatebox').hide();
			$('#updateid').val('');
			$('#checkcode').val('');
		});
		$('#closebtn').click(function() {
			$('.bg').click();
		});
		function updatecode(id, code) {
			$('.bg').show();
			$('.updatebox').show();
			$('#updateid').val(id);
			$('#checkcode').val(code);
		}

		$('#updatebtn').click(function() {
			var id = $('#updateid').val();
			var code = $('#checkcode').val();
			if (code == '') {
				alert('验证码不能为空');
				$('#checkcode').focus();
				return false;
			}
			$.post('/admin/Checkcode/updateCode', {
				id : id,
				code : code
			}, function(data) {
				alert(data);
				$('#showcode' + id).html(code);
				$('.bg').click();
			});
		});
		
		$('#deleteRange').click(function() {
			if ($('#start').val() == '' || $('#start').val() == '选择开始时间') {
				alert('选择开始时间');
				return false;
			}
			if ($('#end').val() == '' || $('#end').val() == '选择结束时间') {
				alert('选择结束时间');
				return false;
			}
			var date1 = new Date($('#start').val().replace('-', '/'));
			var date2 = new Date($('#end').val().replace('-', '/'));
			if (Date.parse(date1) - Date.parse(date2) > 0) {
				alert("结束时间要大于开始时间");
				return false;
			}
			if (confirm("此操作将删除所有指定时间范围内添加的验真码，且不可恢复，确定要执行吗？"))
				window.location.href = '/admin/Checkcode/deleteRange?start='+ $('#start').val() + '&end=' + $('#end').val();
		});
	</script>
</body>
</html>