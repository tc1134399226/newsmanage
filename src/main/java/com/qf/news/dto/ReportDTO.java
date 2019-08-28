package com.qf.news.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReportDTO {
    long userId;
    long ruserId;
    long artile;
    String context;
    Timestamp createTime;
}
