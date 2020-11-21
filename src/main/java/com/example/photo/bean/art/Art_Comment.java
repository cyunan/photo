package com.example.photo.bean.art;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//文章评论
@Entity
public class Art_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//流水id
    private String art_id;//文章id
    private String id_unique;//评论者id
    private String comment;//评论内容

    public Art_Comment() {
    }

    public Art_Comment(String art_id, String id_unique, String comment) {
        this.art_id = art_id;
        this.id_unique = id_unique;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArt_id() {
        return art_id;
    }

    public void setArt_id(String art_id) {
        this.art_id = art_id;
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
