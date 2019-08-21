package com.qf.news.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Area {
    private Integer areaId;
    private String areaName;
    private List<Type> types;
}
