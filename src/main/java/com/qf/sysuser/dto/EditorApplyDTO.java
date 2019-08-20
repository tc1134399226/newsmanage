package com.qf.sysuser.dto;

import lombok.Data;

@Data
public class EditorApplyDTO {
    Integer userId;
    String realName;
    String idCardBack;
    String idCardFront;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }


    @Override
    public String toString() {
        return "EditorApplyDTO{" +
                "userId=" + userId +
                ", realName='" + realName + '\'' +
                ", idCardBack='" + idCardBack + '\'' +
                ", idCardFront='" + idCardFront + '\'' +
                '}';
    }
}
