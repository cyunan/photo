package com.example.photo.bean.vlog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//文章评论
@Entity
public class Vlog_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//流水id
    private String vlog_id;//视频id
    private String id_unique;//评论者id
    private String comment;//评论内容

    public Vlog_Comment() {
    }

    public Vlog_Comment(String vlog_id, String id_unique, String comment) {
        this.vlog_id = vlog_id;
        this.id_unique = id_unique;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVlog_id() {
        return vlog_id;
    }

    public void setVlog_id(String vlog_id) {
        this.vlog_id = vlog_id;
    }

    public String getId_unique() {
        return id_unique;
    }

    public void setId_unique(String id_unique) {
        this.id_unique = id_unique;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
