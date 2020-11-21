package com.example.photo.mapper;

import com.example.photo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repository extends JpaRepository<User,Integer> {
}
