package com.qf.news.controller;


import com.qf.news.pojo.ArticleInfo;
import com.qf.news.service.NewsArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("news")
public class NewsArticleInfoController {

    @Autowired
    NewsArticleInfoService newsArticleInfoService;

    //设置富文本编辑器(编辑文章和上传图片)
    static String UPLOAD_PATH = "/static/upload/";
    @ResponseBody
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        //{属性:"值"}
        //"值"

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        //%s占位符
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        System.out.println(serverPath);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }
    //根据articleId查询编辑的新闻显示到预览页面
    @RequestMapping("getReleaseInfoById")
    @ResponseBody
    public ArticleInfo getReleaseInfoById(@RequestParam int articleId){
        return newsArticleInfoService.getReleaseInfoById(articleId);
    }

    //用户在前台输入新闻添加到数据库
    @RequestMapping("commitArticle")
    @ResponseBody
    public boolean commitArticle(@RequestBody ArticleInfo articleInfo){
        return newsArticleInfoService.commitArticle(articleInfo);

    }

    //根据输入的新闻内容查询获取articleId
    @RequestMapping("getArticleInfoIdById")
    @ResponseBody
    public ArticleInfo getArticleInfoIdById(@RequestBody ArticleInfo articleInfo){
        return newsArticleInfoService.getArticleInfoIdById(articleInfo);
    }

    //修改新闻状态
    @RequestMapping("updateStatus")
    @ResponseBody
    public boolean updateStatus(@RequestParam int articleId){
        return newsArticleInfoService.updateStatus(articleId);
    }

    //修改处于编辑未提交审核状态的新闻 并确认提交
    @RequestMapping("secondCommitArticle")
    @ResponseBody
    public boolean secondCommitArticle(@RequestBody ArticleInfo articleInfo){
        return newsArticleInfoService.secondCommitArticle(articleInfo);
    }

    /**
     * 获取ip值
     * @param articleInfo
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("getIP")
    @ResponseBody
    public void doGet(@RequestBody ArticleInfo articleInfo, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        String uri = request.getRequestURI();//返回请求行中的资源名称
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = request.getRemoteAddr();//返回发出请求的IP地址
        String params = request.getQueryString();//返回请求行中的参数部分
        String host=request.getRemoteHost();//返回发出请求的客户机的主机名
        int port =request.getRemotePort();//返回发出请求的客户机的端口号。
        String IP=request.getRemoteHost();
//
        articleInfo.setUserIp(ip); //赋值
//
        //存储ip地址值到数据库
        newsArticleInfoService.getIP(articleInfo);
    }




    /**
     * 上传封面图
     * @param dropzFile
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();

        //创建文件需要存储的路径
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        //如果目标文件夹不存在我就创建它
        if(!destPath.exists()){
            destPath.mkdirs();
        }
        //获取文件的后缀名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));

        String destFileName = UUID.randomUUID()+fileSuffix;
        System.out.println(destFileName);
        File destFile = new File(destPath,destFileName);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);
        result.put("status",200);
        //http://localhost:8080/xxxxx/xxxx.jpg
        result.put("filePath","http://localhost:8080/static/upload/"+destFileName);
        return result;
    }


    /**
     * 获取新闻封面图
     * @param articleInfo
     * @return
     */
    @RequestMapping("uploadCover")
    @ResponseBody
    public boolean uploadCover(@RequestBody ArticleInfo articleInfo){
        return newsArticleInfoService.uploadCover(articleInfo);
    }

}
