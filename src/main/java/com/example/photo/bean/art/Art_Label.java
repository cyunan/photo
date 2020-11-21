package com.example.photo.bean.art;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//文章标签
@Entity
public class Art_Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//流水id
    private int art_id;//文章id
    private String lab_id;//标签id

    public Art_Label() {
    }

    public Art_Label(int art_id, String labid) {
        this.art_id = art_id;
        this.lab_id = labid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getLab_id() {
        return lab_id;
    }

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id;
    }
}
