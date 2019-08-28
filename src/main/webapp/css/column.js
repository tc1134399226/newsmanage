let datas = new Date();
let da = datas.getDate();
let month = datas.getMonth() + 1;
let year = datas.getFullYear();
let min = datas.getMinutes();
let hours = datas.getHours();
let categoryname= location.search.split("=")[1].split("&")[0];
if (categoryname==="guoji"||categoryname==="guonei"){
    $("#redian").addClass("active")
}else if (categoryname==="fangchan"||categoryname==="caijing"||categoryname==="tiyu"){
    $("#qita").addClass("active")
}else {
    $("#"+categoryname).addClass("active")
}
//获取当前时间
$(".blog_date_div").html("<p>"+
    "<i class='glyphicon glyphicon-time'></i>&ensp;"+
    year + "-" + month + "-" + da + "&nbsp" + hours + ":" + min+
    "</p>");
//更新当前时间(每隔5s)
setInterval(function() {
    let datas = new Date();
    da = datas.getDate();
     month = datas.getMonth() + 1;
     year = datas.getFullYear();
     min = datas.getMinutes();
     hours = datas.getHours();
    $(".blog_date_div").html("<p>"+
    "<span class='glyphicon glyphicon-time'></span>"+
        year + "-" + month + "-" + da + "&nbsp" + hours + ":" + min+
    "</p>");
}, 5000);
//获取用户信息
$.ajax({
    type:"get",
    url:"/youya_news/initUser",
    success:function (result) {
        if (result!="false"){
            if (result.rolename==="小编"){
                $("#blogUserWrapper").attr("href","/youya_news/author/draftlist.html")
            }
            if (result.rolename==="会员"){
                $("#blogUserWrapper").attr("href","/youya_news/usermanage/message.html")
            }
            if (result.rolename==="管理员"){
                $("#blogUserWrapper").attr("href","/youya_news/administrator/articleReview.html")
            }
            $("#blogUserWrapper").html("" +
                "<img src=\""+result.icon+"\" class=\"img-fluid\" height=\"40\" width=\"40\">\n" +
                ""+result.username+"")
        }
    }
});
//搜索功能
function header_search(pageNum){
    let search=$(".form-control").val();
    $.ajax({
        type : "post",
        dataType:"json",
        contentType: "application/json;charset=utf-8",
        async:false,
        url : "/youya_news/ReleaseSystem/searchAllNews",
        data:JSON.stringify({
            pageNum:pageNum,
            categoryname:categoryname,
            search:search
        }),
        success : function(result) {
            context(result);
            searchpages(result);
            console.log(result);
            $(".blog_search").removeClass("show_search")
        },
        error : function(e){
            console.log(e.responseText);
        }
    })
}

//刷新页面
function reloadpage(pageNum){
    $.ajax({
        type : "post",
        dataType:"json",
        contentType: "application/json;charset=utf-8",
        async:false,
        url : "/youya_news/ReleaseSystem/getAllNews",
        data:JSON.stringify({
            pageNum:pageNum,
            categoryname:categoryname
        }),
        success : function(result) {
            context(result);
            newpages(result);
            console.log(result);
        },
        error : function(e){
            console.log(e.responseText);
        }
    })
}
reloadpage(0);

//拼接新闻列表
function context(result){
    let trStr="";
    let bigdiv="";
    $(result.list).each(function(index,item){
        if (result.list.length>1){
            if (index<2){
                bigdiv+="<div class=\"blog_food_bigdiv wow fadeInUp\" style=\"visibility: visible; animation-name: fadeInUp;\">\n" +
                    "<div class=\"blog_post_style2\">\n" +
                    "<!--头条新闻图片-->\n" +
                    "<div class=\"blog_post_style2_img\">\n" +
                    "<img src=\""+item.newsimg+"\" class=\"img-fluid\" alt=\"\" width='525' height='400'></div>\n" +
                    "<div class=\"blog_post_style2_content\">\n" +
                    "<!--头条新闻标题-->\n" +
                    "<h3><a href='/youya_news/news/article.html?newsid="+item.newsid+"'>"+item.newstitle+"</a></h3>\n" +
                    "<!--头条新闻作者-->\n" +
                    "<div class=\"blog_author_data\">\n" +
                    "<a href=\"#\">\n" +
                    "<img src=\""+item.icon+"\" class=\"img-fluid\" alt=\"\" width=\"34\" height=\"34\">\n" +
                    ""+item.username+"</a></div>\n" +
                    "<!--头条新闻浏览量和评论数-->\n" +
                    "<ul class=\"blog_meta_tags\">\n" +
                    "<!--浏览量--><li>\n" +
                    "<span class=\"blog_bg_blue\">\n" +
                    "<i class=\"glyphicon glyphicon-eye-open\"></i>\n" +
                    ""+item.newsclicks+"</span></li>\n" +
                    "<!--评论数-->\n" +
                    "<li><span class=\"blog_bg_pink\">\n" +
                    "<i class=\"fa fa-comments\"></i>\n" +
                    ""+item.newstalks+"</span></li></ul>" +
                    "<!--头条新闻副标题-->\n" +
                    "<p>"+item.newssubtitle+"</p>" +
                    "<!--头条新闻进入内文-->\n" +
                    "<a href='/youya_news/news/article.html?newsid="+item.newsid+"' class=\"blog_readmore\">\n" +
                    "查看更多</a></div></div></div>";
            }
            else {
                trStr+="<div class=\"blog_post_style2 wow fadeInUp\" style=\"visibility: visible; animation-name: fadeInUp;\">\n" +
                    "<div class=\"blog_post_style2\">\n" +
                    "<!--头条新闻图片-->\n" +
                    "<div class=\"blog_post_style2_img\">\n" +
                    "<img src=\""+item.newsimg+"\" class=\"img-fluid\" alt=\"\" width='180' height='180'></div>\n" +
                    "<div class=\"blog_post_style2_content\">\n" +
                    "<!--头条新闻标题-->\n" +
                    "<h3><a href='/youya_news/news/article.html?newsid="+item.newsid+"'>"+item.newstitle+"</a></h3>\n" +
                    "<!--头条新闻作者-->\n" +
                    "<div class=\"blog_author_data\">\n" +
                    "<a href=\"#\">\n" +
                    "<img src=\""+item.icon+"\" class=\"img-fluid\" alt=\"\" width=\"34\" height=\"34\">\n" +
                    ""+item.username+"</a></div>\n" +
                    "<!--头条新闻浏览量和评论数-->\n" +
                    "<ul class=\"blog_meta_tags\">\n" +
                    "<!--浏览量--><li>\n" +
                    "<span class=\"blog_bg_blue\">\n" +
                    "<i class=\"glyphicon glyphicon-eye-open\"></i>\n" +
                    ""+item.newsclicks+"</span></li>\n" +
                    "<!--评论数-->\n" +
                    "<li><span class=\"blog_bg_pink\">\n" +
                    "<i class=\"fa fa-comments\"></i>\n" +
                    ""+item.newstalks+"</span></li></ul>" +
                    "<!--头条新闻副标题-->\n" +
                    "<p>"+item.newssubtitle+"</p>" +
                    "<!--头条新闻进入内文-->\n" +
                    "<a href='/youya_news/news/article.html?newsid="+item.newsid+"' class=\"blog_readmore\">\n" +
                    "查看更多</a></div></div></div>";
            }
        }
        else {
            trStr+="<div class=\"blog_post_style2 wow fadeInUp\" style=\"visibility: visible; animation-name: fadeInUp;\">\n" +
                "<div class=\"blog_post_style2\">\n" +
                "<!--头条新闻图片-->\n" +
                "<div class=\"blog_post_style2_img\">\n" +
                "<img src=\""+item.newsimg+"\" class=\"img-fluid\" alt=\"\" width='180' height='180'></div>\n" +
                "<div class=\"blog_post_style2_content\">\n" +
                "<!--头条新闻标题-->\n" +
                "<h3><a href='/youya_news/news/article.html?newsid="+item.newsid+"'>"+item.newstitle+"</a></h3>\n" +
                "<!--头条新闻作者-->\n" +
                "<div class=\"blog_author_data\">\n" +
                "<a href=\"#\">\n" +
                "<img src=\""+item.icon+"\" class=\"img-fluid\" alt=\"\" width=\"34\" height=\"34\">\n" +
                ""+item.username+"</a></div>\n" +
                "<!--头条新闻浏览量和评论数-->\n" +
                "<ul class=\"blog_meta_tags\">\n" +
                "<!--浏览量--><li>\n" +
                "<span class=\"blog_bg_blue\">\n" +
                "<i class=\"glyphicon glyphicon-eye-open\"></i>\n" +
                ""+item.newsclicks+"</span></li>\n" +
                "<!--评论数-->\n" +
                "<li><span class=\"blog_bg_pink\">\n" +
                "<i class=\"fa fa-comments\"></i>\n" +
                ""+item.newstalks+"</span></li></ul>" +
                "<!--头条新闻副标题-->\n" +
                "<p>"+item.newssubtitle+"</p>" +
                "<!--头条新闻进入内文-->\n" +
                "<a href='/youya_news/news/article.html?newsid="+item.newsid+"' class=\"blog_readmore\">\n" +
                "查看更多</a></div></div></div>";
        }
    });
    $(".blog_food_style2").html(bigdiv);
    if ($(".blog_post_style2_img img").attr("src")===""||$(".blog_post_style2_img img").attr("src")==="null" ){
        $(".blog_post_style2_img img").attr("src","./banner2.jpg")
    }
    $(".blog_technology_slider").html(trStr);
}
//分页
function newpages(result){
    var splitePageStr = "<li id='prePage'><a onclick='reloadpage("+result.prePage+")' href='javascript:void(0);'>上一页</a></li>";
    for(var i=1;i<=result.pages;i++){
        splitePageStr +="<li id='pages"+i+"'><a onclick='reloadpage("+i+")' href='javascript:void(0);'>"+i+"</a></li>";
    }
    splitePageStr += "<li id='nextPage'><a onclick='reloadpage("+result.nextPage+")' href='javascript:void(0);'>下一页</a></li>";
    $(".pagination").html(splitePageStr);

    if (result.isFirstPage){
        $("#prePage").addClass("disabled");
        $("#prePage a").removeAttr('onclick');
    }
    if (result.isLastPage){
        $("#nextPage").addClass("disabled");
        $("#nextPage a").removeAttr('onclick');
    }
    $("#pages"+result.pageNum).addClass("active");
    $("#pages"+result.pageNum+" a").removeAttr("onclick");
}
//搜索分页
function searchpages(result) {
    var splitePageStr = "<li id='prePage'><a onclick='header_search("+result.prePage+")' href='javascript:void(0);'>上一页</a></li>";
    for(var i=1;i<=result.pages;i++){
        splitePageStr +="<li id='pages"+i+"'><a onclick='header_search("+i+")' href='javascript:void(0);'>"+i+"</a></li>";
    }
    splitePageStr += "<li id='nextPage'><a onclick='header_search("+result.nextPage+")' href='javascript:void(0);'>下一页</a></li>";
    $(".pagination").html(splitePageStr);

    if (result.isFirstPage){
        $("#prePage").addClass("disabled");
        $("#prePage a").removeAttr('onclick');
    }
    if (result.isLastPage){
        $("#nextPage").addClass("disabled");
        $("#nextPage a").removeAttr('onclick');
    }
    $("#pages"+result.pageNum).addClass("active");
    $("#pages"+result.pageNum+" a").removeAttr("onclick");
}