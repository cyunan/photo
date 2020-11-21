package com.example.photo.mapper;

import com.example.photo.bean.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfo_Repository extends JpaRepository<User_Info,Integer> {
}
