package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.init.HR_Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Art_Mapper {
    List<HR_Article> getArticle();
    Art_Label findlabel(@Param("art_id") int art_id);
}
