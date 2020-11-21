package com.example.photo.bean.init;

import com.example.photo.bean.store.Store_bannerInfo;
import com.example.photo.bean.store.Store_channelInfo;

import java.util.List;

public class Store_DataInfo {
    private Store_bannerInfo store_bannerInfos;
    private Store_channelInfo store_channelInfos;

    public Store_bannerInfo getStore_bannerInfos() {
        return store_bannerInfos;
    }

    public void setStore_bannerInfos(Store_bannerInfo store_bannerInfos) {
        this.store_bannerInfos = store_bannerInfos;
    }

    public Store_channelInfo getStore_channelInfos() {
        return store_channelInfos;
    }

    public void setStore_channelInfos(Store_channelInfo store_channelInfos) {
        this.store_channelInfos = store_channelInfos;
    }
}
