package com.example.photo.mapper;

import com.example.photo.bean.art.Article;
import com.example.photo.bean.init.Store_DataInfo;
import com.example.photo.bean.init.Store_DataInfoList;
import com.example.photo.bean.store.Store_bannerInfo;
import com.example.photo.bean.store.Store_channelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Store_Mapper {
    Store_DataInfo finddata(@Param("id") int id);
    Store_DataInfoList finddatalist(@Param("id") int id);

    List<Store_bannerInfo> findStore_bannerInfos(@Param("image") int image);
    List<Store_channelInfo> findstore_channelInfos(@Param("image") int image);

    List<Article> getart();
}
