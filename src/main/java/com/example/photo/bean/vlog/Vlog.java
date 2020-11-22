package com.example.photo.bean.vlog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//文章表
@Entity
public class Vlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//视频id
    private String id_unique;//发布者id
    private String title;//标题
    private String content;//内容
    private String vlog_url;//视频
    private Date date;//视频发布时间
    private int likes;//点赞数

    public Vlog() {
    }

    public Vlog(String id_unique, String title, String content, String vlog_url, Date date, int likes) {
        this.id = id;
        this.id_unique = id_unique;
        this.title = title;
        this.content = content;
        this.vlog_url = vlog_url;
        this.date = date;
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

    public String getVlog_url() {
        return vlog_url;
    }

    public void setVlog_url(String vlog_url) {
        this.vlog_url = vlog_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
