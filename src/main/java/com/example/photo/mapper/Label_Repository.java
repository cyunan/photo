package com.example.photo.mapper;

import com.example.photo.bean.art.Art_Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Label_Repository extends JpaRepository<Art_Label,Integer> {
}
