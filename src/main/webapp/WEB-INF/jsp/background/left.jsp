<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="js/jquery.js" ></script>
<title>绿子食品官方网站后台管理</title>
<style type="text/css"> 
	/* common */
	*{ word-wrap:break-word; outline:none; }

	body{ width:159px; background:#F2F9FD url(image/Images/bg_repx_h.gif) right top no-repeat; color:#666; font:12px "Lucida Grande", Verdana, Lucida, Helvetica, Arial, "" ,sans-serif; }
	body, ul{ margin:0; padding:0; }
	a{ color:#2366A8; text-decoration:none; }
	a:hover { text-decoration:underline; }
	.menu{ position:relative; z-index:20; }
	.menu ul{ position:absolute; top:10px; right:-1px !important; right:-2px; list-style:none; width:150px; background:#F2F9FD url(image/Images/bg_repx_h.gif) right -20px no-repeat; padding-bottom:20px; }
	.menu li{ margin:3px 0px 3px 0px;; *margin:1px 0; height:auto !important; height:24px; overflow:hidden; font-size:14px; font-weight:700; }
	.menu li a{ display:block; margin-right:2px; padding:3px 0 2px 30px; *padding:4px 0 2px 30px; border:1px solid #F2F9FD; background:url(image/Images/bg_repno.gif) no-repeat 10px -40px; color:#666; }
	.menu li a:hover{ text-decoration:none; margin-right:0; border:1px solid #B5CFD9; border-right:1px solid #FFF; background:#FFF; }
	.menu li a.tabon{ text-decoration:none; margin-right:0; border:1px solid #B5CFD9; border-right:1px solid #FFF; background:#FFF url(image/Images/bg_repy.gif) repeat-y; color:#2366A8; }
	.footer{ width:155px;position:fixed; _position:absolute; padding:2px 2px; z-index:30; bottom:0; background:url(image/Images/bg_repx.gif) 0 -199px repeat-x; cursor:pointer; text-align:center; background-color:#F2F9FD; display:none; _bottom:auto;_top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-16));}
	.header{ width:155px;position:fixed; _position:absolute; padding:2px 2px; z-index:30; top:0; background:url(image/Images/bg_repx.gif) 0 -181px repeat-x; cursor:pointer; text-align:center; background-color:#F2F9FD; display:none; _top:expression(eval(document.documentElement.scrollTop));}
	.menu .jia{cursor:pointer;background:url(image/Images/1.gif) no-repeat;padding-left:20px;height:22px;}
	.menu .jian{cursor:pointer;background:url(image/Images/2.gif) no-repeat;padding-left:20px;height:22px;}
</style>
</head>

<body>
	<div class="menu" oncontextmenu="event.returnValue=false" onselectstart="event.returnValue=false"
		ondragstart="window.event.returnValue=false" onsource="event.returnValue=false" topmargin="0">
		<ul id="leftmenu">
			<c:forEach items="${privileges}" var="p" varStatus="status">
				<c:choose>
					<c:when test="${p.parent==null}">
						<li class="jian" onclick="changebg(this,'${p.id}'">${p.name}</li>
					</c:when>
					<c:otherwise>
						<li class="${p.parent.id}">
							<a href="${p.url}" target="main" title="${p.description}" class="${status.index==1?'tabon':''}">${p.name}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
	</div>
	<div class="header"><img src="image/Images/shang.jpg" /></div>
	<div class="footer"><img src="image/Images/arrow.jpg" /></div>
	<script type="text/javascript">
		// 切换背景
		function changebg(obj,key) {
		    if (obj.className == 'jia') {
		        obj.className = 'jian';
		        for (var i=0; i<$('.'+key).length; i++) {
		            $('.'+key+':eq('+i+')').show();
		        }
		    }else{
		        obj.className = 'jia';
		        for (var i=0; i<$('.'+key).length; i++) {
		            $('.'+key+':eq('+i+')').hide();
		        }
		    }    
		}
	
	    $(document).ready(function () {
	        $("#leftmenu li a").click(function () {
	            $("#leftmenu li a").removeClass('tabon');
	            $(this).addClass('tabon');
	        });
	        if ($("#leftmenu").height() > $(window).height()) {
	            $(".footer").show();
	        }
	        var topTime = true;
	        $(".footer").click(function () {
	            if (topTime) {
	                topTime = false;
	                var top1 = Number($(document).scrollTop());
	                $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');
	                $body.animate({scrollTop : top1 + 100},100,function () {
	                    if ($(window).height() + $(document).scrollTop() >= $("#leftmenu").height()) {
	                        $(".footer").hide();
	                    }else{
	                        $(".footer").show();
	                    }
	                    if ($(document).scrollTop() == 0) {
	                        $('.header').hide();
	                    }else{
	                        $('.header').show();
	                    }
	                    topTime = true;
	                });
	            }  
	        });
	        $(".header").click(function () {
	            if (topTime) {
	                topTime = false;
	                var top1 = Number($(document).scrollTop());
	                $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');
	                $body.animate({scrollTop : top1 - 100},100,function () {
	                    if ($(window).height() + $(document).scrollTop() >= $("#leftmenu").height()) {
	                        $(".footer").hide();
	                    }else{
	                        $(".footer").show();
	                    }
	                    if ($(document).scrollTop() == 0) {
	                        $('.header').hide();
	                    }else{
	                        $('.header').show();
	                    }
	                    topTime = true;
	                });
	            }  
	        });
	    });
	</script>
</body>
</html>