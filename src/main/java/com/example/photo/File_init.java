package com.example.photo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 路径映像
 */
@Component
@ConfigurationProperties(prefix = "file")
public class File_init {
    //apk安装包
    private String staticAccessPath_apk;
    private String uploadFolder_apk;
    //文章
    private String staticAccessPath_art;
    private String uploadFolder_art;
    //视频
    private String staticAccessPath_vlog;
    private String uploadFolder_vlog;

    public String getStaticAccessPath_apk() {
        return staticAccessPath_apk;
    }

    public void setStaticAccessPath_apk(String staticAccessPath_apk) {
        this.staticAccessPath_apk = staticAccessPath_apk;
    }

    public String getUploadFolder_apk() {
        return uploadFolder_apk;
    }

    public void setUploadFolder_apk(String uploadFolder_apk) {
        this.uploadFolder_apk = uploadFolder_apk;
    }

    public String getStaticAccessPath_art() {
        return staticAccessPath_art;
    }

    public void setStaticAccessPath_art(String staticAccessPath_art) {
        this.staticAccessPath_art = staticAccessPath_art;
    }

    public String getUploadFolder_art() {
        return uploadFolder_art;
    }

    public void setUploadFolder_art(String uploadFolder_art) {
        this.uploadFolder_art = uploadFolder_art;
    }

    public String getStaticAccessPath_vlog() {
        return staticAccessPath_vlog;
    }

    public void setStaticAccessPath_vlog(String staticAccessPath_vlog) {
        this.staticAccessPath_vlog = staticAccessPath_vlog;
    }

    public String getUploadFolder_vlog() {
        return uploadFolder_vlog;
    }

    public void setUploadFolder_vlog(String uploadFolder_vlog) {
        this.uploadFolder_vlog = uploadFolder_vlog;
    }
}
