/*通用广告加载代码*/
(function(){
	
	// 添加函数映射
	window["AD_SURVEY_Add_PageTag"] = _add_page_tag;
	window["AD_SURVEY_Add_AdPos"] = _add_ad_pos;
	window["AD_SURVEY_AD_LOAD"] = _ad_load;
	window["AD_SURVEY_IFRAME_LOAD"] = _iframe_load_content;

	// 广告内容缓存
	var AD_SURVEY_IFRAME_CONTENTS = new Array();
	
	// 已处理广告位
	var AD_SURVEY_AD_POS_DONE = new Array();

	/* 全局变量 */
	// 页面标签
	var AD_SURVEY_PAGE_TAGS = null;
	// 预览创意ID
	var AD_SURVEY_PREVIEW_CREATIVE_ID = null;
	// 预览广告位ID
	var AD_SURVEY_PREVIEW_AD_POS_ID = null;

	/* 广告加载代码初始化 */
	function _init() {
		/* 获取页面广告在线预览参数*/
		// 获取页面URL
		var url = window.location.href;
		if(url==null || url=="" || url==undefined) {
			return;
		}
		// 解析参数中是否有预览参数#PREVIEW_CREATIVE_ID=xxx&PREVIEW_AD_POS_ID=xxx
		var hasPreviewParams = url.indexOf("#PREVIEW_CREATIVE_ID=")!=-1 && url.indexOf("&PREVIEW_AD_POS_ID=")!=-1;
		// 如果没有预览参数，直接返回false
		if(!hasPreviewParams) {
			return;
		}
		// 保存预览参数
		AD_SURVEY_PREVIEW_CREATIVE_ID = url.substring(url.indexOf("#PREVIEW_CREATIVE_ID=")+21 , url.indexOf("&PREVIEW_AD_POS_ID="));
		AD_SURVEY_PREVIEW_AD_POS_ID = url.substring(url.indexOf("&PREVIEW_AD_POS_ID=") + 19);
	}
	
	/* 添加页面标签 */
	function _add_page_tag() {
		// 获取可变参数
		var params = new Array();  
		var paramsSerial = "";
		for (var i=0; i<arguments.length; i++) {  
			params[i] = arguments[i];
			paramsSerial = paramsSerial + (i==0 ? "" : ".") + arguments[i];
		}
		// 判断参数有效性
		if(params.length<=1) {
			return;
		}
		// 保存页面标签值
		if(AD_SURVEY_PAGE_TAGS==null || AD_SURVEY_PAGE_TAGS==undefined || AD_SURVEY_PAGE_TAGS=="") {
			AD_SURVEY_PAGE_TAGS = paramsSerial;
		}
		else {
			AD_SURVEY_PAGE_TAGS = AD_SURVEY_PAGE_TAGS + "*" + paramsSerial;
		}
	}

	/* 增加广告位 */
	function _add_ad_pos(sid) {
		// 参数有效性判断
		if(sid==null || sid==undefined) {
			return;
		}
		// protocol
		var _matchDemandProtocol = (("https:" == document.location.protocol) ? "https://" : "http://");
		// 生成广告请求串
		var matchUrl = _matchDemandProtocol + "sspservice.ad-survey.com/pub/match?m=fn&sid="+sid+"&scn=1&scf=js*html*image*flash*text";
		// 添加页面标签
		if(AD_SURVEY_PAGE_TAGS!=null && AD_SURVEY_PAGE_TAGS!="" && AD_SURVEY_PAGE_TAGS!=undefined) {
			matchUrl += "&pts=" + AD_SURVEY_PAGE_TAGS;
		}
		// 添加预览参数
		if(AD_SURVEY_PREVIEW_CREATIVE_ID!=null && AD_SURVEY_PREVIEW_CREATIVE_ID!="" && AD_SURVEY_PREVIEW_CREATIVE_ID!=undefined 
				&& AD_SURVEY_PREVIEW_AD_POS_ID!=null && AD_SURVEY_PREVIEW_AD_POS_ID!="" && AD_SURVEY_PREVIEW_AD_POS_ID!=undefined
				&& parseInt(AD_SURVEY_PREVIEW_AD_POS_ID,10)==parseInt(sid,10)) {
			matchUrl += "&pci=" + AD_SURVEY_PREVIEW_CREATIVE_ID;
		}
		// 请求串添加时间戳
		matchUrl += "&timestamp=" + new Date().getTime();
		// 页面加载广告
		document.write("<script id='AD_SURVEY_LOAD_ADSLOT_"+sid+"' type='text/javascript' charset='utf-8' src='"+matchUrl+"'></script>");
	}

	/* 广告加载 */
	function _ad_load(matchResults) {
		// 判断广告匹配结果有效性
		if(matchResults==null || matchResults==undefined || matchResults.length<=0) {
			return;
		}
		var matchResult = matchResults[0];
		if(matchResult.result==null || matchResult==undefined 
				|| matchResult.ad_pos_id==null || matchResult.ad_pos_id==undefined
				|| matchResult.ad_pos_width==null || matchResult.ad_pos_width==undefined
				|| matchResult.ad_pos_height==null || matchResult.ad_pos_height==undefined) {
			return;
		}
		// protocol
		var _matchDemandProtocol = (("https:" == document.location.protocol) ? "https://" : "http://");		
		// 是否固定显示广告位
		var isAdPosFix = (matchResult.ad_pos_fix!=undefined && matchResult.ad_pos_fix!=null && parseInt(matchResult.ad_pos_fix,10)==1 || parseInt(matchResult.result,10)==1) ? true : false;
		
		// 是否显示广告位标记
		var isAdPosSign = (matchResult.ad_pos_sign!=undefined && matchResult.ad_pos_sign!=null && parseInt(matchResult.ad_pos_sign,10)==1) ? true : false;		
		// 创意设置显示广告位标记
		var creativeSignPos = (matchResult.creative_sign_pos!=undefined && matchResult.creative_sign_pos!=null && parseInt(matchResult.creative_sign_pos,10)>=1 && parseInt(matchResult.creative_sign_pos,10)<=4) ? parseInt(matchResult.creative_sign_pos,10) : 0;
		var creativeSignStyle = (matchResult.creative_sign_style!=undefined && matchResult.creative_sign_style!=null && parseInt(matchResult.creative_sign_style,10)>=1 && parseInt(matchResult.creative_sign_style,10)<=4) ? parseInt(matchResult.creative_sign_style,10) : 0;
		// 广告位标记设置优先优先级：创意 > 广告位
		var adSignHtml = "";
		if(creativeSignPos!=0 && creativeSignStyle!=0) {
			adSignHtml = "<a style='"+(creativeSignStyle==4?"width:16px;height:16px;":"width:29px;height:16px;")+"overflow:hidden;position:absolute;";
			if(creativeSignPos==1) {
				adSignHtml += "right:0px;top:0px;";
			}else if(creativeSignPos==2) {
				adSignHtml += "right:0px;bottom:0px;";
			}else if(creativeSignPos==3) {
				adSignHtml += "left:0px;bottom:0px;";
			}else if(creativeSignPos==4) {
				adSignHtml += "left:0px;top:0px;";
			}
			adSignHtml += "z-index:10000;background:url("+_matchDemandProtocol+"ipengtai.huanqiu.com/resource/image/";
			if(creativeSignStyle==1) {
				adSignHtml += "sign_common.png) no-repeat;'></a>";
			}else if(creativeSignStyle==2) {
				adSignHtml += "sign_border.png) no-repeat;'></a>";
			}else if(creativeSignStyle==3) {
				adSignHtml += "sign_black.png) no-repeat;'></a>";
			}else if(creativeSignStyle==4) {
				adSignHtml += "sign_baidu2.png) no-repeat;'></a>";
			}
		} else if(isAdPosSign) {
			adSignHtml = "<a style='width:29px;height:16px;overflow:hidden;position:absolute;right:0px;top:0px;z-index:10000;background:url("+_matchDemandProtocol+"ipengtai.huanqiu.com/resource/image/ad_sign.png) no-repeat;'></a>";
		}

		// 在广告加载脚本后增加div区域,用户显示广告
		var adslotHtmlBegin = "<div id='ad_survey_ad_slot_"+matchResult.ad_pos_id+"' style='width:"+matchResult.ad_pos_width+"px;height:"+matchResult.ad_pos_height+"px;margin:0px;padding:0px;border:0px;display:"+(isAdPosFix ? "block" : "none")+";overflow:hidden;position:relative;'>";
		var adslotHtmlEnd = adSignHtml + "</div>";
		// 如果无广告，直接退出
		if(matchResult.result=='0' || matchResult.type==null || matchResult.type==undefined
				|| matchResult.content==null || matchResult.content==undefined || matchResult.content.length==0) {
			document.write(adslotHtmlBegin + adslotHtmlEnd);
			return;
		}
		// 基于广告类型，分别展现
		if(matchResult.content.toLowerCase().indexOf("<html>")==-1 
				&& matchResult.content.toLowerCase().indexOf("<script")!=-1
				&& matchResult.content.toLowerCase().lastIndexOf("</script>")!=-1) {
			// 如果创意只是script，直接显示
			_show_script_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd);
		}
		else {
			// 显示广告
			if(matchResult.type=='js' && (matchResult.content.toLowerCase().lastIndexOf("</script>")+9)!=matchResult.content.length) {
				// 如果广告类型是JS,并且不带script标签,展现js广告
				_show_bare_script_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd);
			} else if(matchResult.type=='html' || matchResult.type=='js' && (matchResult.content.toLowerCase().lastIndexOf("</script>")+9)==matchResult.content.length){
				// 如果广告类型是html，并且不带script标签,展现html广告
				_show_html_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd);
			}
		}
	}

	/* 显示javascript广告(即创意内容为script) */
	function _show_script_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd) {
		// 直接输出广告内容
		document.write(adslotHtmlBegin + matchResult.content + adslotHtmlEnd);
	}

	/* 显示裸露javascript广告(即创意内容为script，但是没有封装在script标签内) */
	function _show_bare_script_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd) {
		// 增加内部script元素及广告内容
		var adJavascriptContent = adslotHtmlBegin + "<script type='text/javascript'>" + matchResult.content + "</script>" + adslotHtmlEnd;
		// 输出广告内容
		document.write(adJavascriptContent);
	}

	/* 显示html广告 */
	function _show_html_ad(matchResult,adslotHtmlBegin,adslotHtmlEnd) {
		// 如果广告无内容，不进行任何处理
		if(matchResult.content==null || matchResult.content==undefined || matchResult.content.length<=0) {
			// 只输出广告位
			document.write(adslotHtmlBegin + adslotHtmlEnd);
			return;
		}
		// 如果html广告内容无script标签，并且不是html页面，不生成iframe，直接输入内容
		if(matchResult.content.toLowerCase().indexOf("<script")==-1 && matchResult.content.toLowerCase().indexOf("<html>")==-1) {
			document.write(adslotHtmlBegin + matchResult.content + adslotHtmlEnd);
			return;
		}
		// 获取广告内容
		var contentHtml = matchResult.content;
		if(contentHtml.indexOf("<html>")==-1 && contentHtml.indexOf("</html>")==-1) {
			contentHtml = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><title>ad</title></head><body style='margin:0px;padding:0px;background-color:transparent;' marginwidth='0' marginheight='0'>" + contentHtml + "</body></html>";
 		}
		AD_SURVEY_IFRAME_CONTENTS[matchResult.ad_pos_id] = contentHtml;
		// 增加iframe显示功能
		var iframeContent = adslotHtmlBegin;
		iframeContent += "<iframe id='ad_survey_ad_slot_iframe_"+matchResult.ad_pos_id+"'";
		iframeContent += " src='about:blank' scrolling='no' marginheight='0' marginwidth='0' frameborder='0' allowtransparency='true'";
		iframeContent += " height='" + matchResult.ad_pos_height + "' width='" + matchResult.ad_pos_width + "' vspace='0' hspace='0'";
		iframeContent += " style='padding:0px;border:0;vertical-align:bottom;margin:0px;display:block;' onload='javascript:AD_SURVEY_IFRAME_LOAD("+matchResult.ad_pos_id+");'>";
		iframeContent += "</iframe>";
		iframeContent += adslotHtmlEnd;
		document.write(iframeContent);
	}

	/*加载iframe页面内容*/
	function _iframe_load_content(ad_pos_id) {
		// 判断广告是否已经处理
		if(AD_SURVEY_AD_POS_DONE[ad_pos_id]==1) {
			return;
		}
		AD_SURVEY_AD_POS_DONE[ad_pos_id]=1;
		// 获取内容,清除内存
		var contentHtml = AD_SURVEY_IFRAME_CONTENTS[ad_pos_id];
		if(contentHtml==null || contentHtml==undefined || contentHtml.length<=0) {
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = null;
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = undefined;
			return;
		}
		// 写入广告内容
		var iframeElement = document.getElementById("ad_survey_ad_slot_iframe_" + ad_pos_id);
		if(iframeElement==undefined || iframeElement==null) {
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = null;
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = undefined;
			return;
		}
		// iframe中写入广告内容
		try{
			iframeElement.contentWindow.document.open("text/html", "replace");
			iframeElement.contentWindow.document.write(contentHtml);
			iframeElement.contentWindow.document.close();
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = null;
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = undefined;
		}catch(e) {
			// 编写Javascript方法
			var content = "javascript:(function(){";
			content += "var content=decodeURIComponent(\"" + encodeURIComponent(contentHtml) + "\");";
			content += "document.open(\"text/html\",\"replace\");";
			content += "document.write(content);";
			content += "document.close();";
			content += "})();";
			iframeElement.src = content;
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = null;
			AD_SURVEY_IFRAME_CONTENTS[ad_pos_id] = undefined;
		}
	}

	// 调用初始化
	_init();

})(window);
