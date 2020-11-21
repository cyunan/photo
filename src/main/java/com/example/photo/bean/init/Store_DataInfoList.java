package com.example.photo.bean.init;

import com.example.photo.bean.store.Store_bannerInfo;
import com.example.photo.bean.store.Store_channelInfo;

import java.util.List;

public class Store_DataInfoList {
    private List<Store_bannerInfo> store_bannerInfos;
    private List<Store_channelInfo> store_channelInfos;

    public List<Store_bannerInfo> getStore_bannerInfos() {
        return store_bannerInfos;
    }

    public void setStore_bannerInfos(List<Store_bannerInfo> store_bannerInfos) {
        this.store_bannerInfos = store_bannerInfos;
    }

    public List<Store_channelInfo> getStore_channelInfos() {
        return store_channelInfos;
    }

    public void setStore_channelInfos(List<Store_channelInfo> store_channelInfos) {
        this.store_channelInfos = store_channelInfos;
    }
}
