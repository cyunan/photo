package com.example.photo.initate;

import com.example.photo.File_init;
import com.example.photo.ResponseUtil;
import com.example.photo.bean.art.Art_Comment;
import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.art.Article;
import com.example.photo.bean.init.Article_Rusult;
import com.example.photo.bean.init.Vlog_Rusult;
import com.example.photo.bean.vlog.Vlog;
import com.example.photo.bean.vlog.Vlog_Comment;
import com.example.photo.bean.vlog.Vlog_Label;
import com.example.photo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//视频操作类
@Service
public class VlogDao {
    @Autowired
    private File_init fi;
    @Autowired
    private Vlog_Repository vr;
    @Autowired
    private VlogLabel_Repository label_repository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VlogComment_Repository comment_repository;
    @Autowired
    private Vlog_Mapper vlog_mapper;
    public Object add_vlog(HttpServletRequest request) {
        String id_unique = request.getParameter("id_unique");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String labels = request.getParameter("labels");
        MultipartFile multipartFile = ((MultipartHttpServletRequest)request).getFile("vlog_file");
        String image_url;
        if (multipartFile==null) {
            return ResponseUtil.fail(400,"缺少字段");
        }else {
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            //加个时间戳，尽量避免文件名称重复，保存的文件名为: ""+fileName
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;

            String path = fi.getUploadFolder_vlog()+fileName;// 设置存放图片文件的路径
            image_url = fi.getStaticAccessPath_vlog()+fileName;//访问映射url
            //创建文件路径
            File dest = new File(path);
            //判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            //上传文件
            try {
                multipartFile.transferTo(dest); //保存文件
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseUtil.fail(412,"上传文件失败");
            }
        }

        if (id_unique==null||title==null||content==null){
            return ResponseUtil.fail(400,"缺少字段");
        }else {
            Vlog vlog = vr.save(new Vlog(id_unique,title,content,image_url,new Date(),0));
            if (labels!=null){
                String arrs[] = labels.split(",");
                for (String label: arrs){
                    label_repository.save(new Vlog_Label(vlog.getId(),label));
                }
            }
            return ResponseUtil.ok("发布成功");
        }
    }

    public Object comment_for_vlog(String vlog_id, String id_unique, String comment) {
        Vlog vlog = userMapper.find_vlogid(vlog_id);
        if (vlog!=null){
            comment_repository.save(new Vlog_Comment(vlog_id,id_unique,comment));
            return ResponseUtil.ok("评论成功");
        }else {
            return ResponseUtil.fail(412,"该vlog不存在");
        }
    }


    public Object vlog_all() {
        List<Vlog_Rusult> vlog_rusults = vlog_mapper.getVloges();
        return ResponseUtil.ok("查询成功",vlog_rusults);
    }

    public Object vlog_user(String id_unique) {
        List<Vlog_Rusult> vlog_rusults = vlog_mapper.getVlogs_for_id_unique(id_unique);
        return ResponseUtil.ok("查询成功",vlog_rusults);
    }
}
