package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.vlog.Vlog_Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VlogLabel_Repository extends JpaRepository<Vlog_Label,Integer> {
}
