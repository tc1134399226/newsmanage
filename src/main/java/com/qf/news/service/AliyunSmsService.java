package com.qf.news.service;

public interface AliyunSmsService {
    /**
     * 短信验证码
     * @param mobile
     * @return
     */
    public String getPhonemsg(String mobile);


}
