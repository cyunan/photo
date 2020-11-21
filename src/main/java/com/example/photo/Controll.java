package com.example.photo;


import com.alibaba.fastjson.JSONObject;
import com.example.photo.bean.art.Art_Label;
import com.example.photo.bean.init.Home_Recommed;
import com.example.photo.initate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controll {
    @Autowired
    private JsonResourceUtils jr;
    @Autowired
    private Reg_Login rl;
    @Autowired
    private Info info;
    @Autowired
    private Home home;
    @Autowired
    private UpdateApk updateApk;
    //测试类
//    @PostMapping("/home_recommed")
//    public JSONObject home_recommed(HttpServletRequest request) {
//
//        return jr.getJsonObjFromConfiguration("home_recommed.json");
//    }
    @PostMapping("/home_message")
    public JSONObject home_message(HttpServletRequest request) {

        return jr.getJsonObjFromConfiguration("home_message.json");
    }
    @PostMapping("/Store_HOME_URL")
    public JSONObject Store_HOME_URL(HttpServletRequest request) {

        return jr.getJsonObjFromConfiguration("Store_HOME_URL.json");
    }
    @PostMapping("/home_recommed")
    public Object home_recommed(HttpServletRequest request){
        //todo 以后这个传id_unique，推送合适的数据给用户
        return home.home_recommed();
    }

    @PostMapping("/vlog")
    public JSONObject vlog(HttpServletRequest request)  {
        //HR_article
        //todo
        return jr.getJsonObjFromConfiguration("vlog_message.json");
    }

    @PostMapping("/add_art")
    public Object add_art(HttpServletRequest request){
        return home.add_art(request);
    }
    @PostMapping("/comment_for_art")
    public Object comment_for_art(@RequestParam("art_id") String art_id,@RequestParam("id_unique") String id_unique,@RequestParam("comment") String comment){
        return home.comment_for_art(art_id,id_unique,comment);
    }
    @GetMapping("test2")
    public Art_Label test2(){
        return home.text2();
    }

    /**
     *登陆注册表
     */
    //注册
    @PostMapping("/register")
    public Object register(@RequestParam("phone") String phone,@RequestParam("password") String password)  {

        return rl.register(phone,password);
    }
    //登录
    @PostMapping("/login")
    public Object login(@RequestParam("phone") String phone,@RequestParam("password") String password)  {

        return rl.login(phone,password);
    }
    //修改
    @PostMapping("/amend")
    public Object amend(@RequestParam("phone") String phone,@RequestParam("password") String password)  {

        return rl.amend(phone,password);
    }

    /**
     * 用户信息表
     */
    //主页的内容便签
    @PostMapping("/hrsign_change")
    public Object hrsign_change(@RequestParam("id_unique") String id_unique,@RequestParam("hr_sign") String hr_sign){
        return info.hrsign_change(id_unique,hr_sign);
    }
    /**
     * 版本更新表
     */
    /**
     *
     * @param file apk文件
     * @param version 版本号
     * @param desc 版本更新细节
     * @return
     */
    //上传最新apk版本
    @PostMapping("update_apk")
    public Object update_apk(@RequestParam("apk_file") MultipartFile file, @RequestParam("version") String version,
                             @RequestParam("desc") String desc){
        return updateApk.update_apk(file,version,desc);
    }
    //查询所有apk版本信息
    @GetMapping("apk_history")
    public Object apk_history(){
        return updateApk.apk_history();
    }
    //查询最新apk版本信息
    @GetMapping("apk_newest")
    public Object apk_newest(){
        return updateApk.apk_newest();
    }

    /**
     * 测试
     * @return
     */
    @GetMapping("test")
    public Object test(){
        return updateApk.text();
    }

    @GetMapping("test1")
    public Object test1(){
        return updateApk.text1();
    }



}
