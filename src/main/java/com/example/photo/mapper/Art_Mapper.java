package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.init.Article_Rusult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Art_Mapper {
    List<Article_Rusult> getArticles();
    List<Article_Rusult> getArticles_for_id_unique(@Param("id_unique") String id_unique);
    List<Article_Rusult> getArticles_for_label(@Param("lab_id")String lab_id);
}
