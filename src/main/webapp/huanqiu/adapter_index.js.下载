

// 根据缓存和设备跳转到相应的页面 
function setCookie(c_name,value,expiredays)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
        ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())+";path=/;domain=huanqiu.com";
}
function getCookie(c_name)
{
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}

(function(W){
    var site = getCookie('domain');
    if(window.location.search.length&&window.location.search.indexOf("from=mobile")!=-1) return;
    if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent.toLowerCase())){
        if(document.referrer === 'http://m.huanqiu.com/'){
            return ;
        }
        if(site==''){
            W.location.href = "http://www.huanqiu.com/select.html";
        }else{
            if(site!='www'){
                window.location.href="http://"+site+".huanqiu.com/";
            }
        }
    }
})(window);