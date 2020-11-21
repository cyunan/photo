package com.example.photo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户信息表
 */
@Entity
public class User_Info {
    @Id
    private String id_unique;//唯一ID
    private String head_url;//头像
    private String name;//昵称
    private String hr_sign;//主页推荐标识（哪几个ViewPager）

    public String getId_unique() {
        return id_unique;
    }

    public void setId_unique(String id_unique) {
        this.id_unique = id_unique;
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

    public String getHr_sign() {
        return hr_sign;
    }

    public void setHr_sign(String hr_sign) {
        this.hr_sign = hr_sign;
    }
}
