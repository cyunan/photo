package com.example.photo.bean.vlog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//文章标签
@Entity
public class Vlog_Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int id;//流水id
    private int vlog_id;//文章id
    private String lab_id;//标签id

    public Vlog_Label() {
    }

    public Vlog_Label(int vlog_id, String lab_id) {
        this.vlog_id = vlog_id;
        this.lab_id = lab_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVlog_id() {
        return vlog_id;
    }

    public void setVlog_id(int vlog_id) {
        this.vlog_id = vlog_id;
    }

    public String getLab_id() {
        return lab_id;
    }

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id;
    }
}
