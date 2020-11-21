package com.example.photo.mapper;

import com.example.photo.bean.art.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Article_Repository extends JpaRepository<Article,Integer> {
}
