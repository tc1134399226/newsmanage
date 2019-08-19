package com.qf.news.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("news")
@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String testDemo(){
        System.out.println("进来了");
        return "成功";
    }
}
