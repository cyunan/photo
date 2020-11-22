package com.example.photo.mapper;

import com.example.photo.bean.art.Article;
import com.example.photo.bean.vlog.Vlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vlog_Repository extends JpaRepository<Vlog,Integer> {
}
