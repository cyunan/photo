package com.example.photo.bean.art;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
//文章表
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//文章id
    private String id_unique;//发布者id
    private String title;//标题
    private String content;//内容
    private String image_url;//文章图片
    private Date date;//文章发布时间
    private int store;//文章评分
    private int likes;//点赞数

    public Article() {
    }

    public Article(String id_unique, String title, String content, String image_url, Date date, int store, int likes) {
        this.id_unique = id_unique;
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.date = date;
        this.store = store;
        this.likes = likes;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
}
