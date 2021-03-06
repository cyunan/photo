package com.example.photo.bean.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//商品热卖表
@Entity
public class Store_hotInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置为自动递增
    private int product_id;//商品id
    private String name;//商品名称
    private String image;//商品图片
    private String cover_price;//目前价格

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        this.cover_price = cover_price;
    }
}
