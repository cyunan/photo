package com.example.photo.bean.init;

import java.util.Date;

public class HR_Article {
    private int id;//文章id
    private String id_unique;//发布者id
    private String title;//标题
    private String content;//内容
    private String image_url;//文章图片
    private Date date;//文章发布时间
    private int store;//文章评分
    private int likes;//点赞数

    private String head_url;//头像
    private String name;//昵称
    private String label;//标签

    public HR_Article() {
    }

    public HR_Article(String id_unique, String title, String content, String image_url, Date date, int store, int likes, String head_url, String name, String label) {
        this.id_unique = id_unique;
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.date = date;
        this.store = store;
        this.likes = likes;
        this.head_url = head_url;
        this.name = name;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_unique() {
        return id_unique;
    }

    public void setId_unique(String id_unique) {
        this.id_unique = id_unique;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
