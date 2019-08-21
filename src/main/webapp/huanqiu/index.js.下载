
$(function(){
	$(".commentDay li").click(function(){
		$(".commentDay li").removeClass("commentActive");
		$(this).addClass("commentActive");
		$(".commentDetail li").removeClass("commentDshow");
		$(".commentDetail li").eq($(this).index()).addClass("commentDshow");
	});

	$(".navMore").click(function(){
		$(".navMore").toggleClass("moreNavShow");
		$(".moreNav").toggle();
		$(".navMore").find('em').toggle();
	});

	function bcTab(bcNavId,bcConId){
    $(bcNavId).find("a").hover(function(){
       $(bcNavId).find("a").removeClass("bcActive");
       $(this).addClass("bcActive");
       $(bcConId).find("ul").hide();
       $(bcConId).find("ul").eq($(this).index()).show();
    });
	}

	bcTab("#bcTab1","#bcTabCon1");
	bcTab("#bcTab2","#bcTabCon2");
});