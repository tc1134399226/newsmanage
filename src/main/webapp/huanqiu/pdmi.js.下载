function getCookie(c_name){
    if (document.cookie.length>0){
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1){
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return decodeURI(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}
var item_id = window.location.href.replace(window.location.protocol, '').replace('//','').split('?')[0];
var uid = getCookie('user[uid]');
var _paq = _paq || [];
window['_paq'] = _paq;
_paq.push(['appkey', 'UAR-000139_459']);
_paq.push(['attr', 'itemid='+item_id]);
_paq.push(['uid', uid, uid == ''?'':'account']);
_paq.push(['trackPV']);

(function() {
    var pa = document.createElement('script'); pa.type = 'text/javascript'; pa.async = true;
    pa.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'rev.uar.hubpd.com/agent/pa.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(pa, s);
})();