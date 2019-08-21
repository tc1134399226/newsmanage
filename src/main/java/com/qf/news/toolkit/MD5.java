package com.qf.news.toolkit;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    public static String encodePassword(String psw){
        String s = DigestUtils.md5Hex(psw);
        //再次加密循环截取加密
        for(int i=0;i<10;i++){
            s = DigestUtils.md5Hex(s.substring(15));
        }
        return s;
    }
}
