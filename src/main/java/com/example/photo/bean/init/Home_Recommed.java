package com.example.photo.bean.init;

import com.example.photo.bean.recommed.HR_ImageArr;

import java.util.List;
//主页推荐
public class Home_Recommed {

    private List<HR_ImageArr> imageArr;//轮转图片
    private List<Article_Rusult> list_data;//推荐Listview数据

    public Home_Recommed() {
    }

    public Home_Recommed(List<HR_ImageArr> imageArr, List<Article_Rusult> list_data) {
        this.imageArr = imageArr;
        this.list_data = list_data;
    }

    public List<HR_ImageArr> getImageArr() {
        return imageArr;
    }

    public void setImageArr(List<HR_ImageArr> imageArr) {
        this.imageArr = imageArr;
    }

    public List<Article_Rusult> getList_data() {
        return list_data;
    }

    public void setList_data(List<Article_Rusult> list_data) {
        this.list_data = list_data;
    }
}
