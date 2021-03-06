package com.example.photo.initate;

import com.example.photo.File_init;
import com.example.photo.ResponseUtil;
import com.example.photo.bean.art.Art_Comment;
import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.art.Article;
import com.example.photo.bean.init.Article_Rusult;
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

//文章操作类
@Service
public class ArticleDao {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArtLabel_Repository lr;
    @Autowired
    private Article_Repository ar;
    @Autowired
    private File_init fi;
    @Autowired
    private ArtComment_Repository ac_r;
    @Autowired
    private Art_Mapper art_r;
    @Autowired
    private Art_Mapper art_mapper;
    public Object add_art(HttpServletRequest request) {
        String id_unique = request.getParameter("id_unique");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String labels = request.getParameter("labels");
        MultipartFile multipartFile = ((MultipartHttpServletRequest)request).getFile("image_file");
        String image_url;
        if (multipartFile==null) {
            return ResponseUtil.fail(400,"缺少字段");
        }else {
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            //加个时间戳，尽量避免文件名称重复，保存的文件名为: ""+fileName
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;

            String path = fi.getUploadFolder_art()+fileName;// 设置存放图片文件的路径
            image_url = fi.getStaticAccessPath_art()+fileName;//访问映射url
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
            Article article = ar.save(new Article(id_unique,title,content,image_url,new Date(),90,0));
            if (labels!=null){
                String arrs[] = labels.split(",");
                for (String label: arrs){
                    lr.save(new Art_Label(article.getId(),label));
                }
            }
            return ResponseUtil.ok("发布成功");
        }
    }

    public Object comment_for_art(String art_id, String id_unique, String comment) {
        Article article = userMapper.find_artid(art_id);
        if (article!=null){
            ac_r.save(new Art_Comment(art_id,id_unique,comment));
            return ResponseUtil.ok("评论成功");
        }else {
            return ResponseUtil.fail(412,"该文章不存在");
        }
    }

    public Object article_user(String id_unique) {
        List<Article_Rusult> article_rusults = art_mapper.getArticles_for_id_unique(id_unique);
        return ResponseUtil.ok("查询成功",article_rusults);
    }

    public Object article_all() {
        List<Article_Rusult> article_rusults = art_mapper.getArticles();
        return ResponseUtil.ok("查询成功",article_rusults);
    }

    public Object article_label(String lab_id) {
        List<Article_Rusult> article_rusults = art_mapper.getArticles_for_label(lab_id);
        return ResponseUtil.ok("查询成功",article_rusults);
    }
}
