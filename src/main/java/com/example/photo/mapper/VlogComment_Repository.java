package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Comment;
import com.example.photo.bean.vlog.Vlog_Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VlogComment_Repository extends JpaRepository<Vlog_Comment,Integer> {
}
