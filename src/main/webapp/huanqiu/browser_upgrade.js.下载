
$(function(){
    var ie6 = !-[1,]&&!window.XMLHttpRequest;
    if(ie6) {
        var $tip = $(document.createElement("div"));
        $tip
            .addClass("ieTips")
            .prependTo(".wrap")
            .html("<em></em>您现在使用的浏览器版本过低，页面上部分内容可能无法正常显示，建议您升级到最新版浏览器。<span><a href=\"javascript:void(0);\"></a></span>");
        $tip.find("a").on("click",function() {
            $tip.remove();
        });
    }
    
    //
    (function() {
        var loc = window.location.host;
        loc&&(loc.search(/huanqiu/ig)==-1)&&(window.location="http://www.huanqiu.com");
    })();
})

