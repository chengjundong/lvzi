// JavaScript Document
$(function(){
	$("ul.menu li").eq(current_menu).addClass("current_menu")//主导航
	$(".search_btn").hover(function(){$(this).css("background-position","0 -27px")},function(){$(this).css("background-position","0 0")})//搜索按钮

	if(typeof(sub_menu)!=="undefined"){ //二级导航
		$(".sub_nav_wrap ul li.sub_nav:eq("+sub_menu+") a:first").addClass("current_sub")

		if($(".sub_nav_wrap ul li.sub_nav:eq("+sub_menu+") a").hasClass("has_son")){
			$(".sub_nav_wrap ul li.sub_nav:eq("+sub_menu+") a").next("ul").show()

			$(".sub_nav_wrap ul li.sub_nav:eq("+sub_menu+") a:first").addClass("current_son")
			if(typeof(sub_son)!=="undefined"){//如果有子级
				$(".sub_nav_wrap ul li.sub_nav:eq("+sub_menu+") a:first").addClass("unbind_click")
				$("a.current_son").next("ul").find("a:eq("+sub_son+")").addClass("current_sub")
			}
		}
	}

	$("a.has_son").toggle(function(){//点击出现2级菜单
		$(this).addClass("current_son").next("ul").slideDown('fast')
	},function(){
		if(!$(this).hasClass("unbind_click")){
			$(this).removeClass("current_son").next("ul").slideUp('fast')
		}
	})


	//下拉城市
	$("span.input_drop").toggle(function(){
		$(this).children("ul.drop_list").slideDown("fast")
	},function(){
		$(this).children("ul.drop_list").slideUp("fast")
	})

	$(document).click(function(){
		$("ul.drop_list:visible").parent().trigger("click")
	})

	$("a.false,a.has_son").click(function(){
		return false;
	})
    /*
	btn
	*/
	$(".detail_btn,.back_list,.more_product_txt,.cook_btn").hover(function(){
		$(this).css("background-color","#817554")
	},
	function(){
		$(this).css("background-color","#3b521a")
	})


	$(".more_green,.more_brown").hover(function(){
		$(this).css("background-image","url("+$("#root").attr("rel")+"image/index/more_hover.gif)")
	},
	function(){
		$(this).css("background-image","url("+$("#root").attr("rel")+"image/index/more.gif)")
	})

	/*
	scro
	*/
	$(window).scroll(function(){
		if($(window).scrollTop()>100){
            if($("div.scro_top").length<=0){
				$("body").append("<div class='scro_top hide pointer t_hide'></div>")
			}
			_h=$(window).height()-60+$(window).scrollTop()
			if($.browser.version==6.0){
				$(".scro_top").css({"position":"absolute","top":_h+"px"})
			}
			else{
				$(".scro_top").css({"position":"fixed","bottom":"26px"})
			}

			$(".scro_top").show().css({"width":"34px","height":"40px","background-image":"url("+$("#root").attr("rel")+"image/hd/scrol.png)"}).click(function(){scro_to(".hd")}).hover(function(){$(this).css("background-position","0 -41px")},function(){$(this).css("background-position","0 0")})

			_w=$(window).width()
			if(_w<=980){
				$(".scro_top").css("right","20px")
			}
			else{
				$(".scro_top").css("right",(_w-980)/2-60+"px")
			}
		}
		else{
			$(".scro_top").hide()
            $(".scro_top").remove()
		}
	})

})

function scro_to(to,speed){ //设置滚动
	$("html,body").stop()
	if(!arguments[1]){
		speed=100
	}
	$("html,body").animate({scrollTop: $(to).offset().top},speed) //,body
	return false
}