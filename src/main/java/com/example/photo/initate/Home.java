package com.example.photo.initate;

import com.example.photo.File_init;
import com.example.photo.ResponseUtil;
import com.example.photo.bean.init.Article_Rusult;
import com.example.photo.bean.init.Home_Recommed;
import com.example.photo.bean.recommed.HR_ImageArr;
import com.example.photo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//主页操作类
@Service
public class Home {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArtLabel_Repository lr;
    @Autowired
    private Article_Repository ar;
    @Autowired
    private File_init fi;
    @Autowired
    private ArtComment_Repository ac_r;
    @Autowired
    private Art_Mapper art_r;

    public Object home_recommed() {
        List<HR_ImageArr> imagearr = userMapper.getImagearr();

        List<Article_Rusult> articles = art_r.getArticles();

        return ResponseUtil.ok("查询成功",new Home_Recommed(imagearr,articles));
    }





}
