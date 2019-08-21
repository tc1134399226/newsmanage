package com.qf.news.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Type {
    private Integer typeId;
    private String typeName;
    private List<Article> articles;
}
