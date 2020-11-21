package com.example.photo.initate;

import com.alibaba.fastjson.JSON;
import com.example.photo.File_init;
import com.example.photo.ResponseUtil;
import com.example.photo.bean.init.Store_DataInfo;
import com.example.photo.bean.init.Store_DataInfoList;
import com.example.photo.bean.UpdateInfo;
import com.example.photo.mapper.Store_Mapper;
import com.example.photo.mapper.UpdateInfo_repository;
import com.example.photo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class UpdateApk {
    @Autowired
    private File_init fi;
    @Autowired
    private UpdateInfo_repository updateInfo_repository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Store_Mapper store_mapper;


    public Object update_apk(MultipartFile file, String version, String desc) {
        String fileName = file.getOriginalFilename();
        String path = fi.getUploadFolder_apk() + fileName;
        String url = fi.getStaticAccessPath_apk() + fileName;
        //创建文件路径
        File dest = new File(path);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        //上传文件
        try {
            file.transferTo(dest); //保存文件
            UpdateInfo updateInfo = userMapper.find_apkversion(version);
            if (updateInfo!=null){
                updateInfo.setApk_url(url);
                updateInfo.setDesc_apk(desc);
                updateInfo.setTime(new Date());
                updateInfo_repository.save(updateInfo);
                return ResponseUtil.ok("修改成功",updateInfo);
            }else {
                updateInfo = new UpdateInfo();
                updateInfo.setVersion(version);
                updateInfo.setApk_url(url);
                updateInfo.setDesc_apk(desc);
                updateInfo.setTime(new Date());
                updateInfo_repository.save(updateInfo);
                return ResponseUtil.ok("上传成功",updateInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail(420,"上传失败");
        }
    }

    //查询所有apk版本信息
    public Object apk_history() {
        List<UpdateInfo> updateInfos = userMapper.apk_history();
        if (updateInfos!=null&&updateInfos.size()>0){
            return ResponseUtil.fail(204,"查询成功",updateInfos);
        }else {
            return ResponseUtil.fail(421,"当前暂无数据");
        }
    }

    //查询最新apk版本信息
    public Object apk_newest() {
        UpdateInfo updateInfo = userMapper.apk_newest();
        if (updateInfo!=null){
            return ResponseUtil.ok("查询成功",updateInfo);

        }else {
            return ResponseUtil.fail(421,"当前暂无数据");
        }
    }

    public Object text() {//两对象
        Store_DataInfo store_dataInfo = new Store_DataInfo();
        store_dataInfo = store_mapper.finddata(1);

        String json = JSON.toJSONString(store_dataInfo);
        return store_dataInfo;
    }

    public Object text1() {
        Store_DataInfoList store_dataInfo = new Store_DataInfoList();
        store_dataInfo = store_mapper.finddatalist(1);

        String json = JSON.toJSONString(store_dataInfo);
        return store_dataInfo;
//        List<Store_bannerInfo> store_bannerInfos = new ArrayList<>();
//        store_bannerInfos = store_mapper.findStore_bannerInfos();
//        return store_bannerInfos;
    }
}
