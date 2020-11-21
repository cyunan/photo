package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Comment;
import com.example.photo.bean.art.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtComment_Repository extends JpaRepository<Art_Comment,Integer> {
}
