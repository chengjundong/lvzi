// JavaScript Document
$(function(){
	//二级右侧的聚焦鼠标交互
	$("a.new_t_inline").hover(function(){$(this).children(".title").removeClass("gray_txt_d")},function(){$(this).children(".title").addClass("gray_txt_d")})
	//二级右侧的滚动
	$(".sub_slide_box ul li a").prepend("<span class='slide_tips_intro block abso t_hide'>阴影层</span>")//动态加载阴影 防止IE6错误
	var sub_slide=$(".sub_slide_box ul li").length
	if(sub_slide<=1){
		$(".control").hide()
		$(".sub_slide_box ul li").show()
	}
	else{
		$(".sub_slide_box").css("height","170px")
		for(i=0;i<sub_slide;i++){
			$(".control").append("<a href='#' title="+(i+1)+" class='pointer'></a>")
		}

		$(".sub_slide_box,control a").hover( //鼠标放上停止播放
			function(){
				clearInterval(s_t)
			},
			function(){
				s_t = setInterval("showAuto(	$('.control a.current_control').next()	)",3000)//主题图
			}
		)
	}

	$(".control a").each(function(x){//KV图的控制按钮
		$(".control a").eq(x).click(function(){
			$(this).addClass("current_control").siblings().removeClass("current_control")
			$(".sub_slide_box ul li").eq(x).siblings().fadeOut("slow")
			$(".sub_slide_box ul li").eq(x).fadeIn("slow")
			$(this).blur()
			return false
		})
	})
	$(".control a:first").trigger("click")//默认第一个按钮的点击事件




})

s_t = setInterval("showAuto(	$('.control a.current_control').next()	)",3000)//主题图
function showAuto(btn){
	if(btn.index('.control a')==-1){//找不到则-1
		$(".control a:first").trigger("click")
	}
	else{
		btn.trigger("click")
	}
}

