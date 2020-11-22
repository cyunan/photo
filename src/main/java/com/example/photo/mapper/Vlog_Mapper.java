package com.example.photo.mapper;

import com.example.photo.bean.init.Article_Rusult;
import com.example.photo.bean.init.Vlog_Rusult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Vlog_Mapper {
    List<Vlog_Rusult> getVloges();
    List<Vlog_Rusult> getVlogs_for_id_unique(@Param("id_unique") String id_unique);
}
