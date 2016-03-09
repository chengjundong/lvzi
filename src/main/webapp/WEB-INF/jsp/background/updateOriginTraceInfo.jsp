<%@ page import="com.alu.lvzi.action.background.AdminAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>绿子食品官方网站后台管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tipswindown.js"></script>
<link rel="stylesheet" href="css/admin/index1.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/tipswindown.css" type="text/css" media="all"/>
<style type="text/css">
.tip{
	color: #aaaaaa;
	margin: 0 15px;
}
</style>
</head>
<body>
	<script type="text/javascript">
	    var pname = ''; //当前正在处理的图片的名称
		var codeExist = true;
		function chooseSuyuanImage(p) {
			pname = p ;
	        tipsWindown("选择图片 ","iframe:/admin/Checkcode/toChooseImage","450","210","true","","true","");
	    }
		function chooseZizhiImage(p) {
			pname = p ;
	        tipsWindown("选择图片 ","iframe:/admin/Checkcode/toChooseImage/zizhi/"+p,"450","210","true","","true","");
	    }
	    function winClose3(url) {
	        $("#windownbg").remove();
	        $("#windown-box").remove();
	        var y = document.getElementById('img_div_'+pname);
	        y.style.display = '';
			y.innerHTML = "<img src='image/verify/suyuan/thumb/thumb_"+url+"' width='80' /><input type='hidden' name='"+pname+"_pic' value='"+url+"' /><br/>";
	    }
		function winClose4(url) {
	        $("#windownbg").remove();
	        $("#windown-box").remove();
	        var y = document.getElementById('img_div_'+pname);
	        y.style.display = '';
			y.innerHTML = "<img src='image/verify/zizhi/thumb/thumb_"+url+"' width='80' /><input type='hidden' name='"+pname+"_pic' value='"+url+"' /><br/>";
	    }
		function checkInput()
		{
			var code = document.getElementById("code");
			if(code.value == '') {
	            alert('批次码不能为空');
	            code.focus();
	            return false;
	        } 
			if(!codeExist)
			{
				alert("批次码不存在");
				code.focus();
				return false;
			}
	        document.getElementById("theform").submit();
		}
		$(function(){
			$('#code').focus();
		});
		$(function(){
			$('#code').blur(function(){
				$.get('/admin/Checkcode/doesCheckcodeExist/code/'+$(this).val(),'', function(data){
					if(data=='-1'){
						$('#codemsg').css('color','red').html('该批次码不存在');
						codeExist = false;
					}
					else if(data=='-2'){
					$('#codemsg').css('color','red').html('批次码不能为空');
						codeExist = false;
					}
					else if(data=="-9"){
						//$('#codemsg').css('color','red').html('已存在溯源记录！继续提交将覆盖原有记录');
						codeExist = true;
					}
					else if(data>0){
						$('#codemsg').css('color','green').html('该批次码存在');
						codeExist = true;
					}
					else{
						codeExist = false;
						alert("未知错误！");					
					}
				});
			});
		});
	
		$(function(){
			$.get('/admin/Checkcode/doesCheckcodeExist/code/4','', function(data){
					 if(data=="-9"){
						codeExist = true;
					}
				});
		});
	</script>
	<div class="container" style="padding-top:0">
		<div class="mainbox" style="width:570px">
			<form id="theform" method="post" enctype="multipart/form-data"  action="admin/updateOriginTraceInfo_doUpate">
                <input type="hidden" name="id" id="id" value="4"/>
				<table class="datalist" style="border-top:0;">
                    <tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">批次号码：</td>
                        <td><input type="text" name="code" id="code" class="txt" value="${batch.id}" readonly="readonly" style="width:180px;"/><span class="tip" id="codemsg"></span></td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>橄榄果产地：</td>
                        <td><input type="text" name="ganlanguo_chandi" id="ganlanguo_chandi" class="txt" value="${batch.originPlace}" style="width:180px;"/></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">橄榄果产地图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_ganlanguo_chandi" >
                            <img id="title_image" src='image/verify/suyuan/${batch.originPlacePic}' width='80' />
                            <input type='hidden' id='ganlanguo_chandi_pic' name='ganlanguo_chandi_pic' value='chandi.jpg' />                            
                            </div>
                            <div class="clear"></div>
                           <a href="#" onclick="chooseSuyuanImage('ganlanguo_chandi')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>采摘时间：</td>
                        <td><input type="text" name="caizhai_time" id="caizhai_time" class="txt" value="${batch.pickingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">采摘时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_caizhai_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.pickingTimePic}' width='80' />
                                <input type='hidden' id='caizhai_time_pic' name='caizhai_time_pic' value='caizhai.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('caizhai_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>压榨时间：</td>
                        <td><input type="text" name="yazha_time" id="yazha_time" class="txt" value="${batch.squeezingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">压榨时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_yazha_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.squeezingTimePic}' width='80' />
                                <input type='hidden' id='yazha_time_pic' name='yazha_time_pic' value='yazha.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('yazha_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>包装时间：</td>
                        <td><input type="text" name="guanzhuang_time" id="guanzhuang_time" class="txt" value="${batch.packagingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">包装时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_guanzhuang_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.packagingTimePic}' width='80' />
                                <input type='hidden' id='guanzhuang_time_pic' name='guanzhuang_time_pic' value='fenzhuang.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('guanzhuang_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>海运时间：</td>
                        <td><input type="text" name="haiyun_time" id="haiyun_time" class="txt" value="${batch.shippingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">海运时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_haiyun_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.shippingTimePic}' width='80' />
                                <input type='hidden' id='haiyun_time_pic' name='haiyun_time_pic' value='haiyun.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('haiyun_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>到港时间：</td>
                        <td><input type="text" name="daogang_time" id="daogang_time" class="txt" value="${batch.inPortTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">到港时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_daogang_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.inPortTimePic}' width='80' />
                                <input type='hidden' id='daogang_time_pic' name='daogang_time_pic' value='daogang.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('daogang_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>分装时间：</td>
                        <td><input type="text" name="fenzhuang_time" id="fenzhuang_time" class="txt" value="${batch.subpackagingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月XX日</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">分装时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_fenzhuang_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.subpackagingTimePic}' width='80' />
                                <input type='hidden' id='fenzhuang_time_pic' name='fenzhuang_time_pic' value='guanzhuang.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('fenzhuang_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td>上市时间：</td>
                        <td><input type="text" name="shangshi_time" id="shangshi_time" class="txt" value="${batch.marketingTime}" style="width:180px;"/><span class="tip">格式:XXXX年XX月</span></td>
                    </tr> 
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">上市时间图片：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_shangshi_time" >
                            <img id="title_image" src='image/verify/suyuan/${batch.marketingTimePic}' width='80' />
                                <input type='hidden' id='shangshi_time_pic' name='shangshi_time_pic' value='shangshi.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseSuyuanImage('shangshi_time')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">产品资质图片1：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_zizhi1" >
                            <img id="title_image" src='image/verify/zizhi/coap1.jpg' width='80' />
                                <input type='hidden' id='zizhi1_pic' name='zizhi1_pic' value='coap1.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseZizhiImage('zizhi1')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">产品资质图片2：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_zizhi2" >
                            <img id="title_image" src='image/verify/zizhi/coap2.jpg' width='80' />
                                <input type='hidden' id='zizhi2_pic' name='zizhi2_pic' value='coap2.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseZizhiImage('zizhi2')">选择图片</a>
                        </td>
                    </tr>
					<tr class="nobg" style="border-bottom:1px dashed #b1cdd8;">
                        <td width="110px">产品资质图片3：</td>
                        <td>                            
                            <div class="goods_thumb_image left" id="img_div_zizhi3" >
                            <img id="title_image" src='image/verify/zizhi/weishengzheng.jpg' width='80' />
                                <input type='hidden' id='zizhi3_pic' name='zizhi3_pic' value='weishengzheng.jpg' />                            
                            </div>
                            <div class="clear"></div>
                            <a href="#" onclick="chooseZizhiImage('zizhi3')">选择图片</a>
                        </td>
                    </tr>
                    <tr class="nobg">
                        <td>
                            <input type="button"  value="提 交" class="btn" onclick="return checkInput()" />&nbsp;&nbsp;                            
                        </td>
                        <td class="tdpage"></td>
                    </tr>
                </table>
			</form>
		</div>
	</div>
</body>
</html>