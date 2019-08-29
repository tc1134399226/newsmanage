package com.qf.news.controller;


import com.qf.news.dto.ReportDTO;
import com.qf.news.pojo.ArticleInfo;
import com.qf.news.pojo.LoveArticle;
import com.qf.news.pojo.UserInfo;
import com.qf.news.service.NewsArticleInfoService;
import com.qf.news.vo.ArticleInfoVO;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
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
    @RequestMapping(value = "wangEditor", method = RequestMethod.POST)
    public Map<String, Object> wangEditor(MultipartFile editorFile, HttpServletRequest request) {
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
    public ArticleInfoVO getReleaseInfoById(@RequestParam int articleId,
                                            HttpSession session){
//        long articleId1 = (Long)session.getAttribute("articleId");
        return newsArticleInfoService.getReleaseInfoById(articleId);
    }

    /**
     * 获取文章热度
     * @param session
     * @return
     */
    @RequestMapping("getArticleAndLoveNumAndComNum")
    @ResponseBody
    public Object getArticleAndLoveNumAndComNum( HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Long articleId = (Long) session.getAttribute("articleId");
        System.out.print("articleId为");
        System.out.println(articleId);
        if (userInfo==null){
            return newsArticleInfoService.getArticleAndLoveNumAndComNum(articleId,null);
        }
        System.out.println("userId为"+userInfo.getUserId());
//        if (articleId==0){
//          return false;
//      }
        return newsArticleInfoService.getArticleAndLoveNumAndComNum(articleId,userInfo.getUserId());
    }


    //用户在前台输入新闻添加到数据库
    @RequestMapping("commitArticle")
    @ResponseBody
    public boolean commitArticle(@RequestBody ArticleInfo articleInfo){
        if (articleInfo.getArticleId()!=0){
            return newsArticleInfoService.uploadArticle(articleInfo);
        }else {
            return newsArticleInfoService.commitArticle(articleInfo);
        }
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
        if (articleInfo.getArticleId()==0){
            return newsArticleInfoService.commitArticle(articleInfo);
        }else {
            return newsArticleInfoService.secondCommitArticle(articleInfo);
        }
    }

    /**
     * 获取ip值
     * @param articleInfo
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("getIP")
    @ResponseBody
    public boolean doGet(@RequestBody ArticleInfo articleInfo, HttpServletRequest request,
                      HttpSession session)
            throws ServletException, IOException

    {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String uri = request.getRequestURI();//返回请求行中的资源名称
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = request.getRemoteAddr();//返回发出请求的IP地址
        String params = request.getQueryString();//返回请求行中的参数部分
        String host=request.getRemoteHost();//返回发出请求的客户机的主机名
        int port =request.getRemotePort();//返回发出请求的客户机的端口号。
        String IP=request.getRemoteHost();
//
        articleInfo.setUserIp(ip); //赋值
//        articleInfo.setUserId(userInfo.getUserId());
        //存储ip地址值到数据库
       return   newsArticleInfoService.getIP(articleInfo);
    }
    @RequestMapping("insertIP")
    @ResponseBody
    public boolean insertIP(@RequestBody ArticleInfo articleInfo, HttpServletRequest request,
                         HttpSession session)
            throws ServletException, IOException

    {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String uri = request.getRequestURI();//返回请求行中的资源名称
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = request.getRemoteAddr();//返回发出请求的IP地址
        String params = request.getQueryString();//返回请求行中的参数部分
        String host=request.getRemoteHost();//返回发出请求的客户机的主机名
        int port =request.getRemotePort();//返回发出请求的客户机的端口号。
        String IP=request.getRemoteHost();
//
        articleInfo.setUserIp(ip); //赋值
//        articleInfo.setUserId(userInfo.getUserId());
        articleInfo.setUserId(1);
        //存储ip地址值到数据库
        return   newsArticleInfoService.insertIP(articleInfo);
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
        result.put("filePath","static/upload/"+destFileName);
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

    @RequestMapping("loveArticle")
    @ResponseBody
    public Object loveArticle(HttpSession session
                              ) throws IOException {
                UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        long articleId = (Long)session.getAttribute("articleId");
            if (userInfo == null) {
                return false;
            }
        System.out.println(userInfo.getUserId()+":"+articleId);
        return newsArticleInfoService.loveArticle(userInfo.getUserId(),articleId);
    }

    //显示新闻
    @RequestMapping("fileshow")
    @ResponseBody
    public void showload(String filename,HttpServletResponse response) throws Exception{
        File file = new File("static/upload",filename);
        byte[] bs = null;
        FileInputStream is = new FileInputStream(file);
        bs = new byte[is.available()];
        int read = is.read(bs);
        response.getOutputStream().write(bs,0,read);
        is.close();
    }
    @RequestMapping("toArticleContent")
    @ResponseBody
    public Object toArticleContent(@RequestParam Long articleId,HttpSession session) {
        if (articleId <=0) {
          return false;
      }
        session.setAttribute("articleId", articleId);
//        Long attribute = (Long) session.getAttribute("articleId");
//        System.out.println(attribute);
//        if (attribute == null) {
//            return false;
//        }
        return (Long)session.getAttribute("articleId")>0;
    }

    /**
     * 上传举报信息
     * @param reportDTO
     * @param session
     * @return
     */
    @RequestMapping("toReport")
    @ResponseBody
    public boolean toReport(@RequestBody ReportDTO reportDTO,HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        reportDTO.setUserId(userInfo.getUserId());
        return newsArticleInfoService.toReport(reportDTO);
    }


}
